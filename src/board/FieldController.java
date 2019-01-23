package board;

import pieces.PieceController;
import pieces.PieceView;

import java.util.List;

//TODO too much logic inside controller, move

public class FieldController {
    private ChessboardModel chessboardModel;
    private ChessboardView chessboardView;
    private FieldModel fieldModel;
    private PieceController pieceController;

    public FieldController(ChessboardModel chessboardModel, ChessboardView chessboardView, FieldModel fieldModel) {
        this.chessboardModel = chessboardModel;
        this.chessboardView = chessboardView;
        this.fieldModel = fieldModel;
        this.pieceController = new PieceController(chessboardModel, chessboardView);
    }

    public void mouseClicked(FieldView fieldView) {
        if (!fieldView.getFieldModel().isTaken() && chessboardModel.getFieldModelSelected() != null) {
            //If field clicked is a possible move, it does it, else it unselects current filed
            moveSelectedPiece(fieldView.getFieldModel());
        } else if (fieldView.getFieldModel().isTaken()) {
            //So, every time you click on a taken field, you select pieceModel you want to move
            if (fieldView.getFieldModel() == chessboardModel.getFieldModelSelected())
                unselectField();
            else
                selectField(fieldView);
        }
    }

    private void unselectField() {
        FieldModel fieldModel = chessboardModel.getFieldModelSelected();
        if (fieldModel == null) return;
        List<FieldModel> moves = fieldModel.getPossibleMoves();
        for (FieldModel f : moves) {
            chessboardView.getFieldView(f).setFill(ChessboardView.playable);
        }
        chessboardView.getFieldView(fieldModel).setFill(ChessboardView.playable);
        chessboardModel.setFieldModelSelected(null);
    }

    private void selectField(FieldView fieldView) {
        // TODO Model should calculate the fields to prompt
        unselectField();
        List<FieldModel> moves = fieldView.getFieldModel().getPossibleMoves();
        if (moves.size() == 0) return;
        for (FieldModel f : moves) {
            chessboardView.getFieldView(f).setFill(ChessboardView.prompt);
        }
        chessboardModel.setFieldModelSelected(fieldView.getFieldModel());
        fieldView.setFill(ChessboardView.selected);
    }

    private void moveSelectedPiece(FieldModel destination) {
        FieldModel fieldSelected = chessboardModel.getFieldModelSelected();
        PieceView pieceViewToMove = chessboardView.getFieldView(fieldSelected).getPieceView();
        List<FieldModel> moves = fieldSelected.getPossibleMoves();
        unselectField();
        if (moves.contains(destination)) {
            pieceController.movePiece(pieceViewToMove, destination);
        }
    }

    public void placePiece(PieceView pieceView){
        pieceController.placePiece(pieceView, this.fieldModel);
    }
}
