package seminar1;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Конструктор класса Человек
 * *
 */
public class HumanClass {
    private String name;
    private String surName;
    private int age;
    private HumanClass partner;
    public enum hSex {Male, Female};
    private String father;
    private String mother;
    private HashMap<String, HumanClass> parents = new HashMap<>();
    private HashSet<HumanClass> childs = new HashSet<>();



    public HumanClass(String hName, String hsName, int hAge) {
        this.setName(hName);
        this.setSurName(hsName);
        this.setAge(hAge);
        System.out.printf("Object HumanClas created. Name %s, SurName %s, Age %d", hName, hsName, hAge);
        System.out.println();
    }

    public HumanClass(String hName) {
        this(hName, "NULL", 0);

        System.out.printf("Object HumanClas created. Name %s", hName);
        System.out.println();
    }
    public HumanClass() {
        this("NoName", "NoFamily", 0);
        System.out.println("Object HumanClas created. Name is not registerred");
    }




    // getters
    public String getName() {
        return this.name + " " + this.surName;
    }

    public String getParents() {
        return "Parents: \n" + "Father- " + this.father + "\n" + "Mother- " + this.mother;

    }
    public String getChildren() {
        String result = "Childrens: ";
        for (HumanClass child:
                this.childs) {
            result += "\n" + child.getName();
        }
        return result;
    }

    public HumanClass getPartner() {
        return partner;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setChild(HumanClass  child) {
        this.childs.add(child);

    }

    public void setParents(HumanClass father, HumanClass mother) {
        this.father = father.getName();
        this.mother = mother.getName();
        this.parents.put("father", father);
        this.parents.put("mother", mother);
    }
/**
 * This method is checking
 */
    public boolean setPartner(HumanClass partner) {

        if (this.getPartner() == null && partner.getPartner() == null) {
            this.partner = partner;
            partner.partner = this;
            return  true;
        }
        else {
            System.out.printf("Already married on %s", this.getPartner().getName());
            return  false;
        }

    }

    // toString



}
