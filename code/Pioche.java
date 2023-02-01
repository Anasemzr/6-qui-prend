package code;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Cette classe permet de la cr�ation d'un Pioche.<br>
 * La Pioche rescensera toute les cartes du Jeu. Elle contiendra au d�part toute les cartes du Jeu ( de 1 � 104 ).<br>
 * Le seul moyen d'avoir une carte est donc de pioche par l'intermediaire de cette classe;<br><br>
 * 
 * <b> Constante : </b><br>
 * <li>
 * MAX_NB_CARTE qui est la valeur maximal qui peut �tre attribuer � une carte
 * </li>
 * <li>
 * MIN_NB_CARTE qui est la valeur minimal qui peut �tre attribuer � une carte
 * </li><br>
 * 
 * @author MEZOUARI Anase, BIENVENU Math�o
 * 
 */

public class Pioche {
	private ArrayList<Carte> pioche;// Liste ou seront stocker toute les cartes qui seront utilis� dans ce jeux
	
	private static final int MAX_NB_CARTE=104; // num�ro maximum d'une carte
	private static final int MIN_NB_CARTE=1;// num�ro minimum d'une carte
	
	
	/**Constructeur de la classe : Initialise la liste et cr�e toute les cartes du Jeu (entre 1 et 104)
	 * 
	 */
	public Pioche() {
		pioche=new ArrayList<Carte>();
		for(int i=Pioche.MIN_NB_CARTE;i<=Pioche.MAX_NB_CARTE;++i) {// la variable "i" representera le num�ro de chaque carte 
																   // A chaque tour une carte sera cr�er et ajout� a la liste "pioche"
																   // "i" d�butera � 1 et sera increment� jusqu'a arriver � 104
			Carte c1;
			c1 = new Carte(i);
			this.pioche.add(c1);
		}
	}
	
	
	/**M�lange la pioche et renvoie une Carte de la pioche (cette carte sera supprimer par la suite)
	 * 
	 * @return Une carte x de la pioche
	 */
	public Carte donneCarte() {
		Collections.shuffle(this.pioche);// on m�lange la pioche
		Carte a = this.pioche.get(0);
		this.pioche.remove(0);
		return a;
	
	}
	
	/**
	 * @return bool�en si la pioche est vide ou non
	 */
	public boolean vide() {
		return pioche.isEmpty();
	}
	

}
