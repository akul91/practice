package algo.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Map.Entry;

public class BFS {

	public static class Vertex {

		public int id;
		public int distance;
		public Vertex parent;
		public boolean marked;

		public Vertex(int id) {
			this.id = id;
			distance = -1;
			parent = null;
			marked = false;
		}
	}

	public static class Graph {
		private HashMap<Vertex, List<Vertex>> myAdjList;
		private HashMap<Integer, Vertex> myVertices;
		// private int myNumVertices;
		// private int myNumEdges;

		public Graph(int v, int e) {
			// myNumVertices = v;
			// myNumEdges = e;
			myVertices = new HashMap<Integer, Vertex>();
			myAdjList = new HashMap<Vertex, List<Vertex>>();
			for (int i = 1; i <= v; i++) {
				Vertex vertex = new Vertex(i);
				myAdjList.put(vertex, new LinkedList<Vertex>());
				myVertices.put(i, vertex);
			}
		}

		public void addEdge(int start, int end) {
			if (myVertices.containsKey(start) && myVertices.containsKey(end)) {
				Vertex startVertex = myVertices.get(start);
				Vertex endVertex = myVertices.get(end);
				List<Vertex> v1 = myAdjList.get(startVertex);
				v1.add(endVertex);
				myAdjList.put(startVertex, v1);
				List<Vertex> v2 = myAdjList.get(endVertex);
				v2.add(startVertex);
				myAdjList.put(endVertex, v2);
			}
		}

		public List<Vertex> getAdjList(int v) {
			return myAdjList.get(myVertices.get(v));
		}

		public boolean hasVertex(int v) {
			return myVertices.containsKey(v);
		}

		public HashMap<Integer, Vertex> getVertices() {
			return myVertices;
		}

		public void printAdjList() {
			for (Entry<Integer, Vertex> entry : myVertices.entrySet()) {
				System.out.print(entry.getKey() + ":");
				for (Vertex vertex : myAdjList.get(entry.getValue())) {
					System.out.print(vertex.id + " ");
				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int v = sc.nextInt();
			int e = sc.nextInt();
			Graph graph = new Graph(v, e);
			for (int j = 0; j < e; j++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				graph.addEdge(start, end);
			}
			int source = sc.nextInt();
			if (graph.hasVertex(source)) {
				Queue<Integer> queue = new LinkedList<Integer>();
				queue.add(source);
				graph.getVertices().get(source).distance = 0;
				graph.getVertices().get(source).marked = true;
				while (!queue.isEmpty()) {
					int currentVertex = queue.poll();
					for (Vertex vertex : graph.getAdjList(currentVertex)) {
						if (!vertex.marked) {
							queue.add(vertex.id);
							vertex.marked = true;
							vertex.distance = 0;
							vertex.distance = graph.getVertices().get(currentVertex).distance + 6;
						}
					}
				}
			}
			for (int x = 1; x <= v; x++) {
				int distance = graph.getVertices().get(x).distance;
				if (distance != 0)
					System.out.print(distance + " ");
			}
			System.out.println();
			// graph.printAdjList();
		}
		sc.close();
	}
}
