package com.rhcloud.quest.brainteaser.services;

import com.rhcloud.quest.brainteaser.dao.QuestDao;
import com.rhcloud.quest.brainteaser.dao.dto.QuestDto;
import com.rhcloud.quest.brainteaser.dao.dto.TooltipDto;
import com.rhcloud.quest.brainteaser.dao.dto.TooltipRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Queue;

@Service
public class QuestServiceImpl implements QuestService{

    private static final Logger LOG = LoggerFactory.getLogger(QuestServiceImpl.class);

    @Autowired
    QuestDao questDao;

    private QuestDto getQuest(Integer questNumber) {
        return questDao.getQuest(questNumber);
    }

    public String getQuestName(Integer questNumber) {
        return getQuest(questNumber).getName();
    }

    public String getQuestMessage(Integer questNumber) {
        return getQuest(questNumber).getMessage();
    }

    public TooltipRequestDto getAvailableTooltipMessage(Integer questNumber) {
        QuestDto questDto = getQuest(questNumber);
        Date startTime = questDto.getStartTime();
        Date currentTime = new Date();

        TooltipRequestDto tooltipRequestDto = new TooltipRequestDto();
        Queue<TooltipDto> tooltips = questDto.getTooltips();
        try {
            TooltipDto tooltipDto = tooltips.element();

            if (currentTime.getTime() - startTime.getTime() >= tooltipDto.getMillisecondsToWait()) {
                LOG.info("Tooltip is available");

                tooltipRequestDto.setMessage(tooltipDto.getMessage());
                tooltipRequestDto.setInfoMessage("Доступна нова підказка");
            } else {
                long waitingMilliseconds = (tooltipDto.getMillisecondsToWait() - (currentTime.getTime() - startTime.getTime()));
                long integerMinutesToWait = waitingMilliseconds / 60000;
                long secondsToWait = waitingMilliseconds / 1000 - integerMinutesToWait * 60;
                LOG.info("User have to wait {} minutes {} seconds", integerMinutesToWait, secondsToWait);

                tooltipRequestDto.setMessage("");
                tooltipRequestDto.setInfoMessage("Підказка буде доступна через " + integerMinutesToWait + " хвилин " + secondsToWait + " секунд");
            }
        } catch (NoSuchElementException ex) {
            LOG.warn("All tooltips was used");
            tooltipRequestDto.setMessage("Підкази закінчились");
            tooltipRequestDto.setInfoMessage("Підкази закінчились");
        }
        return tooltipRequestDto;
    }

    public void nextTooltip(Integer questNumber) {
        QuestDto questDto = getQuest(questNumber);
        Queue<TooltipDto> tooltips = questDto.getTooltips();
        tooltips.poll();
    }

    public Date getStartTime(Integer questNumber) {
        return getQuest(questNumber).getStartTime();
    }

    public void setStartTime(Integer questNumber, boolean isTooltipRequest) {
        QuestDto questDto = getQuest(questNumber);
        if (isTooltipRequest || questDto.getStartTime() == null) questDto.setStartTime(new Date());
    }

    public boolean isMessageSent(Integer questNumber) {
        return getQuest(questNumber).isMessageSent();
    }

    public void setMessageSent(Integer questNumber) {
        QuestDto questDto = getQuest(questNumber);
        questDto.setIsMessageSent(true);
    }
}
