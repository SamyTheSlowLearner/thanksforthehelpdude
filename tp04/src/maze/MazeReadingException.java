package maze;

public class MazeReadingException extends Exception {
	

	public MazeReadingException (String fileName, int ligne, String erreur)
	{
		super("Erreur trouvée dans le fichier" + fileName + " ,à la ligne "+"(" + ligne + ")"+" ,Erreur de type; " + erreur);
	}
}


