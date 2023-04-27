package SOLID.Views;

import java.util.ArrayList;

/**Интерфейс для показа списка из объектов
 * @param <T> любых объектов, не только HashMap
 */
public interface ViewAllProducts<T> {

    /**Метод вывода списка объектов
     * @param prodList список объектов Т
     */
    void showAllProd(ArrayList<T> prodList);
}
