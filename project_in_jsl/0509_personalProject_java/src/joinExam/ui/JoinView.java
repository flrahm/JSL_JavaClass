package joinExam.ui;

import java.util.List;
import java.util.Scanner;

import joinExam.dao.TableInfo_Join;
import joinExam.vo.JoinVO;

public class JoinView {
	TableInfo_Join ti = new TableInfo_Join();

	// 5. ������ ȸ�� ���� ���
	public void print4Delete(JoinVO jvo) {
		
		System.out.println("ID\t: " + jvo.getUserid());
		System.out.println("�̸�\t: " + jvo.getName());
		System.out.println("�̸���\t: " + jvo.getEmail());
		
	}
	
	// 5. ������ ȸ�����̵� �Է¹ޱ�
	public String getId4Delete(Scanner scan) {
		System.out.println(" == ȸ�� ���� ���� ==");
		System.out.println("������ ���ϴ� ȸ���� ID �� �Է��ϼ��� : ");
		String userid = Enter.inputStr(scan, ti.length_userid, 1);

		return userid;
	}
	
	// 4. ������ ȸ�� ���� �Է¹ޱ�
	public JoinVO getVO4Update(Scanner scan, JoinVO jvo) {
		System.out.println("ID\t: " + jvo.getUserid());

		// �̸� �Է�
		System.out.print("�̸�(" + jvo.getName() + "): ");
		String name = getName(scan, 0);

		// ��й�ȣ �Է�
		System.out.print("��й�ȣ(");
		for (int i = 0; i < jvo.getPasswd().length(); i++)
			System.out.print("*");
		System.out.print("):");
		String pw = getPW(scan, 0);
		
		// �̸��� �Է�
		System.out.print("�̸��� (");
		if(jvo.getEmail() != null)
			System.out.print(jvo.getEmail() + "): ");
		else
			System.out.print("����): ");
		String email = getEmail(scan, 0);
		
		// ���� �Է�
		System.out.print("���� (");
		if(jvo.getAge() != 0)
			System.out.print(jvo.getAge() + "): ");
		else
			System.out.print("����): ");
		int age = getAge(scan);
		
		if (name != null)
			jvo.setName(name);
		if(pw != null)
			jvo.setPasswd(pw);
		if(email != null)
			jvo.setEmail(email);
		jvo.setAge(age);
		
		return jvo;
	}

	// �˻��� ���̵� �Է¹ޱ�
	public String getId4Search(Scanner scan) {
		System.out.println(" == ȸ�� ���� ���� ==");
		System.out.println("������ ���ϴ� ȸ���� ID �� �Է��ϼ��� : ");
		String userid = Enter.inputStr(scan, ti.length_userid, 1);

		return userid;
	}

	// �۾� �ݺ� ���� ����
	public boolean isIterWork(Scanner scan, String workName) {
		System.out.println("��� " + workName + " �Ͻðڽ��ϱ�? [Y/N]");

		while (true) {
			String choice = scan.nextLine();
			if (choice.equalsIgnoreCase("y"))
				return true;
			else if (choice.equalsIgnoreCase("n")) {
				return false;
			} else
				System.err.println("�߸��� �Է��Դϴ�. y �Ǵ� n �� �Է��ϼ���");
		}
	}

	// 4. ����Ʈ ����ϱ�
	public void printSearchResult(List<JoinVO> jList, String flag) {
		if (jList.size() == 0) {
			if (flag.equals("1"))
				System.out.println("�ش� ID�� ��ϵ� ȸ���� �����ϴ�");
			else
				System.out.println("�ش� �̸����� ��ϵ� ȸ���� �����ϴ�");
		} else
			JoinPrint.printListByVO(jList);

	}

	// 4. �˻��� ���̵� �Ǵ� �̸� �Է¹ޱ�
	public String[] getIdOrName(Scanner scan) {
		System.out.println(" == ȸ�� �˻� ==");
		System.out.println("�������� �˻��Ͻðڽ��ϱ�?  ([1] ���̵�� �˻� / [2] �̸����� �˻�)");

		String[] IdNameAndFlag = new String[2];

		String IdOrName;
		while (true) {
			IdOrName = Enter.inputNum(scan, 1);
			if (IdOrName != null) {
				if (IdOrName.equals("1")) {
					System.out.println("���̵�� �˻��մϴ�");
					IdNameAndFlag[1] = "1";
					break;
				} else if (IdOrName.equals("2")) {
					System.out.println("�̸����� �˻��մϴ�");
					IdNameAndFlag[1] = "2";
					break;
				} else
					System.err.println("1 �Ǵ� 2�� �Է��ϼ���");
			} else
				System.err.println("���� �Է��ϼ���");
		}

		if (IdOrName.equals("1")) {
			System.out.println("ID : ");
			IdNameAndFlag[0] = Enter.inputStr(scan, ti.length_userid, 1);
		} else {
			System.out.println("�̸� : ");
			IdNameAndFlag[0] = Enter.inputStr(scan, ti.length_name, 1);
		}

		return IdNameAndFlag;

	}

	// 3. �α��� ��� ���
	public void printLoginResult(int loginResult, int tryCnt, int tryLimit) {
		System.out.println();
		if (loginResult == 0)
			System.out.println("�������� �ʴ� ���̵� �Դϴ�");
		else if (loginResult == 1)
			System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�");
		else
			System.out.println("�α��� ����");

		if (loginResult == 0 || loginResult == 1) {
			if ((tryCnt + 1) != tryLimit) {
				System.err.println(tryLimit + "ȸ ������ �������� ���ư��ϴ�. ���� �õ� Ƚ�� : " + (tryCnt + 1));
				System.out.println();
			} else {
				System.err.println(tryLimit + "ȸ ��� Ʋ���̽��ϴ�. �������� ���ư��ϴ�");
				System.out.println();
			}
		}

	}

	// 3. �α��ο� ���̵� ��й�ȣ �Է�
	public String[] getIdPw(Scanner scan) {
		System.out.println(" == ȸ�� �α��� ==");
		String[] idPw = new String[2];
		System.out.println("ID : ");
		idPw[0] = Enter.inputStr(scan, ti.length_userid, 1);
		System.out.println("PW : ");
		idPw[1] = Enter.inputStr(scan, ti.length_passwd, 1);
		return idPw;
	}

	// ������ ���� ���
	public void printOk(String work, int workOk) {
		if (workOk != 0)
			System.out.println(work + " ����");
		else
			System.err.println(work + " ����");
	}

	// �۾� ���� Ȯ��
	public boolean insureWork(String work, Scanner scan) {
		System.out.println(work + " �Ͻðڽ��ϱ�? [y/n]");

		while (true) {
			String choice = scan.nextLine();
			if (choice.equalsIgnoreCase("y"))
				return true;
			else if (choice.equalsIgnoreCase("n")) {
				System.out.println(work + "��(��) ��ҵǾ����ϴ�");
				return false;
			} else
				System.err.println("�߸��� �Է��Դϴ�. y �Ǵ� n �� �Է��ϼ���");
		}
	}

	// 2-3 ������ �Է¹ޱ�
	public void enterVO4Add(Scanner scan, JoinVO jvo) {

		System.out.println("�̸� : ");
		String name = getName(scan, 1);

		System.out.println("��й�ȣ : ");
		String passwd = getPW(scan,1);

		System.out.println("�̸��� : ");
		String email = getEmail(scan, 0);

		System.out.println("���� : ");
		int age = getAge(scan);

		jvo.setName(name);
		jvo.setPasswd(passwd);
		jvo.setEmail(email);
		jvo.setAge(age);
	}

	// 2-3-4 ���� �Է¹ޱ�
	public int getAge(Scanner scan) {

		String age = Enter.inputNum(scan, ti.length_age);
		if (age == null)
			return 0;
		else
			return Integer.parseInt(age);
	}

	// 2-3-3 �̸��� �Է¹ޱ�
	public String getEmail(Scanner scan, int option) {

		String email;
		while (true) {
			email = Enter.inputStr(scan, ti.length_email, 0);
			if (email == null && option != 1)
				break;
			if (Enter.emailValidate(email))
				break;
			else
				System.err.println("�ùٸ� �̸��� ������ �ƴմϴ�");
		}
		return email;
	}

	// 2-3-2 �̸� �Է¹ޱ�
	public String getName(Scanner scan, int option) {

		String name;
		while (true) {
			name = Enter.inputStr(scan, ti.length_name, 0);
			if (name == null)
				if (option == 1)
					System.err.println("�̸��� �ʼ� �Է��Դϴ�");
				else
					break;
			else {
				if (Enter.nameValidate(name))
					break;
				else
					System.err.println("�̸��� ���� Ȥ�� �ѱ۸� �Է� �����մϴ�");
			}
		}

		return name;
	}

	// 2-3-1 ��й�ȣ �Է¹ޱ�
	private String getPW(Scanner scan, int option) {
		String pw;
		while (true) {
			pw = Enter.inputStr(scan, ti.length_passwd, 0);

			if (pw == null)
				if (option == 1)
					System.err.println("��й�ȣ�� �ʼ� �Է��Դϴ�");
				else
					break;
			else {
				if (Enter.pwValidate(pw))
					break;
				else
					System.err.println("��й�ȣ���� ���� ��ҹ���, ����, Ư������(�ѱ�����)�� ��� ���ԵǾ� �־�� �մϴ�");
			}
		}

		return pw;

	}

	// 2-2 �ߺ� ���̵� ��¹�
	public void IdOverlap(boolean isOverlap) {
		if (isOverlap)
			System.err.println("�ߺ��� ���̵� �Դϴ�");
		else
			System.out.println("��� ������ ���̵� �Դϴ�");
	}

	// 2-1 ���̵� �Է¹ޱ�
	public String getID(Scanner scan) {
		System.out.println(" == �ű� ȸ�� ��� ==");
		System.out.println("ID : ");
		String id;

		while (true) {
			id = Enter.inputStr(scan, ti.length_userid, 1);
			if (Enter.idValidate(id))
				break;
		}

		return id;
	}

	// 1. ��ü ����Ʈ ���
	public void printAllJoin(List<JoinVO> jList) {

		if (jList.size() != 0) {
			System.out.println(" == ��ü ȸ�� ��� ==");
			System.out.println("��ü ȸ�� �� : " + jList.size() + " ��");
			System.out.println();
			JoinPrint.printJoinList(jList);
		} else
			System.out.println("��ϵ� ȸ���� �����ϴ�");

	}
}
