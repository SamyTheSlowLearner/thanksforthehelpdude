package graph;

import java.util.HashSet;

public class ProcessedVertexesImpl implements ProcessedVertexes{
	public HashSet<Vertex> processedVertexes= new HashSet<Vertex>();
	
	@Override
	public void addVertex(Vertex v) {
		processedVertexes.add(v);
		
	}

	@Override
	public boolean inPrrocessedVertexes(Vertex v) {
		
		return processedVertexes.contains(v);
	}

	@Override
	public boolean endVertexInPV() {
		
		return false;
	}

}
