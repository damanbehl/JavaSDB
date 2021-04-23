package utility;

public class User {
    public final String name;
    public final String zodiac;
    public final String gender;
    public int HP;
    private int moveCounter;
    private boolean gameOver;

    public User(String name, String zodiac, String gender, int HP) {
        this.name = name;
        this.gender = gender;
        this.zodiac = zodiac;
        this.HP = HP;
        this.moveCounter = 0;
        this.gameOver = false;
    }

    public int getMoveCounter() {
        return this.moveCounter;
    }

    public void incrementMoveCounter() {
        this.moveCounter = this.moveCounter + 1;
    }

    public void setGameOver(boolean b) {
        this.gameOver = b;
    }

    public boolean getGameOver() {
        return this.gameOver;
    }
}
