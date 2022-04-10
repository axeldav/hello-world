import java.util.LinkedList;

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
}
