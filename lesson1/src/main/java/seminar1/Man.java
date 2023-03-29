package seminar1;

public class Man extends HumanClass{

    private hSex sex = hSex.Male;
    public Man(String hName, String hsName, int hAge) {
        this.setName(hName);
        this.setSurName(hsName);
        this.setAge(hAge);
        this.setHumanclassSex(String.valueOf(hSex.Male));
    }

    public Man() {
        this("NoName", "NoFamily", 0);
    }

    public hSex getSex() {
        return this.sex;
    }
}
