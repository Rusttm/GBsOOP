package seminar4;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/*
* Создание нового документа  Счет
* на основании двух интерфейсов
* автоматически создается объект Корзина
* */
public class Invoice extends Document implements InterfaceFinanceDocument, InterfaceProdDocument {

    // автоматически создаем корзину (список товаров в счете)
    Cart invoiceCart;
    Company ownerComp;
    private int id = 1;

    private String name = "";
    private String date = "";

    public static void main(String[] args) {
        Invoice newInvoice = new Invoice();
        newInvoice.invoiceTestFullFillment();
        // устанавливаем реквизиты компании
//        Company myCompany = new Company("7799999", "Муки Зву");
//        newInvoice.setOwner(myCompany);
        newInvoice.printInvoice();
    }
    public Invoice(Cart objCart) {
        /*
         * Счет имеет возможность добавлять товар при инициализации
         * т.к. может быть создан из другого документа
         * */
        this.invoiceCart = objCart;
        this.id++;
        this.setDate();
        this.ownerComp = new Company("______", "______");
    }

    public Invoice() {
        /*
         * пустой Счет
         * */
        this.id++;
        this.setDate();
        this.invoiceCart = new Cart();
        this.ownerComp = new Company("______", "______");
    }
    @Override
    public String getDate() {
        return this.date;
    }

    @Override
    public void setDate() {
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        this.date = dtf.format(now);
    }

    @Override
    public void printDocument() {
        this.printInvoice();
    }

    // тестовая реализация
    public void invoiceTestFullFillment() {
        // создаем товары
        Product newProd1 = new Product("Iphone 12", 1000.00);
        Product newProd2 = new Product("Macbook Air", 2500.00);
        Product newProd3 = new Product("Samsung S22", 1100.00);
        // добавляем товары в корзину
        this.invoiceCart.addProd(newProd1, 4);
        this.invoiceCart.addProd(newProd2, 3);
        this.invoiceCart.addProd(newProd1, 1);
        this.invoiceCart.addProd(newProd3, 2);
//        newCart.getCartInvoiceView();
    }



    public void addProd(Product objProd, int num) {
        /* добавление в Счет эквивалентно добавление в корзину счета*/
        this.invoiceCart.addProd(objProd, num);
    }

    public Cart getInvoiceCart() {
        return invoiceCart;
    }

    /* печать документа*/
    public void printInvoice() {
        System.out.println("Компания: " + this.ownerComp.getName() + " ИНН: " + this.ownerComp.getItn());
        System.out.println("Счет номер " + this.getName() + " от " + this.getDate());
        ArrayList<ArrayList> myInvoiceCart = this.invoiceCart.getCartInvoiceView();
        int i = 1;
        System.out.println("№|Наименование|колво|Цена|Сумма налога|Сумма|");
        for (ArrayList printLine: myInvoiceCart) {
            System.out.print(i);
            for (Object elem :printLine) {
                System.out.print("|"+ elem);
            }
            System.out.print("|");
            System.out.println();

            i++;
        }
        System.out.printf("Всего позиций: %d", this.invoiceCart.getNumPos());
//        System.out.print(this.invoiceCart.getNumPos());
        System.out.println();
        System.out.printf("Количество товара: %.0f шт.", this.numSum());
        System.out.println();
        System.out.printf("Итого к оплате: %.2f руб.", this.sumDoc());
        System.out.println();
        System.out.printf("В том числе НДС: %.2f руб.", this.vatDoc());
        System.out.println();


    }

    @Override
    public Double sumDoc() {
        return this.invoiceCart.getCartSum();
    }

    @Override
    public Double vatDoc() {
        return this.invoiceCart.getCartVatSum();
    }

    @Override
    public Company getOwner() {
        return this.ownerComp;
    }

    public String getName() {
        if (name == "") {
            return Integer.toString(this.id);
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(Company obComp) {
        this.ownerComp = obComp;
    }

    @Override
    public Double numSum() {
        return this.invoiceCart.getCartProdNum();
    }
}
