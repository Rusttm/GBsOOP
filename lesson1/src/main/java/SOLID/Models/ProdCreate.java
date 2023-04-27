package SOLID.Models;

import java.util.HashMap;

/**
 * Класс для создания продукта
 */
public class ProdCreate extends PhoneProd {
    int id = 1;
    private static int counter;
    HashMap prod;

    /**
     * @param name Имя
     * @param model Модель
     * @param year Год
     * @param brand Производитель
     * @param memory Память
     * @param descr Описание
     * @param price Цена
     */
    public ProdCreate(String name, String model, String year, String brand, String memory, String descr, String price) {
        this.id = counter;
        counter++;
        this.prod= new HashMap();
        this.prod.put("id", id);
        this.prod.put("name", name);
        this.prod.put("model", model);
        this.prod.put("year", year);
        this.prod.put("brand", brand);
        this.prod.put("memory", memory);
        this.prod.put("descr", descr);
        this.prod.put("price", price);
        this.prod.put("label", name + " " + model + " " + memory);
//        System.out.println(this.prod);
    }

    /**
     * Метод выдает HashMap продукта(объекта)
     * @return HashMap
     */
    public HashMap getProd() {
        return this.prod;
    }

    /** Так как наследование идет от HashMap
     * то можно воспользоваться методом из Материнского класса
     * метод get
     * @param key ключ
     * @return значение
     */
    public Object get(String key) {
        return super.get(key);
    }

    /**То же самое -взял из материнского класса
     * добавляет в объект ключ-значение
     * @param key ключ
     * @param value значение
     */
    public void put(String key, String value) {
        this.prod.put(key, value);
    }

}
