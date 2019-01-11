import com.jaxb.unmarshall.Envelope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class Main {

    private static String filePath = "src\\main\\resources\\response.xsd";

    private static Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {

        File responseFile = new File(filePath);

        JAXBContext context = JAXBContext.newInstance(Envelope.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        Envelope response = (Envelope) unmarshaller.unmarshal(responseFile);

        LOGGER.info("The status is [{}]", response.getResponseBody().getDeclarationResponse().getSentStatus());

    }

}
