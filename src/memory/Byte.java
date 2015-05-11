package memory;

public class Byte {
	
	private boolean free;
	private int num;
	private int processID;
	
	public Byte(int num){
		this.num = num;
		free = true;
	}

	public boolean isFree() {
		return free;
	}

	public void use() {
		this.free = false;
	}
	
	public void setFree(){
		free = true;
	}
	
	public void setProcessID(int id){
		this.processID = id;
	}
	
	public int getProcessID(){
		return processID;
	}

}
