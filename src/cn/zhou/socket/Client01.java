package cn.zhou.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Client01 {

    // 创建客户端
    private Socket s;
    // 指定服务器地址
    private String server = "localhost";
    // 指定服务器端口号
    private Integer port = 9976;
    // 客户端的输出流对应服务器的输入流
    private OutputStream os;

    public Client01() {

        try {
            // 创b.toString()建客户端对象
            s = new Socket(server, port);
            // 创建 客户端的输出流对象
            os = s.getOutputStream();
            byte[] b = new byte[1024];

            System.out.println("please input your message:");
            PrintWriter pw = new PrintWriter(os);


            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String nl = scanner.nextLine();
//                b = nl.getBytes();
                pw.println(scanner.nextLine());
                if(scanner.nextLine().equals("ok")){
                    break;
                }
            }


//不需要关闭输出流，因为关闭输出流的时候客户端也会关闭，反之关闭客户端也会关闭 IO流
//            os.write(b);

            os.close();
            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    abstract class acas {

    }

    public static void main(String[] args) {
        new Client01();
    }
}
