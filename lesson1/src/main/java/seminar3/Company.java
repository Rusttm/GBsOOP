package seminar3;

/*
*
* класс Компания,
* который может быть и клиентом и юрлицом компании*/
public class Company {
    private int id;
    private String itn; // инн
    private String name;

    public Company(String itn, String name) {
        this.itn = itn;
        this.name = name;
        this.id++;
    }
    public Company() {
        new Company("1234567", "NonameCompany");
    }

    public String getItn() {
        return itn;
    }

    public String getName() {
        return name;
    }
}
