// employees 테이블에서 6월 입사자의 사번, 이름, 급여, 입사일을 조회하여
// Employee 객체로 생성한 후에 ArrayList로 저장하고 출력하는 자바 프로그램을 구현하시오.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpDeptTest {

	public static void main(String[] args) {
		EmpDeptTest t = new EmpDeptTest();
		ArrayList<Employee> list = t.selectEmp(new String[] { "02", "06", "12" });
		for (Employee e : list) {
			System.out.println(e);
		}
	}

	ArrayList<Employee> selectEmp(String[] month) {
		ArrayList<Employee> list = new ArrayList<Employee>();

		try {
			// MySQL용 JDBC Driver 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			// DB 연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "emp");

			// 같은 SQL 구문을 조건만 바꾸면서 여러 번 실행하는 경우
			String query = "\"SELECT employee_id, first_name, salary, hire_date FROM employees WHERE hire_date LIKE '%-?-%'";
			PreparedStatement ps = conn.prepareStatement(query);

			for (int i = 0; i < month.length; i++) {
				ps.setInt(1, Integer.parseInt(month[i]));
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					int employee_id = rs.getInt("employee_id");
					String first_name = rs.getString("first_name");
					double salary = rs.getDouble("salary");
					String hire_date = rs.getString("hire_date");
					
					list.add(new Employee(employee_id, first_name, salary, hire_date));
				}
				rs.close();
			}

			ps.close();
			conn.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
}

class Employee {

	int employee_id;
	String first_name;
	double salary;
	String hire_date;

	public Employee(int employee_id, String first_name, double salary, String hire_date) {
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.salary = salary;
		this.hire_date = hire_date;
	}

	@Override
	public String toString() {
		return employee_id + "\t" + first_name + "\t" + salary + "\t" + hire_date;
	}

}
