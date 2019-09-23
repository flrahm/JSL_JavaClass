package joinExam.ui;

import java.util.List;
import java.util.Scanner;

import joinExam.dao.TableInfo_Join;
import joinExam.vo.JoinVO;

public class JoinView {
	TableInfo_Join ti = new TableInfo_Join();

	// 5. 삭제할 회원 정보 출력
	public void print4Delete(JoinVO jvo) {
		
		System.out.println("ID\t: " + jvo.getUserid());
		System.out.println("이름\t: " + jvo.getName());
		System.out.println("이메일\t: " + jvo.getEmail());
		
	}
	
	// 5. 삭제할 회원아이디 입력받기
	public String getId4Delete(Scanner scan) {
		System.out.println(" == 회원 정보 삭제 ==");
		System.out.println("삭제를 원하는 회원의 ID 를 입력하세요 : ");
		String userid = Enter.inputStr(scan, ti.length_userid, 1);

		return userid;
	}
	
	// 4. 수정할 회원 정보 입력받기
	public JoinVO getVO4Update(Scanner scan, JoinVO jvo) {
		System.out.println("ID\t: " + jvo.getUserid());

		// 이름 입력
		System.out.print("이름(" + jvo.getName() + "): ");
		String name = getName(scan, 0);

		// 비밀번호 입력
		System.out.print("비밀번호(");
		for (int i = 0; i < jvo.getPasswd().length(); i++)
			System.out.print("*");
		System.out.print("):");
		String pw = getPW(scan, 0);
		
		// 이메일 입력
		System.out.print("이메일 (");
		if(jvo.getEmail() != null)
			System.out.print(jvo.getEmail() + "): ");
		else
			System.out.print("없음): ");
		String email = getEmail(scan, 0);
		
		// 나이 입력
		System.out.print("나이 (");
		if(jvo.getAge() != 0)
			System.out.print(jvo.getAge() + "): ");
		else
			System.out.print("없음): ");
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

	// 검색용 아이디 입력받기
	public String getId4Search(Scanner scan) {
		System.out.println(" == 회원 정보 수정 ==");
		System.out.println("수정을 원하는 회원의 ID 를 입력하세요 : ");
		String userid = Enter.inputStr(scan, ti.length_userid, 1);

		return userid;
	}

	// 작업 반복 여부 묻기
	public boolean isIterWork(Scanner scan, String workName) {
		System.out.println("계속 " + workName + " 하시겠습니까? [Y/N]");

		while (true) {
			String choice = scan.nextLine();
			if (choice.equalsIgnoreCase("y"))
				return true;
			else if (choice.equalsIgnoreCase("n")) {
				return false;
			} else
				System.err.println("잘못된 입력입니다. y 또는 n 을 입력하세요");
		}
	}

	// 4. 리스트 출력하기
	public void printSearchResult(List<JoinVO> jList, String flag) {
		if (jList.size() == 0) {
			if (flag.equals("1"))
				System.out.println("해당 ID로 등록된 회원이 없습니다");
			else
				System.out.println("해당 이름으로 등록된 회원이 없습니다");
		} else
			JoinPrint.printListByVO(jList);

	}

	// 4. 검색할 아이디 또는 이름 입력받기
	public String[] getIdOrName(Scanner scan) {
		System.out.println(" == 회원 검색 ==");
		System.out.println("무엇으로 검색하시겠습니까?  ([1] 아이디로 검색 / [2] 이름으로 검색)");

		String[] IdNameAndFlag = new String[2];

		String IdOrName;
		while (true) {
			IdOrName = Enter.inputNum(scan, 1);
			if (IdOrName != null) {
				if (IdOrName.equals("1")) {
					System.out.println("아이디로 검색합니다");
					IdNameAndFlag[1] = "1";
					break;
				} else if (IdOrName.equals("2")) {
					System.out.println("이름으로 검색합니다");
					IdNameAndFlag[1] = "2";
					break;
				} else
					System.err.println("1 또는 2를 입력하세요");
			} else
				System.err.println("값을 입력하세요");
		}

		if (IdOrName.equals("1")) {
			System.out.println("ID : ");
			IdNameAndFlag[0] = Enter.inputStr(scan, ti.length_userid, 1);
		} else {
			System.out.println("이름 : ");
			IdNameAndFlag[0] = Enter.inputStr(scan, ti.length_name, 1);
		}

		return IdNameAndFlag;

	}

	// 3. 로그인 결과 출력
	public void printLoginResult(int loginResult, int tryCnt, int tryLimit) {
		System.out.println();
		if (loginResult == 0)
			System.out.println("존재하지 않는 아이디 입니다");
		else if (loginResult == 1)
			System.out.println("비밀번호가 틀렸습니다");
		else
			System.out.println("로그인 성공");

		if (loginResult == 0 || loginResult == 1) {
			if ((tryCnt + 1) != tryLimit) {
				System.err.println(tryLimit + "회 오류시 메인으로 돌아갑니다. 현재 시도 횟수 : " + (tryCnt + 1));
				System.out.println();
			} else {
				System.err.println(tryLimit + "회 모두 틀리셨습니다. 메인으로 돌아갑니다");
				System.out.println();
			}
		}

	}

	// 3. 로그인용 아이디 비밀번호 입력
	public String[] getIdPw(Scanner scan) {
		System.out.println(" == 회원 로그인 ==");
		String[] idPw = new String[2];
		System.out.println("ID : ");
		idPw[0] = Enter.inputStr(scan, ti.length_userid, 1);
		System.out.println("PW : ");
		idPw[1] = Enter.inputStr(scan, ti.length_passwd, 1);
		return idPw;
	}

	// 쿼리문 실행 결과
	public void printOk(String work, int workOk) {
		if (workOk != 0)
			System.out.println(work + " 성공");
		else
			System.err.println(work + " 실패");
	}

	// 작업 실행 확인
	public boolean insureWork(String work, Scanner scan) {
		System.out.println(work + " 하시겠습니까? [y/n]");

		while (true) {
			String choice = scan.nextLine();
			if (choice.equalsIgnoreCase("y"))
				return true;
			else if (choice.equalsIgnoreCase("n")) {
				System.out.println(work + "이(가) 취소되었습니다");
				return false;
			} else
				System.err.println("잘못된 입력입니다. y 또는 n 을 입력하세요");
		}
	}

	// 2-3 나머지 입력받기
	public void enterVO4Add(Scanner scan, JoinVO jvo) {

		System.out.println("이름 : ");
		String name = getName(scan, 1);

		System.out.println("비밀번호 : ");
		String passwd = getPW(scan,1);

		System.out.println("이메일 : ");
		String email = getEmail(scan, 0);

		System.out.println("나이 : ");
		int age = getAge(scan);

		jvo.setName(name);
		jvo.setPasswd(passwd);
		jvo.setEmail(email);
		jvo.setAge(age);
	}

	// 2-3-4 나이 입력받기
	public int getAge(Scanner scan) {

		String age = Enter.inputNum(scan, ti.length_age);
		if (age == null)
			return 0;
		else
			return Integer.parseInt(age);
	}

	// 2-3-3 이메일 입력받기
	public String getEmail(Scanner scan, int option) {

		String email;
		while (true) {
			email = Enter.inputStr(scan, ti.length_email, 0);
			if (email == null && option != 1)
				break;
			if (Enter.emailValidate(email))
				break;
			else
				System.err.println("올바른 이메일 형식이 아닙니다");
		}
		return email;
	}

	// 2-3-2 이름 입력받기
	public String getName(Scanner scan, int option) {

		String name;
		while (true) {
			name = Enter.inputStr(scan, ti.length_name, 0);
			if (name == null)
				if (option == 1)
					System.err.println("이름은 필수 입력입니다");
				else
					break;
			else {
				if (Enter.nameValidate(name))
					break;
				else
					System.err.println("이름은 영문 혹은 한글만 입력 가능합니다");
			}
		}

		return name;
	}

	// 2-3-1 비밀번호 입력받기
	private String getPW(Scanner scan, int option) {
		String pw;
		while (true) {
			pw = Enter.inputStr(scan, ti.length_passwd, 0);

			if (pw == null)
				if (option == 1)
					System.err.println("비밀번호는 필수 입력입니다");
				else
					break;
			else {
				if (Enter.pwValidate(pw))
					break;
				else
					System.err.println("비밀번호에는 영문 대소문자, 숫자, 특수문자(한글포함)이 모두 포함되어 있어야 합니다");
			}
		}

		return pw;

	}

	// 2-2 중복 아이디 출력문
	public void IdOverlap(boolean isOverlap) {
		if (isOverlap)
			System.err.println("중복된 아이디 입니다");
		else
			System.out.println("사용 가능한 아이디 입니다");
	}

	// 2-1 아이디 입력받기
	public String getID(Scanner scan) {
		System.out.println(" == 신규 회원 등록 ==");
		System.out.println("ID : ");
		String id;

		while (true) {
			id = Enter.inputStr(scan, ti.length_userid, 1);
			if (Enter.idValidate(id))
				break;
		}

		return id;
	}

	// 1. 전체 리스트 출력
	public void printAllJoin(List<JoinVO> jList) {

		if (jList.size() != 0) {
			System.out.println(" == 전체 회원 목록 ==");
			System.out.println("전체 회원 수 : " + jList.size() + " 명");
			System.out.println();
			JoinPrint.printJoinList(jList);
		} else
			System.out.println("등록된 회원이 없습니다");

	}
}
