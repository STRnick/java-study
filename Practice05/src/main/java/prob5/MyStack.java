package prob5;

public class MyStack<T> {
	private int top;
	private T[] buffer;

	@SuppressWarnings("unchecked")
	public MyStack(int size) {
		top = -1;
		buffer = (T[])new Object[size];
	}

	private void resize() {
		@SuppressWarnings("unchecked")
		T[] newBuffer = (T[])new Object[buffer.length * 2];
//		for(int i=0; i<top; i++){
//			newBuffer[i] = buffer[i];
//		}
		System.arraycopy(buffer, 0, newBuffer, 0, top + 1);
		buffer = newBuffer;
	}

	public void push(T word) {
		if (top == buffer.length - 1) {
			resize();
		}
//		top += 1;
		buffer[++top] = word;
	}

	public T pop() throws MyStackException {
		if (isEmpty()) {
			throw new MyStackException();
		}
		
		T result = buffer[top];
		buffer[top--] = null;
		
		return result;
	}

	public boolean isEmpty() {
		return top == -1;
	}
}