package prob5;

public class MyStack {
	private int top = 0;
	private String[] buffer;

	public MyStack(int size) {
		buffer = new String[size];
	}

	public void push(String string) {
		resize();
		buffer[++top] = string;
	}

	private void resize() {
		if (top + 1 == buffer.length) {
			String[] buffer2 = new String[buffer.length * 2];
			System.arraycopy(buffer, 0, buffer2, 0, top + 1);
			buffer = buffer2;
		}
	}

	public String pop() throws MyStackException {
		if (top == 0) {
			throw new MyStackException();
		} else {
			String string = buffer[top];
			buffer[top] = null;
			top--;
			return string;
		}
	}

	public boolean isEmpty() {
		return top == 0;
	}
}