package Graphs;

import java.util.ArrayList;

public class CycleDetectionUGDFS {

    public static boolean isCyclicGraph(int vertex, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adjList){

        visited[vertex] = true;

        for (int v: adjList.get(vertex)){
            if( !visited[v] ) {
                if (isCyclicGraph(v, vertex, visited, adjList)) return true;
            }
            else if(v != parent) return true;
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
                if(isCyclicGraph(i, -1,  visited, adjList)) {
                    System.out.println("GRAPH IS CYCLIC");
                }
            }
        }
    }

}
