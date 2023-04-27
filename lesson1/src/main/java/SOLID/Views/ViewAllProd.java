package SOLID.Views;

import SOLID.Models.ProdCreate;
import seminar3.PriceList;

import java.util.ArrayList;

/**Класс для просмотра Списка объектов телефонов
 * в этом случае ProdCreate дочерний класс от HashMap
 * @param <T> ProdCreate
 */
public class ViewAllProd<T extends ProdCreate> implements ViewAllProducts<T> {
    public ViewAllProd() {
    }

    /**метод из интерфейса
     * в данной реализации T наследован от HashMap
     * поэтому мы можем использовать уже реализованный
     * класс ViewProd
     * @param prodList список объектов Т
     */
    @Override
    public void showAllProd(ArrayList<T> prodList) {
        ViewProd newProdViewer = new ViewProd<>();
        for (T prod: prodList) {
            newProdViewer.showProd(prod);
        }
    }
}
