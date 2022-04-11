import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;

public class ActorNode extends MyNode {
    //list of movies for actor
    LinkedList<Edge> movies;
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
    public Collection<Edge> getNeighbours() {
        return movies;
    }

    @Override
    public boolean addEdge(Edge edge) {
        return movies.add(edge);
    }

    @Override
    public String toString() {
        String str = "";
        str += "| " +  name + " |";
        for (Edge e:movies) {
            str += " -> ";
            str+= e.dest.getName() + " ";
        }
        return str;
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
}
