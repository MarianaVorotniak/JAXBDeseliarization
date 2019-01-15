import com.jaxb.POJOs.RespuestaDeclaracion;
import com.jaxb.services.ParseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is a program to parse XML elements from a SOAP response using JAXB.
 *
 * @author Mariana Vorotniak
 */
public class Main {

    private static String filePath = "src\\main\\resources\\response.xml";

    private static Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {

        ParseService  service = new ParseService();
        RespuestaDeclaracion response = service.parseResponse(filePath);

        LOGGER.info("The status is [{}]", response.getSendStatus());
    }

}
