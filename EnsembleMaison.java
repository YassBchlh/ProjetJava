import java.util.HashMap;
import java.util.Scanner;
public class EnsembleMaison{
	private HashMap<String,Maison> ensembleMaisons;
	
	public EnsembleMaison() {
		ensembleMaisons = new HashMap<String,Maison>();
	}
	
	public void ajouterMaison() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez le nom et la consommation de la maison : ");
		String nom = sc.next();
		String conso = sc.next();
		ConsoMaison cM = ConsoMaison.valueOf(conso.toUpperCase());
		if(!estPresent(nom)) {
			Maison m = new Maison(nom,cM);
			ensembleMaisons.put(m.getNom(), m);
			System.out.println("La maison "+nom+ " de capacité "+m.demandeElectrique()+" kW a bien été ajoutée ");
		}else {
			Maison m = rechercheMaison(nom);
			m.setCM(cM);
			System.out.println("La maison "+nom+" avait déjà été ajoutée. Nous avons donc mis à jour la consommation à "+m.demandeElectrique() +" kW");
		}
	}
	private ConsoMaison Inverse(Integer valeur) {
		int val = valeur.intValue();
		ConsoMaison cM = null;
		switch(val) {
		case 10 : cM = ConsoMaison.BASSE;
				 break;
		case 20 : cM = ConsoMaison.NORMAL;
				 break;
		case 40 : cM = ConsoMaison.FORTE;
				 break;
		}
		return cM;
	}
	public boolean estPresent(String nomMaison) {
		return ensembleMaisons.containsKey(nomMaison);
	}
	public Maison rechercheMaison(String nomM) {
		for(String nomMaison : ensembleMaisons.keySet()) {
			if(nomMaison.equals(nomM)) {
				/*ConsoMaison cM = Inverse(ensembleMaisons.get(nomM));
				Maison m = new Maison(nomMaison,cM);
				return m;*/
				return ensembleMaisons.get(nomM);
			}
		}
		return null;
	}
}