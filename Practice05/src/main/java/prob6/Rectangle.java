package prob6;

public class Rectangle extends Shape {
	
	private int w;
	private int h;

	public Rectangle(int w, int h) {
		this.h = h;
		this.w = w;
	}

	@Override
	protected double getArea() {
		return w*h;
	}

	@Override
	protected double getPerimeter() {
		return (w+h)*2;
	}

}
