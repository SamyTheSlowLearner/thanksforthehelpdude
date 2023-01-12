package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public  class ShortestPathsImpl implements ShortestPaths {
	public HashMap<Vertex,Vertex> shortestpaths= new HashMap<>();
	@Override
	public Vertex getprevious(Vertex v) {
		
		return shortestpaths.get(v);
	}
	@Override
	public void setprevious(Vertex fils,Vertex pere) {
		shortestpaths.put(fils, pere);
	}
	@Override
	public ArrayList<Vertex> getShortestPath(Vertex endVertex) {
		ArrayList<Vertex> R= new ArrayList<Vertex>();
		while(!(shortestpaths.get(endVertex)==null)) {
			R.add(shortestpaths.get(endVertex));
			endVertex = shortestpaths.get(endVertex);
		}
		return R;
	}

}
