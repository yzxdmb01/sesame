package com.sesame.socket;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @Author: yinzhixing
 * @Description: socket Server
 * @Date: 2017/11/17 16:21
 */
public class Server {
	private static final int SOCKET_PORT = 50000;
	public static ArrayList<Socket> socketList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		Server server = new Server();
		server.initServer();
	}

	public void initServer() {
		try {
			ServerSocket serverSocket = new ServerSocket(SOCKET_PORT);
			System.out.println("服务已打开");
			while (true) {
				//每当接收到一个socket请求，服务端也创建一个socket
				Socket socket = serverSocket.accept();
				System.out.println("来了！！！！:" + socket.getInetAddress());
				socketList.add(socket);
				BufferedOutputStream outputStream = new BufferedOutputStream(socket.getOutputStream());
				String ip = socket.getInetAddress().getHostAddress();
				outputStream.write(("欢迎你:" + ip + "\n").getBytes());
				outputStream.flush();
				new Thread(new ServerThread(socket)).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("端口号被占用了？");
		}
	}


}
