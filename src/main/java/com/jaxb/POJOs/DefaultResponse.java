package com.jaxb.POJOs;

import com.jaxb.interfaces.LoggerMessage;

public class DefaultResponse implements LoggerMessage {
    @Override
    public String getMessage() {
        return "Response is null";
    }
}
