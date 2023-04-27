package SOLID.Models;

import java.util.HashMap;

public class ProdAddInfo<T extends ProdCreate>{

    public ProdAddInfo() {
    }

    public void addInfo(T prod, String key, String value) {
//        System.out.println(prod);
        prod.put(key,value);
//        System.out.println(prod);
    }
}
