package SOLID.Models;

/**
 * Интерфейс создания нового продукта
 */
public interface IModelCreate<T> {
    T newObject();
}
