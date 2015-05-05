package scheduler;

import java.util.List;

public class FIFOScheduler extends SchedulerAlgorithm{

	@Override
	public FakeProcess getNextProcess(List<FakeProcess> list) {
		return list.get(0);	
	}
	
	

}
