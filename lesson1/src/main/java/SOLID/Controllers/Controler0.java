package SOLID.Controllers;

import SOLID.Connectors.ConnectorArraySave;
import SOLID.Connectors.ProdSave2DB;
import SOLID.Models.ProdAddInfo;
import SOLID.Models.ProdCreate;
import SOLID.Models.ProdInfo;
import SOLID.Views.ViewAllProd;
import SOLID.Views.ViewProd;

import java.util.ArrayList;
import java.util.HashMap;

public class Controler0 implements IController0{
    public static void main(String[] args) {

        HashMap<String,String> newLine = new HashMap<String,String>();
        ProdCreate newPhone1 = new ProdCreate("iPhone", "SE", "2015", "Apple", "64", "refurbished", "50000");
        ProdCreate newPhone2 = new ProdCreate("iPhone", "12 Pro Max","2020", "Apple", "256", "", "125000");
        ProdCreate newPhone3 = new ProdCreate("Redmi", "MI9","2018", "Xiaomi", "128", "", "11000");

        // Здесь мы можем получить из объекта информацию по ключу
        ProdInfo newInformer = new ProdInfo<ProdCreate>();
        System.out.println("Берем из объекта ключ label:");
        System.out.println(newInformer.getInfo(newPhone1, "label"));
        System.out.println();

        // можем добавить в объект ключ-значение
        ProdAddInfo newAdder = new ProdAddInfo();
        newAdder.addInfo(newPhone1, "screen", "6.5");
        newAdder.addInfo(newPhone2, "НовыйКлюч", "НовоеЗначение");

        // можем выдать во Viewer информацию
        ViewProd newViewer = new ViewProd();
        newViewer.showProd(newPhone1);


        // можем набросать объекты в массив ...
        ArrayList<ProdCreate> newProdArray = new ArrayList<>();
        newProdArray.add(newPhone1);
        newProdArray.add(newPhone2);
        newProdArray.add(newPhone3);

        // ... и отправить в Viewer для массива объектов
        ViewAllProd newFullViewer = new ViewAllProd<>();
        newFullViewer.showAllProd(newProdArray);

        // можем записать объект в Базу Данных (файл)
        ProdSave2DB newWriter = new ProdSave2DB<>();
        newWriter.save2DB(newPhone1);

        // можем записать массив продуктов(объектов) в Базу Данных (файл)
        ConnectorArraySave newMultiWriter = new ConnectorArraySave();
        newMultiWriter.saveArray2DB(newProdArray);


    }
}
