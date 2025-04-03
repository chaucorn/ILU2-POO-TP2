package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;
import villagegaulois.Etal;
class ControlLibererEtalTest {
	private Village village;
	private Chef abraracourcix;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlEmmenager controlEmmenager;
	private ControlPrendreEtal controlPrendreEtal;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlLibererEtal controlLibererEtal;
	
	@BeforeEach
	
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlEmmenager = new ControlEmmenager(village);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
	}
	@Test
	void test() {
		controlEmmenager.ajouterGaulois("Bonemine", 5);
		controlPrendreEtal.prendreEtal("Bonemine", "fleurs", 10);
		Etal bonemine_etal = controlTrouverEtalVendeur.trouverEtalVendeur("Bonemine");
		assertTrue(bonemine_etal.isEtalOccupe());
		controlLibererEtal.libererEtal("Bonemine");
		assertFalse(bonemine_etal.isEtalOccupe());
	}

}
