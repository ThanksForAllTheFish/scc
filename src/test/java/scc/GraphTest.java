package scc;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;
import static scc.Fixtures.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class GraphTest {

	private Graph graph;
	private Set<Edge> edges;
	
	@Before
	public void init() {
		edges = sampleEdges();
		graph = new Graph(edges);
	}

	@Test
	public void creation() {
		assertThat(graph, equalTo(new Graph(edges, sampleVertexes())));
	}
	
	@Test
	public void reverse() throws Exception {
		Graph reversed = graph.reverse();
		assertThat(reversed, equalTo(new Graph(Fixtures.reversedSampleEdges(), reversedSampleVertexes())));
	}

}