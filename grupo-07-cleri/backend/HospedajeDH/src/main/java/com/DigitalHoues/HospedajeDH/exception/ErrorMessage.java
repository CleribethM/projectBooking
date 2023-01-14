package com.DigitalHoues.HospedajeDH.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class ErrorMessage {
    private int statusCode;
    private String exception;
    private String message;
    //private String description;
    private String path;

    public ErrorMessage(Exception exception, String path) {
        this.exception = exception.getClass().getSimpleName();
        this.message = exception.getMessage();
        this.path = path;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "statusCode=" + "statusCode" +
                ", exception='" + exception + '\'' +
                ", message='" + message + '\'' +
                ", description='" + "description" + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
