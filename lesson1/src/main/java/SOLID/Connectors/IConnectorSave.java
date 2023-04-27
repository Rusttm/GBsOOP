package SOLID.Connectors;


/** Интерфейс для записи позиции в Базу данных
 * @param <T> Указывается продукт (объект)
 */
public interface IConnectorSave<T> {
    void save2DB(T prod);
}
