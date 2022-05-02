package prob5;

public class MyStackException extends Exception {
	private static final long serialVersionUID = 1L;

	MyStackException() {
		super("stack is empty");
	}
}
