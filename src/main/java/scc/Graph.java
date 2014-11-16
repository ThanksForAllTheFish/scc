package scc;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {

	private Set<Edge> edges;
	private Map<Vertex, Set<Edge>> vertexes;

	public Graph(Set<Edge> edges) {
		this(edges, 
				edges.stream().reduce(new HashMap<Vertex, Set<Edge>>(),
					(vertexes, edge) -> {
						Vertex vertex = edge.source();
						Set<Edge> outgoing = vertexes.get(vertex);
						if (null == outgoing) {
							outgoing = new HashSet<>();
						}
						outgoing.add(edge);
						vertexes.put(vertex, outgoing);
						return vertexes;
					}, 
					(vertexes1, vertexes2) -> {
						vertexes1.putAll(vertexes2);
						return vertexes1;
					}
				));
	}

	protected Graph(Set<Edge> edges, Map<Vertex, Set<Edge>> vertexes) {
		this.edges = edges;
		this.vertexes = vertexes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((edges == null) ? 0 : edges.hashCode());
		result = prime * result
				+ ((vertexes == null) ? 0 : vertexes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Graph))
			return false;
		Graph other = (Graph) obj;
		if (edges == null) {
			if (other.edges != null)
				return false;
		} else if (!edges.equals(other.edges))
			return false;
		if (vertexes == null) {
			if (other.vertexes != null)
				return false;
		} else if (!vertexes.equals(other.vertexes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Graph [edges=" + edges + ", vertexes=" + vertexes + "]";
	}

	public Graph reverse() {
		return new Graph(collectedReverse());
	}

	@SuppressWarnings("unused")
	private Set<Edge> reducedReverse() {
		return this.edges.stream().reduce(new HashSet<Edge>(),
				(edges, edge) -> {
					edges.add(new Edge(edge.target(), edge.source()));
					return edges;
				}, (edges1, edges2) -> {
					edges1.addAll(edges2);
					return edges1;
				});
	}

	private Set<Edge> collectedReverse() {
		return this.edges.parallelStream()
				.collect(
						mapping(edge -> new Edge(edge.target(), edge.source()),
								toSet()));
	}
}
