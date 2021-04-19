package controltemplate;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

public interface graphicity {
    /**
     * functional Template for creating gridpanes throughout the project
     */
    GridPane createGridpane(Pos object, int []padding, int []HVGap);
}
