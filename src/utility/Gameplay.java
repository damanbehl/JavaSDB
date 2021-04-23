package utility;

import graphical.Actuator;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import obstacle.GenericObstacle;

public class Gameplay {
    public static GridPane startJourney(GridPane gridPane, GraphicalUtility ob, User u1, boolean isRepeat, boolean gameOver, Stage primaryStage) {
        if (gameOver) {
            return gridPane;
        }
        GenericObstacle go = new GenericObstacle();
        int indiceCO[] = {2, 5, 6, 6};

        gridPane.getChildren().clear();
        ob.addUserInfoToPane(gridPane, u1, ob);
        String tCon = "Hi " + u1.name + " you are the exiled son of the King of Winterfell\n You have been banished to the great Wall Up north\nYou have an initial HP of:" + u1.HP +
                "\nYou have a long road ahead of you, \nbeware this conquest is not for the faint of heart" +
                "\n You have the following choices";
        String toSend = "";
        if (isRepeat == false) {
            toSend = tCon;
        } else {
            toSend = "You tried to escape your fate a sword damage was dealt to you";
        }
        ob.addText(gridPane, toSend, "Arial", 17, indiceCO, HPos.CENTER, Constant.TWENTY_MARGIN, FontWeight.BOLD);
        Button c1 = ob.addButton(gridPane, "GO TO THE WALL", "Arial", 13, Constant.CHOI_BTN_ONE, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        Button c2 = ob.addButton(gridPane, "Contest Decision", "Arial", 13, Constant.CHOI_BTN_TWO, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        c1.setOnAction((ActionEvent) -> {
            u1.incrementMoveCounter();
            goToWall(gridPane, ob, u1);
        });
        c2.setOnAction((ActionEvent) -> {
            u1.incrementMoveCounter();
            go.reduceHp(Constant.SWORD_DAMAGE, u1);
            if (u1.getGameOver()) {
                System.out.println("endzone");
                endingSequence(gridPane, Constant.POOR_PLAY, u1, ob, primaryStage);
            } else {
                startJourney(gridPane, ob, u1, true, false, primaryStage);
            }
        });
        return gridPane;
    }

    public static void goToWall(GridPane gridPane, GraphicalUtility ob, User u1) {

    }

    public static void endingSequence(GridPane gridPane, String message, User u1, GraphicalUtility ob, Stage primaryStage) {
        gridPane.getChildren().clear();
        ob.addHeaderLabel(gridPane, Constant.G_OVER, "Arial", 19, Constant.INTRO_INSETS, HPos.CENTER, Constant.TWENTY_MARGIN, FontWeight.BOLD);
        ob.addText(gridPane, message, "Arial", 15, Constant.CENTER_PROMPT, HPos.CENTER, Constant.TWENTY_MARGIN, FontWeight.BLACK);
        Button b1 = ob.addButton(gridPane, "Play Again", "Arial", 14, Constant.CENTER_BTN, HPos.CENTER, Constant.TWENTY_MARGIN, FontWeight.NORMAL);
        b1.setOnAction((ActionEvent) -> {
            Actuator a1 = new Actuator();
            a1.wrapperLauncher(primaryStage);
        });
    }
}
