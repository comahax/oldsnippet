package com.common.util.file;

import java.io.File;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * 描述：
 * 		文件操作工具类
 */
public class FileUtil {
	/**
	 * 根据路径删除路径，文件不存在也返回true
	 * @param path	文件路径
	 */
	public static boolean deleteFileByPath(String path){
		boolean isSuccess = false;
		
		File file = new File(path);
		
		if(file.exists()){
			isSuccess = file.delete();
		}
		else{
			isSuccess = true;
		}
		
		return isSuccess;
	}
}
