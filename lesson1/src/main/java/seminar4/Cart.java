package seminar4;

import java.util.ArrayList;
import java.util.HashMap;

/*
Корзина в которую складываются товары
* */
public class Cart {
    private int id;
    private int numPos;
    private double cartSum = 0.0;
    private double cartVatSum = 0.0;
    private double cartProdNum = 0.0;
    public HashMap<String,HashMap> cartHash;

    public Cart() {
        this.cartHash = new HashMap<>();
        this.id++;
    }

    public void addProd(Product prodObj, int n) {
        /*Добавляет в словарь корзины новую позицию если ее нет
        * Либо добавляет указанное количество к имеющемуся уже в корзине
        *
        * */
        String prodName = prodObj.getName();
        this.cartProdNum += n;
        this.cartSum += n * prodObj.getPrice();
//        System.out.println();
        this.cartVatSum += n * prodObj.getPrice() *  prodObj.getVat() / (1+prodObj.getVat());
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
            System.out.print(posName + " ");
            System.out.print(cartHash.get(posName).get("count")+"шт.");
            System.out.println();
        }

    }
    public ArrayList<ArrayList> getCartInvoiceView () {
        ArrayList<ArrayList> result = new ArrayList<>();
        for (String posName: cartHash.keySet()) {
            ArrayList lineArray = new ArrayList<>();
            Product ob = (Product) cartHash.get(posName).get("prod");
            int numOfProd = (int) cartHash.get(posName).get("count");
//            System.out.println(ob.getPrice());
            double costProdSum = ob.getPrice() * numOfProd;
            lineArray.add(ob.getName());
            lineArray.add(numOfProd);
            lineArray.add(ob.getPrice());
            lineArray.add(costProdSum);
            result.add(lineArray);
        }

//        System.out.println(result);


        return result;
    }

    public int getId() {
        return id;
    }

    public double getCartSum() {
        return cartSum;
    }

    public double getCartProdNum() {
        return cartProdNum;
    }

    public double getCartVatSum() {
        return cartVatSum;
    }

    public HashMap<String, HashMap> getCartHash() {
        /*Возможность получить словарь корзины{"name", objProd}
        *
        * */
        return cartHash;
    }

    public int getNumPos() {
        this.numPos = this.cartHash.size();
        return numPos;
    }
}
