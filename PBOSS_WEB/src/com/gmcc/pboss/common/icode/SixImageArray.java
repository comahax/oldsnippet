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
 * 6位随机验证码生成
 */
public class SixImageArray {
	/**
	 * 随机码存放文件的路径
	 */
	public static final String path="/projects/gmcc/siximage/arrary.txt";
	/**
	 * 随机码在list中的位置
	 */
	public static int sixImagePosition = 5000;
	/**
	 * 将文件中的随机码放入list中
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
	 * 产生5000以内的随机数代表随机数在list中的位置
	 */
	public static String getString() {
		Random rnd = new Random();	
		List list=getList();
		int RndImg = rnd.nextInt(sixImagePosition);
		String sixNumber = list.get(RndImg).toString();	
		System.out.println("6位随机验证码=" + sixNumber);
		return sixNumber;
			
	}
}
