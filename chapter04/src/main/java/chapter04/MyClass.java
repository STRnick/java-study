package chapter04;

public class MyClass {
	// Singleton 예제
	private static MyClass instance = null;
	
	private MyClass() {

	}
	public static MyClass getInstance() {
		if (instance == null) {
			instance = new MyClass();
		}
		return instance;
	}

}
