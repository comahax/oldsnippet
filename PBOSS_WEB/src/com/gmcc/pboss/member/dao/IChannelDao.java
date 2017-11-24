package com.gmcc.pboss.member.dao;

import com.gmcc.pboss.common.bean.Channel;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-8-19
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：渠道DAO
 */
public interface IChannelDao {
	/**
	 * 根据渠道编码得到渠道信息
	 * @param wayId
	 * @return
	 */
	public Channel getChannelByWayId(String wayId,long isnet);

	public Channel getByWayId(String wayid);
}
