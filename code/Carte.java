package code;

/**
 * Cette classe permet de la création d'une Carte.<br>
 * Une carte est composée d'un numéro unique et d'un nombre de tête de Boeuf.<br>
 * Les numéros attribués vont de 1 à 104.<br>
 * Le nombre de tête de Boeuf d'une carte est calculé par rapport <b> au  numéro de la carte </b>.
 * <li>
 * Par défaut une carte contient au moins 1 tête de boeuf
 *</li>
 *
 *<li>
 * Les cartes dont le numéro se termine par un 5 valent 2 tête de Boeuf
 *</li>
 *
 * <li>
 * Les cartes dont le numéro se termine par un 0 valent 3 tête de Boeuf
 *</li>
 *
 *<li>
 *Les cartes dont le numéro est formé par deux chiffres égaux valent 5 tête de Boeuf
 *</li>
 *
 *<li>
 *Attention a l'exception 55 qui vaut 7 tête de Boeuf car elle posséde deux chiffres égaux et qui se termine par un 5.
 *</li><br>
 *
 *
 * @author MEZOUARI Anase, BIENVENU Mathéo
 * 
 */

public class Carte {
	private int num_carte; // numéro de la carte
	private String joueur; // nom du joueur qui possède cette carte s'il y en a un
	
	private static final int NB_DEFAULT_TETEdeBOEUF=1; 
	private static final int NB_5_TETEdeBOEUF=2;
	private static final int NB_0_TETEdeBOEUF=3;
	private static final int NB_CHIFFRE_EGAUX_TETEdeBOEUF=5;
	
	
	/** Constructeur de la classe Carte : il attribue le numéro de la nouvelle carte crée grâce au parametre "numero"
	 *
	 * @param numero : numero qu'on attribura a la carte
	 */
	public Carte(int numero) {
		this.num_carte=numero;
	}
	
	
	/**Calcule le nombre de tête de Boeuf pour chaque instance de la classe Carte en fonction de leurs numéro
	 * 
	 * @return le nombre de tête de boeuf d'une carte
	 */
	public int get_nb_TetedeBoeuf() {
		int nb=Carte.NB_DEFAULT_TETEdeBOEUF;
		
		if(this.num_carte%10==0) {
			nb=Carte.NB_0_TETEdeBOEUF;
		}
		
		if(this.num_carte%5==0 && this.num_carte%2!=0) {
			nb=Carte.NB_5_TETEdeBOEUF;
		}
		
		if(this.num_carte%10==this.num_carte/10) {
			nb=Carte.NB_CHIFFRE_EGAUX_TETEdeBOEUF;
		}
		
		return nb;
	}
	
	
	
	/**Enrengistre le nom du joueur pour une instance x de cette classe
	 * 
	 * @param nom : nom de Joueur
	 */
	public void attribuer_joueur(String nom) {
		this.joueur=nom;
	}
	
	
	/**
	 * @return renvoie le nom du joueur qui possède la carte
	 */
	public String get_posseseur_carte() {
		return this.joueur;
		}
	
	/**
	 * @return le numéro de la carte
	 */
	public int get_num_carte() {
		return num_carte;
	}
	
	/**Construis une chaine de caractère représentant la carte
	 * 
	 *@return s : le numéro de la carte suivie du nombre de tête de Boeuf entre parenthése s'il y en a un.
	 */
	public String toString() {
		String s=" "+this.num_carte;
		if(this.get_nb_TetedeBoeuf()>1) {
			s+=" ("+this.get_nb_TetedeBoeuf()+")";
		}
		return s;
	}
}
