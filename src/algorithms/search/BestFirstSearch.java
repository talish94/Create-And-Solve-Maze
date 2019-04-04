package algorithms.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;

public class BestFirstSearch extends BreadthFirstSearch {

    public BestFirstSearch() {
        queue = new PriorityQueue<>();

           /* @Override
            public int compare(AState o1, AState o2) {
                if (o1.getCost() < o2.getCost())
                    return 1;
                else if (o1.getCost() > o2.getCost())
                    return -1;
                return 0;
            }*/
                //////return Integer.compare(getCost(), other.getCost());
        }

        @Override
        public String getName() {
            return "BestFirstSearch";
        }
    }



