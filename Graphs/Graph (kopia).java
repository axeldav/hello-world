import java.util.*;

public class Graph {


    /**
     * Den här implementationen är alltså en lista av listor, och listan själv
     * är själva noden, detta skulle kunna göras med en map också:
     * map<nod,lista_med_grannar>
     *
     * @param adj - grafen- en arraylista av arraylistor, implementation av
     *            Adjacency List
     * @param a - vilken av listan, den fungerar som "nod" i det här fallet
     * @param b - noden/talet som ska placeras i den listan
     */
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int a, int b){
        adj.get(a).add(b);
        adj.get(b).add(a);
    }

    static void printGraph(ArrayList<ArrayList<Integer>> adj){

        //igenom listorna
        for(int i = 0; i < adj.size(); i++){

            System.out.print("node/list nr " + i +  " has neighbours: ");

            //igenom listan i listan
            for(int j = 0; j <adj.get(i).size(); j++){

                System.out.print(adj.get(i).get(j) + ", ");

            }

            //för att printa en ny rad
            System.out.println();
        }
     }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(V);

        for(int i = 0; i < V; i++)
            graph.add(new ArrayList<Integer>());


        addEdge(graph, 0,1);
        addEdge(graph, 0,2);
        addEdge(graph, 0,4);
        addEdge(graph, 1,2);
        addEdge(graph, 1,3);

        printGraph(graph);
    }
}