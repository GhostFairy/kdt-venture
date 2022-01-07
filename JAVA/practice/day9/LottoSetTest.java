import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class LottoSetTest {

	public static void main(String[] args) {
		HashSet<Integer> lottoSet = new HashSet<Integer>();
		// lottoSet에 1-45 사이의 중복되지 않는 로또 숫자 6개를 생성하여 저장하고 출력한다.

		while (lottoSet.size() < 6) {
			Random rand = new Random();
			lottoSet.add(rand.nextInt(45) + 1);
		}
		
		// Set을 배열로 만들고 정렬
		Integer[] result = lottoSet.toArray(new Integer[lottoSet.size()]);
		Arrays.sort(result);

		// 배열을 출력
		for (Integer i : result) {
			System.out.print(i + " ");
		}
	}

}
