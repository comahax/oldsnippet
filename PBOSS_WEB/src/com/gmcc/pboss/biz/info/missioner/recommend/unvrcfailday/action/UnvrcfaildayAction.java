package com.gmcc.pboss.biz.info.missioner.recommend.unvrcfailday.action;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.gmcc.pboss.biz.info.missioner.recommend.unvrcfailday.service.UnvrcfaildayService;
import com.gmcc.pboss.biz.info.missioner.recommend.unvrcfailday.support.UnvrcfaildayParameter;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.QueryParameter;

public class UnvrcfaildayAction extends AbstractAction {

	UnvrcfaildayParameter parameter;
	@Override
	public QueryParameter getParameter() {
		// TODO Auto-generated method stub
		parameter = parameter==null?new UnvrcfaildayParameter():parameter;
		// 设置页码
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// 设置大小  
		
		short empattr2 = this.getLogMember().getEmpattr2();
		if(empattr2==1 || empattr2==2){//个人专员 或者 1+3专员
			parameter.setRcno(this.getLogMember().getTelephone());
		}else{// 3 代理商
			parameter.setWayid(this.getLogMember().getChannel().getWayid());
		}
		return parameter;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub
	}
	
	private UnvrcfaildayService unvrcfaildayService;	
	public void setUnvrcfaildayService(UnvrcfaildayService unvrcfaildayService) {
		this.unvrcfaildayService = unvrcfaildayService;
	}

	public String doList(){
		this.setTitle(PageLoction.RecommendFailQuery);
		short empattr2 = this.getLogMember().getEmpattr2();
		if(empattr2==1 || empattr2==2){//个人专员 或者 1+3专员
			return "missioner";
		}else{// 3 代理商
			return "agency";
		}		
	}
	
	public String doAjax(){
		ServiceResult result = isLogin();
		if(result.isSuccess())
			result = this.unvrcfaildayService.transact(getMember(), getParameter(), ServiceType.QUERY);
		this.writeJSONServicePage(result, getsetCols());
		return null;
	}
	
	/**
	 * 获得表头
	 * @return
	 */
	public List<ColumnSet> getsetCols() {
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();	
//		u.failid,u.rcno,u.mobileno,u.opnid,o.name as opnname,u.rcmonth,u.rcdate
//		u.reason,u.ossrc,u.wayid,w.wayname,e.empattr2 
		//setCols.add(new ColumnSet("failid", "序号"));
		setCols.add(new ColumnSet("rcno", "专员号码"));
		setCols.add(new ColumnSet("mobileno", "客户号码"));
		setCols.add(new ColumnSet("opnid", "业务编码"));
		setCols.add(new ColumnSet("opnname", "业务名称"));
		setCols.add(new ColumnSet("rcmonth", "推荐月份"));
		setCols.add(new ColumnSet("rcdate", "推荐时间"));
		setCols.add(new ColumnSet("reason", "失败原因"));
		setCols.add(new ColumnSet("ossrc", "业务平台来源"));
		short empattr2 = this.getLogMember().getEmpattr2();
		if(empattr2==1 || empattr2==2){//个人专员 或者 1+3专员
			setCols.add(new ColumnSet("wayid", "渠道编码"));
			setCols.add(new ColumnSet("wayname", "渠道名称"));
		}else{// 3 代理商
			setCols.add(new ColumnSet("empattr2", "成员属性"));	
		}
		return setCols;
	}
	 /**
	 * 返回页面显示的效果
	 * @return the colSet
	 */
	public String getShowCols(){
		return JSONArray.fromObject(getsetCols()).toString();
	}
	
	public Map getEmpattr2(){
		Map<String,String> map = new LinkedHashMap<String,String>();
		map.put("", null);
		Map t = Constant.getConstantsMap(ConstantsType.CH_EMPATTR2);
		t.remove("3");
		t.remove("4");
		t.remove("5");
		map.putAll(t);
		return map;
	}

}
