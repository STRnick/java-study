package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int PORT = 9999;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		List<Writer> listWriters = new ArrayList<Writer>();

		try {
			// 1. 서버 소겟 생성
			serverSocket = new ServerSocket();

			// 2. 바인딩
//			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress(SERVER_IP, PORT));
			log("연결 기다림 " + SERVER_IP + ":" + PORT);

			// 3. 요청 대기
			while (true) {
				Socket socket = serverSocket.accept();
				ChatServerThread cst = new ChatServerThread(socket, listWriters);
				cst.start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				System.out.println("[ChatServerError] " + e);
			}
		}
	}

	public static void log(String log) {
		System.out.println("[ChatServer] " + log);
	}

}
