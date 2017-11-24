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
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-10-29
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：沟通平台接口
 */
public interface CommunicatePlateauService extends BaseService, CacheService{
	
	/**
	 * 公告/业务信息/提问回复
	 * 输入：
	 * CommunicatePlateauParameter.replyContent	回复内容
	 * CommunicatePlateauParameter.advinfoid		信息ID
	 * CommunicatePlateauParameter.employeeid	人员编码
	 * @return
	 */
	public ServiceResult replay(QueryParameter parameter);
	
	/**
	 * 公告/业务信息已阅
	 * 输入：
	 * CommunicatePlateauParameter.advinfoid
	 * CommunicatePlateauParameter.employeeid
	 * @return
	 */
	public ServiceResult read(QueryParameter parameter);
	
	/**
	 * 在线问答 新增提问
	 * @param parameter
	 * @return
	 */
	public ServiceResult createQuestion(LoginMember member,QueryParameter parameter);
	
	/**
	 * 在线问答 关闭提问
	 * @param parameter
	 * @return
	 */
	public ServiceResult closeQuestion(QueryParameter parameter);
	
	/**
	 * 代办任务查看
	 * @param parameter
	 * @return
	 */
	public ServiceResult readPendingTask(QueryParameter parameter);
	
	/**
	 * 代办任务完成
	 * @param parameter
	 * @return
	 */
	public ServiceResult finishPendingTask(QueryParameter parameter);
	
	/**
	 * 根据地市标识从缓存中获取该地市的公开信息
	 * @param cityid
	 * @return
	 */
	public List<ChPwAdvinfo> getPublicInfoByCityid(String cityid);
	/**
	 * 查找附件
	 */
	public ServiceResult findAffix(String affxid);
	/**
	 * 查找公开信息
	 * @param cityid
	 * @param foid
	 * @return
	 */
	public ServiceResult queryForPublic(String cityid ,String advinfoid);
	/**
	 * 查找公开信息附件下载
	 * @param cityid
	 * @param advinfoid
	 * @param affixid
	 * @return
	 */
	public String queryForPublicAffix(String cityid ,String advinfoid,String affixid);
}
