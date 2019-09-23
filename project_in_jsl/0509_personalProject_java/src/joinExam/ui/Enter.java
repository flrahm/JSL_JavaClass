package joinExam.ui;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Enter { // �Է¿� ���õ� �޼ҵ� ����

	// �̸��� ��ȿ���� �˻��ϴ� �޼ҵ�. ����� �� �����, �ѱ��̸� �� �ѱ۷�, �����ڿ� ���ڸ�
	public static boolean nameValidate(String str) {
		String namePattern = "^[a-zA-Z��-�R]*$";
		return Pattern.matches(namePattern, str);
			
	}
	
	// �̸����� ��ȿ���� �˻��ϴ� �޼ҵ�
	public static boolean emailValidate(String str) {
		String emailPattern = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.[a-zA-Z]{2,6}$";
		return Pattern.matches(emailPattern, str);
	}
	
	// ��й�ȣ�� ��ȿ���� �˻��ϴ� �޼ҵ�
	public static boolean pwValidate(String str) {
		boolean flag = false;

		boolean isCapital = false;
		boolean isSmall = false;
		boolean isNum = false;
		boolean isSpecial = false;

		for (int i = 0; i < str.length(); i++) {
			char test = str.charAt(i);
			if (test >= 'a' && test <= 'z')
				isSmall = true;
			if (test >= 'A' && test <= 'Z')
				isCapital = true;
			if (test >= '0' && test <= '9')
				isNum = true;
			if (!((test >= 'a' && test <= 'z') || (test >= 'A' && test <= 'Z') || (test >= '0' && test <= '9')))
				isSpecial = true;
		}
		if (isCapital && isSmall && isNum && isSpecial)
			flag = true;

		return flag;
	}

	// ���̵��� ��ȿ���� �˻��ϴ� �޼ҵ�
	public static boolean idValidate(String str) {
		
		for (int i = 0; i < str.length(); i++) {
			char test = str.charAt(i);
			if(i == 0 && !(test >='a' && test <= 'z')) {
				System.err.println("���̵�� �ݵ�� ���� �ҹ��ڷ� �����ؾ� �մϴ�");
				return false;
			}
			if (!((test >= 'a' && test <= 'z') || (test >= '0' && test <= '9'))) {
				System.err.println("���̵�� ���� �ҹ��ڿ� ���ڸ� ��� �����մϴ�");
				return false;
			}
		}

		return true;
	}

	// ���ڼ��� ���� �޼ҵ�
	private static int countStrNum(String str) {

		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			char test = str.charAt(i);

			if ((test >= 'a' && test <= 'z') || (test >= 'A' && test <= 'Z') || (test >= '0' && test <= '9'))
				cnt++;
			else
				cnt += 2;
		}

		return cnt;
	}

	// DB�κ��� ��¥�� ������. ��Ʈ������ �޾Ƽ� ��Ʈ������ ��ȯ
	public static String getDateFromDB(String inStr) {

		if (inStr != null) {
			return inStr.substring(0, 11);
		} else {
			return null;
		}

	}

	// ���ڸ� �Է¹޴� �޼ҵ�. �ڸ��� �̸�����
	public static String inputStr(Scanner scan, int maxNum, int option) {// �ɼ��� 0�̸� ��ĭ �Է½� null ��ȯ, 1�̸� �ʼ� �Է�
		boolean flag = true;
		String inStr = "";
		while (flag) {
			inStr = scan.nextLine();

			if (inStr.equals("")) {
				if (option == 0)
					return null;
				else
					System.err.println("���� �Է��ϼ���");

			} else {
				if (countStrNum(inStr) <= maxNum || maxNum == 0)
					flag = false;
				else
					System.err.println("�Է� ������ �ʰ��Ͽ����ϴ� (���� : " + countStrNum(inStr) + "/�ִ밪 : " + maxNum + ")");
			}
		}

		return inStr;
	}

	// ���ڸ� �Է¹޴� �޼ҵ�. ��Ʈ��
	public static String inputNum(Scanner scan, int maxNum) { // 0�̸� ���Ѿ���, �ڸ���

		String returnStr = null;
		String inStr;
		boolean flag = true;
		while (flag) {
			inStr = scan.nextLine();

			if (inStr.length() <= maxNum || maxNum == 0) {
				if (!inStr.equals("")) {
					for (int i = 0; i < inStr.length(); i++) {
						if (!(inStr.charAt(i) >= '0' && inStr.charAt(i) <= '9')) {
							System.err.println("�߸��� �Է��Դϴ�. ���� �Ǵ� ��ĭ�� �Է��ϼ���");
							break;
						}

						if (i == inStr.length() - 1) {
							returnStr = inStr;
							flag = false;
						}
					}

				} else {
					returnStr = null;
					flag = false;
				}

			} else
				System.err.println("�Է� ������ �ʰ��Ͽ����ϴ� (" + maxNum + ")");
		}

		return returnStr;
	}

}
