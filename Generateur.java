import java.util.HashMap;
import java.util.Map;
public class Generateur{
	private String nom;
	private int capaciteMax;
	
	public Generateur(String nom,int capaciteMax) {
		this.nom = nom;
		this.capaciteMax = capaciteMax;
	}
	
	public String getNom() {
		return nom;
	}
	public int getCapaciteMax() {
		return capaciteMax;
	}
	/*public double tauxUtilisation(HashMap<Maison,Generateur> r) {
		double tauxUtilisation = 0.0;
		for(Maison M : r.keySet()) {
			if(r.get(M).getNom().equals(nom)) {
				tauxUtilisation+=M.demandeElectrique();
			}
		}
		tauxUtilisation/=capaciteMax;
		return tauxUtilisation;
	}*/

	public void setCapacite(int capacite) {
		capaciteMax = capacite;
	}
}