import com.jaxb.POJOs.RespuestaDeclaracion;
import com.jaxb.services.ParseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBElement;

/**
 * This is a program to parse XML elements from a SOAP response using JAXB.
 *
 * @author Mariana Vorotniak
 */
public class Main {

    private static String filePath = "src\\main\\resources\\response.xsd";

    private static Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {

        ParseService parsedXml = new ParseService(filePath);

        JAXBElement<RespuestaDeclaracion> jaxbElement = parsedXml.getResponse();
        RespuestaDeclaracion response = jaxbElement.getValue();
        String status = response.getSentStatus();

        LOGGER.info("The status is [{}]", status);
    }

}
