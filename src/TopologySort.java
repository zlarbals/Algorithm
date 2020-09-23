/*
방향 그래프의 모든 노드를 방향성을 거스르지 않도록 순서대로 나열.
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologySort {

    private ArrayList<Integer> result;

    public ArrayList<Integer> getResult() {
        return result;
    }

    public void doTopologySort(ArrayList<ArrayList<Integer>> graph, int[] indegree, int nodeCount){
        Queue<Integer> queue = new LinkedList<>();
        int[] indegreeClone=indegree.clone();

        for(int i=1;i<=nodeCount;i++){
            if(indegreeClone[i]==0)
                queue.offer(i);
        }

        result=new ArrayList<>();
        while(!queue.isEmpty()){
            int now = queue.poll();
            result.add(now);

            for(int i=0;i<graph.get(now).size();i++){
                indegreeClone[graph.get(now).get(i)]--;

                if(indegreeClone[graph.get(now).get(i)]==0)
                    queue.offer(graph.get(now).get(i));
            }
        }

    }

}
