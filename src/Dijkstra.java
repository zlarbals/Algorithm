/*
시작지점에서 모든 지점까지의 최소 거리 구하기.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {

    private int[] result;

    public int[] getResult() {
        return result;
    }

    public void doDijkstra(ArrayList<ArrayList<DijkstraNode>> graph, int startNode, int nodeCount) {
        result = new int[nodeCount+1];
        Arrays.fill(result,Integer.MAX_VALUE);
        PriorityQueue<DijkstraNode> pq = new PriorityQueue<>();

        pq.offer(new DijkstraNode(startNode,0));
        result[startNode]=0;

        while(!pq.isEmpty()){
            DijkstraNode node = pq.poll();
            int now=node.getIndex();
            int distance=node.getDistance();

            if(result[now]<distance)
                continue;

            for(int i=0;i<graph.get(now).size();i++){
                int cost=distance+graph.get(now).get(i).getDistance();

                if(cost<result[graph.get(now).get(i).getIndex()]){
                    result[graph.get(now).get(i).getIndex()]=cost;
                    pq.offer(new DijkstraNode(graph.get(now).get(i).getIndex(),cost));
                }
            }
        }

    }

}
