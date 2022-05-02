package prob6;

public interface Resizable {

	public static void resize(double d) {
		Rectangle.width = Rectangle.width * d;
		Rectangle.height = Rectangle.height * d;
	}
}