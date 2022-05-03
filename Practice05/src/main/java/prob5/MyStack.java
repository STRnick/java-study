package prob5;

public class MyStack {
	private int top = 0;
	private String[] buffer;

	public MyStack(int size) {
		buffer = new String[size];
	}

	private void resize() {
		String[] newBuffer = new String[buffer.length * 2];
		System.arraycopy(buffer, 0, newBuffer, 0, top + 1);
		buffer = newBuffer;
	}

	public void push(String word) {
		if (top == buffer.length - 1) {
			resize();
		}
//		top += 1;
		buffer[++top] = word;
	}

	public String pop() throws MyStackException {
		if (isEmpty()) {
			throw new MyStackException();
		}
		
		String result = buffer[top];
		buffer[top--] = null;
		
		return result;
	}

	public boolean isEmpty() {
		return top == -1;
	}
}