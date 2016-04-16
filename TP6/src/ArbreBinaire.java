import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class ArbreBinaire {

	private String value;
	private ArbreBinaire filsG;
	private ArbreBinaire filsD;
	private int key;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public ArbreBinaire getFilsG() {
		return filsG;
	}

	public void setFilsG(ArbreBinaire filsG) {
		this.filsG = filsG;
	}

	public ArbreBinaire getFilsD() {
		return filsD;
	}

	public void setFilsD(ArbreBinaire filsD) {
		this.filsD = filsD;
	}
	
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
	
	ArbreBinaire(String value) {
		this.value = value;
	}
	
	ArbreBinaire(String value, ArbreBinaire filsG, ArbreBinaire filsD, int key) {
		this.value = value;
		this.filsG = filsG;
		this.filsD = filsD;
		this.key = key;
	}
	
	public void displayLeftFirst() {
		if (filsG != null) {
			filsG.displayLeftFirst();
		}
		System.out.println(value);
		if (filsD != null) {
			filsD.displayLeftFirst();
		}
	}
	
	public void displayRightFirst() {
		if (filsD != null) {
			filsD.displayRightFirst();
		}
		System.out.println(value);
		if (filsG != null) {
			filsG.displayRightFirst();
		}
	}
	
	public void displayMiddleFirst() {
		System.out.println(value);
		if (filsG != null) {
			filsG.displayMiddleFirst();
		}
		if (filsD != null) {
			filsD.displayMiddleFirst();
		}
	}
	
	public void displayPostFix() {
		if (filsG != null) {
			filsG.displayPostFix();
		}
		if (filsD != null) {
			filsD.displayPostFix();
		}
		System.out.println(value);
	}
	
	public int depth(int sizeMax) {
		int sizeMaxRight = 0; // 0 si on considère que la distance de la racine à la racine est 0.
		int sizeMaxLeft = 0; // Idem.
		if (filsG != null) {
			sizeMaxLeft = filsG.depth(sizeMax) + 1;
		}
		if (filsD != null) {
			sizeMaxRight = filsD.depth(sizeMax) + 1;
		}
		return Math.max(sizeMaxLeft, sizeMaxRight);
	}
	
	
	// Affichage en Profondeur: Méthode 1 (Avec utilisation Arbre à clé + Marqueur avec HashMap)
	
	Map<ArbreBinaire, Integer> map = new HashMap<>();
	public boolean marquer(ArbreBinaire a, int key) {
		if (map.get(key) == null) {
			map.put(a, a.key) ;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Des que vous appelez depthFirstSearch(), il faut reinitiliser la hashmap.
	 * 
	 * depthFirstSearch(ArbreBinaire a) doit etre changé en depthFirstSearch(HashMap map)
	 * et appelé a.filsG.(map)
	 * 
	 * Il y a donc 2 methodes depthFirstSearch, une sans paramètre et l'autre avec hashmap en paramètres.
	 * 
	 */

	public void depthFirstSearch(ArbreBinaire a) {
		System.out.println(a.value);
		marquer(a, a.key);
		if (a.filsG != null) {
		    if (marquer(a.filsG, a.filsG.key) != false) {
			depthFirstSearch(a.filsG);
			}
		}
		if (a.filsD != null) {
			if (marquer(a.filsD, a.filsD.key) != false) {
				depthFirstSearch(a.filsD);
			}
		}
	}
	
	// Affichage en Profondeur: Méthode 2 (Avec utilisation d'une pile)
	public static void DFS(ArbreBinaire a) {
		Stack<ArbreBinaire> pile = new Stack<ArbreBinaire>(); 
		pile.push(a);
		while (!pile.isEmpty()) {
			ArbreBinaire b = pile.pop();
			System.out.println(b.getValue());
			if (b.filsD != null) {
				pile.push(b.filsD);
			}
			if (b.filsG != null) {
				pile.push(b.filsG);
			}
		}
		return;
	}
	
	// Affichage en Largeur :
	public static void BFS(ArbreBinaire a) {
		LinkedList<ArbreBinaire> queue = new LinkedList<ArbreBinaire>();
		queue.add(a);
		while(queue.peek() != null) {
			ArbreBinaire b = queue.remove();
		    System.out.println(b.getValue());
		    if (b.getFilsG() != null) {
		    	queue.add(b.getFilsG());
		    }
		    if (b.getFilsD() != null) {
		    	queue.add(b.getFilsD());
		    }
		}
		return;
	}
	
}
