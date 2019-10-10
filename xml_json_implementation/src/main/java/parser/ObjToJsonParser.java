package parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Category;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ObjToJsonParser {
    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Category.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        XMLInputFactory xmlFactory = XMLInputFactory.newInstance();

        File xmlFilePath = new File("src/main/resources/products.xml");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(new FileInputStream(xmlFilePath), StandardCharsets.UTF_8));
        XMLStreamReader reader = xmlFactory.createXMLStreamReader(in);

        List<Category> categoryList = new ArrayList<>();
        while (reader.hasNext() && (!reader.isStartElement() || !reader.getLocalName().equals("category"))) {
            reader.next();
        }

        while (reader.getEventType() == XMLStreamConstants.START_ELEMENT) {
            JAXBElement<Category> boolElement = unmarshaller.unmarshal(reader, Category.class);
            Category category = boolElement.getValue();
            categoryList.add(category);

            if (reader.getEventType() == XMLStreamConstants.CHARACTERS) {
                reader.next();
            }
        }
        reader.close();

        categoryList.forEach(System.out::println);

        ObjectMapper mapper = new ObjectMapper();

        try {
            // Java objects to JSON file
            mapper.writeValue(new File("category.json"), categoryList);
            // Java objects to JSON string - compact-print
            String jsonString = mapper.writeValueAsString(categoryList);
            System.out.println(jsonString);
            // Java objects to JSON string - pretty-print
            String jsonInString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(categoryList);
            System.out.println(jsonInString2);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
