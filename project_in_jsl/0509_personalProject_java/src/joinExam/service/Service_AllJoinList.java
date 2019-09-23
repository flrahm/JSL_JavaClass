package joinExam.service;

import java.util.List;

import joinExam.dao.JoinDAO;
import joinExam.vo.JoinVO;

public class Service_AllJoinList {

	public List<JoinVO> selectAllJoin() {
		JoinDAO dao = new JoinDAO();
		return dao.selectAllJoin();
	}
}
