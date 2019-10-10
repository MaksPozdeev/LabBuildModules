package validator;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;

public class XmlValidator {
    public static void main(String[] args) throws SAXException, IOException {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String fileName = "resources/products.xml";
        String schemaName = "resources/products.xsd";

        SchemaFactory factory = SchemaFactory.newInstance(language);
//        File schemaLocation = new File("resources/products.xsd");
//        Schema schema = factory.newSchema(schemaLocation);
        Schema schema = factory.newSchema();

        Validator validator = schema.newValidator();
        String xmlFilePath = "resources/products.xml";
        Source source = new StreamSource(xmlFilePath);

        try {
            validator.validate(source);
            System.out.println(xmlFilePath + " is valid.");
        } catch (SAXException ex) {
            System.out.println(xmlFilePath + " is not valid because ");
            System.out.println(ex.getMessage());
        }

    }
}
