package Graphs;

import java.util.ArrayList;

public class DFS {

    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    int V =0;
    DFS (int v){
        V = v;

        for (int i =0; i<V;i++)
            graph.add(new ArrayList<>());
    }

    public void addEdge(int u, int v) {
        graph.get(u).add(v);
    }

    public ArrayList<Integer> getDfs() {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> dfsArray = new ArrayList<>();

        for (int i=0; i < V; i++){
            if(!visited[i])
                dfsUtil(i, visited, dfsArray);
        }

        return dfsArray;
    }

    public void dfsUtil(int node, boolean[] visited, ArrayList<Integer> dfsArray){

        dfsArray.add(node);
        visited[node] = true;

        for (int edge: graph.get(node)){
            if(!visited[edge]) {
                dfsUtil(edge, visited, dfsArray);
            }
        }
    }

    public void printGraph(){
        for (int i =0; i < V;i++){
            System.out.println(" ");
            System.out.print("Edge from :" + i);
            for (int edge: graph.get(i)){
                System.out.print(" --> " + edge);
            }
        }
    }
    public static void main(String[] args){

        DFS g = new DFS(4);
        // Adding edges one by one
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.printGraph();
        System.out.println(" ");
        System.out.println("DFS :");
        g.getDfs().forEach(System.out::println);

    }
}
