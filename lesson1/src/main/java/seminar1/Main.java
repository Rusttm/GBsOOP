package seminar1;
//import HumanClass;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        HumanClass man = new Man();
        man.setName("Vova");
        man.setSurName("Ivanov");
        man.setAge(35);

        HumanClass woman = new Woman();
        woman.setName("Svetlana");
        woman.setSurName("Sidorova");

        HumanClass dauhter = new Woman("Anna", "Ivanova", 15);
        HumanClass mother = new Woman("Elena", "Petrova", 51);
        HumanClass father = new Man("Oleg", "Ivanov", 55);


        System.out.println("Set child to Vova");
        man.setChild(dauhter);
        System.out.printf("%s childs: \n%s", man.getName(), man.getChildren());
        System.out.println();


        System.out.println("Set parents to Vova");
        man.setParents(father, mother);
        System.out.printf("%s parents: \n%s",man.getName(), man.getParents());
        System.out.println();

        System.out.println("Trying to married Vova + Svetlana");
        man.setPartner(woman); // привязывает партнера
        System.out.printf("Partner of %s is %s", man.getPartner().getName(), woman.getPartner().getName()); // показать имя партнера
        System.out.println();
        System.out.printf("Partner of %s is %s", woman.getPartner().getName(), man.getPartner().getName()); // показать имя партнера

//        System.out.println(((Man) man).getSex());

;
    }
}
