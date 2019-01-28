package com.jaxb.POJOs;

import com.jaxb.interfaces.Message;

public abstract class MessageDecorator implements Message {

    protected Message message;

    public MessageDecorator(Message message) {
        this.message = message;
    }

    @Override
    public void getMessage() {
        this.message.getMessage();
    }
}
