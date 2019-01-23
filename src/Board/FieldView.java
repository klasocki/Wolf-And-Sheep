package Board;

import Pieces.PieceView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class FieldView {
    private Rectangle viewRepresentation;
    private FieldModel fieldModel;
    private PieceView pieceView;
    private FieldController fieldController;

    public FieldView(FieldModel fieldModel, ChessboardView chessboardView, ChessboardModel chessboardModel) {
        this.fieldModel = fieldModel;
        this.fieldController = new FieldController(chessboardModel, chessboardView, fieldModel);
        this.viewRepresentation = new Rectangle();
        if ((fieldModel.getRow() + fieldModel.getCol()) % 2 == 1) {
            addEventHandlers(viewRepresentation);
            viewRepresentation.setFill(ChessboardView.playable);
        } else {
            viewRepresentation.setFill(ChessboardView.nonPlayable);
        }
        GridPane chessboard = chessboardView.getChessboardGrid();
        viewRepresentation.widthProperty().bind(
                chessboard.widthProperty().divide(ChessboardModel.size));
        viewRepresentation.heightProperty().bind(
                chessboard.heightProperty().divide(ChessboardModel.size));
    }

    public void setFill(Color color) {
        viewRepresentation.setFill(color);
    }

    public Rectangle getViewRepresentation() {
        return viewRepresentation;
    }

    public FieldModel getFieldModel() {
        return fieldModel;
    }

    public void setPieceView(PieceView pieceView) {
        this.pieceView = pieceView;
    }

    public PieceView getPieceView() {
        return pieceView;
    }

    public void mouseExited() {
        colorField(true);
    }

    public void mouseEntered() {
       colorField(false);
    }

    private void colorField(boolean darker) {
        Color current = Color.valueOf(viewRepresentation.getFill().toString());
        Color toSet = darker ? current.darker() : current.brighter();
        viewRepresentation.setFill(toSet);
        if (fieldModel.isTaken()) {
            if (darker) pieceView.makeDarker();
            else pieceView.makeBrighter();
        }
    }

    public void addEventHandlers(Shape viewRepresentation) {
        viewRepresentation.setOnMouseEntered(event -> mouseEntered());
        viewRepresentation.setOnMouseExited(event -> mouseExited());
        viewRepresentation.setOnMouseClicked(event -> fieldController.mouseClicked(this));
    }

}
