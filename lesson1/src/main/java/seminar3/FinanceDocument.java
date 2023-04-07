package seminar3;

/*
* Интерфейс для финансовых документов
* которые должны иметь сумму документа и сумму налога
* а также организацию -владельца документа
*
* */
public interface FinanceDocument {

    Double sumDoc(); // должен выдавать сумму документа
    Double vatDoc(); // финансовый документ должен выдавать сумму налога
    Company getOwner(); // финансовый документ должен выдавать организацию от которой он инициирован


}
