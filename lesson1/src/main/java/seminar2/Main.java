package seminar2;


/*создаем документ Счет и вносим туда позиции
* */
public class Main {
    public static void main(String[] args) {
        // создаем Инвойса
        Invoice newInvoice1 = new Invoice();

//        добавляем компанию
        Company myCompany = new Company("77777777", "Рога и Копыта");
        newInvoice1.setOwner(myCompany);

//        добавляем товар в счет
        Product newProduct = new Product("Сумка", 300.00,500.00, 0.2);
        newInvoice1.addProd(newProduct, 1);

//        печатаем Счет
        newInvoice1.printInvoice();

    }
}
