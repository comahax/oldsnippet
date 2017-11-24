package com.gmcc.pboss.biz.info.missioner.recommend.success.action;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.gmcc.pboss.biz.info.missioner.recommend.success.service.AgencyService;
import com.gmcc.pboss.biz.info.missioner.recommend.success.service.MissionerService;
import com.gmcc.pboss.biz.info.missioner.recommend.success.support.MissionerQueryParameter;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.dictionary.HttpDictionary;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.member.service.IDelayLoadService;

public class RecommendSuccessAction  extends AbstractAction{
	
	MissionerQueryParameter parameter;
	
	/**
	 * 延迟加载部分登录信息：合作商资料、上级渠道经理、菜单栏
	 */
	private IDelayLoadService delayLoadService;	
	public void setDelayLoadService(IDelayLoadService delayLoadService) {
		this.delayLoadService = delayLoadService;
	}

	public String doList(){
		LoginMember member = this.getMember();
		if( !member.isInfoloaded()){//待延迟加载的信息尚未加载，加载这些信息
			member = this.delayLoadService.fillMember(member);
			//获取菜单项
			Map<String,ArrayList> menuMap = member.getMenuMap();
	 		this.getSession().setAttribute("menuMap", menuMap);//将菜单信息放入session中
	 		member.setMenuMap(null);//避免在session中放置2次
	 		this.getSession().setAttribute(HttpDictionary.USER_NAME, member);
		}
		
		this.setTitle(PageLoction.RecommendSuccessQuery);
		Short empattr2 = this.getLogMember().getEmpattr2();
		
		if(empattr2 == null){
			this.setMessage("专员类型为空");
			return "error";
		}
		if(empattr2 == 1 || empattr2 == 2){
			return "missioner";//推广专员
		}else{
			if(empattr2 == 3){
				return "agency";//代理商
			}else{
				this.setMessage("您所属的专员类型不支持访问");
				return "error";
			}
		}
	}
	
	private MissionerService rsMissionerService;
	private AgencyService rsAgencyService;
	public String doListMissioner(){
		ServiceResult result = isLogin();
		if(result.isSuccess())
			result = rsMissionerService.transact(getMember(), getParameter(), ServiceType.QUERY);
		this.writeJSONServicePage(result, getsetCols1());
		return null;
	}
	
	/**
	 * 获得表头
	 * @return
	 */
	public List<ColumnSet> getsetCols1() {
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();		
		setCols.add(new ColumnSet("ruleid", "校验规则"));
		setCols.add(new ColumnSet("opnid", "发生业务编码"));
		setCols.add(new ColumnSet("name", "发生业务名称"));
		setCols.add(new ColumnSet("calcopnid", "结算业务编码"));
		setCols.add(new ColumnSet("calname", "结算业务名称"));
		setCols.add(new ColumnSet("calcmonth", "结算月份"));
		setCols.add(new ColumnSet("wayid", "渠道编码"));
		setCols.add(new ColumnSet("wayname", "渠道名称"));		
		setCols.add(new ColumnSet("oprtime", "业务发生时间"));
		setCols.add(new ColumnSet("oprcode", "专员号码"));
		setCols.add(new ColumnSet("mobile", "业务发生号码"));
		setCols.add(new ColumnSet("busivalue", "业务量"));
		setCols.add(new ColumnSet("rewardtype", "酬金类型"));
		setCols.add(new ColumnSet("ossrc", "业务来源"));
		setCols.add(new ColumnSet("empattr2", "成员属性"));		
		return setCols;
	}
	 /**
	 * 返回页面显示的效果
	 * @return the colSet
	 */
	public String getShowCols1(){
		return JSONArray.fromObject(getsetCols1()).toString();
	}
	
	public String doListAgency(){
		ServiceResult result = isLogin();
		if(result.isSuccess())
			result = rsAgencyService.transact(getMember(), getParameter(), ServiceType.QUERY);
		this.writeJSONServicePage(result, getsetCols2());
		return null;
	}
	
	/**
	 * 获得表头
	 * @return
	 */
	public List<ColumnSet> getsetCols2() {
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();		
		setCols.add(new ColumnSet("ruleid", "校验规则"));
		setCols.add(new ColumnSet("opnid", "发生业务编码"));
		setCols.add(new ColumnSet("name", "发生业务名称"));
		setCols.add(new ColumnSet("calcopnid", "结算业务编码"));
		setCols.add(new ColumnSet("calname", "结算业务名称"));
		setCols.add(new ColumnSet("calcmonth", "结算月份"));
		setCols.add(new ColumnSet("wayid", "渠道编码"));
		setCols.add(new ColumnSet("wayname", "渠道名称"));		
		setCols.add(new ColumnSet("oprtime", "业务发生时间"));
		setCols.add(new ColumnSet("oprcode", "专员号码"));
		setCols.add(new ColumnSet("mobile", "业务发生号码"));
		setCols.add(new ColumnSet("busivalue", "业务量"));
		setCols.add(new ColumnSet("rewardtype", "酬金类型"));
		setCols.add(new ColumnSet("ossrc", "业务来源"));
		setCols.add(new ColumnSet("empattr2", "成员属性"));		
		return setCols;
	}
	 /**
	 * 返回页面显示的效果
	 * @return the colSet
	 */
	public String getShowCols2(){
		return JSONArray.fromObject(getsetCols2()).toString();
	}
	
	@Override
	public QueryParameter getParameter() {
		parameter = parameter==null?new MissionerQueryParameter():parameter;
		
		// 设置页码
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// 设置大小
		
		if(getMember() != null && !"".equals(getMember())){
			//联系电话，专员查询时，限定本专员对应的数据（非页面条件）
			parameter.setTelephone(getMember().getTelephone());
			
			//所属渠道，代理商查询时，限定代理商对应的数据（非页面条件）
			parameter.setWayidAgency(getMember().getWayid());
		}
		
		return parameter;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}

	public MissionerService getRsMissionerService() {
		return rsMissionerService;
	}

	public void setRsMissionerService(MissionerService rsMissionerService) {
		this.rsMissionerService = rsMissionerService;
	}

	public AgencyService getRsAgencyService() {
		return rsAgencyService;
	}

	public void setRsAgencyService(AgencyService rsAgencyService) {
		this.rsAgencyService = rsAgencyService;
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
