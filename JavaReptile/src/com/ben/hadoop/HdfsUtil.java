package com.ben.hadoop;

import org.junit.Test;

public class HdfsUtil {

	//private static FileSystem fs = null;
	
	static {
		
		try {
			//��������
			//Configuration conf = new Configuration();
			
			//��ֵ
			//conf.set("fs.defaultFS","hdfs://192.168.100.1:8020/");
			
			//ͨ��Api��ȡ����
			//fs = FileSystem.get(new URL("hdfs://192.168.100.1:8020/"),conf,"hdfs");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	/**
	 * HDFS �ļ��ϴ�
	 */
	@Test
	public void FileUpLoad() {
		
		try {
			//fs.copyFromLocalFile(new Path(""), new Path("/arry_2018"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
}
