package com.gmcc.pboss.common.icode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author tangzhu
 * 6λ�����֤������
 */
public class SixImageArray {
	/**
	 * ��������ļ���·��
	 */
	public static final String path="/projects/gmcc/siximage/arrary.txt";
	/**
	 * �������list�е�λ��
	 */
	public static int sixImagePosition = 5000;
	/**
	 * ���ļ��е���������list��
	 */
	public static List getList() {
		File file=null;
		List list=new ArrayList();
		try {
			file=new File(path);
			BufferedReader br=new BufferedReader(new FileReader(file));
			String readline=null;
			while((readline=br.readLine())!=null) {
				list.add(readline);
			}
			br.close();
		}catch(Exception e) {
			e.printStackTrace();
		} 
		return list;
	}
	/**
	 * ����5000���ڵ�����������������list�е�λ��
	 */
	public static String getString() {
		Random rnd = new Random();	
		List list=getList();
		int RndImg = rnd.nextInt(sixImagePosition);
		String sixNumber = list.get(RndImg).toString();	
		System.out.println("6λ�����֤��=" + sixNumber);
		return sixNumber;
			
	}
}
