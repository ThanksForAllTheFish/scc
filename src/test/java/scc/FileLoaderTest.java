package scc;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;
import static scc.Fixtures.sampleEdges;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;

import org.junit.Test;

public class FileLoaderTest {

	private FileLoader fileLoader;

	@Test
	public void readFile() throws URISyntaxException, IOException {
		fileLoader = new FileLoader();
		Set<Edge> edges = fileLoader.readFile("SCC-test.txt");
		
		assertThat(edges, containsInAnyOrder(sampleEdges().toArray(new Edge[]{})));
	}
}
