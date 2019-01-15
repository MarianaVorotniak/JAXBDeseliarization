@XmlSchema (
        namespace="http://schemas.xmlsoap.org/soap/envelope/",
        elementFormDefault=XmlNsForm.QUALIFIED,
        xmlns = {
                @XmlNs(prefix = "env", namespaceURI="http://schemas.xmlsoap.org/soap/envelope/"),
                @XmlNs(prefix="ddiiR", namespaceURI="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/RespuestaDeclaracion.xsd"),
                @XmlNs(prefix="ddii", namespaceURI="https://www2.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/es/aeat/ddii/enol/ws/DeclaracionInformativa.xsd")
        }
)
package com.jaxb.POJOs;

import javax.xml.bind.annotation.*;