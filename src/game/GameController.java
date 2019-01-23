package game;

import board.ChessboardModel;
import board.ChessboardView;
import board.FieldView;
import javafx.scene.layout.GridPane;
import pieces.PieceFactory;
import pieces.PieceModel;
import pieces.PieceView;

public class GameController {
    ChessboardModel chessboardModel;
    ChessboardView chessboardView;

    public static GameController initGame(boolean playerControlsSheep) {
        ChessboardModel cm = new ChessboardModel();
        ChessboardView cv = new ChessboardView(cm);
        PieceFactory pieceFactory = new PieceFactory(cm, cv);
        pieceFactory.placePieces( playerControlsSheep);
        return new GameController(cm, cv);
    }

    public GameController(ChessboardModel chessboardModel, ChessboardView chessboardView) {
        this.chessboardModel = chessboardModel;
        this.chessboardView = chessboardView;
    }

    public void undoLastMove() {
        if (chessboardModel.canUndo()) {
            Game.Move lastMove = chessboardModel.popMove();
            PieceModel pieceMoved = lastMove.to.getPieceModel();
            FieldView movedTo = chessboardView.getFieldView(lastMove.to);
            PieceView pieceViewMoved = movedTo.getPieceView();
            movedTo.colorField(FieldView.ColorTo.PLAYABLE);
            //without the above, field remains darker after undo
            //get's darker after move because mouse leaves it after it's fill is set back to playable
            pieceMoved.moveWithoutCheck(lastMove.from);
            pieceViewMoved.moveWithoutColorChange(lastMove.from);
        }
    }

    public GridPane getChessboardGrid() {
        return chessboardView.getChessboardGrid();
    }
}
