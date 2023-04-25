package PhonesBase;

import java.util.ArrayList;
import java.util.HashMap;

/** Интерфейс работы с Базой данных
 **/


public interface IDBconnector {
    /**Коннектор базы данных по телефонам(любым продуктам)
     * должен получать данные из файла или БД и выдавать из по запросу
     * @ getFilteredDB() выдает данные по фильтрам
     * @ getProductByID() выдает продукт по ID
     * @ getAllDb() выдает всю базу
     * */
    ArrayList getFilteredDB();
    HashMap getProductByID();
    ArrayList getAllDb();
}
