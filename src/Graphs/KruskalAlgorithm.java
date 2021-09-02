package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class KruskalAlgorithm {

    static int[] parent = null;
    static int[] rank = null;

    public static void makeSet(int N){

        parent = new int[N];
        rank = new int[N];
        for (int i=0; i < N; i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public static int findParent(int node){
        if(node == parent[node]){
            return node;
        }
        return parent[node] = findParent(parent[node]);
    }

    public static void union(int u, int v){
        u = findParent(u);
        v = findParent(v);

        if(rank[u] < rank[v]) parent[u] = v;
        else if(rank[u] > rank[v]) parent[v] = u;
        else {
            parent[v] = u;
            rank[u]++;
        }
    }

    private int kruskalAlgo(ArrayList<Node> adj, int N){

        ArrayList<Node> mst = new ArrayList<>();
        Collections.sort(adj, new NodeComparator());

        int costMst = 0;

        for (int i =0; i < adj.size(); i++){
            Node n = adj.get(i);
            if(findParent(n.u) != findParent(n.v)){
                costMst += n.weight;
                mst.add(n);
                union(n.u, n.v);
            }
        }

        return costMst;
    }

    public static void main(String[] args){

        int n = 5;
        ArrayList<Node> adj = new ArrayList<Node>();


        adj.add(new Node(0, 1, 2));
        adj.add(new Node(0, 3, 6));
        adj.add(new Node(1, 3, 8));
        adj.add(new Node(1, 2, 3));
        adj.add(new Node(1, 4, 5));
        adj.add(new Node(2, 4, 7));


        KruskalAlgorithm kruskalAlgorithm = new KruskalAlgorithm();
        makeSet(9);
        System.out.println(kruskalAlgorithm.kruskalAlgo(adj, n));
    }

}


class Node {

    int weight;
    int u;
    int v;

    public Node(int weight, int u, int v) {
        this.weight = weight;
        this.u = u;
        this.v = v;
    }
}

class NodeComparator implements Comparator<Node>{
    @Override
    public int compare(Node o1, Node o2) {
        if(o1.weight < o2.weight) return -1;
        else if(o1.weight > o2.weight) return 1;
        else return 0;
    }
}