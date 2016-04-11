
public class ArbreBinaire {

	private String value;
	private ArbreBinaire filsG;
	private ArbreBinaire filsD;

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
	
	ArbreBinaire(String value) {
		this.value = value;
	}
	
	ArbreBinaire(String value, ArbreBinaire filsG, ArbreBinaire filsD) {
		this.value = value;
		this.filsG = filsG;
		this.filsD = filsD;
	}
	
	public static void display(ArbreBinaire a) {
		if (a.filsG != null) {
			display(a.filsG);
		}
		System.out.println(a.value);
		if (a.filsD != null) {
			display(a.filsD);
		}
	}
	
	public static void inserer(ArbreBinaire a, String str) {
		if (str.compareTo(a.value) < 0) {
			if (a.filsG != null) {
				inserer(a.filsG, str);
			} else {
				a.filsG = new ArbreBinaire(str, null, null);
			}
		} else if (str.compareTo(a.value) > 0) {
			if (a.filsD != null) {
				inserer(a.filsD, str);
			} else {
				a.filsD = new ArbreBinaire(str, null, null);
			}
		} else {
			System.out.println(" '' " + str + " '' Already Exist in the Tree.");
		}
		
	}
	
	public static boolean contient(ArbreBinaire a, String str) {
		if (str.compareTo(a.value) < 0) {
			if (a.filsG != null) {
				return contient(a.filsG, str);
			}
		} else if (str.compareTo(a.value) > 0) {
			if (a.filsD != null) {
				return contient(a.filsD, str);
			}
		} else {
			return true;
		}
		return false;
	}
	 
	public static int compteRecherche(ArbreBinaire a, String str) {
		int compteur = 1;
		if (str.compareTo(a.value) < 0) {
			if (a.filsG != null) {
				compteur = compteRecherche(a.filsG, str) + 1;
				return compteur;
			}
		} else if (str.compareTo(a.value) > 0) {
			if (a.filsD != null) {
				compteur = compteRecherche(a.filsD, str) + 1;
				return compteur;
			}
		} else {
			return compteur;
		}
		return 0;
	}
	
	
}
