package gui;

import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.List;

class GuiUtils {
    static void setButtonHeightAndBindSizes(int minHeight, List<Button> buttons, Button longestButton) {
        longestButton.setMinHeight(minHeight);
        for (Button button : buttons) {
            button.minHeightProperty().bind(longestButton.minHeightProperty());
            button.prefWidthProperty().bind(longestButton.widthProperty());
        }
    }

    static void centerWindow(Stage window) {
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        window.setX((primScreenBounds.getWidth() - window.getWidth()) / 2);
        window.setY((primScreenBounds.getHeight() - window.getHeight()) / 2);
    }
}
