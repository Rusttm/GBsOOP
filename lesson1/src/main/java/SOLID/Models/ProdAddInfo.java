package SOLID.Models;

import java.util.HashMap;

public class ProdAddInfo<T extends HashMap>{

    public void setProdInfo(T prod, T prodInfo) {
        prod.putAll(prodInfo);
        System.out.println(prod);
    }
}
