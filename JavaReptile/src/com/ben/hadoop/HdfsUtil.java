package com.ben.hadoop;

import org.junit.Test;

public class HdfsUtil {

	//private static FileSystem fs = null;
	
	static {
		
		try {
			//声明配置
			//Configuration conf = new Configuration();
			
			//赋值
			//conf.set("fs.defaultFS","hdfs://192.168.100.1:8020/");
			
			//通过Api读取数据
			//fs = FileSystem.get(new URL("hdfs://192.168.100.1:8020/"),conf,"hdfs");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	/**
	 * HDFS 文件上传
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
