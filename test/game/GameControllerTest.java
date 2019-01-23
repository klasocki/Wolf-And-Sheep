package game;

import board.ChessboardModel;
import board.ChessboardView;
import board.FieldModel;
import org.junit.jupiter.api.Test;
import pieces.PieceFactory;
import pieces.PieceModel;
import pieces.PieceView;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

    @Test
    void undoLastMove() {
        ChessboardModel chessboardModel = new ChessboardModel();
        ChessboardView chessboardView = new ChessboardView(chessboardModel);
        GameController gameController = new GameController(chessboardModel, chessboardView);
        PieceFactory pieceFactory = new PieceFactory(chessboardModel, chessboardView);
        pieceFactory.placePieces(true);
        assert !chessboardModel.canUndo();
        FieldModel wolfField = chessboardModel.getField(0, 5);
        FieldModel toMove = chessboardModel.getField(1, 4);
        PieceModel wolf = wolfField.getPieceModel();
        PieceView wolfView = chessboardView.getFieldView(wolfField).getPieceView();
        wolfView.move(toMove);
        assert !wolf.hasTurnNow();
        assert wolf == chessboardModel.getField(1, 4).getPieceModel();
        assert null == chessboardModel.getField(0, 5).getPieceModel();
        gameController.undoLastMove();
        assert wolf == chessboardModel.getField(0, 5).getPieceModel();
        assert wolf.hasTurnNow();
    }
}