package cn.zhou.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;

public class MyServer {

	// 服务器端口号
	private static int port = 8001;
	//
	private static boolean prit = false;
	// 用户集合
	private static ArrayList<String> userList = new ArrayList<>();
	// 消息
	private static LinkedList<String> messageList = new LinkedList<>();
	// 多线程
	private static ArrayList<ServerThread> threadsList = new ArrayList<>();

	// 服务器对象
	private ServerSocket serverSocket;

	public MyServer() {
		try {
			// 创建服务器对象，并设置监听端口号 8001
			serverSocket = new ServerSocket(port);
			new PrintClient();

			while (true) {
				// 接受客户端连接
				Socket socket = serverSocket.accept();
				// 创建服务器多线程对象
				new ServerThread(socket);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 打印客户端信息
	class PrintClient extends Thread {

		public PrintClient() {
			// 创建对象时启动多线程
			start();
		}

		public void run() {
			while (true) {
				try {
					// 睡眠１０秒
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
				//
				if (prit == true) {
					String msg = messageList.getFirst();
					// System.out.println("prepare to sent to Clent");
					for (ServerThread sThread : threadsList) {
						sThread.sendMessage(msg);
					}
					synchronized (messageList) {
						messageList.removeFirst();
					}
					prit = messageList.size() > 0 ? true : false;
				}
			}
		}
	}

	class ServerThread extends Thread {
		private Socket client;
		private PrintWriter pw;
		private BufferedReader br;
		private String user;

		public ServerThread(Socket socket) {
			try {
				client = socket;
				pw = new PrintWriter(client.getOutputStream(), true);
				br = new BufferedReader(new InputStreamReader(client.getInputStream()));
				br.readLine();

				pw.println("connect success input your name ~");
				start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void pushMessage(String msg) {
			synchronized (messageList) {
				messageList.add(msg);
			}
			prit = true;
		}

		public void sendMessage(String msg) {
			pw.println(msg);
		}

		public void run() {
			try {
				int first = 1;
				String msg = br.readLine();
				while (!msg.equals("bye")) {
					if (first == 1) {
						user = msg;
						userList.add(user);
						threadsList.add(this);
						pw.println(user + " hello you can chat now ");
						this.pushMessage("Client <" + user + "> " + "join in ~");
						// System.out.println("the prit is " + prit);
						first--;
					} else {
						this.pushMessage("Client<" + user + "> " + "say :" + msg);
						// System.out.println("the prit is " + prit + " " + messageList.size());
					}
					msg = br.readLine();
					// System.out.println(msg);
				}
				pw.println("bye Client");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					client.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				threadsList.remove(this);
				userList.remove(user);
				pushMessage(user + " leave ~");
			}
		}
	}

	public static void main(String[] srgs) throws Exception {
		new MyServer();
	}
}
