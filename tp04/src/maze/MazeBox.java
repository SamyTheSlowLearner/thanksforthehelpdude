package maze;
import graph.Vertex;

public class MazeBox implements Vertex{
	// 
	private final int i ;//abscisse
	private final  int j ;//ordonne
	private final String label;//type de case
	
	//utilisation de final, car position et type de case invariant
	
	
    public MazeBox (int i, int j,String label ) {
		this.i = i ;
		this.j = j ;
		this.label = label;
		
	}
	
	
	public final int getabs () {
		return i ;//retourne abscisse
	}	
	
	
	public final int getord() {
		return j ;//retourne ordonnee
	}
	

	public final String getLabel () {
		return label ;//retourne type de case
	}
	

	public final int passante () {
		String a= this.label ;
		if(a.equals("W")) {return 0;}
		else {return 1;}
		//test si la case est passante ou blocante(retourne 0 si blocante , et 1 sinon)
	}
}
