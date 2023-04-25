package PhonesBase;

import java.util.HashMap;

/** Интерфейс для создания моделей продукта
 * */
public interface IProductModel<T> {
    public int id = 0;
    /** модель должна получать
     * @getProdName() название
     * @getProdId()id продукта
     * @getProd() непосредственно получет данные по продукту
     * */
    public HashMap<String, T> getProd();
    public String getProdName();
    public String getProdId();

}
