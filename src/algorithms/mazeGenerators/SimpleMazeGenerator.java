package algorithms.mazeGenerators;

public class SimpleMazeGenerator extends AMazeGenerator {
    @Override
    public Maze generate(int row, int col) {
        Maze maze = new Maze(row, col);
        for(int i=0; i<(row*col)/10; i++){
            int randomX=(int)(Math.random()*col);
            int randomY=(int)(Math.random()*row);
            maze.setMyMaze(randomX, randomY, 1);
            //if(!maze.solve()){
             //   maze.setMyMaze(randomX, randomY, 0);
            //}
        }
        return maze;

    }
}
