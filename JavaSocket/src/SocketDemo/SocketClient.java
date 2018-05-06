package SocketDemo;
import java.io.OutputStream;
import java.net.Socket;

public class SocketClient {
	public static void main(String args[]) throws Exception{
		
		String host = "127.0.0.1";
		int port = 3333;
		//与服务端建立连接
		Socket socket = new Socket(host, port);
		//连接后，接收输出流
		OutputStream outputStream = socket.getOutputStream();
		String message = "Hello! ben";
		socket.getOutputStream().write(message.getBytes("UTF-8"));
		outputStream.close();
		socket.close();
	}
}
