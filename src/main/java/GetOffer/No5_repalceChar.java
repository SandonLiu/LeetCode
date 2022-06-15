package GetOffer;

public class No5_repalceChar {
	public static void main(String[] args) {

		// 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
		// 输入：s = "We are happy."
		// 输出："We%20are%20happy."

		// 输入条件
		String inputStr = "We are happy.";
		String strAfter = "%20";
		char charBefore = ' ';

		// 字符替换
		String outputStr = replaceChar(inputStr, charBefore, strAfter);

		// 结果输出
		System.out.println(inputStr);
		System.out.println(outputStr);
	}

	private static String replaceChar(String inputStr, char charBefore, String strAfter) {

		// 定义极限数组
		char[] outputArray = new char[inputStr.length() * strAfter.length()];

		int size = 0;
		for (int i = 0; i < inputStr.length(); i++) {

			// 未遇到charBefore
			if (inputStr.charAt(i) != charBefore) {
				outputArray[size++] = inputStr.charAt(i);

				// 遇到charBefore
			} else {
				for (int j = 0; j < strAfter.length(); j++) {
					outputArray[size++] = strAfter.charAt(j);
				}
			}
		}

		// char[] -> String
		return new String(outputArray);
	}

}

//private class String replaceChar(String inputStr, String strAfter,char charBefore) {
//	

//	return
//}