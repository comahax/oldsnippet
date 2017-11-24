package com.gmcc.pboss.common.dictionary;
/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-8-19
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：渠道状态
 */
public class ChannelState {
	/**
	 * 固定参数CH_VALIDFLAG
		0 失效 1有效 -1删除
	 */
	/**有效*/
	public static final int VALIDATION = 1;
	
	/**失效*/
	public static final int INVALIDATION = 0;
	
	/**删除*/
	public static final int DELETE = -1;
}
