package chapter03;

public class StudentTest {

	public static void main(String[] args) {
		Student s1 = new Student();
		s1.setGrade(1);
		
		Person p1 = s1;  		  //upcasting(암시적/자식→부모)
		p1.setName("둘리");
		
		Student s2 = (Student)p1; //downcasting(명시적/부모→자식)
		s2.setMajor("cs");		
	}

}
