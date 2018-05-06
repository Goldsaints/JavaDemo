package SocketDemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

	public static void main(String[] args) throws Exception{
		
		//�����˿�
		int port = 3333;
		ServerSocket server = new ServerSocket(port);
		
		//server��һֱ�ȴ����ӵĵ���
		System.out.println("server��һֱ�ȴ����ӵĵ���");
		Socket socket = server.accept();
		
		//�������Ӻ󣬴�socket�л�ȡ�����������������������ж�ȡ�����տͻ��˷��͵���Ϣ��
		InputStream inputStream = socket.getInputStream();
		byte[] bytes = new byte[1024];
//		int len;
//		StringBuilder sb = new StringBuilder();
//		while((len = inputStream.read(bytes))!=-1) {
//			//ע���ƶ������ʽ�����ͷ��ͽ��շ�һ��Ҫͳһ������ʹ��UTF-8
//			sb.append(new String(bytes,0,len,"UTF-8"));
//		}
//		System.out.println("get message from client : "+sb);
		
		/**
		 * 2���ֽڱ�ʾ���ȣ����߷���˷��͵���Ϣ�ж೤��Ȼ������֪�����ն೤����Ϣ�ͱ�ʾ�������
		 * 1���ֽڣ����256����ʾ256B
		 * 2���ֽڣ����65536����ʾ64K
		 * 3���ֽڣ����16777216����ʾ16M
		 * 4���ֽڣ����4294967296����ʾ4G
		 */
		while(true) {
			//���Ȼ�ȡǰ�����ֽڱ�ʾ�ĳ���
			int first = inputStream.read();
			//�������-1����ʾ�������Ľ�β��socket�Ѿ��رգ���ʱ��������ȥ��ȡ
			if(first == -1) {
				break;
			}
			int second = inputStream.read();
			int length = (first << 8)+second;
			//Ȼ����һ��ָ������byte����
			bytes  = new byte[length];
			//Ȼ���ȡָ�����ȵ���Ϣ����
			inputStream.read(bytes);
			System.out.println("get message from client: "+new String(bytes, "UTF-8"));
		}
		
		//�������ͽ������ŵķ�����Ϣ����
//		OutputStream outputStream = socket.getOutputStream();
//		outputStream.write("Hello Client! I get the message.".getBytes("UTF-8"));
//		outputStream.close();
		
		
		inputStream.close();
		socket.close();
		server.close();
	}
	
}
