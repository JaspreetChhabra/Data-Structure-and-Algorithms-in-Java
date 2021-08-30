package Graphs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionUGBFS {

    static class Pair{
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static boolean isCyclicGraph(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int vertex){

        visited[vertex] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(vertex, -1));

        while (!queue.isEmpty()){

            Pair p = queue.poll();
            ArrayList<Integer> vertexes = adj.get(p.first);

            for (int v: vertexes){
                if(!visited[v]){
                    visited[v] = true;
                    queue.add(new Pair(v, p.first));
                }
                else if(v != p.second) return true;
            }
        }

        return false;
    }

    public static void main(String[] args){

        Graph graph = new Graph(12);

        graph.addEdge(1, 2);
        graph.addEdge(2, 4);

        graph.addEdge(3,5);
        graph.addEdge(5,6);
        graph.addEdge(5,10);
        graph.addEdge(6,7);
        graph.addEdge(7,8);
        graph.addEdge(8,11);
        graph.addEdge(10,9);
        graph.addEdge(9,8);

        ArrayList<ArrayList<Integer>> adjList = Graph.getAdj();
        boolean[] visited = new boolean[adjList.size() + 1];
        for (int i=0; i< adjList.size(); i++){
            if(!visited[i]){
                if(isCyclicGraph(adjList, visited, i)) {
                    System.out.println("GRAPH IS CYCLIC");
                    break;
                }
            }
        }
    }
}
