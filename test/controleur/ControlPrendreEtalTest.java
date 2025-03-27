package controleur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;
import personnages.Chef;
import personnages.Gaulois;


class ControlPrendreEtalTest {
	private Village village;
	private Chef abraracourcix;
	private ControlPrendreEtal controlPrendreEtal;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlEmmenager controlEmmenager;
	
	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite	, village);
		controlEmmenager = new ControlEmmenager(village);
	}
	
	
	@Test
	void testControlPrendreEtal() {
		assertNotNull(controlPrendreEtal, "Constructeur ne renvoie pas null");
	}
	
	@Test
	void testResteEtals() {
		assertTrue(controlPrendreEtal.resteEtals());
		
	}
	
	@Test
	void testPrendreEtal() {
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		assertTrue(controlEmmenager.isHabitant("Bonemine"));
		assertNotNull(controlPrendreEtal.prendreEtal("Bonemine", "fleur", 10));
	}
	@Test
	void testVerifierIdentite() {
		controlEmmenager.ajouterGaulois("Panda", 10);
		assertTrue(controlVerifierIdentite.verifierIdentite("Panda"));
	}

}
