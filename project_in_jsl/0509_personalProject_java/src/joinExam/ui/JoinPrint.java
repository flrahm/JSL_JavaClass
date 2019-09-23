package joinExam.ui;

import java.util.List;

import joinExam.dao.TableInfo_Join;
import joinExam.vo.JoinVO;

public class JoinPrint {

	public static void printListByVO(List<JoinVO> jList) {

		JoinVO jvo = null;
		for (int i = 0; i < jList.size(); i++) {
			jvo = jList.get(i);
			System.out.println("--------------------------------------------------");
			System.out.println("ID\t: " + jvo.getUserid());
			System.out.println("이름\t: " + jvo.getName());
			if (jvo.getEmail() != null)
				System.out.println("이메일\t: " + jvo.getEmail());
			else
				System.out.println("이메일\t: ");
			if (jvo.getAge() != 0)
				System.out.println("나이\t: " + jvo.getAge());
			else
				System.out.println("나이\t: ");
			System.out.println("등록일\t: " + jvo.getRegdate());
			System.out.println("--------------------------------------------------");
		}
	}

	public static void printMain() {

		System.out.println("--------------------------------------------------");
		System.out.println("=== 회원 관리 프로그램 Ver 1.03 ===");
		System.out.println(" [1] 회원 목록 보기");
		System.out.println(" [2] 회원 정보 등록");
		System.out.println(" [3] 로그인");
		System.out.println(" [4] 회원 정보 검색");
		System.out.println(" [5] 회원 정보 수정");
		System.out.println(" [6] 회원 정보 삭제");
		System.out.println(" [7] 프로그램 종료");
		System.out.println();

	}

	public static void printJoinList(List<JoinVO> jList) {
		TableInfo_Join ti = new TableInfo_Join();

		tappingTitle("아이디", ti.length_userid);
		tappingTitle("이름", ti.length_name);
		tappingTitle("이메일", ti.length_email);
		tappingTitle("등록일자 ", ti.length_regdate);
		System.out.println();
		JoinVO jvo = null;
		for (int i = 0; i < jList.size(); i++) {
			jvo = jList.get(i);
			tappingVO(jvo.getUserid(), ti.length_userid);
			tappingVO(jvo.getName(), ti.length_name);

			if (jvo.getEmail() != null)
				tappingVO(jvo.getEmail(), ti.length_email);
			else
				tappingVO("", ti.length_email);

			tappingVO(jvo.getRegdate(), ti.length_regdate);
			System.out.println();
		}

	}

	// 내용 탭찍어서 출력하기
	private static void tappingVO(String str, int maxSize) {

		System.out.print(str);
		int iter;
		if (str != null)
			iter = maxSize / 8 - str.length() / 8 + 1;
		else
			iter = maxSize / 8 + 1;
		for (int i = 0; i < iter; i++)
			System.out.print("\t");

	}

	// 타이틀 탭찍어서 출력하기
	private static void tappingTitle(String str, int maxSize) {

		System.out.print(str);
		int iter = maxSize / 8 + 1;
		for (int i = 0; i < iter; i++)
			System.out.print("\t");

	}
}
