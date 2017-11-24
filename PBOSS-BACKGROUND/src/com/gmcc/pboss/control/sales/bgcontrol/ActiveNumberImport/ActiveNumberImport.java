package com.gmcc.pboss.control.sales.bgcontrol.ActiveNumberImport;


import java.util.Date;

import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface ActiveNumberImport extends AbstractControl {

	
	/**
	 * ��������뵼�롱֮��ڷ���
	 * @param cityid ���б�ʶ
	 * @param srcpath ��������ļ��Ĵ��·��
	 * @throws Exception
	 */
	public void doProcess(String cityid,String srcpath) throws Exception;
	
	/**
	 * <pre>
	 * ��ѯBOSSϵͳ��ҵ����־��CS_REC_RECEPTION����ȡ��������,
	 * �������ݲ��뵽���뼤���¼��FX_SN_NOACTINFO��
	 * </pre>
	 * @param cityno ���б���(������ʽ)
	 * @param today
	 * @param yesterday
	 * @return
	 * @throws Exception
	 */
	public int batchImportDataFromBOSS(String cityno, Date today,
			Date yesterday) throws Exception ;
	
	/*
	 * �������׿��������ݸ���
	 */
	public int doCooperatorActiveUpdate() throws Exception ;
}
