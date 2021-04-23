package obstacle;

import utility.User;

public class GenericObstacle extends ObstacleParent {
    @Override
    public User reduceHp(int reuceBy, User u1){
        u1.HP = u1.HP- reuceBy;
        return u1;
    }
}
