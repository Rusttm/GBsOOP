package seminar2;

/*
* Интерфейс для финансовых документов
* которые должны иметь сумму документа и сумму налога
*
* */
public interface FinanceDocument {
    public  Double sumDoc();
    public  Double vatDoc();

}
