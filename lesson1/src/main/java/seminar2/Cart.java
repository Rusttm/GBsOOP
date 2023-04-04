package seminar2;

import java.util.*;
import java.util.HashMap;

/*
Корзина в которую складываются товары
* */
public class Cart {
    private int id;
    public HashMap<String,HashMap> cartHash;

    public Cart() {
        this.cartHash = new HashMap<>();
        this.id++;
    }

    public void addProd(Product prodObj, int n) {
        String prodName = prodObj.getName();
        if (cartHash.containsKey(prodName)) {
            HashMap temp = cartHash.get(prodName);
            int numPos = (int) temp.get("count");
            numPos += n;
            temp.put("count", numPos);
//            System.out.println("Такая позиция есть");


        }
        else {
            HashMap prodHashMap = new HashMap<>();
            prodHashMap.put("count", n);
            prodHashMap.put("prod", prodObj);
            cartHash.put(prodName, prodHashMap);
//            System.out.println("Нет такой позиции");
        }

    }
    public void addProd(Product prodObj) {
        addProd(prodObj, 1);
    }

        public void viewCart() {
            for (String posName: cartHash.keySet()) {
                System.out.println(posName);
                System.out.println(cartHash.get(posName).get("count"));

            }

        }
    public int getId() {
        return id;
    }
}
