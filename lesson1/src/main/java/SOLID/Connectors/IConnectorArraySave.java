package SOLID.Connectors;

/** Интерфейс для записи списка позиций в Базу данных
 * @param <V> любой  список(объект)
 */
public interface IConnectorArraySave<V> {
    void saveArray2DB(V prodList);
}
