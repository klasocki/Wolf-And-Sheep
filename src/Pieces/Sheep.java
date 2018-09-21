package Pieces;

public class Sheep extends Piece {

    public Sheep(boolean playerControlsSheep) {
        movingWay = playerControlsSheep ? new MovesUpward() : new MovesDownward();
    }
}
