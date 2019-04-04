package algorithms.mazeGenerators;

public interface IMazeGenerator {
    /**
     *
     * @param row
     * @param col
     * @return maze object
     */
    public Maze generate(int row, int col);

    /**
     *
     * @param row
     * @param col
     * @return time measured to create the maze
     */
    public long measureAlgorithmTimeMillis(int row, int col);
}
