package seminar3;

import java.util.HashMap;

/*
* Интерфейс для создания склада
* который
* должен иметь метод запроса
* */
public interface InterfaceStock<T>{
    public HashMap getStock(T stockName);
    public boolean put2Stock(Product product);
}
