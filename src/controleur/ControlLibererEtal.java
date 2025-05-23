package controleur;
import villagegaulois.Etal;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
		//this.village = village;
	}

	
	public boolean isVendeur(String nomVendeur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur)!=null;
	}
	/**
	 * 
	 * @param nomVendeur
	 * @return donneesEtal est un tableau de chaine contenant
	 * 		[0] : un boolean indiquant si l'étal est occupé
	 * 		[1] : nom du vendeur
	 * 		[2] : produit vendu
	 * 		[3] : quantité de produit à vendre au début du marché
	 * 		[4] : quantité de produit vendu
	 */
	public String[] libererEtal(String nomVendeur) {
		String[] donneesEtal = new String[5];
		
		if(!isVendeur(nomVendeur)) {
			System.out.println("Mais vous n'etes pas inscrit sur notre marche aujourd'hui!");
			donneesEtal[0] = "0";
		}
		else 
		{
			Etal etalTrouve =  controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
			donneesEtal =  etalTrouve.etatEtal();	
			System.err.println("Vous avez vendu " + donneesEtal[4] + " sur " + donneesEtal[3]
					+ " " + donneesEtal[2] + ".");
			System.out.println("Au revoir Bonemine, passez une bonne journee.");
			etalTrouve.libererEtal();
;		}
		return donneesEtal;
		
	}
	

}
