package SocketConCurrency;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 并发Socket编程
 * @author Ben
 */
public class SocketServer {
	
	public static void main(String[] args) throws Exception {
		int port = 3333;
		ServerSocket server = new ServerSocket(port);
		System.out.println("Waiting for connct!");
		
		//-------------------如果发生阻塞，服务器会崩---------------------//
//		while(true) {
//			Socket socket = server.accept();
//			InputStream inputStream = socket.getInputStream();
//			byte[] bytes = new byte[1024];
//			int len;
//			StringBuilder sb = new StringBuilder();
//			while((len=inputStream.read(bytes))!=-1) {
//				sb.append(new String(bytes, 0 , len,"UTF-8"));
//			}
//			System.out.println("get message from client" + sb);
//			inputStream.close();
//			socket.close();
//		}
		//------------------------------------------------------------------//
		
		
		//-----------------------使用线程进行并发------------------------//
		//使用线程池，防止并发过高创建过多线程耗尽资源
		ExecutorService threadPool = Executors.newFixedThreadPool(100);
		while(true) {
			Socket socket = server.accept();
			
			/*
			 * 在Runnable里面写执行的方法
			 * ExecutorServer threadPool = Executors.newFixedThreadPool(100);
			 * Runnable runnable = ()->{
			 * 		.........
			 * }
			 * threadPool.submit(runnable);
			 * */
			
			Runnable runnable = ()->{
				try {
					InputStream inputStream = socket.getInputStream();
					StringBuilder sb = new StringBuilder();
					byte[] bytes = new byte[1024];
					int len;
					while((len = inputStream.read(bytes))!=-1) {
						sb.append(new String(bytes,0,len,"UTF-8"));
					}
					System.out.println("get message from client："+sb);
					inputStream.close();
					socket.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			};
			threadPool.submit(runnable);
		}
		//------------------------------------------------------------------//
		
	}
}
