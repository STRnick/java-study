package tv;

public class TV {
	private int channel; // 0 ~ 255 rotation
	private int volume; // 0 ~ 100 rotation
	private boolean power;
	
	public TV(int channel, int volume, boolean power) {
		
	}

	public void volume(boolean up) {
//		volume(volume += (up ? 1 : -1));
		if(up) {
			volume += 1;
		} else {
			volume -= 1;
		}
	}
	
	public void volume(int volume) {
		this.volume= volume;
		if(volume<0) {
			volume = 0;
		} else if(volume>100) {
			volume = 100;
		}
//		로테이션 알고리즘 구현
	}
	
	public void status() {
		System.out.println(
			"TV[channel=" + channel +
			", volume=" + volume + 
			", power=" + (power ? "on" : "off"));
	}

	public void power(boolean power) {
//		power=(power ? on : off);	
	}
}
