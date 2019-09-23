package joinExam.main;

import java.util.Scanner;

import joinExam.action.Action;
import joinExam.action.Action_AllJoinList;
import joinExam.action.Action_Delete;
import joinExam.action.Action_Login;
import joinExam.action.Action_Update;
import joinExam.action.Action_addNewJoin;
import joinExam.action.Action_search;
import joinExam.controller.JoinController;
import joinExam.ui.JoinPrint;

public class JoinMain {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		JoinController controller = new JoinController();
		boolean flag = true;
		Action action;

		while (flag) {
			action = null;
			System.out.println("");

			JoinPrint.printMain();
			System.out.print("[메뉴 선택 : ");
			String menu = scan.nextLine();
			System.out.println("--------------------------------------------------");

			switch (menu) {
			case "7":
				System.out.println("프로그램을 종료합니다");
				flag = false;
				break;
			case "1":
				action = new Action_AllJoinList();
				break;
			case "2":
				action = new Action_addNewJoin();
				break;
			case "3":
				action = new Action_Login();
				break;
			case "4":
				action = new Action_search();
				break;
			case "5":
				action = new Action_Update();
				break;
			case "6":
				action = new Action_Delete();
				break;
			default:
				System.err.println("잘못된 입력입니다. 1~7 사이의 값을 입력하세요");

			}

			if (action != null)
				controller.processRequest(action, scan);

		}
		scan.close();
	}

}
