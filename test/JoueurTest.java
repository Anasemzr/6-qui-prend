package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import code.Joueur;
import code.Carte;

class JoueurTest {
	Joueur j = new Joueur("Anase");
	Carte c = new Carte(55);
	@Test
	void testPrendTetedeBoeuf() {
		int nb=j.get_TetedeBoeuf();
		j.prendTetedeBoeuf(5);
		assertTrue(nb<j.get_TetedeBoeuf());
	}

	@Test
	void testAjouterCarte() {
		j.ajouterCarte(c);
		assertTrue(j.possede_carte(c.get_num_carte()));// TODO
	}

	@Test
	void testRetirerCarte() {
		j.ajouterCarte(c);
		j.retirerCarte(c.get_num_carte());
		assertFalse(j.possede_carte(c.get_num_carte()));// TODO
	}

	@Test
	void testAppropriation_des_Carte() {
		j.ajouterCarte(c);
		j.appropriation_des_Carte();
		assertTrue("Anase"==c.get_posseseur_carte());
	}

	@Test
	void testPossede_carte() {
		j.ajouterCarte(c);
		assertTrue(j.possede_carte(c.get_num_carte())); // TODO
	}


}
