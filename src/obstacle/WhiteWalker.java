package obstacle;

import utility.Constant;
import utility.User;

public class WhiteWalker extends NaturalDisaster{
    private boolean isWWAlive;
    public WhiteWalker(){
        this.isWWAlive = true;
    }
    @Override
    public User attackPlayerDagger(User u1) {
        u1.HP = u1.HP - Constant.WHITE_WALKER_DAMAGE;
        if (u1.HP <= 0) {
            u1.setGameOver(true);
        }
        return u1;
    }

    @Override
    public User attackPlayer(User u1) {
        if(u1.doIHvSwordOfKings()){
            this.isWWAlive = false;
            return u1;
        }
        u1.HP = u1.HP - Constant.WHITE_WALKER_DAMAGE;
        if (u1.HP <= 0) {
            u1.setGameOver(true);
        }
        return u1;
    }
    public boolean isWWAlive(){
        return this.isWWAlive;
    }
}
