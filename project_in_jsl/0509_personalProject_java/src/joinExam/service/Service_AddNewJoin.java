package joinExam.service;


import joinExam.dao.JoinDAO;
import joinExam.vo.JoinVO;

public class Service_AddNewJoin {

	// ȸ������ ���
	public int addNewJoin(JoinVO jvo) {
		JoinDAO dao = new JoinDAO();
		return dao.insertJoin(jvo);
	}
	
	// id�� �ߺ��Ǵ��� Ȯ��
	public boolean checkingIdOverlap(String id) {
		JoinDAO dao = new JoinDAO();
		return dao.selectAllID(id);
	}
}
