package board;

import pieces.PieceView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class FieldView {
    private Rectangle viewRepresentation;
    private FieldModel fieldModel;
    private PieceView pieceView;
    private FieldController fieldController;

    FieldView(FieldModel fieldModel, ChessboardView chessboardView, ChessboardModel chessboardModel) {
        this.fieldModel = fieldModel;
        this.fieldController = new FieldController(chessboardModel, chessboardView);
        this.viewRepresentation = new Rectangle();
        if ((fieldModel.getRow() + fieldModel.getCol()) % 2 == 1) {
            addEventHandlers(viewRepresentation);
            viewRepresentation.setFill(ChessboardView.playable);
            viewRepresentation.getStyleClass().add("playable-field");
        } else {
            viewRepresentation.setFill(ChessboardView.nonPlayable);
        }
        GridPane chessboard = chessboardView.getChessboardGrid();
        chessboard.add(viewRepresentation, fieldModel.getCol(), fieldModel.getRow());
        viewRepresentation.widthProperty().bind(
                chessboard.widthProperty().divide(ChessboardModel.size));
        viewRepresentation.heightProperty().bind(
                chessboard.heightProperty().divide(ChessboardModel.size));
    }

    void setFill(Color color) {
        viewRepresentation.setFill(color);
    }

    Rectangle getViewRepresentation() {
        return viewRepresentation;
    }

    FieldModel getFieldModel() {
        return fieldModel;
    }

    public void setPieceView(PieceView pieceView) {
        this.pieceView = pieceView;
    }

    public PieceView getPieceView() {
        return pieceView;
    }

    private void mouseExited() {
        colorField(ColorTo.DARKER);
    }

    private void mouseEntered() {
        colorField(ColorTo.BRIGHTER);
    }


    public void colorField(ColorTo color) {
        Color toSet = ColorTo.getFill(color, this);
        viewRepresentation.setFill(toSet);
        if (fieldModel.isTaken()) {
            if (color.equals(ColorTo.DARKER)) pieceView.makeDarker();
            else if (color.equals(ColorTo.BRIGHTER)) pieceView.makeBrighter();
        }
    }

    public void addEventHandlers(Shape viewRepresentation) {
        viewRepresentation.setOnMouseEntered(event -> mouseEntered());
        viewRepresentation.setOnMouseExited(event -> mouseExited());
        viewRepresentation.setOnMouseClicked(event -> fieldController.mouseClicked(this));
    }

    public enum ColorTo {
        DARKER, BRIGHTER, PLAYABLE;

        private static Color getFill(ColorTo color, FieldView fieldView) {
            Color current = Color.valueOf(fieldView.viewRepresentation.getFill().toString());
            switch (color) {
                case PLAYABLE:
                    return ChessboardView.playable;
                case DARKER:
                    return current.darker();
                case BRIGHTER:
                    return current.brighter();
                default:
                    return Color.BLANCHEDALMOND; // just because
            }
        }
    }
}
