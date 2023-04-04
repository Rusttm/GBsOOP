package seminar2;

/*
* Абстрактный класс для создания документов
*
**/

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Document {
    private int id;
    private String date;
    public Document() {
        this.id += 1;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.date = dtf.format(now);
    }

    public String getDate() {
        return date;
    }

    public int getId() {
        return id;
    }
}
