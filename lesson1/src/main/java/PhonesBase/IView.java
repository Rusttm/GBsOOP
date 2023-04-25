package PhonesBase;

import java.util.ArrayList;
import java.util.HashMap;

/**
*Интерфейс для работы с View */
public interface IView {
    /**
    * View должен получать: список фильтров, либо запрос на конкретную модель
    * выдавать список отфильтрованных телефонов, список фильтров
    * @getPhoneFilters() фильтры для отбора телефонов
    * @printPhonesFiltered() печатает список отфильтрованных телефонов
    * @printFilters() получает все возможные фильтры телефонов
     * @getPhoneData() получает данные конкретного телефона
     * @printPhoneData() печатает данные конкретного телефона
     *
    */

    public ArrayList printFilters();
    public HashMap getPhoneFilters();
    public ArrayList printPhonesFiltered();
    public HashMap getPhoneData();
    public HashMap printPhoneData();

}
