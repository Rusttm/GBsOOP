package PhonesBase;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;


/**
 * Модель телефона
 */
public class PhoneModel implements IProductModel<HashMap> {

    int id = 0;
    private LinkedList<String> phoneLabels;
    private LinkedList<String> phoneLabelsExt;
    private HashSet<String> phoneChar;
    private HashMap prod;
    private HashSet<String> ProdNesFields = new HashSet();
    private HashMap<String,String> prodCharFields = new HashMap();

    public static void main(String[] args) {
        fullFillment();
    }

    /**
     * Метод для тестовой проверки методов класса
     */
    public static void fullFillment() {
        HashMap<String,String> newProdMap = new HashMap<>();
        newProdMap.put("name","Andriod");
        newProdMap.put("memory","128");
        newProdMap.put("memory2","128.5");
        newProdMap.put("model","Nova");
        newProdMap.put("screen","6,74");
        newProdMap.put("brand","Huawei");
        newProdMap.put("year","2016");
        newProdMap.put("price","10000");
        PhoneModel newPhone1 = new PhoneModel(newProdMap);
        HashMap<String,String> newProdMap2 = new HashMap<>();
        newProdMap2.put("name","Andriod");
        newProdMap2.put("model","X6");
        newProdMap2.put("screen","6,5");
        newProdMap2.put("memory","128");
        newProdMap2.put("brand","Honor");
        newProdMap2.put("year","2019");
        newProdMap2.put("price","17000");
        newProdMap2.put("descr","Best seller");
        PhoneModel newPhone2 = new PhoneModel(newProdMap2);
        HashMap<String,String> newProdMap3 = new HashMap<>();
        newProdMap3.put("name","Iphone");
        newProdMap3.put("model","12 Max Pro");
        newProdMap3.put("screen","6,8");
        newProdMap3.put("memory","64");
        newProdMap3.put("brand","Apple");
        newProdMap3.put("year","2021");
        newProdMap3.put("price","100000");
        newProdMap3.put("additionalInfo1","скидка");
        PhoneModel newPhone3 = new PhoneModel(newProdMap3);
        HashMap<String,String> newProdMap4 = new HashMap<>();
        newProdMap4.put("name","Iphone");
        newProdMap4.put("model","12 Max Pro");
        newProdMap4.put("screen","6,8");
        newProdMap4.put("memory","64");
        newProdMap4.put("brand","Apple");
        newProdMap4.put("year","2021");
        newProdMap4.put("price","100000");
        newProdMap4.put("ref","Восстановлен");
        PhoneModel newPhone4 = new PhoneModel(newProdMap4);
        newPhone1.getProdLabel();
        System.out.println(newPhone1.getProdDescr());
        System.out.println(newPhone1.getProdCharTable());
        newPhone2.getProdLabel();
        System.out.println(newPhone2.getProdDescr());
        newPhone3.getProdLabel();
        System.out.println(newPhone3.getProdDescr());
        newPhone4.getProdLabel();
        System.out.println(newPhone4.getProdDescr());
    }
    public PhoneModel(HashMap prod) {
        this.id ++;
        this.setProdNesFields();
        prod.put("id", Integer.toString(this.id));

        this.prod = prod;
       if (this.checkNesFields(prod)) {
           this.phoneLabels = new LinkedList<String>();
           this.phoneLabelsExt = new LinkedList<String>();
           this.phoneChar = new HashSet<>();
       } else {
           System.out.println("Телефон не создан т.к. отсутствуют некоторые поля");
            throw new IllegalArgumentException("Необходимо добавить поля, вызов списка полей - getProdNesFields()");
       }
    }


    @Override
    public HashMap getProd() {
        return this.prod;
    }

    @Override
    public String getProdLabel() {
        String labelPhone = "";
        String labelPhoneExt = "";
        this.phoneLabels.add("name");
        this.phoneLabels.add("model");
        this.phoneLabels.add("memory");
        this.phoneLabelsExt.add("brand");
        for (String key: this.phoneLabels) {
            labelPhone += this.prod.get(key) + " ";
        }
    if (this.phoneLabelsExt.size()!=0) {
        for (String key: this.phoneLabelsExt) {
            labelPhoneExt += this.prod.get(key);
        }
        labelPhone += "(" + labelPhoneExt + ")";
    }
        System.out.println(labelPhone);
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
        return null;
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
