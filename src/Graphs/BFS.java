package Graphs;


import java.util.Iterator;
import java.util.LinkedList;

public class BFS {

    private int V;
    private LinkedList<Integer> adj[];

    public BFS(int v) {
        this.V = v;
        this.adj = new LinkedList[v];

        for (int i=0;i<v;i++){
            adj[i] = new LinkedList();
        }
    }

    public void addEdge(int u, int v){
         adj[u].add(v);
    }

    public void printBfs(int a){

        boolean[] visited = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(a);
        visited[a] = true;
        while(!queue.isEmpty()){
            a = queue.poll();
            System.out.println(a);

            Iterator<Integer> iterator = adj[a].listIterator();
            while (iterator.hasNext()){
                int next = iterator.next();
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String[] args){
        BFS g = new BFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.printBfs(2);
    }
}
