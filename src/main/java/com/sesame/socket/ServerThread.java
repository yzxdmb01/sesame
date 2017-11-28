package com.sesame.socket;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @Author: yinzhixing
 * @Description: 服务器线程的作用：
 * 1.接收来自客户端的信息
 * 2.将接收的信息解析，并转发给客户端
 * @Date: 2017/11/17 16:25
 */
public class ServerThread implements Runnable {
	//定义处理当前线程的socket
	private Socket socket;
	//该线程所处理的socket所对应的流
	private BufferedReader bufferedReader;

	public ServerThread(Socket socket) throws IOException {
		this.socket = socket;
		bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

	/**
	 * 实现run方法，读客户端的
	 */
	@Override
	public void run() {
		try {
			String content;
			while ((content = bufferedReader.readLine()) != null) {
				System.out.println("B:" + content);
				for (Socket socket : Server.socketList) {
					if (!socket.isConnected()) {
						Server.socketList.remove(socket);
						continue;
					}
					if (socket != this.socket) {
						BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
						bufferedOutputStream.write((content + "\n").getBytes());
						bufferedOutputStream.flush();
					}
				}
			}
			Server.socketList.remove(socket);
			System.out.println("断开连接:" + socket.getInetAddress().getHostAddress());
		} catch (IOException e) {
			System.out.println("断开连接e:" + socket.getInetAddress().getHostAddress());
		}

	}
}
