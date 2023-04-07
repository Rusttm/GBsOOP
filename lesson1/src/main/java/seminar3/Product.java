package seminar3;

import java.util.HashMap;

public class Product {
    private int id = 0; // уникальный код
    String name; // название
    Double cost; // себестоимость
    Double price; // прайсовая цена
    Double vat = 0.2; // ставка НДС
    PriceList priceList = new PriceList(); // прайс


    public Product(String name, Double cost, Double price, Double VAT) {
        this.id++;
        this.name = name;
        this.cost = cost;
        this.price = price;
        priceList.setProdPrice(name, price);
        this.vat = VAT;
    }
    public Product(String name, Double cost) {
        this.id++;
        this.name = name;
        this.cost = cost;
        this.price = priceList.getProdPrice(name);;
        this.vat = 0.2;

    }

    public Product() {
        this("Noname product", 0.0);
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

    public Double getProfit() {
        InterfaceProdProfit<Double, Product> prodProfit = (ob) -> (this.getPrice()-this.getCost());
        return cost;
    }

    public Double getPrice() {
        return priceList.getProdPrice(this.getName());

//        return price;
    }

    public Double getVat() {
        return vat;
    }


}
