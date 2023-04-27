package SOLID.Controllers;

import SOLID.Models.ProdAddInfo;
import SOLID.Models.ProdCreate;
import SOLID.Models.ProdInfo;

import java.util.HashMap;

public class Controler0 implements IController0{
    public static void main(String[] args) {

        HashMap<String,String> newLine = new HashMap<String,String>();
        ProdCreate newPhone1 = new ProdCreate("iPhone", "SE", "2015", "Apple", "64", "refurbished", "50000");
        ProdCreate newPhone2 = new ProdCreate("iPhone", "12 Pro Max","2020", "Apple", "256", "", "125000");
        ProdCreate newPhone3 = new ProdCreate("Redmi", "MI9","2018", "Xiaomi", "128", "", "11000");
        System.out.println(newPhone1.getProd());
        ProdInfo newInformer = new ProdInfo<ProdCreate>();
        ProdAddInfo newAdder = new ProdAddInfo();
//        System.out.println("Берем из объекта ключ label:");
//        System.out.println(newInformer.getInfo(newPhone1, "label"));
        newAdder.addInfo(newPhone1, "screen", "6.5");
        System.out.println(newPhone1.getProd());
//        newLine.put("name","NoName");
//        ProdAddInfo newAdd = new ProdAddInfo();
//        newAdd.setProdInfo((HashMap) newPhone.getProd(), newLine);

//        ProdCreate newPhone2 = new ProdCreate<HashMap>();
//        System.out.println(newPhone2.getId());
    }
}
