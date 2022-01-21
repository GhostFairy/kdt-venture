/*	알파벳 소문자로만 이루어진 단어가 주어진다. 이 때, 이 단어가 팰린드롬(회문)인지 아닌지 확인하는 프로그램을 작성하시오.
	팰린드롬이란 앞으로 읽을 때와 거꾸로 읽을 때 똑같은 단어를 말한다. 
	level, noon은 팰린드롬이고, multicampus, online, judge는 팰린드롬이 아니다.

	입력형식
	첫째 줄에 테스트할 단어 갯수가 주어진다.
	둘째줄부터 테스트할 단어를 단어 갯수만큼 입력한다. 
	단어의 길이는 1보다 크거나 같고, 100보다 작거나 같으며, 알파벳 소문자로만 이루어져 있다.

	출력형식
	둘째 줄부터 테스트할 갯수만큼 입력한 단어가 팰린드롬이면 1, 아니면 0을 출력한다.

	입력예                 출력예 
	2
	level          1
	online         0 

	입력예                 출력예 
	5
	level          1
	noon           1
	multicampus    0
	judge          0
	online         0
*/

import java.util.Scanner;

public class Test1 {

	static int isPalindrome(String word) {
		for (int i = 0; i < word.length() / 2; i++) {
			if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
				return 0;
			}
		}
		return 1;
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int count = stdIn.nextInt();
		stdIn.nextLine();
		String[] words = new String[count];
		for (int i = 0; i < count; i++) {
			words[i] = stdIn.nextLine();
		}
		for (int i = 0; i < count; i++) {
			System.out.println(isPalindrome(words[i]));
		}
		stdIn.close();
	}

}