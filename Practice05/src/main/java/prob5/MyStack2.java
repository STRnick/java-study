package prob5;

public class MyStack2 {
	private int top;
	private Object[] buffer;

	public MyStack2(int size) {
		top = -1;
		buffer = new Object[size];
	}

	public void push(Object word) {
		if (top == buffer.length - 1) {
			resize();
		}
//		top += 1;
		buffer[++top] = word;
	}

	private void resize() {
		Object[] newBuffer = new Object[buffer.length * 2];
		System.arraycopy(buffer, 0, newBuffer, 0, top + 1);
		buffer = newBuffer;
	}

	public Object pop() throws MyStackException {
		if (isEmpty()) {
			throw new MyStackException();
		}

		Object result = buffer[top];
		buffer[top--] = null;

		return result;
	}

	public boolean isEmpty() {
		return top == -1;
	}
}