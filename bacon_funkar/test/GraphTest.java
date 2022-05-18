import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {


    @Test
    public void testReadGraph() throws IOException {
        Graph graph = new Graph();
        graph.createGraphFromFile("test2.txt");
        System.out.println("Hej");
    }


    @Test
    public void testTwoActorNodesEqualsEachOther(){

        assertEquals(new ActorNode("brad pitt"), new ActorNode("brad pitt"));
        assertEquals(new MovieNode("brad pitt"), new MovieNode("brad pitt"));
    }

    @Test
    public void getNodeFromGraph() throws IOException {
        Graph graph = new Graph();
        graph.createGraphFromFile("test.txt");
        MyNode n = graph.nodes.get(new ActorNode("<a>Dykes, Van"));
        System.out.println(n);

    }

    @Test
    public void getNeighboursFromNode() throws IOException {
        Graph graph = new Graph();
        graph.createGraphFromFile("test.txt");
        MyNode n = graph.nodes.get(new ActorNode("<a>Dykes, Van"));
        System.out.println(n.getNeighbours());

    }



    @Test
    public void bfsTest() throws IOException {
        Graph graph = new Graph();
        graph.createGraphFromFile("moviedata.txt");


        MyNode goal = graph.nodes.get(new ActorNode("<a>De Niro, Robert"));
        MyNode start = graph.nodes.get(new ActorNode("<a>Bacon, Kevin (I)"));
        MyNode beaconNR = graph.bfs(goal,start);
        System.out.println(beaconNR.showPath());
    }


}