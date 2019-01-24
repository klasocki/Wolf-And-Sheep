package pieces;

import board.ChessboardModel;
import board.ChessboardView;
import board.FieldModel;

import java.util.ArrayList;
import java.util.List;

public class PieceFactory {
    private ChessboardModel chessboardModel;
    private ChessboardView chessboardView;

    public PieceFactory(ChessboardModel chessboardModel, ChessboardView chessboardView) {
        this.chessboardModel = chessboardModel;
        this.chessboardView = chessboardView;
    }
    public List<PieceModel> placePieces(boolean playerControlsSheep) {
        List<PieceModel> result = new ArrayList<>();
        PieceModel wolfModel = new WolfModel(chessboardModel);
        result.add(wolfModel);
        PieceView wolf = new WolfView(wolfModel, chessboardView);
        FieldModel wolfField = playerControlsSheep ?
                chessboardModel.getField(0,ChessboardModel.size / 2 + 1) :
                chessboardModel.getField(ChessboardModel.size - 1,ChessboardModel.size / 2);
        wolf.place(wolfField);
        for (int i = 0; i < ChessboardModel.size / 2; i++) {
            PieceModel sheepModel = new SheepModel(chessboardModel, playerControlsSheep);
            result.add(sheepModel);
            PieceView sheepView = new SheepView(sheepModel, chessboardView);
            FieldModel sheepField = playerControlsSheep ?
                    chessboardModel.getField(ChessboardModel.size - 1, i * 2) :
                    chessboardModel.getField(0, i * 2 + 1);
            sheepView.place(sheepField);
        }
        return result;
    }

}
