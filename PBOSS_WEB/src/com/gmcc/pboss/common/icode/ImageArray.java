package com.gmcc.pboss.common.icode;

/**
 * 此处插入类型描述。
 * 创建日期：(2005-7-7 22:42:37)
 * @author：Administrator
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.gmcc.pboss.common.config.ConfigUtil;
import com.gmcc.pboss.common.dictionary.CommonConfig;
import com.gmcc.pboss.common.dictionary.FileDictionary;
import com.gmcc.pboss.common.config.FileConfigAdapter;


 
public class ImageArray {
	
//   public static final int maxSize = 100;
//   public static final int maxSize = 99;   
	
	private static List list = null;

	private static long modifiedTime = 0;// 最后修改时间

	public static List getList() {
		File file = null;
		try {
			String path = FileConfigAdapter.getImagePath() + "arrary.txt";;
			file = new File(path);
			long lastModifiedTime = file.lastModified();
			if (lastModifiedTime != modifiedTime || list == null||list.size()==0) {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String readline = null;
				list = new ArrayList();
				while ((readline = br.readLine()) != null) {
					list.add(readline);
				}
				modifiedTime = lastModifiedTime;
				br.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
/**
 * ImageArray 构造子注解。
 */
private ImageArray() {
  
}
/**
 * 此处插入方法描述。
 * 创建日期：(2005-7-7 22:45:53)
 * @return int
 */ 
public static String getString() {

	Random rnd = new Random();	
	List list = getList();
	int maxSize = Integer.parseInt(ConfigUtil.getCommonConfig(FileDictionary.COMMON_NAME, 
      		      		           CommonConfig.ICODE_SIZE));
	int RndImg = rnd.nextInt(maxSize);
	return list.get(RndImg).toString();	
		
}


/**
 * 此处插入方法描述。
 * 创建日期：(2005-7-7 22:54:39)
 * @param args java.lang.String[]
 */
public static void main(String[] args) 
{ 
	String i="";
	int maxSize = Integer.parseInt(ConfigUtil.getCommonConfig(FileDictionary.COMMON_NAME, 
		           CommonConfig.ICODE_SIZE));
    for(int j=0; j<maxSize; j++){
	 i = getString();
	 System.out.println("i=" + i);
	}
}
}
