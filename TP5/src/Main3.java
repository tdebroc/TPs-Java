
public class Main3 {

	public static void main(String[] args) {
		
		FileEntier n7 = new FileEntier(7, null);
		FileEntier n3 = new FileEntier(3, n7);
		FileEntier queue = new FileEntier(1, n3);
		
		queue.display();	
		queue.add(8);
		queue.add(10);
		System.out.println("After adding 8 and 10");
		queue.display();
		System.out.println("Take : " + queue.take());
		queue.display();
		System.out.println("Take : " + queue.take());
		queue.display();
	}
	
}
