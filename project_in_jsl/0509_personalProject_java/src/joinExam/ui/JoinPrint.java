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
			System.out.println("�̸�\t: " + jvo.getName());
			if (jvo.getEmail() != null)
				System.out.println("�̸���\t: " + jvo.getEmail());
			else
				System.out.println("�̸���\t: ");
			if (jvo.getAge() != 0)
				System.out.println("����\t: " + jvo.getAge());
			else
				System.out.println("����\t: ");
			System.out.println("�����\t: " + jvo.getRegdate());
			System.out.println("--------------------------------------------------");
		}
	}

	public static void printMain() {

		System.out.println("--------------------------------------------------");
		System.out.println("=== ȸ�� ���� ���α׷� Ver 1.03 ===");
		System.out.println(" [1] ȸ�� ��� ����");
		System.out.println(" [2] ȸ�� ���� ���");
		System.out.println(" [3] �α���");
		System.out.println(" [4] ȸ�� ���� �˻�");
		System.out.println(" [5] ȸ�� ���� ����");
		System.out.println(" [6] ȸ�� ���� ����");
		System.out.println(" [7] ���α׷� ����");
		System.out.println();

	}

	public static void printJoinList(List<JoinVO> jList) {
		TableInfo_Join ti = new TableInfo_Join();

		tappingTitle("���̵�", ti.length_userid);
		tappingTitle("�̸�", ti.length_name);
		tappingTitle("�̸���", ti.length_email);
		tappingTitle("������� ", ti.length_regdate);
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

	// ���� ���� ����ϱ�
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

	// Ÿ��Ʋ ���� ����ϱ�
	private static void tappingTitle(String str, int maxSize) {

		System.out.print(str);
		int iter = maxSize / 8 + 1;
		for (int i = 0; i < iter; i++)
			System.out.print("\t");

	}
}
