package prob04;

public class Depart extends Employee {	
	
	private String name;
	private int salary;
	private String depart;

	public Depart(String name, int salary, String depart) {
		this.name = name;
		this.salary = salary;
		this.depart = "기획부";
	}
	
	@Override
	public void getInformation() {
		System.out.println("이름: " + name + "  연봉: " + salary + "  부서: " + depart);
	}
	
}
