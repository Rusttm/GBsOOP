package seminar2;

import java.util.HashMap;

public class Product {
    private int id = 0;
    String name;
    Double cost;
    Double price;

    Double vat = 0.2;

    public Product(String name, Double cost, Double price, Double VAT) {
        this.id++;
        this.name = name;
        this.cost = cost;
        this.price = price;
        this.vat = VAT;
    }
    public Product() {

        this.id++;
        this.name = "Noname product";
        this.cost = 0.00D;
        this.price = 0.00D;
        this.vat = 0.2;
    }

    public HashMap getProdInfo() {
        HashMap result = new HashMap<>();
        result.put("id", id);
        result.put("name", name);
        result.put("cost", cost);
        result.put("price", price);
        return result;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Double getCost() {
        return cost;
    }

    public Double getPrice() {
        return price;
    }

    public Double getVat() {
        return vat;
    }
}
