package graph;

import java.util.ArrayList;

public class Graph {

	private final static double INF = Double.POSITIVE_INFINITY;
	private ArrayList<Node> node = new ArrayList<Node>();

	public ArrayList<Node> getNode() {
		return node;
	}

	// public Queue<Node> node = new Queue<Node>();
	private int[][] graph;

	public int[][] getGraph() {
		return graph;
	}

	public Graph() {
		this.graph = new int[0][0];
	}

	public void addNode(String nome) {
		int[][] graphAux = this.graph;

		this.graph = new int[this.graph.length + 1][this.graph.length + 1];

		for (int i = 0; i < graphAux.length; i++) {
			for (int j = 0; j < graphAux.length; j++) {
				this.graph[i][j] = graphAux[i][j];

			}
		}

		Node aux = new Node();
		aux.indice = this.node.size();
		aux.distancia = INF;
		aux.visitado = false;
		aux.nome = nome;
		this.node.add(aux);
	}

	public void addEdge(String or, String de, int di) {

		String origem = or;
		int o = -1;

		String destino = de;
		int d = -1;

		for (int i = 0; i < this.node.size(); i++) {
			if (this.node.get(i).nome.equals(origem)) {
				o = i;

			}
			if (this.node.get(i).nome.equals(destino)) {
				d = i;

			}

		}

		this.graph[o][d] = di;
		this.graph[d][o] = di;

	}

	public void removeEdge(String or, String de) {

		this.print();

		String origem = or;
		int o = -1;

		String destino = de;
		int d = -1;

		for (int i = 0; i < this.node.size(); i++) {
			if (origem.equals(this.node.get(i).nome)) {
				o = i;

			}
			if (destino.equals(this.node.get(i).nome)) {
				d = i;

			}

		}

		this.graph[o][d] = 0;
		this.graph[d][o] = 0;

	}

//	public void dijkstraTrigger(String o, String d) {
//		Node or = new Node();
//		Node ds = new Node();
//
//		for (int i = 0; i < this.node.size(); i++) {
//			if (this.node.get(i).nome.equals(o)) {
//				this.node.get(i).distancia = 0;
//				or = this.node.get(i);
//
//			}
//			if (this.node.get(i).nome.equals(d)) {
//				ds = this.node.get(i);
//
//			}
//		}
//		dijkstra(or, ds);
//
//	}
//
//	private void dijkstra(Node o, Node d) {
//		this.priorityQueue.add(o);
//
//		while (!this.priorityQueue.isEmpty()) {
//			Node comparator = this.priorityQueue.remove();
//			this.node.get(comparator.indice).visitado = true;
//
//			for (int i = 0; i < this.graph.length; i++) {
//				if ((this.graph[comparator.indice][i] > 0) && (this.node.get(i).visitado == false)
//						&& (this.node.get(i).distancia > (comparator.distancia + this.graph[comparator.indice][i]))) {
//					this.node.get(i).distancia = this.node.get(comparator.indice).distancia + this.graph[comparator.indice][i];
//					this.priorityQueue.add(node.get(i));
//					node.get(i).procedente = this.node.get(comparator.indice);
//
//				}
//			}
//		}
//		this.printD(o, d);
//
//	}

	public void printD(Node o, Node d) {
		Node proc = null;
		String p = "";

		for (int i = 0; i < this.node.size(); i++) {
			if (this.node.get(i).nome.equals(d.nome)) {
				System.out.println("Menor distancia de " + o.nome + " ate " + this.node.get(i).nome + " = " + this.node.get(i).distancia);
				proc = this.node.get(i);
				while (proc != null) {
					p = proc.nome + (p.length() == 0 ? "" : " - ") + p;
					proc = proc.procedente;
				}
			}
		}
		System.out.printf("O menor caminho de %s até %s é: ", o.nome, d.nome);
		System.out.println(p);
	}

//	public void printNode() {
//		for (int i = 0; i < node.size(); i++) {
//			System.out.println(node.get(i).indice + " : " + this.node.get(i).nome + " : " + node.get(i).distancia + " : " + node.get(i).visitado);
//			System.out.println(this.node.get(i).procedente != null ? this.node.get(i).procedente.nome : "sem procedente");
//
//		}
//	}

	public void print() {
		System.out.println("\n\n");
		for (int i = 0; i < this.node.size(); i++) {
			System.out.print("  " + this.node.get(i).nome + "\t");

		}
		System.out.println();
		for (int i = 0; i < this.node.size(); i++) {
			System.out.print(this.node.get(i).nome);
			for (int j = 0; j < this.node.size(); j++) {
				System.out.print(" " + this.graph[j][i] + "\t ");

			}
			System.out.println();

		}

	}

}