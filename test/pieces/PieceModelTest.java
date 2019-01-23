package pieces;

import board.ChessboardModel;
import board.FieldModel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PieceModelTest {
    ChessboardModel chessboardModel = new ChessboardModel();
    PieceModel wolf = new WolfModel(chessboardModel);
    PieceModel sheep = new SheepModel(chessboardModel, true);
    PieceModel sheepMovingDown = new SheepModel(chessboardModel, false);

    @Test
    void place() {
        wolf.place(chessboardModel.getField(1, 1));
        assert wolf.isPlaced();
        assert !sheep.isPlaced();
        assert !sheepMovingDown.isPlaced();
    }

    @Test
    void getPossibleMoves() {
        wolf.place(chessboardModel.getField(1, 1));
        sheepMovingDown.place(chessboardModel.getField(0, 2));
        sheep.place(chessboardModel.getField(5, 5));
        ArrayList<FieldModel> wolfMoves = new ArrayList<>();
        ArrayList<FieldModel> sheepMoves = new ArrayList<>();
        ArrayList<FieldModel> sheepDownMoves = new ArrayList<>();
        wolfMoves.add(chessboardModel.getField(0, 0));
        wolfMoves.add(chessboardModel.getField(2, 0));
        wolfMoves.add(chessboardModel.getField(2, 2));

        sheepDownMoves.add(chessboardModel.getField(1, 3));

        sheepMoves.add(chessboardModel.getField(4, 4));
        sheepMoves.add(chessboardModel.getField(4, 6));

        assert wolf.getPossibleMoves().containsAll(wolfMoves);
        assert sheep.getPossibleMoves().containsAll(sheepMoves);
        assert sheepMovingDown.getPossibleMoves().containsAll(sheepDownMoves);
    }
}