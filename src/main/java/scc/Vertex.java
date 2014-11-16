package scc;

import java.util.HashSet;
import java.util.Set;

public class Vertex {

	private final int v;
	private int finishing = 0;
	private boolean visited = false;
	private Set<Edge> outgoing = new HashSet<>();

	public Vertex(int v) {
		this.v = v;
	}
	
	public void setFinishing(int finishing) {
		this.finishing = finishing;
	}
	
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + v;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Vertex))
			return false;
		Vertex other = (Vertex) obj;
		if (v != other.v)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vertex [v=" + v + ", finishing=" + finishing + ", visited="
				+ visited + "]";
	}

	public void add(Edge edge) {
		this.outgoing.add(edge);
	}
}
