package seminar1;
//import HumanClass;
public class Main {
    public static void main(String[] args) {
        System.out.println("Generate objects from classes Man and Woman");
        HumanClass man = new Man();
        man.setName("Vova");
        man.setSurName("Ivanov");
        man.setAge(35);

        HumanClass woman = new Woman();
        woman.setName("Svetlana");
        woman.setSurName("Sidorova");

        HumanClass womansister = new Woman("Vera", "Sidorova", 15);
        HumanClass dauhter = new Woman("Anna", "Ivanova", 15);

        HumanClass mother = new Woman("Elena", "Petrova", 51);
        HumanClass father = new Man("Oleg", "Ivanov", 55);
        HumanClass son = new Man("Viktor", "Ivanov", 5);

        // Set child to Vova
        man.setChild(dauhter);
        son.setParent(woman);
        System.out.printf("%s childs: \n%s", man.getName(), man.getChildrenNames());
        System.out.println();
        System.out.printf("%s childs: \n%s", woman.getName(), woman.getChildrenNames());
        System.out.println();

        // Set parents to Vova
        man.setParents(father, mother);
        System.out.printf("%s parents: \n%s",man.getName(), man.getParentsNames());
        System.out.println();


        // Trying to married Vova + Svetlana
        man.setPartner(woman); // привязывает партнера
        man.setPartner(womansister); // пытаемся привязать нового "Already married ..."
        System.out.println();
        System.out.printf("Partner of %s is %s", man.getPartner().getName(), woman.getPartner().getName()); // показать имя партнера
        System.out.println();
        System.out.printf("Partner of %s is %s", woman.getPartner().getName(), man.getPartner().getName()); // показать имя партнера

//        System.out.println(((Man) man).getSex());


    }
}
