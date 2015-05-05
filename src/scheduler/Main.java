package scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
	
	private Scheduler fifo;
	private Scheduler shortest;
	private Scheduler priority;
	private List<FakeProcess> list;
	private Random random;
	
	public Main(){
		random = new Random();
		list = makeList();
		fifo = new Scheduler(new FIFOScheduler(), list);
		shortest = new Scheduler(new ShortestProcessScheduler(), list);
		priority = new Scheduler(new PriorityScheduler(), list);
		
	}

	private List<FakeProcess> makeList() {
		List<FakeProcess> processes = new ArrayList<FakeProcess>();
		for(int i = 0; i<100; i++){
			int pri = random.nextInt((10)+1) + 1;
			int time = random.nextInt(100);
			processes.add(new FakeProcess(pri, time));
		}
		return processes;
	}
	


	public Scheduler getFifo() {
		return fifo;
	}

	public Scheduler getShortest() {
		return shortest;
	}

	public Scheduler getPriority() {
		return priority;
	}

	public static void main(String[] args) {
		
		Main main = new Main();
		
		System.out.println("First In First Out Scheduler");
		long start = System.currentTimeMillis();
		main.getFifo().run();
		long end = System.currentTimeMillis();
		System.out.println("Exection Time: " + (end - start));
		
		System.out.println("\nPriority Scheduler");
		start = System.currentTimeMillis();
		main.getPriority().run();;
		end = System.currentTimeMillis();
		System.out.println("Exection Time: " + (end - start));
		
		System.out.println("\nShortest Process Scheduler");
		start = System.currentTimeMillis();
		main.getShortest().run();
		end = System.currentTimeMillis();
		System.out.println("Exection Time: " + (end - start));

	}

}
