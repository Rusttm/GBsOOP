package SOLID.Models;

import java.util.HashMap;

public class ProdInfo <T extends ProdCreate> {

    public void ProdInfo() {
    }
    public Object getInfo(T prod, String key) {
//        HashMap temp =  prod;
//        System.out.println(prod.getProd());
        return prod.getProd().get(key);
    }

}
