package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous etes deja un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Etes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1: //Druide
					emmenagerDruide(nomVisiteur);
					break;

				case 2: //Gaulois
					emmenagerGaulois(nomVisiteur);
					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}



	private void emmenagerGaulois(String nomVisiteur) {
		System.out.println("Bienvenue villageois " + nomVisiteur );
		int gauloisForce = Clavier.entrerEntier("Quelle est votre force?");
		controlEmmenager.ajouterGaulois(nomVisiteur, gauloisForce);

		
	}

	private void emmenagerDruide(String nomVisiteur) {
		System.out.println("Bienvenue druide " + nomVisiteur );
		int druideForce = -1;
		druideForce = Clavier.entrerEntier("Quelle est votre force?");
		int effetPotionMax = -2; 
		int effetPotionMin = -1;
		effetPotionMin = Clavier.entrerEntier("Quelle est la force de potion la plus faible que vous produisez?");
		effetPotionMax = Clavier.entrerEntier("Quelle est la force de potion la plus forte que vous produisez?");
		while (effetPotionMax < effetPotionMin) {
			System.out.println("Attention Druide, vous vous etes trompe entre le minimum et le maximum");
			effetPotionMin = Clavier.entrerEntier("Quelle est la force de potion la plus faible que vous produisez?");
			effetPotionMax = Clavier.entrerEntier("Quelle est la force de potion la plus forte que vous produisez?");
		}
		controlEmmenager.ajouterDruide(nomVisiteur, druideForce, effetPotionMin, effetPotionMax);
	}
}
