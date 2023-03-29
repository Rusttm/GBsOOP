public class HumanClass {
    private String name;
    private String surName;
    private int age;
    private boolean mariage;
    private String father;
    private String mother;
    private HashMap<String> childs;

    public HumanClass {
        System.out.println("Man midified");

    }

    public String getName() {
        return "name" + " " + "surName";
    }
    public String getParents() {
        return father + " " + mother;
    }
    public String getChildren() {
        result = "";
        for (String child:
             this.childs) {
            result += " " + child
        }

        return father + " " + mother;
    }
    @java.lang.Override
    public java.lang.String toString() {
        return "HumanClass{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                ", mariage=" + mariage +
                ", father='" + father + '\'' +
                ", mother='" + mother + '\'' +
                ", childs=" + childs +
                '}';
    }
}
