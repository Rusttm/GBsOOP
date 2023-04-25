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
     * @ putProd2DB() положить продукт в БД
     * @ delProdFromDB() удалить продукт из БД
     * @ updProd2DB() изменить продукт в БД
     * */
    ArrayList getFilteredDB();

    HashMap getProductByID(String id);

    ArrayList getAllDb();

    boolean putProd2DB(HashMap<String, String> prod);

    boolean delProdFromDB(String id);

    boolean updProd2DB();

}
