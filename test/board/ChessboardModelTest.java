package board;


import org.junit.jupiter.api.Test;
import pieces.PieceModel;
import pieces.WolfModel;

class ChessboardModelTest {
    private ChessboardModel chessboardModel = new ChessboardModel();

    @Test
    void setFieldModelSelected() {
        assert chessboardModel.getFieldModelSelected() == null;
        chessboardModel.setFieldModelSelected(chessboardModel.getField(0,1));
        assert chessboardModel.getFieldModelSelected().equals(chessboardModel.getField(0, 1));
        chessboardModel.setFieldModelSelected(null);
        assert chessboardModel.getFieldModelSelected() == null;
    }

    @Test
    void isValidMove() {
        PieceModel piece = new WolfModel(chessboardModel);
        piece.place(chessboardModel.getField(7, 7));
        assert chessboardModel.isValidMove(0,1);
        assert chessboardModel.isValidMove(ChessboardModel.size - 1, ChessboardModel.size - 2);
        assert !chessboardModel.isValidMove(7, 7);
        assert !chessboardModel.isValidMove(7, 8);
        assert !chessboardModel.isValidMove(8, 7);
        assert !chessboardModel.isValidMove(7123, 8135);
        assert !chessboardModel.isValidMove(0, -1);
        assert !chessboardModel.isValidMove(-2, 0);
    }
}