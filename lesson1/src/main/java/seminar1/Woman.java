package seminar1;

public class Woman extends HumanClass {
    private hSex sex = hSex.Female;

    public Woman(String hName, String hsName, int hAge) {
        super(hName, hsName, hAge);
        this.setHumanclassSex(String.valueOf(hSex.Female));

    }

    public Woman(String hName) {
        super(hName);
        this.setHumanclassSex(String.valueOf(hSex.Female));

    }

    public Woman() {

    }

    public hSex getSex() {
        return sex;
    }
}
