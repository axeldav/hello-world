import java.util.Collection;
import java.util.LinkedList;

abstract class MyNode {

    protected boolean visited = false;

    abstract public boolean addEdge(Edge edge);

    abstract public String getName();

    public abstract void setVisitedTrue();

    public abstract boolean isVisited();

    public abstract Collection<Edge> getNeighbours();


}
