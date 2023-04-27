package SOLID.Views;

/**Интерфейс показа Продукта
 * @param <T> объект продукта
 */
public interface IViewProd<T> {
    /**Метод для вывода продукта на экран или страницу
     * @param prod любой продукт(Объект)
     */
    void showProd(T prod);
}
