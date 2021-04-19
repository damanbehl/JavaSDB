package utility;

import javafx.geometry.*;
import javafx.scene.layout.*;
import controltemplate.graphicity;
public class GraphicalUtility implements graphicity{
    /**
     *
     * @param ob : Pos object with alignment coming from a different class
     * @param padding : an int array with padding for gridpane in the following order top, right bottom left
     * @return: returns gridPane with configuration according to parameters
     */
    @Override
    public  GridPane createGridpane(Pos ob, int[] padding, int[] HVGap) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(ob);
        gridPane.setPadding(new Insets(padding[0], padding[1], padding[2], padding[3]));
        gridPane.setHgap(HVGap[0]);
        gridPane.setVgap(HVGap[1]);
        //TODO: CODE FOR CONDITIONAL COLUMN CONSTRAINTS
        return gridPane;
    }
}
