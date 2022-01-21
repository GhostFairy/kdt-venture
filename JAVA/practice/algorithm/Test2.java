/*	정삼각형 별 출력
	5 입력
		    *
		   ***
		  *****
		 *******
		*********
*/

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int size = stdIn.nextInt();
		stdIn.close();

		for (int i = 0; i < size; i++) {
			for (int j = 1; j < size - i; j++) {
				System.out.print(" ");
			}
			for (int j = size - i; j <= size + i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
