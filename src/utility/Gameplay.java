package utility;

import graphical.Actuator;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import obstacle.Dragon;
import obstacle.GenericObstacle;
import obstacle.WhiteWalker;

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
        ob.addUserInfoToPane(gridPane, u1, ob);
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

    public static void reachedWall(GridPane gridPane, GraphicalUtility ob, User u1, Stage primaryStage) {
        gridPane.getChildren().clear();
        ob.addUserInfoToPane(gridPane, u1, ob);
        ob.addText(gridPane, Constant.REACHED_WALL, "Arial", 15, Constant.CENTER_PROMPT, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        Button c1 = ob.addButton(gridPane, "DRINK ELIXIR", "Arial", 13, Constant.CHOI_BTN_ONE, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        Button c2 = ob.addButton(gridPane, "TAKE SWORD OF THE KINGS", "Arial", 13, Constant.CHOI_BTN_TWO, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        c1.setOnAction((ActionEvent) -> {
            u1.incrementMoveCounter();
            u1.drinkElixir();
            swordElixirTimeLine(gridPane, ob, u1, primaryStage);
        });
        c2.setOnAction((ActionEvent) -> {
            u1.incrementMoveCounter();
            u1.takeSwordOfKings();
            swordElixirTimeLine(gridPane, ob, u1, primaryStage);
        });
    }

    public static void swordElixirTimeLine(GridPane gridPane, GraphicalUtility ob, User u1, Stage primaryStage) {
        gridPane.getChildren().clear();
        ob.addUserInfoToPane(gridPane, u1, ob);
        String message = "";
        if (u1.doIHaveElixir()) {
            message = Constant.HAVE_ELIXIR;
        } else {
            message = Constant.HAVE_SWORD;
        }
        ob.addText(gridPane, message, "Arial", 15, Constant.CENTER_PROMPT, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        Button c1 = ob.addButton(gridPane, "GO TOWARDS WHITE WALKER", "Arial", 13, Constant.CHOI_BTN_ONE, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        Button c2 = ob.addButton(gridPane, "GO TOWARDS DRAGON", "Arial", 13, Constant.CHOI_BTN_TWO, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        c1.setOnAction((ActionEvent) -> {
            u1.incrementMoveCounter();
            encounterWW(gridPane, ob, u1, false, false, primaryStage);
        });
        c2.setOnAction((ActionEvent) -> {
            u1.incrementMoveCounter();
            encounterDragon(gridPane, ob, u1, false, false, primaryStage);
        });
    }

    public static void encounterWW(GridPane gridPane, GraphicalUtility ob, User u1, boolean isRepeat, boolean gameOver, Stage primaryStage) {
        WhiteWalker ww = new WhiteWalker();
        boolean canIDefeatWW = false;
        gridPane.getChildren().clear();
        ob.addUserInfoToPane(gridPane, u1, ob);
        String entityPossesed = "";
        if (u1.doIHaveElixir()) {
            entityPossesed = "Elixir of life";
        } else {
            entityPossesed = "You have the sword of the kings";
            canIDefeatWW = true;
        }
        String toSend = "";
        if (isRepeat == false) {
            toSend = Constant.WW_ATTACKED + ", you have the " + entityPossesed;
        } else {
            toSend = "The white walker is too strong, you have to use the weapon that kills the white walker\n you need either the sword of the kings or dragon glass";
        }
        ob.addText(gridPane, toSend, "Arial", 15, Constant.CENTER_PROMPT, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        Button c1 = ob.addButton(gridPane, "Attack with dagger", "Arial", 13, Constant.CHOI_BTN_ONE, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        Button c2 = ob.addButton(gridPane, "Attack with sword", "Arial", 13, Constant.CHOI_BTN_TWO, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        Button c3 = ob.addButton(gridPane, "Retreat", "Arial", 13, Constant.CHOI_BTN_THREE, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        c1.setOnAction((ActionEvent) -> {
            u1.incrementMoveCounter();
            ww.attackPlayerDagger(u1);
            if (u1.getGameOver()) {
                System.out.println("Endzone");
                endingSequence(gridPane, Constant.WW_ATTACKED, u1, ob, primaryStage);
            } else {
                encounterWW(gridPane, ob, u1, true, false, primaryStage);
            }
        });
        c2.setOnAction((ActionEvent) -> {
            u1.incrementMoveCounter();
            ww.attackPlayer(u1);
            if (!ww.isWWAlive()) {
                goToWinterfell(gridPane, ob, u1, false, false, primaryStage, "You killed the white walker,\n but was it really the last of them");
            } else {
                if (u1.getGameOver()) {
                    System.out.println("Endzone");
                    endingSequence(gridPane, Constant.WHITE_WALKER_KILLEDU, u1, ob, primaryStage);
                } else {
                    encounterWW(gridPane, ob, u1, true, false, primaryStage);
                }
            }
        });
        c3.setOnAction((ActionEvent) -> {
            u1.incrementMoveCounter();
            goToWinterfell(gridPane, ob, u1, false, false, primaryStage, "you retreated from the white walker, a wise choice");
        });
    }

    public static void encounterDragon(GridPane gridPane, GraphicalUtility ob, User u1, boolean isRepeat, boolean gameOver, Stage primaryStage) {
        Dragon ww = new Dragon();
        boolean canIDefeatDrogon = false;
        gridPane.getChildren().clear();
        ob.addUserInfoToPane(gridPane, u1, ob);
        String entityPossesed = "";
        if (u1.doIHaveElixir()) {
            entityPossesed = "Elixir of life";
            canIDefeatDrogon = true;
        } else {
            entityPossesed = "You have the sword of the kings";
        }
        String toSend = "";
        if (isRepeat == false) {
            toSend = Constant.DRAGON_ATTACKED + ", you have the " + entityPossesed;
        } else {
            toSend = "The Dragon is too strong, you\n you need the elixir of life or an army to defeat the dragon ";
        }
        ob.addText(gridPane, toSend, "Arial", 15, Constant.CENTER_PROMPT, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        Button c1 = ob.addButton(gridPane, "Attack", "Arial", 13, Constant.CHOI_BTN_ONE, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        Button c2 = ob.addButton(gridPane, "Retreat", "Arial", 13, Constant.CHOI_BTN_THREE, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        c1.setOnAction((ActionEvent) -> {
            u1.incrementMoveCounter();
            ww.breatheFire(u1);
            if (!ww.isDrogonAlive()) {
                u1.setDragonGlass();
                goToWinterfell(gridPane, ob, u1, false, false, primaryStage, "You killed the dragon and discovered a pile of dragon glass");
                System.out.println(u1.getDragonGlass());
            } else {
                if (u1.getGameOver()) {
                    System.out.println("Endzone");
                    endingSequence(gridPane, Constant.DRAGON_KILLEDU, u1, ob, primaryStage);
                } else {
                    encounterDragon(gridPane, ob, u1, true, false, primaryStage);
                }
            }


        });
        c2.setOnAction((ActionEvent) -> {
            u1.incrementMoveCounter();
            goToWinterfell(gridPane, ob, u1, false, false, primaryStage, "You retreated from the dragon, a wise choice");
        });
    }

    public static void goToWinterfell(GridPane gridPane, GraphicalUtility ob, User u1, boolean isRepeat, boolean gameOver, Stage primaryStage, String history) {
        gridPane.getChildren().clear();
        GenericObstacle go = new GenericObstacle();
        ob.addUserInfoToPane(gridPane, u1, ob);
        String message = "";
        if (isRepeat == false) {
            message = "You have reached Winterfell, previously\n " + history + "\n unfortunately, Winterfell your home is under attack\n what do you want to do next";
        } else {
            message = "You cannot defeat this army by your own";
        }
        ob.addText(gridPane, message, "Arial", 15, Constant.CENTER_PROMPT, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        Button c1 = ob.addButton(gridPane, "ATTACK", "Arial", 13, Constant.CHOI_BTN_ONE, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        Button c2 = ob.addButton(gridPane, "REGROUP AT THE WALL", "Arial", 13, Constant.CHOI_BTN_TWO, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        c1.setOnAction((ActionEvent) -> {
            u1.incrementMoveCounter();
            go.reduceHp(Constant.ARMY_DAMAGE, u1);
            if (u1.getGameOver()) {
                System.out.println("Endzone");
                endingSequence(gridPane, Constant.POOR_PLAY, u1, ob, primaryStage);
            } else {
                goToWinterfell(gridPane, ob, u1, true, false, primaryStage, "");
            }
        });
        c2.setOnAction((ActionEvent) -> {
            u1.incrementMoveCounter();
            regroupAtWall(gridPane, ob, u1, true, false, primaryStage);
        });
    }

    public static void regroupAtWall(GridPane gridPane, GraphicalUtility ob, User u1, boolean isRepeat, boolean gameOver, Stage primaryStage) {
        gridPane.getChildren().clear();
        ob.addUserInfoToPane(gridPane, u1, ob);
        ob.addText(gridPane, Constant.CONFLICT_BREAKOUT, "Arial", 17, Constant.CENTER_PROMPT, HPos.CENTER, Constant.TWENTY_MARGIN, FontWeight.BOLD);
        Button c1 = ob.addButton(gridPane, "Ally with Dornish", "Arial", 13, Constant.CHOI_BTN_ONE, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        Button c2 = ob.addButton(gridPane, "Ally with wildlings", "Arial", 13, Constant.CHOI_BTN_TWO, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        c1.setOnAction((ActionEvent) -> {
            u1.incrementMoveCounter();
            u1.setdornishAlly();
            alliedForces(gridPane, ob, u1, false, false, primaryStage);
        });
        c2.setOnAction((ActionEvent) -> {
            u1.incrementMoveCounter();
            u1.setwildlingAlly();
            alliedForces(gridPane, ob, u1, false, false, primaryStage);

        });
    }

    public static void alliedForces(GridPane gridPane, GraphicalUtility ob, User u1, boolean isRepeat, boolean gameOver, Stage primaryStage) {
        GenericObstacle go = new GenericObstacle();
        gridPane.getChildren().clear();
        ob.addUserInfoToPane(gridPane, u1, ob);
        String ally = u1.getdornishAlly() ? "Dornish" : "wildling";
        ob.addText(gridPane, "You chose wisely and allied up with" + ally, "Arial", 17, Constant.CENTER_PROMPT, HPos.CENTER, Constant.TWENTY_MARGIN, FontWeight.BOLD);
        Button c1 = ob.addButton(gridPane, "Attack" + (ally.equals("Dornish") ? "Wildlings" : "Dornish"), "Arial", 13, Constant.CHOI_BTN_ONE, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        Button c2 = ob.addButton(gridPane, "Negotiate", "Arial", 13, Constant.CHOI_BTN_TWO, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        c1.setOnAction((ActionEvent) -> {
            u1.incrementMoveCounter();
            go.reduceHp(Constant.ARMY_DAMAGE, u1);
            if (u1.getGameOver()) {
                System.out.println("Endzone");
                endingSequence(gridPane, Constant.POOR_PLAY, u1, ob, primaryStage);
            } else {
                dornishWildlingFiasco(gridPane, ob, u1, false, false, primaryStage, (ally.equals("Dornish") ? "Wildlings" : "Dornish"));
            }
        });
        c2.setOnAction((ActionEvent) -> {
            u1.incrementMoveCounter();
            dornishWildlingFiasco(gridPane, ob, u1, false, false, primaryStage, null);
        });
    }

    public static void dornishWildlingFiasco(GridPane gridPane, GraphicalUtility ob, User u1, boolean isRepeat, boolean gameOver, Stage primaryStage, String enemy) {
        GenericObstacle go = new GenericObstacle();
        gridPane.getChildren().clear();
        ob.addUserInfoToPane(gridPane, u1, ob);
        String message = enemy == null ? "No enemy you negotiated, a wise choice" : "you made an enemy out of" + enemy + "\n you have reached Winterfell";
        ob.addText(gridPane, message, "Arial", 15, Constant.CENTER_PROMPT, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        Button c1 = ob.addButton(gridPane, "Attack head on", "Arial", 13, Constant.CHOI_BTN_ONE, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        Button c2;
        if (u1.getDragonGlass()) {
            c2 = ob.addButton(gridPane, "Lead towards Dragon", "Arial", 13, Constant.CHOI_BTN_TWO, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        } else {
            c2 = ob.addButton(gridPane, "Lead towards white walkers", "Arial", 13, Constant.CHOI_BTN_TWO, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        }
        c1.setOnAction((ActionEvent) -> {
            u1.incrementMoveCounter();
            go.reduceHp(Constant.SWORD_DAMAGE, u1);
            if (u1.getGameOver()) {
                System.out.println("Endzone");
                endingSequence(gridPane, Constant.POOR_PLAY, u1, ob, primaryStage);
            } else {
                lannisterArmy(gridPane, ob, u1, primaryStage);
            }

        });
        c2.setOnAction((ActionEvent) -> {
            u1.incrementMoveCounter();
            lannisterArmy(gridPane, ob, u1, primaryStage);
        });
    }

    public static void lannisterArmy(GridPane gridPane, GraphicalUtility ob, User u1, Stage primaryStage) {
        GenericObstacle go = new GenericObstacle();
        gridPane.getChildren().clear();
        ob.addUserInfoToPane(gridPane, u1, ob);
        ob.addText(gridPane, "You took care of the invading army and reclaimed Winterfell", "Arial", 15, Constant.CENTER_PROMPT, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        Button c1 = ob.addButton(gridPane, "Attack white walkers", "Arial", 13, Constant.CHOI_BTN_ONE, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        Button c2;
        if (u1.getDragonGlass()) {
            c2 = ob.addButton(gridPane, "forge weapon out of dragon glass", "Arial", 13, Constant.CHOI_BTN_TWO, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        } else {
            c2 = ob.addButton(gridPane, "tame dragon to reinforce", "Arial", 13, Constant.CHOI_BTN_TWO, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        }
        Button c3 = ob.addButton(gridPane, "make allies out of " + (u1.getwildlingAlly() ? "dornish" : "wildlings"), "Arial", 13, Constant.CHOI_BTN_THREE, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        c1.setOnAction((ActionEvent) -> {
            u1.incrementMoveCounter();
            go.reduceHp(100, u1);
            endingSequence(gridPane, "You cannot attack the entire army of white walker\n you need more allies, \nYou have lost", u1, ob, primaryStage);

        });
        c2.setOnAction((ActionEvent) -> {
            u1.incrementMoveCounter();
            finalScene(gridPane, ob, u1, primaryStage, u1.getDragonGlass() ? "You forged weapons out of dragon glass" : "you tamed a dragon");
        });
        c3.setOnAction((ActionEvent) -> {
            u1.incrementMoveCounter();
            finalScene(gridPane, ob, u1, primaryStage, "You made allies out of " + (u1.getdornishAlly() ? "wildlings" : "dornish"));
        });

    }

    public static void finalScene(GridPane gridPane, GraphicalUtility ob, User u1, Stage primaryStage, String history) {
        gridPane.getChildren().clear();
        ob.addUserInfoToPane(gridPane, u1, ob);
        ob.addText(gridPane, "Previously "+ history, "Arial", 15, Constant.CENTER_PROMPT, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        Button c1 = ob.addButton(gridPane, "Attack white walkers", "Arial", 13, Constant.CHOI_BTN_ONE, HPos.CENTER, Constant.ZERO_PADDING, FontWeight.BLACK);
        c1.setOnAction((ActionEvent) -> {
            u1.incrementMoveCounter();
            endingSequence(gridPane, "Congratualtions on defeating the army of the dead, \nhave a good day", u1, ob, primaryStage);

        });
    }

}
