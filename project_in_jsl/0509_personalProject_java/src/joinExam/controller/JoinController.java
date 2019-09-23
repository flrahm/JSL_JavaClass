package joinExam.controller;

import java.util.Scanner;

import joinExam.action.Action;

public class JoinController {

	public void processRequest(Action action, Scanner scan) {
		try {
		action.execute(scan);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
