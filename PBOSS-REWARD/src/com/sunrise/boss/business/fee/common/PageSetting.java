package com.sunrise.boss.business.fee.common;

import org.apache.log4j.Logger;

public class PageSetting {
	
	
	public  final static int LIMIT_PAGE = 100; 	//导出的限制页数是100页
	public  final static int EXCELOUT_PAGE_SIZE = 100; 	//限制导出记录每次读取100条记录
	
	private static Logger log = Logger.getLogger(PageSetting.class);
	
	
	/**
	 * 
	 * @param rowcount 记录总数
	 * @param pageno 当前页数
	 * @param pagesize 每页记录数
	 * @return 当前页第一条记录数
	 */
	public static int getFirstResult(int rowcount ,int pageno, int pagesize){
		int firstRs = 0;
		if(rowcount > 0){ 
			firstRs = pagesize * (pageno - 1);
			if(firstRs < 0) firstRs = 0;
		}
		return firstRs;
	}
	/**
	 * 
	 * @param rowcount 记录总数
	 * @param pageno 当前页数
	 * @param pagesize 每页记录数
	 * @return 当前页最后一条记录数
	 */
	public static int getLastResult(int rowcount ,int pageno, int pagesize){
		int lastRs = 0;
		if(rowcount > 0){ 
			lastRs = pagesize * pageno - 1;
			if (lastRs >= rowcount) lastRs = rowcount - 1;
		}
		return lastRs;
	}

	
	/**
	 * 判断当前页是否超出总页数
	 * @param rowcount 记录总数
	 * @param pageno 当前页数
	 * @param pagesize 每页记录数
	 * @return 当前页数
	 */
	public static int checkPageNo(int rowcount ,int pageno, int pagesize){
		int doprevious = pageno;
		int initcount = (pageno - 1 ) * pagesize;
		if(rowcount < 1) return 1;
		while(initcount > 0){
			if(initcount >= rowcount){
				doprevious--;
				initcount = initcount - pagesize;
			}else{
				break;
			}						
		}		
		if(doprevious < 1 )return 1;	
		
		return doprevious;
	}
	
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
