package com.gmcc.pboss.common.batch.upload;

import java.io.File;
import java.util.HashMap;

import com.sunrise.jop.ui.User;

//import jxl.Cell;

/**
 * ��ʽ�����,��ʽ���������Լ̳и���,����ʵ��ICheckFormat�ӿ�
 * 
 * @author liminghao
 * 
 */
public class BaseCheckFormat implements ICheckFormat {
	/**
	 * @param file
	 *            �ļ���
	 * @param parameterMap
	 *            ������
	 */
	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {

	}

	/**
	 * @param line
	 *            �ļ���һ������
	 * @param rowCount
	 *            ��ǰ�ڼ���
	 */
	public void checkLine(String line, int rowCount) throws Exception {

	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		// TODO Auto-generated method stub

	}

	public void checkLine(String line, int rowCount, boolean iscustom, User user)
			throws Exception {
		// TODO Auto-generated method stub

	}
	// public void checkLine(Cell[] cell, int count)throws Exception{
	//		
	// }

}
