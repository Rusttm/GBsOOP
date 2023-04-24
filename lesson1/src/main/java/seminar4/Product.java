package seminar4;

import java.util.HashMap;

public class Product <T extends String> {
    private int id = 0; // уникальный код
    T name; // название
    double cost; // себестоимость
    double price; // прайсовая цена
    double vat; // ставка НДС
    PriceList priceList = new PriceList(); // прайс


    public Product(T name, double cost, double price, double VAT) {
        this.id++;
        this.name = name;
        this.cost = cost;
        this.price = price;
        priceList.setProdPrice(name, price);
        this.vat = VAT;
    }
    public Product(T name, double cost) {
        this.id++;
        this.name = name;
        this.cost = cost;
        this.price = priceList.getProdPrice(name);;
        this.vat = 0.2;

    }

    public Product() {
        this((T) "Noname product", 0.0);
    }

    public HashMap getProdInfo() {
        HashMap result = new HashMap<>();
        result.put("id", id);
        result.put("name", name);
        result.put("cost", cost);
        result.put("price", price);
        return result;
    }

    public T getName() {

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
//Возвращает значение НДС
    public Double getVat() {
        return vat;
    }


}
