package chat.gui;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ChatClientApp {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 9999;

	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);

		while (true) {

			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();

			if (name.isEmpty() == false) {
				break;
			}

			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}

		scanner.close();

		// 1. create socket
		Socket socket = new Socket();
		// 2. connect server
		try {
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			consoleLog("채팅방에 입장하였습니다.");
			new ChatWindow(name, socket).show();

//			// 3. get io stream(pipline established)
//			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
//			
//			// 4. join protocol 처리
			String request = "join:" + name + "\r\n";
			pw.println(request);
			
//			// pw.println("join:둘리");
//			printWriter.println(request);
//			String line = "JOIN:OK";
//			if ("JOIN:OK".equals(line)) {
//				new ChatWindow(name, socket, bufferedReader, printWriter).show();
//			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void consoleLog(String log) {
		System.out.println(log);		
	}
}
