public class KruskalEdge implements Comparable<KruskalEdge>{
    //a노드(nodeA)에서 b노드(nodeB)까지의 거리(distance)
    private int nodeA;
    private int nodeB;
    private int distance;

    public KruskalEdge(int nodeA, int nodeB, int distance) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.distance = distance;
    }

    public int getNodeA() {
        return nodeA;
    }

    public int getNodeB() {
        return nodeB;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(KruskalEdge o) {
        return Integer.compare(this.getDistance(),o.getDistance());
    }
}
