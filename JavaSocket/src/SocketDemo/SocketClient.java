package SocketDemo;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketClient {
	public static void main(String args[]) throws Exception{
		
		String host = "127.0.0.1";
		int port = 3333;
		//�����˽�������
		Socket socket = new Socket(host, port);
		
		//���Ӻ󣬽��������
		OutputStream outputStream = socket.getOutputStream();
		String message = "Hello! ben";

//    û�з�����ϱ�־�ķ�����Ϣ����
//		socket.getOutputStream().write(message.getBytes("UTF-8"));
		
		/**
		 * 2���ֽڱ�ʾ���ȣ����߷���˷��͵���Ϣ�ж೤��Ȼ������֪�����ն೤����Ϣ�ͱ�ʾ�������
		 */
		//���㷢����Ϣ�ĳ���
		byte[] sendBytes = message.getBytes("UTF-8");
		System.out.println(sendBytes.length+"--"+(sendBytes.length >> 8));
		outputStream.write(sendBytes.length >> 8);
		outputStream.write(sendBytes.length);
		//Ȼ����Ϣ�ٴη��ͳ�ȥ
		outputStream.write(sendBytes);
		outputStream.flush();
		
		 //==========�˴��ظ�����һ�Σ�ʵ����Ŀ��Ϊ����������˴�ֻΪչʾ�÷�
	    message = "the second message!";
	    sendBytes = message.getBytes("UTF-8");
	    outputStream.write(sendBytes.length >>8);
	    outputStream.write(sendBytes.length);
	    outputStream.write(sendBytes);
	    outputStream.flush();
	    
	  //==========�˴��ظ�����һ�Σ�ʵ����Ŀ��Ϊ����������˴�ֻΪչʾ�÷�
	    message = "the third message!";
	    sendBytes = message.getBytes("UTF-8");
	    outputStream.write(sendBytes.length >>8);
	    outputStream.write(sendBytes.length);
	    outputStream.write(sendBytes);  
		
//		//ͨ��shutdownOutput���ٷ������Ѿ����������ݣ�����ֻ�ܽ�������
		socket.shutdownOutput();
//		�ӷ���˽�����Ϣ	
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
