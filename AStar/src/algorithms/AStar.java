package algorithms;

import java.util.ArrayList;
import java.util.List;

import graph.Edge;
import graph.Graph;
import graph.Vertex;

/* 
A* -> F(n) = G(n) + H(n)

aberta = []
fechada = []
aberta.add(inicial(G=0, H=0, F=0))
enquanto aberta != 0:
    atual = aberta.get_min_f()
    aberta.remove(atual)
    fechada.add(atual)
    se(atual == objetivo):
        retorna sucesso
    filhos = atual.adjacentes
    para cada filho em filhos:
        se filho em fechada:
            continue
        filho.g = atual.g + dist(filho, atual)
        filho.h = dist(filho, objetivo)
        filho.f = filho.g + filho.h
        se filho em aberta e filho.g > aberta.max_g:
            continue
        aberta.add(filho) 
*/

public class AStar<T> {

    private Graph<T> graph;
    private List<Vertex<T>> openList;
    private List<Vertex<T>> closedList;
    private Vertex<T> vertexOrigin;
    private Vertex<T> vertexDestination;
    private Dijkstra<T> dijkstra;

    public AStar(Graph<T> graph){
        this.graph = graph;
        this.openList = new ArrayList<Vertex<T>>();
        this.closedList = new ArrayList<Vertex<T>>();
        this.dijkstra = new Dijkstra<>(graph);
    }

    public void AStarTrigger(T origin, T destination){
        this.vertexOrigin = this.graph.getVertex(origin);
        this.vertexDestination = this.graph.getVertex(destination);

        this.aStar();
    }

    private void aStar(){
        this.openList.add(this.vertexOrigin);
        
        while(!this.openList.isEmpty()){
            Vertex<T> atual = this.getMinF(this.openList);
            this.openList.remove(atual);
            this.closedList.add(atual);
            if(atual == this.vertexDestination){
                // System.out.println("Chegou no Destino");
                break;
            }
            List<Edge<T>> filhos = atual.getEdges();
            for(Edge<T> edge : filhos){
                Vertex<T> filho = edge.getVertDe();
                if(this.closedList.contains(filho)) continue;

                filho.setAstarG(atual.getAstarG() + edge.getDistance());

                this.dijkstra.aStarDijkstraTrigger(filho, this.vertexDestination);
                filho.setAstarH(this.vertexDestination.getDijkstraDistance());

                filho.setAstarF(filho.getAstarG() + filho.getAstarH());

                if(this.openList.contains(filho) && filho.getAstarG() > this.getMaxG(this.openList)) continue;

                this.openList.add(filho);
            }
        }
    }

    public void printPath(){
        System.out.printf("O menor caminho de %s até %s é: ", this.vertexOrigin.getValue(), this.vertexDestination.getValue());
        this.closedList.forEach(v -> {
            System.out.print(v.getValue() + (v == this.closedList.get(this.closedList.size()-1) ? "" : " - "));

        });
    }

    private Vertex<T> getMinF(List<Vertex<T>> list){
        Vertex<T> result = list.get(0);

        for(Vertex<T> vertex : list){
            result = vertex.getAstarF() < result.getAstarF() ? vertex : result;

        }
        return result;
    }

    private int getMaxG(List<Vertex<T>> list){
        int result = list.get(0).getAstarG();
        
        for(Vertex<T> vertex : list){
            result = vertex.getAstarG() > result ? vertex.getAstarG() : result;

        }
        return result;
    }
    
}