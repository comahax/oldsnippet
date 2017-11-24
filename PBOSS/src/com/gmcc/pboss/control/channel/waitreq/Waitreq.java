/**
 * auto-generated code
 * Wed Nov 18 16:14:43 CST 2009
 */
package com.gmcc.pboss.control.channel.waitreq;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.gmcc.pboss.business.channel.waitreq.WaitreqDBParam;
import com.gmcc.pboss.business.channel.waitreq.WaitreqVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: Waitreq
 * </p>;
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Jerimy
 * @version 1.0
 */
public interface Waitreq extends AbstractControl {
	public WaitreqVO doCreate(WaitreqVO vo) throws Exception;

	/*
	 * 0:�������� 1:���˹��� 2:������ 3:�������� 4:�������� 5:��Դ���� 6:��ͨ���� 8:���� 100:�����ȼ�����վ��֤�룩
	 */
	public static final Short SMS_CH = new Short("0");
	public static final Short SMS_KEHE = new Short("1");
	public static final Short SMS_REWARD = new Short("2");
	public static final Short SMS_FX = new Short("3");
	public static final Short SMS_PRO = new Short("4");
	public static final Short SMS_IM = new Short("5");
	public static final Short SMS_GOTO = new Short("6");
	public static final Short SMS_OTHER = new Short("8");
	public static final Short SMS_PRIORITY = new Short("100");

	/**
	 * ����������������� ���������ݣ����ܺ���
	 */
	public WaitreqVO doInsert(Short mobileType, String content, String mobile)
			throws Exception;
	
	public WaitreqVO doInsert2(Short mobileType, String content, String sendno, String recno)
		throws Exception ;

	public void doRemoveByVO(WaitreqVO vo) throws Exception;

	public void doRemoveByPK(Serializable pk) throws Exception;

	public WaitreqVO doUpdate(WaitreqVO vo) throws Exception;

	public WaitreqVO doFindByPk(Serializable pk) throws Exception;

	public DataPackage doQuery(WaitreqDBParam params) throws Exception;
	
	/*
	 * ����:��������,��������,���ͺ���,���պ���,����ʱ��
	 */
	public WaitreqVO doInsert3(Short mobileType, String content, String sendno, String recno, Date senttime) throws Exception ;
	
	//���浽��Ϣ�����ͱ�
	public void doSaveWaitreq(Short mobileType, String content, String desttype, List<String> objidList)throws Exception;
	
	/**
	 * �����Ͷ��š��������� --�ɼ�ƽ̨���õ���
	 *  @param ���ű�ʶ,���滻�����ļ�ֵ�����պ���
	 * ���ݶ��ű�ʶ��ѯ����ģ������Զ������ݽ����滻��Ȼ�������Ŵ����ͱ�           
	 * @author yedaoe
	 */
	public WaitreqVO doInsertForCj(String sId, Map<String,String> keyAndValue, String recno) throws Exception;

}
