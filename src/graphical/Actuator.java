package graphical;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;
import utility.*;

public class Actuator extends Application {
    private static String name;
    private static String zodiac;
    private static String gender;
    private static int moveCounter;
    private static int HP = Constant.INITIAL_HP;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Ice and Fire");
        GraphicalUtility ob = new GraphicalUtility();
        GridPane initialGrid = initializeGrid(ob);
//        initialGrid.setGridLinesVisible(true);
        addContent(initialGrid);
        Scene scene = cueFirstScene(initialGrid, ob);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public GridPane initializeGrid(GraphicalUtility ob) {
        GridPane initialGrid = ob.createGridpane(Pos.TOP_CENTER, Constant.ZERO_PADDING, Constant.MAIN_SGRID_HVGAP);
        return initialGrid;
    }

    public void addContent(GridPane gridPane) {
        Label headerLabel = new Label("Ice and Fire");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        gridPane.add(headerLabel, 1, 2, 5, 1);
        gridPane.setHalignment(headerLabel, HPos.CENTER);
        gridPane.setMargin(headerLabel, new Insets(0, 0, 0, 0));
    }

    public Scene cueFirstScene(GridPane initialGrid, GraphicalUtility ob) {
        Scene scene = new Scene(initialGrid, 800, 500);
        BackgroundImage myBI = new BackgroundImage(new Image("file:src/img/lighter.jpeg", 800, 500, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
        initialGrid.setBackground(new Background(myBI));
        Button bb = new Button("Start Game");
        bb.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        initialGrid.add(bb, 4, 10, 3, 1);
        initialGrid.setHalignment(bb, HPos.CENTER);
        initialGrid.setMargin(bb, new Insets(0, 0, 0, 0));
        bb.setOnAction((ActionEvent) -> {
            initiateGame(initialGrid, ob);
        });
        return scene;
    }

    public void initiateGame(GridPane gridPane, GraphicalUtility ob) {
        int insets[] = {2, 4, 2, 2};
        int innsetsTxt[] = {2, 6, 2, 2};
        int insetTxtNom[] = {3, 8, 1, 1};
        int insetNmLbl[] = {1, 8, 1, 1};
        int insetGTag[] = {1, 9, 1, 1};
        int insetRdBtn[] = {2, 9, 1, 1};
        int insetRdBtn2[] = {3, 9, 1, 1};
        int insetRdBtn3[] = {4, 9, 1, 1};
        int insetZodiac[] = {1, 10, 1, 1};
        int insetZodiacFld[] = {3, 10, 1, 1};
        int insetsBtn[] = {3, 11, 1, 1};

        gridPane.getChildren().clear();
        Label headerLabel = ob.addHeaderLabel(gridPane, Constant.INTRO_MSG, "Arial", 20, insets,
                HPos.CENTER, Constant.TWENTY_MARGIN, FontWeight.EXTRA_BOLD);

        ob.addText(gridPane, Constant.INTRO_PROMPT, "Arial", 18, innsetsTxt,
                HPos.CENTER, Constant.TWENTY_MARGIN, FontWeight.LIGHT);

        ob.addText(gridPane, Constant.NAME_LABEL, "Arial", 15, insetNmLbl,
                HPos.CENTER, Constant.ZERO_PADDING, FontWeight.LIGHT);

        TextField name = ob.addTextField(gridPane, Constant.NAME_PHOLD, "Arial", 12, insetTxtNom, Constant.ZERO_PADDING, 40);

        ob.addText(gridPane, Constant.GENDER_LABEL, "Arial", 15, insetGTag,
                HPos.CENTER, Constant.TWENTY_MARGIN, FontWeight.LIGHT);
        ToggleGroup tg = new ToggleGroup();
        ob.addRadioButton(gridPane, Constant.MALE, "Arial", 15, insetRdBtn,
                HPos.CENTER, Constant.TWENTY_MARGIN, FontWeight.BOLD, tg);
        ob.addRadioButton(gridPane, Constant.FEMALE, "Arial", 15, insetRdBtn2,
                HPos.CENTER, Constant.TWENTY_MARGIN, FontWeight.BOLD, tg);
        ob.addRadioButton(gridPane, Constant.OTHER, "Arial", 15, insetRdBtn3,
                HPos.CENTER, Constant.TWENTY_MARGIN, FontWeight.EXTRA_BOLD, tg);
        ob.addText(gridPane, Constant.ZODIAC, "Arial", 15, insetZodiac,
                HPos.CENTER, Constant.TWENTY_MARGIN, FontWeight.LIGHT);
        TextField zodiac = ob.addTextField(gridPane, Constant.ZODIAC_PHOLD, "Arial", 12, insetZodiacFld, Constant.ZERO_PADDING, 40);
        Button submit = ob.addButton(gridPane, Constant.SUB_BTN_TXT, "Arial", 15, insetsBtn,
                HPos.CENTER, Constant.TWENTY_MARGIN, FontWeight.LIGHT);
        submit.setOnAction((ActionEvent) -> {
            setClassAttrib(gridPane, name, zodiac, tg, ob);
        });
    }

    public static void setClassAttrib(GridPane gridPane, TextField name, TextField zodiac, ToggleGroup tg, GraphicalUtility ob) {
        RadioButton selected = (RadioButton) tg.getSelectedToggle();
        if (selected == null || name == null || zodiac == null) {
            if (selected == null) {
                ob.showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Error", "No gender selected");
            } else if (name == null) {
                ob.showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Error", "No Name entered");
            } else {
                ob.showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Error", "No Zodiac entered");
            }

        } else {
            User u1 = new User(name.getText(), zodiac.getText(), selected.getText(), HP);
            Actuator.name = name.getText();
            Actuator.zodiac = zodiac.getText();
            Actuator.gender = selected.getText();
            System.out.println("class attributes set");
            Gameplay.startJourney(gridPane, ob, u1);
        }
    }




}
