
public class FileEntier implements FileEntierInterface {
	
	public Integer value;
	public FileEntier next;
	
	public FileEntier(int value, FileEntier next){
		this.value = value;
		this.next = next;
	}
	
	public void add(int n) {
		if (next != null) {
			next.add(n);
		} else {
			next = new FileEntier(n, null);
		}
	}

	@Override
	public int take() {
		int valueToReturn = value;
		if (next != null) {
			value = next.value;
			next = next.next;
		}
		return valueToReturn;
	}
	
	public int take(FileEntier queue) {
		if (queue == null) {
			//throw new Exception("Queue is null");
			System.out.println("list is null");
			return -1;
		}
		int valueToReturn = value;
		if (next != null) {
			value = next.value;
			next = next.next;
		} else {
			queue = null;
		}
		return valueToReturn;
	}
	
	public void display() {
		System.out.println(value);
		if (next != null) {
			next.display();
		}
	}
	
}
