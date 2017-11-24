package com.gmcc.pboss.common.export;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PageSetting {

	public  final static int LIMIT_PAGE = 50; 	//导出的限制页数是100页
	public  final static int EXCELOUT_PAGE_SIZE = 1000; 	//限制导出记录每次读取100条记录
	private static Logger log = LoggerFactory.getLogger(PageSetting.class);
	/**
	 * 判断起始页码、终止页码和每页的记录数是否符合基本规则
	 * 
	 * @param startindex  导出的起始页码
	 * @param endindex	  导出的终止页码
	 * @param pagesize	  导出每页的记录数
	 * @throws Exception
	 */
	public static void checkPageIndex(long startindex,long endindex,long pagesize) throws Exception{
		
		long pagenosize = endindex - startindex + 1;
		if(endindex < 1 || startindex < 1){
			log.error("ExcelOut checkPageIndex Error: endindex < 1 or startindex < 1!");
			throw new Exception();
		}
		if(pagesize < 1){
			log.error("ExcelOut checkPageIndex Error: pagesize < 1!");
			throw new Exception();
		}
		
		if(pagenosize < 1 || pagenosize > EXCELOUT_PAGE_SIZE){
			log.error("ExcelOut checkPageIndex Error: pagenosize < 1 or pagenosize > " + EXCELOUT_PAGE_SIZE +"!");
			throw new Exception();
		}
		
		if(pagenosize * pagesize < 1 || pagenosize * pagesize > EXCELOUT_PAGE_SIZE * LIMIT_PAGE){
			log.error("ExcelOut checkPageIndex Error: pagenosize * pagesize < 1 or pagenosize * pagesize > " + EXCELOUT_PAGE_SIZE * LIMIT_PAGE +"!");
			throw new Exception();
		}
		
	}
}
