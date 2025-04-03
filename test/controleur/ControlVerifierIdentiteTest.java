package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private Village village;
	private Chef abraracourcix;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlEmmenager controlEmmenager;

	@BeforeEach
	
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlEmmenager = new ControlEmmenager(village);
	}
	
	@Test
	void test() {
		controlEmmenager.ajouterGaulois("Bonemine", 3);
		assertTrue(controlVerifierIdentite.verifierIdentite("Bonemine"));
		assertFalse(controlVerifierIdentite.verifierIdentite("Flora"));
		
	}

}
