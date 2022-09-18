package graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {

    private T value;
    private List<Edge<T>> edges;
    private boolean dijkstraVisited = false;
    private int dijkstraDistance;
    private Vertex<T> dijkstraDerived;
    private int astarG = 0;
    private int astarH = 0;
    private int astarF = 0;

    
    public Vertex(T value){
        this.value = value;
        this.edges = new ArrayList<Edge<T>>();
    }
    
    public Vertex(){}
    
    public T getValue(){
        return this.value;
    }
    
    public void addEdge(Edge<T> edge){
        this.edges.add(edge);
    }
    
    public List<Edge<T>> getEdges(){
        return this.edges;
    }
    
    public boolean isDijkstraVisited() {
        return dijkstraVisited;
    }
    
    public void setDijkstraVisited(boolean visited) {
        this.dijkstraVisited = visited;
    }
    
    public int getDijkstraDistance() {
        return dijkstraDistance;
    }
    
    public void setDijkstraDistance(int dijkstraDistance) {
        this.dijkstraDistance = dijkstraDistance;
    }
    
    public Vertex<T> getDijkstraDerived() {
        return dijkstraDerived;
    }

    public void setDijkstraDerived(Vertex<T> dijkstraDerived) {
        this.dijkstraDerived = dijkstraDerived;
    }

    public int getAstarG() {
        return astarG;
    }

    public void setAstarG(int astarG) {
        this.astarG = astarG;
    }

    public int getAstarH() {
        return astarH;
    }

    public void setAstarH(int astarH) {
        this.astarH = astarH;
    }

    public int getAstarF() {
        return astarF;
    }

    public void setAstarF(int astarF) {
        this.astarF = astarF;
    }

    

}