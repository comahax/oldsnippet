package com.sunrise.boss.ui.commons.batch.upload;

import java.util.HashMap;

import jxl.Cell;

import org.apache.struts.upload.FormFile;

import com.sunrise.boss.ui.commons.User;
/**
 * ��ʽ�����,��ʽ���������Լ̳и���,����ʵ��ICheckFormat�ӿ�
 * @author liminghao
 *
 */
public class BaseCheckFormat implements ICheckFormat{
    /**
     * @param file �ļ���
     * @param parameterMap ������
     */
	public void checkFile(FormFile file,HashMap parameterMap) throws Exception {

	}
    /**
     * @param line �ļ���һ������
     * @param rowCount ��ǰ�ڼ���
     */
	public void checkLine(String line, int rowCount) throws Exception {
		
		
	}
	public void checkLine(String line, int rowCount, User user) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public void checkLine(String line, int rowCount,boolean iscustom, User user) throws Exception {
		// TODO Auto-generated method stub
		
	}
	public void checkLine(Cell[] cell, int count)throws Exception{
		
	}
	
}
