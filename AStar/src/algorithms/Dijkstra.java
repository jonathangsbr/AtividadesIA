package algorithms;

import java.util.LinkedList;
import java.util.Queue;

import graph.Edge;
import graph.Graph;
import graph.Vertex;

public class Dijkstra<T> {

    private Graph<T> graph;
    private Queue<Vertex<T>> priorityQueue;
    private Vertex<T> vertexOrigin;
    private Vertex<T> vertexDestination;

    
    public Dijkstra(Graph<T> graph) {
        this.graph = graph;
    }
    
    public void dijkstraTrigger(T origin, T destination) {
        this.graph.resetDijkstraValues();
        this.priorityQueue = new LinkedList<Vertex<T>>();
        this.vertexOrigin = this.graph.getVertex(origin);
        this.vertexDestination = this.graph.getVertex(destination);
        
        this.dijkstra();
    }
    
    public void aStarDijkstraTrigger(Vertex<T> origin, Vertex<T> destination){
        this.graph.resetDijkstraValues();
        this.priorityQueue = new LinkedList<Vertex<T>>();
        this.vertexOrigin = origin;
        this.vertexDestination = destination;

        this.dijkstra();
    }
    
    private void dijkstra() {
        this.priorityQueue.add(this.vertexOrigin);
        this.vertexOrigin.setDijkstraDistance(0);
        
        while (!this.priorityQueue.isEmpty()) {
            Vertex<T> comparator = this.priorityQueue.remove();
            comparator.setDijkstraVisited(true);

            for (Edge<T> e : comparator.getEdges()) {
                if (e.getVertDe().isDijkstraVisited() == false
                && (e.getVertDe().getDijkstraDistance() > (comparator.getDijkstraDistance() + e.getDistance()))) {
                    e.getVertDe().setDijkstraDistance(comparator.getDijkstraDistance() + e.getDistance());
                    this.priorityQueue.add(e.getVertDe());
                    e.getVertDe().setDijkstraDerived(e.getVertOr());
                }
            }
        }
    }
    
    public void printPath() {
        Vertex<T> proc = this.vertexDestination;
        String p = "";
        
        System.out.println(
            "Menor distancia de " + this.vertexOrigin.getValue() + " ate " + this.vertexDestination.getValue() + " = " + this.vertexDestination.getDijkstraDistance());
        while (proc != null) {
                p = proc.getValue() + (p.length() == 0 ? "" : " - ") + p;
                proc = proc.getDijkstraDerived();
                
            }
            System.out.printf("O menor caminho de %s até %s é: ", this.vertexOrigin.getValue(), this.vertexDestination.getValue());
            System.out.println(p);
                
    }
            
    public Vertex<T> getVertexOrigin() {
        return this.vertexOrigin;
    }

    public void setVertexOrigin(Vertex<T> vertexOrigin) {
        this.vertexOrigin = vertexOrigin;
    }

    public Vertex<T> getVertexDestination() {
        return this.vertexDestination;
    }

    public void setVertexDestination(Vertex<T> vertexDestination) {
        this.vertexDestination = vertexDestination;
    }

}