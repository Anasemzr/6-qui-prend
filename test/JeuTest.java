package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import code.Serie;
import code.Carte;
import code.Joueur;
import code.jeu;

class JeuTest {
	jeu j =new jeu();
	
	@Test
	void testAjouterJoueur() {
		j.ajouterJoueur("Anase");
		j.ajouterJoueur("Mathéo");
		assertEquals(2,j.nb_joueur());
	}

	@Test
	void testPoseCarteChoisis() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testRegle3() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testRegle4() {
		fail("Not yet implemented"); // TODO
	}

}
