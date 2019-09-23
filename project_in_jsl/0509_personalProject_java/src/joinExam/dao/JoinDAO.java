package joinExam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import joinExam.db.DBManager;
import joinExam.ui.Enter;
import joinExam.vo.JoinVO;

public class JoinDAO {

	DBManager dbm = DBManager.getInstance();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	TableInfo_Join ti = new TableInfo_Join();

	// ����...6
	public int deleteJoin(String id) {
		int deleteOk = 0;
		String sql = "delete from " + ti.tableName;
		sql += " where " + ti.userid + " = ?";

		try {
			conn = dbm.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			deleteOk = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			closeAll();
		}
		return deleteOk;
	}

	// ������Ʈ....5
	public int updateJoin(JoinVO jvo) {

		int updateOk = 0;
		String sql = "update " + ti.tableName;
		sql += " set " + ti.name + " = ?, ";
		sql += ti.passwd + " = ?, ";
		sql += ti.email + " = ?, ";
		sql += ti.age + " = ? ";
		sql += "where " + ti.userid + " = ?";

		try {
			conn = dbm.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jvo.getName());
			pstmt.setString(2, jvo.getPasswd());
			pstmt.setString(3, jvo.getEmail());
			pstmt.setInt(4, jvo.getAge());
			pstmt.setString(5, jvo.getUserid());

			updateOk = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			closeAll();
		}
		return updateOk;
	}

	// 4. �˻�
	public List<JoinVO> selectByNameOrID(String str, boolean isID) { // true �� ���̵�, false �� �̸�

		String sql = "select * from " + ti.tableName;
		if (isID)
			sql += " where " + ti.userid + " = ? ";
		else
			sql += " where " + ti.name + " = ? ";
		sql += " order by regdate";
		List<JoinVO> jList = new ArrayList<JoinVO>();

		try {
			conn = dbm.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, str);
			rs = pstmt.executeQuery();
			JoinVO jvo = null;
			while (rs.next()) {
				jvo = new JoinVO();
				jvo.setUserid(rs.getString(ti.userid));
				jvo.setName(rs.getString(ti.name));
				jvo.setEmail(rs.getString(ti.email));
				jvo.setAge(rs.getInt(ti.age));
				jvo.setRegdate(Enter.getDateFromDB(rs.getString(ti.regdate)));

				jvo.setPasswd(rs.getString(ti.passwd));

				jList.add(jvo);
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			closeAll();
		}

		return jList;
	}

	// 3. �α���
	public int tryLogin(String id, String pw) {
		String sql = "select " + ti.passwd + " from " + ti.tableName;
		sql += " where userid = ?";
		int loginResult = 0; // 0�̸� ���̵� Ʋ��, 1�̸� ��й�ȣ Ʋ��, 2�� ����

		try {
			conn = dbm.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (!rs.next())
				loginResult = 0;
			else {
				String passwd = rs.getString(ti.passwd);
				if (passwd.equals(pw))
					loginResult = 2;
				else
					loginResult = 1;
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			closeAll();
		}

		return loginResult;
	}

	// 2-1 . �ش� ���̵� �����ϴ��� Ȯ��
	public boolean selectAllID(String id) {

		String sql = "select " + ti.userid + " from " + ti.tableName;
		sql += " where " + ti.userid + " in ?";
		boolean isOverlap = true;

		try {
			conn = dbm.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next())
				isOverlap = true;
			else
				isOverlap = false;

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			closeAll();
		}

		return isOverlap;

	}

	// 2. �ű� ȸ�� ���
	public int insertJoin(JoinVO jvo) {

		int insertOk = 0;
		String sql = "insert into " + ti.tableName;
		sql += " values (?,?,?,?,?,sysdate)";

		try {
			conn = dbm.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jvo.getUserid());
			pstmt.setString(2, jvo.getName());
			pstmt.setString(3, jvo.getPasswd());
			pstmt.setString(4, jvo.getEmail());
			pstmt.setInt(5, jvo.getAge());

			insertOk = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			closeAll();
		}
		return insertOk;
	}

	// 1. ��ü ����Ʈ ���
	public List<JoinVO> selectAllJoin() {

		String sql = "select * from " + ti.tableName;
		sql += " order by " + ti.regdate;
		List<JoinVO> jList = new ArrayList<JoinVO>();

		try {
			conn = dbm.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			JoinVO jvo = null;
			while (rs.next()) {
				jvo = new JoinVO();
				jvo.setUserid(rs.getString(ti.userid));
				jvo.setName(rs.getString(ti.name));
				jvo.setEmail(rs.getString(ti.email));
				jvo.setRegdate(Enter.getDateFromDB(rs.getString(ti.regdate)));

				jList.add(jvo);
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			closeAll();
		}

		return jList;

	}

	// close all
	private void closeAll() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
