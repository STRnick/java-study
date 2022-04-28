package prob01;

public class Printer {
	private int num;
	private boolean a;
	private double b;
	private String name;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public boolean isA() {
		return a;
	}

	public void setA(boolean a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void println(int num) {
		this.num = num;
		System.out.println(num);
	}

	public void println(double b) {
		this.b = b;
		System.out.println(b);
	}

	public void println(boolean a) {
		this.a = a;
		System.out.println(a);
	}

	public void println(String name) {
		this.name = name;
		System.out.println(name);
	}
}
