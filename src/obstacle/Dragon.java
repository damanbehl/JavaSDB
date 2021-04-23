package obstacle;

import controltemplate.Obstacle;

public class Dragon implements Obstacle {
    public int breatheFire(){
        return 0;
    }
    public void die(){

    }

    @Override
    public int attackPlayer() {
        return 0;
    }
}
