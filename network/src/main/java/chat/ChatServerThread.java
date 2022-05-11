package chat;

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
	private String nickname;
	private Socket socket;
	List<Writer> listWriters;

	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}

	@Override
	public void run() {
		try {
			// 1. Remote Host Information
			InetSocketAddress inetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			String remoteHostAddress = inetSocketAddress.getAddress().getHostAddress();
			int remoteHostPort = inetSocketAddress.getPort();
			ChatServer.log("conneted by client[" + remoteHostAddress + ":" + remoteHostPort + "]");

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
					doMessage(tokens[1], printWriter);
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

		// ack
		writer.println("채팅방에 입장했습니다. (" + nickname + ")님!");
		writer.flush();
		
		String data = nickname + "님이 참여하였습니다! 모두 환영해주세요~^^";
		broadcast(data);

		/* writer pool에 저장 */
		addWriter(writer);

		
	}

	private void doMessage(String data, PrintWriter printWriter) {
		broadcast(nickname + ":" + data);
		System.out.println(nickname + "발신");
	}

	private void doQuit(Writer writer) {
		String data = nickname + "님이 퇴장했습니다.";
		removeWriter(writer);
		broadcast(data);
	}

	private void addWriter(Writer writer) {
		synchronized (listWriters) {
			listWriters.add(writer);
		}
	}

	private void removeWriter(Writer writer) {
		synchronized (listWriters) {
			listWriters.remove(writer);
		}
	}

	private void broadcast(String data) {
		synchronized (listWriters) {
			for (Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter) writer;
				printWriter.println(data);
				printWriter.flush();
			}
		}
	}

	private void log(String log) {
		System.out.println("[ChatServerThread] " + log);
	}
}
