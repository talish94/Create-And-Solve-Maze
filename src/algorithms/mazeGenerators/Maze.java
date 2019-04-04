package algorithms.mazeGenerators;

import java.util.Stack;

public class Maze {
    int row;
    int col;
    int myMaze[][];
    Position start=new Position();
    Position end=new Position();
    Position positions[][];
    boolean visited[][];

    public Maze(int row, int col) {
        int maze[][] = new int[row][col];
        this.row = row;
        this.col = col;
        this.myMaze = maze;
        start.setRow(0);
        start.setCol(0);
        end.setRow(row-1);
        end.setCol(col-1);
        this.positions=new Position[row][col];
        //System.out.println(row);
        this.visited=new boolean[row][col];

    }

    public boolean getVisited(int row, int col) {
        return visited[row][col];
    }

    public void setVisited(int row, int col, boolean visited) {
        this.visited[row][col] = visited;
    }

    public int getMyMaze(int row, int col) {
        return myMaze[row][col];
    }

    public void setMyMaze(int row, int col, int value) {

        myMaze[row][col] = value;
    }
    public void setAllMaze(int row, int col, int value) {

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                myMaze[i][j] = value;
            }
        }
    }
    public Position getStartPosition() {
        return start;
    }

    public Position getGoalPosition() {
        return end;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void print() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == start.getRowIndex() && j == start.getColumnIndex()) {
                    System.out.print(String.format("S"));
                } else if (i == end.getRowIndex() && j == end.getColumnIndex()) {
                    System.out.print(String.format("E"));
                } else {
                    System.out.print(String.format("%s", myMaze[i][j]));
                }
            }
            System.out.println();
        }
    }

    public boolean existNotVisited(Position[][] positions) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (positions[i][j].getVisited() == false) {
                    return true;
                }
            }
        }
        return false;
    }

    public int amountOfNeighbors(Position[][] positions,Position curr){
        int amount=0;
       if((curr.getRowIndex() > 0 ) && (positions[curr.getColumnIndex()][curr.getRowIndex()-1].getVisited()==false)) {
           amount++;
       }
        if((curr.getRowIndex() < row-1 ) && positions[curr.getColumnIndex()][curr.getRowIndex()+1].getVisited()==false) {
            amount++;
        }
        if((curr.getColumnIndex() > 0 ) && positions[curr.getColumnIndex()-1][curr.getRowIndex()].getVisited()==false) {
            amount++;
        }
        if((curr.getColumnIndex() < col-1) && positions[curr.getColumnIndex()+1][curr.getRowIndex()].getVisited()==false) {
            amount++;
        }
        return amount;
    }

    public void initPositions(Position[][] positions) {
        for (int i = 0; i < row; i++) {
            positions[i]=new Position[col];
            for (int j = 0; j < col; j++) {
                positions[i][j]=new Position();
                positions[i][j].setRow(i);
                positions[i][j].setCol(j);
            }
        }
    }

    public Position move(Position[][] positions, Position current, Stack path) {
        Position myposition=new Position();
        Position temp=new Position();

        if((current.getColumnIndex() < col-1) && positions[current.getColumnIndex()+1][current.getRowIndex()].getVisited()==false) {
            temp.setCol(current.getColumnIndex());
            temp.setRow(current.getRowIndex());
            path.push(temp);
            myposition.setCol(current.getColumnIndex()+1);
            myposition.setRow(current.getRowIndex());
            return myposition;
        }
        if((current.getRowIndex() < row-1 ) && positions[current.getColumnIndex()][current.getRowIndex()+1].getVisited()==false) {
            temp.setCol(current.getColumnIndex());
            temp.setRow(current.getRowIndex());
            path.push(temp);
            myposition.setCol(current.getColumnIndex());
            myposition.setRow(current.getRowIndex()+1);
            return myposition;
        }
        return current;
    }
}
