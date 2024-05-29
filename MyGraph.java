import java.util.*;
public class MyGraph<V> {
    private  boolean undirected;
    private final Map<Vertex<V>, List<Vertex<V>>> map = new HashMap<>();
     public MyGraph() {
        this(true);
    }

    public MyGraph(boolean undirected) {
        this.undirected = undirected;
    }
 public void addVertex(Vertex<V> v) {
        if (hasVertex(v))
            return;

        map.put(v, new LinkedList<>());
    }
//    public boolean hasVertex(Vertex v) {
//        return map.containsKey(v);
//    }
public void addEdge(Vertex<V> source, Vertex<V> dest) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest)
                || source.equals(dest))
            return; // reject parallels & self-loops

        map.get(source).add(dest);

        if (undirected)
            map.get(dest).add(source);
    }
     public boolean hasEdge(Vertex source, Vertex dest) {
        if (!hasVertex(source)) return false;
        return map.get(source).contains(dest);
    }
    public boolean hasVertex(Vertex<V> v){
    return map.containsKey(v);
    }
 public List<Vertex<V>> adjacencyList(Vertex v) {
        if (!hasVertex(v)) return null;

        return map.get(v);
    }



}
