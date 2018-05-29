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
 * 大数据批量下载文件采集工具类
 * @author Ben
 * @version v1.0
 */

public class DataDownUnit {

	/**
	 * 根据网址和编码集获取网页的源代码
	 * @param url 网址
	 * @param encoding 编码
	 * @return 网页源代码
	 */
	public static String getHTMLResourceUrl(String url,String encoding) {
		
		//存储源代码容器
		StringBuffer buffer = new StringBuffer();
		URL urlObj = null;
		//打开网络连接
		URLConnection uc = null;
		//建立文件写入流
		InputStreamReader isr = null;
		BufferedReader reader = null;
		
		// JVM调优 
		
		try {
			//建立网络连接
			urlObj = new URL(url);
			//打开网络连接
			uc = urlObj.openConnection();
			//建立文件写入流
			isr = new InputStreamReader(uc.getInputStream(), encoding);
			//建立文件缓冲写入流
			reader = new BufferedReader(isr);
			//建立临时变量
			String temp = "";
			while((temp = reader.readLine())!=null) {
				buffer.append(temp+"\n"); //一边读，一边写
			}
		} catch (MalformedInputException e) {
			e.printStackTrace();
			System.out.println("网络失败！");
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("网络异常！");
		}finally {
			if(isr != null) {
				System.out.println("网页连接失败！");
			}
		}
		return buffer.toString();
	}
	
	public static void writeFIleByLine(String context , String fileName) {
		
		//1、创建文件
		File file = new File(fileName);
		PrintWriter writer = null;
		
		try {
			//2、获取输出文件流的对象
			writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file),"utf-8"));
			// 写入文件中
			writer.print(context);
			//刷新同步一次
			writer.flush();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	// java 入口
	public static void main(String[] args) {
		
		
		//1、根据网址和页面的编码值获取网页的源代码
		String url = "http://www.youku.com/";
		String encoding = "utf-8";
		String html = getHTMLResourceUrl(url,encoding);
		System.out.println(html);
		
		//2、文件信息转换为文件
		String pathName = "C:\\Users\\Ben\\Desktop\\MyTest\\youku.html";
		writeFIleByLine(html,pathName);
		
		//3、文件信息上传到分布式文件系统中
		
		
		//4、计算
		
	}

}
