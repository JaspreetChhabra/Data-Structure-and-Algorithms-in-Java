package Graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PrimsAlgorithm {

    private void primsAlgo(ArrayList<ArrayList<PrimsNode>> adjList, int N){

        int[] parent = new int[N];
        int[] key = new int[N];
        boolean[] mst = new boolean[N];
        for (int i=0; i < N; i++){
            key[i] = Integer.MAX_VALUE;
            mst[i] = false;
        }

        PriorityQueue<PrimsNode> pq = new PriorityQueue<PrimsNode>(N, new PrimsNode());
        key[0] = 0;
        parent[0] = -1;
        pq.add(new PrimsNode(key[0], 0));

        while (!pq.isEmpty()){
            PrimsNode node = pq.poll();
            mst[node.getV()] = true;

            for (PrimsNode e: adjList.get(node.getV())){
                if(!mst[e.getV()] && e.getWeight() < key[e.getV()]){
                    parent[e.getV()] = node.getV();
                    key[e.getV()] = e.getWeight();
                    pq.add(new PrimsNode(e.getV(), key[e.getV()]));
                }
            }
        }

        for(int i = 1;i<N;i++) {
            System.out.println(parent[i] + " - " + i);
        }
    }
    public static void main(String args[])
    {
        int n = 5;
        ArrayList<ArrayList<PrimsNode>> adj = new ArrayList<ArrayList<PrimsNode> >();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<PrimsNode>());

        adj.get(0).add(new PrimsNode(1, 2));
        adj.get(1).add(new PrimsNode(0, 2));

        adj.get(1).add(new PrimsNode(2, 3));
        adj.get(2).add(new PrimsNode(1, 3));

        adj.get(0).add(new PrimsNode(3, 6));
        adj.get(3).add(new PrimsNode(0, 6));

        adj.get(1).add(new PrimsNode(3, 8));
        adj.get(3).add(new PrimsNode(1, 8));

        adj.get(1).add(new PrimsNode(4, 5));
        adj.get(4).add(new PrimsNode(1, 5));

        adj.get(2).add(new PrimsNode(4, 7));
        adj.get(4).add(new PrimsNode(2, 7));

        PrimsAlgorithm primsAlgorithm = new PrimsAlgorithm();
        primsAlgorithm.primsAlgo(adj, n);

    }

}

class PrimsNode implements Comparator<PrimsNode>
{
    private int v;
    private int weight;

    PrimsNode(int _v, int _w) { v = _v; weight = _w; }

    PrimsNode() {}

    int getV() { return v; }
    int getWeight() { return weight; }

    @Override
    public int compare(PrimsNode primsNode1, PrimsNode primsNode2)
    {
        if (primsNode1.weight < primsNode2.weight)
            return -1;
        if (primsNode1.weight > primsNode2.weight)
            return 1;
        return 0;
    }
}

