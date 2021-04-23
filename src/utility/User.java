package utility;

public class User {
    public final String name;
    public final String zodiac;
    public final String gender;
    public int HP;

    public User(String name, String zodiac, String gender, int HP) {
        this.name = name;
        this.gender = gender;
        this.zodiac = zodiac;
        this.HP = HP;
    }
}
