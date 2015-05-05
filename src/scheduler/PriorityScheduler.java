package scheduler;

import java.util.List;

public class PriorityScheduler extends SchedulerAlgorithm{

	@Override
	public FakeProcess getNextProcess(List<FakeProcess> list) {
		return getHighestPriority(list);
	}

	private FakeProcess getHighestPriority(List<FakeProcess> list) {
		FakeProcess highest = list.get(0);
		for(FakeProcess x: list){
			if(x.getPriority() > highest.getPriority()){
				highest = x;
			}
		}
		
		return highest;
	}
	
	

}
