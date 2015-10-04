package com.rhcloud.quest.brainteaser.dao.dto;

public class TooltipDto {
    private String message;
    private int millisecondsToWait;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getMillisecondsToWait() {
        return millisecondsToWait;
    }

    public void setMillisecondsToWait(int millisecondsToWait) {
        this.millisecondsToWait = millisecondsToWait;
    }
}
