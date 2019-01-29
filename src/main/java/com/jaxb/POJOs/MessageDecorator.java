package com.jaxb.POJOs;

import com.jaxb.interfaces.Message;

public class MessageDecorator implements Message {

    protected Message message;

    public MessageDecorator(Message message) {
        this.message = message;
    }

    @Override
    public void printMessage() {
        this.message.printMessage();
    }
}
