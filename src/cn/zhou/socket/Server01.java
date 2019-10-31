package cn.zhou.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server01 {

	// 服务器对象
	private ServerSocket ss;
	// 服务器监听端口
	private Integer port = 9976;
	// 服务器的输入流对应客户端的输出流
	private InputStream inputStream = null;

	public Server01() {
		try {

			ss = new ServerSocket(port);
			if (ss != null) {
				System.out.println("the server " + ss.getInetAddress() + "\t is starting");
			}

			// 接收客户端请求
			// 接收请求，接收到一个客户端
			Socket socket = ss.accept();
			inputStream = socket.getInputStream();

			System.out.println("the client " + socket.getInetAddress() + "\t is connected!!!");

			// 接收客户端信息
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			System.out.println("打印从客户端接收到的信息:");

			String str = null;
			StringBuilder sb = new StringBuilder();
			while ((str = br.readLine()) != null & "ok".equals(br.readLine())) {// !socket.isClosed() &
				sb.append(br.readLine());
			}

			System.out.println(sb.toString());

			inputStream.close();
			socket.close();
			ss.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Server01();
	}
}
