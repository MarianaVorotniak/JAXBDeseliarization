import com.jaxb.unmarshall.Body;
import com.jaxb.unmarshall.Envelope;
import com.jaxb.unmarshall.RespuestaDeclaracion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * This is a program to parse XML elements from a SOAP response using JAXB.
 *
 * @author Mariana Vorotniak
 */
public class Main {

    private static String filePath = "src\\main\\resources\\response.xsd";

    private static Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {

        File responseFile = new File(filePath);

        JAXBContext context = JAXBContext.newInstance(Envelope.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        Envelope response = (Envelope) unmarshaller.unmarshal(responseFile);

        Body responseBody = response.getResponseBody();
        RespuestaDeclaracion declarationResponse = responseBody.getDeclarationResponse();
        String status = declarationResponse.getSentStatus();

        LOGGER.info("The status is [{}]", status);

    }

}
