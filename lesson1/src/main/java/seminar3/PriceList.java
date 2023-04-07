package seminar3;

import java.util.HashMap;

public class PriceList {
    private int id = 0;
    private String date;
    private HashMap<String, Double> price;

    public void priceTestFullFillment() {
        this.price.put("Зарядное устройство", 200.00);
        this.price.put("Сумка Thule 15", 500.00);
        this.price.put("Iphone 12", 1300.000);
        this.price.put("Macbook Air", 3000.00);
        this.price.put("Samsung S22", 1400.00);
    }

    public PriceList() {
        this.id++;
        this.price = new HashMap<>();
        this.priceTestFullFillment();

    }

    public boolean setProdPrice(String prodName, double value) {
        this.price.put(prodName, value);
        return true;
    }

    public Double getProdPrice(String prodName) {
        if (this.price.containsKey(prodName)) {
            return this.price.get(prodName);
        }
        else  {
            System.out.println("Цена на позицию" + prodName + "не установлена");
            return null;
        }

    }

}
