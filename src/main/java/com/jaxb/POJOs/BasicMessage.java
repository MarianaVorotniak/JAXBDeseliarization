package com.jaxb.POJOs;

import com.jaxb.interfaces.Message;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
public class BasicMessage implements Message {

    private static Logger LOGGER = LoggerFactory.getLogger(BasicMessage.class);

    @Override
    public void printMessage() {
        LOGGER.info("SOAP Response: ");
    }

}
