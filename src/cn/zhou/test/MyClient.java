package cn.zhou.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MyClient extends Thread {

	// 所请求的服务器的ip地址
	private static String serverIp = "127.0.0.1";
	// 定义客户端端口号
	private static int serverPort = 8001;
	// 客户端
	private Socket clientsSocket;
	// 客户端的输出流，用于传输数据
	private PrintWriter pw;
	// 为了提高字符流读写的效率，引入了缓冲机制,加快写入的速度
	private BufferedReader br;

	// 无参构造器,初始化客户端信息
	public MyClient() {
		try {
			// 创建客户端对象
			clientsSocket = new Socket(serverIp, serverPort);
			// 创建客户端的输出流 public PrintWriter(Writer out,boolean autoFlush)
			// 创建新 PrintWriter。 autoFlush 如果为 true，
			// 则 println、printf 或 format 方法将刷新输出缓冲区
			pw = new PrintWriter(clientsSocket.getOutputStream(), true);

			// 包装客户端的输入流提升效率
			br = new BufferedReader(new InputStreamReader(clientsSocket.getInputStream()));

			// 获取服务器返回的信息
			new readServer();

			while (true) {
				// 读入控制台的内容
				br = new BufferedReader(new InputStreamReader(System.in));
				String input = br.readLine();
				// System.out.println("this is the input :" + input);
				// 通过客户端的输出流传输控制台传入的内容
				pw.println(input);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 内部类继承多线程,获取服务器返回的信息
	class readServer extends Thread {
		// 包装输入流
		private BufferedReader reader;

		public readServer() {
			try {
				// 创建客户端的输入流（读）
				reader = new BufferedReader(new InputStreamReader(clientsSocket.getInputStream()));

				// 启动线程
				start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void run() {
			try {
				while (true) {
					// 接受服务器返回的信息
					String content = reader.readLine();
					// 如果是 exit则断开链接
					if (content.equals("exit")) {
						break;
					} else {
						// 打印服务器返回的信息
						System.out.println(content);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		new MyClient();
	}
}
