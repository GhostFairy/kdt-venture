
class Employee {

	int id;
	String name;
	int salary;
	int bonus;
	int total;

	public Employee(int id, String name, int salary, int bonus) {
		// super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.bonus = bonus;
	}

	public void calcTotal() {
		total = salary + bonus;
	}

}

class Manager extends Employee {

	int managerBonus;

	public Manager(int id, String name, int salary, int bonus, int managerBonus) {
		super(id, name, salary, bonus);
		this.managerBonus = managerBonus;
	}

	@Override
	public void calcTotal() {
		super.calcTotal();
		total = super.total + managerBonus;
	}

}

class Engineer extends Employee {

	int certBonus;
	int techBonus;

	public Engineer(int id, String name, int salary, int bonus, int certBonus, int techBonus) {
		super(id, name, salary, bonus);
		this.certBonus = certBonus;
		this.techBonus = techBonus;
	}

	@Override
	public void calcTotal() {
		super.calcTotal();
		total = super.total + certBonus + techBonus;
	}

}

class Secretary extends Employee {

	int secretBonus;

	public Secretary(int id, String name, int salary, int bonus, int secretBonus) {
		super(id, name, salary, bonus);
		this.secretBonus = secretBonus;
	}

	@Override
	public void calcTotal() {
		super.calcTotal();
		total = super.total + secretBonus;
	}

}

public class SalaryTest {

	public static void main(String[] args) {
		Employee e[] = new Employee[4];
		e[0] = new Employee(1000, "이사원", 10000, 5000);
		e[1] = new Manager(2000, "김간부", 20000, 10000, 10000);
		e[2] = new Engineer(3000, "박기술", 15000, 7500, 5000, 5000);
		e[3] = new Secretary(4000, "최비서", 15000, 7000, 10000);

		for (int i = 0; i < e.length; i++) {
			e[i].calcTotal();
			System.out.println(e[i].id + " : " + e[i].name + " : " + e[i].salary + " : " + e[i].total);
		}
	}

}
