public class Edge {
    int weight = 0;
    MyNode dest;

    Edge(MyNode dest){
        this.dest = dest;
    }
    Edge(int weight, MyNode dest){
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EDGE to: " + dest.getName();
    }
}
