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
    private String humanclassSex;
    private int age;
    private HumanClass partner;
    public enum hSex {Male, Female}
    private String father;
    private String mother;
    private final HashMap<String, HumanClass> parents = new HashMap<>();
    private final HashSet<HumanClass> childs = new HashSet<>();



    public HumanClass(String hName, String hsName, int hAge) {
        this.setName(hName);
        this.setSurName(hsName);
        this.setAge(hAge);
//        System.out.printf("Object HumanClas created. Name %s, SurName %s, Age %d", hName, hsName, hAge);
//        System.out.println();
    }

    public HumanClass(String hName) {
        this(hName, "NoSurname", 0);

//        System.out.printf("Object HumanClas created. Name %s", hName);
//        System.out.println();
    }
    public HumanClass() {
        this("NoName", "NoFamily", 0);
//        System.out.println("Object HumanClas created. Name is not registerred");
    }




    // getters
    public String getName() {
        return this.name + " " + this.surName;
    }

    public String getParentsNames() {
        return "Father- " + this.father + "\n" + "Mother- " + this.mother;

    }
    public String getChildrenNames() {
        String result = "";
        for (HumanClass child:
                this.childs) {
            result = result + " " + child.getName();
        }
        return result;
    }


    public HashSet<HumanClass> getChilds() {
        return this.childs;
    }

    public HashMap<String, HumanClass> getParents() {
        return this.parents;
    }

    public HumanClass getPartner() {
        return partner;
    }

    public int getAge() {
        return age;
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

/**
 * Метод добавляет ребенка в HashSet
 * также добавляет ребенку отца и мать (партнеров)
 *
 * */
    public void setChild(HumanClass  child) {
        if (this.childs.contains(child)) {
            System.out.println("This child already is in HashSet");
        }
        else {
            this.childs.add(child);
        }
        child.setParent(this);
    }


    /**
     * Метод добавляет отца и мать в HashMap
     * */

    public void setParents(HumanClass father, HumanClass mother) {
        this.father = father.getName();
        this.mother = mother.getName();
        this.parents.put("father", father);
        this.parents.put("mother", mother);

    }

    /**
     * Метод добавляет объекту отца или мать в HashMap
     * в зависимости от пола
     * если у отца или матери нет этого ребенка
     * то также добавляет его в childs
     * */

    public void setParent(HumanClass person) {
        if (person.humanclassSex == "Male") {
            this.father = person.getName();
            this.parents.put("father", person);
        }
        else {
            this.mother = person.getName();
            this.parents.put("mother", person);
        }
        if (!person.childs.contains(this)) {
            person.setChild(this);
        }
    }




/**
 * This method is checking both partenrs for marriage
 * and make them partners if not
 */
    public void setPartner(HumanClass partner) {

        if (this.getPartner() == null && partner.getPartner() == null) {
            this.partner = partner;
            partner.partner = this;

        }
        else {

            System.out.printf("Cant marry %s:", partner.getName());
            System.out.println();
            System.out.printf("%s already married on %s", this.getName(), this.getPartner().getName());

        }

    }

    public void setHumanclassSex(String humanclassSex) {
        this.humanclassSex = humanclassSex;
    }

    // toString



}
