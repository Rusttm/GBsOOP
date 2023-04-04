package seminar2;

/*
* Абстрактный класс для создания документов
*
**/

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Document {
    private int id;
    private String date;
    public abstract String getDate();
    public abstract void setDate();

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
