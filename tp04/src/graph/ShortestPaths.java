package graph;

import java.util.List;

public interface ShortestPaths {
	Vertex getprevious(Vertex v);//récupérer le sommet précédent correspondant au chemin le plus court pour un sommet v
	void setprevious(Vertex v, Vertex w);// 
	List<Vertex> getShortestPath( Vertex endVertex ); 
}
