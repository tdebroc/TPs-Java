import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		ArbreBinaire a = new ArbreBinaire("A", null, null);
		ArbreBinaire b = new ArbreBinaire("B", a, null);
		ArbreBinaire c = new ArbreBinaire("C", b, null);
		ArbreBinaire.display(c);
		System.out.println("========");
		ArbreBinaire.inserer(c,"Z");
		ArbreBinaire.inserer(c,"D");
		ArbreBinaire.inserer(c,"E");
		ArbreBinaire.inserer(c,"Z");
		ArbreBinaire.display(c);
		
		
		System.out.println("Autre test avec des mots : ");
		
		ArbreBinaire mot = new ArbreBinaire("the", null, null);
		ArbreBinaire.inserer(mot,"quick");
		ArbreBinaire.inserer(mot,"brown");
		ArbreBinaire.inserer(mot,"fox");
		ArbreBinaire.inserer(mot,"jumps");
		ArbreBinaire.inserer(mot,"over");
		ArbreBinaire.inserer(mot,"the");
		ArbreBinaire.inserer(mot,"lazy");
		ArbreBinaire.inserer(mot,"dog");
		ArbreBinaire.display(mot);
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Recherche d'un mot dans l'arbre ==> Saisir le mot : ");
		String test = scan.nextLine();
		scan.close();
		ArbreBinaire.contient(mot, test);
		if (ArbreBinaire.contient(mot, test) == true ) {
			System.out.println("L'arbre contient le mot '' " + test + " ''.");
		} else {
			System.out.println("L'arbre ne contient pas le mot '' " + test + " ''.");
		}

		if (ArbreBinaire.compteRecherche(mot, test) != 0 ) {
			System.out.println("Nombre de noeuds explorés pour la recherche : " + ArbreBinaire.compteRecherche(mot, test));
		} else {
			System.out.println("Tous les noeuds ont été exploré (l'arbre ne contient pas le mot '' " + test + " '').");
		}
		/// "dog" = 5 noeuds visités
		/// "lazy" = 7 noeuds visités
		/// "quick" = 2 noeuds visités
		
		
		
		/// Arbre Binaire de recherche Générique:
		
		/// Instance d'Arbre Binaire stockant des phrases:
		
		ArbreBinaireGenerique<String> nodeMot2 = new ArbreBinaireGenerique("je", null, null);
		ArbreBinaireGenerique<String> nodeMot3 = new ArbreBinaireGenerique("m'appelle", null, null);
		ArbreBinaireGenerique<String> nodeMot1 = new ArbreBinaireGenerique("Bonjour", nodeMot2, nodeMot3);
		ArbreBinaireGenerique<String> nodeMot4 = new ArbreBinaireGenerique("Paul", null, null);
		ArbreBinaireGenerique<String> nodeMot5 = new ArbreBinaireGenerique("de THOISY", null, null);
		nodeMot2.setFilsG(nodeMot4);
		nodeMot2.setFilsD(nodeMot5);
				
		System.out.println("Arbre Binaire Générique qui stocke des phrases: ");
		System.out.println("Affichage postfixé: ");
		nodeMot1.displayPostFix();		
		System.out.println("Affichage en Profondeur (DFS 2) Méthode 2: ");
		ArbreBinaireGenerique.DFS(nodeMot1);	
		System.out.println("Affichage en Largeur (BFS) : ");
		ArbreBinaireGenerique.BFS(nodeMot1);
		
		
		/// Instance d'Arbre Binaire stockant des entiers:
		
		ArbreBinaireGenerique<Integer> node2 = new ArbreBinaireGenerique(2, null, null);
		ArbreBinaireGenerique<Integer> node3 = new ArbreBinaireGenerique(3, null, null);
		ArbreBinaireGenerique<Integer> node1 = new ArbreBinaireGenerique(1, node2, node3);
		ArbreBinaireGenerique<Integer> node4 = new ArbreBinaireGenerique(4, null, null);
		ArbreBinaireGenerique<Integer> node5 = new ArbreBinaireGenerique(5, null, null);
		node2.setFilsG(node4);
		node2.setFilsD(node5);
		
		System.out.println("Arbre Binaire Générique qui stocke des entiers: ");
		System.out.println("Affichage postfixé Générique: ");
		node1.displayPostFix();
		System.out.println("Affichage en Profondeur (DFS 2) Méthode 2: ");
		ArbreBinaireGenerique.DFS(node1);
		System.out.println("Affichage en Largeur (BFS) : ");
		ArbreBinaireGenerique.BFS(node1);
		
	}

}
