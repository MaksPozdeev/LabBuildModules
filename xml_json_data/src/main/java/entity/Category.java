package entity;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlType(name = "category")
@XmlAccessorType(XmlAccessType.FIELD)
public class Category {

    @XmlAttribute
    private String nameCategory;

    @XmlElement(name = "subcategory")
    private List<Subcategory> subcategoryList;

    //    Block of methods
    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<Subcategory> getSubcategoryList() {
        return subcategoryList;
    }

    public void setSubcategoryList(List<Subcategory> subcategoryList) {
        this.subcategoryList = subcategoryList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "nameCategory='" + nameCategory + '\'' +
                ", subcategoryList=" + subcategoryList +
                '}' +
                "\n";
    }
}
