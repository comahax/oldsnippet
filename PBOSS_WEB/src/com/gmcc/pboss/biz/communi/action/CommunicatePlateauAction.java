package com.gmcc.pboss.biz.communi.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;

import com.gmcc.pboss.biz.communi.CPDictionary;
import com.gmcc.pboss.biz.communi.service.CommunicateInterlocutionService;
import com.gmcc.pboss.biz.communi.service.CommunicatePlateauOperation;
import com.gmcc.pboss.biz.communi.service.CommunicatePlateauService;
import com.gmcc.pboss.biz.communi.support.CommunicatePlateauParameter;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.config.ConfigUtil;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.dictionary.Role;
import com.gmcc.pboss.common.exception.TransactionProcessionException;
import com.gmcc.pboss.common.file.bean.FileHandleConfig;
import com.gmcc.pboss.common.file.bean.FileUploadBean;
import com.gmcc.pboss.common.file.bean.ServerInfoBean;
import com.gmcc.pboss.common.file.dictionary.UploadFileType;
import com.gmcc.pboss.common.file.util.FileHandleUtil;
import com.gmcc.pboss.common.file.util.FtpAccess;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.model.communi.ChPwAdvaffix;
import com.gmcc.pboss.model.communi.ChPwAdvinfo;
import com.gmcc.pboss.model.communi.CommunicatePlateauVO;
import com.opensymphony.xwork2.ActionContext;

/**
 * 从兴公司电子渠道业务部
 * 
 * @author tangzhu
 * @date 2009-10-29 所属项目：PBOSS 所属模块：门户网站 描述：沟通平台Action
 */
public class CommunicatePlateauAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9200418265419846373L;

	private CommunicatePlateauService service;

	private CommunicateInterlocutionService cpService;

	private CommunicatePlateauParameter parameter;
	
	private CommunicatePlateauParameter publicParameter;
	/**
	 * 信息
	 */
	private ChPwAdvinfo chPwAdvinfo;
	/**
	 * 附件列表
	 */
	private List chPwAdvaffixList;
//	/**
//	 * 下载文件路径
//	 */
//	private String downloadFilePath;
//	/**
//	 * 下载附件文件名
//	 */
//	private String downloadFileName;
	
	/**
	 * 上传配置
	 */
	private FileUploadBean uploadConfig;
	/**
	 * 地市ID
	 */
	private String cityid ;
	/**
	 * 公告/业务/知识库信息查询(查询页面)
	 * 
	 * @return
	 */
	public String doQueryInfos() {
		LoginMember member = this.getMember();
		
		CommunicatePlateauParameter parameter = (CommunicatePlateauParameter)getParameter();
		parameter.setOperation(CommunicatePlateauOperation.getQueryInfosKind(parameter.getType()));
		
		ServiceResult result = service.transact(member, parameter,ServiceType.QUERY);

		// 返回JSON对象
		this.writeJSONServicePage(result, CPDictionary.PENDING_REQUEST
				.equals(parameter.getType()) ? getPendingRequestColsList()
				: getAfficheColsList());
		return null;
	}

	/**
	 * 提问保存
	 * 
	 * @return
	 */
	public String doQuestionSubmit() {
		LoginMember member = getMember();
		ServiceResult result;
		try {
			getParameter().setOperation(
					CommunicatePlateauOperation.CREATE_QUESTION);
			result = service.transactionProcessing(member, getParameter(),
					ServiceType.OTHER);
		} catch (TransactionProcessionException e) {
			result = new ServiceResult();
			result.setSuccess(false);
			result.setRetCode(ServiceRetCode.EXCEPTION);
			result.setMessage(ConfigUtil.getMessage(ServiceCode.COMMUNICATE,
					ServiceRetCode.EXCEPTION));
			logger.error("CommunicatePlateauAction:" + e.getMessage());
		}
		if (result.isSuccess()) {
			result.setRetObject("myQuestion.do");
			writeJSONServiceData(result);
		}
		return null;
	}

	/**
	 * 我的提问(查询页面)
	 * 
	 * @return
	 */
	public String doMyQuestionQuery() {
		LoginMember member = this.getMember();
		CommunicatePlateauParameter parameter = (CommunicatePlateauParameter)getParameter();
		parameter.setOperation(CommunicatePlateauOperation.QUERY_QUESTION);
		
		ServiceResult result = cpService.transact(member, getParameter(),ServiceType.QUERY);
		
		List list = result.getRetResult().getData();
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			ChPwAdvinfo c = (ChPwAdvinfo) iter.next();
			c.setStateName(Constant.getConstantName(
							ConstantsType.QUESTION_STATE, String.valueOf(c
									.getState())));
		}
		// 返回JSON对象
		this.writeJSONServicePage(result, getMyQuestionColsList());
		return null;
	}

	/**
	 * 查看公告/业务/知识库/提问
	 */
	public String doShowInfo() {
		LoginMember member = this.getMember();
		ServiceResult result = null;
		try {
			CommunicatePlateauParameter parameter = (CommunicatePlateauParameter)getParameter();
			parameter.setOperation(CommunicatePlateauOperation.getShowInfosKind(parameter.getType()));
			
			result = service.transactionProcessing(member, getParameter(),ServiceType.QUERY_ONE);
		} catch (Exception e) {
			result = new ServiceResult();
			result.setSuccess(false);
			result.setRetCode(ServiceRetCode.EXCEPTION);
			result.setMessage(ConfigUtil.getMessage(ServiceCode.COMMUNICATE,
					ServiceRetCode.EXCEPTION));
			logger.error("CommunicatePlateauAction:" + e.getMessage());
			e.printStackTrace();
		}
		if (result.isSuccess()) {
			CommunicatePlateauVO vo = (CommunicatePlateauVO) (result
					.getRetObject());
			chPwAdvinfo = vo.getAdvinfo();
			chPwAdvaffixList = vo.getAdvaffixs();
			
			//如果是调查问卷返回上传信息
			if(CPDictionary.QUESTIONNAIRE.equals(chPwAdvinfo.getType().toString())){
				//读取配置文件
				 uploadConfig = FileHandleUtil.loadUploadConfig(UploadFileType.INDAGATE_QUESTIONNAIRE);
			}
		}
		return SUCCESS;
	}
	/**
	 * 查看公开信息
	 */
	public String doShowPublic(){
		LoginMember member = this.getMember();
		ServiceResult result = null;
		try {
			result = service.queryForPublic(getCityid(), String.valueOf(getPublicParameter().getAdvinfoid()));
		} catch (Exception e) {
			result = new ServiceResult();
			result.setSuccess(false);
			result.setRetCode(ServiceRetCode.EXCEPTION);
			result.setMessage(ConfigUtil.getMessage(ServiceCode.COMMUNICATE,
					ServiceRetCode.EXCEPTION));
			logger.error("CommunicatePlateauAction:" + e.getMessage());
			e.printStackTrace();
		}
		if (result.isSuccess()) {
			chPwAdvinfo = (ChPwAdvinfo) (result.getRetObject());
			chPwAdvaffixList = new ArrayList();
			Set<ChPwAdvaffix> set = chPwAdvinfo.getAffixs();
			for(Iterator it = set.iterator();it.hasNext();){
				chPwAdvaffixList.add(it.next());
			}
		}
		return SUCCESS;
	}
	
	/**
	 * 待办业务
	 */
	public String doPendingRequestList() {
		this.setTitle(PageLoction.PendingRequestQuery);
		return super.doList();
	}

	/**
	 * 业务
	 */
	public String doOperationList() {
		this.setTitle(PageLoction.OperationInfoQuery);
		return super.doList();
	}

	/**
	 * 公告
	 */
	public String doAffcheList() {
		this.setTitle(PageLoction.AfficheInfoQuery);
		return super.doList();
	}

	/**
	 * 知识库
	 */
	public String doKnowledgeList() {
		this.setTitle(PageLoction.KnowledgeQuery);
		return super.doList();
	}

	/**
	 * 在线问答->提问
	 */
	public String doQuestion() {
		this.setTitle(PageLoction.Question);
		return super.doList();
	}

	/**
	 * 在线问答->我的提问
	 */
	public String doMyQuestionList() {
		this.setTitle(PageLoction.MyQuestion);
		return super.doList();
	}

	/**
	 * 公告/业务信息/提问回复
	 * 
	 * @return
	 */
	public String doReplay() {
		CommunicatePlateauParameter parameter = (CommunicatePlateauParameter) getParameter();
		parameter.setOperation(CommunicatePlateauOperation.REPLAY);
		
		ServiceResult result = service.transactionProcessing(getMember(),parameter, ServiceType.OTHER);
		writeJSONServiceData(result);
		return null;
	}

	/**
	 * 公告/业务信息已阅
	 * 
	 * @return
	 */
	public String doRead() {
		CommunicatePlateauParameter parameter = (CommunicatePlateauParameter) getParameter();
		parameter.setOperation(CommunicatePlateauOperation.READ);
		
		ServiceResult result = service.transactionProcessing(getMember(),
				parameter, ServiceType.OTHER);
		writeJSONServiceData(result);
		return null;
	}

	/**
	 * 提问关闭
	 * 
	 * @return
	 */
	public String doClose() {
		CommunicatePlateauParameter parameter = (CommunicatePlateauParameter) getParameter();
		parameter.setOperation(CommunicatePlateauOperation.CLOSE_QUESTION);
		ServiceResult result = service.transactionProcessing(getMember(),
				parameter, ServiceType.OTHER);
		writeJSONServiceData(result);
		return null;
	}

	/**
	 * 待办任务查看
	 * 
	 * @return
	 */
	public String doReadPendingTask() {
		CommunicatePlateauParameter parameter = (CommunicatePlateauParameter) getParameter();
		System.out.println(parameter == null);
		parameter.setOperation(CommunicatePlateauOperation.READ_PENDING_TASK);
		ServiceResult result = service.transactionProcessing(getMember(),
				parameter, ServiceType.OTHER);
		// for test
		chPwAdvinfo = (chPwAdvinfo == null) ? new ChPwAdvinfo() : chPwAdvinfo;
		chPwAdvinfo.setContent("a.html");

		result.setRetObject(chPwAdvinfo.getContent());
		writeJSONServiceData(result);
		return null;
	}

	/**
	 * 待办任务完成
	 */
	public String doFinishPendingTask() {
		CommunicatePlateauParameter parameter = (CommunicatePlateauParameter) getParameter();
//		System.out.println(parameter == null);
		
		parameter.setOperation(CommunicatePlateauOperation.FINISH_PENDING_TASK);
		ServiceResult result;
		try {
			result = service.transactionProcessing(getMember(), parameter,
					ServiceType.OTHER);
		} catch (TransactionProcessionException e) {
			result = this.getErrServiceResult(ServiceCode.COMMUNICATE);
			this.setMessage(result.getMessage());
			logger.error("CommunicatePlateauAction.doFinishPendingTask:"
					+ e.getMessage());// 输出到用户
		}
		writeJSONServiceData(result);
		return null;
	}

	/**
	 * by zhangsiwei
	 * @since 2010-01-22 修改为从FTP服务器上下载
	 * @return
	 */
	public String doAffixDownload() {
		try {
			ChPwAdvaffix affix = null;
			ServiceResult result = service.findAffix(parameter.getAffixid());
			affix = (ChPwAdvaffix)(result.getRetObject());
			
			if(affix!=null){
				String downloadFilePath = affix.getAffixpath();
				if(downloadFilePath!=null && !"".equals(downloadFilePath)){
					ServerInfoBean ftpInfo = ServerInfoBean.getInstance();
					FtpAccess.doDownloadFile(ftpInfo, downloadFilePath, getResponse());
					return null;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.error("CommunicatePlateauAction.doFinishPendingTask:需要下载的文件不存在" );
		return ERROR;
	}
	/**
	 * by zhangsiwei
	 * @since 2010-01-22 修改为从FTP服务器上下载
	 * @return
	 */
	public String doAffixPDownload() {
		try {
			String downloadFilePath  = service.queryForPublicAffix(getCityid(), String.valueOf(publicParameter.getAdvinfoid()), publicParameter.getAffixid());
			if(downloadFilePath!=null && !"".equals(downloadFilePath)){
				ServerInfoBean ftpInfo = ServerInfoBean.getInstance();
				FtpAccess.doDownloadFile(ftpInfo, downloadFilePath, getResponse());
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.error("CommunicatePlateauAction.doFinishPendingTask:需要下载的文件不存在" );
		return ERROR;
	}
	
	public String doQuestionnaireReplyAffixDownload(){
		try {
			String downloadFilePath = ServletActionContext.getRequest().getParameter("fileName");
			if(downloadFilePath!=null && !"".equals(downloadFilePath)){
				ServerInfoBean ftpInfo = ServerInfoBean.getInstance();
				FtpAccess.doDownloadFile(ftpInfo, downloadFilePath, getResponse());
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.error("CommunicatePlateauAction.doFinishPendingTask:需要下载的文件不存在" );
		return ERROR;
	}

	/**
	 * 公告表头
	 * 
	 * @return
	 */
	public List<ColumnSet> getAfficheColsList() {
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		setCols.add(new ColumnSet("advinfoid", "ID", false, true));
		setCols.add(new ColumnSet("title", "标题"));
		setCols.add(new ColumnSet("releasetime", "发布时间"));
		return setCols;
	}

	public String getAfficheColsString() {
		return JSONArray.fromObject(getAfficheColsList()).toString();
	}

	/**
	 * 得到待办业务表头
	 * 
	 * @return
	 */
	public List<ColumnSet> getPendingRequestColsList() {
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		setCols.add(new ColumnSet("advinfoid", "ID", false, true));
		setCols.add(new ColumnSet("title", "标题"));
		setCols.add(new ColumnSet("releasetime", "发布时间"));
		setCols.add(new ColumnSet("plantime", "计划完成时间"));
		return setCols;
	}

	public String getPendingRequestColsString() {
		return JSONArray.fromObject(getPendingRequestColsList()).toString();
	}

	/**
	 * 得到我的提问表头
	 */
	public List<ColumnSet> getMyQuestionColsList() {
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		setCols.add(new ColumnSet("advinfoid", "ID", false, true));
		setCols.add(new ColumnSet("title", "标题"));
		setCols.add(new ColumnSet("releasetime", "发布时间"));
		setCols.add(new ColumnSet("content", "内容描述"));
		setCols.add(new ColumnSet("stateName", "状态"));
		return setCols;
	}

	public String getMyQuestionColsString() {
		return JSONArray.fromObject(getMyQuestionColsList()).toString();
	}

	/**
	 * 回复表头
	 */
	public List<ColumnSet> getReplyColsList() {
		List<ColumnSet> list = new ArrayList<ColumnSet>();
		list.add(new ColumnSet("replytime", "回复时间", "25%"));
		list.add(new ColumnSet("oid", "回复人", "25%"));
		list.add(new ColumnSet("replycontent", "回复内容", "50%"));
		return list;
	}
	
	public String getQuestionnaireColsString(){
		List<ColumnSet> list = new ArrayList<ColumnSet>();
		list.add(new ColumnSet("replytime", "回复时间", "25%"));
		list.add(new ColumnSet("oid", "回复人", "15%"));
		list.add(new ColumnSet("affix", "附件", "60%"));
		return JSONArray.fromObject(list).toString();
	}

	public String getReplyColsString() {
		return JSONArray.fromObject(getReplyColsList()).toString();
	}
	
	public void prepare() throws Exception {

	}

	/**
	 * *************************Getter and
	 * Setter********************************
	 */

	public CommunicatePlateauService getService() {
		return service;
	}

	public void setService(CommunicatePlateauService service) {
		this.service = service;
	}

	public CommunicateInterlocutionService getCpService() {
		return cpService;
	}

	public void setCpService(CommunicateInterlocutionService cpService) {
		this.cpService = cpService;
	}

	public void setParameter(CommunicatePlateauParameter parameter) {
		this.parameter = parameter;
	}

	public QueryParameter getParameter() {
		int pageSize = 8;	//页面大小
		parameter = (parameter == null) ? new CommunicatePlateauParameter()
				: parameter;

		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			parameter.setSize(pageSize);//(getPageSize().intValue());// 设置大小

		LoginMember member = this.getMember();
		// 客户端传值
		parameter.setNet(member.getIsnet() == Role.SHOP_MASTER);
		parameter.setEmployeeid(member.getEmployeeid());

		// 默认为不是首页
		parameter.setIndexPage(false);

		return parameter;
	}
	
	
	public CommunicatePlateauParameter getPublicParameter() {
		return publicParameter;
	}

	public void setPublicParameter(CommunicatePlateauParameter publicParameter) {
		this.publicParameter = publicParameter;
	}

	public ChPwAdvinfo getChPwAdvinfo() {
		return chPwAdvinfo;
	}

	public void setChPwAdvinfo(ChPwAdvinfo chPwAdvinfo) {
		this.chPwAdvinfo = chPwAdvinfo;
	}

	public List getChPwAdvaffixList() {
		return chPwAdvaffixList;
	}

	public void setChPwAdvaffixList(List chPwAdvaffixList) {
		this.chPwAdvaffixList = chPwAdvaffixList;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public FileUploadBean getUploadConfig() {
		return uploadConfig;
	}

	public void setUploadConfig(FileUploadBean uploadConfig) {
		this.uploadConfig = uploadConfig;
	}
	
}