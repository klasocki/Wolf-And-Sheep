package game;

import board.ChessboardModel;
import board.ChessboardView;
import board.FieldView;
import javafx.scene.layout.GridPane;
import pieces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class GameController implements PieceMovedObserver{
    private ChessboardModel chessboardModel;
    private ChessboardView chessboardView;
    private boolean sheepMoveUp;
    private List<PieceModel> pieces;
    private List<GameOverObserver> observers;

    public static GameController initGame(boolean playerControlsSheep) {
        ChessboardModel cm = new ChessboardModel();
        cm.setSheepMoveUp(playerControlsSheep);
        ChessboardView cv = new ChessboardView(cm);
        PieceFactory pieceFactory = new PieceFactory(cm, cv);
        List<PieceModel> pieces = pieceFactory.placePieces(playerControlsSheep);
        return new GameController(cm, cv, pieces, playerControlsSheep);
    }

    public GameController(ChessboardModel chessboardModel, ChessboardView chessboardView,
                          List<PieceModel> pieces, boolean sheepMoveUp) {
        this.chessboardModel = chessboardModel;
        this.chessboardView = chessboardView;
        chessboardView.addObserver(this);
        this.pieces = pieces;
        this.sheepMoveUp = sheepMoveUp;
        this.observers = new ArrayList<>();
    }

    public void addObserver(GameOverObserver observer) {
        observers.add(observer);
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

    public boolean sheepWon() {
        return getWolf().getPossibleMoves().size() == 0 && getWolf().hasTurnNow();
    }

    public boolean wolfWon() {
        List<Integer> sheepRows = getSheep().stream().
                map(a -> a.getFieldModel().getRow()).sorted().collect(Collectors.toList());
        int lastSheepRowNumber = sheepMoveUp ? sheepRows.get(sheepRows.size() - 1) : sheepRows.get(0);
        return getWolf().getFieldModel().getRow() == lastSheepRowNumber;
    }

    public GridPane getChessboardGrid() {
        return chessboardView.getChessboardGrid();
    }

    List<PieceModel> getSheep() {
        return pieces.stream().filter(a -> a instanceof SheepModel).collect(Collectors.toList());
    }

    PieceModel getWolf() {
        return pieces.stream().filter(a -> a instanceof WolfModel).collect(Collectors.toList()).get(0);
    }


    @Override
    public void pieceMoved() {
        if (sheepWon()) {
            observers.forEach(GameOverObserver::sheepHaveWon);
        }
        if (wolfWon()) {
            observers.forEach(GameOverObserver::wolfHasWon);
        }
    }
}
