package maze;
import java.io.BufferedReader;


import java.io.FileReader;

import java.io.PrintWriter;

import java.util.ArrayList;


import graph.Graph;
import graph.Vertex;

public class Maze implements Graph{
	private MazeBox[][] Cases;
	private int hauteur;
	private int largeur;
	
	public Maze(int h, int l)
	{	
		this.Cases=new MazeBox[h][l];
		this.hauteur=h;
		this.largeur=l;
		}
	
	
	
	
	
	public final MazeBox[][] getCases() {
		return Cases;}

	@Override
	public ArrayList<Vertex> getSommets() {
		ArrayList<Vertex> listeSommets = new ArrayList<Vertex>();
		for(int i=0;i< largeur;i++) {
			for(int j=0;j<hauteur;j++) {
				listeSommets.add(Cases[i][j]);
			}
		}
		return listeSommets;
	}//Retourne tous les sommets du labyrinthe

	@Override
	public ArrayList<Vertex> getSuccesseurs(Vertex a) {
		ArrayList<Vertex> successors = new ArrayList<Vertex>();
		
		MazeBox box = (MazeBox) a ;
		int i =box.getabs();
		int j= box.getord();
		try {
			MazeBox voisin = Cases[i+1][j];
			if(voisin.passante()==1){
				successors.add(voisin);
			}}catch( Exception e) {};
			
		try {
			MazeBox voisin = Cases[i-1][j-1];
			if(voisin.passante()==1){
				successors.add(voisin);
			}}catch( Exception e) {};

		try {
			MazeBox voisin = Cases[i][j-1];
			if(voisin.passante()==1){
				successors.add(voisin);
			}}catch( Exception e) {};
		try {
			MazeBox voisin = Cases[i][j+1];
			if(voisin.passante()==1){
				successors.add(voisin);
			}}catch( Exception e) {};
		try {
			MazeBox voisin = Cases[i-1][j];
			if(voisin.passante()==1){
				successors.add(voisin);
			}}catch( Exception e) {};
		try {
			MazeBox voisin = Cases[i-1][j+1];
			if(voisin.passante()==1){
				successors.add(voisin);
			}}catch( Exception e) {};
						
		
		
	
		return successors;
	}/*retourne tous les successeurs d'un sommet donné 
	(les indices des successeurs varie selon la parité de l'xxx du sommet d'origine)*/
	
	
	public int gethauteur() {
		return hauteur;
	}
	
	public int getlargeur() {
		return largeur;
	}



	@Override
	public int getPoids(Vertex a, Vertex b) {
		
		return 1;//tous les arcs sont de poids 1
	}
	
	
		
	public void initFromTextFile(String fileName) throws Exception
	// permet l'initialisation du labyrinthe à partir d'un fichier texte
	{			  
		FileReader lec = new FileReader(fileName);
		BufferedReader blec = new BufferedReader(lec);	
		this.Cases = new MazeBox[hauteur(fileName)][largeur(fileName)];
		try {
			
			for (int ligne = 0 ; ligne < hauteur(fileName) ; ligne++) 
			{				  
				String line = blec.readLine();

				if (line == null) throw new MazeReadingException(fileName, ligne, "hauteur non valide");
				if (line.length() < largeur) throw new MazeReadingException(fileName, ligne, "largeur insuffisante");
				if (line.length() > largeur) throw new MazeReadingException(fileName, ligne, "exces de largeur");

				for (int colonne = 0 ; colonne < largeur(fileName) ; colonne++)
				{
					switch (line.charAt(colonne)) 
					{
					case 'W' :
						Cases[ligne][colonne] = new WallBox(ligne, colonne); 
						break;
				    case 'A' :
						Cases[ligne][colonne] = new ArrivalBox(ligne, colonne); 
						break;
					case 'D' :
						Cases[ligne][colonne] = new DepartureBox(ligne, colonne);
						break;
					case 'E' :
						Cases[ligne][colonne] = new EmptyBox(ligne, colonne); 
						break;         	
					
						
						
					default :
						
						throw new MazeReadingException(fileName, ligne, " caractère invalide ");
					}
				} 
			}

		} finally {
			lec.close();
			blec.close();
		}

	}
	
	public int hauteur(String fileName) throws Exception{
		FileReader a = new FileReader(fileName);
		BufferedReader b = new BufferedReader(a);
		int y =0;
		while(b.readLine()!= null) {y++;}
			
		
		return y+1;
		
	}//retourne la hauteur d'un labyrinthe
	

	
	
	public int largeur(String fileName) throws  Exception {
		FileReader a = new FileReader(fileName);
		BufferedReader b = new BufferedReader(a);
		
		return b.readLine().length();
		
		
	}//retourne la largeur d'un labyrinthe
	
	
	public final void saveToTextFile(String fileName1) throws Exception {
		int H =this.hauteur;
		int L =this.largeur;
		try(PrintWriter imp = new PrintWriter(fileName1) ;){
			for( int i = 0 ; i< H-1 ; i++) {
				for( int j = 0 ; j <L-1 ; j++) {
					imp.print(this.Cases[i][j].getLabel());
				}
				imp.println("");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}//convertit un labyrinthe en fichier text correspondant (operation inverse de initfromtextfile)
	
	public MazeBox depart()  {
		ArrayList<MazeBox> test1 = new ArrayList<MazeBox>();
		for(int i =0;i<hauteur;i++) {
			for(int j=0;j<largeur;j++) {
				MazeBox test2 = Cases[i][j];
				if(test2.getLabel().equals("D")) {test1.add(test2);}
				
			}
		}
	
		if(test1.size()!=1) {return null;}
		
		else {return test1.get(0);}
		}//retourne null si le labyrinthe n'a pas un depart unique, et le depart sinon
	
	public MazeBox arrivee()  {
		ArrayList<MazeBox> test1 = new ArrayList<MazeBox>();
		for(int i =0;i<hauteur;i++) {
			for(int j=0;j<largeur;j++) {
				MazeBox test2 = Cases[i][j];
				if(test2.getLabel().equals("A")) {test1.add(test2);}
				
			}
		}
	
		if(test1.size()!=1) {return null;}
		
		else {return test1.get(0);}
		}//retourne null si le labyrinthe n'a pas une arrivee unique, et l'arrivee sinon
	
	
	
	public void update( ArrayList<Vertex> chemin) {

		
		MazeBox D =(MazeBox) this.depart() ;
		MazeBox A =(MazeBox) this.arrivee() ;
		for( int i = 0 ; i< this.gethauteur() ; i++) {
			for( int j = 0 ; j <this.getlargeur() ; j++) {
				MazeBox box = this.getCases()[i][j] ;
				if( chemin.contains(box) && (box != D) && (box != A)) {this.getCases()[i][j]= new PathBox(i,j);}	
				}
			}
		}//effectue une mise à jour de labyrinthe apres l'application de Dikjstra
	
	
}
