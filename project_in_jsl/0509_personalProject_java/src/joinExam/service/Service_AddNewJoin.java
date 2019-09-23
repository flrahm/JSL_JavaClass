package joinExam.service;


import joinExam.dao.JoinDAO;
import joinExam.vo.JoinVO;

public class Service_AddNewJoin {

	// 회원정보 등록
	public int addNewJoin(JoinVO jvo) {
		JoinDAO dao = new JoinDAO();
		return dao.insertJoin(jvo);
	}
	
	// id가 중복되는지 확인
	public boolean checkingIdOverlap(String id) {
		JoinDAO dao = new JoinDAO();
		return dao.selectAllID(id);
	}
}
