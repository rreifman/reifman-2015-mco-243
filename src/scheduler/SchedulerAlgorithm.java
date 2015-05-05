package scheduler;

import java.util.List;

public abstract class SchedulerAlgorithm {
	
	public abstract FakeProcess getNextProcess(List<FakeProcess> list); 

}
