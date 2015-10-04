package com.rhcloud.quest.brainteaser.dao.dto;

public class TooltipRequestDto {
    String infoMessage;
    private String message;

    public String getInfoMessage() {
        return infoMessage;
    }

    public void setInfoMessage(String infoMessage) {
        this.infoMessage = infoMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
