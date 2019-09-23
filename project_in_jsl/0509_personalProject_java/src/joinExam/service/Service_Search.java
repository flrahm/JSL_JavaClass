package joinExam.service;

import java.util.List;

import joinExam.dao.JoinDAO;
import joinExam.vo.JoinVO;

public class Service_Search {

	public List<JoinVO> searchByID(String id){
		JoinDAO dao = new JoinDAO();
		return dao.selectByNameOrID(id, true);
	}
	
	public List<JoinVO> searchByname(String name){
		JoinDAO dao = new JoinDAO();
		return dao.selectByNameOrID(name, false);
	}
	
}
