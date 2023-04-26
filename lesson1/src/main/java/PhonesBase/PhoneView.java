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



//        for (Object prod: data) {
//            HashMap<String,String> prodHash = (HashMap<String, String>) prod;
//            System.out.println(prodHash.get("label"));
//        }
    }

    public void printMainCommands() {
        System.out.println("Нажмите:");
        System.out.println("порядковый номер (1,2 ...) для просмотра описания");
        System.out.println("n -для создания нового элемента");
        System.out.println("d -для удаления элемента");
    }
}
