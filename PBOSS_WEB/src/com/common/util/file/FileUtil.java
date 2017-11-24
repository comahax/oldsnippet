package com.common.util.file;

import java.io.File;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * ������
 * 		�ļ�����������
 */
public class FileUtil {
	/**
	 * ����·��ɾ��·�����ļ�������Ҳ����true
	 * @param path	�ļ�·��
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
