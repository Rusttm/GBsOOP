package PhonesBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Controller {

    private DBFileConnector mainConnector;
    private Scanner button1 = new Scanner(System.in);
    private Scanner field1 = new Scanner(System.in);


    public static void main(String[] args) {
        Controller newController = new Controller();
        Scanner myButton = new Scanner(System.in);
        String button = "s";
        while (button.compareTo("x")!=0) {
            if (button.compareTo("s") == 0) {
                newController.mainPage();
                button = myButton.next().toString();
            }
            if (button.compareTo("d") == 0) {
                newController.deletePage();
                button = myButton.next().toString();
                if (button.compareTo("s") != 0) {
                    newController.deleteElem(button);
                    newController.mainPage();
                }
            }
            if (button.compareTo("n") == 0) {
                newController.makePage();
                newController.mainPage();
            }

            button = myButton.next().toString();
        }

    }

    public Controller() {
        this.mainConnector = new DBFileConnector();
        this.fullFillment();
    }

    /**
     * Показывает, какие позиции есть в Базе?
     */
    public void mainPage() {
        PhoneView newView = new PhoneView();
        newView.printAllPhones(this.mainConnector.getAllFromFile());
        newView.printMainCommands();
    }
    public void deletePage() {
        PhoneView newView = new PhoneView();
        newView.printAllPhones(this.mainConnector.getAllFromFile());
        newView.printDelCommands();
    }
    public void makePage() {
        PhoneView newView = new PhoneView();
        PhoneModel newPhone = new PhoneModel();
        ArrayList fields = new ArrayList<>(newPhone.getProdNesFields());
//        fields = newPhone.getProdNesFields();
        boolean completed = true;
        HashMap<String, String> prod = new HashMap<>();
        String field = "m";
        for (int i = 0; i < fields.size() ; i++) {
            if (fields.get(i).toString().compareTo("id") == 0) {
                continue;
            }
            newView.makePhone(fields.get(i).toString());
            field = this.field1.next().toString();
            if (field.compareTo("s") != 0) {
                newPhone.putKey(fields.get(i).toString(), field.toString());
            } else {
                completed = false;
                break;
            }
        }
        if (completed) {
            this.mainConnector.putProd2DB(newPhone);
            System.out.println("Товар создан");
        }

    }

    public void deleteElem(String posNum) {
        ArrayList posList = this.mainConnector.getAllFromFile();
        HashMap<String,String> pos = new HashMap<>();
        for (int i = 0; i < posList.size() ; i++) {
            if (posNum.compareTo(Integer.toString(i+1)) == 0) {
                pos = (HashMap) posList.get(i);
                System.out.printf("Удаляем %sй элемент", pos.get("id"));
                System.out.println();
                this.mainConnector.delProdFromDB(pos.get("id"));
                break;
            }
        }
    }

    public void fullFillment() {
        DBFileConnector newPhoneConnector = this.mainConnector;

        PhoneModel newPhone1 = new PhoneModel();
        newPhone1.putKey("name","Redmi MI9");
        newPhone1.putKey("memory","128");
//        newPhone1.putKey("memory2","128.5");
        newPhone1.putKey("model","MI9");
        newPhone1.putKey("screen","6,74");
        newPhone1.putKey("brand","Xiaomi");
        newPhone1.putKey("year","2018");
        newPhone1.putKey("price","10000");
//        newPhone1.putKey("name","Andriod"); // не должен брать
//        System.out.println(newPhone1.getProdId());
        newPhoneConnector.putProd2DB(newPhone1);

        PhoneModel newPhone2 = new PhoneModel();
        newPhone2.putKey("name","Iphone");
        newPhone2.putKey("model","12 Max Pro");
        newPhone2.putKey("screen","6,8");
        newPhone2.putKey("memory","64");
        newPhone2.putKey("brand","Apple");
        newPhone2.putKey("year","2021");
        newPhone2.putKey("price","100000");
        newPhone2.putKey("additionalInfo1","скидка");
//        System.out.println(newPhone2.getProdId());
        newPhoneConnector.putProd2DB(newPhone2);

        PhoneModel newPhone3 = new PhoneModel();
        newPhone3.putKey("name","Iphone");
        newPhone3.putKey("model","12 Max Pro");
        newPhone3.putKey("screen","6,8");
        newPhone3.putKey("memory","64");
        newPhone3.putKey("brand","Apple");
        newPhone3.putKey("year","2021");
        newPhone3.putKey("price","100000");
        newPhone3.putKey("ref","Восстановлен");
        newPhoneConnector.putProd2DB(newPhone3);

        PhoneModel newPhone4 = new PhoneModel();
        newPhone4.putKey("name","Android");
        newPhone4.putKey("model","Pixel");
        newPhone4.putKey("screen","6,1");
        newPhone4.putKey("memory","32");
        newPhone4.putKey("brand","Google");
        newPhone4.putKey("year","2015");
        newPhone4.putKey("price","10000");
        newPhoneConnector.putProd2DB(newPhone4);

        PhoneModel newPhone5 = new PhoneModel();
        newPhone5.putKey("name","Android");
        newPhone5.putKey("memory","128");
        newPhone5.putKey("memory2","128.5");
        newPhone5.putKey("model","Nova");
        newPhone5.putKey("screen","6,74");
        newPhone5.putKey("brand","Huawei");
        newPhone5.putKey("year","2016");
        newPhone5.putKey("price","10000");
        newPhone5.putKey("name","Andriod"); // не должен брать
        newPhoneConnector.putProd2DB(newPhone5);


        newPhone5.updKey("name","Android10");
        newPhone5.updKey("memory","128");
        newPhone5.updKey("model","Nova");
        newPhone5.updKey("screen","6,74");
        newPhone5.updKey("brand","Huawei");
        newPhone5.updKey("year","2016");
        newPhone5.updKey("price","10000");
        newPhoneConnector.updProd2DB(newPhone5);



    }

}
