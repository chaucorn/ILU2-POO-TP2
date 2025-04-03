package frontiere;

import java.util.Iterator;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche =  controlAfficherMarche.donnerInfosMarche();
		if (infosMarche.length ==0) {
			System.out.println("Le marche est vide, revenez plus tard");
		}else {
			System.out.println(nomAcheteur + ", vous trouverez au marche:");
			int nbEtal = infosMarche.length / 3;
		int j = 0;
		for (int i = 0; i < nbEtal; i++) {
			String vendeurNom = infosMarche[j++];
			String quantite = infosMarche[j++];
			String produit = infosMarche[j++];
			System.out.println("- " + vendeurNom + " qui vend " + quantite + " " + produit);
			
		}
		}
		
	}
}
