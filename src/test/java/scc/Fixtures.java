package scc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({ "rawtypes", "unchecked", "serial" })
public class Fixtures {

	public static Set<Edge> sampleEdges() {
		Set<Edge> edges = new HashSet<>();

		edges.add(newEdge("1", "7"));
		edges.add(newEdge("2", "5"));
		edges.add(newEdge("3", "9"));
		edges.add(newEdge("4", "1"));
		edges.add(newEdge("5", "8"));
		edges.add(newEdge("6", "8"));
		edges.add(newEdge("6", "3"));
		edges.add(newEdge("7", "9"));
		edges.add(newEdge("7", "4"));
		edges.add(newEdge("8", "2"));
		edges.add(newEdge("9", "6"));

		return edges;
	}

	private static Edge newEdge(String source, String target) {
		return new Edge(new String[] { source, target });
	}

	public static Map<Vertex, Set<Edge>> sampleVertexes() {
		Map<Vertex, Set<Edge>> vertexes = new HashMap<>();
		vertexes.put(new Vertex(1), new HashSet(){{add(newEdge("1", "7"));}});
		vertexes.put(new Vertex(2), new HashSet(){{add(newEdge("2", "5"));}});
		vertexes.put(new Vertex(3), new HashSet(){{add(newEdge("3", "9"));}});
		vertexes.put(new Vertex(4), new HashSet(){{add(newEdge("4", "1"));}});
		vertexes.put(new Vertex(5), new HashSet(){{add(newEdge("5", "8"));}});
		vertexes.put(new Vertex(6), new HashSet(){{add(newEdge("6", "8"));add(newEdge("6", "3"));}});
		vertexes.put(new Vertex(7), new HashSet(){{add(newEdge("7", "9"));add(newEdge("7", "4"));}});
		vertexes.put(new Vertex(8), new HashSet(){{add(newEdge("8", "2"));}});
		vertexes.put(new Vertex(9), new HashSet(){{add(newEdge("9", "6"));}});
		return vertexes;
	}
	
	public static Map<Vertex, Set<Edge>> reversedSampleVertexes() {
		Map<Vertex, Set<Edge>> vertexes = new HashMap<>();
		vertexes.put(new Vertex(1), new HashSet(){{add(newEdge("1", "4"));}});
		vertexes.put(new Vertex(2), new HashSet(){{add(newEdge("2", "8"));}});
		vertexes.put(new Vertex(3), new HashSet(){{add(newEdge("3", "6"));}});
		vertexes.put(new Vertex(4), new HashSet(){{add(newEdge("4", "7"));}});
		vertexes.put(new Vertex(5), new HashSet(){{add(newEdge("5", "2"));}});
		vertexes.put(new Vertex(6), new HashSet(){{add(newEdge("6", "9"));}});
		vertexes.put(new Vertex(7), new HashSet(){{add(newEdge("7", "1"));}});
		vertexes.put(new Vertex(8), new HashSet(){{add(newEdge("8", "5"));add(newEdge("8", "6"));}});
		vertexes.put(new Vertex(9), new HashSet(){{add(newEdge("9", "3"));add(newEdge("9", "7"));}});
		return vertexes;
	}

	public static Set<Edge> reversedSampleEdges() {
		Set<Edge> edges = new HashSet<>();

		edges.add(newEdge("7", "1"));
		edges.add(newEdge("5", "2"));
		edges.add(newEdge("9", "3"));
		edges.add(newEdge("1", "4"));
		edges.add(newEdge("8", "5"));
		edges.add(newEdge("8", "6"));
		edges.add(newEdge("3", "6"));
		edges.add(newEdge("9", "7"));
		edges.add(newEdge("4", "7"));
		edges.add(newEdge("2", "8"));
		edges.add(newEdge("6", "9"));

		return edges;
	}

}
