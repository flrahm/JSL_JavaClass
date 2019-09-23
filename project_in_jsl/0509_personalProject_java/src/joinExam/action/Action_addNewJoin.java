package joinExam.action;

import java.util.Scanner;

import joinExam.service.Service_AddNewJoin;
import joinExam.ui.JoinView;
import joinExam.vo.JoinVO;

public class Action_addNewJoin implements Action {

	@Override
	public void execute(Scanner scan) throws Exception {
		String work = "등록";
		JoinView view = new JoinView();
		Service_AddNewJoin svc = new Service_AddNewJoin();

		
		JoinVO jvo = new JoinVO();
		// 1. 아이디 입력받기 
		String id;
		while (true) {
			id = view.getID(scan);	// 2. 아이디 중복 검사
			boolean isOverlap = svc.checkingIdOverlap(id);
			view.IdOverlap(isOverlap);
			if (!isOverlap) {
				jvo.setUserid(id);
				break;
			}
		}
		///////
		
		view.enterVO4Add(scan, jvo);	// 3. 아이디를 제외한 나머지 입력받기
		if(view.insureWork(work, scan)) {	// 4. 실행 확인
			int insertOk = svc.addNewJoin(jvo);	// 5. db에 등록
			view.printOk(work, insertOk);	// 6. 등록 결과 확인
		}
		
		
	}

}
