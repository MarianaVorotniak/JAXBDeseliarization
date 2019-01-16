package com.jaxb;

import com.jaxb.POJOs.RespuestaDeclaracion;
import com.jaxb.exceptions.IncorrectFileException;
import com.jaxb.services.ParseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

/**
 * This is a program to parse XML elements from a SOAP response using JAXB.
 *
 * @author Mariana Vorotniak
 */
public class Main {

    private static String filePath = "src\\main\\resources\\response.xml";

    private static Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IncorrectFileException, IOException {

        ParseService  service = new ParseService();
        String fileContent = readFile(filePath);
        RespuestaDeclaracion response = service.parseResponse(fileContent);


        LOGGER.info("The status is [{}]", response.getSendStatus());
    }

    public static String readFile(String path) throws IncorrectFileException {
        byte[] encoded = null;
        try {
           encoded = Files.readAllBytes(Paths.get(path));
        } catch (NoSuchFileException e) {
            throw new IncorrectFileException("File does not exist");
        } catch (IOException e) {
            throw new IncorrectFileException("IOException");
        }

        return new String(encoded);
    }

}
