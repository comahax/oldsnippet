package com.gmcc.pboss.biz.info.reward.action;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.biz.communi.service.CommunicatePlateauOperation;
import com.gmcc.pboss.biz.communi.service.CommunicatePlateauService;
import com.gmcc.pboss.biz.communi.support.CommunicatePlateauParameter;
import com.gmcc.pboss.biz.info.reward.model.BbcRewardTotal;
import com.gmcc.pboss.biz.info.reward.model.RewardRecord;
import com.gmcc.pboss.biz.info.reward.service.RewardLocalService;
import com.gmcc.pboss.biz.info.reward.service.RewardService;
import com.gmcc.pboss.biz.info.reward.support.BbcRewardQueryParameter;
import com.gmcc.pboss.biz.info.reward.support.RewardKind;
import com.gmcc.pboss.biz.info.reward.support.RewardQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.common.util.CommonUtil;
import com.gmcc.pboss.common.util.DateUtil;
import com.gmcc.pboss.model.communi.ChPwAdvinfo;
import com.gmcc.pboss.model.reward.rewardlocal.ChPwRewardlocal;
import com.gmcc.pboss.model.reward.rewardlocal.ChPwRewardlocaltitle;
import com.gmcc.pboss.biz.info.reward.model.BbcRewardRecord;

public class RewardTotalAction extends RewardRecordAction {
	private String _backURL;

	private RewardQueryParameter parameter;
	private String wayType;
	private double sumReward = 0;
	//运行数组
	private List<RewardRecord> cardReward = new ArrayList<RewardRecord>();//套卡酬金
	private List<RewardRecord> servReward = new ArrayList<RewardRecord>();//服务业务酬金
	private List<RewardRecord> dateReward = new ArrayList<RewardRecord>();//数据业务酬金
	private List tempReward = new ArrayList();//其它酬金
	private List<RewardRecord> allRewards = new ArrayList<RewardRecord>();//其它酬金
	
	private Double cardRewardTtl = 0.0;
	private Double servRewardTtl = 0.0;
	private Double dateRewardTtl = 0.0;
	private Double tempRewardTtl = 0.0;
	private Double allRewardTtl = 0.0;
	
	private ServiceResult servResult;
	//网站渠道BBC查询
	//private RewardService bbcRewardTotalService;
	private RewardService bbcRewardGenService;
	
	private boolean queryAG = true;
	
	//月实际支付酬金报表-社会渠道
	private RewardService rewardTotalService;
	//月实际支付酬金报表-网站渠道
	private RewardService bbcRewardTotalService;
	//酬金余额查询 
	private RewardService rewardBalanceService;
	private QueryResult result;
	//本地酬金
	private RewardLocalService rewardLocalService;
	
	//社会渠道网点月实际支付酬金确认
	private String taskID;
	private boolean confirm;
	private boolean confirmAction;
	private CommunicatePlateauService communicatePlateauService;
	//本地酬金查询是否查询
	private boolean query = false;
	//主表对象
	private ChPwRewardlocal rewardLocal = null;
	//主表对象
	private List<ChPwRewardlocal> rewardLocalList = null;
	//标题表列表
	private List<ChPwRewardlocaltitle> ttlList = null;
	
	public QueryParameter getParameter() {

		parameter = parameter == null ? new RewardQueryParameter() : parameter;		
		
		parameter.setAction(QueryAction.ALL);
//		// 不用翻页设置页码
//		if (this.getPageNo() != null)
//			parameter.setNo(getPageNo().intValue());// 设置页码
//		if (this.getPageSize() != null)
//			parameter.setSize(getPageSize().intValue());// 设置大小

		LoginMember member = getMember();
		parameter.setWayid(member.getWayid());
		
		if (StringUtils.isEmpty(parameter.getMonth())){
			//默认上一个月的数据
			parameter.setMonth(CommonUtil.getMonth());
		}
//		手工调数
//		parameter.setMonth("200907");
		//取汇总的数据
		parameter.setGroup(true);
		return parameter;
	}
	
	/**
	 * @param parameter the parameter to set
	 */
	public void setParameter(RewardQueryParameter parameter) {
		this.parameter = parameter;
	}

	/**
	 * @return the bbcRewardTotalService
	 */
	public RewardService getBbcRewardTotalService() {
		return bbcRewardTotalService;
	}

	/**
	 * @param bbcRewardTotalService the bbcRewardTotalService to set
	 */
	public void setBbcRewardTotalService(RewardService bbcRewardTotalService) {
		this.bbcRewardTotalService = bbcRewardTotalService;
	}
	
	public RewardService getBbcRewardGenService() {
		return bbcRewardGenService;
	}
	public void setBbcRewardGenService(RewardService bbcRewardGenService) {
		this.bbcRewardGenService = bbcRewardGenService;
	}

	/**
	 * @return the sumReward
	 */
	public double getSumReward() {
		return sumReward;
	}

	/**
	 * @param sumReward the sumReward to set
	 */
	public void setSumReward(double sumReward) {
		this.sumReward = sumReward;
	}

	/**
	 * @return the _backURL
	 */
	public String get_backURL() {
		return _backURL;
	}
	/**
	 * @param _backurl the _backURL to set
	 */
	public void set_backURL(String _backurl) {
		_backURL = _backurl;
	}
	
	/**
	 * @return the cardReward
	 */
	public List<RewardRecord> getCardReward() {
		return cardReward;
	}
	/**
	 * @param cardReward the cardReward to set
	 */
	public void setCardReward(List<RewardRecord> cardReward) {
		this.cardReward = cardReward;
	}
	/**
	 * @return the servReward
	 */
	public List<RewardRecord> getServReward() {
		return servReward;
	}
	/**
	 * @param servReward the servReward to set
	 */
	public void setServReward(List<RewardRecord> servReward) {
		this.servReward = servReward;
	}
	/**
	 * @return the dateReward
	 */
	public List<RewardRecord> getDateReward() {
		return dateReward;
	}
	/**
	 * @param dateReward the dateReward to set
	 */
	public void setDateReward(List<RewardRecord> dateReward) {
		this.dateReward = dateReward;
	}
	/**
	 * @return the tempReward
	 */
	public List getTempReward() {
		return tempReward;
	}
	/**
	 * @param tempReward the tempReward to set
	 */
	public void setTempReward(List tempReward) {
		this.tempReward = tempReward;
	}
	
	/**
	 * @return the allRewards
	 */
	public List<RewardRecord> getAllRewards() {
		return allRewards;
	}

	/**
	 * @param allRewards the allRewards to set
	 */
	public void setAllRewards(List<RewardRecord> allRewards) {
		this.allRewards = allRewards;
	}

	/**
	 * @return the servResult
	 */
	public ServiceResult getServResult() {
		return servResult;
	}
	/**
	 * @param servResult the servResult to set
	 */
	public void setServResult(ServiceResult servResult) {
		this.servResult = servResult;
	}
	
	
	/**
	 * @return the wayType
	 */
	public String getWayType() {
		return wayType;
	}

	/**
	 * @param wayType the wayType to set
	 */
	public void setWayType(String wayType) {
		this.wayType = wayType;
	}

	/**
	 * @return the queryBBC
	 */
	public boolean isQueryAG() {
		return queryAG;
	}

	/**
	 * @param queryBBC the queryBBC to set
	 */
	public void setQueryAG(boolean queryAG) {
		this.queryAG = queryAG;
	}

	/**
	 * @return the rewardTotalService
	 */
	public RewardService getRewardTotalService() {
		return rewardTotalService;
	}

	/**
	 * @param rewardTotalService the rewardTotalService to set
	 */
	public void setRewardTotalService(RewardService rewardTotalService) {
		this.rewardTotalService = rewardTotalService;
	}


	public RewardService getRewardBalanceService() {
		return rewardBalanceService;
	}

	public void setRewardBalanceService(RewardService rewardBalanceService) {
		this.rewardBalanceService = rewardBalanceService;
	}

	/**
	 * @return the result
	 */
	public QueryResult getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(QueryResult result) {
		this.result = result;
	}

	/**
	 * @return the taskID
	 */
	public String getTaskID() {
		return taskID;
	}

	/**
	 * @param taskID the taskID to set
	 */
	public void setTaskID(String taskID) {
		this.taskID = taskID;
	}

	/**
	 * @return the confirm
	 */
	public boolean isConfirm() {
		return confirm;
	}

	/**
	 * @param confirm the confirm to set
	 */
	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}

	/**
	 * @return the confirmAction
	 */
	public boolean isConfirmAction() {
		return confirmAction;
	}

	/**
	 * @param confirmAction the confirmAction to set
	 */
	public void setConfirmAction(boolean confirmAction) {
		this.confirmAction = confirmAction;
	}

	/**
	 * @return the communicatePlateauService
	 */
	public CommunicatePlateauService getCommunicatePlateauService() {
		return communicatePlateauService;
	}

	/**
	 * @param communicatePlateauService the communicatePlateauService to set
	 */
	public void setCommunicatePlateauService(
			CommunicatePlateauService communicatePlateauService) {
		this.communicatePlateauService = communicatePlateauService;
	}

	/**
	 * 月度应发酬金报表
	 * 生成页面
	 */
	public String doList() {
		setTitle(PageLoction.RewardTotalList);
		setQueryAG("".equals(wayType)||wayType==null);
		LoginMember member = getMember();
		if (!isQueryAG()){//查询网站渠道表			
			BbcRewardQueryParameter bbcParam = new BbcRewardQueryParameter();
			RewardQueryParameter queryParam = (RewardQueryParameter)this.getParameter();
			//使用新的查询参数
			bbcParam.setAction(QueryAction.ALL);
			bbcParam.setWayid(member.getWayid());
			bbcParam.setMonth(queryParam.getMonth());
			bbcParam.setGroup(queryParam.isGroup());
			if(wayType.equals("BBC")){
				bbcParam.setRewardKind(RewardKind.B2M);
			}
			else{//wayType.equels("UNPB")
				bbcParam.setRewardKind(RewardKind.UNPB);
			}
			//this.servResult = this.bbcRewardTotalService.transact(member, bbcParam, ServiceType.QUERY);
			this.servResult = this.bbcRewardGenService.transact(member, bbcParam, ServiceType.QUERY);
		}else{//查询社会渠道表			
			this.servResult = getService().transact(member, getParameter(), ServiceType.QUERY);
		}//if
		
		if (this.servResult.isSuccess()){
				//设置统计总金额
				this.sumReward = 0;
				//创建配置数组
				this.allRewards =  this.servResult.getRetResult().getData();//提取数据
				for (Object obj:allRewards ){
					if (!isQueryAG()){
						//BbcRewardTotal dtl =(BbcRewardTotal) obj;
						BbcRewardRecord dtl = (BbcRewardRecord) obj;
						tempReward.add(dtl);
						//统计总金额
						//this.sumReward += dtl.getPaymoney().doubleValue();
						this.sumReward +=dtl.getPaysum().doubleValue();
					}else{
						RewardRecord dtl =(RewardRecord) obj;	
						//日期合成
						dtl.setPaymonth1(CommonUtil.getShowMonth(dtl.getPaymonth1()));
						if (StringUtils.isNotEmpty(dtl.getPaymonth2())){
							//日期合成
							dtl.setPaymonth2(CommonUtil.getShowMonth(dtl.getPaymonth2()));
						}
						if (StringUtils.isNotEmpty(dtl.getPaymonth3())){
							//日期合成
							dtl.setPaymonth3(CommonUtil.getShowMonth(dtl.getPaymonth3()));
						}
						//统计总金额
						this.sumReward += dtl.getPaysum().doubleValue();
//						System.out.println(">>>>>dtl.paysum"+dtl.getPaysum().doubleValue());
						if (dtl.getRewardtype()==0 || dtl.getRewardtype()==1 || dtl.getRewardtype()==2 ){
							//套卡酬金 - 类型为0-标准卡固定酬金、1-标准卡积分酬金、2-标准卡专门津贴
							cardReward.add(dtl);
							cardRewardTtl += dtl.getPaysum().doubleValue();
						}else if (dtl.getRewardtype()==3 || dtl.getRewardtype()==4){
							//数据业务酬金  类型为3-数据业务基本酬金,4-数据业务奖励酬金
							dateReward.add(dtl);
							dateRewardTtl += dtl.getPaysum().doubleValue();
						}else if (dtl.getRewardtype()==5 || dtl.getRewardtype()==6){
							//服务业务酬金 类型为5-服务业务基本酬金,6-服务业务奖励酬金
							servReward.add(dtl);
							servRewardTtl += dtl.getPaysum().doubleValue();
						}else {
							tempReward.add(dtl);
							tempRewardTtl  += dtl.getPaysum().doubleValue();
						}//if
					}					
				}//for
		}else{
			this.setMessage(this.servResult.getMessage());
		}
		if (!isQueryAG()){
			if(wayType.equals("BBC"))
				return "BBCPAGE";
			else
				return "UNPBPAGE";
		}
		return this.execute();
//		setMessage(result.getMessage());
//
//		setResult(result.getRetResult());
		
	}

	/**
	 * 月实际支付酬金报表
	 * 生成页面
	 */
	public String doRPayList(){
		setTitle(PageLoction.RewardRealPayList);
		setQueryAG("".equals(wayType)||wayType==null);
		LoginMember member = getMember();
		if (!isQueryAG()){//查询网站渠道			
			BbcRewardQueryParameter bbcParam = new BbcRewardQueryParameter();
			RewardQueryParameter queryParam = (RewardQueryParameter)this.getParameter();
			//使用新的查询参数
			bbcParam.setAction(QueryAction.ALL);
			bbcParam.setWayid(member.getWayid());
			bbcParam.setMonth(queryParam.getMonth());
			bbcParam.setGroup(true);
			if(wayType.equals("BBC")){
				bbcParam.setRewardKind(RewardKind.B2M);
			}
			else{//wayType.equels("UNPB")
				bbcParam.setRewardKind(RewardKind.UNPB);
			}
			this.servResult = this.bbcRewardTotalService.transact(member, bbcParam, ServiceType.QUERY);
		}
		else{//查询社会渠道表			
			this.servResult = this.rewardTotalService.transact(member, getParameter(), ServiceType.QUERY);
		}
		//查询社会渠道表
		//this.servResult = this.rewardTotalService.transact(member, getParameter(), ServiceType.QUERY);
		
		if (!this.servResult.isSuccess()){
			this.setMessage(this.servResult.getMessage());
		}else{
			this.setResult(servResult.getRetResult());
		}
		if(!isQueryAG()){
			if(wayType.equals("BBC"))
				return "BBCPAGE";
			else
				return "UNPBPAGE";
		}
		return this.execute();
	}
	/**
	 * 社会渠道网点月实际支付酬金报表  确认
	 * 生成页面
	 */
	public String doPTConfirm(){
		LoginMember member = getMember();
		this.setConfirmAction(true);
		setTitle(PageLoction.RewardRealPayList);
		
		//调用【待办任务查看】Service.readPendingTask接口
		CommunicatePlateauParameter comParam = new CommunicatePlateauParameter();
		
		try{
			comParam.setAdvinfoid(new Long(this.taskID));
			comParam.setEmployeeid(member.getEmployeeid());
			comParam.setOperation(CommunicatePlateauOperation.READ_PENDING_TASK);
			ServiceResult servReslt = communicatePlateauService.transactionProcessing(member, comParam, ServiceType.OTHER);	
			if (!servReslt.isSuccess()){
				this.setMessage(servReslt.getMessage());
				this.set_backURL(INPUT);
				return ERROR;
			}
		}catch(Exception e){
			this.setMessage(e.getMessage());
			this.set_backURL(INPUT);
			return ERROR;
		}
		//查询待办数据
		RewardQueryParameter param = new RewardQueryParameter();
		param.setOpnid(this.taskID);
		ServiceResult servAdvinfoid = this.rewardTotalService.transact(member, param, ServiceType.QUERY_ONE); 
		if (!servAdvinfoid.isSuccess()){
			this.setMessage(servAdvinfoid.getMessage());
			this.set_backURL(INDEX);
			return ERROR;
		}//if
		ChPwAdvinfo advinfo = (ChPwAdvinfo) servAdvinfoid.getRetObject();
		//状态判断
		if (advinfo.getState()!=4){
			this.setConfirm(true);
		}else{
			this.setConfirm(false);
		}
		param = (RewardQueryParameter) getParameter();//提取查询条件
		Date dateSet = advinfo.getReleasetime();
		param.setMonth(DateUtil.getCustomerMonth(dateSet));//设置默认查询日期
		System.out.println(">>>>>DATE::"+param.getMonth());
		//查询社会渠道表
		this.servResult = this.rewardTotalService.transact(member, param, ServiceType.QUERY);
		
		if (!this.servResult.isSuccess()){
			this.setMessage(this.servResult.getMessage());
		}else{
			this.setResult(servResult.getRetResult());
		}
		return this.execute();
	}
	/**
	 * 酬金余额查询
	 * 生成页面
	 */
	public String doBalance(){
		setTitle(PageLoction.RewardBalance);
		//查询数据

		LoginMember member = getMember();
		//查询月份：默认查询当前月
		RewardQueryParameter param = (RewardQueryParameter) getParameter();
		param.setMonth(CommonUtil.getNowMonthString());
//		param.setMonth("200908");
		
		//查询社会渠道表
		this.servResult = this.rewardBalanceService.transact(member, param, ServiceType.OTHER);
		
		if (!this.servResult.isSuccess()){
			this.setMessage(this.servResult.getMessage());
		}else{
			this.setResult(servResult.getRetResult());
		}
		return this.execute();
	}

	/**
	 * 本地酬金查询 
	 * @return
	 */
	public String doLocalReward(){
		setTitle(PageLoction.RewardLocal);
		//结算月份、报表类型分析对应RewardQueryParameter的month和rewardtype
		
		if (this.parameter ==null ){ 
			this.query = false;
			return this.execute();	
		}else if (this.parameter.getMonth()==null || this.parameter.getRewardtype()==null){
			this.query = false;
			return this.execute();				
		}//if
		
		this.query = true;
		this.servResult = this.rewardLocalService.transact(getLogMember(), this.getParameter(), ServiceType.QUERY);
		if (this.servResult.isSuccess()){
			if(!ConstantsType.RPWDLocalRPT.equals(this.parameter.getRewardtype())){
				Object [] rtnObj = (Object[]) this.servResult.getRetObject();
				//设置相关对象
				if (ConstantsType.RRWDSumRPT.equals(parameter.getRewardtype())){
					this.setRewardLocal((ChPwRewardlocal) rtnObj[0]);
					parameter.setNowDate(new Date());
					parameter.setZhmonth(parameter.getMonth().substring(0, 4)+"年"+parameter.getMonth().substring(4, parameter.getMonth().length())+"月");
				}else{
					this.setRewardLocalList((List<ChPwRewardlocal>) rtnObj[0]);
				}
				this.setTtlList((List<ChPwRewardlocaltitle>) rtnObj[1]);
			}
		}else{
			this.setMessage(this.servResult.getMessage());
		}
		return this.execute();	
	}
	/**
	 * 本地酬金明细查询 
	 * @return
	 */
	public String doLocalRewardDtl(){
		setTitle(PageLoction.RewardLocal);
		//结算月份、报表类型分析对应RewardQueryParameter的month和rewardtype
		
		if (this.parameter ==null ){ 
			this.query = false;
			return this.execute();	
		}else if (this.parameter.getMonth()==null || this.parameter.getRewardtype()==null){
			this.query = false;
			return this.execute();				
		}//if
		
		this.query = true;
		this.servResult = this.rewardLocalService.queryDtl(getLogMember(), this.getParameter());
		
		return this.execute();	
	}
	/**
	 * 提取酬金余额查询 时间: N-6名称 
	 * @return
	 */
	public String getBalanceTime6(){
		return setBalanceTime(6);
	}
	/**
	 * 提取酬金余额查询 时间: N-5名称 
	 * @return
	 */
	public String getBalanceTime5(){
		return setBalanceTime(5);
	}
	/**
	 * 提取酬金余额查询 时间: N-4名称 
	 * @return
	 */
	public String getBalanceTime4(){
		return setBalanceTime(4);
	}
	/**
	 * 提取酬金余额查询 时间: N-3名称 
	 * @return
	 */
	public String getBalanceTime3(){
		return setBalanceTime(3);
	}
	/**
	 * 提取酬金余额查询 时间: N-2名称 
	 * @return
	 */
	public String getBalanceTime2(){
		return setBalanceTime(2);
	}
	/**
	 * 提取酬金余额查询 时间: N-2名称 
	 * @return
	 */
	public String getBalanceTime1(){
		return setBalanceTime(1);
	}
	/**
	 * 计算酬金余额查询时间 ,N-i方式：
	 * @return
	 */
	protected String setBalanceTime(int i){ 
		RewardQueryParameter param = (RewardQueryParameter)this.getParameter();
		String setParam = param.getMonth()+"01";
		try {
			Date getSet = DateUtil.convertStringToDate("yyyyMMdd",setParam);
			getSet = DateUtil.DateDiff("M", getSet, -i);
			return CommonUtil.getDateTime(getSet, 42);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("[RewardTotalAction.setBalanceTime("+i+")]日期转换出错:"+e.getMessage());
			logger.warn("[RewardTotalAction.setBalanceTime("+i+")]日期转换出错:"+e.getMessage());
			return "";
		}
	}
	/**
	 * 提取页面显示时间名称
	 * @return
	 */
	public String getShowTimeName(){
		RewardQueryParameter param = (RewardQueryParameter)this.getParameter();
		String setParam = param.getMonth()+"01";
		try {
			Date getSet = DateUtil.convertStringToDate("yyyyMMdd",setParam);
			return CommonUtil.getDateTime(getSet, 42);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("[RewardTotalAction.getShowTimeName]日期转换出错:"+e.getMessage());
			return null;
		}
	}
	
	/**
	 * 本地酬金类型
	 */
	public Map getReportType() {
		Map rewardLocalType =  Constant.getConstantsMap(ConstantsType.REWARDLOCALTYPE);
		Map rtn = new LinkedHashMap<String,String>();
		rtn.put("", "请选择");
		rtn.putAll(rewardLocalType);
		return rtn;
	}
	
	public LoginMember getLogMember(){
		LoginMember member = getMember();
		return member;
	}

	public Double getCardRewardTtl() {
		return cardRewardTtl;
	}

	public void setCardRewardTtl(Double cardRewardTtl) {
		this.cardRewardTtl = cardRewardTtl;
	}

	public Double getServRewardTtl() {
		return servRewardTtl;
	}

	public void setServRewardTtl(Double servRewardTtl) {
		this.servRewardTtl = servRewardTtl;
	}

	public Double getDateRewardTtl() {
		return dateRewardTtl;
	}

	public void setDateRewardTtl(Double dateRewardTtl) {
		this.dateRewardTtl = dateRewardTtl;
	}

	public Double getTempRewardTtl() {
		return tempRewardTtl;
	}

	public void setTempRewardTtl(Double tempRewardTtl) {
		this.tempRewardTtl = tempRewardTtl;
	}

	public Double getAllRewardTtl() {
		return allRewardTtl;
	}

	public void setAllRewardTtl(Double allRewardTtl) {
		this.allRewardTtl = allRewardTtl;
	}

	public List<ChPwRewardlocal> getRewardLocalList() {
		return rewardLocalList;
	}

	public void setRewardLocalList(List<ChPwRewardlocal> rewardLocalList) {
		this.rewardLocalList = rewardLocalList;
	}

	/**
	 * @return the rewardLocalService
	 */
	public RewardLocalService getRewardLocalService() {
		return rewardLocalService;
	}

	/**
	 * @param rewardLocalService the rewardLocalService to set
	 */
	public void setRewardLocalService(RewardLocalService rewardLocalService) {
		this.rewardLocalService = rewardLocalService;
	}

	/**
	 * @return the query
	 */
	public boolean isQuery() {
		return query;
	}

	/**
	 * @param query the query to set
	 */
	public void setQuery(boolean query) {
		this.query = query;
	}

	



	public ChPwRewardlocal getRewardLocal() {
		return rewardLocal;
	}

	/**
	 * @param rewardLocal the rewardLocal to set
	 */
	public void setRewardLocal(ChPwRewardlocal rewardLocal) {
		this.rewardLocal = rewardLocal;
	}

	/**
	 * @return the ttlList
	 */
	public List<ChPwRewardlocaltitle> getTtlList() {
		return ttlList;
	}

	/**
	 * @param ttlList the ttlList to set
	 */
	public void setTtlList(List<ChPwRewardlocaltitle> ttlList) {
		this.ttlList = ttlList;
	}
	
}
