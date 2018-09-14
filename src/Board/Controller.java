package Board;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Controller {

    public static void mouseEntered(Rectangle rectangle) {
        Color current = Color.valueOf(rectangle.getFill().toString());
        rectangle.setFill(current.darker());

    }

    public static void mouseExited(Rectangle rectangle) {
        Color current = Color.valueOf(rectangle.getFill().toString());
        rectangle.setFill(current.brighter());
    }
    

}
