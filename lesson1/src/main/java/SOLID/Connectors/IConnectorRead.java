package SOLID.Connectors;

/** Интерфейс для чтения данных из Базы данных
 * @return <T> возвращает объект класса Т
 */
public interface IConnectorRead<T> {

    public default T loadFromDB() {
        // load and return data from file
        return null;
    }
}
