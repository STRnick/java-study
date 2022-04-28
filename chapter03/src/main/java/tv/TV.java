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
//		volume(volume += (up ? 1 : -1));
		if(up) {
			volume += 1;
		} else if(!up){
			volume -= 1;
		} else {
		}
	}
	
	public void volume(int volume) {
		this.volume= volume;
		if(volume>=0 || volume<=100) {
			volume(true);
		} else {
		}
//		로테이션 알고리즘 구현
	}
	
	public void channel(boolean up) {
//		volume(volume += (up ? 1 : -1));
		if(up) {
			channel += 1;
		} else if(!up){
			channel -= 1;
		} else {
			channel = channel;
		}
	}
	
	public void channel(int channel) {
		this.channel= channel;
		if(channel>=0 || channel<=255) {
			channel(true);
		} else {
			channel = channel;
		}
//		로테이션 알고리즘 구현
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
