package seminar2;

/*
* Интерфейс для финансовых документов
* которые должны иметь сумму документа и сумму налога
* а также организацию -владельца документа
*
* */
public interface FinanceDocument {

    Double sumDoc();
    Double vatDoc();
    Company getOwner();


}
