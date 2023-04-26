package PhonesBase;

import java.util.ArrayList;
import java.util.HashMap;

/** Интерфейс работы с Базой данных
 **/

/**Коннектор базы данных по телефонам(любым продуктам)
 * должен получать данные из файла или БД и выдавать из по запросу
 * @ getFilteredDB() выдает данные по фильтрам
 * @ getProductByID() выдает продукт по ID
 * @ getAllDb() выдает всю базу
 * @ putProd2DB() положить продукт в БД
 * @ delProdFromDB() удалить продукт из БД
 * @ updProd2DB() изменить продукт в БД
 * */
public interface IDBconnector <T> {


    /** Метод выдает продукты которые подходят по фильтрам
     * @param filterMap получает на входе HashMap {фильтр:значение}
     * @return возвращает ArrayList с продуктами, либо пустой
     */
    ArrayList getFilteredDB(HashMap<String, String> filterMap);

    /** Метод для выдачи продукта по id
     * @param id искомого продукта
     * @return возвращает сам продукт если он существует в базе, и null -если нет
     */
    HashMap getProductFromDBByID(String id);


    /** Метод выдает всю базу из памяти
     * @return в виде ArrayList
     */
    ArrayList getAllDb();

    /** Метод выдает всю базу из Файла
     * @return в виде ArrayList
     */
    ArrayList getAllFromFile();


    /** Метод для добавления продукта
     * @param prod новые данные в виде HashMap
     * @return возвращает true если добавил, и false -если нет
     */
    boolean putProd2DB(T prod);


    /** удаляет позицию по id
     * @param id указать id удаляемой позиции
     * @return true если успешно
     */
    boolean delProdFromDB(String id);


    /** Метод для обновления продукта
     * @param updProd новые данные в виде HashMap
     * @return возвращает true если обновил, и false -если не обновил
     */
    boolean updProd2DB(T updProd);
}
