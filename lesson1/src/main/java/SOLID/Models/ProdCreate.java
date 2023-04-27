package SOLID.Models;

import java.util.HashMap;

public class ProdCreate<T> extends Prod{
    private static int id;
    T prod;
    public ProdCreate() {
        id++;

    }

    public static int getId() {
        return id;
    }

}
