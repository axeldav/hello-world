import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Graph {

    HashMap<MyNode,MyNode> nodes;

    Graph(){
        nodes = new HashMap<MyNode, MyNode>();
    }

    public boolean addEdge(MyNode actor, MyNode movie){
        return actor.addEdge(new Edge(movie)) &&
                movie.addEdge(new Edge(actor));
    }
    public boolean addEdge(int weight ,MyNode actor, MyNode movie){
        return actor.addEdge(new Edge(weight, movie));
    }

    public void createGraphFromFile(String path) throws IOException {
        FileInputStream inputStream = new FileInputStream(path);
        Scanner sc = new Scanner(inputStream);

        ActorNode tempAct = null;
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            if(line.charAt(1) == 'a'){
                tempAct = new ActorNode(line);
                nodes.put(tempAct, tempAct);
            } else if (line.charAt(1) == 't'){
                MovieNode tempMov = new MovieNode(line);
                nodes.put(tempMov, tempMov);
                addEdge(tempAct, tempMov);
            }
        }
        inputStream.close();
        sc.close();
    }

    public int bfs(MyNode startNode, MyNode goalNode){
        //poll() tar ut det första elementet ur kön
        Queue<MyPair> queue = new LinkedList<>();

        int depth = 0;
        queue.add(new MyPair(startNode, depth));
        startNode.setVisitedTrue();

        while (!queue.isEmpty()){
            MyPair tempPair = queue.poll();

            if (tempPair.getKey().getName().equals(goalNode.getName()))
                return (int) tempPair.getValue();
            
            depth++;
            MyNode tempNode = (MyNode) tempPair.getKey();
            for (Edge neighbour: tempNode.getNeighbours()) {
                if(!neighbour.dest.isVisited()){
                    queue.add(new MyPair(neighbour.dest, depth));
                    neighbour.dest.setVisitedTrue();
                }
            }

        }
        return -1;

    }

}