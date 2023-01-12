package graph;

import java.util.ArrayList;

public interface Graph {
	public ArrayList<Vertex> getSommets(); //retourne tous les sommets du graphe

	public ArrayList<Vertex> getSuccesseurs(Vertex a); //retourne liste des successeurs du sommet a

	public int getPoids(Vertex a, Vertex b); //poids de l'arc liant le sommet a et b


}
