package com.rhcloud.quest.brainteaser.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

@Service
public class SmsSenderServiceImpl implements SmsService{
    private final static String SMSC_LOGIN = "serhii4";
    private final static String SMSC_PASSWORD = "1qaz2wsx3edc4";
    private final static String SMSC_CHARSET = "utf-8";

    private static final Logger LOG = LoggerFactory.getLogger(SmsSenderServiceImpl.class);


    public void sendSms(String phoneNumber, String message) {
        try {
            String[] messageInfo = createSmsSendingCommand("send",
                    "cost=3&phones=" + URLEncoder.encode(phoneNumber, SMSC_CHARSET) +
                    "&mes=" + URLEncoder.encode(message, SMSC_CHARSET) +
                     "&translit=0");
            if (Integer.parseInt(messageInfo[1]) > 0) {
                LOG.info("Sms was sent. ID: {}, SMS count: {}, cost: {} , balance: {}",
                        messageInfo[0], messageInfo[1], messageInfo[2], messageInfo[3]);
            } else {
                LOG.error("Error №{}", Math.abs(Integer.parseInt(messageInfo[1])));
                if (Integer.parseInt(messageInfo[0])>0) LOG.error(", ID: {}", messageInfo[0]);
            }
        } catch (UnsupportedEncodingException e) {
            LOG.error("Failed to send sms", e);
        }
    }

    private String[] createSmsSendingCommand(String cmd, String arg){
        String comma = ",";
        try {
            String requestUrl = "http://smsc.ru/sys/" + cmd +".php?login=" + URLEncoder.encode(SMSC_LOGIN, SMSC_CHARSET)
                    + "&psw=" + URLEncoder.encode(SMSC_PASSWORD, SMSC_CHARSET)
                    + "&fmt=1&charset=" + SMSC_CHARSET + "&" + arg;

            int i = 0;
            do {
                if (i > 0) Thread.sleep(2000 + 1000 * i);

                if (i == 2) requestUrl = requestUrl.replace("://smsc.ru/", "://www2.smsc.ru/");

                comma = readServerRequest(requestUrl);
            }
            while (comma == "" && ++i < 4);
        } catch (UnsupportedEncodingException e) {
            LOG.error("Failed to create sms command", e);
        } catch (InterruptedException e) {
            LOG.error("Failed to create sms command", e);
        }

        return comma.split(",");
    }

    private String readServerRequest(String url) {
        String requestString = "";
        String realUrl = url;
        String[] requestParam = {};
        boolean isPost = url.length() > 2000;

        if (isPost) {
            requestParam = url.split("\\?",2);
            realUrl = requestParam[0];
        }

        try {
            URL connectionUrl = new URL(realUrl);
            InputStream inputStream;

            if (isPost){
                URLConnection connection = connectionUrl.openConnection();
                connection.setDoOutput(true);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream(), SMSC_CHARSET);
                outputStreamWriter.write(requestParam[1]);
                outputStreamWriter.flush();
                outputStreamWriter.close();
                inputStream = connection.getInputStream();
            } else {
                inputStream = connectionUrl.openStream();
            }

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, SMSC_CHARSET);
            int textSymbol;

            while ((textSymbol = inputStreamReader.read()) != -1) {
                requestString += (char)textSymbol;
            }
            inputStreamReader.close();
        } catch (MalformedURLException e) {
            LOG.error("Failed to read server request", e);
        } catch (IOException e) {
            LOG.error("Failed to read server request", e);
        }

        return requestString;
    }
}