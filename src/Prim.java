import java.util.Arrays;

public class Prim {
    public void doPrim(int[][] graph, int startNode) {
        int graphSize = graph.length;
        int temp;

        int[] selectedNode = new int[graphSize];
        int[] weight = new int[graphSize];
        boolean[] check = new boolean[graphSize];

        Arrays.fill(weight, Integer.MAX_VALUE);

        weight[startNode] = 0;
        selectedNode[startNode] = startNode;

        for (int i = 0; i < graphSize - 1; i++) {
            temp = findMinNodeIndex(weight, check);
            check[temp] = true;

            //graph start index is 1.
            //node 0 does not exist.
            for (int j = 1; j < graphSize; j++) {
                if (graph[temp][j] != 0 && check[j] == false && graph[temp][j] < weight[j]) {
                    selectedNode[j] = temp;
                    weight[j] = graph[temp][j];
                }
            }
        }

        print(selectedNode);

    }

    private int findMinNodeIndex(int[] weight, boolean[] check) {
        int min, minIndex;
        min = Integer.MAX_VALUE;
        minIndex = -1;

        for (int i = 1; i < weight.length; i++) {
            if (check[i] == false && weight[i] < min) {
                min = weight[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    private void print(int[] selectedNode){
        for(int i=1;i<selectedNode.length;i++)
            System.out.println(selectedNode[i]+" - " + i);
    }
}
