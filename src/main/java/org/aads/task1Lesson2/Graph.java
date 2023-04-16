package org.aads.task1Lesson2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    private static final int NODE_LIMIT = 100;
    private final ArrayList<LinkedList<Integer>> adj;
    private final ArrayList<LinkedList<Integer>> reverseAdj;
    /**
     * store all nodes that are adjacent to at least one node
     */
    private final HashSet<Integer> nodeSet;
    private Boolean[] isReachable;
    private final int limit;

    public Graph() {
        this(NODE_LIMIT);
    }

    public Graph(int limit) {
        this.limit = limit;
        nodeSet = new HashSet<>(limit);
        adj = new ArrayList<>(limit);
        reverseAdj = new ArrayList<>(limit);
        for (int i = 0; i < limit; ++i) {
            adj.add(new LinkedList<>());
            reverseAdj.add(new LinkedList<>());
        }
    }

    public void add(Integer parent, Integer child) {
        if (parent > limit || parent < 0 || child > limit || child < 0) {
            return;
        }

        adj.get(parent).add(child);
        nodeSet.add(parent);
        nodeSet.add(child);
        addToReverse(parent, child);
    }

    /**
     * @param file to read
     * @return false if there was a some kind of error and true otherwise
     */
    public boolean readFromFile(File file) {
        if (!file.exists() || file.length() == 0) {
            return false;
        }

        try (var reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            int nEdges = Integer.parseInt(reader.readLine());
            for (int i = 0; i < nEdges; ++i) {
                List<Integer> pair = Arrays.stream(reader.readLine().split(" "))
                        .map(Integer::parseInt)
                        .toList();
                add(pair.get(0), pair.get(1));
            }
        } catch (IOException e) {
            System.out.println("THERE WAS AN ERROR!!");
            return false;
        }
        return true;
    }

    /**
     * O(nv)
     * v-number of verges
     * n - length of path
     *
     * @return null if node 'to' doesn't exists
     */
    public List<Integer> findNumberOfPath(int to, int len) {
        if (len == 0) {
            return List.of(to);
        }
        if (adj.size() == 0 || !nodeSet.contains(to)) {
            return new ArrayList<>();
        }

        isReachable = new Boolean[limit + 1];
        Arrays.fill(isReachable, false);
        dfs(to, 0, len);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < limit + 1; ++i) {
            if (isReachable[i]) {
                ans.add(i);
            }
        }
        return ans;
    }

    /**
     * This algorithm uses BFS for searching
     *
     * @param from   starting point of searching
     * @param target node to search
     * @return true if the path from the 'from' node to the 'target' node exists
     * Complexity:
     * Time: O(n), n - number of nodes, since we visit each node only one time
     * Space: O(n), since we are using queue
     */
    public boolean containsPath(int from, int target) {
        if (from == target) {
            return true;
        }
        if (!nodeSet.contains(from) || !nodeSet.contains(target)) {
            return false;
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] used = new boolean[limit];
        q.add(from);
        while (!q.isEmpty()) {
            int current = q.poll();
            used[current] = true;
            if (current == target) {
                return true;
            }
            //add all unused nodes to queue
            q.addAll(adj.get(current)
                    .stream()
                    .filter(p -> !used[p])
                    .toList());
        }
        return false;
    }

    private void addToReverse(Integer parent, Integer child) {
        reverseAdj.get(child).add(parent);
    }


    private void dfs(int current, int counter, int length) {
        if (counter == length) {
            isReachable[current] = true;
            return;
        }
        for (int parent : reverseAdj.get(current)) {
            dfs(parent, counter + 1, length);
        }
    }

    @Override
    public String toString() {
        return nodeSet.toString();
    }
}
