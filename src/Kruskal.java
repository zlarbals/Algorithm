import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Kruskal {
    private class Edge{
        private int u;
        private int v;
        private int weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    public ArrayList<Edge> extractEdges(int[][] graph) {
       int temp = graph.length;
        ArrayList<Edge> edges = new ArrayList<Edge>();

        for (int i = 1; i < temp; i++) {
            for (int j = i + 1; j < temp; j++) {
                if (graph[i][j] != 0) {
                    edges.add(new Edge(i,j,graph[i][j]));
                }
            }
        }
        return edges;
    }

    public void doKruskal(int[][] graph) {
        int graphSize, nodeNumber;
        int[][] mst;
        ArrayList<Edge> edges;
        edges = extractEdges(graph);
        graphSize = graph.length;
        nodeNumber = graphSize - 1;

        mst = new int[graphSize][graphSize];

        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {
                if(e1.weight>e2.weight)
                    return 1;
                else if(e1.weight<e2.weight)
                    return -1;
                else
                    return 0;
            }
        });

        int[] parents = new int[graphSize];
        int[] size = new int[graphSize];
        for (int i = 1; i < graphSize; i++) {
            parents[i] = i;
            size[i] = 1;
        }

        int edgeCounter = 0;
        int selectedEdgeNumber = 1;
        while (selectedEdgeNumber <= nodeNumber - 1) {
            Edge temp=edges.get(edgeCounter);
            edgeCounter++;

            if (isCycle(temp.u, temp.v, parents))
                continue;

            union(findParent(temp.u, parents), findParent(temp.v, parents), parents, size);
            mst[temp.u][temp.v] = temp.weight;
            selectedEdgeNumber++;
        }

        print(mst);
    }

    private void print(int[][] mst) {
        for (int i = 1; i < mst.length; i++) {
            for (int j = 1; j < mst.length; j++) {
                if (mst[i][j] != 0)
                    System.out.println(i + " " + j + " " + mst[i][j]);
            }
        }
    }

    private boolean isCycle(int u, int v, int[] parents) {
        return findParent(u, parents) == findParent(v, parents);
    }

    private void union(int u, int v, int[] parents, int[] size) {
        u = findParent(u, parents);
        v = findParent(v, parents);
        if (size[u] > size[v]) {
            parents[v] = u;
            size[u] += size[v];
        } else {
            parents[u] = v;
            size[v] += size[u];
        }
    }

    private int findParent(int u, int[] parents) {
        int parent = parents[u];
        while (parent != u) {
            u = parent;
            parent = parents[u];
        }
        return u;
    }
}
