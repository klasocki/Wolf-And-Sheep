package Pawnes;

public class Position {
    private int row;
    private int col;
    private boolean taken;

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }


    public int getRow() {
        return row;
    }

    protected void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    protected void setCol(int col) {
        this.col = col;
    }
}
