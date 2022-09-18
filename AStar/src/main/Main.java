package main;

import algorithms.AStar;
import algorithms.Dijkstra;

public class Main {
    
    public static void main(String[] args) {
        Map map = new Map(); 
        map.mapGenerate();
        // map.printMap();
        new Dijkstra<String>(map.getGraph());
        Dijkstra<String> dijkstra = new Dijkstra<String>(map.getGraph());
        dijkstra.dijkstraTrigger("Arad", "Bucharest");
        dijkstra.printPath();
        
        AStar<String> aStar = new AStar<String>(map.getGraph());
        aStar.AStarTrigger("Arad", "Bucharest");
        System.out.println("_______________________________________________\n");
        System.out.println("_______________________________________________\n");
        System.out.println("_______________________________________________\n");
        aStar.printPath();

    }

}
