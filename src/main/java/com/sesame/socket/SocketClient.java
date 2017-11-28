package com.sesame.socket;

import com.sesame.utils.L;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author: yinzhixing
 * @Description: 一个Socket客户端
 * @Date: 2017/11/28 10:50
 */
public class SocketClient {
	private Socket socket;
	private static final String IP = "192.168.1.126";
	private static final int SOCKET_PORT = 50000;


	/**
	 * 开启一个socket连接
	 */
	private void startSocket() {
		try {
			socket = new Socket(IP, SOCKET_PORT);
			L.i("连上了！！！");
			//必须要在新线程中开启，因为会阻塞线程的
			new Thread(() -> startSendMsg()).start();
			new Thread(() -> startGetMsg()).start();
		} catch (
				IOException e)

		{
			e.printStackTrace();
			L.i("连接失败：" + e.getMessage());
		}
	}

	/**
	 * 处理接收数据的流
	 *
	 * @throws IOException
	 */
	private void startGetMsg() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			L.i("ready to input");
			String content;
			while ((content = br.readLine()) != null) {
				System.out.println("对方：" + content);
			}
		} catch (IOException e) {
			L.i("this is input stream and encounter an IOException:" + e.getMessage());
		}
	}

	/**
	 * 处理发送数据的流
	 *
	 * @throws IOException
	 */
	private void startSendMsg() {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			L.i("ready to output");
			while (socket.isConnected()) {
				Scanner scanner = new Scanner(System.in);
				String msg = scanner.nextLine();
				bw.write(msg + "\n");
				bw.flush();
			}
		} catch (IOException e) {
			L.i("this is output stream and encounter an IOException:" + e.getMessage());
		}
	}

	public static void main(String[] args) {
		SocketClient sc = new SocketClient();
		sc.startSocket();
	}

}
