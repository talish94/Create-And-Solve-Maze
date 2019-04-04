package algorithms.search;

public abstract class AState implements Comparable<AState>{

    AState parent;
    boolean visited;
    int distance;
    int cost;

    public AState() {
    }

    public AState getParent() {
        return parent;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setParent(AState parent) {
        this.parent = parent;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int dis) {
        this.distance = dis;
    }

    @Override
    public int compareTo(AState o) {
        if (cost < o.getCost())
            return 1;
        else if (cost > o.getCost())
            return -1;
        return 0;
    }



    /*
        public void setRow(int row) {this.row = row; }
        public void setCol(int col) {
            this.col = col;
        }
        public void setValue(int val) {
        this.value = val;
    }
        public void setPartOfPath(boolean isPart) {
            this.partOfPath = isPart;
        }
        public void setDistance(int dis) {
        this.distance = dis;
    }

        public int getRowIndex() {
            return row;
        }
        public int getColumnIndex() {
            return col;
        }
        public int getDistance() { return distance; }
        public int getValue() { return value; }
        public boolean getPartOfPath() { return partOfPath; }

        @Override
        public String toString() {
            return "{"+ row +","+ col+"}";
        }
    }
*/

}