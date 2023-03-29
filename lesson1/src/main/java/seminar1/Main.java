package seminar1;
//import HumanClass;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        HumanClass man = new Man();
        HumanClass woman = new Woman();
        woman.setName("Svetlana");
        HumanClass dauhter = new Woman("Anna");
        HumanClass mother = new Woman("Elena");
        HumanClass father = new Man("Oleg", "Ivanov", 35);
        man.setName("Vova");
        man.setChild(dauhter);

//        man.setParents(father, mother);
        System.out.println("Trying to married Vova + Svetlana");
        man.setPartner(woman); // привязывает партнера
        System.out.println(man.getPartner().getName()); // показать имя партнера
        System.out.println(woman.getPartner().getName()); // показать имя партнера
//        System.out.println(woman.getName()); // получить имя
//        System.out.println(man.getName());
//        System.out.println(((Man) man).getSex());
//        System.out.println(man.getChildren());
//        System.out.println(man.getParents());
    }
}
