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
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Java and the seven deadly sins!");
        GridPane initialGrid = initializeGrid();
        addContent(initialGrid);
        Scene scene = cueFirstScene(initialGrid);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public GridPane initializeGrid() {
        GraphicalUtility ob = new GraphicalUtility();
        GridPane initialGrid = ob.createGridpane(Pos.TOP_CENTER, Constant.MAIN_SCREEN_PADDING, Constant.MAIN_SGRID_HVGAP);
        return initialGrid;
    }

    public void addContent(GridPane gridPane) {
        Label headerLabel = new Label("Java and the seven deadly sins!");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        gridPane.add(headerLabel, 0, 0, 5, 1);
        gridPane.setHalignment(headerLabel, HPos.CENTER);
        gridPane.setMargin(headerLabel, new Insets(0, 0, 0, 0));
    }
    public Scene cueFirstScene(GridPane initialGrid){
        Scene scene = new Scene(initialGrid, 800, 500);
        BackgroundImage myBI = new BackgroundImage(new Image("file:src/img/java.png", 800, 500, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
        initialGrid.setBackground(new Background(myBI));
        return  scene;
    }
}
