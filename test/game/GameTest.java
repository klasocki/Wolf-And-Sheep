package game;

import board.ChessboardModel;
import org.junit.jupiter.api.Test;
import pieces.PieceModel;
import pieces.SheepModel;
import pieces.WolfModel;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    void turnTest() {
        ChessboardModel chessboardModel = new ChessboardModel();
        assert chessboardModel.turnOf() == WolfModel.class;
        chessboardModel.changeTurn();
        assert chessboardModel.turnOf() == SheepModel.class;
        PieceModel sheep = new SheepModel(chessboardModel, false);
        assert chessboardModel.turnOf().isInstance(sheep);
        PieceModel wolf = new WolfModel(chessboardModel);
        assert !chessboardModel.turnOf().isInstance(wolf);
    }
}