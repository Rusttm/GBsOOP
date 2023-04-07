package seminar3;

import java.util.ArrayList;
import java.util.HashMap;

/*Склад возвращает HashMap {name:складНазвание, info:складИнформация, data: {названиеТовара:, [obj Товар1,obj Товар2]}} склада
* */
public class Stock implements InterfaceStock {
    // код склада
    private int id;

    // информация по складу любые ключ-значение
    private HashMap stock = new HashMap<>();
    /*
    *непосредственно склад c перечислением товара
    * в виде HashMap {"name":название, "data": ArrayList}
            **/
    private HashMap stockData;

    public static void main(String[] args) {
        Product newProduct1 = new Product("Зарядное устройство", 100.00,200.00, 0.2);
        Product newProduct2 = new Product("Зарядное устройство", 100.00,200.00, 0.2);
        Stock stock = new Stock("Москва1");
        stock.put2Stock(newProduct1);
        stock.put2Stock(newProduct2);
        System.out.println(stock.getFromStock(newProduct1.getName(), 2));
    }

/*
* Инициализация создает HashMap
* */
    public Stock(String stockName, HashMap stockInfo) {
        this.id++;
        this.stockData = new HashMap<>();
        this.stock.put("name", stockName);
        this.stock.put("info", stockInfo);
        this.stock.put("data", this.stockData);
    }

    public Stock(String stockName) {
        this(stockName, new HashMap<String,String>());
    }

    @Override
    public HashMap getStock(Object stockName) {
        return this.stock;
    }

    @Override
    public boolean put2Stock(Product product) {

        String productName = product.getName();
        ArrayList productArray = new ArrayList<>();
        // если массив уже есть
        if (this.stockData.containsKey(productName)) {
            productArray = (ArrayList) this.stockData.get(productName);
        }
        // проверяет есть ли такой объект в списке?
        if (productArray.contains(product)) {
            System.out.println(product.getName() + "Такой товар(объект) уже есть на складе");
        }
        else  {
            productArray.add(product);
            this.stockData.put(productName, productArray);
            return true;
        }

        return false;
    }

    @Override
    public ArrayList<Product> getFromStock(String productName, int num) {
        ArrayList<Product> result = new ArrayList<>();
        if (this.stockData.containsKey(productName)) {
            ArrayList tempList = (ArrayList) this.stockData.get(productName);
            for (int i = 0; i < num; i++) {
                int numProducts = tempList.size();
                if (numProducts>0) {
                    result.add((Product) tempList.get(0));
                    tempList.remove(0);
                }
                else {
                    System.out.println("недостаточно товара на на складе");
                    return null;
                }
            }

        }
        else {
            System.out.println("Товара нет на на складе");
            return null;
        }

        return result;
    }

    @Override
    public HashMap getProdStockInfo(Object productName) {

        return null;
    }

}
