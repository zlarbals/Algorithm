import java.util.Arrays;

public class Dijkstra {
    public void doDijkstra(int[][] graph,int startNode){
        int graphSize=graph.length;
        int temp;
        int[] distance = new int[graphSize];
        boolean[] check = new boolean[graphSize];

        Arrays.fill(distance,Integer.MAX_VALUE);

        distance[startNode]=0;

        for(int i=0;i<graphSize-1;i++){
            temp=findMinNodeIndex(distance,check);
            check[temp]=true;

            for(int j=1;j<graphSize;j++){
                //1.j노드 방문한 적 없고
                //2.현재의 temp 노드에서 j 노드로 가능 경로 존재하고
                //3.현재의 temp 노드로 가는 거리가 존재하고
                //4.temp 노드까지의 거리+temp 에서 j 노드까지의 가중치 < 현재 적용되어있는 j 노드까지의 거리
                if(check[j]==false&&graph[temp][j]!=0&&distance[temp]!=Integer.MAX_VALUE&&distance[temp]+graph[temp][j]<distance[j])
                    distance[j]=distance[temp]+graph[temp][j];
            }
        }
        print(distance,startNode);
    }

    private int findMinNodeIndex(int[] distance, boolean[] check) {
        int min, minIndex;
        min = Integer.MAX_VALUE;
        minIndex = -1;

        for (int i = 1; i < distance.length; i++) {
            if (check[i] == false && distance[i] < min) {
                min = distance[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    private void print(int[] distance,int startNode){
        System.out.println("startNode : "+startNode);
        for(int i=1;i<distance.length;i++){
            System.out.println("distance to "+i+" node : "+distance[i]);
        }
    }
}
