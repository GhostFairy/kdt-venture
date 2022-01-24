
import java.util.Stack;

public class PairStackTest {

	public static void main(String args[]) {
		// 괄호짝찾기에 적용 . {} () []
		String s = "{[()]}";// t
		System.out.println(isPair(s));// true
		s = "{}[]()";// t
		System.out.println(isPair(s));
		s = "{{[]()[]{}}";// f
		System.out.println(isPair(s));
		s = "{[}](}";// f
		System.out.println(isPair(s));
	}

	static boolean isPair(String s) {
		Stack<String> st = new Stack<String>();
		boolean flag = false;
		// 오픈괄호 stack 저장한다
		// 클로즈괄호 나오면("}" ) --> stack 추출하여 "{" 일치 검사
		// 클로즈괄호 나오면("]" ) --> stack 추출하여 "[" 일치 검사
		// 클로즈괄호 나오면(")" ) --> stack 추출하여 "(" 일치 검사
		for (int i = 0; i < s.length(); i++) {
			String word = s.substring(i, i + 1);
			if (word.equals("{") || word.equals("(") || word.equals("[")) {
				st.push(word);
			} else if (word.equals("}") && !st.isEmpty()) {
				if (st.pop().equals("{")) {
					flag = true;
				}
			} else if (word.equals(")") && !st.isEmpty()) {
				if (st.pop().equals("(")) {
					flag = true;
				}
			} else if (word.equals("]") && !st.isEmpty()) {
				if (st.pop().equals("[")) {
					flag = true;
				}
			}
		}
		if (!st.isEmpty()) {
			return false;
		}
		return flag;
	}

}
