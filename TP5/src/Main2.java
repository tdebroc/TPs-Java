import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Saisissez la valeur de n : n = ");
		int n = scan.nextInt();
		scan.close();
		System.out.println("Méthode par itération:");
		System.out.println("Voici la liste des nombres premiers compris entre 1 et " + n +" : ");
		premiers(n);
		System.out.println("");
		System.out.println("Méthode par récursivité:");
		System.out.println("Voici la liste des nombres premiers compris entre 1 et " + n +" : ");
		premiersR(n);
	}
	
	public static void premiers(int n) {
		int[] crible = new int[n+1];
		eratosthene(crible);
		for (int i=0; i<crible.length; i++) {
			if (crible[i] != 0) {
				System.out.print(crible[i] + " , ");
			}
		}
	}
	
	public static void eratosthene(int[] tableau) {
		for (int i = 0; i < tableau.length; i++) {
			tableau[i] = i;
			if(tableau[i] == 1){
				tableau[i] = 0;
			} else{
				for (int j=2; j < i; j++) {
					if((tableau[i] %j) == 0) {
						tableau[i] = 0;
					}
				}
			}
		}
	}
	
	public static void premiersR(int n) {
		int[] crible = new int[n+1];
		eratostheneR(crible,n,0);
		for (int i=0; i<crible.length; i++) {
			if (crible[i] != 0) {
				System.out.print(crible[i] + " / ");
			}
		}
	}
	
	public static void eratostheneR(int[] tableau, int n , int i) {
		tableau[i] = i;
		if(tableau[i] == 1){
			tableau[i] = 0;
		} else{
			for (int j=2; j < i; j++) {
				if((tableau[i] %j) == 0) {
					tableau[i] = 0;
				}
			}
		}
		if (i<n) {
			eratostheneR(tableau,n,i+1);
		}
	}
	
}
