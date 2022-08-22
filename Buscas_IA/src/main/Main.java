package main;

import algorithms.UniformCostSearch;
import graph.Graph;

public class Main {
	
	public static void main(String[] args) {
		Graph g = new Graph();
		g.addNode("A");
		g.addNode("B");
		g.addNode("C");
		g.addNode("D");
		g.addNode("E");
		g.addNode("F");
		g.addNode("G");
		g.addEdge("A", "B", 7);
		g.addEdge("A", "D", 5);
		g.addEdge("B", "C", 8);
		g.addEdge("B", "D", 9);
		g.addEdge("B", "E", 7);
		g.addEdge("C", "E", 5);
		g.addEdge("D", "E", 15);
		g.addEdge("D", "F", 6);
		g.addEdge("E", "F", 8);
		g.addEdge("E", "G", 9);
		g.addEdge("F", "G", 11);
		
		new UniformCostSearch(g, "A", "G");
		
		
	}
}
