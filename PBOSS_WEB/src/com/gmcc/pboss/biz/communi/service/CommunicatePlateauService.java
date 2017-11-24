package com.gmcc.pboss.biz.communi.service;

import java.io.Serializable;
import java.util.List;

import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.BaseService;
import com.gmcc.pboss.common.service.CacheService;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.model.communi.ChPwAdvinfo;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-10-29
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ��������ͨƽ̨�ӿ�
 */
public interface CommunicatePlateauService extends BaseService, CacheService{
	
	/**
	 * ����/ҵ����Ϣ/���ʻظ�
	 * ���룺
	 * CommunicatePlateauParameter.replyContent	�ظ�����
	 * CommunicatePlateauParameter.advinfoid		��ϢID
	 * CommunicatePlateauParameter.employeeid	��Ա����
	 * @return
	 */
	public ServiceResult replay(QueryParameter parameter);
	
	/**
	 * ����/ҵ����Ϣ����
	 * ���룺
	 * CommunicatePlateauParameter.advinfoid
	 * CommunicatePlateauParameter.employeeid
	 * @return
	 */
	public ServiceResult read(QueryParameter parameter);
	
	/**
	 * �����ʴ� ��������
	 * @param parameter
	 * @return
	 */
	public ServiceResult createQuestion(LoginMember member,QueryParameter parameter);
	
	/**
	 * �����ʴ� �ر�����
	 * @param parameter
	 * @return
	 */
	public ServiceResult closeQuestion(QueryParameter parameter);
	
	/**
	 * ��������鿴
	 * @param parameter
	 * @return
	 */
	public ServiceResult readPendingTask(QueryParameter parameter);
	
	/**
	 * �����������
	 * @param parameter
	 * @return
	 */
	public ServiceResult finishPendingTask(QueryParameter parameter);
	
	/**
	 * ���ݵ��б�ʶ�ӻ����л�ȡ�õ��еĹ�����Ϣ
	 * @param cityid
	 * @return
	 */
	public List<ChPwAdvinfo> getPublicInfoByCityid(String cityid);
	/**
	 * ���Ҹ���
	 */
	public ServiceResult findAffix(String affxid);
	/**
	 * ���ҹ�����Ϣ
	 * @param cityid
	 * @param foid
	 * @return
	 */
	public ServiceResult queryForPublic(String cityid ,String advinfoid);
	/**
	 * ���ҹ�����Ϣ��������
	 * @param cityid
	 * @param advinfoid
	 * @param affixid
	 * @return
	 */
	public String queryForPublicAffix(String cityid ,String advinfoid,String affixid);
}
