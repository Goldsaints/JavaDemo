package com.ben.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 批量删除List
 * @author Ben
 *
 */
public class DeleteList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> list =new ArrayList<>(Arrays.asList("a1","a2","b1","b2"));
		
		/**
		 * ite.remove();，写成 list.remove();，就会报错ConcurrentModificationException错误，
		 * Iterator 取下一个元素的时候，会检测当前修改的值是否与预期修改的值吻合，
		 * ite的remove方法会自动同步当前修改的值和预期修改的值，
		 * list的remove方法是没有自动同步功能
		 */
		//使用迭代器删除
		for(Iterator<String> ite = list.iterator();ite.hasNext();) {
			String str = ite.next();
			if(str.contains("b")) {
				ite.remove();
			}
		}
		
		//或者使用逆向遍历删除
//		int size = list.size()-1;
//		for(int i =size  ;i>0;i--) {
//			String str = list.get(i);
//			if(str.contains("b")) {
//				list.remove(i);
//			}
//		}
		System.out.println("list="+list.toString());
		
	}

}
