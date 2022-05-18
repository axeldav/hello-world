import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Graph {

    HashMap<MyNode,MyNode> nodes;

    /**
     * Har samma nod för både key och value för att den lätt ska kunna hämtas ur Hashmappen, O(1)
     */
    Graph(){
        nodes = new HashMap<MyNode, MyNode>();
    }


    /**
     * ActorNode - har en lista med MovieNodes
     * MovieNode - har en lista med ActorNodes
     *
     * Det finns många dubletter av Movies i filen, men alla Actor finns bara en gång
     * Därför är koden utformad så att den först kollar efter Actor, sparar den Actor i variabeln
     * samtidigt som den går igenom alla Movies för den Actor
     *
     * @param path
     * @throws IOException
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

                    nodes.get(tempMov).add(tempAct); //add actor to actorlist of this movie
                    tempAct.add(nodes.get(tempMov)); //add this movie to movielist of actor

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


    /**
     *
     * @param goal - Noden som man ska starta ifrån, - Kevin Bacon
     * @param start - noden som man ska starta från -
     * @return
     */
    public MyNode bfs(MyNode goal, MyNode start){
        //poll() tar ut det första elementet ur kön
        Queue<MyPair> queue = new LinkedList<>();

        int depth = 0;
        queue.add(new MyPair(goal, depth));
        goal.setVisitedTrue();

        while (!queue.isEmpty()){
            MyPair tempPair = queue.poll();

            if (tempPair.getKey().getName().equals(start.getName()))
                return tempPair.getKey();

            MyNode tempNode = (MyNode) tempPair.getKey();
            depth = tempPair.getValue();

            for (MyNode neighbour: tempNode.getNeighbours()) {

                if(!neighbour.isVisited()){
                    queue.add(new MyPair(neighbour, depth+1));
                    neighbour.setVisitedTrue();

                    //för varje neighbout som besöks, lägg till parent-nodens path till den
                    for (String path:tempNode.getPath()) {
                        neighbour.addToPath(path);
                    }
                    //lägg till parent-noden själv till path också
                    neighbour.addToPath(tempNode.getName());
                }
            }

        }
        return null;

    }
}