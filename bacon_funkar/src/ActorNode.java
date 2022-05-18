import java.util.*;

public class ActorNode extends MyNode {
    //list of movies for actor
    private LinkedList<MyNode> movies;
    private String name;
    private ArrayList<String> path;



    public ActorNode(String name){
        movies = new LinkedList<>();
        this.name = name;
        path = new ArrayList<>();
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
    public void addToPath(String name) {
        path.add(name);
    }

    @Override
    public ArrayList<String> getPath() {
        return path;
    }

    @Override
    protected boolean add(MyNode node) {
        return movies.add(node);
    }

    @Override
    public String showPath() {
        String result = "here is the path: " + getName();
        for (int i = path.size()-1; i >= 0 ; i--) {
            result += " -> " +  path.get(i);

        }
        int nr = path.size()/2;
        result += " |||  BACON_NR: " + nr;
        return result;
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
