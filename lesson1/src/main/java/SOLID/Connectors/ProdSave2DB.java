package SOLID.Connectors;

import SOLID.Models.ProdCreate;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ProdSave2DB<T extends ProdCreate> implements IConnectorSave<T> {
    public ProdSave2DB() {
    }
    String fileName = "SolidDB.txt";

    @Override
    public void save2DB(T prod) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(this.fileName), StandardCharsets.UTF_8))) {
                writer.write(prod.getProd().toString() + "\n");
        }
        catch (IOException ex) {
        }
    }
}
