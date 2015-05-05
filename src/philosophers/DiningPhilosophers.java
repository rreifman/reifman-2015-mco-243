package philosophers;

import java.util.Map;

public class DiningPhilosophers {

	public void main(String[] args) {
		// TODO Auto-generated method stub
		Fork forks[] = new Fork[5];
		for(int i =0; i<5; i++){
			forks[i] = new Fork(String.valueOf(i));
		}
		
		Philosopher philosophers[] = new Philosopher[5];
		
		philosophers[0] = new Philosopher("A", forks[0], forks[1]);
		philosophers[1] = new Philosopher("B", forks[1], forks[2]);
		philosophers[2] = new Philosopher("C", forks[2], forks[3]);
		philosophers[3] = new Philosopher("D", forks[4], forks[5]);
		philosophers[4] = new Philosopher("E", forks[5], forks[0]);

		
		for(Philosopher p: philosophers){
			p.start();
		}

	}

}
