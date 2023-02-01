package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import code.Pioche;
import code.Carte;

class PiocheTest {
	Pioche p = new Pioche();
	@Test
	void testDonneCarte() {
		Carte a=p.donneCarte();
		assertTrue(a.get_num_carte()>0 && 104>a.get_num_carte());
	}

	@Test
	void testVide() {
		assertFalse(p.vide());
		
	}

}
