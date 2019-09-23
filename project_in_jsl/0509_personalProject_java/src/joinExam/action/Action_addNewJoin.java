package joinExam.action;

import java.util.Scanner;

import joinExam.service.Service_AddNewJoin;
import joinExam.ui.JoinView;
import joinExam.vo.JoinVO;

public class Action_addNewJoin implements Action {

	@Override
	public void execute(Scanner scan) throws Exception {
		String work = "���";
		JoinView view = new JoinView();
		Service_AddNewJoin svc = new Service_AddNewJoin();

		
		JoinVO jvo = new JoinVO();
		// 1. ���̵� �Է¹ޱ� 
		String id;
		while (true) {
			id = view.getID(scan);	// 2. ���̵� �ߺ� �˻�
			boolean isOverlap = svc.checkingIdOverlap(id);
			view.IdOverlap(isOverlap);
			if (!isOverlap) {
				jvo.setUserid(id);
				break;
			}
		}
		///////
		
		view.enterVO4Add(scan, jvo);	// 3. ���̵� ������ ������ �Է¹ޱ�
		if(view.insureWork(work, scan)) {	// 4. ���� Ȯ��
			int insertOk = svc.addNewJoin(jvo);	// 5. db�� ���
			view.printOk(work, insertOk);	// 6. ��� ��� Ȯ��
		}
		
		
	}

}
