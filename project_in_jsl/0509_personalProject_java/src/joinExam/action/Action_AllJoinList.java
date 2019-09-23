package joinExam.action;

import java.util.List;
import java.util.Scanner;

import joinExam.service.Service_AllJoinList;
import joinExam.ui.JoinView;
import joinExam.vo.JoinVO;

public class Action_AllJoinList implements Action {

	@Override
	public void execute(Scanner scan) throws Exception {
		Service_AllJoinList svc = new Service_AllJoinList();
		JoinView view = new JoinView();
		
		List<JoinVO> jList = svc.selectAllJoin();
		view.printAllJoin(jList);
		

	}

}
