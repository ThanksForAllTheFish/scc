package scc;

public class Edge {

	private final Vertex source;
	private final Vertex target;

	public Edge(String[] line) {
		source = new Vertex(Integer.valueOf(line[0]));
		target = new Vertex(Integer.valueOf(line[1]));
	}

	public Edge(Vertex source, Vertex target) {
		this.source = source;
		this.target = target;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((target == null) ? 0 : target.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Edge))
			return false;
		Edge other = (Edge) obj;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (target == null) {
			if (other.target != null)
				return false;
		} else if (!target.equals(other.target))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return source.toString() + "-->" + target.toString();
	}

	public Vertex source() {
		return source;
	}
	
	public Vertex target() {
		return target;
	}
}
