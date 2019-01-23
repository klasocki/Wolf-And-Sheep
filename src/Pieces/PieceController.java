package Pieces;

import Board.ChessboardModel;
import Board.ChessboardView;
import Board.FieldModel;

public class PieceController {
    private ChessboardModel chessboardModel;
    private ChessboardView chessboardView;

    public PieceController(ChessboardModel chessboardModel, ChessboardView chessboardView) {
        this.chessboardModel = chessboardModel;
        this.chessboardView = chessboardView;
    }

    public void placePiece(PieceView pieceView, FieldModel fieldModel) {
        pieceView.place(fieldModel);
    }

    public void movePiece(PieceView pieceView, FieldModel fieldModel) {
            pieceView.move(fieldModel);
    }
}
