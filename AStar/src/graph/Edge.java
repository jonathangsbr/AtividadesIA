package graph;

public class Edge<T> {

    private Vertex<T> vertOr;
    private Vertex<T> vertDe;
    private int distance;

    
    public Edge(Vertex<T> vertOr, Vertex<T> vertDe, int dist){
        this.vertOr = vertOr;
        this.vertDe = vertDe;
        this.distance = dist;
    }
    
    public Vertex<T> getVertOr() {
        return vertOr;
    }

    public void setVertOr(Vertex<T> vertOr) {
        this.vertOr = vertOr;
    }

    public Vertex<T> getVertDe() {
        return vertDe;
    }

    public void setVertDe(Vertex<T> vertDe) {
        this.vertDe = vertDe;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

}
