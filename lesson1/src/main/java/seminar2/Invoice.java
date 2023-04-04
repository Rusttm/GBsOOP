package seminar2;


/*
* Создание нового документа  Счет
* на основании двух интерфейсов
* автоматически создается объект Корзина
* */
public class Invoice extends Document implements FinanceDocument, ProdDocument{
    // автоматически создаем корзину (список товаров в счете)
    Cart invoiceCart;
    public Invoice() {
        // создаем товары
        Product newProd1 = new Product("Iphone 12", 1000.00,1300.00, 0.2);
        Product newProd2 = new Product("Macbook Air", 2500.00,3000.00, 0.2);
        // добавляем товары в корзину
        invoiceCart.addProd(newProd1, 5);
        invoiceCart.addProd(newProd2, 3);
        invoiceCart.addProd(newProd1, 1);
        invoiceCart.viewCart();
        invoiceCart.getCartInvoiceView();
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
    public Double numSum() {
        return this.invoiceCart.getCartProdNum();
    }
}
