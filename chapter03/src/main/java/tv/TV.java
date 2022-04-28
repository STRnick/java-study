package tv;

public class TV {
	private int channel; // 0 ~ 255 rotation
	private int volume; // 0 ~ 100 rotation
	private boolean power;
	
	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}

	public void volume(boolean up) {
		volume(volume += (up ? 1 : -1));
	}
	
	public void volume(int volume) {
		if(!power) {
			return;
		}
		if(volume < 0) {
			volume = 0;
		} else if(volume > 100){
			volume = 100;
		}
		this.volume = volume;
//		로테이션 알고리즘 구현
	}
	
	public void channel(boolean up) {
		channel(channel + (up ? 1 : -1));
	}

	public void channel(int channel) {
		if(!power) {
			return;
		}
		if(channel < 0) {
			channel = 0;
		} else if(channel > 255){
			channel = 255;
		}
		this.channel = channel;
	}
	
	public void power(boolean power) {
		this.power = power;
	}
	
	public void status() {
		System.out.println(
			"TV[channel=" + channel +
			", volume=" + volume + 
			", power=" + (power ? "on" : "off"));
	}
}
