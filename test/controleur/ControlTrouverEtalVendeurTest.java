package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;
import villagegaulois.Etal;

class ControlTrouverEtalVendeurTest {
	private Village village;
	private Chef abraracourcix;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlEmmenager controlEmmenager;
	private ControlPrendreEtal controlPrendreEtal;
	private ControlVerifierIdentite controlVerifierIdentite;


	@BeforeEach
	
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlEmmenager = new ControlEmmenager(village);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
	}
	@Test
	void test() {
		controlEmmenager.ajouterGaulois("Bonemine", 5);
		controlEmmenager.ajouterGaulois("Panda", 10);
		int numero1 = controlPrendreEtal.prendreEtal("Bonemine", "fleurs", 10);
		int numero2 = controlPrendreEtal.prendreEtal("Panda", "sangliers", 20);
		Etal etal_bonemine = controlTrouverEtalVendeur.trouverEtalVendeur("Bonemine");
		assertEquals(numero1,0);
		assertEquals(numero2,1);

	}

}
