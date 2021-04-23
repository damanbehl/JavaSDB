package controltemplate;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Window;
import utility.GraphicalUtility;
import utility.User;

public interface Graphicity {
    /**
     * functional Template for creating gridpanes throughout the project
     */
    GridPane createGridpane(Pos object, int[] padding, int[] HVGap);

    Label addHeaderLabel(GridPane gridPane, String labelTxt, String labelFont, int fontSize, int indices[]
            , HPos agn, int margin[], FontWeight fontWtObj);

    Text addText(GridPane gridPane, String textCon, String labelFont, int fontSize, int indices[]
            , HPos agn, int margin[], FontWeight fontWtObj);

    Button addButton(GridPane gridPane, String btnTxt, String labelFont, int fontSize, int indices[]
            , HPos agn, int margin[], FontWeight fontWtObj);

    void showAlert(Alert.AlertType alertType, Window owner, String title, String message);

    TextField addTextField(GridPane gd, String text, String fontName, int fontSize, int indices[], int margin[], int prefWidth);

    RadioButton addRadioButton(GridPane gridPane, String btnTxt, String labelFont, int fontSize, int indices[]
            , HPos agn, int margin[], FontWeight fontWtObj, ToggleGroup tg);

    void addUserInfoToPane(GridPane gridPane, User u1, GraphicalUtility ob);
}
