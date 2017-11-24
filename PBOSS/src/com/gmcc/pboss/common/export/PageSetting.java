package com.gmcc.pboss.common.export;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PageSetting {

	public  final static int LIMIT_PAGE = 50; 	//����������ҳ����100ҳ
	public  final static int EXCELOUT_PAGE_SIZE = 1000; 	//���Ƶ�����¼ÿ�ζ�ȡ100����¼
	private static Logger log = LoggerFactory.getLogger(PageSetting.class);
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
