package com.rhcloud.quest.brainteaser.services;

import com.rhcloud.quest.brainteaser.dao.dto.TooltipRequestDto;

import java.util.Date;

/**
 * Created by Sergey on 14.08.2015.
 */
public interface QuestService {
    String getQuestName(Integer questNumber);

    String getQuestMessage(Integer questNumber);

    TooltipRequestDto getAvailableTooltipMessage(Integer questNumber);

    void nextTooltip(Integer questNumber);

    Date getStartTime(Integer questNumber);

    void setStartTime(Integer questNumber, boolean isTooltipRequest);

    boolean isMessageSent(Integer questNumber);

    void setMessageSent(Integer questNumber);
}
