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

    public void stockTestFullFillment() {
        Product newProduct1 = new Product("Зарядное устройство", 100.00,200.00, 0.2);
        Product newProduct2 = new Product("Зарядное устройство", 90.00,200.00, 0.2);
        Product newProduct3 = new Product("Сумка Thule 15", 300.00,500.00, 0.2);
        Product newProduct4 = new Product("Сумка Thule 15", 320.00,500.00, 0.2);
        Product newProduct5 = new Product("Iphone 12", 1000.00,1300.00, 0.2);
        Product newProduct6 = new Product("Macbook Air", 2500.00,3000.00, 0.2);
        Product newProduct7 = new Product("Samsung S22", 1100.00,1400.00, 0.2);
        Product newProduct8 = new Product("Сумка Thule 15", 280.00,500.00, 0.2);
        this.put2Stock(newProduct1);
        this.put2Stock(newProduct2);
        this.put2Stock(newProduct3);
        this.put2Stock(newProduct4);
        this.put2Stock(newProduct5);
        this.put2Stock(newProduct6);
        this.put2Stock(newProduct7);
        this.put2Stock(newProduct8);

    }

    public static void main(String[] args) {

        Stock stock = new Stock("Москва1");
        stock.stockTestFullFillment();

        System.out.println(stock.getStock("Москва1")); // печатаем Склад
        System.out.println(stock.getProdStockInfo("Зарядное устройство")); // общие данные по продукту
        System.out.println(stock.getFromStock("Зарядное устройство", 2)); // Списываем товар(объекты) со склада
        System.out.println(stock.getStock("Москва1"));// печатаем Склад
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

    /*
    * Кладет на склад товар (объект)
    * */
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

    /*
    * Отгружает товар со склада
    * Выдает по имени массив(склад) объектов по этой позиции
    * */
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
                    System.out.println("недостаточно товара "+ productName + " на на складе");
                    return null;
                }
            }

        }
        else {
            System.out.println("Товара " + productName + " нет на на складе");
            return null;
        }

        return result;
    }

    /*
    * Выдает данные по названию позиции
    * на выходе HashMap с указанием информации
    * */
    @Override
    public HashMap getProdStockInfo(String productName) {
        InterfaceProdProfit<Double, Product> profit = (ob) -> (ob.getPrice()-ob.getCost());
        HashMap prodGroupInfo = new HashMap<>();
        if (this.stockData.containsKey(productName)) {
            Double costSum = 0.0;
            Double profitSum = 0.0;
            ArrayList<Product> prodArray = new ArrayList<>();
            prodArray = (ArrayList<Product>) this.stockData.get(productName);
            prodGroupInfo.put("name", productName); // название
            prodGroupInfo.put("num", prodArray.size()); // количество позиций на складе
            for (Product prod:
                 prodArray) {
                costSum += prod.getCost();
                profitSum += profit.get(prod);
            }
            prodGroupInfo.put("sumCost", costSum); // суммарная себестоимость
            prodGroupInfo.put("avgCost", costSum / prodArray.size()); // средняя себестоимость
            prodGroupInfo.put("sumProfit", profitSum); // суммарная прибыль
        }
        else {
            System.out.println("Товара нет на на складе");
            return null;
        }
        return prodGroupInfo;
    }

}
