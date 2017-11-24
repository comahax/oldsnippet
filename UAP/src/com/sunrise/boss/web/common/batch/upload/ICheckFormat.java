package com.sunrise.boss.web.common.batch.upload;

import java.util.HashMap;


/**
 * Title: 格式检查接口
 * @author liminghao
 * @version 1.0
 */
public interface ICheckFormat {

    /**
     * 检查文件的类型,大小
     * @param file 文件类
     */
	public void checkFile(FormFile file) throws Exception;
    
	/**
     * 检查文件的每行数据
     * @param line 文件的一行数据
     * @param rowCount 当前第几行
     */
	public void checkLine(String line,int rowCount) throws Exception;
	
}
