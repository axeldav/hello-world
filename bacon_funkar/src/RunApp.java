import java.io.IOException;
import java.util.Scanner;

public class RunApp {

    public static void main(String[] args) {
        try {
            Graph graph = new Graph();
            graph.createGraphFromFile("moviedata.txt");
            Scanner scanner = new Scanner(System.in);

            System.out.println("Write the name of actor to find Their Bacon-number: \n Write on the format: Surname, Firstname (ex. DiCaprio, Leonardo)");
            String input = scanner.nextLine();

            MyNode bacon = graph.nodes.get(new ActorNode("<a>Bacon, Kevin (I)"));
            MyNode actor = graph.nodes.get(new ActorNode("<a>" + input));

            MyNode baconNr = graph.bfs(bacon, actor);
            System.out.println("\n "+ baconNr.showPath());


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
