package com.gmcc.pboss.common.batch.upload;

import java.io.File;
import java.util.HashMap;

//import jxl.Cell;

/**
 * Title: ��ʽ���ӿ�
 * 
 * @author liminghao
 * @version 1.0
 */
public interface ICheckFormat {

	/**
	 * ����ļ�������,��С,parameterMap��ű���ֵ
	 * 
	 * @param file
	 *            �ļ���
	 * @param parameterMap
	 *            ������
	 */
	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception;

	/**
	 * ����ļ���ÿ������
	 * 
	 * @param line
	 *            �ļ���һ������
	 * @param rowCount
	 *            ��ǰ�ڼ���
	 */
	public void checkLine(String line, int rowCount) throws Exception;

}
