package utility;

import graphical.Actuator;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import obstacle.Dragon;
import obstacle.GenericObstacle;

public class Gameplay {
    public static void startJourney(GridPane gridPane, GraphicalUtility ob, User u1, boolean isRepeat, boolean gameOver, Stage primaryStage) {
        if (gameOver) {
            return;
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
            goToWall(gridPane, ob, u1, false, false, primaryStage);
        });
        c2.setOnAction((ActionEvent) -> {
            u1.incrementMoveCounter();
            go.reduceHp(Constant.SWORD_DAMAGE, u1);
            if (u1.getGameOver()) {
                System.out.println("Endzone");
                endingSequence(gridPane, Constant.POOR_PLAY, u1, ob, primaryStage);
            } else {
                startJourney(gridPane, ob, u1, true, false, primaryStage);
            }
        });
    }

    public static void goToWall(GridPane gridPane, GraphicalUtility ob, User u1, boolean isRepeat, boolean gameOver, Stage primaryStage) {
        if (gameOver) {
            return;
        }
        Dragon drogon = new Dragon();
        gridPane.getChildren().clear();
        ob.addUserInfoToPane(gridPane, u1, ob);
        String toSend = "";
        if (isRepeat == false) {
            toSend = Constant.IN_BW_WALL;
        } else {
            toSend = "You tried to attack the dragon with more HP than you\n the dragon attacked you with fire\n" +
                    "maybe you need a drink or a potion :)";
        }
        ob.addText(gridPane, toSend, "Arial", 15, Constant.CENTER_PROMPT, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        Button c1 = ob.addButton(gridPane, "EVADE", "Arial", 13, Constant.CHOI_BTN_ONE, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        Button c2 = ob.addButton(gridPane, "ATTACK", "Arial", 13, Constant.CHOI_BTN_TWO, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        c1.setOnAction((ActionEvent) -> {
            u1.incrementMoveCounter();
            reachedWall(gridPane, ob, u1, primaryStage);
        });
        c2.setOnAction((ActionEvent) -> {
            u1.incrementMoveCounter();
            drogon.breatheFire(u1);
            if (u1.getGameOver()) {
                System.out.println("Endzone");
                endingSequence(gridPane, Constant.DRAGON_KILLEDU, u1, ob, primaryStage);
            } else {
                goToWall(gridPane, ob, u1, true, false, primaryStage);
            }
        });

    }

    public static void endingSequence(GridPane gridPane, String message, User u1, GraphicalUtility ob, Stage primaryStage) {
        gridPane.getChildren().clear();
        ob.addHeaderLabel(gridPane, Constant.G_OVER, "Arial", 19, Constant.G_OVER_INSETS, HPos.RIGHT, Constant.ZERO_PADDING, FontWeight.BOLD);
        ob.addText(gridPane, message, "Arial", 15, Constant.CENTER_PROMPT, HPos.CENTER, Constant.TWENTY_MARGIN, FontWeight.BLACK);
        ob.addText(gridPane, "Name:" + u1.name, "Arial", 14, Constant.REPORT_NAME, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        ob.addText(gridPane, "Zodiac:" + u1.zodiac, "Arial", 14, Constant.REPORT_ZODIAC, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        ob.addText(gridPane, "No of moves:" + u1.getMoveCounter(), "Arial", 14, Constant.REPORT_MOVES, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);

        Button b1 = ob.addButton(gridPane, "Play Again", "Arial", 14, Constant.CENTER_BTN, HPos.CENTER, Constant.TWENTY_MARGIN, FontWeight.NORMAL);
        b1.setOnAction((ActionEvent) -> {
            Actuator a1 = new Actuator();
            a1.wrapperLauncher(primaryStage);
        });
    }
    public static void reachedWall(GridPane gridPane, GraphicalUtility ob, User u1, Stage primaryStage){
        gridPane.getChildren().clear();
        ob.addUserInfoToPane(gridPane, u1, ob);
    }
}
