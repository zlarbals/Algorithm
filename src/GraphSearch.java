import java.util.Queue;

public class GraphSearch {
    public void DFS(int[][] graph,boolean[] check,int x){
        //check visit
        check[x]=true;
        System.out.println(x+" ");

        //graph start index is 1.
        //node 0 does not exist.
        for(int i=1;i<graph.length;i++){
            if(graph[x][i]!=0&&check[i]==false)
                DFS(graph, check, i);
        }
    }

    /*
    example,

    queue.add(firstNode);
    check[firstNode]=true;
    BFS(graph,check,queue);
     */
    public void BFS(int[][] graph, boolean[] check, Queue<Integer> queue){
        int temp;

        while(queue.isEmpty()==false){
            temp=queue.remove();
            System.out.println(temp+" ");
            //graph start index is 1.
            //node 0 does not exist.
            for(int i=1;i<graph.length;i++){
                if(graph[temp][i]!=0&&check[i]==false){
                    check[i]=true;
                    queue.add(i);
                }
            }
        }

    }
}
