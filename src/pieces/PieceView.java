package pieces;

import board.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public abstract class PieceView {
    protected Circle viewRepresentation;
    private PieceModel pieceModel;
    private FieldView fieldView;
    private ChessboardView chessboardView;

    public PieceView(PieceModel pieceModel, ChessboardView chessboardView) {
        this.pieceModel = pieceModel;
        this.chessboardView = chessboardView;
        Circle viewRepresentation = new Circle();
        viewRepresentation.radiusProperty().bind(chessboardView.getPieceRadiusProperty());
        this.viewRepresentation = viewRepresentation;
    }

    public Circle getViewRepresentation() {
        return viewRepresentation;
    }

    public FieldView getFieldView() {
        return fieldView;
    }


    public void place(FieldModel fieldModel) {
        if (pieceModel.place(fieldModel)) {
            chessboardView.addPiece(this.viewRepresentation, fieldModel.getCol(), fieldModel.getRow());
            this.fieldView = chessboardView.getFieldView(fieldModel);
            this.fieldView.addEventHandlers(this.viewRepresentation);
            this.fieldView.setPieceView(this);
        }
    }

    public void move(FieldModel fieldModel) {
        if (pieceModel.move(fieldModel)) {
            fieldView.setPieceView(null);
            fieldView = chessboardView.getFieldView(fieldModel);
            fieldView.setPieceView(this);
            fieldView.addEventHandlers(this.viewRepresentation);
        /* without this color setting, mouse leaves the circle
        without entering it after the move, resulting in
        the circle getting darker and darker
        */
            viewRepresentation.setFill(
                    Color.valueOf(viewRepresentation.getFill().toString()).brighter());

            chessboardView.movePiece(this, fieldModel.getCol(), fieldModel.getRow());
        }
    }

    public void makeBrighter() {
        viewRepresentation.setFill(Color.valueOf(viewRepresentation.getFill().toString()).brighter());
    }

    public void makeDarker() {
        viewRepresentation.setFill(Color.valueOf(viewRepresentation.getFill().toString()).darker());
    }

}
