package prob5;

public class MyStack {
	private int top = 0;
	private String[] buffer;
	
	public MyStack(int size) {
		buffer = new String[size];
	}

	private void resize(){
		if(top + 1 == buffer.length){
			String[] newBuffer = new String[buffer.length * 2];
			System.arraycopy(buffer, 0, newBuffer, 0, top+1);
			buffer = newBuffer;
		}
	}

	public void push(String item) {
		resize();
		buffer[++top] = item;		
	}

	public String pop() throws MyStackException{
		if(top == 0){
			throw new MyStackException();
		}
		String item = buffer[top];
		buffer[top] = null;
		top--;
		return item;
	}
	
	public boolean isEmpty() {		
		return (top == 0);
	}
}