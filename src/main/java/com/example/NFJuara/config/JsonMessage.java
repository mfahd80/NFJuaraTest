package com.example.NFJuara.config;

import java.io.Serializable;

import lombok.Data;

@Data
public class JsonMessage implements Serializable{

	private static final long serialVersionUID = 4325259813629524630L;
	
    public static final String MSG_TITLE_Success = "Success";
    public static final String MSG_TITLE_ERROR = "Error";
    
    private String messageTitle;
    private String messageBody;
    private Object object;
    
    public JsonMessage() {}
    
    public JsonMessage(String messageTitle, String messageBody) {
        this.messageTitle = messageTitle;
        this.messageBody = messageBody;
    }
    
    public JsonMessage(String messageTitle, String messageBody, Object object) {
        this.messageTitle = messageTitle;
        this.object = object;
        this.messageBody = messageBody;
    }
    
    public static JsonMessage showSuccessMessage(String messageBody) {
        return new JsonMessage(MSG_TITLE_Success, messageBody);
    }
    
    public static JsonMessage showErrorMessage(String messageBody) {
        return new JsonMessage(MSG_TITLE_ERROR, messageBody);
    }

}
