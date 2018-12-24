package model;

public class LaptopModel {

    private String name;
    private String price;

    public LaptopModel(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}
