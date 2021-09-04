package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSortBFS {

    private static List<Integer> bfs(ArrayList<ArrayList<Integer>> adjList, int[] inDegree){
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> topoSort = new ArrayList<>();

        for (int i =0; i <inDegree.length; i++){
            if(inDegree[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()){
            int node = queue.poll();
            topoSort.add(node);

            for (int v: adjList.get(node)){
                inDegree[v]--;
                if(inDegree[v] == 0)
                    queue.add(v);
            }
        }
        return topoSort;
    }

    public static void main(String[] args){
        int N = 6;
        Graph g = new Graph(N);

        g.addDirectedEdge(2,3);
        g.addDirectedEdge(3, 1);
        g.addDirectedEdge(4, 0);
        g.addDirectedEdge(4, 1);
        g.addDirectedEdge(5, 0);
        g.addDirectedEdge(5, 2);

        ArrayList<ArrayList<Integer>> adjList = Graph.getAdj();
        int[] inDegree = new int[N];

        for (int i =0; i < N ; i++){
            for(int edge: adjList.get(i)){
                inDegree[edge]++;
            }
        }

        bfs(adjList, inDegree).forEach(System.out::println);
    }
}
