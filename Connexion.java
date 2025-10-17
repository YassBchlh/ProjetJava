import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
public class Connexion{
	private HashMap<Maison,Generateur> connexions;
	private static final int LAMBDA = 10;
	public Connexion() {
		connexions = new HashMap<Maison,Generateur>();
	}
	
	public HashMap<Maison,Generateur> getConnexion(){
		return connexions;
	}
	public void ajouterConnexion(EnsembleMaison eM,EnsembleGenerateur eG) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez entrer le générateur et la maison que vous voulez connecter : ");
		String nom1 = sc.next();
		String nom2 = sc.next();
		Maison m = null;
		Generateur g = null;
		if((nom1.charAt(0)=='G')&&(nom2.charAt(0)=='M')) {
			m = eM.rechercheMaison(nom2);
			g = eG.rechercheGenerateur(nom1);
		}
		if((nom1.charAt(0)=='M')&&(nom2.charAt(0)=='G')) {
			m = eM.rechercheMaison(nom1);
			g = eG.rechercheGenerateur(nom2);
		}
		if((m==null)||(g==null)) {
			System.out.println("La maison ou le générateur n'ont pas été ajoutés");
			return;
		}
		connexions.put(m, g);
		System.out.println("La connexion entre "+nom1+" et "+nom2+" a bien été effectuée ");
	}
	public double tauxUtilisation(Generateur g) {
		double tauxUtilisation = 0.0;
		for(Maison m : connexions.keySet()) {
			Generateur gen = connexions.get(m);
			String nomG = g.getNom();
			if(gen.getNom().equals(nomG)) {
				tauxUtilisation+=m.demandeElectrique();
			}
		}
		tauxUtilisation/=g.getCapaciteMax();
		return tauxUtilisation;
	}
	public double moyUtilisation() {
		double moyUtilisation=0.0;
		Set<Generateur> uniques = new HashSet<Generateur>(connexions.values());
		for(Generateur g : uniques) {
			moyUtilisation+=tauxUtilisation(g);
		}
		moyUtilisation/=uniques.size();
		return moyUtilisation;
		
	}
	
	public double disp() {
		double disp = 0.0;
		Set<Generateur> uniques = new HashSet<Generateur>(connexions.values());
		double moyenne = moyUtilisation();
		for(Generateur g : uniques) {
			disp += Math.abs(tauxUtilisation(g)-moyenne);
		}
		return disp;
	}
	public double surcharge1Generateur(Generateur g) {
		double surcharge1Generateur = 0.0;
		int maisonGenerateur = 0;
		for(Maison m : connexions.keySet()){
			if(connexions.get(m).getNom().equals(g.getNom())) {
				maisonGenerateur+=m.demandeElectrique();
			}
		}
		surcharge1Generateur=(maisonGenerateur-g.getCapaciteMax())/g.getCapaciteMax();
		return surcharge1Generateur;
	}
	public double max(double nombre) {
		if(nombre>0) {
			return nombre;
		}
		return 0.0;
	}
	public double surcharge() {
		double surcharge = 0.0;
		Set<Generateur> uniques = new HashSet<Generateur>(connexions.values());
		for(Generateur g : uniques) {
			surcharge+=max(surcharge1Generateur(g));
		}
		return surcharge;
	}
	public double cout() {
		double cout;
		cout = disp()+LAMBDA*surcharge();
		return cout;
	}
	public void affiche() {
		System.out.println("Avec une somme des écarts de "+disp()+" et une surcharge de "+surcharge()+" ,le coût du réseau actuel est "+cout());
	}
	
}