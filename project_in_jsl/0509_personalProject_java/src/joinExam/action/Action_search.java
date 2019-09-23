package joinExam.action;

import java.util.List;
import java.util.Scanner;

import joinExam.service.Service_Search;
import joinExam.ui.JoinView;
import joinExam.vo.JoinVO;

public class Action_search implements Action {

	@Override
	public void execute(Scanner scan) throws Exception {
		Service_Search svc = new Service_Search();
		JoinView view = new JoinView();

		List<JoinVO> jList = null;

		while (true) {
			String[] IdNameAndFlag = view.getIdOrName(scan);
			if (IdNameAndFlag[1].equals("1")) {
				jList = svc.searchByID(IdNameAndFlag[0]);
			} else {
				jList = svc.searchByname(IdNameAndFlag[0]);
			}

			view.printSearchResult(jList, IdNameAndFlag[1]);
			
			if(!view.isIterWork(scan, "°Ë»ö"))
				break;
		}
	}

}
