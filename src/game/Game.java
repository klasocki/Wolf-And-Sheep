package game;

import board.FieldModel;
import pieces.SheepModel;
import pieces.WolfModel;

import java.util.Stack;

public class Game {
    private boolean wolfsTurn = true; //WolfModel starts the game
    public boolean sheepMoveUp;
    private Stack<Move> listOfMoves = new Stack<>();

    public void saveMove(Move move) {
        listOfMoves.push(move);
    }
    public Move popMove() {
        return listOfMoves.pop();
    }

    public void changeTurn() {
        wolfsTurn = !wolfsTurn;
    }

    public Class turnOf() {
        return wolfsTurn ? WolfModel.class : SheepModel.class;
    }

    public boolean canUndo() {
        return !listOfMoves.empty();
    }

    public static class Move{
        public FieldModel from;
        public FieldModel to;

        public Move(FieldModel from, FieldModel to) {
            this.from = from;
            this.to = to;
        }
    }

}

