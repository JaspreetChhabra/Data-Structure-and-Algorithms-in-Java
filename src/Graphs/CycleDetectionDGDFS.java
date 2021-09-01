package Graphs;

import java.util.ArrayList;

public class CycleDetectionDGDFS {

    private static boolean detectCycle(int node, boolean[] visited, boolean[] dfsVisited, ArrayList<ArrayList<Integer>> adjList) {
        visited[node] = true;
        dfsVisited[node] = true;

        for (int v: adjList.get(node)){
            if(!visited[v]) {
                if(detectCycle(v, visited, dfsVisited, adjList)) return true;
            }
            else if(dfsVisited[v]) return true;
        }
        dfsVisited[node] = false;
        return false;
    }

    public static void main(String[] args){

        Graph graph = new Graph(12);

        graph.addDirectedEdge(1, 2);
        graph.addDirectedEdge(7, 8);
        graph.addDirectedEdge(8,9);
        graph.addDirectedEdge(9,7);

        ArrayList<ArrayList<Integer>> adjList = Graph.getAdj();
        boolean[] visited = new boolean[adjList.size() + 1];
        boolean[] dfsVisited = new boolean[adjList.size() + 1];

        for (int i=0; i< adjList.size(); i++){
            if(!visited[i]){
                if(detectCycle(i, visited, dfsVisited, adjList)) {
                    System.out.println("GRAPH HAS A CYCLE");
                    break;
                }
            }
        }
    }
}
