package utility;

import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.FontWeight;
import obstacle.GenericObstacle;

public class Gameplay {
    public static GridPane startJourney(GridPane gridPane, GraphicalUtility ob, User u1) {
        GenericObstacle go = new GenericObstacle();
        int indiceCO[] = {1, 5, 6, 6};

        gridPane.getChildren().clear();
        String tCon = "Hi " + u1.name + " you are the exiled son of the King of Winterfell\n You have been banished to the great Wall Up north\nYou have an initial HP of:" + u1.HP +
                "\nYou have a long road ahead of you, \nbeware this conquest is not for the faint of heart" +
                "\n You have the following choices";
        ob.addText(gridPane, tCon, "Arial", 17, indiceCO, HPos.CENTER, Constant.TWENTY_MARGIN, FontWeight.BOLD);
        Button c1 = ob.addButton(gridPane, "GO TO THE WALL", "Arial", 13, Constant.CHOI_BTN_ONE, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        Button c2 = ob.addButton(gridPane, "Contest Decision", "Arial", 13, Constant.CHOI_BTN_TWO, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        c1.setOnAction((ActionEvent) -> {

        });
        c2.setOnAction((ActionEvent) -> {
            go.reduceHp(Constant.SWORD_DAMAGE, u1);
        });
        return gridPane;
    }
}
