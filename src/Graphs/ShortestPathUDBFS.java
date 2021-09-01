package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUDBFS {

    public static int calculateDistance(int source, int destination, ArrayList<ArrayList<Integer>> adjList){
        int[] dist = new int[adjList.size() + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        dist[source] = 0;

        while (!queue.isEmpty()){
            int node = queue.poll();

            for (int v: adjList.get(node)){
                int distance = dist[v];
                if(distance > dist[node] + 1) {
                    dist[v] = dist[node] + 1;
                    queue.add(v);
                }
            }
        }
        return dist[destination];
    }

    public static void main(String[] args){
        Graph graph = new Graph(12);

        graph.addEdge(0 , 1);
        graph.addEdge(1, 2);

        graph.addEdge(2,6);
        graph.addEdge(0,3);
        graph.addEdge(3,4);
        graph.addEdge(4,5);
        graph.addEdge(5,6);

        ArrayList<ArrayList<Integer>> adjList = Graph.getAdj();
        System.out.println("Shortest Distance: " + calculateDistance(0, 6, adjList));
    }
}
