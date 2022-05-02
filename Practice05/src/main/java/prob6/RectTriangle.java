package prob6;

public class RectTriangle extends Shape implements Resizable {
	private double width;
	private double height;

	public RectTriangle(int width, int height) {
		Shape.width = (double) width;
		Shape.height = (double) height;
		this.width = (double) width;
		this.height = (double) height;
	}

	@Override
	public double getArea() {
		return (width * height * 0.5);
	}

	@Override
	public double getPerimeter() {
		return (width + height + Math.sqrt((width * width) + (height * height)));
	}

}
