package code;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Cette classe permet de regrouper toute les autres classes du package application.<br>
 * Cette classe est constitu� :
 * <li> d'une liste de joueur qui regroupera tout les participants d'une partie de 6 qui Prend.</li>
 * <li> d'une liste de serie qui regroupera toutes les series d'une partie de 6 qui Prend.</li>
 * <li> d'une liste de Carte qui regroupera toutes les cartes choisis par les joueurs durant un tour de 6 qui Prend.</li>
 * <li> d'une pioche qui permettra de r�cuperer des cartes</li><br>
 * 
 * <b> Constante : </b><br>
 * <li>
 * MAX_JOUEUR qui est la valeur maximal qui de joueur dans une partie
 * </li>
 * <li>
 * MAX_CARTE_JOUEUR qui est la valeur maximal de carte que peut posseder un Joueur
 * </li>
 * <li>
 * NB_SERIE qui est la valeur maximal de serie dans une partie.
 * </li><br>
 * 
 * 
 * @author MEZOUARI Anase, BIENVENU Math�o
 * 
 */

/**
 * @author Anase
 *
 */
public class jeu {
	private ArrayList <Joueur> joueur;// Listes des joueurs qui joueront au jeux
	private ArrayList <Serie> serie; // listes des series presentes dans le jeux 
	private ArrayList <Carte> carteJoueurChoisis; // liste des cartes que les joueurs choisiront pendant chaque manche
	private Pioche pioche; // Instance pioche ou toute les cartes du jeux seront creer
	private int indice_joueur;// indice qui representera la position d'un joueur dans la liste "joueur"
	private int indice_serie;// indice qui representera la position d'une serie dans la liste "serie"
	
	private static final int MAX_JOUEUR=10; // le nombre maximum de joueur pour une partie
	private static final int MAX_CARTE_JOUEUR=10; // le nombre maximum de carte pour un joueur
	private static final int NB_SERIE=4; // Le nombre de serie qui doivent �tre creer pour le bon fonctionnement d'une partie.
	
	/**Contructeur : Initialise toute les entit�s n�ccesaire pour que la partie commence 
	 * 
	 */
	public jeu() {
		joueur= new ArrayList <Joueur>();
		serie= new ArrayList <Serie>();
		carteJoueurChoisis= new ArrayList <Carte>();
		pioche= new Pioche();
		indice_joueur=-1;
		indice_serie=-1;
		
		for (int i = 0; i < NB_SERIE; i++) {// on cr�er ici les series en leurs donnant chacune une carte de la pioche
			serie.add(new Serie(pioche.donneCarte()));
		}
		
	
	}
	
	/**Permet de r�cuperer un a un les joueurs de la partie
	 *  
	 * @return le joueur
	 */
	public Joueur getJoueur() {
		this.indice_joueur++;
		if(this.joueur.size()==this.indice_joueur) {
			this.indice_joueur=0;
		}
		return this.joueur.get(indice_joueur);
		
	}
	
	/**Permet de r�cuperer une a une les series de la partie
	 * 
	 * @return la serie
	 */
	public Serie getSerie() {
		this.indice_serie++;
		if(this.serie.size()==this.indice_serie) {
			this.indice_serie=0;
		}
		return this.serie.get(indice_serie);
		
	}
	
	/**
	 * @return le nombre de serie dans la partie
	 */
	public int nb_serie(){
		return this.serie.size();
	}
	
	/**
	 * @return le nombre de joueur dans la partie
	 */
	public int nb_joueur() {
		return this.joueur.size();
	}
	
	
	
	/**Permet d'ajouter un joueur dans la partie
	 * 
	 * @param nom : le nom du joueur
	 */
	public void ajouterJoueur(String nom) {
		if(joueur.size()<=MAX_JOUEUR) {
			Joueur j;
			j = new Joueur(nom);
			joueur.add(j);
		}
		
	}
	
	
	/**Construis une chaine de caract�re repr�sentant toutes les cartes choisis durant un tour par les Joueurs
	 * 
	 *@return s : Pour chaque carte, son num�ro suivie du nombre de t�te de Boeuf entre parenth�se s'il y en a un.
	 */
	public String toStringCarteChoisis() {
		String s="";
		for (int i = 0; i < this.carteJoueurChoisis.size(); i++) {
			if(i==this.carteJoueurChoisis.size()-1) {
				s+=" "+carteJoueurChoisis.get(i).get_num_carte()+" ("+carteJoueurChoisis.get(i).get_posseseur_carte()+")";
			}
			else if(i==this.carteJoueurChoisis.size()-2) {
				s+=" "+carteJoueurChoisis.get(i).get_num_carte()+" ("+carteJoueurChoisis.get(i).get_posseseur_carte()+") et";
			}
			else {
				s+=" "+carteJoueurChoisis.get(i).get_num_carte()+" ("+carteJoueurChoisis.get(i).get_posseseur_carte()+"),";
			}
		}
		
		return s+" ";
	}
	
	
	/**Ajoute dans la liste une carte pass�e en parametre
	 * 
	 * @param a : la carte que le joueurs a choisis de jouer
	 */
	public void ajouter_carte_choisis(Carte a) {
		this.carteJoueurChoisis.add(a);
		Collections.sort(this.carteJoueurChoisis, Comparator.comparing(Carte::get_num_carte));
		
	}
	
	
	/** Distribue a chaque joueurs des cartes et inscris le nom du joueur dans les cartes qu'ils lui ont �t� distribu�
	 * 
	 */
	public void distribuer() {
		for(Joueur j:this.joueur) {
			for (int i = 0; i < MAX_CARTE_JOUEUR; i++) {
				j.ajouterCarte(pioche.donneCarte());
			}
			j.appropriation_des_Carte();
			
		}
	}
	
	/**
	 * @return un boolean si la liste des cartes choisis par les Joueurs est vide(true) ou non(false)
	 */
	public boolean carteJoueurChoisis_isEmpty() {
		return this.carteJoueurChoisis.isEmpty();
	}
	
	
	/**Initialise pour chaque joueur son bool�en a_ramasser_TeteDeBoeuf ce qui signifie qu'il n'ont pas ramasser durant un tour des t�tes de Boeuf
	 * 
	 */
	public void initialiseJoueurCarteRamasser() {
		for(Joueur j:this.joueur) {
			if(j.a_ramasser_TeteDeBoeuf()) {
				j.set_false_ramasseTeteDeBoeuf();
			}
		}
	}
	
	/**Traite les cartes qui ont �t� choisis d'�tre jouer par les joueurs
	 * Seul les trois premieres r�gles sont utilis� ici
	 * 
	 * @return un bool�en si oui(true) ou non(false) la carte a pu �tre pos�e (si la fonction retourne false alors la r�gle 4 devras etre ex�cut�)
	 */
	public boolean poseCarteChoisis() {
			// la fonction traite une carte par une carte
			int i;
			Carte a=this.carteJoueurChoisis.get(0);
			
			int num_serie_valide=0;
			int diff_num_carte=this.serie.get(num_serie_valide).differenceDeNumeroAvec(a);
			
			if(diff_num_carte<0) {
				diff_num_carte=105;
			}
			
			boolean carte_pose=false;
			for (i=1; i < this.serie.size(); i++) 
			{// on parcourt toutes les series
				if(this.serie.get(i).estPlusPetitQue(a)) // r�gle 1
				{
					if(this.serie.get(i).differenceDeNumeroAvec(a)<diff_num_carte) // r�gle 2
					{
							diff_num_carte=this.serie.get(i).differenceDeNumeroAvec(a);
							num_serie_valide=i;		
							carte_pose=true;

					}
				}
			}
			
				
			if(carte_pose) {
				if (!this.serie.get(num_serie_valide).estPleine()) 
				{
				this.serie.get(num_serie_valide).ajouter_carte(a);// on ajoute la carte a la serie qui peut selon les r�gles abriter cette carte
				this.carteJoueurChoisis.remove(0); // on supprime la carte pour qu'au prochain appele de la fonction on traite la suivante
				}
				else { // regle 3
					this.regle3(num_serie_valide, a);// la serie peut abriter la carte mais elle est pleine donc place a la r�gle 3
					this.carteJoueurChoisis.remove(0);// on supprime la carte pour qu'au prochain appele de la fonction on traite la suivante
				}
				return true;
			}
			
			// on verifie pour la premiere serie si la carte peut y �tre pos� car plus haut on compar� les series une a une en partant de 
			// la premiere, donc celle si n'a pas pu �tre tester 
			
			if(this.serie.get(0).estPlusPetitQue(a)) {
				if (!this.serie.get(0).estPleine()) 
				{
					this.serie.get(0).ajouter_carte(a);// on ajoute la carte a la serie qui peut selon les r�gles abriter cette carte

					this.carteJoueurChoisis.remove(0);// on supprime la carte pour qu'au prochain appele de la fonction on traite la suivante
					
				}
				else 
				{// regle 3
					this.regle3(0, a);// la serie peut abriter la carte mais elle est pleine donc place a la r�gle 3
					this.carteJoueurChoisis.remove(0);// on supprime la carte pour qu'au prochain appele de la fonction on traite la suivante
				}
				return true;
			}
			
			return false;
	}
	
	
	
	/**Cette fonction applique la regle 3 du jeu qui est : 
	 * Lorsqu'une sixi�me carte doit �tre d�pos�e dans une serie (en comportant donc d�j� 5), le joueur 
	 * ramasse les 5 cartes de la s�rie (c'est sa p�nalit�) et la sixi�me forme alors le d�but d'une nouvelle s�rie
	 * 
	 * @param indice_serie : indice de la serie a nettoyer
	 * @param a : 6eme carte a placer au debut de la serie
	 */
	public void regle3(int indice_serie,Carte a) {
		
		int indice_joueur=0;
		for (int i = 0; i < joueur.size(); i++) {// on cherche ici celui ou celle a qui appartenait la carte
			if(joueur.get(i).get_Nom()==a.get_posseseur_carte()) {
				indice_joueur=i;
			}
		}
		
		joueur.get(indice_joueur).prendTetedeBoeuf(serie.get(indice_serie).get_total_TeteBoeuf());// on incremente son compteur total 
		joueur.get(indice_joueur).set_nbTeteDeBoeuf_manche(serie.get(indice_serie).get_total_TeteBoeuf());// on increment aussi son compteur par manche
		joueur.get(indice_joueur).set_true_ramasseTeteDeBoeuf();// on passe a true son bool�en qui indique que le joueur a ramass� des t�tes de Boeufs
		
		serie.get(indice_serie).vider();// on vide la serie
		serie.get(indice_serie).ajouter_carte(a);// on ajoute la carte
		
		
	}
	
	/**Cette fonction applique la regle 4 du jeu qui est : 
	 * 
	 * Si la carte devant �tre d�pos�� par un joueur a une valuer si faible qu'elle ne peut aller dans aucune s�rie,
	 * le joueur ramasse toutes les cartes d'une serie de son choix et la carte du joueur forme alors le d�but d'une nouvelle serie

	 * @param indice_serie : indice de la serie que le joueur veut ramasser
	 */
	
	public void regle4(int indice_serie) {
		Carte a=this.carteJoueurChoisis.get(0);
		
		int indice_joueur=0;
		for (int i = 0; i < joueur.size(); i++) {// comme dans la r�gle 3 on doit retrouver a qui appartient la carte
			if(joueur.get(i).get_Nom()==a.get_posseseur_carte()) {
				indice_joueur=i;
			}
		}
		joueur.get(indice_joueur).prendTetedeBoeuf(serie.get(indice_serie).get_total_TeteBoeuf());// on incremente son compteur total 
		joueur.get(indice_joueur).set_nbTeteDeBoeuf_manche(serie.get(indice_serie).get_total_TeteBoeuf());// on increment aussi son compteur par manche
		joueur.get(indice_joueur).set_true_ramasseTeteDeBoeuf();// on passe a true son bool�en qui indique que le joueur a ramass� des t�tes de Boeufs
		
		serie.get(indice_serie).vider();// on vide la serie
		serie.get(indice_serie).ajouter_carte(a);// on ajoute la carte qui etait incompatible avec les series
		
		this.carteJoueurChoisis.remove(0);//// on supprime la carte pour qu'au prochain appele de la fonction on traite la suivante
	}

	
	/**Permet de conna�tre la fin de la partie
	 * 
	 * @return false ou true si la partie n'est pas finis ou si elle l'est
	 */
	public boolean jeux_fini() {
		for(Joueur j:this.joueur) {
			if(!j.deck_vide()) {return false;}
		}
		return true;
	}
	
	/**
	 * @return la premiere carte de la liste des cartes choisis par les joueurs
	 */
	public Carte getCarteJoueurChoisis() {
		return this.carteJoueurChoisis.get(0);
	}
	
	
	/**
	 * Trie les joueurs en fonction de leurs nombre de t�te de Boeuf
	 */
	public void trierJoueurTetedeBoeuf() {
		Collections.sort(this.joueur, Comparator.comparing(Joueur::get_TetedeBoeuf));
	}
}
