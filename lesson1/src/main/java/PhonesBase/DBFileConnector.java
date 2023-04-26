package PhonesBase;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner; // Import the Scanner class to read text files


/**
 * Коннектор к файлу с телефонами
 */
public class DBFileConnector implements IDBconnector {
    private ArrayList<HashMap> dataBase;
    private String fileName;
    public static void main(String[] args) {
//        Тестовые наполнения:
//        GenerateDBFile("PhoneDB");
//        readFromFile2Array("PhoneDB");
//        ArrayList testDataBase = DBFullFillment();
        DBFileConnector newConnect = new DBFileConnector("PhoneDB");
        newConnect.DBFullFillment();
        HashMap<String,String> newFilter = new HashMap<>();
        newFilter.put("memory","64");
        newFilter.put("name","honor");
        System.out.printf("По фильтру %s найдено ", newFilter.toString());
        System.out.println(newConnect.getFilteredDB(newFilter));
//        System.out.println(newConnect.dataBase);
//        HashMap<String, String> prod5 = new HashMap<>();
//        prod5.put("id", "1");
//        prod5.put("name", "IPhone");
//        newConnect.updProd2DB(prod5);



//        System.out.println(newConnect.dataBase);
//        newConnect.write2FileFromArray("PhoneDB", testDataBase);
//        System.out.println();
//        System.out.println(newConnect.readFromFile2Array());
//        System.out.println(newConnect.getProductByID("2"));
//        System.out.println(newConnect.delProdFromDB("2"));

    }

    public DBFileConnector(String fileName) {
        this.fileName = fileName;
        this.dataBase = this.readFromFile2Array();
    }


    /** Вспомогательный метод Создает файл
     * @param fileName название файла
     */
    public static void GenerateDBFile(String fileName) {
        try {
            File myObj = new File(fileName);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    /** считывает данные из файла в массив HashMap
     * @return массив
     */
    public ArrayList readFromFile2Array() {
        // read data to ArrayList dataBase
        ArrayList<HashMap> resultArray = new ArrayList<>();

        try {
            File myObj = new File(this.fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
//                System.out.println(data);
                resultArray.add(convertStr2HashMap(data));
            }
            myReader.close();
            return resultArray;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }

    }


    public boolean write2FileFromArray(ArrayList dataArray) {
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(this.fileName), "utf-8"));
            for (Object prodOb: dataArray) {
//                System.out.println(prodOb);
                writer.write(prodOb.toString()+"\n");
            }
            return true;
        } catch (IOException ex) {
            // Report
            return false;
        } finally {
            try {writer.close();} catch (Exception ex) {/*ignore*/}
        }
    }

    /** дополнительный модуль для конвертации из строки файла в Hashmap
     * @param hashString входная строка
     * @return массив ArrayList
     */
    public static HashMap convertStr2HashMap(String hashString) {
        // delete {}
        String strNew = hashString.substring(1, hashString.length()-1);
        HashMap<String, String> newProd = new HashMap<>();
        // split key:value
        String[] pairs = strNew.split(", ");
        for (int i = 0; i < pairs.length; i++) {
            String pair = pairs[i];
            String[] keyValue = pair.split("=");
            newProd.put(keyValue[0], keyValue[1]);
        }
        return newProd;
    }

    /** Дополнительный модуль для заполнение тестовой базы
     */
    public void DBFullFillment() {
        ArrayList<HashMap> dataBase = new ArrayList<>();
        HashMap<String, String> prod1 = new HashMap<>();
        prod1.put("id", "1");
        prod1.put("name", "IPhone");
        prod1.put("memory", "64");
        HashMap<String, String> prod2 = new HashMap<>();
        prod2.put("id", "2");
        prod2.put("name", "Xiaomi");
        prod2.put("memory", "128");
        HashMap<String, String> prod3 = new HashMap<>();
        prod3.put("id", "3");
        prod3.put("name", "Honor");
        prod3.put("memory", "64");
        dataBase.add(prod1);
        dataBase.add(prod2);
        dataBase.add(prod3);
        HashMap<String, String> prod4 = new HashMap<>();
        prod4.put("id", "4");
        prod4.put("name", "Google");
        prod4.put("memory", "32");
        dataBase.add(prod4);

        this.dataBase = dataBase;
        this.write2FileFromArray(dataBase);

    }


    @Override
    public ArrayList getFilteredDB(HashMap<String, String> filterMap) {
        ArrayList resultArray = new ArrayList<>();
//        ArrayList resultArray = (ArrayList) this.dataBase.clone();
//        Ищем по ключу
        HashSet<Integer> removeIndexes = new HashSet<>();
        for (String filterKey: filterMap.keySet()) {
            String filterValue = filterMap.get(filterKey);
            for (int i = 0; i < this.dataBase.size(); i++) {
                HashMap<String,String> prod = (HashMap) this.dataBase.get(i);
                try {
                    String value = prod.get(filterKey);
//                    Исключаем, если не подходит
                    if ( value.toLowerCase().compareTo(filterValue.toLowerCase()) !=0 ) {
                        removeIndexes.add(i);
                    }

                } catch (Exception e) {
//                    System.out.printf("В продукте %s не найдено значение %s",prod.toString(), filterKey);
                    removeIndexes.add(i);
//                    throw new RuntimeException(e);
                }

            }
//            System.out.println(removeIndexes);

        }
        for (int i = 0; i < this.dataBase.size(); i++) {
//            System.out.println(removeIndexes.contains(i));
            if (!removeIndexes.contains(i)) {
//                    System.out.println(removeIndexes.contains(i));
                    resultArray.add(this.dataBase.get(i));
            }

        }


        return resultArray;
    }

    @Override
    public HashMap getProductByID(String id) {
        for (HashMap<String,String> prod: this.dataBase) {
//            Не понятно, почему он не может сравнить две строки?, приходится возводить следующую конструкцию
            String value = prod.get("id");
            if ( value.compareTo(id) ==0 ) {
                return prod;
            }
        }
        return null;
    }

    /**Выдать всю базу
     * @return возвращает ArrayList
     */
    @Override
    public ArrayList getAllDb() {
        return this.dataBase;
    }


    /**Кладет новый продукт в Базу
     * @param newProd продукт в виде HashMap
     * @return получилось или нет?
     */
    @Override
    public boolean putProd2DB(HashMap<String, String> newProd) {
        String newValue = newProd.get("id");
        // Сначала проверить есть ли в базе?
        HashMap isNotNew = this.getProductByID(newValue);
        if (isNotNew==null) {
            this.dataBase.add(newProd);
            this.write2FileFromArray(this.dataBase);
            System.out.printf("Продукт %s добавлен", newProd.toString());
            System.out.println();
            return true;
        }
        System.out.println("Продукт с данным id уже существует");
        return false;
    }

    @Override
    public boolean delProdFromDB(String id) {
        ArrayList workArray = this.dataBase;
        HashMap<String,String> prod = new HashMap<>();
        for (int i = 0; i < this.dataBase.size(); i++) {
            prod = (HashMap) workArray.get(i);
            String value = prod.get("id");
            if ( value.compareTo(id) ==0 ) {
                workArray.remove(i);
                this.write2FileFromArray(workArray);
                this.readFromFile2Array();
                System.out.printf("Продукт %s удален", prod.toString());
                System.out.println();
                return true;
            }
        }
        System.out.println("Продукт с данным ID не удален или не существует в Базе");
        return false;
    }


    @Override
    public boolean updProd2DB(HashMap<String, String> updProd) {
        String updValue = updProd.get("id");
        // Сначала проверить есть ли в базе?
        HashMap isNotNew = this.getProductByID(updValue);
        if (isNotNew!=null) {
            this.dataBase.remove(isNotNew);
            this.dataBase.add(updProd);
            this.write2FileFromArray(this.dataBase);
            System.out.printf("Продукт %s обновлен на %s", isNotNew.toString(),updProd.toString());
            System.out.println();
            return true;
        }
        System.out.println("Продукт не найден в базе");
        return false;
    }

    public ArrayList<HashMap> getDataBase() {
        return dataBase;
    }
}
