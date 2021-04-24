package obstacle;

import controltemplate.Obstacle;
import utility.User;

public abstract class NaturalDisaster implements Obstacle {
    public abstract User attackPlayer(User u1);
    @Override
    public int attackPlayer(){
        return 0;
    }
    public abstract User attackPlayerDagger(User u1);
}
