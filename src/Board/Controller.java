package Board;

import Pawnes.Movable;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import Pawnes.*;

import java.util.ArrayList;


public class Controller {

    public static void mouseExited(Rectangle rectangle) {
        Color current = Color.valueOf(rectangle.getFill().toString());
        rectangle.setFill(current.darker());

    }

    public static void mouseEntered(Rectangle rectangle) {
        Color current = Color.valueOf(rectangle.getFill().toString());
        rectangle.setFill(current.brighter());
    }

    public static void mouseClicked(Field field) {
        Movable moveWay = new MovesBothWays();
        ArrayList<Field> moves = moveWay.getPossibleMoves(field);
        if (moves.size() == 0) return;
        for (Field f : moves) {
            f.square.setFill(Color.GREEN);
        }
    }



}
