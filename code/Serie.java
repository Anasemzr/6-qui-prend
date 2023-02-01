package code;
import java.util.ArrayList;

/**
 * Cette classe permet de la création d'une Serie.<br>
 * Une serie a pour but de stocker les cartes choisis par les joueurs.<br><br>
 * 
 * <b> Constante : </b><br>
 * <li>
 * MAX_NB_CARTE qui est la valeur maximal de carte déposé dans une serie
 * </li><br>
 * 
 * @author MEZOUARI Anase, BIENVENU Mathéo
 * 
 */

/**
 * @author Anase
 *
 */
public class Serie {
	private ArrayList<Carte> serie;// liste de carte qui representera une serie dans le jeu
	
	private static final int MAX_NB_CARTE=5;// nombre de carte maximum que peut comporter une serie 
	
	
	/**Constructeur : créer une serie et ajoute sa première carte
	 * 
	 * @param a : première carte qui sera poser dans le jeu
	 */
	public Serie(Carte a) {
		serie=new ArrayList<Carte>();
		serie.add(a);
		
	}
	
	
	/**Compare si la derniere carte de la serie est plus petite que une carte x passée en parametre
	 * 
	 * @param a : la carte qu'on veut comparer
	 * @return booléen si oui ou non dernière carte de la serie est plus petite que celle passée en paramètre
	 */
	public boolean estPlusPetitQue(Carte a) {
		return a.get_num_carte()-serie.get(serie.size()-1).get_num_carte()>0;
	}
	
	/**Calcule la différence entre la derniere carte de la serie et une carte x passée en parametre
	 * 
	 * @param a : la carte qu'on veut comparer
	 * @return la différence entre la derniere carte de la serie et la carte passée en parametre
	 */
	public int differenceDeNumeroAvec(Carte a) {
		return a.get_num_carte()-serie.get(serie.size()-1).get_num_carte();
		
	}
	
	
	/**Vide la liste de carte (serie)
	 * 
	 */
	public void vider() {
		if(!serie.isEmpty()) {
			serie.clear();
		}
		
	}
	
	
	/**Ajoute si c'est possible une carte dans la liste
	 * @param a : Carte qui sera ajoutée dans la liste
	 */
	public void ajouter_carte(Carte a) {
		if(serie.size()<=MAX_NB_CARTE) {
			serie.add(a);
		}
			
	}
	
	/**
	 * @return la taille de la liste 
	 */
	public int taille() {
		return serie.size();
	}
	
	
	/**
	 * @return booléen si la liste est pleine donc possède le maximum de carte possible ou non
	 */
	public boolean estPleine() {
		return serie.size()>=MAX_NB_CARTE;
	}
	
	/**Calcule le nombre total de tête de Boeuf que contient une serie par rapport au nombre de carte qu'elle possède
	 * 
	 * @return total : nombre de tête de Boeuf de la serie
	 */
	public int get_total_TeteBoeuf()
	{
		int total=0;
		for(Carte a:this.serie) {
			total+=a.get_nb_TetedeBoeuf();
		}
		return total;
	}
	
	/**Construis une chaine de caractère représentant la serie
	 * 
	 *@return s : Pour chaque carte de la serie, son numéro suivie du nombre de tête de Boeuf entre parenthése s'il y en a un.
	 */
	public String toString() {
		
		String s="";
		for(Carte a:this.serie) {
			s+=a.toString()+",";
		}
		
		return s.substring(1, s.length()-1);
		
	}
	
	
	
}