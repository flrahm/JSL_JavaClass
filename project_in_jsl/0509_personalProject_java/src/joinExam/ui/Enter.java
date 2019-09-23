package joinExam.ui;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Enter { // ÀÔ·Â¿¡ °ü·ÃµÈ ¸Ş¼Òµå ¸ğÀ½

	// ÀÌ¸§ÀÇ À¯È¿¼ºÀ» °Ë»çÇÏ´Â ¸Ş¼Òµå. ¿µ¾î¸é Âß ¿µ¾î·Î, ÇÑ±ÛÀÌ¸é Âß ÇÑ±Û·Î, ¿µ¹®ÀÚ¿Í ¼ıÀÚ¸¸
	public static boolean nameValidate(String str) {
		String namePattern = "^[a-zA-Z°¡-ÆR]*$";
		return Pattern.matches(namePattern, str);
			
	}
	
	// ÀÌ¸ŞÀÏÀÇ À¯È¿¼ºÀ» °Ë»çÇÏ´Â ¸Ş¼Òµå
	public static boolean emailValidate(String str) {
		String emailPattern = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.[a-zA-Z]{2,6}$";
		return Pattern.matches(emailPattern, str);
	}
	
	// ºñ¹Ğ¹øÈ£ÀÇ À¯È¿¼ºÀ» °Ë»çÇÏ´Â ¸Ş¼Òµå
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

	// ¾ÆÀÌµğÀÇ À¯È¿¼ºÀ» °Ë»çÇÏ´Â ¸Ş¼Òµå
	public static boolean idValidate(String str) {
		
		for (int i = 0; i < str.length(); i++) {
			char test = str.charAt(i);
			if(i == 0 && !(test >='a' && test <= 'z')) {
				System.err.println("¾ÆÀÌµğ´Â ¹İµå½Ã ¿µ¾î ¼Ò¹®ÀÚ·Î ½ÃÀÛÇØ¾ß ÇÕ´Ï´Ù");
				return false;
			}
			if (!((test >= 'a' && test <= 'z') || (test >= '0' && test <= '9'))) {
				System.err.println("¾ÆÀÌµğ´Â ¿µ¾î ¼Ò¹®ÀÚ¿Í ¼ıÀÚ¸¸ »ç¿ë °¡´ÉÇÕ´Ï´Ù");
				return false;
			}
		}

		return true;
	}

	// ±ÛÀÚ¼ö¸¦ ¼¼´Â ¸Ş¼Òµå
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

	// DB·ÎºÎÅÍ ³¯Â¥¸¦ °¡Á®¿È. ½ºÆ®¸µÀ¸·Î ¹Ş¾Æ¼­ ½ºÆ®¸µÀ¸·Î ¹İÈ¯
	public static String getDateFromDB(String inStr) {

		if (inStr != null) {
			return inStr.substring(0, 11);
		} else {
			return null;
		}

	}

	// ¹®ÀÚ¸¦ ÀÔ·Â¹Ş´Â ¸Ş¼Òµå. ÀÚ¸´¼ö ¹Ì¸¸À¸·Î
	public static String inputStr(Scanner scan, int maxNum, int option) {// ¿É¼ÇÀÌ 0ÀÌ¸é ºóÄ­ ÀÔ·Â½Ã null ¹İÈ¯, 1ÀÌ¸é ÇÊ¼ö ÀÔ·Â
		boolean flag = true;
		String inStr = "";
		while (flag) {
			inStr = scan.nextLine();

			if (inStr.equals("")) {
				if (option == 0)
					return null;
				else
					System.err.println("°ªÀ» ÀÔ·ÂÇÏ¼¼¿ä");

			} else {
				if (countStrNum(inStr) <= maxNum || maxNum == 0)
					flag = false;
				else
					System.err.println("ÀÔ·Â ¹üÀ§¸¦ ÃÊ°úÇÏ¿´½À´Ï´Ù (½ÇÁ¦ : " + countStrNum(inStr) + "/ÃÖ´ë°ª : " + maxNum + ")");
			}
		}

		return inStr;
	}

	// ¼ıÀÚ¸¦ ÀÔ·Â¹Ş´Â ¸Ş¼Òµå. ½ºÆ®¸µ
	public static String inputNum(Scanner scan, int maxNum) { // 0ÀÌ¸é Á¦ÇÑ¾øÀ½, ÀÚ¸´¼ö

		String returnStr = null;
		String inStr;
		boolean flag = true;
		while (flag) {
			inStr = scan.nextLine();

			if (inStr.length() <= maxNum || maxNum == 0) {
				if (!inStr.equals("")) {
					for (int i = 0; i < inStr.length(); i++) {
						if (!(inStr.charAt(i) >= '0' && inStr.charAt(i) <= '9')) {
							System.err.println("Àß¸øµÈ ÀÔ·ÂÀÔ´Ï´Ù. ¼ıÀÚ ¶Ç´Â ºóÄ­À» ÀÔ·ÂÇÏ¼¼¿ä");
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
				System.err.println("ÀÔ·Â ¹üÀ§¸¦ ÃÊ°úÇÏ¿´½À´Ï´Ù (" + maxNum + ")");
		}

		return returnStr;
	}

}
