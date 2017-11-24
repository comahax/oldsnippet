package com.gmcc.pboss.biz.communi.service.impl;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.LogFactory;
import org.springframework.orm.ObjectRetrievalFailureException;

import com.gmcc.pboss.biz.basic.node.dao.ChPwRcvobjDao;
import com.gmcc.pboss.biz.communi.CPDictionary;
import com.gmcc.pboss.biz.communi.dao.AdvaffixDao;
import com.gmcc.pboss.biz.communi.dao.CommunicatePlateauDao;
import com.gmcc.pboss.biz.communi.dao.ReplyDao;
import com.gmcc.pboss.biz.communi.service.CommunicatePlateauOperation;
import com.gmcc.pboss.biz.communi.service.CommunicatePlateauRetCode;
import com.gmcc.pboss.biz.communi.service.CommunicatePlateauService;
import com.gmcc.pboss.biz.communi.support.CommunicatePlateauParameter;
import com.gmcc.pboss.biz.communi.support.processor.CommunicatePlateauParameterProcessor;
//import com.gmcc.pboss.biz.index.support.AdvinfoPendingParameterProcessor;
import com.gmcc.pboss.biz.basic.goods.service.IbGlSysparamService;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.config.ConfigUtil;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.CommonConfig;
import com.gmcc.pboss.common.dictionary.CommunicateConfig;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.dictionary.FileDictionary;
import com.gmcc.pboss.common.exception.TransactionProcessionException;
import com.gmcc.pboss.common.log.Log;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;
import com.gmcc.pboss.common.util.CommonUtil;
import com.gmcc.pboss.common.util.DateUtil;
import com.gmcc.pboss.model.communi.ChPwAdvaffix;
import com.gmcc.pboss.model.communi.ChPwAdvinfo;
import com.gmcc.pboss.model.communi.ChPwRcvobj;
import com.gmcc.pboss.model.communi.ChPwReply;
import com.gmcc.pboss.model.communi.CommunicatePlateauVO;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-10-29
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：沟通平台业务实现类
 */
public class CommunicatePlateauServiceImpl extends QueryBaseServiceImpl implements
		CommunicatePlateauService {

	private ChPwRcvobjDao chPwRcvobjDao;
	private AdvaffixDao advaffixDao;
	private ReplyDao replyDao;
	private String[] allCity = null;
	private IbGlSysparamService ibGlSysparamService;
	// 公开信息缓存
	protected Map<String,List<ChPwAdvinfo>> cache = new LinkedHashMap<String,List<ChPwAdvinfo>>();
	
	protected static final org.apache.commons.logging.Log logger = LogFactory.getLog(CommunicatePlateauServiceImpl.class);
	
	public CommunicatePlateauServiceImpl() {
		this.serviceCode = ServiceCode.COMMUNICATE;
		this.serviceName = "沟通平台";
		this.isNeedLogin = false;
		this.setProcessor(new CommunicatePlateauParameterProcessor());
		
		String branchName = ConfigUtil.getCommonConfig(FileDictionary.COMMON_NAME,CommonConfig.SYSSUPPORT_BRANCH);
		if("ALL".equals(branchName)){
			Map<String,String> map = Constant.getConstantsMap(ConstantsType.BRANCH_NAME);
			Set<String> set = map.keySet();
			String[] e = new String[map.size()];
			int i = 0;
			for(Iterator<String> it = set.iterator();it.hasNext();){
				e[i++] = it.next();
			}
			allCity = e;
		}
		else
			allCity = branchName.split("\\|");
	}
	
	public void clear() {
		cache.clear();
	}
	// 初始化缓存
	public void init() {
		SessionFactoryContextHolder.setSessionFactoryContext(null);
		int retCode = ServiceRetCode.FAIL;
		String serviceCode = ServiceCode.COMMON;
		String msg = ConfigUtil.getMessage(serviceCode, retCode	);
		
		try {
			int maxRows = Integer.parseInt(ConfigUtil.
					getCommonConfig(FileDictionary.COMMUNICATE_FILE, CommunicateConfig.PUBLIC_INFO_PAGESIZE));

			for (String cityid:allCity){
				List<ChPwAdvinfo> advinfos = loadCityPublicInfo2Cache(cache,cityid,maxRows);
				//没能发生错误，清空缓存
				cache.remove(cityid);
				cache.put(cityid, advinfos);
			}

		} 
		catch (RuntimeException e) {
			// TODO Auto-generated catch block
			msg = CommonUtil.createExceptionString(e);
		}
		
		if(cache.size() != 0){
			retCode = ServiceRetCode.SUCCESS;
			msg = ConfigUtil.getMessage(serviceCode, retCode);
		}
		else{
			retCode = ServiceRetCode.EMPTY;
			msg = ConfigUtil.getMessage(serviceCode, retCode);
		}
		Log.cacheLog("CommunicatePlateauService","公开信息查询",msg);
		
		
		// 下面加载其余20个地市库的公开信息
	}
	/**
	 * 将21个地市库的公开信息加载到内存中
	 * @param cache
	 * @param cityid
	 * @param maxRows
	 */
	private List<ChPwAdvinfo> loadCityPublicInfo2Cache(Map<String,List<ChPwAdvinfo>> cache,String cityid,int maxRows) {
		SessionFactoryContextHolder.setSessionFactoryContext(cityid);
		CommunicatePlateauDao cpDao = (CommunicatePlateauDao)this.getDao();
		return cpDao.queryCityPublicInfo(maxRows);
	}
	// 在 quartz 中配置，每天凌晨0点调用, 具体配置参考 applicationContext-quartz.xml
	public void refresh() {
//		clear();
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>沟通平台刷新");
		init();
	}
	/**
	 * 根据地市标识从缓存中获取该地市的公开信息
	 * @param cityid
	 * @return
	 */
	public List<ChPwAdvinfo> getPublicInfoByCityid(String cityid) {
		if(cache.containsKey(cityid)) {
			return cache.get(cityid);
		}
		return null;
	}

	public ServiceResult read(QueryParameter parameter) {
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);
		
		CommunicatePlateauDao cpDao = (CommunicatePlateauDao)this.getDao();
		CommunicatePlateauParameter param = (CommunicatePlateauParameter)parameter;
		ChPwRcvobj rcvobj = cpDao.getRcvobjByIds(param);
		rcvobj.setState(Long.valueOf("2"));
		rcvobj.setStatetime(new java.util.Date());
		
		cpDao.update(rcvobj);
		
		result.setSuccess(true);
		result.setRetCode(ServiceRetCode.SUCCESS);
		return result;
	}

	public ServiceResult replay(QueryParameter parameter) {
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);
		
		CommunicatePlateauParameter param = (CommunicatePlateauParameter)parameter;
		long advinfoid = param.getAdvinfoid();
		String employeeid = param.getEmployeeid();
		String replycontent = param.getContent();
		
		ChPwReply reply = new ChPwReply();
		reply.setAdvinfoid(advinfoid);
		reply.setOid(employeeid);
		reply.setReplycontent(replycontent);
		reply.setReplytime(new java.util.Date());
		
		replyDao.save(reply);
		
		result.setSuccess(true);
		result.setRetCode(ServiceRetCode.SUCCESS);
		
		return result;
	}
	
	public ServiceResult createQuestion(LoginMember member,QueryParameter parameter) {
		// TODO Auto-generated method stub
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);
		
		CommunicatePlateauParameter param = (CommunicatePlateauParameter)parameter;
		ChPwAdvinfo advinfo = new ChPwAdvinfo();
		advinfo.setType(Long.valueOf("2"));
		advinfo.setNdapproval(Long.valueOf("0"));
		advinfo.setDesttype(Long.valueOf("6"));
		int DATE_INTERVAL = 
			Integer.parseInt(ConfigUtil.
					getCommonConfig(FileDictionary.COMMUNICATE_FILE, CommunicateConfig.DATE_INTERVAL));
		advinfo.setEnddate(DateUtil.DateDiff("M", new java.util.Date(), DATE_INTERVAL));
		advinfo.setOprcode(member.getEmployeeid());
		advinfo.setState(Long.valueOf("3"));
		advinfo.setReleasetime(new java.util.Date());
		advinfo.setTitle(param.getTitle());
		advinfo.setContent(param.getContent());
		this.getDao().save(advinfo);
		
		result.setSuccess(true);
		result.setRetCode(ServiceRetCode.SUCCESS);
		return result;
	}
	
	public ServiceResult closeQuestion(QueryParameter parameter) {
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);
		
		CommunicatePlateauDao cpDao = (CommunicatePlateauDao)this.getDao();
		CommunicatePlateauParameter param = (CommunicatePlateauParameter)parameter;
		ChPwAdvinfo advinfo = (ChPwAdvinfo)cpDao.get(param.getAdvinfoid());
		advinfo.setState(Long.valueOf("4"));
		
		cpDao.update(advinfo);
		
		result.setSuccess(true);
		result.setRetCode(ServiceRetCode.SUCCESS);
		return result;
	}
	
	public ServiceResult readPendingTask(QueryParameter parameter) {
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);
		
		CommunicatePlateauDao cpDao = (CommunicatePlateauDao)this.getDao();
		CommunicatePlateauParameter param = (CommunicatePlateauParameter)parameter;
		long advinfoid = param.getAdvinfoid();
		ChPwAdvinfo advinfo = null;
		try {
			try {
				advinfo = (ChPwAdvinfo)cpDao.get(advinfoid);
			}catch(ObjectRetrievalFailureException ex) {
				result.setRetCode(CommunicatePlateauRetCode.ADVINFO_NOT_EXIST);
				return result;
			}
			ChPwRcvobj obj = (ChPwRcvobj)(cpDao.getRcvobjByIds(param));
			if(obj == null) {
				obj = new ChPwRcvobj();
				obj.setAdvinfo(advinfo);
				obj.setObjid(param.getEmployeeid());
				obj.setChecktime(new java.util.Date());
				obj.setState(Long.valueOf("1"));
				obj.setStatetime(new java.util.Date());
				chPwRcvobjDao.save(obj);
			}else {
				if(obj.getChecktime() == null) {
					obj.setChecktime(new java.util.Date());
					chPwRcvobjDao.update(obj);
				}
			}
		}catch(Exception ex) {
			String message = ConfigUtil.
								getMessage(ServiceCode.COMMUNICATE, 
										CommunicatePlateauRetCode.COMMISSION_TASK_FAIL);
			// 可在Action捕获此异常，得到message并set到ServiceResult的message中
			throw new TransactionProcessionException(message);
		}
		result.setSuccess(true);
		result.setRetCode(ServiceRetCode.SUCCESS);
		return result;
	}
	
	public ServiceResult finishPendingTask(QueryParameter parameter) {
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);
		
		CommunicatePlateauDao cpDao = (CommunicatePlateauDao)this.getDao();
		CommunicatePlateauParameter param = (CommunicatePlateauParameter)parameter;
		
		ChPwRcvobj rcvObj = cpDao.getRcvobjByIds(param);
		rcvObj.setState(Long.valueOf("2"));
		chPwRcvobjDao.update(rcvObj);
		
		result.setSuccess(true);
		result.setRetCode(ServiceRetCode.SUCCESS);
		return result;
	}
	/**
	 * 这里实现公告/业务/知识库/待办任务/调查问卷 查询
	 */
	public ServiceResult query(LoginMember member, QueryParameter parameter) {
		// TODO Auto-generated method stub
		/**
		CommunicatePlateauParameter param = (CommunicatePlateauParameter)parameter;
		if(param.getType().equals((CPDictionary.PENDING_REQUEST))){//查询待办业务
			//需要查询系统参数，做"待办任务"的屏蔽处理
			String systemParam = this.ibGlSysparamService.getSysValue(5, "pboss_Web");
			if(systemParam!=null){//屏蔽参数存在
				this.setProcessor(new CommunicatePlateauParameterProcessor(systemParam));
			}else{//屏蔽参数不存在
				this.setProcessor(new CommunicatePlateauParameterProcessor());
			}			
		}else{//其他非待办业务
			this.setProcessor(new CommunicatePlateauParameterProcessor());
		}
		*/
		CommunicatePlateauParameter param = (CommunicatePlateauParameter)parameter;
		if(param.getType().equals((CPDictionary.PENDING_REQUEST))){//查询待办业务
			//需要查询系统参数，做"待办任务"的屏蔽处理
			String systemParam = this.ibGlSysparamService.getSysValue(5, "pboss_Web");
			if(systemParam!=null){//屏蔽参数存在
				//this.setProcessor(new CommunicatePlateauParameterProcessor(systemParam));
				((CommunicatePlateauParameterProcessor)this.getProcessor()).setSystemParam(systemParam);
			}else{//屏蔽参数不存在
				//this.setProcessor(new CommunicatePlateauParameterProcessor());
				((CommunicatePlateauParameterProcessor)this.getProcessor()).setSystemParam(null);
			}			
		}else{//其他非待办业务
			//this.setProcessor(new CommunicatePlateauParameterProcessor());
			((CommunicatePlateauParameterProcessor)this.getProcessor()).setSystemParam(null);
		}
		return super.query(member, parameter);
	}
	
	/**
	 * 这里实现公告/业务/知识库信息查阅/提问查看
	 */
	public ServiceResult queryForOne(LoginMember member,
			QueryParameter parameter) {
		// TODO Auto-generated method stub
		
		ServiceResult result = null;
		boolean isSuccess = false;
		int retCode = CommunicatePlateauRetCode.FAIL;
		
		CommunicatePlateauParameter param = (CommunicatePlateauParameter)parameter;
		long advinfoid = param.getAdvinfoid();
		
		result = findAdvInfo(advinfoid);
		if(!result.isSuccess())return result;
		
		//信息
		ChPwAdvinfo advinfo = (ChPwAdvinfo)result.getRetObject();
		String type = advinfo.getType().toString();
		
		//查询附件
		AdvaffixDao affixDao = (AdvaffixDao)this.getAdvaffixDao();
		List<ChPwAdvaffix> affixs = 
			affixDao.doQueryAffixByAdvinfoid(advinfoid);
		
		// 非知识库,非调查问卷和非在线问答
		if(!CPDictionary.QUESTIONNAIRE.equals(type) && 
			!CPDictionary.KNOWLEDGE.equals(type) && 
			!CPDictionary.INTERLOCUTION.equals(type)) {
			
			result = this.renewalRecvobj(param, advinfo);
			if(!result.isSuccess())return result;
		}
		
		CommunicatePlateauVO cpVo = new CommunicatePlateauVO();
		cpVo.setAdvinfo(advinfo);
		cpVo.setAdvaffixs(affixs);
		result.setRetObject(cpVo);
//		result.setRetResult(null);
		
		isSuccess = true;
		retCode = CommunicatePlateauRetCode.SUCCESS;
		
		result.setSuccess(isSuccess);
		result.setRetCode(retCode);
		return result;
	}
	
	public ServiceResult queryForPublic(String cityid ,String advinfoid){
		
		ServiceResult result = new ServiceResult();
		
		boolean isSuccess = false;
		int retCode = CommunicatePlateauRetCode.FAIL;
		
		ChPwAdvinfo advinfo = null;
		try {
			List<ChPwAdvinfo> list = getPublicInfoByCityid(cityid);
			for(int i = 0 ; i<list.size();i++){
				if(Long.valueOf(list.get(i).getAdvinfoid()).equals(Long.valueOf(advinfoid))){
					advinfo = list.get(i);
				}
			}
			result.setRetObject(advinfo);
			isSuccess = true;
			retCode = CommunicatePlateauRetCode.SUCCESS;
		}
		catch(ObjectRetrievalFailureException ex) {
			retCode = CommunicatePlateauRetCode.ADVINFO_NOT_EXIST;
		}
		result.setSuccess(isSuccess);
		result.setRetCode(retCode);
		return result;
	}
	
	public String queryForPublicAffix(String cityid ,String advinfoid,String affixid){
		ChPwAdvinfo advinfo = null;
		String path = "";
		ServiceResult result= queryForPublic(cityid,advinfoid);
		ChPwAdvinfo c = (ChPwAdvinfo)result.getRetObject();
		Set<ChPwAdvaffix> set = c.getAffixs();
		for(Iterator<ChPwAdvaffix> it = set.iterator();it.hasNext();){
			ChPwAdvaffix affix = it.next();
			if(Long.valueOf(affix.getAdvinfoid()).equals(Long.valueOf(affixid))){
				path = affix.getAffixpath();
			}
		}
		return path;
	}
	
	/**
	 * 查询接受对象表是否有记录。不存在，新增一条接受对象记录；
	 * 存在，判断查看时间（CHECKTIME）如果为空，则更新查看时间为当前时间
	 * @return
	 */
	public ServiceResult renewalRecvobj(CommunicatePlateauParameter param, ChPwAdvinfo advinfo){
		ServiceResult result = new ServiceResult();
		
		boolean isSuccess = false;
		int retCode = CommunicatePlateauRetCode.FAIL;
		
		CommunicatePlateauDao cpDao = (CommunicatePlateauDao)this.getDao();
		ChPwRcvobj obj = (ChPwRcvobj)(cpDao.getRcvobjByIds(param));
		//不存在
		if(obj == null) {
			obj = new ChPwRcvobj();
			obj.setAdvinfo(advinfo);
			obj.setObjid(param.getEmployeeid());
			obj.setChecktime(new java.util.Date());
			obj.setState(CPDictionary.OS_OPEN);
			obj.setStatetime(new java.util.Date());
			chPwRcvobjDao.save(obj);
		}
		//判断查看时间（CHECKTIME）如果为空
		else if(obj.getChecktime() == null) {
			obj.setChecktime(new java.util.Date());
			chPwRcvobjDao.update(obj);
		}
		
		isSuccess = true;
		retCode = CommunicatePlateauRetCode.SUCCESS;
		
		result.setSuccess(isSuccess);
		result.setRetCode(retCode);
		return result;
	}
	
	/**
	 * 根据信息ID查询信息
	 * @param advinfoid
	 * @return
	 */
	public ServiceResult findAdvInfo(long advinfoid){
		ServiceResult result = new ServiceResult();
		
		boolean isSuccess = false;
		int retCode = CommunicatePlateauRetCode.FAIL;

		CommunicatePlateauDao cpDao = (CommunicatePlateauDao)this.getDao();
		ChPwAdvinfo advinfo = null;
		try {
			advinfo = (ChPwAdvinfo)cpDao.get(advinfoid);
			result.setRetObject(advinfo);
			isSuccess = true;
			retCode = CommunicatePlateauRetCode.SUCCESS;
		}
		catch(ObjectRetrievalFailureException ex) {
			retCode = CommunicatePlateauRetCode.ADVINFO_NOT_EXIST;
		}
		
		result.setSuccess(isSuccess);
		result.setRetCode(retCode);
		return result;
	}
	
	/**
	 * 根据附件ID查询附件信息
	 */
	public ServiceResult findAffix(String affxid) {
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);
		ChPwAdvaffix aff =  (ChPwAdvaffix)advaffixDao.get(Long.valueOf(affxid));
		result.setSuccess(true);
		result.setRetCode(ServiceRetCode.SUCCESS);
		result.setRetObject(aff);
		return result;
	}
	
	/**
	 * 这里调用reply , read , createQuestion , closeQuestion,readPendingTask,finishPendingTask方法
	 */
	public ServiceResult other(LoginMember member, QueryParameter parameter) {
		ServiceResult result = null;
		int operation = parameter.getOperation();
		switch(operation){
			case CommunicatePlateauOperation.REPLAY:
				result = this.replay(parameter);
				break;
			case CommunicatePlateauOperation.READ:
				result = this.read(parameter);
				break;
			case CommunicatePlateauOperation.CREATE_QUESTION:
				result = this.createQuestion(member, parameter);
				break;
			case CommunicatePlateauOperation.CLOSE_QUESTION:
				result = this.closeQuestion(parameter);
				break;
			case CommunicatePlateauOperation.READ_PENDING_TASK:
				result = this.readPendingTask(parameter);
				break;
			case CommunicatePlateauOperation.FINISH_PENDING_TASK:
				result = this.finishPendingTask(parameter);
				break;
		}
		return result;
	}

	public ChPwRcvobjDao getChPwRcvobjDao() {
		return chPwRcvobjDao;
	}

	public void setChPwRcvobjDao(ChPwRcvobjDao chPwRcvobjDao) {
		this.chPwRcvobjDao = chPwRcvobjDao;
	}

	public AdvaffixDao getAdvaffixDao() {
		return advaffixDao;
	}

	public void setAdvaffixDao(AdvaffixDao advaffixDao) {
		this.advaffixDao = advaffixDao;
	}

	public ReplyDao getReplyDao() {
		return replyDao;
	}

	public void setReplyDao(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}
	
	public void setIbGlSysparamService(IbGlSysparamService ibGlSysparamService){
		this.ibGlSysparamService = ibGlSysparamService;
	}
}
