package com.sunrise.boss.business.fee.common;

import org.apache.log4j.Logger;

public class PageSetting {
	
	
	public  final static int LIMIT_PAGE = 100; 	//����������ҳ����100ҳ
	public  final static int EXCELOUT_PAGE_SIZE = 100; 	//���Ƶ�����¼ÿ�ζ�ȡ100����¼
	
	private static Logger log = Logger.getLogger(PageSetting.class);
	
	
	/**
	 * 
	 * @param rowcount ��¼����
	 * @param pageno ��ǰҳ��
	 * @param pagesize ÿҳ��¼��
	 * @return ��ǰҳ��һ����¼��
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
	 * @param rowcount ��¼����
	 * @param pageno ��ǰҳ��
	 * @param pagesize ÿҳ��¼��
	 * @return ��ǰҳ���һ����¼��
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
	 * �жϵ�ǰҳ�Ƿ񳬳���ҳ��
	 * @param rowcount ��¼����
	 * @param pageno ��ǰҳ��
	 * @param pagesize ÿҳ��¼��
	 * @return ��ǰҳ��
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
	 * �ж���ʼҳ�롢��ֹҳ���ÿҳ�ļ�¼���Ƿ���ϻ�������
	 * 
	 * @param startindex  ��������ʼҳ��
	 * @param endindex	  ��������ֹҳ��
	 * @param pagesize	  ����ÿҳ�ļ�¼��
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
