package obstacle;

import controltemplate.Obstacle;
import utility.User;

public class Dragon implements Obstacle {
    private int dragonHP;
    public Dragon(){
        this.dragonHP = 125;
    }
    public User breatheFire(User u1) {
        u1.HP = u1.HP - 25;
        this.dragonHP = this.dragonHP - 25;
        if (u1.HP <= 0) {
            u1.setGameOver(true);
        }
        return u1;
    }

    public void die() {

    }

    @Override
    public int attackPlayer() {
        return 0;
    }
}
