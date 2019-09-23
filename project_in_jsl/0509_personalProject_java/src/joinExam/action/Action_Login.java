package joinExam.action;

import java.util.Scanner;

import joinExam.service.Service_Login;
import joinExam.ui.JoinView;

public class Action_Login implements Action {

	@Override
	public void execute(Scanner scan) throws Exception {
		JoinView view = new JoinView();
		Service_Login svc = new Service_Login();
		int tryLimit = 3;	// 최대 로그인 시도 횟수
		
		
		int tryCnt = 0;	// 현재 로그인 시도횟수
		while(tryCnt < tryLimit) {
		
			String[] idPw = view.getIdPw(scan);
			int loginResult = svc.tryLogin(idPw[0], idPw[1]);
			view.printLoginResult(loginResult , tryCnt , tryLimit);
			if(loginResult == 2)
				break;
			tryCnt++;
		}
		
	}

}
