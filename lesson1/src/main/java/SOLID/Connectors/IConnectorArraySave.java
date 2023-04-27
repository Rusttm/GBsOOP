package SOLID.Connectors;

/** Интерфейс для записи списка позиций в Базу данных
 * @param <ArrayList> список
 */
public interface IConnectorArraySave<V> {
    void saveArray2DB(V prodList);
}
