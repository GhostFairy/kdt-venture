
import java.util.Scanner;

public class QuickSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("학생 수 입력: ");
		int N = sc.nextInt();
		int[] scores = new int[N];
		System.out.println();

		for (int i = 0; i < N; i++) {
			System.out.print("학생 " + (i + 1) + " 점수 입력: ");
			scores[i] = sc.nextInt();
		}
		System.out.println();
		sc.close();

		System.out.println("성적 순으로 정렬");
		quickSort(scores, 0, scores.length - 1);

		for (int i = 0; i < N; i++) {
			System.out.println((i + 1) + "등: " + scores[i]);
		}
	}

	static void quickSort(int[] data, int left, int right) {
		if (left < right) {
			int pl = left;
			int pr = right;
			int pivot = data[(left + right) / 2];

			while (pl < pr) {
				while (data[pl] > pivot) {
					pl++;
				}
				while (data[pr] < pivot) {
					pr--;
				}
				int temp = data[pl];
				data[pl] = data[pr];
				data[pr] = temp;
			}

			quickSort(data, left, pl - 1);
			quickSort(data, pr + 1, right);
		}
	}

}
