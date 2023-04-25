package PhonesBase;

import java.util.HashMap;

/** Интерфейс для создания моделей продукта
 * */
public interface IProductModel<T> {
    public int id = 0;
    /** модель должна получать
     * @ getProdName() название
     * @ getProdId()id продукта
     * @ getProd() непосредственно получет данные по продукту
     * */
    HashMap<String, T> getProd();
    String getProdName();
    String getProdId();

}
