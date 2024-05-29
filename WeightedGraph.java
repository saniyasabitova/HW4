import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraph<V> {
 private final boolean undirected;
    private final Map<Vertex<V>, HashMap<Vertex<V>,Double>> map = new HashMap<>();

    public WeightedGraph() {
        this(true);
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addEdge(Vertex<V> source, Vertex<V> dest, double weight) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest)
                || source.equals(dest))
            return; // reject parallels & self-loops

        map.get(source).put(dest,weight);

        if (undirected)
           map.get(dest).put(source,weight);
    }

    public void addVertex(Vertex<V> v) {
        if (hasVertex(v))
            return;

        map.put(v, new HashMap<>());
    }
    public boolean hasVertex(Vertex<V> v){
    return map.containsKey(v);
    }
    public boolean hasEdge(Vertex<V> source, Vertex<V> dest) {
        if (!hasVertex(source)) return false;
        return map.get(source).containsKey(dest);
    }
public int numberOfVertices(){
        return map.size();
}
public int numberOfEdges(){
        int count =0;
        for(HashMap<Vertex<V>,Double> vd : map.values()){
        count+= vd.size();
    }
        return count;
}
public double getWeight(Vertex start, Vertex dest){
        if (!map.containsKey(start)){
            return -1;
        }
        return map.get(start).get(dest);
}
public List<Vertex<V>> adjacencyList(Vertex v){
List<Vertex<V>> vertices = new ArrayList<>();
HashMap<Vertex<V>,Double> vd = map.get(v);
for (Vertex d: vd.keySet()){
    vertices.add(d);

}
return vertices;
}
public Map<Vertex<V>, Double> getAdjacentVerticesWithWeights(Vertex v){
HashMap<Vertex<V>,Double> vd = map.get(v);
for (Vertex d: vd.keySet()){
    System.out.println(d+" "+ vd.get(d));
}
  return vd;
}
}

