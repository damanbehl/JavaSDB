package utility;

import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import controltemplate.Graphicity;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Window;

public class GraphicalUtility implements Graphicity {
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
     * @return : returns applied label
     */
    @Override
    public Label addHeaderLabel(GridPane gridPane, String labelTxt, String labelFont, int fontSize, int indices[]
            , HPos agn, int margin[], FontWeight fontWtObj) {
        Label genericLabel = new Label(labelTxt);
        genericLabel.setFont(Font.font(labelFont, fontWtObj, fontSize));
        gridPane.add(genericLabel, indices[0], indices[1], indices[2], indices[3]);
        gridPane.setHalignment(genericLabel, agn);
        gridPane.setMargin(genericLabel, new Insets(margin[0], margin[1], margin[2], margin[3]));
        return genericLabel;

    }
//    @Override
//    public GridPane addText(GridPane gridPane, String textCon, String labelFont, int fontSize, int indices[]
//            , HPos agn, int margin[], FontWeight fontWtObj) {
//        Text genericText = new Text(textCon);
//        genericText.setFont(Font.font(labelFont, fontWtObj, fontSize));
//        gridPane.add(genericText, indices[0], indices[1], indices[2], indices[3]);
//        gridPane.setHalignment(genericText, agn);
//        gridPane.setMargin(genericText, new Insets(margin[0], margin[1], margin[2], margin[3]));
//        return gridPane;
//    }

    /**
     *
     * @param gridPane: gridpane on which we want to add the label
     * @param textCon:  text content
     * @param labelFont: text font
     * @param fontSize: font size
     * @param indices: gridpane indices
     * @param agn: alignment obj
     * @param margin: margin values
     * @param fontWtObj:
     * @return returns created Text component
     */
    @Override
    public Text addText(GridPane gridPane, String textCon, String labelFont, int fontSize, int indices[]
            , HPos agn, int margin[], FontWeight fontWtObj) {
        Text genericText = new Text(textCon);
        genericText.setTextAlignment(TextAlignment.CENTER);
        genericText.setFont(Font.font(labelFont, fontWtObj, fontSize));
        gridPane.add(genericText, indices[0], indices[1], indices[2], indices[3]);
        gridPane.setHalignment(genericText, agn);
        gridPane.setMargin(genericText, new Insets(margin[0], margin[1], margin[2], margin[3]));
        return genericText;
    }
    /**
     *
     * @param gridPane: gridpane on which we want to add the label
     * @param btnTxt:  text content
     * @param labelFont: text font
     * @param fontSize: font size
     * @param indices: gridpane indices
     * @param agn: alignment obj
     * @param margin: margin values
     * @param fontWtObj:
     * @return returns created button component
     */
    @Override
    public Button addButton(GridPane gridPane, String btnTxt, String labelFont, int fontSize, int indices[]
            , HPos agn, int margin[], FontWeight fontWtObj) {
        Button genericButton = new Button(btnTxt);
        genericButton.setFont(Font.font(labelFont, fontWtObj, fontSize));
        gridPane.add(genericButton, indices[0], indices[1], indices[2], indices[3]);
        gridPane.setHalignment(genericButton, agn);
        gridPane.setMargin(genericButton, new Insets(margin[0], margin[1], margin[2], margin[3]));
        return genericButton;
    }

    /**
     *
     * @param alertType: Alert class object for error, info or none
     * @param owner: Owner of the window in which we want to apply
     * @param title: title of the
     * @param message: message that we want to display
     */
    @Override
    public void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    /**
     *
     * @param gd
     * @param text
     * @param fontName
     * @param fontSize: font size of textfield
     * @param indices: grid indices of TF
     * @param margin: margins around TF
     * @param prefWidth : preferred width of textfield
     * @return created textField object
     */
    @Override
    public TextField addTextField(GridPane gd, String text, String fontName, int fontSize, int indices[], int margin[], int prefWidth) {
        TextField retObj = new TextField();
        retObj.setPromptText(text);
        retObj.setFocusTraversable(false);
        retObj.setFont(Font.font(fontName, FontWeight.EXTRA_LIGHT, fontSize));
        retObj.setPrefWidth(prefWidth);
        gd.add(retObj, indices[0], indices[1], indices[2], indices[3]);
        gd.setMargin(retObj, new Insets(margin[0], margin[1], margin[2], margin[3]));
        return retObj;
    }

    //    public GridPane addBackgroundMusic(GridPane gridPane){
//        return gridPane;
//    }
    @Override
    public RadioButton addRadioButton(GridPane gridPane, String btnTxt, String labelFont, int fontSize, int indices[]
            , HPos agn, int margin[], FontWeight fontWtObj, ToggleGroup tg) {
        RadioButton genericRadioButton = new RadioButton(btnTxt);
        genericRadioButton.setFont(Font.font(labelFont, fontWtObj, fontSize));
        genericRadioButton.setToggleGroup(tg);
        gridPane.add(genericRadioButton, indices[0], indices[1], indices[2], indices[3]);
        gridPane.setHalignment(genericRadioButton, agn);
        gridPane.setMargin(genericRadioButton, new Insets(margin[0], margin[1], margin[2], margin[3]));
        return genericRadioButton;
    }
}
