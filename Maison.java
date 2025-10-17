public class Maison{
	private String nom;
	private ConsoMaison cM;
	
	public Maison(String nom, ConsoMaison cM) {
		this.nom = nom;
		this.cM = cM;
	}
	
	public int demandeElectrique() {
		int demandeElec = 0;
		switch(cM) {
		case BASSE : demandeElec = 10;
			  		break;
		case NORMAL : demandeElec = 20;
					break;
		case FORTE : demandeElec = 40;
					break;
		}
		return demandeElec;
	}
	public String getNom() {
		return nom;
	}
	public void setCM(ConsoMaison conso) {
		cM=conso;
	}
}