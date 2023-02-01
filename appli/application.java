package appli;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import code.Carte;
import code.Joueur;
import code.jeu;

public class application {

	public static void main(String[] args) {
		jeu partie; 
		partie=new jeu();
		
		File doc =new File("config.txt"); // fichier ou sont renseigné le nom des Joueurs
		Scanner obj=null; // scanner qui serviras a lire le fichier "config.txt"
		
		try {// ouvertur du fichier pour commencer à le lire
			obj = new Scanner(doc);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		String joueur="";
		String nom;
		
		while (obj.hasNextLine()){// Ajout des Joueur a la partie
			nom=obj.nextLine();
			partie.ajouterJoueur(nom);
			
			if(!obj.hasNextLine()) {
				joueur=joueur.substring(0, joueur.length()-1)+" et "+nom;
			}
			else {
				joueur+=" "+nom+",";
			}
		}
		
		
		partie.distribuer(); // distribution des cartes
		String s="Les "+partie.nb_joueur()+" joueurs sont"+joueur+". Merci de jouer à 6 qui prend !";
		System.out.println(s);
		
		Scanner sc = new Scanner(System.in);// scanner qui serviras a lire les entrée des joueurs 
		
		while(!partie.jeux_fini()) 
		{
			
			for (int i = 0; i < partie.nb_joueur(); i++) 
			{// boucle pour permettre a chaque joueur de jouer
				
				Joueur player=partie.getJoueur();// on recupere un joueur
				player.set_false_ramasseTeteDeBoeuf();
				System.out.println("A "+player.get_Nom()+" de jouer.");
				Console.pause();
				
				for (int k = 0; k < partie.nb_serie(); k++) {// on affiche les series
					System.out.println("- série n° "+(k+1)+" : "+partie.getSerie().toString());
				}
				System.out.println("- Vos cartes : "+player.toString());// on affiche les cartes du joueur ou de la joueuse
				
				
				System.out.print("Saisissez votre choix : "); 
	
				boolean valeur_valide=false;
				int carte_valide=0;
				
				
				while(!valeur_valide) {// ici on demande au joueur de choisir une de ces cartes
					
					if(!sc.hasNextInt()) {// si la valeur fourni n'est pas un entier on lui redemande de choisir
						  sc.next();
						  System.out.print("Vous n’'avez pas cette carte, saisissez votre choix : ");
					} 
					else {
						carte_valide=sc.nextInt();
						if (player.possede_carte(carte_valide))
						{
							valeur_valide=true;
						}
						else {// si la valeur fourni est bien un entier mais qu'il ne possède pas la carte choisis alors on lui redemande de choisir
							System.out.print("Vous n'’avez pas cette carte, saisissez votre choix : ");
						}
						
					}
				}
				
				partie.ajouter_carte_choisis(player.retirerCarte(carte_valide));// la carte choisis est ajouté a la liste des cartes choisis pendant un tour
				Console.clearScreen();
				
			}
			
			
				
				boolean carte_bien_poser;
				String carteChoisis = partie.toStringCarteChoisis(); 
				
				while(!partie.carteJoueurChoisis_isEmpty()) // tant que toutes les cartes choisis par les joueurs n'ont pas été traité
				{
					carte_bien_poser=partie.poseCarteChoisis();// on applique les 3 règle
					
					if(!carte_bien_poser) { // si la carte n'a pas ete poser alors on applique la régle 4
						Carte a=partie.getCarteJoueurChoisis();
						System.out.println("Les cartes"+carteChoisis+"vont être posées.");
						System.out.println("Pour poser la carte "+a.get_num_carte()+", "+a.get_posseseur_carte()+" doit choisir la série qu'il va ramasser.");
						
						for (int k = 0; k < partie.nb_serie(); k++) { // on affiche les series
							System.out.println("- série n° "+(k+1)+" : "+partie.getSerie().toString());
						}
						
						System.out.print("Saisissez votre choix : ");
						
						
						
						boolean serie_valide=false;
						int num_serie=0;
						
						
						while(!serie_valide) { // ici on demande au joueur de choisir une de ces cartes
							
							if(!sc.hasNextInt()) {// si la valeur fourni n'est pas un entier on lui redemande de choisir
								  sc.next();
								  System.out.print("Ce n’est pas une série valide, saisissez votre choix : ");
							} 
							else {
								num_serie=sc.nextInt();
								if (partie.nb_serie()>num_serie-1 && num_serie-1>=0)
								{
									serie_valide=true;
								}
								else {// si la valeur fourni est bien un entier mais qu'il ne possède pas la carte choisis alors on lui redemande de choisir
									System.out.print("Ce n’est pas une série valide, saisissez votre choix : ");
								}
								
							}
						}
						
						
						partie.regle4(num_serie-1);// on applique la régle 4 pour la serie que le joueur a décidé de ramasser
					}
			}
			
			
			System.out.println("Les cartes"+carteChoisis+"ont été posées.");
			
			for (int k = 0; k < partie.nb_serie(); k++) { // on affiche les series
				System.out.println("- série n° "+(k+1)+" : "+partie.getSerie().toString());
			}
			
			String JoueurRamasserCarte="";
			boolean ramasser=false;
			for (int i = 0; i < partie.nb_joueur(); i++) 
			{// on affiche les joueurs qui ont ramassés des têtes de Boeufs durant la manche
				
				Joueur player=partie.getJoueur();
				if(player.a_ramasser_TeteDeBoeuf()) {
					ramasser=true;
					JoueurRamasserCarte+=player.get_Nom()+" a ramassé "+player.get_nbTeteDeBoeuf_manche();
					
					if(player.get_nbTeteDeBoeuf_manche()>1) {JoueurRamasserCarte+=" têtes de boeufs";}
					else {JoueurRamasserCarte+=" tête de boeufs";}
					
					JoueurRamasserCarte+="\n";
					
				}

			}
			if(!ramasser) {
				JoueurRamasserCarte="Aucun joueur ne ramasse de tête de boeufs.";
			}
			System.out.println(JoueurRamasserCarte.substring(0, JoueurRamasserCarte.length()-2));
			
		}
		
		System.out.println("** Score final");
		for (int i = 0; i < partie.nb_joueur(); i++) 
		{// on affiche le nom de chaque Joueur suivi du nombre de tête de Boeufs qu'il a ammassé
			
			
			partie.trierJoueurTetedeBoeuf();// on trie les joueurs en fonction de leurs nombres total de tête de Boeuf
			Joueur player=partie.getJoueur();
			if(player.get_TetedeBoeuf()>1) {
				System.out.println(player.get_Nom()+" a ramassé "+player.get_TetedeBoeuf()+" têtes de boeufs");
			}
			else
			{
				System.out.println(player.get_Nom()+" a ramassé "+player.get_TetedeBoeuf()+" tête de boeufs");
			}
			
			
		}
		
		
	}
	

}
