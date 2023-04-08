package seminar4;


/*создаем документ Счет и вносим туда позиции
* */
public class Main {
    public static void main(String[] args) {
        // создаем склад
        Stock stock = new Stock("Москва1");
        // автозаполняем
        stock.stockTestFullFillment();
        System.out.println(stock.getStock("Москва1"));
    }
}
