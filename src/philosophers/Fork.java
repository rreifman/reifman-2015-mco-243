package philosophers;

public class Fork {

	private String name;
	private boolean available;
	
	public Fork(String name){
		available = true;
		this.name = name;
	}
	
	public boolean isAvailable(){
		return available;
	}
	
	public void pickUp(){
		available = false;
	}
	
	public void putDown(){
		available = true;
	}
}
