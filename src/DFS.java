public class DFS {
    public void DFS(int[][] graph,boolean[] check,int x){
        //check visit
        check[x]=true;
        System.out.println(x);

        //graph start index is 1.
        //node 0 does not exist.
        for(int i=1;i<graph.length;i++){
            if(graph[x][i]!=0&&check[i]==false)
                DFS(graph, check, i);
        }
    }
}
