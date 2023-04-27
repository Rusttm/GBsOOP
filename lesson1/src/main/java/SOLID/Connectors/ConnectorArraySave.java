package SOLID.Connectors;

import SOLID.Models.ProdCreate;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/** класс для записи списка из ProdCreate
 * @param <V> список
 */
public class ConnectorArraySave<V extends ArrayList<ProdCreate>> implements IConnectorArraySave<V> {
    String fileName = "SolidDB.txt";
    /**метод для записи списка
     * @param prodList список
     */
    @Override
    public void saveArray2DB(V prodList) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(this.fileName), StandardCharsets.UTF_8))) {
            for (ProdCreate prodOb : prodList) {
                writer.write(prodOb.getProd().toString() + "\n");
            }
        }
        catch (IOException ex) {
        }

    }
}

