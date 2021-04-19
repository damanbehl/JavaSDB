package graphical;
import  javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
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
        GridPane initialGrid =initializeGrid();
    }
    public GridPane initializeGrid(){
        GraphicalUtility ob = new GraphicalUtility();
        GridPane initialGrid = ob.createGridpane(Pos.TOP_CENTER, Constant.MAIN_SCREEN_PADDING, Constant.MAIN_SGRID_HVGAP);
        return  initialGrid;
    }
}
