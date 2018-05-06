package SocketDemo;
import java.io.InputStream;
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

//    没有发送完毕标志的发送信息方法
//		socket.getOutputStream().write(message.getBytes("UTF-8"));
		
		/**
		 * 2个字节表示长度，告诉服务端发送的信息有多长，然后服务端知道接收多长的信息就表示接收完毕
		 */
		//计算发送消息的长度
		byte[] sendBytes = message.getBytes("UTF-8");
		System.out.println(sendBytes.length+"--"+(sendBytes.length >> 8));
		outputStream.write(sendBytes.length >> 8);
		outputStream.write(sendBytes.length);
		//然后将信息再次发送出去
		outputStream.write(sendBytes);
		outputStream.flush();
		
		 //==========此处重复发送一次，实际项目中为多个命名，此处只为展示用法
	    message = "the second message!";
	    sendBytes = message.getBytes("UTF-8");
	    outputStream.write(sendBytes.length >>8);
	    outputStream.write(sendBytes.length);
	    outputStream.write(sendBytes);
	    outputStream.flush();
	    
	  //==========此处重复发送一次，实际项目中为多个命名，此处只为展示用法
	    message = "the third message!";
	    sendBytes = message.getBytes("UTF-8");
	    outputStream.write(sendBytes.length >>8);
	    outputStream.write(sendBytes.length);
	    outputStream.write(sendBytes);  
		
//		//通过shutdownOutput高速服务器已经发送完数据，后续只能接受数据
		socket.shutdownOutput();
//		从服务端接收信息	
		InputStream inputStream = socket.getInputStream();
		byte[] bytes =new byte[1024];
		int len ; 		
		StringBuilder sb = new StringBuilder();
		while((len = inputStream.read(bytes))!=-1) {
			sb.append(new String(bytes, 0 , len , "UTF-8"));
		}
		System.out.println("get message from server "+sb);
		
	
		inputStream.close();
		outputStream.close();
		socket.close();
	}
}
