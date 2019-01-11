package com.jaxb.unmarshall;

import javax.xml.bind.annotation.*;

@XmlType(name = "Envelope")
@XmlRootElement(name="Envelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class Envelope {

    @XmlElement(name = "Header", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    private Header header;

    @XmlElement(name="Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    private Body responseBody;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Body getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(Body responseBody) {
        this.responseBody = responseBody;
    }

    public Envelope() {
    }
}
