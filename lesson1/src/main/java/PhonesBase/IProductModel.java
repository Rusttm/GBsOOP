package PhonesBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/** Интерфейс для создания моделей продукта
 * */

/** модель должна получать
 * @ getProdName() название
 * @ getProdId()id продукта
 * @ getProd() непосредственно получет данные по продукту
 * */
public interface IProductModel<T> {
    public int id = 0;

    /** Метод возвращает объект продукта
     * @return
     */
    HashMap<String, T> getProd();

    /**Метод возвращает название телефона
     * (из чего составить название указывается в отдельном списке)
     * @return строку с названием: Iphone 14 64 (Apple)
     */
    String getProdLabel();


    /**Выдает список необходимых полей (ключи) для заполнения
     * @return ArrayList
     */
    HashSet<String> getProdNesFields();
    String getProdId();
    String getProdDescr();
    /** Метод возвращает HashMap с указанием характеристик продукта
     * @return
     */
    HashMap<String,String> getProdCharTable();

}
