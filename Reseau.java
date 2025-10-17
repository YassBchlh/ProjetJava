import java.util.Scanner;
public class Reseau{
	public static void Menu1() {
		System.out.println("Bienvenue dans le menu 1. Voici les options qui s'offrent à vous: \n");
		System.out.println("1 Ajouter un générateur \n");
		System.out.println("2 Ajouter une maison \n");
		System.out.println("3 Ajouteur une connexion entre une maison et un générateur \n");
		System.out.println("4 Fin\n");
	}
	public static void Menu2() {
		System.out.println("Bienvenue dans le menu 2. Voici les options qui s'offrent à vous : \n");
		System.out.println("1 Calculer le cout du réseau actuel \n");
		System.out.println("2 Modifier une connexion \n");
		System.out.println("3 Afficher le réseau \n");
		System.out.println("4 Fin \n");
	}
	public static void main(String[] args) {
		EnsembleGenerateur eG = new EnsembleGenerateur();
		EnsembleMaison eM = new EnsembleMaison();
		Connexion connect = new Connexion();
		int choix;
		Scanner sc = new Scanner(System.in);
		do {
			Menu1();
			System.out.println("Votre choix du Menu 1 : ");
			choix = sc.nextInt();
			switch(choix) {
			case 1 :eG.ajouterGenerateur();
					break;
			case 2 : eM.ajouterMaison();
					break;
			case 3 : connect.ajouterConnexion(eM, eG);
					break;
			case 4 : System.out.println("Fin ");
					break;
			}
		}while(choix!=4);
		do {
			System.out.println("Votre choix du Menu 2 : ");
			choix = sc.nextInt();
			switch(choix) {
			case 1 :connect.affiche();
					break;
			case 2 : eM.ajouterMaison();
					break;
			case 3 : connect.ajouterConnexion(eM, eG);
					break;
			case 4 : System.out.println("Fin ");
					break;
			}
		}while(choix!=4);
	}
}