package com.gmcc.pboss.biz.basic.goods.service;

import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.BaseService;
import com.gmcc.pboss.common.service.CacheService;

/**
 * 
 * ҵ������ѯ��֧�ֻ���
 * 
 */
public interface IbGlSysparamService extends BaseService {
	
	//��ȡ�Ƿ��ṩ��Դ��ϸ�鿴 1-�ǣ�0-��
	public String getIsQuery(LoginMember member);
	
	/**
	 * ��ȡϵͳ����
	 * @param systemid   ϵͳ����id
	 * @param paramType  ϵͳ�������ͣ������ͬ��������
	 * @return   ϵͳ����ֵ���ظ�Action
	 */
	public String getSysValue(long systemid, String paramType);
	
}
