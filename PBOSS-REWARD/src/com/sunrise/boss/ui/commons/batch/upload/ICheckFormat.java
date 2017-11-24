package com.sunrise.boss.ui.commons.batch.upload;

import java.util.HashMap;

import jxl.Cell;

import org.apache.struts.upload.FormFile;

import com.sunrise.boss.ui.commons.User;

/**
 * Title: 格式检查接口
 * @author liminghao
 * @version 1.0
 */
public interface ICheckFormat {

    /**
     * 检查文件的类型,大小,parameterMap存放表单域值
     * @param file 文件类
     * @param parameterMap 表单参数
     */
	public void checkFile(FormFile file,HashMap parameterMap) throws Exception;
    
	/**
     * 检查文件的每行数据
     * @param line 文件的一行数据
     * @param rowCount 当前第几行
     */
	public void checkLine(String line,int rowCount) throws Exception;
	
}
