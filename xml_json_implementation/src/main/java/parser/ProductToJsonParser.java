package parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Product;

public class ProductToJsonParser {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static String run(Product product) {
        //        System.out.println(json);
        return GSON.toJson(product);

    }
}
