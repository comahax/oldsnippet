package com.gmcc.pboss.biz.info.reward.adjustment.action;

 
 
 
 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;

 
import com.gmcc.pboss.biz.info.reward.adjustment.service.AdjustmentService;
import com.gmcc.pboss.biz.info.reward.adjustment.support.AdjustmentQueryParameter;
 
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.QueryParameter;
import com.sun.org.apache.bcel.internal.generic.NEW;


public class AdjustmentAction extends AbstractAction {
	//������ʽ���£���201307
	private static final String YEAR_MONTH = "[1-9]{1}[0-9]{3}((0[1-9]{1})|(1[012]{1}))"; 
	private List retlist;
	private QueryParameter parameter;
	private AdjustmentService  adjustmentService; 
 
	public QueryParameter getParameter() {
		// TODO Auto-generated method stub
		parameter = parameter==null?new AdjustmentQueryParameter():parameter;
		// ����ҳ�룬������ϸ��ѯʱʹ�ã�ͳ�ƻ��ܲ�ʹ��
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// ����ҳ��
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// ���ô�С 
		
		LoginMember logMem = this.getMember();
		if(logMem.getIsnet()==1){//����ֻ�����ѯ��������Ϣ
			((AdjustmentQueryParameter)parameter).setWayid(logMem.getWayid());
		}
		
		return parameter;
	}
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	//��ѯ
	public String doView() throws ParseException{
		if(this.getLogMember().getIsnet()!=4){//����
			this.setTitle(PageLoction.ADJUSTMENT_STAT);
		}else{//������Ա
			this.setTitle(PageLoction.MAG_ADJUSTMENT_STAT);
		}
		((AdjustmentQueryParameter)this.getParameter()).setSupportPaymonth(adjustmentService.isSupportPaymonth());
		((AdjustmentQueryParameter)this.getParameter()).setSupportFee(adjustmentService.isSupportFee());  
		//Ĭ�ϲ�ѯ�ϸ��µ�����
		 SimpleDateFormat format = new SimpleDateFormat("yyyyMM"); 
		 Calendar objCalendar = Calendar.getInstance(); 
		 //objCalendar.setTime(format.parse("201312"));
		 objCalendar.add(Calendar.MONTH, -1); 
		 format.format(objCalendar.getTime());
		 System.out.println( format.format(objCalendar.getTime())); 
		((AdjustmentQueryParameter)this.getParameter()).setRewardmonth(format.format(objCalendar.getTime()));
		return SUCCESS;
	}
	
	private boolean isValidParam(AdjustmentQueryParameter param){
		boolean supportPaymont = param.isSupportPaymonth();
		String month = param.getRewardmonth();
		String paymonth = param.getPaymonth(); 
		boolean flag = true;//���
		if(!supportPaymont){//��֧�ָ����·�
			param.setPaymonth(null); 
			if( (month==null || "".equals(month)) ){//�����·ݺ�ҵ������ͬʱΪ��
				this.addActionMessage("[�����·�]����ͬʱΪ��");
				flag = flag && false;
			} 
			if(month!=null && !"".equals(month) && !month.matches(YEAR_MONTH)){//��Ϊ�գ�����ʽ������Ҫ��
				param.setRewardmonth("");
				this.addActionMessage("[�����·�]��ʽ���ԣ�����Ϊ6Ϊ��Ч����");
				flag = flag && false;
			}  
		}else{//֧�ָ����·�
			if( (month==null || "".equals(month)) && (paymonth==null || "".equals(paymonth)) ){//�����·ݺ͸����·�ͬʱΪ��
				this.addActionMessage("[�����·�]��[�����·�]����ͬʱΪ��");
				flag = flag && false;
			}
			if(month!=null && !"".equals(month) && !month.matches(YEAR_MONTH)){//��Ϊ�գ�����ʽ������Ҫ��
				param.setRewardmonth("");
				this.addActionMessage("[�����·�]��ʽ���ԣ�����Ϊ6Ϊ��Ч����");
				flag = flag && false;
			}
			if(paymonth!=null && !"".equals(paymonth) && !paymonth.matches(YEAR_MONTH)){//��Ϊ�գ�����ʽ������Ҫ��
				param.setPaymonth("");
				this.addActionMessage("[�����·�]��ʽ���ԣ�����Ϊ6Ϊ��Ч����");
				flag = flag && false;
			} 
		}
		return flag;
	} 
	
	public String doStat(){
		if(this.getLogMember().getIsnet()!=4){//����
			this.setTitle(PageLoction.ADJUSTMENT_STAT);
		}else{//������Ա
			this.setTitle(PageLoction.MAG_ADJUSTMENT_STAT);
		}
		ServiceResult result = null;
		result = isLogin();
		
		AdjustmentQueryParameter param = (AdjustmentQueryParameter)this.getParameter();
		if(this.isValidParam(param)){//У������Ƿ���ȷ
			if(result.isSuccess()){
				result = this.adjustmentService.transact(getMember(), getParameter(), ServiceType.OTHER);
			} 
			if(result.isSuccess()){
				this.retlist = result.getRetResult().getData();
			}else{
				this.addActionMessage(result.getMessage());
			}
		}		
		return SUCCESS;
	} 
	
	
	public String doAjax(){
		ServiceResult result = isLogin();
		if(result.isSuccess())
			result = this.adjustmentService.transact(getMember(), getParameter(), ServiceType.OTHER);
		this.writeJSONServicePage(result, getsetCols());
		return null;
	}
	
	/**
	 * ��ñ�ͷ  �������⣩
	 * @return
	 */
	public List<ColumnSet> getsetCols() {
		AdjustmentQueryParameter parameter = new AdjustmentQueryParameter();
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		setCols.add(new ColumnSet("wayid", "�������"));
		setCols.add(new ColumnSet("wayname", "��������"));
		setCols.add(new ColumnSet("starlevel","�����Ǽ�"));
		setCols.add(new ColumnSet("rewardmonth", "�����·�"));
		if(adjustmentService.isSupportPaymonth()){
		setCols.add(new ColumnSet("paymonth", "�����·�"));
		}
		setCols.add(new ColumnSet("paysum", "˰ǰӦ��"));
		setCols.add(new ColumnSet("rpmoney", "�������"));
		if(adjustmentService.isSupportFee()){
		     setCols.add(new ColumnSet("fees", "������"));
		}
		setCols.add(new ColumnSet("taxmoney", "˰��"));
		setCols.add(new ColumnSet("realpay", "˰����"));
       return setCols;
	}
	 /**
	 * ����ҳ����ʾ��Ч��
	 * @return the colSet
	 */
	public String getShowCols(){
		return JSONArray.fromObject(getsetCols()).toString();
	}	
	
	
	public AdjustmentService getAdjustmentService() {
		return adjustmentService;
	}
	public void setAdjustmentService(AdjustmentService adjustmentService) {
		this.adjustmentService = adjustmentService;
	} 
	
	public List getRetlist() {
		return retlist;
	}
	public void setRetlist(List retlist) {
		this.retlist = retlist;
	}
}
