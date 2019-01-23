package pieces;

import board.ChessboardView;


public class WolfView extends PieceView {
    public WolfView(PieceModel pieceModel, ChessboardView chessboardView) {
        super(pieceModel, chessboardView);
        this.viewRepresentation.setFill(ChessboardView.wolfColor);
    }
}
