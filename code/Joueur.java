package code;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 * Cette classe permet de la cr�ation d'un Joueur.<br>
 * Un joueur est determin� par un nom.Ils poss�dent un compteur qui d�nombre le total de t�te de Boeuf qu'il a ramass� et
 * un deck qui contient les cartes qu'il aura durant la partie.
 * 
 * <br><i>Le boole�n ramasserTeteDeBoeuf et la variable nbTeteDeBoeuf_manche permettront de savoir si le joueur � r�colter 
 * des t�tes des boeufs durant le tour, si oui combien il en a pris</i>
 * 
 * @author MEZOUARI Anase, BIENVENU Math�o
 * 
 */


public class Joueur {
	
	private String Nom; // Nom du joueur
	private int nbTeteDeBoeuf; // nombre total de t�te de boeuf qu'il a cumul�
	private ArrayList<Carte> deck;// ensemble de cartes que poss�de le joueur 
	
	private boolean ramasserTeteDeBoeuf;// bool�en qui indique si le joueur a rammas� des t�tes de boeuf pendant un tour
	private int nbTeteDeBoeuf_manche;// nombre de t�te de t�tes de boeuf ramass� pendant un tour
	
	/**Constructeur de la classe : un joueur est cr�er en passant par parametre son nom
	 * 							   Toute les donn�es relative � l'instance cr�er son initialiser
	 * 
	 * @param nom : nom du Joueur
	 */
	public Joueur(String nom) {
		this.Nom=nom;
		this.nbTeteDeBoeuf=0;
		this.deck=new ArrayList<Carte>();
		this.ramasserTeteDeBoeuf=false;
	}
	
	
	/**Incr�mente le compteur total de t�te de boeuf que le joueur a cumul�
	 * 
	 * @param nombre_tete_de_boeuf 
	 */
	public void prendTetedeBoeuf(int nombre_tete_de_boeuf) {
		if(nombre_tete_de_boeuf>=0) {this.nbTeteDeBoeuf+=nombre_tete_de_boeuf;}
		
	}
	
	
	/**
	 * @return le nombre de total de t�te de Boeuf que le joueur a cumul�
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
	 * @param a : Carte qui sera ajout� dans le deck
	 */
	public void ajouterCarte(Carte a) {
		this.deck.add(a);
		Collections.sort(this.deck, Comparator.comparing(Carte::get_num_carte));// gr�ce a la biblioth�que Collection et Comparator 
																				// nous avons pu trier nos carte en fonctions du num�ro
																				// de la carte
	}
	
	
	/**Retire une carte des mains du joueur et la renvoie
	 * 
	 * @param num : num�ro de la carte qu'on d�sire retirer
	 * @return Instance de la carte (en l'occurence celle qu'on a retir� du deck du joueur)
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
	 * @return un bool�en si le deck est vide de carte ou pas
	 */
	public boolean deck_vide() {
		return deck.isEmpty();
	}
	
	/**Verifie si le joueur poss�de une carte dont le num�ro est pass� en parametre
	 * 
	 * @param num : num�ro de la carte
	 * @return bool�en si le joueur posss�de oui ou non la carte
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
	 * @return si un bool�en si le joueur a ramass� des carte durant un tour
	 */
	public boolean a_ramasser_TeteDeBoeuf() {
		return this.ramasserTeteDeBoeuf;
	}
	
	/**
	 * Indique que le joueur a ramass� des cartes durant un x tour
	 */
	public void set_true_ramasseTeteDeBoeuf(){
		this.ramasserTeteDeBoeuf=true;
	}
	
	/**
	 * Indique que le joueur n'a pas ramass� des cartes durant un x tour
	 */
	public void set_false_ramasseTeteDeBoeuf() {
		this.ramasserTeteDeBoeuf=false;
	}
	
	
	/**Stock le nombre de t�te de Boeuf qu'un joueur � re�u pendant un tour
	 * 
	 * @param nbTeteDeBoeuf qui est le nombre de t�te de boeuf ramass� durant le tour
	 */
	public void set_nbTeteDeBoeuf_manche(int nbTeteDeBoeuf) {
		this.nbTeteDeBoeuf_manche=nbTeteDeBoeuf;
	}
	
	/**
	 * @return le nombre de t�te de boeuf ramass� durant un tour
	 */
	public int get_nbTeteDeBoeuf_manche() {
		return this.nbTeteDeBoeuf_manche;
	}
	
	/**Construis une chaine de caract�re repr�sentant le deck du Joueur
	 * 
	 *@return s : Pour chaque carte, son num�ro suivie du nombre de t�te de Boeuf entre parenth�se s'il y en a un.
	 */
	public String toString() {
		String s="";
		for(Carte a:this.deck) {
			s+=a.toString()+",";
		}
		
		return s.substring(1, s.length()-1);
	}
}