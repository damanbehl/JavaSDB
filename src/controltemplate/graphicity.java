package controltemplate;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.text.FontWeight;

public interface graphicity {
    /**
     * functional Template for creating gridpanes throughout the project
     */
    GridPane createGridpane(Pos object, int[] padding, int[] HVGap);

    void addHeaderLabel(GridPane gridPane, String labelTxt, String labelFont, int fontSize, int indices[]
            , HPos agn, int margin[], FontWeight fontWtObj);

    void addText(GridPane gridPane, String textCon, String labelFont, int fontSize, int indices[]
            , HPos agn, int margin[], FontWeight fontWtObj);
}
