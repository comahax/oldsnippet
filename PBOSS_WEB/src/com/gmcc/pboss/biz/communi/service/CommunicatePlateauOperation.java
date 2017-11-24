package com.gmcc.pboss.biz.communi.service;
/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-10-29
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：自定义操作码从100递增
 */
public class CommunicatePlateauOperation {
	/**回复*/
	public static final int REPLAY = 101;
	/**查询回复*/
	public static final int REPLAY_QUERY = 102;
	
	/**已阅*/
	public static final int READ = 103;

	/**新增提问*/
	public static final int CREATE_QUESTION = 104;
	/**关闭提问*/
	public static final int CLOSE_QUESTION = 105;
	/**查询提问*/
	public static final int QUERY_QUESTION = 106;
	
	/**代办任务查看*/
	public static final int READ_PENDING_TASK = 107;
	/**代办任务完成*/
	public static final int FINISH_PENDING_TASK = 108;
	
	/**
	 * 获得信息查询类型
	 * @param type 信息类型
	 * @return 200 + 信息类型
	 */
	public static int getQueryInfosKind(String type){
		return 200 + Integer.parseInt(type);
	}
	
	/**
	 * 获得信息查看类型
	 * @param type
	 * @return 300 + 信息类型
	 */
	public static int getShowInfosKind(String type){
		return 300 + Integer.parseInt(type);
	}
}
