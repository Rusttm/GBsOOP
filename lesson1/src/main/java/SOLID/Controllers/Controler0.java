package SOLID.Controllers;

import SOLID.Models.ProdAddInfo;
import SOLID.Models.ProdCreate;

import java.util.HashMap;

public class Controler0 implements IController0{
    public static void main(String[] args) {
        ProdCreate newPhone = new ProdCreate<HashMap>();
        HashMap<String,String> newLine = new HashMap<String,String>();
        newLine.put("name","NoName");
        ProdAddInfo newAdd = new ProdAddInfo();
        newAdd.setProdInfo((HashMap) newPhone.getProd(), newLine);
        System.out.println(newPhone.getId());
        ProdCreate newPhone2 = new ProdCreate<HashMap>();
        System.out.println(newPhone2.getId());
    }
}
