package seminar3;


/*создаем документ Счет и вносим туда позиции
* */
public class Main {
    public static void main(String[] args) {
        System.out.println("Счет #1");
        // создаем Счет с автозаполнением
        Invoice newInvoice1 = new Invoice();

        //        добавляем компанию
        Company myCompany = new Company("77777777", "Рога и Копыта");
        newInvoice1.setOwner(myCompany);

        //        печатаем Счет
        newInvoice1.printInvoice();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("Счет #2");
        // создаем Счет с пустой корзиной
        Cart newCart = new Cart();
        Invoice newInvoice2 = new Invoice(newCart);
        //        добавляем компанию
        Company myCompany2 = new Company("7799999", "Муки Зву");
        newInvoice2.setOwner(myCompany2);
        //        добавляем товар в счет
        Product newProduct = new Product("Сумка", 300.00,500.00, 0.2);
        newInvoice2.addProd(newProduct, 1);
        //        печатаем Счет
        newInvoice2.printInvoice();



    }
}
