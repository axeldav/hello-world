import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;

public class MovieNode extends MyNode{
    //list of actors for movie
    private LinkedList<MyNode> actors;
    private String title;
    private ArrayList<String> path;

    MovieNode(String title){
        this.title = title;
        actors = new LinkedList<MyNode>();
        path = new ArrayList<String>();
    }



    @Override
    protected boolean add(MyNode node) {
        return actors.add(node);
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
    public Collection<MyNode> getNeighbours() {
        return actors;
    }

    @Override
    public void addToPath(String name) {
        path.add(name);
    }

    @Override
    public ArrayList<String> getPath() {
        return path;
    }

    @Override
    public String showPath() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieNode movieNode = (MovieNode) o;
        return Objects.equals(title, movieNode.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return getName();
    }
}

