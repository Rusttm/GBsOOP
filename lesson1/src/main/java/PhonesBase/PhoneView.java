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
        System.out.println("Введите:");
        System.out.println("i -для просмотра описания элементов");
        System.out.println("n -для создания нового элемента");
        System.out.println("d -для удаления элемента");

    }
    public void printDelCommands() {
        System.out.println("Введите:");
        System.out.println("порядковый номер (1,2 ...) для удаления");
        System.out.println("s -для возврата в меню");
    }
    public void makePhone(String key) {
        System.out.printf("Введите значение поля %s:", key);
        System.out.println();
        System.out.println("Или Введите:");
        System.out.println("s -для возврата в меню");
    }
    public void printDescrCommands() {
        System.out.println("Введите:");
        System.out.println("порядковый номер (1,2 ...) для просмотра описания");
        System.out.println("s -для возврата в меню");
    }
    public void descrPhone() {
        System.out.println("Введите:");
        System.out.println("s -для возврата в меню");
        System.out.println("i -для просмотра описания элементов");
    }
}
