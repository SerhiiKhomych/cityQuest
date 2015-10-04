package com.rhcloud.quest.brainteaser.services;

public interface SmsService {
    void sendSms(String phoneNumber, String message);
}
