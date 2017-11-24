package com.gmcc.pboss.biz.info.reward.cityrecord.action;

import java.util.ArrayList;
import java.util.List; 
import net.sf.json.JSONArray; 
import com.gmcc.pboss.biz.info.reward.cityrecord.service.CityrecordService;
import com.gmcc.pboss.biz.info.reward.cityrecord.support.CityrecordQueryParameter;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember; 
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.biz.info.node.model.Way;

public class CityrecordAction extends AbstractAction {
	//正则表达式年月，如201307
	private static final String YEAR_MONTH = "[1-9]{1}[0-9]{3}((0[1-9]{1})|(1[012]{1}))";
	
	private List retlist;
	private double paytotal;

	private QueryParameter parameter;
	private CityrecordService cityrecordService; 
	@Override
	public QueryParameter getParameter() {
		// TODO Auto-generated method stub
		parameter = parameter==null?new CityrecordQueryParameter():parameter;
		// 设置页码，仅在明细查询时使用，统计汇总不使用
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// 设置大小 
		
		LoginMember logMem = this.getMember();
		if(logMem.getIsnet()==1){//店主只允许查询自身酬金信息
			((CityrecordQueryParameter)parameter).setWayid(logMem.getWayid());
		}
		
		return parameter;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}
	
	public String doView(){
		if(this.getLogMember().getIsnet()!=4){//店主
			this.setTitle(PageLoction.CITYRECORD_STAT);
		}else{//经理人员
			this.setTitle(PageLoction.MAG_CITYRECORD_STAT);
		}
		((CityrecordQueryParameter)this.getParameter()).setSupportPaymonth(cityrecordService.isSupportPaymonth());
		return SUCCESS;
	}
	
	
	private boolean isValidParam(CityrecordQueryParameter param){
		boolean supportPaymont = param.isSupportPaymonth();
		String month = param.getMonth();
		String paymonth = param.getPaymonth();
		String oprmonth   = param.getOprmonth();
		boolean flag = true;//标记
		if(!supportPaymont){//不支持付款月份
			param.setPaymonth(null); 
			if( (month==null || "".equals(month)) &&  (oprmonth==null ||  "".equals(oprmonth)) ){//结算月份和业务发生月同时为空
				this.addActionMessage("[结算月份]、[业务发生月]不能同时为空");
				flag = flag && false;
			}
			
			if(month!=null && !"".equals(month) && !month.matches(YEAR_MONTH)){//不为空，但格式不符合要求
				param.setMonth("");
				this.addActionMessage("[结算月份]格式不对，必须为6为有效年月");
				flag = flag && false;
			}
			
			if(oprmonth!=null && !"".equals(oprmonth) && !oprmonth.matches(YEAR_MONTH)){//不为空，但格式不符合要求
				param.setOprmonth("");
				this.addActionMessage("[业务发生月]格式不对，必须为6为有效年月");
				flag = flag && false;
			}
		}else{//支持付款月份
			if( (month==null || "".equals(month)) && (paymonth==null || "".equals(paymonth)) && (oprmonth==null ||  "".equals(oprmonth)) ){//结算月份和付款月份同时为空
				this.addActionMessage("[结算月份]、[付款月份]、[业务发生月]不能同时为空");
				flag = flag && false;
			}
			if(month!=null && !"".equals(month) && !month.matches(YEAR_MONTH)){//不为空，但格式不符合要求
				param.setMonth("");
				this.addActionMessage("[结算月份]格式不对，必须为6为有效年月");
				flag = flag && false;
			}
			if(paymonth!=null && !"".equals(paymonth) && !paymonth.matches(YEAR_MONTH)){//不为空，但格式不符合要求
				param.setPaymonth("");
				this.addActionMessage("[付款月份]格式不对，必须为6为有效年月");
				flag = flag && false;
			}
			if(oprmonth!=null && !"".equals(oprmonth) && !oprmonth.matches(YEAR_MONTH)){//不为空，但格式不符合要求
				param.setOprmonth("");
				this.addActionMessage("[业务发生月]格式不对，必须为6为有效年月");
				flag = flag && false;
			}
		}
		return flag;
	}
	
	public String doStat(){
		if(this.getLogMember().getIsnet()!=4){//店主
			this.setTitle(PageLoction.CITYRECORD_STAT);
		}else{//经理人员
			this.setTitle(PageLoction.MAG_CITYRECORD_STAT);
		}
		ServiceResult result = null;
		result = isLogin();
		
		CityrecordQueryParameter param = (CityrecordQueryParameter)this.getParameter();
		if(this.isValidParam(param)){//校验参数是否正确
			if(result.isSuccess()){
				result = this.cityrecordService.transact(getMember(), getParameter(), ServiceType.OTHER);
			}
			if(result.isSuccess()){
				this.retlist = result.getRetResult().getData();
				Object[] retObj = (Object[])result.getRetObject();
				//this.busitotal=busi_pay[0];
				this.paytotal=(Double)retObj[0];
				if(retObj[1]!=null){
					//CityrecordQueryParameter param = (CityrecordQueryParameter)this.parameter;
					Way way = (Way)retObj[1];
					param.setWayname(way.getWayname());
					param.setStarlevel(way.getStrStarlevel());
				}
			}else{
				//CityrecordQueryParameter param = (CityrecordQueryParameter)this.parameter;
				param.setWayname(null);
				param.setStarlevel(null);
				this.addActionMessage(result.getMessage());
			}
		}		
		return SUCCESS;
	}	

	public String doList(){
		return SUCCESS;
	}
	
	public String doAjax(){
		ServiceResult result = isLogin();
		if(result.isSuccess())
			result = this.cityrecordService.transact(getMember(), getParameter(), ServiceType.QUERY);
		this.writeJSONServicePage(result, getsetCols());
		return null;
	}
	
	/**
	 * 获得表头
	 * @return
	 */
	public List<ColumnSet> getsetCols() {
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		setCols.add(new ColumnSet("wayid", "网点编码"));
		setCols.add(new ColumnSet("wayname", "网点名称"));
		setCols.add(new ColumnSet("opnid", "业务编码"));
		setCols.add(new ColumnSet("opnname", "业务名称"));
		setCols.add(new ColumnSet("rewardtypename", "酬金期数"));
		setCols.add(new ColumnSet("mobile", "手机号码或IMEI号码"));
		setCols.add(new ColumnSet("oprtime", "业务发生时间"));
		setCols.add(new ColumnSet("busivalue", "业务量或业务金额"));
		setCols.add(new ColumnSet("paymoney", "本期应发酬金"));
		return setCols;
	}
	 /**
	 * 返回页面显示的效果
	 * @return the colSet
	 */
	public String getShowCols(){
		return JSONArray.fromObject(getsetCols()).toString();
	}	
	
	public CityrecordService getCityrecordService() {
		return cityrecordService;
	}

	public List getRetlist() {
		return retlist;
	}

	public double getPaytotal() {
		return paytotal;
	}

	public void setCityrecordService(CityrecordService cityrecordService) {
		this.cityrecordService = cityrecordService;
	}
}
