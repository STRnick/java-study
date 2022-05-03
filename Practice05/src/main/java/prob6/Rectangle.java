package prob6;

public class Rectangle extends Shape implements Resizable {
	public static double width;
	public static double height;

	public Rectangle(int width, int height) {
		Shape.width = (double) width;
		Shape.height = (double) height;
		this.width = (double) width;
		this.height = (double) height;
	}

	@Override
	public double getArea() {
		return (width * height);
	}

	@Override
	public double getPerimeter() {
		return ((width + height)*2);
	}

}