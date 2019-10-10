package entity;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlType(name = "subcategory")
@XmlAccessorType(XmlAccessType.FIELD)
public class Subcategory {

    @XmlAttribute
    private String nameSubcategory;

    @XmlElement(name = "product")
    private List<Product> productList;

    //    Block of methods
    public String getNameSubcategory() {
        return nameSubcategory;
    }

    public void setNameSubcategory(String nameSubcategory) {
        this.nameSubcategory = nameSubcategory;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "main.java.entity.Subcategory{\n" +
                "name='" + nameSubcategory + '\'' +
                ",\n productList=" + productList +
                '}' +
                "\n";
    }
}
