package prob01;

public class Printer {

//	public void println(int num) {
//		System.out.println(num);
//	}
//
//	public void println(double b) {
//		System.out.println(b);
//	}
//
//	public void println(boolean a) {
//		System.out.println(a);
//	}
//
//	public void println(String name) {
//		System.out.println(name);
//	}

	// Java Generic(*overloding is better than Generic)
//	public <T> void println(T t) {
//		System.out.println(t);
//	}
	
	//가변 파라미터 + Generic method
	public <T> void println(T... ts) {
		for (T t : ts) {
			System.out.print(t + " ");
		}
		System.out.println("");
	}

	public int sum(int... nums) {
		int sum = 0;
		for (int n : nums) {
			sum += n;
		}
		return sum;
	}
}
