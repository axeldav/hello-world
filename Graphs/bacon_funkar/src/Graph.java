import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Graph {

    HashMap<MyNode,MyNode> nodes;

    Graph(){
        nodes = new HashMap<MyNode, MyNode>();
    }

    /*
    public boolean addEdge(MyNode actor, MyNode movie){
        return actor.addEdge(new Edge(movie)) &&
                movie.addEdge(new Edge(actor));
    }


    public boolean addEdge(int weight ,MyNode actor, MyNode movie){
        return actor.addEdge(new Edge(weight, movie));
    }
     */

    public void createGraphFromFile(String path) throws IOException {
        FileInputStream inputStream = new FileInputStream(path);
        Scanner sc = new Scanner(inputStream);

        ActorNode tempAct = null;
        while (sc.hasNextLine()){
            String line = sc.nextLine();

            if(line.charAt(1) == 'a'){
                //lägger till actor
                tempAct = new ActorNode(line);
                nodes.put(tempAct, tempAct);

            } else {
                MovieNode tempMov = new MovieNode(line);
                //ska också lägga till movie i nodes om den inte finns
                //nodes.put(tempMov, tempMov);
                if (nodes.containsKey(tempMov)) {
                    nodes.get(tempMov).add(tempAct);
                    tempAct.add(nodes.get(tempMov));
                }
                else {
                    tempMov.add(tempAct);
                    tempAct.add(tempMov);
                    nodes.put(tempMov, tempMov);

                }
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


            MyNode tempNode = (MyNode) tempPair.getKey();
            depth = tempPair.getValue();
            for (MyNode neighbour: tempNode.getNeighbours()) {
                if(!neighbour.isVisited()){
                    queue.add(new MyPair(neighbour, depth+1));
                    neighbour.setVisitedTrue();
                }
            }

        }
        return -1;

    }
}