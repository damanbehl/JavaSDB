package utility;

public class User {
    public final String name;
    public final String zodiac;
    public final String gender;
    public int HP;
    private int moveCounter;
    private boolean gameOver;
    private boolean swordOfKings;
    private boolean elixirOfLife;
    private boolean dragonGlass;

    public User(String name, String zodiac, String gender, int HP) {
        this.name = name;
        this.gender = gender;
        this.zodiac = zodiac;
        this.HP = HP;
        this.moveCounter = 1;
        this.gameOver = false;
        this.elixirOfLife = false;
        this.swordOfKings = false;
        this.dragonGlass = false;
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
    public void drinkElixir(){
        this.elixirOfLife = true;
    }
    public void takeSwordOfKings(){
        this.swordOfKings = true;
    }
    public boolean doIHaveElixir(){
        return elixirOfLife;
    }
    public boolean doIHvSwordOfKings(){
        return swordOfKings;
    }
    public void setDragonGlass(){
        this.dragonGlass = true;
    }
}
