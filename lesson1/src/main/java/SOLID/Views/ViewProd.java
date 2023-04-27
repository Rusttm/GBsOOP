package SOLID.Views;

import SOLID.Models.ProdCreate;

import java.util.HashMap;

/**Класс из интерфейса IViewProd
 * так как он реализуется для телефонов,
 * то T -дочерний класс от ProdCreate
 * @param <T> ProdCreate
 */
public class ViewProd<T extends ProdCreate> implements IViewProd<T> {

    public ViewProd() {
    }

    /**Метод имплементируется интерфейсом
     * так как Т дочерний класс от HashMap
     * используем это для вывода на экран
     * @param prod любой продукт(Объект)
     */
    @Override
    public void showProd(T prod) {
        HashMap temp = prod.getProd();
        System.out.printf("Телефон %s :", temp.get("label"));
        System.out.println();
        for (Object key: temp.keySet()) {
            if (key.toString().equals("label")) {
                continue;
            }
            System.out.printf("%s - %s", key.toString(), temp.get(key));
            System.out.println();
        }
        System.out.println();

    }
}
