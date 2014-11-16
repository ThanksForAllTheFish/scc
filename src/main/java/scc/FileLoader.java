package scc;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileLoader {
	
	public Set<Edge> readFile(final String fileName) throws URISyntaxException, IOException {
		URL url = FileLoader.class.getClassLoader().getResource(fileName);
		
		Path path = Paths.get(new URI(url.toString()));
		long start = System.currentTimeMillis();
		try(Stream<String> file = Files.lines(path);) {
			Set<Edge> edges = file.parallel().map(line -> new Edge(line.split("\\s+"))).collect(Collectors.toSet());
			System.err.println(System.currentTimeMillis() - start);
			return edges;
		}
	}
}
