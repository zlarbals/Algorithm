/*
최소한의 비용으로 신장 트리 구하기
신장 트리 : 하나의 그래프가 있을 때 모든 노드를 포함하면서 사이클이 존재하지 않는 부분 그래프
 */


import java.util.ArrayList;
import java.util.Collections;

public class Kruskal {

    private int result;

    public int getResult() {
        return result;
    }

    public void doKruskal(ArrayList<KruskalEdge> edges, int nodeCount) {
        int[] parent = new int[nodeCount+1];
        for(int i=1;i<=nodeCount;i++)
            parent[i]=i;

        ArrayList<KruskalEdge> edgesClone = new ArrayList<>();
        edgesClone.addAll(edges);
        Collections.sort(edgesClone);

        result=0;
        for(int i=0;i<edgesClone.size();i++){
            KruskalEdge edge=edgesClone.get(i);
            int nodeA=edge.getNodeA();
            int nodeB=edge.getNodeB();
            int distance=edge.getDistance();

            if(findParent(nodeA,parent)!=findParent(nodeB,parent)){
                unionParent(nodeA,nodeB,parent);
                result+=distance;
            }
        }

    }

    private void unionParent(int nodeA, int nodeB, int[] parent) {
        int a=findParent(nodeA,parent);
        int b=findParent(nodeB,parent);

        if(a>b)
            parent[a]=b;
        else
            parent[b]=a;
    }

    private int findParent(int nodeA, int[] parent) {
        if(nodeA==parent[nodeA])
            return nodeA;
        else
            return parent[nodeA]=findParent(parent[nodeA],parent);
    }


}
