package com.ben.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * ����ɾ��List
 * @author Ben
 *
 */
public class DeleteList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> list =new ArrayList<>(Arrays.asList("a1","a2","b1","b2"));
		
		/**
		 * ite.remove();��д�� list.remove();���ͻᱨ��ConcurrentModificationException����
		 * Iterator ȡ��һ��Ԫ�ص�ʱ�򣬻��⵱ǰ�޸ĵ�ֵ�Ƿ���Ԥ���޸ĵ�ֵ�Ǻϣ�
		 * ite��remove�������Զ�ͬ����ǰ�޸ĵ�ֵ��Ԥ���޸ĵ�ֵ��
		 * list��remove������û���Զ�ͬ������
		 */
		//ʹ�õ�����ɾ��
		for(Iterator<String> ite = list.iterator();ite.hasNext();) {
			String str = ite.next();
			if(str.contains("b")) {
				ite.remove();
			}
		}
		
		//����ʹ���������ɾ��
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
