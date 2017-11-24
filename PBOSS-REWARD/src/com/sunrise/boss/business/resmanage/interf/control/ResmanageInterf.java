package com.sunrise.boss.business.resmanage.interf.control;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: BOSS1.5
 * </p>
 * 
 * <p>
 * Description: ��Դ����ӿ�
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * 
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Rodney
 * @version ����02:18:312006-8-28
 */
public interface ResmanageInterf {
	/**
	 * 
	 * @Description:��Դ�����ӿ�
	 * @param paramstring
	 * @return �ɹ�ʧ�ܱ�־|ԭ��
	 * @throws Exception
	 *             String
	 */
	public String manageRes(String paramstring, Long restype, Long oprtype,
			User user) throws Exception;

	/**
	 * 
	 * @Description:��Ʒ���Ͳ�ѯ�ӿ�
	 * @param Comclassid��user
	 * @return ��Ʒ���ͼ��� Set
	 */
	public Set getComType(Long Comclassid, User user) throws Exception;

	/**
	 * 
	 * @Description:��Ʒ��ʶ���۸��ѯ
	 * @param comtype
	 * @return ��Ʒ��ʶ���۸�
	 * @throws Exception
	 *             Map
	 */
	public List getComId(Long comtype, User user) throws Exception;

	/**
	 * �����Ʒ������״̬�Ƿ���ϵ��볷��Ҫ��
	 * 
	 * @param comresid
	 *            ��Ʒ���
	 * @param comid
	 *            ��Ʒ��ʶ
	 * @param wayid
	 *            ��������Դʹ������
	 * @param user
	 * @throws Exception
	 */
	public void doUnImportComresCheck(String comresid, Long comid,
			String wayid, User user) throws Exception;

	/**
	 * �����Ʒ������״̬�Ƿ���ϵ���Ҫ��
	 * 
	 * @param comresid
	 *            ��Ʒ���
	 * @param comid
	 *            ��Ʒ��ʶ
	 * @param wayid
	 *            ��������Դʹ������
	 * @param user
	 * @throws Exception
	 */
	public void doImportComresCheck(String comresid, Long comid, String wayid,
			User user) throws Exception;

	/**
	 * ������Ʒ���볷��������Ʒ״̬�޸�Ϊ����̬�����������
	 * 
	 * @param comresid
	 *            ��Ʒ���
	 * @param comid
	 *            ��Ʒ��ʶ
	 * @param user
	 * @throws Exception
	 */
	public void doUnImportComres(String comresid, Long comid, User user)
			throws Exception;

	/**
	 * ������Ʒ���룬����Ʒ״̬�޸�Ϊ��ȡ̬�����������
	 * 
	 * @param comresid
	 *            ��Ʒ���
	 * @param comid
	 *            ��Ʒ��ʶ
	 * @param user
	 * @throws Exception
	 */
	public void doImportComres(String comresid, Long comid, User user)
			throws Exception;
}
