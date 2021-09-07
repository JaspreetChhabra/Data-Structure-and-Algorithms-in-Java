package Graphs;

import java.util.*;

public class ShortestPathUDDijsktraAlgo {

    private static void calculateDistance(ArrayList<ArrayList<Node>> adjList, int source, int N){

        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<Node>(N, new Node());
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()){

            Node curr = pq.poll();

            for (Node edge: adjList.get(curr.v)){
                if(dist[edge.v] > curr.weight + edge.weight){
                    dist[edge.v] = curr.weight + edge.weight;
                    pq.add(new Node(edge.v, dist[edge.v]));
                }
            }
        }

        for (int i = 0; i < N; i++)
        {
            System.out.print( dist[i] + " ");
        }
    }
    public static void main(String[] args){

        int n =5;
        ArrayList<ArrayList<Node> > adj = new ArrayList<ArrayList<Node> >();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Node>());

        adj.get(0).add(new Node(1, 2));
        adj.get(1).add(new Node(0, 2));

        adj.get(1).add(new Node(2, 4));
        adj.get(2).add(new Node(1, 4));

        adj.get(0).add(new Node(3, 1));
        adj.get(3).add(new Node(0, 1));

        adj.get(3).add(new Node(2, 3));
        adj.get(2).add(new Node(3, 3));

        adj.get(1).add(new Node(4, 5));
        adj.get(4).add(new Node(1, 5));

        adj.get(2).add(new Node(4, 1));
        adj.get(4).add(new Node(2, 1));
        calculateDistance(adj, 0, n);
    }

    static class Node implements Comparator<Node> {
        int v;
        int weight;

        public Node(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        public Node() {
        }

        @Override
        public int compare(Node n1, Node n2){
            if(n1.weight < n2.weight)
                return -1;
            else if(n1.weight > n2.weight)
                return 1;
            else return 0;
        }
    }
}
