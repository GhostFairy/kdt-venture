//1. 키보드 + Scanner 이용하여 입력받기
//예)
//이름: 이학생
//국어: 100
//영어: 90
//수학: 80
//2. 3~N명의 학생의 정보 저장
//3. Student 클래스 정의(name kor eng mat sum avg 필요하면 getter/setter, 생성자 ...)
//4. ArrayList<Student> 생성
//5. 학생별 총점, 평균 계산하여 저장
//6. 현재 프로젝트 내 scores.dat 파일 생성 후 저장
//예)
//1 이학생 100 90 80 총점 평점
//2 ...
//3 ...

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;


class Student {

	String name;
	int kor;
	int eng;
	int mat;
	int sum;
	double avg;

	public Student(String name, int kor, int eng, int mat) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		sum = kor + eng + mat;
		avg = sum / 3.0;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.00");
		return name + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + sum + "\t" + df.format(avg);
	}

}

public class ScoreTest {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		System.out.print("입력할 학생의 수: ");
		int max = sc.nextInt();
		System.out.println();

		ArrayList<Student> list = new ArrayList<Student>();

		for (int i = 0; i < max; i++) {
			System.out.print("학생 정보 입력 (이름 국어 영어 수학): ");
			String name = sc.next();
			int kor = sc.nextInt();
			int eng = sc.nextInt();
			int mat = sc.nextInt();

			list.add(new Student(name, kor, eng, mat));
		}
		System.out.println();
		sc.close();

		FileWriter fw = new FileWriter("scores.dat", true);
		fw.write("순번\t이름\t\t국어\t영어\t수학\t총점\t평균\n");

		for (int i = 0; i < list.size(); i++) {
			fw.write((i + 1) + "\t" + list.get(i).toString() + "\n");
		}

		fw.close();
		System.out.println("입력된 정보를 scores.dat에 저장하였습니다.");
	}

}