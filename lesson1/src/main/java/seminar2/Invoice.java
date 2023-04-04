package seminar2;

public class Invoice extends Document implements FinanceDocument{

    public Invoice() {

        Document newDoc = new Document();
    }

    @Override
    public Float sumDoc() {
        return null;
    }

    @Override
    public Float vatDoc() {
        return null;
    }


}
