package seminar2;


/*создаем документ Счет и вносим туда позиции
* */
public class Main {
    public static void main(String[] args) {
        Product newProd1 = new Product("Iphone 12", 1000.00,1300.00);
        Product newProd2 = new Product("Macbook 12", 1000.00,1300.00);
        System.out.println(newProd1.getProdInfo());
        Cart newCart = new Cart();
        newCart.addProd(newProd1);
        newCart.viewCart();

//        Document newDoc = new Document();
//        System.out.println(newDoc.getId());
//        System.out.println(newDoc.getDate());
    }
}
