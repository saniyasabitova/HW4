public class Main {

    public static void main(String[] args) {
        WeightedGraph<String> weightedGraph = new WeightedGraph<>(true);

          Vertex<String> num1 = new Vertex<>("Alanya");
        Vertex<String> num2 = new Vertex<>("Istanbul");
        Vertex<String> num3 = new Vertex<>("Kemer");
        Vertex<String> num4 = new Vertex<>("Antalya");
        Vertex<String> num5 = new Vertex<>("Denizli");
        Vertex<String> num6 = new Vertex<>("Ankara");
        Vertex<String> num7 = new Vertex<>("Izmir");
        fillWithWeights(weightedGraph,num1,num2,num3,num4,num5,num6,num7);

        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(weightedGraph, num1);
        outputPath(djk, num5);


        System.out.println("--------------------------------");

        MyGraph<String> graph = new MyGraph<>(true);
        fillWithoutWeights(graph,num1,num2,num3,num4,num5,num6,num7);


        System.out.println("--------------------------------");

        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<String>(graph, num1);
        outputPath(bfs, num7);
    }

    public static void fillWithoutWeights(MyGraph<String> graph,Vertex<String> num1,Vertex<String> num2,Vertex<String> num3,Vertex<String> num4,Vertex<String> num5,Vertex<String> num6,Vertex<String> num7) {graph.addVertex(num1);
      graph.addVertex(num2);
      graph.addVertex(num3);
      graph.addVertex(num4);
      graph.addVertex(num5);
      graph.addVertex(num6);
      graph.addVertex(num7);

      graph.addEdge(num1,num2);
      graph.addEdge(num2,num3);
      graph.addEdge(num3,num4);
      graph.addEdge(num4,num5);
      graph.addEdge(num5,num6);
      graph.addEdge(num6,num7);

    }



    public static void fillWithWeights(WeightedGraph<String> graph,Vertex<String> num1,Vertex<String> num2,Vertex<String> num3,Vertex<String> num4,Vertex<String> num5,Vertex<String> num6,Vertex<String> num7) {
        graph.addVertex(num1);
      graph.addVertex(num2);
      graph.addVertex(num3);
      graph.addVertex(num4);
      graph.addVertex(num5);
      graph.addVertex(num6);
      graph.addVertex(num7);

      graph.addEdge(num1,num2,35);
      graph.addEdge(num2,num3,500);
      graph.addEdge(num3,num4,10);
      graph.addEdge(num4,num5,50);
      graph.addEdge(num5,num6,40);
      graph.addEdge(num6,num7,10);


    }

    public static void outputPath(Search<String> search, Vertex<String> key) {
        for (Vertex<String> v : search.pathTo(key)) {
            System.out.print(v.getData() + " -> ");
        }

        System.out.println();
    }
}