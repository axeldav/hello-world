import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;

public class ActorNode extends MyNode {
    //list of movies for actor
    LinkedList<MyNode> movies;
    String name;


    public ActorNode(String name){
        movies = new LinkedList<>();
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setVisitedTrue() {
        super.visited = true;
    }

    @Override
    public boolean isVisited() {
        return visited;
    }

    @Override
    public Collection<MyNode> getNeighbours() {
        return movies;
    }

    @Override
    protected boolean add(MyNode node) {
        return movies.add(node);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorNode actorNode = (ActorNode) o;
        return Objects.equals(name, actorNode.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return getName();
    }
}
