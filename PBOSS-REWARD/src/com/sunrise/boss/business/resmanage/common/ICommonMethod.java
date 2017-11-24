package com.sunrise.boss.business.resmanage.common;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.ui.commons.User;

public interface ICommonMethod {

	/**
	 * ������Դ������������Ʒ״̬�ж���Ʒ�Ƿ���Խ��в���
	 * 
	 * @param oprtype
	 * @param comstate
	 * @return boolean
	 */
	public boolean chkComstate(Long oprtype, Long comstate);

	/**
	 * �����ʼ��ź���ֹ��ż�������Դ�������Ƿ�һ��
	 * 
	 * @param outwayid
	 * @param begno
	 * @param endno
	 * @param comid
	 * @param dao
	 * @return ���������һ�£�����-1�� ����һ�£����ؿɲ�����Դ����
	 * @throws Exception
	 */
	public int chkWayissame(String outwayid, String begno, String endno,
			Long comid, String batchno, Long comstate, BaseDAO dao)
			throws Exception;

	/**
	 * �Ǽ���Դ������־
	 * 
	 * @param begno
	 * @param batchno
	 * @param comid
	 * @param wayid
	 * @param comstate
	 * @param oprVO
	 * @param user
	 * @return ��Դ������־����
	 * @throws Exception
	 */
	public Object setOprVO(String begno, String batchno, Long comid,
			String wayid, Long comstate, Object oprVO, User user)
			throws Exception;

	/**
	 * �Ǽ���Դ�����
	 * 
	 * @param reqVO
	 * @param user
	 * @throws Exception
	 */
	public void setReqVO(Object reqVO, User user) throws Exception;

}