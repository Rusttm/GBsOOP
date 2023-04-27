package SOLID.Models;

import java.util.HashMap;

/** класс для получения из объекта значения ключа
 * чтобы работать с объектом созданным в классе ProdCreate
 * пришлось наследовать T от него
 * @param <T> наследован от ProdCreate
 */
public class ProdInfo <T extends ProdCreate> {

    public void ProdInfo() {
    }

    /**Метод в классе один
     * подается объект и ключ, возвращает значение
     * @param prod объект
     * @param key ключ
     * @return значение
     */
    public Object getInfo(T prod, String key) {
        return prod.getProd().get(key);
    }

}
