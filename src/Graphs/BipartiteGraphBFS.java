package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraphBFS {

    private static boolean isBipartite(ArrayList<ArrayList<Integer>> adjList, int node, int[] color){

        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node] = 0;

        while (!q.isEmpty()){

            int v = q.poll();
            for(int vertex: adjList.get(v)){
                if(color[vertex] == -1) {
                    color[vertex] = 1 - color[v];
                    q.add(vertex);
                }
                else if(color[vertex] == color[v]) return false;
            }
        }
        return true;
    }

    private static boolean checkBipartite(ArrayList<ArrayList<Integer>> adjList) {

        int[] color = new int[adjList.size()+1];
        Arrays.fill(color, -1);

        for (int i=0; i < adjList.size(); i++){
            if(color[i] == -1){
                if(!isBipartite(adjList, i, color)) return false;
            }
        }

        return true;
    }

    public static void main(String[] args){

        Graph bipartite = new Graph(9);

        bipartite.addEdge(1, 2);
        bipartite.addEdge(2, 3);
        bipartite.addEdge(2, 8);
        bipartite.addEdge(3,4);
        bipartite.addEdge(4,5);
        bipartite.addEdge(8,5);
        bipartite.addEdge(5,6);
        bipartite.addEdge(6,7);

        ArrayList<ArrayList<Integer>> adjList = Graph.getAdj();
        System.out.println("Graph is Bipartite : "+ checkBipartite(adjList));

        bipartite = new Graph(9);

        bipartite.addEdge(1, 2);
        bipartite.addEdge(2, 3);
        bipartite.addEdge(2, 7);
        bipartite.addEdge(3,4);
        bipartite.addEdge(4,5);
        bipartite.addEdge(7,6);
        bipartite.addEdge(6,5);
        bipartite.addEdge(5,8);
        adjList = Graph.getAdj();
        System.out.println("Graph is Bipartite : "+ checkBipartite(adjList));
    }
}
