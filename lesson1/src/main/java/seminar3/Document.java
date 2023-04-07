package seminar3;

/*
* Абстрактный класс для создания документов
* в нем должны быть определены методы
* для даты и номера(имени)
**/

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Document {
    private int id;
    private String date;
    public abstract String getName(); // документ должен уметь выдать имя документа
    public abstract String getDate(); // документ должен уметь выдать дату
    public abstract void setDate(); // документ должен уметь установить дату
    public abstract void printDocument(); // документ должен иметь возможность печати

    public Document() {
        this.id += 1;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.date = dtf.format(now);
    }

    public int getId() {
        return id;
    }
}
