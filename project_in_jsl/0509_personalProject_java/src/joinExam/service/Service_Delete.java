package joinExam.service;

import java.util.List;

import joinExam.dao.JoinDAO;
import joinExam.vo.JoinVO;

public class Service_Delete {

	public List<JoinVO> searchByID(String id){
		JoinDAO dao = new JoinDAO();
		return dao.selectByNameOrID(id, true);
	}
	
	public int deleteJoin(String id) {
		JoinDAO dao = new JoinDAO();
		return dao.deleteJoin(id);
	}
}
