package prob03;

public abstract class Unit {
	private int x, y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}	
	
	void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	void stop() {
	}
}
