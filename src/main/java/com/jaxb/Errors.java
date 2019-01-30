package com.jaxb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.*;

public class Errors {

    private static Logger LOGGER = LoggerFactory.getLogger(Errors.class);

    private static Map<BigInteger, String> mapOfErrors = new HashMap<BigInteger, String>()
    {{
        put(BigInteger.valueOf(1100), "The XML does not comply with the schema. Need to report as mandatory field.");
        put(BigInteger.valueOf(1101), "Error when reporting characters whose encoding is not UTF-8.");
        put(BigInteger.valueOf(1102), "Technical error when recording in inbox");
        put(BigInteger.valueOf(1103), "Unexpected error when parsing the XML");
        put(BigInteger.valueOf(1104), "Error in the date format.");
        put(BigInteger.valueOf(1105), "Technical error when obtaining the CSV (Código Seguro de Verificación [Secure Verification Code]).");
        put(BigInteger.valueOf(1106), "The Tax ID is not identified");
        put(BigInteger.valueOf(1107), "The Tax ID has an incorrect format");
        put(BigInteger.valueOf(1108), "The RepresentativeTaxID has an incorrect format.");
        put(BigInteger.valueOf(1109), "The RepresentativeTaxID has an invalid format.");
        put(BigInteger.valueOf(1110), "Failed to get the certificate");
        put(BigInteger.valueOf(1111), "Technical error when checking powers of attorney");
        put(BigInteger.valueOf(1112), "Technical error when creating the procedure");
        put(BigInteger.valueOf(1113), "The certificate holder must be the Taxpayer, Company Representative or Proxy");
        put(BigInteger.valueOf(1114), "The XML does not comply with the schema. The maximum allowed limit of reported events to register has been exceeded");
        put(BigInteger.valueOf(1115), "Error The address does not correspond to the input file");

        put(BigInteger.valueOf(4100), "Error in the header. The content of the CommunicationType field is not valid");
        put(BigInteger.valueOf(4101), "Error in the header. The content of the Model field is not valid");
        put(BigInteger.valueOf(4102), "Error in the header. The content of the Fiscal Year field is not valid");
        put(BigInteger.valueOf(4103), "Error in the header. The content of the Period field is not valid");
        put(BigInteger.valueOf(4104), "Error in the header. The content of the IDVersionModel field is not valid");
        put(BigInteger.valueOf(4105), "Error in the header. The Tax ID of the taxpayer is invalid");
        put(BigInteger.valueOf(4106), "Error in the header. The RepresentativeTaxID of the taxpayer is invalid");
        put(BigInteger.valueOf(4107), "Error in the header. The Tax ID of the taxpayer has an incorrect format");
        put(BigInteger.valueOf(4108), "Error in the header. The RepresentativeTaxID of the taxpayer has an incorrect format");
        put(BigInteger.valueOf(4109), "Error in the header. The Tax ID of the taxpayer cannot belong to a minor");
        put(BigInteger.valueOf(4110), "Error in the header. The RepresentativeTaxID of the taxpayer cannot belong to a minor");


        put(BigInteger.valueOf(2100), "Incorrect value or type of the field");
        put(BigInteger.valueOf(2101), "The Return field contains characters that are not UTH-8");
        put(BigInteger.valueOf(2102), "The value of the ID field must be the Tax ID of a natural person when the value of the IDType field is ‘07’");
        put(BigInteger.valueOf(2103), "User not authorised to perform this action");
        put(BigInteger.valueOf(2104), "Incorrect value of the CountryCode field");
        put(BigInteger.valueOf(2105), "Incorrect valued of the IDType field");
        put(BigInteger.valueOf(2106), "Incorrect valued of the ID field");
        put(BigInteger.valueOf(2107), "The Tax ID is not identified");
        put(BigInteger.valueOf(2108), "The Tax ID is not identified");
        put(BigInteger.valueOf(2109), "Incorrect value of the Fiscal Year field. It must be this year or earlier");
        put(BigInteger.valueOf(2110), "Country code is mandatory when Identification Type is different to TaxID-VAT");
        put(BigInteger.valueOf(2111), "Error in the Return block. Incorrect value of the Name field");
        put(BigInteger.valueOf(2112), "The ID field is not identified");
        put(BigInteger.valueOf(2113), "The indicated CountryCode field does not match the first two digits of the identifier");
        put(BigInteger.valueOf(2114), "The value of the Country Code can only be ‘ES’ when the IDType is ‘07’");
        put(BigInteger.valueOf(2115), "The ID field does not contain a correctly formatted Tax ID");
        put(BigInteger.valueOf(2116), "The Tax ID has an incorrect format");
        put(BigInteger.valueOf(2117), "The Tax ID of the Representative has an incorrect format");

        put(BigInteger.valueOf(3100), "DB technical error");
        put(BigInteger.valueOf(3101), "Duplicate reported event.");
        put(BigInteger.valueOf(3102), "The reported event to modify does not exist in our DB");
        put(BigInteger.valueOf(3103), "DB technical error. Error in the Integrity of the Information");
        put(BigInteger.valueOf(3104), "The reported event has already been cancelled");

        put(BigInteger.valueOf(5101), "Incorrect value of the Key field");
        put(BigInteger.valueOf(5102), "In the case of a minor, the Tax ID of the representative must have a value");
        put(BigInteger.valueOf(5103), "In the case of a minor, the Tax ID of the representative can’t match the Tax ID of the Taxpayer reported in the Reported Event");
        put(BigInteger.valueOf(5104), "Incorrect value of the Property Location field");
        put(BigInteger.valueOf(5105), "Incorrect value of the Province Code field");
        put(BigInteger.valueOf(5106), "Incorrect value of the Road Type field");
        put(BigInteger.valueOf(5107), "Incorrect value of the Numbering Type field");
        put(BigInteger.valueOf(5108), "Incorrect value of the Payment Method field");
    }};

    public static String findMessageByCode(BigInteger code) {
        String message = ", message: " + mapOfErrors.get(code);

        if (mapOfErrors.get(code) == null) {
            message = ". Unknown error code [" + code + "]";
        }

        return message;
    }

}
