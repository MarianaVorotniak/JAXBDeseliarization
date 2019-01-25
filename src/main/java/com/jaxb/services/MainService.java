package com.jaxb.services;

import com.jaxb.exceptions.ParseException;
import com.jaxb.interfaces.Responses;
import org.slf4j.*;
import java.io.IOException;
import java.nio.file.*;

public class MainService {

    private static Logger LOGGER = LoggerFactory.getLogger(MainService.class);
    private static ParseService service = new ParseService();

    public void printResponse(Responses objectResponse) {

        LOGGER.info(objectResponse.getMessage());
    }

    public Responses getResponse(String filePath) throws ParseException {

        String fileContent = readFile(filePath);
        if (fileContent.contains("RespuestaDeclaracion"))
            return service.parseResponse(fileContent);
        else if (fileContent.contains("Fault"))
            return service.parseFaultResponse(fileContent);

        throw new ParseException("Error in file path " + filePath);
    }

    public static String readFile(String path) throws ParseException {

        if (path.isEmpty())
            throw new ParseException("File path is empty");
        if (path == null)
            throw new ParseException("File path is null");

        byte[] encoded;
        try {
            encoded = Files.readAllBytes(Paths.get(path));
        } catch (NoSuchFileException e) {
            throw new ParseException("File does not exist :" +  path);
        } catch (IOException e) {
            throw new ParseException("IOException: " + e.getMessage());
        }

        return new String(encoded);
    }
}
