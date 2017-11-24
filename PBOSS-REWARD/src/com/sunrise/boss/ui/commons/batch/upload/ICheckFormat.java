package com.sunrise.boss.ui.commons.batch.upload;

import java.util.HashMap;

import jxl.Cell;

import org.apache.struts.upload.FormFile;

import com.sunrise.boss.ui.commons.User;

/**
 * Title: ��ʽ���ӿ�
 * @author liminghao
 * @version 1.0
 */
public interface ICheckFormat {

    /**
     * ����ļ�������,��С,parameterMap��ű���ֵ
     * @param file �ļ���
     * @param parameterMap ������
     */
	public void checkFile(FormFile file,HashMap parameterMap) throws Exception;
    
	/**
     * ����ļ���ÿ������
     * @param line �ļ���һ������
     * @param rowCount ��ǰ�ڼ���
     */
	public void checkLine(String line,int rowCount) throws Exception;
	
}
