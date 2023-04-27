package SOLID.Connectors;

public class SaveProd2file implements IConnectorSave{
    @Override
    public void save2DB(Object entry) {
        IConnectorSave.super.save2DB(entry);
    }
}
