package scheduler;

import java.util.List;

public class ShortestProcessScheduler extends SchedulerAlgorithm{

	@Override
	public FakeProcess getNextProcess(List<FakeProcess> list) {
		return getShortestProcess(list);
	}

	private FakeProcess getShortestProcess(List<FakeProcess> list) {
		FakeProcess shortest = list.get(0);
		
		for(FakeProcess x: list){
			if(x.getTimeLeft() < shortest.getTimeLeft()){
				shortest = x;
			}
		}
		
		return shortest;
	}
	
	

}
