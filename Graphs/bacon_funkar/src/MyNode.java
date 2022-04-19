import java.util.Collection;
import java.util.LinkedList;

abstract class MyNode {

    protected abstract boolean add(MyNode node);

    protected boolean visited = false;

    abstract public String getName();

    public abstract void setVisitedTrue();

    public abstract boolean isVisited();

    public abstract Collection<MyNode> getNeighbours();


}
