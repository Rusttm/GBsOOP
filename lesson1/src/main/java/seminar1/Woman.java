package seminar1;

public class Woman extends HumanClass {
    private hSex sex = hSex.Female;
    public Woman(String hName) {
        super(hName);

    }

    public Woman() {

    }

    public hSex getSex() {
        return sex;
    }
}