package prob05;

public class MyBase extends Base {
	public class Base {
		public void service(String state) {
			if (state.equals("낮")) {
				day();
			} else {
				night();
			}
		}

		public void day() {
			System.out.println("낮");
		}

		public void night() {
			System.out.println("night");
		}
		
		public void afternoon() {
			System.out.println("오후");
		}
	}

}
