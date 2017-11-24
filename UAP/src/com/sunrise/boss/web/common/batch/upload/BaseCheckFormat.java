package com.sunrise.boss.web.common.batch.upload;

import com.sunrise.jop.ui.User;

import jxl.Cell;

/**
 * 格式检查类,格式检查子类可以继承该类,或者实现ICheckFormat接口
 * @author panmeifa
 *
 */
public class BaseCheckFormat implements ICheckFormat{
    /**
     * @param file 文件类
     */
	public void checkFile(FormFile file) throws Exception {

	}
    /**
     * @param line 文件的一行数据
     * @param rowCount 当前第几行
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
