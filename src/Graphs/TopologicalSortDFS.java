package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortDFS {

    private static void dfs(ArrayList<ArrayList<Integer>> adjList, boolean[] visited, Stack<Integer> topoStack, int vertex){

        visited[vertex] = true;

        for (int v: adjList.get(vertex)){
            if(!visited[v])
                dfs(adjList, visited, topoStack, v);
        }
        topoStack.push(vertex);
    }
    public static void main(String[] args){
        Graph g = new Graph(6);

        g.addDirectedEdge(2,3);
        g.addDirectedEdge(3, 1);
        g.addDirectedEdge(4, 0);
        g.addDirectedEdge(4, 1);
        g.addDirectedEdge(5, 0);
        g.addDirectedEdge(5, 2);

        ArrayList<ArrayList<Integer>> adjList = Graph.getAdj();
        Stack<Integer> topoStack = new Stack<>();
        boolean[] visited = new boolean[6];
        for (int i=0; i< 6; i++){
            if(!visited[i])
                dfs(adjList, visited, topoStack, i);
        }

        while (!topoStack.isEmpty()){
            System.out.println(topoStack.pop());
        }
    }
}
