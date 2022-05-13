package chat.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ChatServerThread extends Thread {
	private String nickname = null;
	private Socket socket = null;
	List<PrintWriter> listWriters = null;

	public ChatServerThread(Socket socket, List<PrintWriter> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}

	@Override
	public void run() {
		try {
			// 1. Remote Host Information
//			InetSocketAddress inetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
//			String remoteHostAddress = inetSocketAddress.getAddress().getHostAddress();
//			int remoteHostPort = inetSocketAddress.getPort();
//			ChatServer.log("conneted by client[" + remoteHostAddress + ":" + remoteHostPort + "]");

			// 2. 스트림 얻기
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			PrintWriter printWriter = new PrintWriter(
					new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);

			// 3. 요청 처리
			while (true) {
				String request = bufferedReader.readLine();

				if (request == null) {
					log("클라이언트로 부터 연결 끊김");
					doQuit(printWriter);
					break;
				}

				// 4. 프로토콜 분석
				String[] tokens = request.split(":");

				if ("join".equals(tokens[0])) {
					doJoin(tokens[1], printWriter);
				} else if ("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				} else if ("quit".equals(tokens[0])) {
					doQuit(printWriter);
				} else {
					ChatServer.log("에러: 알수 없는 요청(" + tokens[0] + ")");
				}
			}
		} catch (IOException e) {
			System.out.println("[ChatServerThreadError] " + e);
		}
	}

	private void doJoin(String nickname, PrintWriter writer) {
		this.nickname = nickname;

		String data = nickname + "님이 입장하였습니다.";
		broadcast(data);

		// writer pool에 저장
		addWriter(writer);
	}

	private void doMessage(String data) {
		broadcast(nickname + ":" + data);
	}

	private void doQuit(PrintWriter writer) {
		removeWriter(writer);
		String data = nickname + "님이 퇴장했습니다.";
		broadcast(data);
	}

	private void addWriter(PrintWriter writer) {
		synchronized (listWriters) {
			listWriters.add(writer);
		}
	}

	private void removeWriter(PrintWriter writer) {
		synchronized (listWriters) {
			listWriters.remove(writer);
		}
	}

	private void broadcast(String data) {
		synchronized (listWriters) {
			for (PrintWriter writer : listWriters) {
				writer.println(data);
				writer.flush();
			}
		}
	}

	private void log(String log) {
		System.out.println("[ChatServerThread] " + log);
	}
}
