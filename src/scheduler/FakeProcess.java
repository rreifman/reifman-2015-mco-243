package scheduler;

public class FakeProcess {
	
	private boolean isRunning;
	private int priority;
	private int timeLeft;
	
	
	public FakeProcess(int priority, int timeLeft){
		this.priority = priority;
		this.timeLeft = timeLeft;
	
	}
	
	public void run(int quantum){
		isRunning = true;
		while(timeLeft>0 && quantum >0){
			timeLeft--;
			quantum--;
		
		}
		if(timeLeft == 0){
			isRunning = false;
		}
	}

	public boolean isRunning() {
		return isRunning;
	}

	public int getPriority() {
		return priority;
	}

	public int getTimeLeft() {
		return timeLeft;
	}

}
