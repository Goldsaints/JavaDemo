package SocketDemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

	public static void main(String[] args) throws Exception{
		
		//监听端口
		int port = 3333;
		ServerSocket server = new ServerSocket(port);
		
		//server将一直等待连接的到来
		System.out.println("server将一直等待连接的到来");
		Socket socket = server.accept();
		
		//建立链接后，从socket中获取输入流，并建立缓冲区进行读取（接收客户端发送的消息）
		InputStream inputStream = socket.getInputStream();
		byte[] bytes = new byte[1024];
//		int len;
//		StringBuilder sb = new StringBuilder();
//		while((len = inputStream.read(bytes))!=-1) {
//			//注意制定编码格式，发送方和接收方一定要统一，建议使用UTF-8
//			sb.append(new String(bytes,0,len,"UTF-8"));
//		}
//		System.out.println("get message from client : "+sb);
		
		/**
		 * 2个字节表示长度，告诉服务端发送的信息有多长，然后服务端知道接收多长的信息就表示接收完毕
		 * 1个字节：最大256，表示256B
		 * 2个字节：最大65536，表示64K
		 * 3个字节：最大16777216，表示16M
		 * 4个字节：最大4294967296，表示4G
		 */
		while(true) {
			//首先获取前两个字节表示的长度
			int first = inputStream.read();
			//如果读到-1，表示读到流的结尾，socket已经关闭，此时将不能再去读取
			if(first == -1) {
				break;
			}
			int second = inputStream.read();
			int length = (first << 8)+second;
			//然后构造一个指定长的byte数组
			bytes  = new byte[length];
			//然后读取指定长度的消息即可
			inputStream.read(bytes);
			System.out.println("get message from client: "+new String(bytes, "UTF-8"));
		}
		
		//不带发送结束符号的发送信息方法
//		OutputStream outputStream = socket.getOutputStream();
//		outputStream.write("Hello Client! I get the message.".getBytes("UTF-8"));
//		outputStream.close();
		
		
		inputStream.close();
		socket.close();
		server.close();
	}
	
}
