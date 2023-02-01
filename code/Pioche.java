package code;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Cette classe permet de la création d'un Pioche.<br>
 * La Pioche rescensera toute les cartes du Jeu. Elle contiendra au départ toute les cartes du Jeu ( de 1 à 104 ).<br>
 * Le seul moyen d'avoir une carte est donc de pioche par l'intermediaire de cette classe;<br><br>
 * 
 * <b> Constante : </b><br>
 * <li>
 * MAX_NB_CARTE qui est la valeur maximal qui peut être attribuer à une carte
 * </li>
 * <li>
 * MIN_NB_CARTE qui est la valeur minimal qui peut être attribuer à une carte
 * </li><br>
 * 
 * @author MEZOUARI Anase, BIENVENU Mathéo
 * 
 */

public class Pioche {
	private ArrayList<Carte> pioche;// Liste ou seront stocker toute les cartes qui seront utilisé dans ce jeux
	
	private static final int MAX_NB_CARTE=104; // numéro maximum d'une carte
	private static final int MIN_NB_CARTE=1;// numéro minimum d'une carte
	
	
	/**Constructeur de la classe : Initialise la liste et crée toute les cartes du Jeu (entre 1 et 104)
	 * 
	 */
	public Pioche() {
		pioche=new ArrayList<Carte>();
		for(int i=Pioche.MIN_NB_CARTE;i<=Pioche.MAX_NB_CARTE;++i) {// la variable "i" representera le numéro de chaque carte 
																   // A chaque tour une carte sera créer et ajouté a la liste "pioche"
																   // "i" débutera à 1 et sera incrementé jusqu'a arriver à 104
			Carte c1;
			c1 = new Carte(i);
			this.pioche.add(c1);
		}
	}
	
	
	/**Mélange la pioche et renvoie une Carte de la pioche (cette carte sera supprimer par la suite)
	 * 
	 * @return Une carte x de la pioche
	 */
	public Carte donneCarte() {
		Collections.shuffle(this.pioche);// on mélange la pioche
		Carte a = this.pioche.get(0);
		this.pioche.remove(0);
		return a;
	
	}
	
	/**
	 * @return booléen si la pioche est vide ou non
	 */
	public boolean vide() {
		return pioche.isEmpty();
	}
	

}
