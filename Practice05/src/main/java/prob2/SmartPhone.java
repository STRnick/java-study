package prob2;

public class SmartPhone extends MusicPhone {

	@Override
	public void execute(String function) {
		if ("음악".equals(function)) {
			playMusic();
			return;
		} else if ("통화".equals(function)) {
			super.execute(function);
			return;
		} else {
			app();
		}
	}

	private void app() {
		System.out.println("앱실행");
	}

	@Override
	protected void playMusic() {
		System.out.println("다운로드해서 음악재생");
	}
}
