package com.jaxb;

import com.jaxb.exceptions.ParseException;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class Errors {

    private static Map<Integer, String> mapOfErrors = new HashMap<Integer, String>()
    {{
        put(1100, "The XML does not comply with the schema. Need to report as mandatory field.");
        put(1101, "Error when reporting characters whose encoding is not UTF-8.");
        put(1102, "Technical error when recording in inbox");
        put(1103, "Unexpected error when parsing the XML");
        put(1104, "Error in the date format.");
        put(1105, "Technical error when obtaining the CSV (Código Seguro de Verificación [Secure Verification Code]).");
        put(1106, "The Tax ID is not identified");
        put(1107, "The Tax ID has an incorrect format");
        put(1108, "The RepresentativeTaxID has an incorrect format.");
        put(1109, "The RepresentativeTaxID has an invalid format.");
        put(1110, "Failed to get the certificate");
        put(1111, "Technical error when checking powers of attorney");
        put(1112, "Technical error when creating the procedure");
        put(1113, "The certificate holder must be the Taxpayer, Company Representative or Proxy");
        put(1114, "The XML does not comply with the schema. The maximum allowed limit of reported events to register has been exceeded");
        put(1115, "Error The address does not correspond to the input file");

        put(4100, "Error in the header. The content of the CommunicationType field is not valid");
        put(4101, "Error in the header. The content of the Model field is not valid");
        put(4102, "Error in the header. The content of the Fiscal Year field is not valid");
        put(4103, "Error in the header. The content of the Period field is not valid");
        put(4104, "Error in the header. The content of the IDVersionModel field is not valid");
        put(4105, "Error in the header. The Tax ID of the taxpayer is invalid");
        put(4106, "Error in the header. The RepresentativeTaxID of the taxpayer is invalid");
        put(4107, "Error in the header. The Tax ID of the taxpayer has an incorrect format");
        put(4108, "Error in the header. The RepresentativeTaxID of the taxpayer has an incorrect format");
        put(4109, "Error in the header. The Tax ID of the taxpayer cannot belong to a minor");
        put(4110, "Error in the header. The RepresentativeTaxID of the taxpayer cannot belong to a minor");


        put(2100, "Incorrect value or type of the field");
        put(2101, "The Return field contains characters that are not UTH-8");
        put(2102, "The value of the ID field must be the Tax ID of a natural person when the value of the IDType field is ‘07’");
        put(2103, "User not authorised to perform this action");
        put(2104, "Incorrect value of the CountryCode field");
        put(2105, "Incorrect valued of the IDType field");
        put(2106, "Incorrect valued of the ID field");
        put(2107, "The Tax ID is not identified");
        put(2108, "The Tax ID is not identified");
        put(2109, "Incorrect value of the Fiscal Year field. It must be this year or earlier");
        put(2110, "Country code is mandatory when Identification Type is different to TaxID-VAT");
        put(2111, "Error in the Return block. Incorrect value of the Name field");
        put(2112, "The ID field is not identified");
        put(2113, "The indicated CountryCode field does not match the first two digits of the identifier");
        put(2114, "The value of the Country Code can only be ‘ES’ when the IDType is ‘07’");
        put(2115, "The ID field does not contain a correctly formatted Tax ID");
        put(2116, "The Tax ID has an incorrect format");
        put(2117, "The Tax ID of the Representative has an incorrect format");

        put(3100, "DB technical error");
        put(3101, "Duplicate reported event.");
        put(3102, "The reported event to modify does not exist in our DB");
        put(3103, "DB technical error. Error in the Integrity of the Information");
        put(3104, "The reported event has already been cancelled");

        put(5101, "Incorrect value of the Key field");
        put(5102, "In the case of a minor, the Tax ID of the representative must have a value");
        put(5103, "In the case of a minor, the Tax ID of the representative can’t match the Tax ID of the Taxpayer reported in the Reported Event");
        put(5104, "Incorrect value of the Property Location field");
        put(5105, "Incorrect value of the Province Code field");
        put(5106, "Incorrect value of the Road Type field");
        put(5107, "Incorrect value of the Numbering Type field");
        put(5108, "Incorrect value of the Payment Method field");
    }};

    public static String findMessageByCode(int code) throws ParseException {
        String message = mapOfErrors.get(code);

        if (message == null)
            throw new ParseException("Incorrect code");

        return message;
    }

}
