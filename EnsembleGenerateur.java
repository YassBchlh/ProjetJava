import java.util.HashMap;
import java.util.Scanner;
public class EnsembleGenerateur{
	private HashMap<String,Generateur> ensembleGenerateur;
	
	public EnsembleGenerateur() {
		//ensembleGenerateur = new HashMap<String,Integer>();
		ensembleGenerateur = new HashMap<String,Generateur>();
	}
	public void ajouterGenerateur() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez le nom et la capacité de votre générateur : ");
		String nom = sc.next();
		int capaciteMax = sc.nextInt();
		if(!estPresentGenerateur(nom)) {
			Generateur g = new Generateur(nom,capaciteMax);
			ensembleGenerateur.put(g.getNom(), g);
			System.out.println("Le générateur "+nom+" ayant pour capacité "+capaciteMax+" kW a été ajouté \n");
		}else {
			System.out.println("Le générateur "+nom+" avait déjà été ajouté. Nous avons donc mis à jour la capacité ");
			System.out.println("Le générateur "+nom+" a donc pour nouvelle capacité "+capaciteMax+" kW ");
			Generateur g = rechercheGenerateur(nom);
			g.setCapacite(capaciteMax);
		}
	}
	public Generateur rechercheGenerateur(String nomGen) {
		for(String nomGenerateur : ensembleGenerateur.keySet()) {
			if(nomGenerateur.equals(nomGen)) {
				return ensembleGenerateur.get(nomGen);
			}
		}
		return null;
	}
	public boolean estPresentGenerateur(String nomGen) {
		return ensembleGenerateur.containsKey(nomGen);
	}
}