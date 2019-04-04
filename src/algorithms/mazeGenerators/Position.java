package algorithms.mazeGenerators;

public class Position {

    int row;
    int col;
    boolean visited;

    public Position() {
        this.row = 0;
        this.col = 0;
        this.visited=false;
    }

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
        this.visited=false;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getRowIndex() {
        return row;
    }

    public int getColumnIndex() {
        return col;
    }

    public boolean getVisited() {
        return visited;
    }

    @Override
    public String toString() {
        return "{"+ row +","+ col+"}";
    }
}
