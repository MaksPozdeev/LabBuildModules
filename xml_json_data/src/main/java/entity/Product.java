package entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {
    @XmlElement(name = "manufacturer")
    private String manufacturer;
    @XmlElement(name = "model")
    private String model;
    @XmlElement(name = "dateOfManufacture")
    private String dateOfManufacture;
    @XmlElement(name = "color")
    private String color;
    @XmlElement(name = "price")
    private Float price;
    @XmlElement(name = "amount")
    private int amount;

    //    Block of methods
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(String dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    @Override
    public String toString() {
        return "Product{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", dateOfManufacture='" + dateOfManufacture + '\'' +
                ", color='" + color + '\'' +
                ", Price=" + price +
                ", Amount=" + amount +
                '}' +
                "\n";
    }
}
