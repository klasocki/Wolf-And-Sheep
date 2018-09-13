package Board;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChessboardTest {

    Chessboard board;

    @Test
    public void getInstance() {
        board = Chessboard.getInstance();
    }

    @Test
    public void wolfsTurn() {
        assertTrue(board.wolfsTurn()); //wolf starts, so should be true by default
    }

    @Test
    public void changeTurn() {
        board.changeTurn();
        assertFalse(board.wolfsTurn());
        board.changeTurn();
        assertTrue(board.wolfsTurn());
    }
}