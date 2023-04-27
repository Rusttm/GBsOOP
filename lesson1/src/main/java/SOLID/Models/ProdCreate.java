package SOLID.Models;

import java.util.HashMap;

public class ProdCreate extends Prod {
    private static int id;
    HashMap prod;
    public ProdCreate(String name, String model, String year, String brand, String memory, String descr, String price) {
        id++;
        this.prod= new HashMap();
        this.prod.put("id", id);
        this.prod.put("name", name);
        this.prod.put("model", model);
        this.prod.put("year", year);
        this.prod.put("brand", brand);
        this.prod.put("memory", memory);
        this.prod.put("descr", descr);
        this.prod.put("price", price);
        this.prod.put("label", name + " " + model + " " + memory);
//        System.out.println(this.prod);
    }

    public HashMap getProd() {
        return this.prod;
    }

    public Object get(String key) {
        return super.get(key);
    }
    public void put(String key, String value) {
//        System.out.println(this.prod);
        this.prod.put(key, value);
    }

}
