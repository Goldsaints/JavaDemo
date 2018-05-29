package com.ben.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.MalformedInputException;

/**
 * ���������������ļ��ɼ�������
 * @author Ben
 * @version v1.0
 */

public class DataDownUnit {

	/**
	 * ������ַ�ͱ��뼯��ȡ��ҳ��Դ����
	 * @param url ��ַ
	 * @param encoding ����
	 * @return ��ҳԴ����
	 */
	public static String getHTMLResourceUrl(String url,String encoding) {
		
		//�洢Դ��������
		StringBuffer buffer = new StringBuffer();
		URL urlObj = null;
		//����������
		URLConnection uc = null;
		//�����ļ�д����
		InputStreamReader isr = null;
		BufferedReader reader = null;
		
		// JVM���� 
		
		try {
			//������������
			urlObj = new URL(url);
			//����������
			uc = urlObj.openConnection();
			//�����ļ�д����
			isr = new InputStreamReader(uc.getInputStream(), encoding);
			//�����ļ�����д����
			reader = new BufferedReader(isr);
			//������ʱ����
			String temp = "";
			while((temp = reader.readLine())!=null) {
				buffer.append(temp+"\n"); //һ�߶���һ��д
			}
		} catch (MalformedInputException e) {
			e.printStackTrace();
			System.out.println("����ʧ�ܣ�");
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("�����쳣��");
		}finally {
			if(isr != null) {
				System.out.println("��ҳ����ʧ�ܣ�");
			}
		}
		return buffer.toString();
	}
	
	public static void writeFIleByLine(String context , String fileName) {
		
		//1�������ļ�
		File file = new File(fileName);
		PrintWriter writer = null;
		
		try {
			//2����ȡ����ļ����Ķ���
			writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file),"utf-8"));
			// д���ļ���
			writer.print(context);
			//ˢ��ͬ��һ��
			writer.flush();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	// java ���
	public static void main(String[] args) {
		
		
		//1��������ַ��ҳ��ı���ֵ��ȡ��ҳ��Դ����
		String url = "http://www.youku.com/";
		String encoding = "utf-8";
		String html = getHTMLResourceUrl(url,encoding);
		System.out.println(html);
		
		//2���ļ���Ϣת��Ϊ�ļ�
		String pathName = "C:\\Users\\Ben\\Desktop\\MyTest\\youku.html";
		writeFIleByLine(html,pathName);
		
		//3���ļ���Ϣ�ϴ����ֲ�ʽ�ļ�ϵͳ��
		
		
		//4������
		
	}

}
