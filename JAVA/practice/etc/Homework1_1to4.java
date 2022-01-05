// 1. Class Nation을 만들고 나라이름, 면적, 인구수를 멤버 변수로 만들고,
//    나라이름변경(), 면적변경(), 인구수변경() 메소드를 만드시오
// 2. Class Nation을 상속한 나라를 3개 만들고,
//    나라별로 특수한 멤버변수 하나와 메소드 하나를 생성하시오
// 3. 나라이름을 private로 지정하고, 면적과 인구수는 public으로 지정하시오
// 4. 행성이름을 만들고 static으로 지정하시오

class Nation {

	private String name;
	public int area;
	public int population;
	static String planet = "지구";

	public void setName(String name) {
		this.name = name;
		System.out.println("나라이름: " + this.name);
	}

	public void setArea(int area) {
		this.area = area;
		System.out.println("면적: " + this.area + "㎢");
	}

	public void setPopulation(int population) {
		this.population = population;
		System.out.println("인구수: " + this.population + "명");
	}

}

class Korea extends Nation {

	String anthem;

	public void setAnthem(String anthem) {
		this.anthem = anthem;
		System.out.println("국가: " + anthem);
	}

}

class USA extends Nation {

	String capital;

	public void setCapital(String capital) {
		this.capital = capital;
		System.out.println("수도: " + capital);
	}

}

class Greece extends Nation {

	String language;

	public void setLanguage(String language) {
		this.language = language;
		System.out.println("언어: " + language);
	}
}

public class Homework1_1to4 {

	public static void main(String[] args) {
		Korea k = new Korea();
		k.setName("대한민국");
		k.setArea(100363);
		k.setPopulation(51709098);
		k.setAnthem("애국가");
		System.out.println();

		USA a = new USA();
		a.setName("미국");
		a.setArea(9833520);
		a.setPopulation(331893745);
		a.setCapital("워싱턴 DC");
		System.out.println();

		Greece g = new Greece();
		g.setName("그리스");
		g.setArea(131957);
		g.setPopulation(10678632);
		g.setLanguage("그리스어");
		System.out.println();

		System.out.println("행성이름: " + Nation.planet);
	}

}
