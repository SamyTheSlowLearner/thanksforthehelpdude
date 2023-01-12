package graph;

public interface ProcessedVertexes {
	void addVertex(Vertex v);//ajout d'un cetain sommet à processedVertexes
	boolean inPrrocessedVertexes(Vertex v);//test d'appartenance
	boolean endVertexInPV();//pour verifier si le sommet final appartient à l'ensemble des sommets traités



}