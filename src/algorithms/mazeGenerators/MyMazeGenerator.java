package algorithms.mazeGenerators;

import java.util.Stack;
import java.util.LinkedList;
import java.util.Random;


public class MyMazeGenerator extends AMazeGenerator {

    public static final char PASSAGE_CHAR = ' ';
    public static final char WALL_CHAR = '▓';
    public static final int WALL = 1;
    public static final int PASSAGE = 0;

    //private final int maze[][];
    //private final int col;
    //private final int row;


    @Override
    public Maze generate(int row, int col) {

        Maze maze = new Maze(row, col);

        final LinkedList<int[]> neighbors = new LinkedList<>();
        final Random random = new Random();
        int x = random.nextInt(col);
        int y = random.nextInt(row);
        Position mystart = new Position(x, y);
        maze.start = mystart;
        Position myend = new Position(x, y);
        maze.end = myend;

        neighbors.add(new int[]{x, y, x, y});
        maze.myMaze = new int[row][col];
        maze.setAllMaze(row, col, 1); //init all maze with value 1

        // maze.initPositions(maze.positions);
        // Position current = new Position(x, y);
        //  maze.setMyMaze(current.getRowIndex(),current.getColumnIndex(),0);
        // current.setVisited(true); //step 1

        while (!neighbors.isEmpty()) {
            final int[] f = neighbors.remove(random.nextInt(neighbors.size()));
            x = f[2];
            y = f[3];

            // maze.myMaze[x][y] = 0;

            if (maze.myMaze[x][y] == WALL) {
                maze.myMaze[f[0]][f[1]] = PASSAGE;
                maze.myMaze[x][y] = PASSAGE;
                if (x >= 2 && maze.myMaze[x - 2][y] == WALL)
                    neighbors.add(new int[]{x - 1, y, x - 2, y});
                if (y >= 2 && maze.myMaze[x][y - 2] == WALL)
                    neighbors.add(new int[]{x, y - 1, x, y - 2});
                if (x < col - 2 && maze.myMaze[x + 2][y] == WALL)
                    neighbors.add(new int[]{x + 1, y, x + 2, y});
                if (y < row - 2 && maze.myMaze[x][y + 2] == WALL)
                    neighbors.add(new int[]{x, y + 1, x, y + 2});
            }
            maze.end.setRow(f[2]);
            maze.end.setCol(f[3]);
        }

        return maze;
    }
}


        /*
        Maze maze = new Maze(row, col);
        //Position positions[][] = new Position[row][col];
        maze.initPositions(maze.positions);
        maze.setAllMaze(row, col, 1);
        Stack myPath=new Stack();
        Position current = new Position(maze.start.getRowIndex(), maze.start.getColumnIndex());
        maze.setMyMaze(current.getRowIndex(),current.getColumnIndex(),0);
        current.setVisited(true); //step 1
        while (maze.existNotVisited(maze.positions)) { //step 2
            if (maze.amountOfNeighbors(maze.positions,current) > 0) { //step 2.1
                Position next = maze.move(maze.positions, current,myPath); //step 2.1.1
                if(next.getColumnIndex()==maze.end.getColumnIndex()&&next.getRowIndex()==maze.end.getRowIndex()) {
                    break;
                }
                //myPath.push(current);//step 2.1.2
                maze.setMyMaze(next.getRowIndex(), next.getColumnIndex(), 0);//step 2.1.3
                current.setRow(next.getRowIndex()); //step 2.1.4
                current.setCol(next.getColumnIndex());
                current.setVisited(true);
            }
            else if (!myPath.empty()) { //step 2.2 : no more neighbors not visited and the stack is not empty
                Position temp1 = (Position)(myPath.pop());
                current.setRow(temp1.getRowIndex());
                current.setCol(temp1.getColumnIndex());
                current.setVisited(true);
            }
        }
        */


