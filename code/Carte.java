package code;

/**
 * Cette classe permet de la cr�ation d'une Carte.<br>
 * Une carte est compos�e d'un num�ro unique et d'un nombre de t�te de Boeuf.<br>
 * Les num�ros attribu�s vont de 1 � 104.<br>
 * Le nombre de t�te de Boeuf d'une carte est calcul� par rapport <b> au  num�ro de la carte </b>.
 * <li>
 * Par d�faut une carte contient au moins 1 t�te de boeuf
 *</li>
 *
 *<li>
 * Les cartes dont le num�ro se termine par un 5 valent 2 t�te de Boeuf
 *</li>
 *
 * <li>
 * Les cartes dont le num�ro se termine par un 0 valent 3 t�te de Boeuf
 *</li>
 *
 *<li>
 *Les cartes dont le num�ro est form� par deux chiffres �gaux valent 5 t�te de Boeuf
 *</li>
 *
 *<li>
 *Attention a l'exception 55 qui vaut 7 t�te de Boeuf car elle poss�de deux chiffres �gaux et qui se termine par un 5.
 *</li><br>
 *
 *
 * @author MEZOUARI Anase, BIENVENU Math�o
 * 
 */

public class Carte {
	private int num_carte; // num�ro de la carte
	private String joueur; // nom du joueur qui poss�de cette carte s'il y en a un
	
	private static final int NB_DEFAULT_TETEdeBOEUF=1; 
	private static final int NB_5_TETEdeBOEUF=2;
	private static final int NB_0_TETEdeBOEUF=3;
	private static final int NB_CHIFFRE_EGAUX_TETEdeBOEUF=5;
	
	
	/** Constructeur de la classe Carte : il attribue le num�ro de la nouvelle carte cr�e gr�ce au parametre "numero"
	 *
	 * @param numero : numero qu'on attribura a la carte
	 */
	public Carte(int numero) {
		this.num_carte=numero;
	}
	
	
	/**Calcule le nombre de t�te de Boeuf pour chaque instance de la classe Carte en fonction de leurs num�ro
	 * 
	 * @return le nombre de t�te de boeuf d'une carte
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
	 * @return renvoie le nom du joueur qui poss�de la carte
	 */
	public String get_posseseur_carte() {
		return this.joueur;
		}
	
	/**
	 * @return le num�ro de la carte
	 */
	public int get_num_carte() {
		return num_carte;
	}
	
	/**Construis une chaine de caract�re repr�sentant la carte
	 * 
	 *@return s : le num�ro de la carte suivie du nombre de t�te de Boeuf entre parenth�se s'il y en a un.
	 */
	public String toString() {
		String s=" "+this.num_carte;
		if(this.get_nb_TetedeBoeuf()>1) {
			s+=" ("+this.get_nb_TetedeBoeuf()+")";
		}
		return s;
	}
}
