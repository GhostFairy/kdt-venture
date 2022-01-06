// 9. java.util.Date, java.text.SimpleDateFormat을 임포트하고
//    현재 날짜를 2021-12-31 23:59:59로 출력하시오

import java.util.Date;
import java.text.SimpleDateFormat;

public class Homework1_9 {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(new Date()));
	}

}
