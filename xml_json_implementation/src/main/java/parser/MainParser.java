package parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Products;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.charset.StandardCharsets;


public class MainParser {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) throws IOException {
        String xmlFilePath = "src/main/resources/products.xml";
        Products products = xmlToProducts(xmlFilePath);
        if (products != null) {
            System.out.println(products);
        }

        if (products != null) {
            String jsonString = objToJson(products);
            System.out.println(jsonString);
            String newJsonFileName = "AnyJsonFile";
            int q = saveJsonInFile(jsonString, newJsonFileName);
            System.out.println("q = " + q);
        }
    }

    private static Integer saveJsonInFile(String jsonString, String nameJson) {
        int result = -1;
        if (jsonString == null) {
            return -1;
        }
        String newJsonFileName = "NewJsonFile.json";

        if (!nameJson.isEmpty()) {
            newJsonFileName = nameJson + ".json";
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(newJsonFileName), StandardCharsets.UTF_8))) {
            bufferedWriter.write(jsonString);
            bufferedWriter.flush();
            result = 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static String objToJson(Products products) {
        String json = GSON.toJson(products);
        System.out.println(json);
        return json;
    }

    private static Products xmlToProducts(String xmlFilePath) {
        Products products = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Products.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(new FileInputStream(xmlFilePath), StandardCharsets.UTF_8));
            products = (Products) unmarshaller.unmarshal(in);
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }

}
