import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {


    @Test
    public void testTwoActorNodesEqualsEachOther(){

        assertEquals(new ActorNode("brad pitt"), new ActorNode("brad pitt"));
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


        MyNode start = graph.nodes.get(new ActorNode("<a>DiBona, Dennis"));
        MyNode end = graph.nodes.get(new ActorNode("<a>DiCaprio, Leonardo"));
        int nr = graph.bfs(start, end);
        System.out.println(nr);
    }


}