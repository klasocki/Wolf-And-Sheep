package game;

import board.ChessboardModel;
import board.ChessboardView;
import board.FieldModel;
import org.junit.jupiter.api.Test;
import pieces.PieceFactory;
import pieces.PieceModel;
import pieces.PieceView;

import java.util.ArrayList;

class GameControllerTest {

    @Test
    void undoLastMove() {
        ChessboardModel chessboardModel = new ChessboardModel();
        ChessboardView chessboardView = new ChessboardView(chessboardModel);
        PieceFactory pieceFactory = new PieceFactory(chessboardModel, chessboardView);
        GameController gameController = new GameController(chessboardModel, chessboardView,
                pieceFactory.placePieces(true), true);
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

    @Test
    void getSheep() {
        GameController gameController = GameController.initGame(true);
        gameController.getSheep().stream().
                map(a -> a.getFieldModel().getRow()).sorted().forEach(a -> {
                    assert a == 7;
        } );
    }

    @Test
    void getWolf() {
        GameController gameController = GameController.initGame(true);
        assert gameController.getWolf().getFieldModel().getRow() == 0;
    }

    @Test
    void somebodyWon() {
        GameController gameController = GameController.initGame(true);
        assert !gameController.wolfWon();
        assert !gameController.sheepWon();
    }
}