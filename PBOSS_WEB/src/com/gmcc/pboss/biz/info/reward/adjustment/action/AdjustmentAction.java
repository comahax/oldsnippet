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
	//正则表达式年月，如201307
	private static final String YEAR_MONTH = "[1-9]{1}[0-9]{3}((0[1-9]{1})|(1[012]{1}))"; 
	private List retlist;
	private QueryParameter parameter;
	private AdjustmentService  adjustmentService; 
 
	public QueryParameter getParameter() {
		// TODO Auto-generated method stub
		parameter = parameter==null?new AdjustmentQueryParameter():parameter;
		// 设置页码，仅在明细查询时使用，统计汇总不使用
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// 设置大小 
		
		LoginMember logMem = this.getMember();
		if(logMem.getIsnet()==1){//店主只允许查询自身酬金信息
			((AdjustmentQueryParameter)parameter).setWayid(logMem.getWayid());
		}
		
		return parameter;
	}
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	//查询
	public String doView() throws ParseException{
		if(this.getLogMember().getIsnet()!=4){//店主
			this.setTitle(PageLoction.ADJUSTMENT_STAT);
		}else{//经理人员
			this.setTitle(PageLoction.MAG_ADJUSTMENT_STAT);
		}
		((AdjustmentQueryParameter)this.getParameter()).setSupportPaymonth(adjustmentService.isSupportPaymonth());
		((AdjustmentQueryParameter)this.getParameter()).setSupportFee(adjustmentService.isSupportFee());  
		//默认查询上个月的数据
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
		boolean flag = true;//标记
		if(!supportPaymont){//不支持付款月份
			param.setPaymonth(null); 
			if( (month==null || "".equals(month)) ){//结算月份和业务发生月同时为空
				this.addActionMessage("[结算月份]不能同时为空");
				flag = flag && false;
			} 
			if(month!=null && !"".equals(month) && !month.matches(YEAR_MONTH)){//不为空，但格式不符合要求
				param.setRewardmonth("");
				this.addActionMessage("[结算月份]格式不对，必须为6为有效年月");
				flag = flag && false;
			}  
		}else{//支持付款月份
			if( (month==null || "".equals(month)) && (paymonth==null || "".equals(paymonth)) ){//结算月份和付款月份同时为空
				this.addActionMessage("[结算月份]、[付款月份]不能同时为空");
				flag = flag && false;
			}
			if(month!=null && !"".equals(month) && !month.matches(YEAR_MONTH)){//不为空，但格式不符合要求
				param.setRewardmonth("");
				this.addActionMessage("[结算月份]格式不对，必须为6为有效年月");
				flag = flag && false;
			}
			if(paymonth!=null && !"".equals(paymonth) && !paymonth.matches(YEAR_MONTH)){//不为空，但格式不符合要求
				param.setPaymonth("");
				this.addActionMessage("[付款月份]格式不对，必须为6为有效年月");
				flag = flag && false;
			} 
		}
		return flag;
	} 
	
	public String doStat(){
		if(this.getLogMember().getIsnet()!=4){//店主
			this.setTitle(PageLoction.ADJUSTMENT_STAT);
		}else{//经理人员
			this.setTitle(PageLoction.MAG_ADJUSTMENT_STAT);
		}
		ServiceResult result = null;
		result = isLogin();
		
		AdjustmentQueryParameter param = (AdjustmentQueryParameter)this.getParameter();
		if(this.isValidParam(param)){//校验参数是否正确
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
	 * 获得表头  （表格标题）
	 * @return
	 */
	public List<ColumnSet> getsetCols() {
		AdjustmentQueryParameter parameter = new AdjustmentQueryParameter();
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		setCols.add(new ColumnSet("wayid", "网点编码"));
		setCols.add(new ColumnSet("wayname", "网点名称"));
		setCols.add(new ColumnSet("starlevel","网点星级"));
		setCols.add(new ColumnSet("rewardmonth", "结算月份"));
		if(adjustmentService.isSupportPaymonth()){
		setCols.add(new ColumnSet("paymonth", "付款月份"));
		}
		setCols.add(new ColumnSet("paysum", "税前应发"));
		setCols.add(new ColumnSet("rpmoney", "奖罚酬金"));
		if(adjustmentService.isSupportFee()){
		     setCols.add(new ColumnSet("fees", "手续费"));
		}
		setCols.add(new ColumnSet("taxmoney", "税金"));
		setCols.add(new ColumnSet("realpay", "税后酬金"));
       return setCols;
	}
	 /**
	 * 返回页面显示的效果
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
