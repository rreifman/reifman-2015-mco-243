package philosophers;

import java.util.Random;

public class Philosopher extends Thread {

	private final static Random R = new Random();
	
	private Fork right;
	private Fork left;
	private String name;

	public Philosopher(String name, Fork right, Fork left) {
		this.right = right;
		this.left = left;
		this.name = name;
	}

	public void eat() {
		
		synchronized(right){
			synchronized(left){
				
				System.out.println(name + " eating");
				try {
					Thread.sleep(R.nextInt(1500) + 500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	
	}
	
	

	public void think() {
		System.out.println(name + " thinking");
		try {
			Thread.sleep(R.nextInt(1500) + 500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {

		while (true) {
			eat();
			think();
		}
	}

	public String getPName() {
		return name;
	}

}
