package customWorkItem;

import java.util.HashMap;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemManager;

public class ElectricPermitWorkItem implements org.kie.api.runtime.process.WorkItemHandler {

	public void abortWorkItem(WorkItem arg0, WorkItemManager arg1) {
		// TODO Auto-generated method stub
		
	}

	public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
		
		String prevERejection = workItem.getParameter("prevERejection").toString();
		
		System.out.println("ElectricPermitWorkItem ::"+prevERejection);
		
		HashMap<String, Object> results = new HashMap<String, Object>();
		
		if (prevERejection.equalsIgnoreCase("No")) {
			results.put("elecPermitStatus", "Approved");
		}
		else {
			results.put("elecPermitStatus", "Rejected");
		}
		
		workItemManager.completeWorkItem(workItem.getId(), results);
		
	}

}
