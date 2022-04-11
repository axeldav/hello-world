import java.util.Collection;
import java.util.LinkedList;

public class MovieNode extends MyNode{
    //list of actors for movie
    LinkedList<Edge> actors;
    String title;

    MovieNode(String title){
        this.title = title;
        actors = new LinkedList<Edge>();
    }


    @Override
    public boolean addEdge(Edge edge) {
        return actors.add(edge);
    }

    @Override
    public String getName() {
        return title;
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
        return actors;
    }

    @Override
    public String toString() {
        String str = "";
        str += "| " +  title + " |";
        for (Edge e:actors) {
            str += " -> ";
            str+= e.dest.getName() + " ";
        }
        return str;
    }
}

