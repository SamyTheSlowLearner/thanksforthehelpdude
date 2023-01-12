package graph;

import java.util.HashMap;

public class MinDistanceImpl implements MinDistance {

	public HashMap<Vertex,Integer> shortestdistance= new HashMap<>();
	@Override
	public int getmindistance(Vertex v) {
		
		return  shortestdistance.get(v);
	}

	@Override
	public void setmindistance(Vertex v, int d) {
		 shortestdistance.put(v, d);
		
	}

}
