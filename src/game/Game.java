package game;

import pieces.SheepModel;
import pieces.WolfModel;

public class Game {
    private boolean wolfsTurn = true; //WolfModel starts the game

    public boolean wolfsTurn() {
        return wolfsTurn;
    }

    public void changeTurn() {
        wolfsTurn = !wolfsTurn;
    }

    public Class turnOf() {
        return wolfsTurn ? WolfModel.class : SheepModel.class;
    }
}

