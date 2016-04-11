import java.util.LinkedList;
import java.util.Stack;

public class ArbreBinaireGenerique<T> implements Comparable<T> {
	
	private T value;
	private ArbreBinaireGenerique<T> filsG;
	private ArbreBinaireGenerique<T> filsD;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
	public ArbreBinaireGenerique<T> getFilsG() {
		return filsG;
	}

	public void setFilsG(ArbreBinaireGenerique<T> filsG) {
		this.filsG = filsG;
	}

	public ArbreBinaireGenerique<T> getFilsD() {
		return filsD;
	}

	public void setFilsD(ArbreBinaireGenerique<T> filsD) {
		this.filsD = filsD;
	}
	
	ArbreBinaireGenerique(T value) {
		this.value = value;
	}
	
	ArbreBinaireGenerique(T value, ArbreBinaireGenerique<T> filsG, ArbreBinaireGenerique<T> filsD) {
		this.value = value;
		this.filsG = filsG;
		this.filsD = filsD;
	}

	@Override
	public int compareTo(T o) {
		
		if (o instanceof String) {
			
			String S1 = (String)o;
		    String S2 = (String)this.value;
		    
		    if (S2.compareTo(S1) == 0) {
		    	return 0;
		    } else if (S1.compareTo(S2) > 0) {
		    	return 1;
		    } else {
		    	return -1;
		    }
		} else if (o instanceof Integer) {
			
			String I1 = (String)o;
		    String I2 = (String)this.value;
		    
		    if (I2.compareTo(I1) == 0) {
		    	return 0;
		    } else if (I1.compareTo(I2) > 0) {
		    	return 1;
		    } else {
		    	return -1;
		    }
		} else {
			return -1;
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
	
	// Affichage en Profondeur: Méthode 2 (Avec utilisation d'une pile)
		public static void DFS(ArbreBinaireGenerique a) {
			Stack<ArbreBinaireGenerique> pile = new Stack<ArbreBinaireGenerique>(); 
			pile.push(a);
			while (!pile.isEmpty()) {
				ArbreBinaireGenerique b = pile.pop();
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
		public static void BFS(ArbreBinaireGenerique a) {
			LinkedList<ArbreBinaireGenerique> queue = new LinkedList<ArbreBinaireGenerique>();
			queue.add(a);
			while(queue.peek() != null) {
				ArbreBinaireGenerique b = queue.remove();
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
