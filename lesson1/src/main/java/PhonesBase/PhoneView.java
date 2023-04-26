package PhonesBase;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneView implements IView{

    @Override
    public void printAllPhones(ArrayList data) {
        System.out.println("В базе находятся следующие модели:");
        for (Object prod: data) {
            HashMap<String,String> prodHash = (HashMap<String, String>) prod;
            System.out.println(prodHash.get("label"));
        }
    }
}
