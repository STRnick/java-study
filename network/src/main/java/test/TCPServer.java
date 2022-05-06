package test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;

		try {
			// 1. 서버 소켓 생성
			serverSocket = new ServerSocket();

			// 2. 바인딩(binding)
			// Socket에 InetSocketAddress(IP Address + Prot)를 바인딩한다.
			// IPAddress(0.0.0.0) : 특정 호스트 IP를 바인딩 하지 않는다.
			// backlog : 요청 queue(10)
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 5555));

			// 3. accept
			// 클라이언트로 부터 요청을 기다린다.
			Socket socket = serverSocket.accept(); // blocking

			InetSocketAddress inetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			String remoteHostAddress = inetSocketAddress.getAddress().getHostAddress();
			int remoteHostPort = inetSocketAddress.getPort();

			System.out.println("[server] conneted by client[" + remoteHostAddress + ":" + +remoteHostPort + "]");

		} catch (IOException e) {
			System.out.println("[server] error: " + e);
		} finally {
			try {
				if (serverSocket != null && serverSocket.isClosed() == false) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
