
public class Main {

	public static void main(String[] args) {
		ArbreBinaire nodeB = new ArbreBinaire("B", null, null, 2);
		ArbreBinaire nodeC = new ArbreBinaire("C", null, null, 3);
		
		ArbreBinaire nodeA = new ArbreBinaire("A", nodeB, nodeC, 1);
		
		ArbreBinaire nodeD = new ArbreBinaire("D", null, null, 4);
		ArbreBinaire nodeE = new ArbreBinaire("E", null, null, 5);
		
		nodeB.setFilsG(nodeD);
		nodeB.setFilsD(nodeE);
		
		System.out.println("Affichage infixé (left first) : ");
		nodeA.displayLeftFirst();
		System.out.println("Affichage infixé (right first) : ");
		nodeA.displayRightFirst();
		System.out.println("Affichage préfixé (middle first) : ");
		nodeA.displayMiddleFirst();
		// On remarque que la méthode d'affichage préfixé correspond à un affichage DFS.
		
		System.out.println("Affichage postfixé : ");
		nodeA.displayPostFix();
		System.out.println("Profondeur (ou hauteur) de l'arbre = " + nodeA.depth(3));
		
		System.out.println("Affichage en Profondeur (DFS) Méthode 1: ");
		ArbreBinaire.DFS(nodeA);
		System.out.println("Affichage en Profondeur (DFS 2) Méthode 2: ");
		nodeA.depthFirstSearch(nodeA);
		
		System.out.println("Affichage en Largeur (BFS) : ");
		ArbreBinaire.BFS(nodeA);
	
	}
}
