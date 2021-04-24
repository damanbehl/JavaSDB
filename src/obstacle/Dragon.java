package obstacle;

import controltemplate.Obstacle;
import utility.User;

public class Dragon implements Obstacle {
    private int dragonHP;
    private boolean isDragonAlive;
    public Dragon(){
        this.dragonHP = 125;
        isDragonAlive = true;
    }
    public User breatheFire(User u1) {
        if(u1.doIHaveElixir()){
            isDragonAlive = false;
            return u1;
        }
        u1.HP = u1.HP - 25;
        this.dragonHP = this.dragonHP - 25;
        if(this.dragonHP<=0){
            isDragonAlive = false;
            return u1;
        }
        if (u1.HP <= 0) {
            u1.setGameOver(true);
        }
        return u1;
    }

    public void die() {

    }
    public boolean isDrogonAlive(){
        return this.isDragonAlive;
    }
    @Override
    public int attackPlayer() {
        return 0;
    }
}
