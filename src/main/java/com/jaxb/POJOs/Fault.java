package com.jaxb.POJOs;

import com.jaxb.interfaces.Message;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.annotation.*;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class Fault extends MessageDecorator {

    private static Logger LOGGER = LoggerFactory.getLogger(Fault.class);

    @XmlElement
    private String faultcode;

    @XmlElement
    private String faultstring;

    @XmlElement
    private Detail detail;

    public Fault(Message message) {
        super(message);
    }

    @Override
    public void getMessage() {
        super.getMessage();
        LOGGER.info(getFaultMessage());
    }

    private String getFaultMessage() {
        return "Cause of the Fault response - [" + getFaultstring() + "]";
    }

}