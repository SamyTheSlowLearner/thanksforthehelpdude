import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import graph.Dijkstra;
import graph.ShortestPaths;
import graph.ShortestPathsImpl;
import graph.Vertex;
import maze.Maze;
import maze.MazeBox;
import maze.MazeReadingException;

public class MainTest {
	
	
		
	public static void main(String[] args) throws MazeReadingException, Exception {
		ShortestPathsImpl z= new ShortestPathsImpl();
		Maze maze = new Maze(2,2);
		int x =maze.hauteur("data/labyrinthe.maze");
		int y =maze.largeur("data/labyrinthe.maze");
		Maze meme = new Maze(y,x);
		
		meme.initFromTextFile("data/labyrinthe.maze");
		MazeBox d =meme.depart();
		MazeBox a =meme.arrivee();
		
		
		ShortestPaths res = Dijkstra.dijkstra(meme, d, a);
		ArrayList<Vertex> chemin= z.getShortestPath(a);
		meme.update(chemin);
		
		
		meme.saveToTextFile("data/testtest");
		
	}
		

}
