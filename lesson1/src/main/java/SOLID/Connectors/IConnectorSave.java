package SOLID.Connectors;


/** Интерфейс для записи позиции в Базу данных
 * @param <T> Указывается объект "позиция"
 */
public interface IConnectorSave<T> {
    public default void save2DB(T entry) {
        // save position to DB
    }
}
