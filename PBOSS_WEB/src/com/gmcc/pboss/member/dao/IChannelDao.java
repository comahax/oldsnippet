package com.gmcc.pboss.member.dao;

import com.gmcc.pboss.common.bean.Channel;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-8-19
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ����������DAO
 */
public interface IChannelDao {
	/**
	 * ������������õ�������Ϣ
	 * @param wayId
	 * @return
	 */
	public Channel getChannelByWayId(String wayId,long isnet);

	public Channel getByWayId(String wayid);
}
