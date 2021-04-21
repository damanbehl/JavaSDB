package utility;

import javafx.geometry.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import controltemplate.graphicity;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Window;

public class GraphicalUtility implements graphicity {
    /**
     * @param ob      : Pos object with alignment coming from a different class
     * @param padding : an int array with padding for gridpane in the following order top, right bottom left
     * @return: returns gridPane with configuration according to parameters
     */
    @Override
    public GridPane createGridpane(Pos ob, int[] padding, int[] HVGap) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(ob);
        gridPane.setPadding(new Insets(padding[0], padding[1], padding[2], padding[3]));
        gridPane.setHgap(HVGap[0]);
        gridPane.setVgap(HVGap[1]);
        //TODO: CODE FOR CONDITIONAL COLUMN CONSTRAINTS
        return gridPane;
    }

    /**
     * @param gridPane:  gridpane on which we want to add the label
     * @param labelTxt:  self explanatory
     * @param labelFont: self explanatory
     * @param fontSize:  self explanatory
     * @param indices:   top right bottom left is the order of the insets
     * @param agn:       alignment with respect to
     * @param margin:    margins around the label
     * @param fontWtObj: fontWeight object
     * @return : returns the modified gridpane
     */
    @Override
    public void addHeaderLabel(GridPane gridPane, String labelTxt, String labelFont, int fontSize, int indices[]
            , HPos agn, int margin[], FontWeight fontWtObj) {
        Label genericLabel = new Label(labelTxt);
        genericLabel.setFont(Font.font(labelFont, fontWtObj, fontSize));
        gridPane.add(genericLabel, indices[0], indices[1], indices[2], indices[3]);
        gridPane.setHalignment(genericLabel, agn.CENTER);
        gridPane.setMargin(genericLabel, new Insets(margin[0], margin[1], margin[2], margin[3]));

    }
//    @Override
//    public GridPane addText(GridPane gridPane, String textCon, String labelFont, int fontSize, int indices[]
//            , HPos agn, int margin[], FontWeight fontWtObj) {
//        Text genericText = new Text(textCon);
//        genericText.setFont(Font.font(labelFont, fontWtObj, fontSize));
//        gridPane.add(genericText, indices[0], indices[1], indices[2], indices[3]);
//        gridPane.setHalignment(genericText, agn.CENTER);
//        gridPane.setMargin(genericText, new Insets(margin[0], margin[1], margin[2], margin[3]));
//        return gridPane;
//    }

    @Override
    public void addText(GridPane gridPane, String textCon, String labelFont, int fontSize, int indices[]
            , HPos agn, int margin[], FontWeight fontWtObj) {
        Text genericText = new Text(textCon);
        genericText.setTextAlignment(TextAlignment.CENTER);
        genericText.setFont(Font.font(labelFont, fontWtObj, fontSize));
        gridPane.add(genericText, indices[0], indices[1], indices[2], indices[3]);
        gridPane.setHalignment(genericText, agn.CENTER);
        gridPane.setMargin(genericText, new Insets(margin[0], margin[1], margin[2], margin[3]));
//        return gridPane;
    }

    public void addButton(GridPane gridPane, String btnTxt, String labelFont, int fontSize, int indices[]
            , HPos agn, int margin[], FontWeight fontWtObj){
        Button genericButton = new Button(btnTxt);
        genericButton.setFont(Font.font(labelFont, fontWtObj, fontSize));
        gridPane.add(genericButton, 1,10,3,1);
        gridPane.setHalignment(genericButton, HPos.CENTER);
        gridPane.setMargin(genericButton, new Insets(0, 0,0,0));
        genericButton.setOnAction((ActionEvent) -> {
            showAlert(Alert.AlertType.INFORMATION, gridPane.getScene().getWindow(), "Information","Maximum number of workshops\n" +
                    "reached.");
        });
    }
    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message){
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();

    }
//    public GridPane addBackgroundMusic(GridPane gridPane){
//        return gridPane;
//    }
}
