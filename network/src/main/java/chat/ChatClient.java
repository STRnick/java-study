package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "192.168.56.1";
	private static final int SERVER_PORT = 6666;

	public static void main(String[] args) {
		/*
		 * 닉네임 받기 nextline 받고 소켓 열고 연결 enter NICKNAME\n (스레드 안에 닉네임 기억) enter ok 확인
		 * (스레드에서 확인) 쓰는 스레드 소켓 "meassage ㅎㅇ\n" 응답 설계 Printer Writer 생성해서 List 공유 quit에
		 * 퇴장 Base 64 encode decode
		 */
		Scanner scanner = null;
		Socket socket = null;
		try {
			// 1. 키보드 연결
			scanner = new Scanner(System.in);

			// 2. socket 생성
			socket = new Socket();
			socket.setReuseAddress(true);

			// 3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));

			// 4. reader/writer 생성
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
	
			// 5. join 프로토콜
			System.out.print("닉네임>> ");
			String nickname = scanner.nextLine();
			
			printWriter.println("join:" + nickname);
			printWriter.flush();

			// 6. ChatClientReceiveThread 시작
			new ChatClientThread(socket).start();

			// 7. 키보드 입력 처리
			while (true) {
				System.out.print(">>");
				String input = scanner.nextLine();

				if ("quit".equals(input) == true) {
					// 8. quit 프로토콜 처리
					break;
				} else {
					// 9. 메시지 처리
					
				}
			}
		} catch (IOException ex) {
			log("error:" + ex);
		} finally {
			// 10. 자원정리
			scanner.close();
		}

	}

	private static void log(String log) {
		System.out.println(log);
	}
}
