package com.rhcloud.quest.brainteaser.dao.dto;

import java.util.Date;
import java.util.Queue;

public class QuestDto {
    private String name;
    private String message;
    private boolean isMessageSent;
    private Date startTime;
    private Queue<TooltipDto> tooltips;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isMessageSent() {
        return isMessageSent;
    }

    public void setIsMessageSent(boolean isMessageSent) {
        this.isMessageSent = isMessageSent;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Queue<TooltipDto> getTooltips() {
        return tooltips;
    }

    public void setTooltips(Queue<TooltipDto> tooltips) {
        this.tooltips = tooltips;
    }
}
