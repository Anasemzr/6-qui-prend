package test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import code.Serie;
import code.Carte;

public class SerieTest {
	Carte c1 = new Carte(25);
	Serie s= new Serie(new Carte(20));
	
	@Test
	public void testEstPlusPetitQue() {
		assertTrue(s.estPlusPetitQue(c1)); // TODO
	}

	@Test
	public void testDifferenceDeNumeroAvec() {
		assertEquals(5, s.differenceDeNumeroAvec(c1)); // TODO
	}

	@Test
	public void testAjouter_carte() {
		int taille=s.taille();
		s.ajouter_carte(c1);
		assertTrue(taille<s.taille());
		// TODO
	}

	@Test
	public void testEstPleine() {
		assertFalse(s.estPleine()); // TODO
	}

}
