package code;
import java.util.ArrayList;

/**
 * Cette classe permet de la cr�ation d'une Serie.<br>
 * Une serie a pour but de stocker les cartes choisis par les joueurs.<br><br>
 * 
 * <b> Constante : </b><br>
 * <li>
 * MAX_NB_CARTE qui est la valeur maximal de carte d�pos� dans une serie
 * </li><br>
 * 
 * @author MEZOUARI Anase, BIENVENU Math�o
 * 
 */

/**
 * @author Anase
 *
 */
public class Serie {
	private ArrayList<Carte> serie;// liste de carte qui representera une serie dans le jeu
	
	private static final int MAX_NB_CARTE=5;// nombre de carte maximum que peut comporter une serie 
	
	
	/**Constructeur : cr�er une serie et ajoute sa premi�re carte
	 * 
	 * @param a : premi�re carte qui sera poser dans le jeu
	 */
	public Serie(Carte a) {
		serie=new ArrayList<Carte>();
		serie.add(a);
		
	}
	
	
	/**Compare si la derniere carte de la serie est plus petite que une carte x pass�e en parametre
	 * 
	 * @param a : la carte qu'on veut comparer
	 * @return bool�en si oui ou non derni�re carte de la serie est plus petite que celle pass�e en param�tre
	 */
	public boolean estPlusPetitQue(Carte a) {
		return a.get_num_carte()-serie.get(serie.size()-1).get_num_carte()>0;
	}
	
	/**Calcule la diff�rence entre la derniere carte de la serie et une carte x pass�e en parametre
	 * 
	 * @param a : la carte qu'on veut comparer
	 * @return la diff�rence entre la derniere carte de la serie et la carte pass�e en parametre
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
	 * @param a : Carte qui sera ajout�e dans la liste
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
	 * @return bool�en si la liste est pleine donc poss�de le maximum de carte possible ou non
	 */
	public boolean estPleine() {
		return serie.size()>=MAX_NB_CARTE;
	}
	
	/**Calcule le nombre total de t�te de Boeuf que contient une serie par rapport au nombre de carte qu'elle poss�de
	 * 
	 * @return total : nombre de t�te de Boeuf de la serie
	 */
	public int get_total_TeteBoeuf()
	{
		int total=0;
		for(Carte a:this.serie) {
			total+=a.get_nb_TetedeBoeuf();
		}
		return total;
	}
	
	/**Construis une chaine de caract�re repr�sentant la serie
	 * 
	 *@return s : Pour chaque carte de la serie, son num�ro suivie du nombre de t�te de Boeuf entre parenth�se s'il y en a un.
	 */
	public String toString() {
		
		String s="";
		for(Carte a:this.serie) {
			s+=a.toString()+",";
		}
		
		return s.substring(1, s.length()-1);
		
	}
	
	
	
}