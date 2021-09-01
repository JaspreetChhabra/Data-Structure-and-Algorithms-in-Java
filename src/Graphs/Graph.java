package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {

    public static ArrayList<ArrayList<Integer>> adj = null;
    public Graph(int v){
        int V = v;

        adj = new ArrayList<ArrayList<Integer> >(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());
    }

    public void addEdge(int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public void addDirectedEdge(int u, int v){
        adj.get(u).add(v);
    }

    public static ArrayList<ArrayList<Integer>> getAdj() {
        return adj;
    }

    public void printGraph(){

        for (int i=0; i < adj.size(); i++){
            System.out.println("\nAdjacency list of vertex" + i);
            System.out.print("head");
            for (int j =0; j < adj.get(i).size(); j++){
                System.out.print(" -> "+ adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);

        // Adding edges one by one
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printGraph();

    }
}
