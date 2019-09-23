package joinExam.action;

import java.util.List;
import java.util.Scanner;

import joinExam.service.Service_Update;
import joinExam.ui.JoinView;
import joinExam.vo.JoinVO;

public class Action_Update implements Action {

	@Override
	public void execute(Scanner scan) throws Exception {
		String work = "수정";
		JoinView view = new JoinView();
		Service_Update svc = new Service_Update();

		JoinVO jvo = new JoinVO();


		while (true) {////
			String userid = view.getId4Search(scan);
			List<JoinVO> jList = svc.searchByID(userid);
			
			if (jList.size() == 0) {
				view.printSearchResult(jList, "1");
				if (!view.isIterWork(scan, "검색"))
					break;
			} else {//
				jvo = view.getVO4Update(scan, jList.get(0));

				if (view.insureWork(work, scan)) {
					int updateOk = svc.updateJoin(jvo);
					view.printOk(work, updateOk);
				}
				
				break;
			}//

		}////
		
		
		
		
	}

}
