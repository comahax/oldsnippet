package com.gmcc.pboss.common.constant.service;

import java.util.Map;

import com.gmcc.pboss.common.service.BaseService;
import com.gmcc.pboss.common.service.CacheService;
import com.gmcc.pboss.model.constant.ChPwCntycompany;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-12-22
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ������
 */
public interface ConstantService extends BaseService, CacheService{
	/**
	 * ��ù̶���������
	 * @param groupid
	 * 			�̶�������ʶ
	 * @param dictid
	 * 			�̶�����key
	 * @return
	 * 			dictName
	 */
	public String getConstantName(String groupid, String dictid);
	
	/**
	 * ��ù̶�������ʾΪgroupid�ļ���
	 * @param groupid
	 * 			�̶�������ʶ
	 * @return
	 * 			Map<dictid,dictname>
	 */
	public Map<String, String> getConstantMap(String groupid);
	
	/**
	 * �����뷵�ص����ӹ�˾������
	 * @param companycode ����
	 * @return ����
	 */
	public String getCntcompanyName(String companycode);
	
	/**
	 * �����б�ʶ��ȡ���зֹ�˾
	 * @param cityid ���б�ʶ
	 * @return
	 */
	public Map<String,ChPwCntycompany> getBranchCntyComps(String cityid);
}
