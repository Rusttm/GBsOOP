package seminar3;

import java.util.ArrayList;
import java.util.HashMap;

/*Склад возвращает HashMap {складНазвание:, складИнформация:, данные: {названиеТовара:, Товар:{}}} склада
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
        return null;
    }

    @Override
    public boolean put2Stock(Product product) {
        System.out.println(product.getName());

        return false;
    }


}
