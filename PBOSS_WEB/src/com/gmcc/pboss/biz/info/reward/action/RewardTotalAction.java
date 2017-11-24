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
	//��������
	private List<RewardRecord> cardReward = new ArrayList<RewardRecord>();//�׿����
	private List<RewardRecord> servReward = new ArrayList<RewardRecord>();//����ҵ����
	private List<RewardRecord> dateReward = new ArrayList<RewardRecord>();//����ҵ����
	private List tempReward = new ArrayList();//�������
	private List<RewardRecord> allRewards = new ArrayList<RewardRecord>();//�������
	
	private Double cardRewardTtl = 0.0;
	private Double servRewardTtl = 0.0;
	private Double dateRewardTtl = 0.0;
	private Double tempRewardTtl = 0.0;
	private Double allRewardTtl = 0.0;
	
	private ServiceResult servResult;
	//��վ����BBC��ѯ
	//private RewardService bbcRewardTotalService;
	private RewardService bbcRewardGenService;
	
	private boolean queryAG = true;
	
	//��ʵ��֧����𱨱�-�������
	private RewardService rewardTotalService;
	//��ʵ��֧����𱨱�-��վ����
	private RewardService bbcRewardTotalService;
	//�������ѯ 
	private RewardService rewardBalanceService;
	private QueryResult result;
	//���س��
	private RewardLocalService rewardLocalService;
	
	//�������������ʵ��֧�����ȷ��
	private String taskID;
	private boolean confirm;
	private boolean confirmAction;
	private CommunicatePlateauService communicatePlateauService;
	//���س���ѯ�Ƿ��ѯ
	private boolean query = false;
	//�������
	private ChPwRewardlocal rewardLocal = null;
	//�������
	private List<ChPwRewardlocal> rewardLocalList = null;
	//������б�
	private List<ChPwRewardlocaltitle> ttlList = null;
	
	public QueryParameter getParameter() {

		parameter = parameter == null ? new RewardQueryParameter() : parameter;		
		
		parameter.setAction(QueryAction.ALL);
//		// ���÷�ҳ����ҳ��
//		if (this.getPageNo() != null)
//			parameter.setNo(getPageNo().intValue());// ����ҳ��
//		if (this.getPageSize() != null)
//			parameter.setSize(getPageSize().intValue());// ���ô�С

		LoginMember member = getMember();
		parameter.setWayid(member.getWayid());
		
		if (StringUtils.isEmpty(parameter.getMonth())){
			//Ĭ����һ���µ�����
			parameter.setMonth(CommonUtil.getMonth());
		}
//		�ֹ�����
//		parameter.setMonth("200907");
		//ȡ���ܵ�����
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
	 * �¶�Ӧ����𱨱�
	 * ����ҳ��
	 */
	public String doList() {
		setTitle(PageLoction.RewardTotalList);
		setQueryAG("".equals(wayType)||wayType==null);
		LoginMember member = getMember();
		if (!isQueryAG()){//��ѯ��վ������			
			BbcRewardQueryParameter bbcParam = new BbcRewardQueryParameter();
			RewardQueryParameter queryParam = (RewardQueryParameter)this.getParameter();
			//ʹ���µĲ�ѯ����
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
		}else{//��ѯ���������			
			this.servResult = getService().transact(member, getParameter(), ServiceType.QUERY);
		}//if
		
		if (this.servResult.isSuccess()){
				//����ͳ���ܽ��
				this.sumReward = 0;
				//������������
				this.allRewards =  this.servResult.getRetResult().getData();//��ȡ����
				for (Object obj:allRewards ){
					if (!isQueryAG()){
						//BbcRewardTotal dtl =(BbcRewardTotal) obj;
						BbcRewardRecord dtl = (BbcRewardRecord) obj;
						tempReward.add(dtl);
						//ͳ���ܽ��
						//this.sumReward += dtl.getPaymoney().doubleValue();
						this.sumReward +=dtl.getPaysum().doubleValue();
					}else{
						RewardRecord dtl =(RewardRecord) obj;	
						//���ںϳ�
						dtl.setPaymonth1(CommonUtil.getShowMonth(dtl.getPaymonth1()));
						if (StringUtils.isNotEmpty(dtl.getPaymonth2())){
							//���ںϳ�
							dtl.setPaymonth2(CommonUtil.getShowMonth(dtl.getPaymonth2()));
						}
						if (StringUtils.isNotEmpty(dtl.getPaymonth3())){
							//���ںϳ�
							dtl.setPaymonth3(CommonUtil.getShowMonth(dtl.getPaymonth3()));
						}
						//ͳ���ܽ��
						this.sumReward += dtl.getPaysum().doubleValue();
//						System.out.println(">>>>>dtl.paysum"+dtl.getPaysum().doubleValue());
						if (dtl.getRewardtype()==0 || dtl.getRewardtype()==1 || dtl.getRewardtype()==2 ){
							//�׿���� - ����Ϊ0-��׼���̶����1-��׼�����ֳ��2-��׼��ר�Ž���
							cardReward.add(dtl);
							cardRewardTtl += dtl.getPaysum().doubleValue();
						}else if (dtl.getRewardtype()==3 || dtl.getRewardtype()==4){
							//����ҵ����  ����Ϊ3-����ҵ��������,4-����ҵ�������
							dateReward.add(dtl);
							dateRewardTtl += dtl.getPaysum().doubleValue();
						}else if (dtl.getRewardtype()==5 || dtl.getRewardtype()==6){
							//����ҵ���� ����Ϊ5-����ҵ��������,6-����ҵ�������
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
	 * ��ʵ��֧����𱨱�
	 * ����ҳ��
	 */
	public String doRPayList(){
		setTitle(PageLoction.RewardRealPayList);
		setQueryAG("".equals(wayType)||wayType==null);
		LoginMember member = getMember();
		if (!isQueryAG()){//��ѯ��վ����			
			BbcRewardQueryParameter bbcParam = new BbcRewardQueryParameter();
			RewardQueryParameter queryParam = (RewardQueryParameter)this.getParameter();
			//ʹ���µĲ�ѯ����
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
		else{//��ѯ���������			
			this.servResult = this.rewardTotalService.transact(member, getParameter(), ServiceType.QUERY);
		}
		//��ѯ���������
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
	 * �������������ʵ��֧����𱨱�  ȷ��
	 * ����ҳ��
	 */
	public String doPTConfirm(){
		LoginMember member = getMember();
		this.setConfirmAction(true);
		setTitle(PageLoction.RewardRealPayList);
		
		//���á���������鿴��Service.readPendingTask�ӿ�
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
		//��ѯ��������
		RewardQueryParameter param = new RewardQueryParameter();
		param.setOpnid(this.taskID);
		ServiceResult servAdvinfoid = this.rewardTotalService.transact(member, param, ServiceType.QUERY_ONE); 
		if (!servAdvinfoid.isSuccess()){
			this.setMessage(servAdvinfoid.getMessage());
			this.set_backURL(INDEX);
			return ERROR;
		}//if
		ChPwAdvinfo advinfo = (ChPwAdvinfo) servAdvinfoid.getRetObject();
		//״̬�ж�
		if (advinfo.getState()!=4){
			this.setConfirm(true);
		}else{
			this.setConfirm(false);
		}
		param = (RewardQueryParameter) getParameter();//��ȡ��ѯ����
		Date dateSet = advinfo.getReleasetime();
		param.setMonth(DateUtil.getCustomerMonth(dateSet));//����Ĭ�ϲ�ѯ����
		System.out.println(">>>>>DATE::"+param.getMonth());
		//��ѯ���������
		this.servResult = this.rewardTotalService.transact(member, param, ServiceType.QUERY);
		
		if (!this.servResult.isSuccess()){
			this.setMessage(this.servResult.getMessage());
		}else{
			this.setResult(servResult.getRetResult());
		}
		return this.execute();
	}
	/**
	 * �������ѯ
	 * ����ҳ��
	 */
	public String doBalance(){
		setTitle(PageLoction.RewardBalance);
		//��ѯ����

		LoginMember member = getMember();
		//��ѯ�·ݣ�Ĭ�ϲ�ѯ��ǰ��
		RewardQueryParameter param = (RewardQueryParameter) getParameter();
		param.setMonth(CommonUtil.getNowMonthString());
//		param.setMonth("200908");
		
		//��ѯ���������
		this.servResult = this.rewardBalanceService.transact(member, param, ServiceType.OTHER);
		
		if (!this.servResult.isSuccess()){
			this.setMessage(this.servResult.getMessage());
		}else{
			this.setResult(servResult.getRetResult());
		}
		return this.execute();
	}

	/**
	 * ���س���ѯ 
	 * @return
	 */
	public String doLocalReward(){
		setTitle(PageLoction.RewardLocal);
		//�����·ݡ��������ͷ�����ӦRewardQueryParameter��month��rewardtype
		
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
				//������ض���
				if (ConstantsType.RRWDSumRPT.equals(parameter.getRewardtype())){
					this.setRewardLocal((ChPwRewardlocal) rtnObj[0]);
					parameter.setNowDate(new Date());
					parameter.setZhmonth(parameter.getMonth().substring(0, 4)+"��"+parameter.getMonth().substring(4, parameter.getMonth().length())+"��");
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
	 * ���س����ϸ��ѯ 
	 * @return
	 */
	public String doLocalRewardDtl(){
		setTitle(PageLoction.RewardLocal);
		//�����·ݡ��������ͷ�����ӦRewardQueryParameter��month��rewardtype
		
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
	 * ��ȡ�������ѯ ʱ��: N-6���� 
	 * @return
	 */
	public String getBalanceTime6(){
		return setBalanceTime(6);
	}
	/**
	 * ��ȡ�������ѯ ʱ��: N-5���� 
	 * @return
	 */
	public String getBalanceTime5(){
		return setBalanceTime(5);
	}
	/**
	 * ��ȡ�������ѯ ʱ��: N-4���� 
	 * @return
	 */
	public String getBalanceTime4(){
		return setBalanceTime(4);
	}
	/**
	 * ��ȡ�������ѯ ʱ��: N-3���� 
	 * @return
	 */
	public String getBalanceTime3(){
		return setBalanceTime(3);
	}
	/**
	 * ��ȡ�������ѯ ʱ��: N-2���� 
	 * @return
	 */
	public String getBalanceTime2(){
		return setBalanceTime(2);
	}
	/**
	 * ��ȡ�������ѯ ʱ��: N-2���� 
	 * @return
	 */
	public String getBalanceTime1(){
		return setBalanceTime(1);
	}
	/**
	 * ����������ѯʱ�� ,N-i��ʽ��
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
			System.out.println("[RewardTotalAction.setBalanceTime("+i+")]����ת������:"+e.getMessage());
			logger.warn("[RewardTotalAction.setBalanceTime("+i+")]����ת������:"+e.getMessage());
			return "";
		}
	}
	/**
	 * ��ȡҳ����ʾʱ������
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
			logger.error("[RewardTotalAction.getShowTimeName]����ת������:"+e.getMessage());
			return null;
		}
	}
	
	/**
	 * ���س������
	 */
	public Map getReportType() {
		Map rewardLocalType =  Constant.getConstantsMap(ConstantsType.REWARDLOCALTYPE);
		Map rtn = new LinkedHashMap<String,String>();
		rtn.put("", "��ѡ��");
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
