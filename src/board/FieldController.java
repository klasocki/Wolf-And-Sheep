package board;

import pieces.PieceView;

import java.util.List;

//TODO too much logic inside controller, move

class FieldController {
    private ChessboardModel chessboardModel;
    private ChessboardView chessboardView;

    FieldController(ChessboardModel chessboardModel, ChessboardView chessboardView) {
        this.chessboardModel = chessboardModel;
        this.chessboardView = chessboardView;
    }

    void mouseClicked(FieldView fieldView) {
        if (chessboardModel.getFieldModelSelected() != null && !fieldView.getFieldModel().isTaken()) {
            //If field clicked is a possible move, it does it, else it unselects current filed
            moveSelectedPiece(fieldView.getFieldModel());
        } else if (fieldView.getFieldModel().isTaken()) {
            //So, every time you click on a taken field, you either select pieceModel you want to move
            // or deselect current selection by clicking it
            if (fieldView.getFieldModel().equals(chessboardModel.getFieldModelSelected()))
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
        unselectField();
        List<FieldModel> moves = fieldView.getFieldModel().getPossibleMoves();
        if (moves.size() == 0 ) return;
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
        if (moves.contains(destination) ) {
            pieceViewToMove.move(destination);
        }
    }

}
