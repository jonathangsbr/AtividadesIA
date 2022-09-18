package main;

import java.util.List;

import graph.Edge;
import graph.Graph;
import graph.Vertex;

public class Map {

    private Graph<String> graph;

    
    public Map(){
        this.graph = new Graph<String>();
    }
    
    public void mapGenerate(){
        this.graph.addVertex("Oradea");
        this.graph.addVertex("Zerind");
        this.graph.addVertex("Arad");
        this.graph.addVertex("Sibiu");
        this.graph.addVertex("Fagaras");
        this.graph.addVertex("Timisoara");
        this.graph.addVertex("Lugoj");
        this.graph.addVertex("Mehadia");
        this.graph.addVertex("Dobreta");
        this.graph.addVertex("Cralova");
        this.graph.addVertex("Rimnicu Vilcea");
        this.graph.addVertex("Pitesti");
        this.graph.addVertex("Bucharest");
        this.graph.addVertex("Giurgiu");
        this.graph.addVertex("Urziceni");
        this.graph.addVertex("Hirsova");
        this.graph.addVertex("Eforie");
        this.graph.addVertex("Vaslui");
        this.graph.addVertex("Iasi");
        this.graph.addVertex("Neamt");
        
        this.graph.addEdge("Oradea", "Zerind", 71);
        this.graph.addEdge("Oradea", "Sibiu", 151);
        this.graph.addEdge("Zerind", "Arad", 75);
        this.graph.addEdge("Arad", "Sibiu", 140);
        this.graph.addEdge("Sibiu", "Fagaras", 99);
        this.graph.addEdge("Sibiu", "Rimnicu Vilcea", 80);
        this.graph.addEdge("Arad", "Timisoara", 118);
        this.graph.addEdge("Timisoara", "Lugoj", 111);
        this.graph.addEdge("Lugoj", "Mehadia", 70);
        this.graph.addEdge("Mehadia", "Dobreta", 75);
        this.graph.addEdge("Dobreta", "Cralova", 120);
        this.graph.addEdge("Cralova", "Rimnicu Vilcea", 146);
        this.graph.addEdge("Cralova", "Pitesti", 138);
        this.graph.addEdge("Rimnicu Vilcea", "Pitesti", 97);
        this.graph.addEdge("Fagaras", "Bucharest", 211);
        this.graph.addEdge("Bucharest", "Giurgiu", 90);
        this.graph.addEdge("Bucharest", "Urziceni", 85);
        this.graph.addEdge("Urziceni", "Hirsova", 98);
        this.graph.addEdge("Urziceni", "Vaslui", 142);
        this.graph.addEdge("Hirsova", "Eforie", 86);
        this.graph.addEdge("Vaslui", "Iasi", 92);
        this.graph.addEdge("Iasi", "Neamt", 87);

        // this.graph.addVertex("bombA");
        // this.graph.addVertex("ceu");
        // this.graph.addVertex("corredor");
        // this.graph.addVertex("jardim");
        // this.graph.addVertex("lion");
        // this.graph.addVertex("basect");
        // this.graph.addVertex("gelato");
        // this.graph.addVertex("meio");
        // this.graph.addVertex("books");
        // this.graph.addVertex("mercado");
        // this.graph.addVertex("shop");
        // this.graph.addVertex("basetr");
        // this.graph.addVertex("bombB");
        // this.graph.addVertex("casa");

        // this.graph.addEdge("bombA", "ceu", 30);
        // this.graph.addEdge("bombA", "corredor", 46);
        // this.graph.addEdge("bombA", "jardim", 53);
        // this.graph.addEdge("ceu", "basect", 90);
        // this.graph.addEdge("jardim", "basect", 99);
        // this.graph.addEdge("jardim", "meio", 63);
        // this.graph.addEdge("corredor", "lion", 62);
        // this.graph.addEdge("lion", "books", 57);
        // this.graph.addEdge("lion", "basetr", 120);
        // this.graph.addEdge("basect", "gelato", 54);
        // this.graph.addEdge("basect", "mercado", 99);
        // this.graph.addEdge("gelato", "meio", 73);
        // this.graph.addEdge("gelato", "mercado", 79);
        // this.graph.addEdge("meio", "shop", 98);
        // this.graph.addEdge("meio", "books", 50);
        // this.graph.addEdge("books", "basetr", 69);
        // this.graph.addEdge("shop", "basetr", 108);
        // this.graph.addEdge("shop", "mercado", 96);
        // this.graph.addEdge("mercado", "bombB", 38);
        // this.graph.addEdge("bombB", "casa", 33);
    }
    
    public void printMap(){
        List<Vertex<String>> list = this.graph.getVertexList();
        
        list.forEach(v -> {
            v.getEdges().forEach(e -> {
                System.out.println("Origem : " + e.getVertOr().getValue());
                System.out.println("Destino : " + e.getVertDe().getValue());
                System.out.println("Distancia : " + e.getDistance());
                System.out.println();
            });
            System.out.println("______________________________________________\n");
        });
        
        for(Vertex<String> v : list){
            for(Edge<String> e : v.getEdges()){
                System.out.println("Origem : " + e.getVertOr().getValue());
                System.out.println("Destino : " + e.getVertDe().getValue());
                System.out.println("Distancia : " + e.getDistance());
                System.out.println();
            }
            System.out.println("______________________________________________\n");
            
        }
        
    }

    public Graph<String> getGraph() {
        return graph;
    }
    
    public void setGraph(Graph<String> graph) {
        this.graph = graph;
    }
    
}
