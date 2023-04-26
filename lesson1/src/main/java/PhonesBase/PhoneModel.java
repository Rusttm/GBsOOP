package PhonesBase;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;


/**
 * Модель телефона
 */
public class PhoneModel extends HashMap implements IProductModel<HashMap> {

    int id = 0;
    private static int counter;
    private LinkedList<String> phoneLabels;
    private LinkedList<String> phoneLabelsExt;
    private HashSet<String> phoneChar;
    private HashMap prod = new HashMap();
    private HashSet<String> ProdNesFields = new HashSet();
    private HashMap<String,String> prodCharFields = new HashMap();

    public static void main(String[] args) {
        fullFillment();
    }

    /**
     * Метод для тестовой проверки методов класса
     */
    public static void fullFillment() {
        PhoneModel newPhone1 = new PhoneModel();
        newPhone1.putKey("name","Android");
        newPhone1.putKey("memory","128");
        newPhone1.putKey("memory2","128.5");
        newPhone1.putKey("model","Nova");
        newPhone1.putKey("screen","6,74");
        newPhone1.putKey("brand","Huawei");
        newPhone1.putKey("year","2016");
        newPhone1.putKey("price","10000");
        newPhone1.putKey("name","Andriod"); // не должен брать

        PhoneModel newPhone2 = new PhoneModel();
        newPhone2.putKey("name","Iphone");
        newPhone2.putKey("model","12 Max Pro");
        newPhone2.putKey("screen","6,8");
        newPhone2.putKey("memory","64");
        newPhone2.putKey("brand","Apple");
        newPhone2.putKey("year","2021");
        newPhone2.putKey("price","100000");
        newPhone2.putKey("additionalInfo1","скидка");

        PhoneModel newPhone3 = new PhoneModel();
        newPhone3.putKey("name","Iphone");
        newPhone3.putKey("model","12 Max Pro");
        newPhone3.putKey("screen","6,8");
        newPhone3.putKey("memory","64");
        newPhone3.putKey("brand","Apple");
        newPhone3.putKey("year","2021");
        newPhone3.putKey("price","100000");
        newPhone3.putKey("ref","Восстановлен");

        PhoneModel newPhone4 = new PhoneModel();
        newPhone4.putKey("name","Android");
        newPhone4.putKey("model","Pixel");
        newPhone4.putKey("screen","6,1");
        newPhone4.putKey("memory","32");
        newPhone4.putKey("brand","Google");
        newPhone4.putKey("year","2015");
        newPhone4.putKey("price","10000");
    }

    public PhoneModel() {
        this.id = counter;
        counter ++;
//        System.out.printf("counter = %d", counter);
//        System.out.println();
        this.setProdNesFields();
        this.phoneLabels = new LinkedList<String>();
        this.phoneLabels.add("name");
        this.phoneLabels.add("model");
        this.phoneLabels.add("memory");
        this.phoneLabelsExt = new LinkedList<String>();
        this.phoneLabelsExt.add("brand");
        this.phoneChar = new HashSet<>();
    }

    /** Устананавливает новые пары ключ-значение
     * @param key ключ
     * @param value значение
     */
    public void putKey(String key, String value) {

        if (this.prod.get(key) == null) {
            this.prod.put(key,value);
        }
        this.setProdNesFields();
//        this.putKey("id", Integer.toString(this.id));
        prod.put("id", Integer.toString(this.id));
        this.prod = prod;
//        if (this.checkNesFields(prod)) {
//            this.phoneLabels = new LinkedList<String>();
//            this.phoneLabelsExt = new LinkedList<String>();
//            this.phoneChar = new HashSet<>();
//        } else {
//            System.out.println("Телефон не создан т.к. отсутствуют некоторые поля");
//            throw new IllegalArgumentException("Необходимо добавить поля, вызов списка полей - getProdNesFields()");
//        }
    }
    public void updKey(String key, String value) {
        this.prod.put(key,value);
        this.setProdNesFields();
    }

    @Override
    public HashMap getProd() {
        this.prod.put("label", this.getProdLabel());
        this.prod.put("descr", this.getProdDescr());
        return this.prod;
    }


    @Override
    public String getProdLabel() {
        String labelPhone = "";
        String labelPhoneExt = "";
        for (String key: this.phoneLabels) {
            labelPhone += this.prod.get(key) + " ";
        }
    if (this.phoneLabelsExt.size()!=0) {
        for (String key: this.phoneLabelsExt) {
            labelPhoneExt += this.prod.get(key);
        }
        labelPhone += "(" + labelPhoneExt + ")";
    }
//        System.out.println(labelPhone);
        return labelPhone;
    }

    @Override
    public HashSet<String> getProdNesFields() {
        return this.ProdNesFields;
    }

    /**
     * Устанавливает поля необходимые для заполнения
     */
    private void setProdNesFields() {
        this.ProdNesFields.add("id");
        this.ProdNesFields.add("name");
        this.ProdNesFields.add("model");
        this.ProdNesFields.add("screen");
        this.ProdNesFields.add("memory");
        this.ProdNesFields.add("brand");
        this.ProdNesFields.add("year");
        this.ProdNesFields.add("price");
    }
    private boolean checkNesFields(HashMap prod) {
        HashSet<String> resultMap = (HashSet<String>) this.ProdNesFields.clone();
        for (Object prodKey: prod.keySet()) {
            if (resultMap.contains(prodKey.toString())) {
                resultMap.remove(prodKey);
//                System.out.println(prod.get(prodKey));
            }
        }
        if (resultMap.size()>0) {
            return false;
        }
        return true;
    }

    @Override
    public String getProdId() {
        return Integer.toString(this.id);
    }

    @Override
    public String getProdDescr() {
        if (this.prod.get("descr")!=null) {
            return (String) this.prod.get("descr");
        }
        return  "Описание отсутствует";
    }

    /** Метод возвращает HashMap с указанием характеристик продукта
     * @return HashMap
     */
    @Override
    public HashMap<String, String> getProdCharTable() {
        this.setProdCharFields();
        HashMap<String, String> resultMap = new HashMap<>();
        for (String key: this.prodCharFields.keySet()) {
            if (prod.get(key) != null) {
                resultMap.put(this.prodCharFields.get(key),prod.get(key).toString());
            }
        }
        return resultMap;
    }

    /** Устанавливает поля с русским описанием для вызова характеристик телефона
     */
    public void setProdCharFields() {
        this.prodCharFields.put("name", "Название");
        this.prodCharFields.put("model","Модель");
        this.prodCharFields.put("screen","Размер дисплея");
        this.prodCharFields.put("memory","Память");
        this.prodCharFields.put("brand","Производитель");
        this.prodCharFields.put("year","Год Выпуска");
        this.prodCharFields.put("price","Цена");
        this.prodCharFields.put("ref","Восстановлен");
        this.prodCharFields.put("additionalInfo1","Дополнительная информация");
    }
}
