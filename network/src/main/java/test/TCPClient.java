package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

public class TCPClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 5555;

	public static void main(String[] args) {
		Socket socket = null;

		try {
			// 1. 소켓 생성
			socket = new Socket();
			// 1-1. 소켓 버퍼 사이즈 확인
			int rcvBufferSize = socket.getReceiveBufferSize();
			int sndBufferSize = socket.getSendBufferSize();
			System.out.println(rcvBufferSize + ":" + sndBufferSize);

			// 1-2. 소켓 버퍼 사이즈 변경
			socket.setReceiveBufferSize(1024 * 10);
			socket.setSendBufferSize(1024 * 10);

			// 1-3. SO_NODELAY(Nagle Algorithm off)
			socket.setTcpNoDelay(true);

			// 1-4. SO_TIMEOUT
//			socket.setSoTimeout(1000);
			socket.setSoTimeout(3000);

			// 2. 서버 연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));

			// 3. IO Stream 받아오기
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			// 4. 쓰기
			String data = "Hello World!";
			os.write(data.getBytes("utf-8"));

			// 5. 읽기
			byte[] buffer = new byte[256];
			int readByteCount = is.read(buffer);
			if (readByteCount == -1) {
				System.out.println("[client] closed by server");
				return;
			}

			data = new String(buffer, 0, readByteCount, "utf-8");
			System.out.println("[client] received: " + data);
		} catch (SocketTimeoutException ex) {
			System.out.println("[client] time out!");
		} catch (SocketException ex) {
			System.out.println("[client] suddenly closed by server");
		} catch (IOException e) {
			System.out.println("[client] error: " + e);
		} finally {
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}
}