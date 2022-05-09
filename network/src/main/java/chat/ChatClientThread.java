package chat;

import java.io.BufferedReader;

public class ChatClientThread extends Thread {
	private BufferedReader bufferedReader;

	public ChatClientThread(BufferedReader bufferedReader) {
		this.bufferedReader = bufferedReader;
	}

	@Override
	public void run() {
		try {
			while (bufferedReader.readLine() != null) {
				System.out.println(bufferedReader.readLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
