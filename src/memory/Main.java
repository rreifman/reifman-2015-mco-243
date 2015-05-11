package memory;

public class Main {

	public static void main(String[] args) {

		MainMemory memory = new MainMemory(128);
		try {
			memory.allocate(1, 8);
			memory.allocate(2, 16);
			memory.free(1);
			memory.allocate(3, 16);
			System.out.println(memory.print());
		} catch (OutOfMemoryException e) {
			e.printStackTrace();
		}

	}

}
