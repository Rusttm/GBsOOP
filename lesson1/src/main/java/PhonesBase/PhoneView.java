package PhonesBase;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneView implements IView {

    @Override
    public void printAllPhones(ArrayList data) {
        System.out.println("В базе находятся следующие модели:");
        for (int i = 0; i < data.size(); i++) {
            System.out.print((i + 1) + ". ");
            HashMap<String, String> prodHash = (HashMap<String, String>) data.get(i);
            System.out.println(prodHash.get("label"));
        }
    }

    public void printMainCommands() {
        System.out.println("Нажмите:");
        System.out.println("порядковый номер (1,2 ...) для просмотра описания");
        System.out.println("n -для создания нового элемента");
        System.out.println("d -для удаления элемента");
    }
    public void printDelCommands() {
        System.out.println("Нажмите:");
        System.out.println("порядковый номер (1,2 ...) для удаления");
        System.out.println("s -для возврата в меню");
    }
    public void makePhone(String key) {
        System.out.printf("Введите значение поля %s:", key);
        System.out.println();
        System.out.println("Или нажмите:");
        System.out.println("s -для возврата в меню");
    }
}
