import java.util.*;

public class Vertex<V> {
    private V data;
    private Map<Vertex <V>,Double> adjacentVertices;
    public void addAjacentVertex(Vertex<V> dest, double weight){
        adjacentVertices.put(dest,weight);
    }

    public Vertex(V data) {
        this.data = data;
    }

    public V getData() {
        return data;
    }

    public void setData(V data) {
        this.data = data;
    }

    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }

    public void setAdjacentVertices(Map<Vertex<V>, Double> adjacentVertices) {
        this.adjacentVertices = adjacentVertices;
    }
   public boolean equals(Object o){
        if(this == o){
            return true;
        }
      if(o!=null || o.getClass()!=getClass()){
          return false;
      }
      Vertex<?> v = (Vertex<?>) o;
      return Objects.equals(data, v.data);
   }
   public int hashCode(){
return Objects.hash(data);
   }

}
