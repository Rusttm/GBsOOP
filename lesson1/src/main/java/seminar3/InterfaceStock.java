package seminar3;

import java.util.ArrayList;
import java.util.HashMap;

/*
* Интерфейс для создания склада
* который
* должен иметь метод запроса
* */
public interface InterfaceStock<T, V>{
    // выдает данные по складу
    public HashMap getStock(T stockName);
    /*
    кладет товар (объект) на склад
    */
    public boolean put2Stock(Product product);

    // берет со склада количество товара в ввиде списка объектов
    public ArrayList<Product> getFromStock(String productName, int number);

    // дает информацию по товару
    public HashMap getProdStockInfo(V productName);
}
