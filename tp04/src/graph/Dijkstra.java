package graph;

import java.util.ArrayList;



public class Dijkstra {
	public static ShortestPaths dijkstra(Graph graph, Vertex startVertex, Vertex endVertex) {
		
		ProcessedVertexesImpl pv = new ProcessedVertexesImpl();
		ShortestPathsImpl pr =new ShortestPathsImpl();
		MinDistanceImpl PI = new MinDistanceImpl();
		ArrayList<Vertex> M = graph.getSommets();
		
		pv.addVertex(startVertex);
		Vertex pivot = startVertex;
		PI.setmindistance(startVertex,0);
		
		
		for(Vertex v: M){ 
			if (!v.equals(startVertex)) {PI.setmindistance(v, 10000);}
			}
		
		
		while(!pv.inPrrocessedVertexes(endVertex)) {
			for(Vertex sv :M) {try {
				if (pr.getprevious(sv).equals(pivot) && !pv.inPrrocessedVertexes(sv)) {
					if(PI.getmindistance(pivot)+ graph.getPoids(sv, pivot)<PI.getmindistance(sv)) {
						PI.setmindistance(sv, PI.getmindistance(pivot)+graph.getPoids(sv, pivot));
						pr.setprevious(sv, pivot);
					}
			
				}}
				catch(Exception e) {}
			}
			Vertex w = null;
			int i= 1000 ;
			
			for (Vertex v : M ) {
				if ( !pv.inPrrocessedVertexes(v) && PI.getmindistance(v)<i) {
					i = PI.getmindistance(v);
					w = v;
				}
			}
			pivot = w ;
			pv.addVertex(pivot);
		}	
		return pr;
		}
		
}
