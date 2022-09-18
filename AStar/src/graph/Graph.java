package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph<T> {

    private List<Vertex<T>> vertexList;
    private List<Edge<T>> edgeList;

    public Graph(){
        this.vertexList = new ArrayList<Vertex<T>>();
        this.edgeList = new ArrayList<Edge<T>>();
    }
    
    public void addVertex(T value){
        this.vertexList.add(new Vertex<T>(value));
    }

    public void addEdge(T or, T de, int dist){
        Vertex<T> vertOr = this.getVertex(or);
        Vertex<T> vertDe = this.getVertex(de);
        Edge<T> edgeOr = new Edge<T>(vertOr, vertDe, dist);
        Edge<T> edgeDe = new Edge<T>(vertDe, vertOr, dist);

        this.edgeList.add(edgeOr);
        this.edgeList.add(edgeDe);
        vertOr.addEdge(edgeOr);
        vertDe.addEdge(edgeDe);
    }

    public Vertex<T> getVertex(T vertexName){
        Vertex<T> vertex = new Vertex<T>();
        for(Vertex<T> v : this.vertexList){
            if(v.getValue().equals(vertexName)) vertex = v;
            
        }
        return vertex;
    }

    public List<Vertex<T>> getVertexList(){
        return this.vertexList;
    }

    public void resetDijkstraValues(){
        this.vertexList.forEach(v -> {
            v.setDijkstraDistance(Integer.MAX_VALUE);
            v.setDijkstraVisited(false);
            v.setDijkstraDerived(null);
        });
    }

}