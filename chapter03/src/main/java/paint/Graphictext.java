package paint;

public class Graphictext implements Drawable {

	private String text;

	public Graphictext(String text) {
		this.text = text;
	}

	@Override
	public void draw() {
		System.out.println(text + "를 그렸습니다.");

	}

}
