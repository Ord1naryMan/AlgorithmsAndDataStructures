package org.aads.task1Lesson2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Graph {
    private static final int NODELIMIT = 100;
    private final ArrayList<LinkedList<Integer>> adj;
    private final ArrayList<LinkedList<Integer>> reverseAdj;
    private Boolean[] isReachable;
    private final int limit;

    public Graph() {
        limit = NODELIMIT;
        adj =  new ArrayList<>(limit);
        reverseAdj = new ArrayList<>(limit);
        for(int i = 0; i<limit; ++i){
            adj.add(new LinkedList<>());
            reverseAdj.add(new LinkedList<>());
        }
    }
    public Graph(int limit){
        this.limit = limit;
        adj =  new ArrayList<>(limit);
        reverseAdj = new ArrayList<>(limit);
        for(int i = 0; i<limit; ++i){
            adj.add(new LinkedList<>());
            reverseAdj.add(new LinkedList<>());
        }
    }

    public void add(Integer parent, Integer child){
        if(parent > limit || parent < 0){
            return;
        }

        adj.get(parent).add(child);
        addToReverse(parent, child);
    }

    public void addToReverse(Integer parent, Integer child){
        reverseAdj.get(child).add(parent);
    }

    /**
     *
     *
     * O(nv)
     * v-number of verges
     * n - length of path
     */
    public List<Integer> findNumberOfPath(int to, int len){
        if(len == 0){
            return List.of(to);
        }
        if(reverseAdj.size() == 0){
            return new ArrayList<>();
        }

        isReachable = new Boolean[limit+1];
        Arrays.fill(isReachable, false);
        dfs(to, 0, len);
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i<limit+1;++i){
            if(isReachable[i]){
                ans.add(i);
            }
        }
        return ans;
    }

    private void dfs(int current, int counter, int length){
        if(counter == length){
            isReachable[current] = true;
            return;
        }
        for(int parent : reverseAdj.get(current)){
            dfs(parent, counter + 1, length);
        }
    }
}
