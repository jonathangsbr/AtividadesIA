package algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import graph.Graph;
import graph.Node;

public class UniformCostSearch {

	private Graph graph = null;
	private Queue<Node> priorityQueue = new LinkedList<Node>();

	public UniformCostSearch(Graph graph, String origem, String destino) {
		this.graph = graph;
		this.uCSTrigger(origem, destino);

	}

	private void uCSTrigger(String o, String d) {
		Node or = new Node();
		Node ds = new Node();
		ArrayList<Node> node = this.graph.getNode();

		for (int i = 0; i < node.size(); i++) {
			if (node.get(i).nome.equals(o)) {
				node.get(i).distancia = 0;
				or = node.get(i);

			}
			if (node.get(i).nome.equals(d)) {
				ds = node.get(i);

			}
		}
		uCS(or, ds);

	}

	private void uCS(Node o, Node d) {
		this.priorityQueue.add(o);
		ArrayList<Node> node = this.graph.getNode();
		int[][] graph = this.graph.getGraph();

		while (!this.priorityQueue.isEmpty()) {
			Node comparator = this.priorityQueue.remove();
			node.get(comparator.indice).visitado = true;

			for (int i = 0; i < graph.length; i++) {
				if ((graph[comparator.indice][i] > 0) && (node.get(i).visitado == false)
						&& (node.get(i).distancia > (comparator.distancia + graph[comparator.indice][i]))) {
					node.get(i).distancia = node.get(comparator.indice).distancia + graph[comparator.indice][i];
					this.priorityQueue.add(node.get(i));
					node.get(i).procedente = node.get(comparator.indice);

				}
			}
		}
		this.graph.printD(o, d);

	}
	
//	public void print() {
//		this.graph.printD();
//		
//	}

}
