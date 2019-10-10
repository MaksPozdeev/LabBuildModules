package parser;

import build.AppMain;
import entity.Category;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JaxbParser {

//    В следующей версии:
//    - избавиться от хардкора
//    - Добавить дженерики
    private static final String PATH_TO_PROPERTIES = "xml.properties";
    private static final String XML_PROPERTY_NAME = "xmlPath";
    private static final String XML_ROOT_ELEMENT = "category";

    public static List<Category> run() throws XMLStreamException, JAXBException {

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        InputStream inputStream = Category.class.getClassLoader().getResourceAsStream(getProperty(PATH_TO_PROPERTIES, XML_PROPERTY_NAME));
        XMLStreamReader xmlReader = xmlInputFactory.createXMLStreamReader(inputStream);
        xmlReader.nextTag();

        List<Category> categoryList = new ArrayList<>();

        while (xmlReader.hasNext()) {
            xmlReader.next();
            if (xmlReader.getEventType() == XMLStreamConstants.START_ELEMENT && xmlReader.getLocalName().equals(XML_ROOT_ELEMENT)) {
                Unmarshaller unmarshaller = JAXBContext.newInstance(Category.class).createUnmarshaller();
                JAXBElement<Category> boolElement = unmarshaller.unmarshal(xmlReader, Category.class);
                Category category = boolElement.getValue();
                categoryList.add(category);
            }
        }
        xmlReader.close();
        return categoryList;
    }

    private static String getProperty(String pathToPropertyFile, String propertyName) {
        try (InputStream input = AppMain.class.getClassLoader().getResourceAsStream(pathToPropertyFile)) {
            Properties properties = new Properties();
            properties.load(input);
            System.out.println(properties.getProperty(propertyName));
            return properties.getProperty(propertyName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
