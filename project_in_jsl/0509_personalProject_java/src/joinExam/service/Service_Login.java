package joinExam.service;

import joinExam.dao.JoinDAO;

public class Service_Login {

	public int tryLogin(String id, String passwd) {
		JoinDAO dao = new JoinDAO();
		
		return dao.tryLogin(id, passwd);
		
	}
}
