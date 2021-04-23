package obstacle;

import utility.User;

public class GenericObstacle extends ObstacleParent {
    @Override
    public User reduceHp(int reduceBy, User u1){
        u1.HP = u1.HP- reduceBy;
        if(u1.HP <=0){
            u1.setGameOver(true);
        }
        return u1;
    }
}
