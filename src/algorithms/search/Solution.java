package algorithms.search;

import java.util.ArrayList;

public class Solution {
    ArrayList<AState> listPath;

    public Solution(AState lastOne) {
        listPath = new ArrayList<AState>();
        AState current = lastOne;
        while (current != null){
            listPath.add(0,current);
            current = current.getParent();
        }
    }

    public ArrayList<AState> getSolutionPath(){
        return listPath;
    }
}
