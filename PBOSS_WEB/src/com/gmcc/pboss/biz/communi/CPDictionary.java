package com.gmcc.pboss.biz.communi;
/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-11-5
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：数据字典
 */
public class CPDictionary {
	/***********************信息类型*****************************/
	/**"1".公告*/
	public static final String AFFICHE = "1";
	
	/**"2".在线问答*/
	public static final String INTERLOCUTION = "2";
	
	/**"3".问卷调查*/
	public static final String QUESTIONNAIRE = "3";
	
	/**"4".知识库*/
	public static final String KNOWLEDGE = "4";
	
	/**"5".待办*/
	public static final String PENDING_REQUEST = "5";
	
	/**"6".业务信息*/
	public static final String OPERATIONINFO = "6";
	
	
	/***********************信息状态*****************************/
	/**1.未发布*/
	public static final Long S_UNPUBLISH = new Long(1);
	/**2.待审批*/
	public static final Long S_APPROVE = new Long(2);
	/**3.已发布*/
	public static final Long S_PUBLISHED = new Long(3);
	/**4.已关闭*/
	public static final Long S_CLOSED = new Long(4);
	/**5.退回*/
	public static final Long S_UNTREAD = new Long(5);
	/**6.已回复*/
	public static final Long S_REVERT = new Long(6);
	
	/***********************接受对象状态*****************************/
	/**1.打开*/
	public static final Long OS_OPEN = new Long(1);
	/**2.关闭*/
	public static final Long OS_CLOSE = new Long(2);

	
}
