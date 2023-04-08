package seminar4;

import java.util.ArrayList;
import java.util.HashMap;

/*
Корзина в которую складываются товары
возвращает в виде {}
cartHash имеет структуру {"name":{"count":количество в корзине, "price":цена по прайсу, "sumVat":сумма налога, "sumPrice":сумма по прайсу}
* */
public class Cart {
    private int id;
    private double cartSum = 0.0;
    private double cartVatSum = 0.0;
    private double cartProdNum = 0.0;
    public HashMap<String,HashMap> cartHash;

    public Cart() {
        this.cartHash = new HashMap<>();
        this.id++;
    }

    /*
    * */
    public void addProd(Product prodObj, int n) {
        /*Добавляет в словарь корзины новую позицию если ее нет
        * Либо добавляет указанное количество к имеющемуся уже в корзине
        * */
        String prodName = prodObj.getName();

        HashMap posInfo = new HashMap<>();
        if (cartHash.containsKey(prodName)) {
            posInfo = cartHash.get(prodName);
            n += (int) posInfo.get("count");
        }

        double sumPrice = n * prodObj.getPrice();
        double sumVat = sumPrice *  prodObj.getVat() / (1+prodObj.getVat());
        this.cartProdNum += n;
        this.cartSum += sumPrice;
        this.cartVatSum += sumVat;
        posInfo.put("count", n);
        posInfo.put("price", prodObj.getPrice());
        posInfo.put("sumVat", sumVat);
        posInfo.put("sumPrice", sumPrice);
        this.cartHash.put(prodName, posInfo);



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

    /*возвращает список строк для распечатки
    * строка вида [наименование\\ количество \\ цена \\ сумма налога \\ сумма по прайсу]*/
    public ArrayList<ArrayList> getCartInvoiceView () {
        ArrayList<ArrayList> result = new ArrayList<>();
        HashMap prodInfo = new HashMap<>();
        for (String posName: cartHash.keySet()) {
            ArrayList lineArray = new ArrayList<>();
            prodInfo = (HashMap) cartHash.get(posName);
            lineArray.add(posName);
            lineArray.add(prodInfo.get("count"));
            lineArray.add(prodInfo.get("price"));
            lineArray.add(prodInfo.get("sumVat"));
            lineArray.add(prodInfo.get("sumPrice"));
            result.add(lineArray);
        }
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
        return this.cartHash.size();
    }
}
