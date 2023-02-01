package test;

import static org.junit.Assert.*;

import org.junit.Test;
import code.Carte;

public class CarteTest {
	Carte a = new Carte(55);
	
	@Test
	public void testGet_nb_TetedeBoeuf() {
		assertTrue(a.get_nb_TetedeBoeuf() == 5);
	}
	
	@Test
	public void testAttribuer_joueur() {
		a.attribuer_joueur("Anase");
		assertTrue(a.get_posseseur_carte()=="Anase");
	}

}
