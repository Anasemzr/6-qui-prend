package code;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 * Cette classe permet de la création d'un Joueur.<br>
 * Un joueur est determiné par un nom.Ils possédent un compteur qui dénombre le total de tête de Boeuf qu'il a ramassé et
 * un deck qui contient les cartes qu'il aura durant la partie.
 * 
 * <br><i>Le booleén ramasserTeteDeBoeuf et la variable nbTeteDeBoeuf_manche permettront de savoir si le joueur à récolter 
 * des têtes des boeufs durant le tour, si oui combien il en a pris</i>
 * 
 * @author MEZOUARI Anase, BIENVENU Mathéo
 * 
 */


public class Joueur {
	
	private String Nom; // Nom du joueur
	private int nbTeteDeBoeuf; // nombre total de tête de boeuf qu'il a cumulé
	private ArrayList<Carte> deck;// ensemble de cartes que possède le joueur 
	
	private boolean ramasserTeteDeBoeuf;// booléen qui indique si le joueur a rammasé des têtes de boeuf pendant un tour
	private int nbTeteDeBoeuf_manche;// nombre de tête de têtes de boeuf ramassé pendant un tour
	
	/**Constructeur de la classe : un joueur est créer en passant par parametre son nom
	 * 							   Toute les données relative à l'instance créer son initialiser
	 * 
	 * @param nom : nom du Joueur
	 */
	public Joueur(String nom) {
		this.Nom=nom;
		this.nbTeteDeBoeuf=0;
		this.deck=new ArrayList<Carte>();
		this.ramasserTeteDeBoeuf=false;
	}
	
	
	/**Incrémente le compteur total de tête de boeuf que le joueur a cumulé
	 * 
	 * @param nombre_tete_de_boeuf 
	 */
	public void prendTetedeBoeuf(int nombre_tete_de_boeuf) {
		if(nombre_tete_de_boeuf>=0) {this.nbTeteDeBoeuf+=nombre_tete_de_boeuf;}
		
	}
	
	
	/**
	 * @return le nombre de total de tête de Boeuf que le joueur a cumulé
	 */
	public int get_TetedeBoeuf() {
		return this.nbTeteDeBoeuf;
	}
	
	
	/**
	 * @return le nom du joueur
	 */
	public String get_Nom() {
		return this.Nom;
	}
	
	
	/**Ajoute une carte dans le deck du joueur et fait un trie croissant du deck 
	 * 
	 * @param a : Carte qui sera ajouté dans le deck
	 */
	public void ajouterCarte(Carte a) {
		this.deck.add(a);
		Collections.sort(this.deck, Comparator.comparing(Carte::get_num_carte));// grâce a la bibliothèque Collection et Comparator 
																				// nous avons pu trier nos carte en fonctions du numéro
																				// de la carte
	}
	
	
	/**Retire une carte des mains du joueur et la renvoie
	 * 
	 * @param num : numéro de la carte qu'on désire retirer
	 * @return Instance de la carte (en l'occurence celle qu'on a retiré du deck du joueur)
	 */
	public Carte retirerCarte(int num) {
		Carte c=new Carte(0);
		for(Carte a:this.deck) {
			if(num==a.get_num_carte())
			{
				c=a;
				this.deck.remove(a);
				return c;
			}
		}
		return c;
	}
	
	/**
	 * Pour chaque carte du deck, on inscris le nom du joueur sur ces cartes 
	 */
	public void appropriation_des_Carte() {
		for(Carte a:this.deck) {
			a.attribuer_joueur(this.Nom);
		}
	}
	
	/**
	 * @return un booléen si le deck est vide de carte ou pas
	 */
	public boolean deck_vide() {
		return deck.isEmpty();
	}
	
	/**Verifie si le joueur posséde une carte dont le numéro est passé en parametre
	 * 
	 * @param num : numéro de la carte
	 * @return booléen si le joueur posssède oui ou non la carte
	 */
	public boolean possede_carte(int num) {
		for(Carte test:this.deck) {
			if (test.get_num_carte()==num) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * @return si un booléen si le joueur a ramassé des carte durant un tour
	 */
	public boolean a_ramasser_TeteDeBoeuf() {
		return this.ramasserTeteDeBoeuf;
	}
	
	/**
	 * Indique que le joueur a ramassé des cartes durant un x tour
	 */
	public void set_true_ramasseTeteDeBoeuf(){
		this.ramasserTeteDeBoeuf=true;
	}
	
	/**
	 * Indique que le joueur n'a pas ramassé des cartes durant un x tour
	 */
	public void set_false_ramasseTeteDeBoeuf() {
		this.ramasserTeteDeBoeuf=false;
	}
	
	
	/**Stock le nombre de tête de Boeuf qu'un joueur à reçu pendant un tour
	 * 
	 * @param nbTeteDeBoeuf qui est le nombre de tête de boeuf ramassé durant le tour
	 */
	public void set_nbTeteDeBoeuf_manche(int nbTeteDeBoeuf) {
		this.nbTeteDeBoeuf_manche=nbTeteDeBoeuf;
	}
	
	/**
	 * @return le nombre de tête de boeuf ramassé durant un tour
	 */
	public int get_nbTeteDeBoeuf_manche() {
		return this.nbTeteDeBoeuf_manche;
	}
	
	/**Construis une chaine de caractère représentant le deck du Joueur
	 * 
	 *@return s : Pour chaque carte, son numéro suivie du nombre de tête de Boeuf entre parenthése s'il y en a un.
	 */
	public String toString() {
		String s="";
		for(Carte a:this.deck) {
			s+=a.toString()+",";
		}
		
		return s.substring(1, s.length()-1);
	}
}