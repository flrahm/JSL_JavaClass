package joinExam.action;

import java.util.List;
import java.util.Scanner;

import joinExam.service.Service_Delete;
import joinExam.ui.JoinView;
import joinExam.vo.JoinVO;

public class Action_Delete implements Action {

	@Override
	public void execute(Scanner scan) throws Exception {
		String work = "삭제";
		Service_Delete svc = new Service_Delete();
		JoinView view = new JoinView();

		while (true) {////
			String userid = view.getId4Delete(scan);
			List<JoinVO> jList = svc.searchByID(userid);
			
			if (jList.size() == 0) {
				view.printSearchResult(jList, "1");
				if (!view.isIterWork(scan, "검색"))
					break;
			} else {//
				view.print4Delete(jList.get(0));
				if (view.insureWork(work, scan)) {
					int deleteOk = svc.deleteJoin(userid);
					view.printOk(work, deleteOk);
				}
				
				break;
			}//

		}////
		
		
	}

}
