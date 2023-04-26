package PhonesBase;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner; // Import the Scanner class to read text files


/**
 * Коннектор к файлу с телефонами
 */
public class DBFileConnector implements IDBconnector<PhoneModel> {
    private ArrayList<HashMap> dataBase = new ArrayList<>();
    private final String fileName;
    public static void main(String[] args) {
//        Тестовые наполнения:
//        GenerateDBFile("PhoneDB");
//        readFromFile2Array("PhoneDB");
//        ArrayList testDataBase = DBFullFillment();
        DBFileConnector newConnect = new DBFileConnector("PhoneDB");
        newConnect.DBFullFillment();
        HashMap<String,String> newFilter = new HashMap<>();
        newFilter.put("memory","64");
//        newFilter.put("name","honor");
        System.out.printf("По фильтру %s найдено ", newFilter);
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

    /** Коннектор к файлу
     * @param fileName
     */
    public DBFileConnector(String fileName) {
        this.fileName = fileName;
        this.dataBase = this.getAllFromFile();
        System.out.println("Connector in created");
    }
    public DBFileConnector() {
        this.fileName = "PhoneDB";
        new DBFileConnector("PhoneDB");
//        this.dataBase = this.readFromFile2Array();
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
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(this.fileName), StandardCharsets.UTF_8))) {
            for (Object prodOb : dataArray) {
//                System.out.println(prodOb);
                writer.write(prodOb.toString() + "\n");
            }
            return true;
        } catch (IOException ex) {
            // Report
            return false;
        }
        /*ignore*/
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
        if (pairs[0] == "") {
            return newProd;
        }
        for (String pair : pairs) {
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
//                        resultArray.remove(i);
                    }

                } catch (Exception e) {
//                    System.out.printf("В продукте %s не найдено значение %s",prod.toString(), filterKey);
                    removeIndexes.add(i);
//                    resultArray.remove(i);
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
    public HashMap getProductFromDBByID(String id) {
        if (this.dataBase == null) {
            return null;
        }
        for (HashMap<String,String> prodHashSring: this.dataBase) {
//            Не понятно, почему он не может сравнить две строки?, приходится возводить следующую конструкцию
            String value = prodHashSring.get("id");
            if (value != null) {
                if ( value.compareTo(id) ==0 ) {
                    return prodHashSring;
                }
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

    @Override
    public ArrayList getAllFromFile() {
        // read data to ArrayList dataBase
        ArrayList<HashMap> resultArray = new ArrayList<>();
        try {
            File myObj = new File(this.fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data != "") {
                    resultArray.add(convertStr2HashMap(data));
                } else {
                    return null;
                }

            }
            myReader.close();
            return resultArray;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }


    /**Кладет новый продукт в Базу
     * @param newProd продукт в виде HashMap
     * @return получилось или нет?
     */
    @Override
    public boolean putProd2DB(PhoneModel newProd) {
        String newValue = newProd.getProdId();
        this.dataBase = this.getAllFromFile();

        if (this.dataBase == null) {
            this.setDataBase();
            this.dataBase.add(newProd.getProd());
            this.write2FileFromArray(this.dataBase);
            return true;
        } else {
            // Сначала проверить есть ли в базе?
            HashMap isNotNew = this.getProductFromDBByID(newValue);
            // проверить на наличие правильных ключей
            if (isNotNew==null) {
                this.dataBase.add(newProd.getProd());
                this.write2FileFromArray(this.dataBase);
                System.out.printf("Продукт %s добавлен", newProd.getProdLabel());
                System.out.println();
                return true;
            }
            System.out.println("Продукт с данным id уже существует");
            return false;
        }
    }

    @Override
    public boolean delProdFromDB(String id) {
        ArrayList workArray = this.dataBase;
        HashMap<String,String> prod;
        for (int i = 0; i < this.dataBase.size(); i++) {
            prod = (HashMap) workArray.get(i);
            String value = prod.get("id");
            if ( value.compareTo(id) ==0 ) {
                workArray.remove(i);
                this.write2FileFromArray(workArray);
                this.getAllFromFile();
                System.out.printf("Продукт %s удален", prod);
                System.out.println();
                return true;
            }
        }
        System.out.println("Продукт с данным ID не удален или не существует в Базе");
        return false;
    }


    @Override
    public boolean updProd2DB(PhoneModel updProd) {
        String updIDValue = updProd.getProdId();
        this.dataBase = this.getAllFromFile();
        // Сначала проверить есть ли в базе?
        HashMap isNotNew = this.getProductFromDBByID(updIDValue);
        if (isNotNew!=null) {
            this.dataBase.remove(isNotNew);
            this.dataBase.add(updProd.getProd());
            this.write2FileFromArray(this.dataBase);
            System.out.printf("Продукт %s обновлен на %s", isNotNew, updProd.getProd());
            System.out.println();
            return true;
        }
        System.out.println("Продукт не найден в базе");
        return false;
    }

    public ArrayList<HashMap> getDataBase() {
        return dataBase;
    }

    public String getFileName() {
        return fileName;
    }

    public void setDataBase() {
        ArrayList dataBase = new ArrayList<>();
        this.dataBase = dataBase;
    }
}
