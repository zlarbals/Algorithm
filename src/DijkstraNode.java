class DijkstraNode implements Comparable<DijkstraNode>{
    private int index;
    private int distance;

    public DijkstraNode(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(DijkstraNode o) {
        //오름차순 정렬
        return Integer.compare(this.distance,o.getDistance());
    }
}