package com.gmcc.pboss.manager.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONArray;

import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dictionary.HttpDictionary;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.manager.service.ManagerNodeService;
import com.gmcc.pboss.manager.support.ManagerNodeQueryParameter;
import com.gmcc.pboss.manager.model.NodeDetail;
import com.gmcc.pboss.biz.info.node.model.Way;
import com.gmcc.pboss.manager.model.WayReversed;
import com.gmcc.pboss.member.service.IDelayLoadService;

public class ManagerNodeAction extends AbstractAction {

	//渠道名称-根据渠道名称，过滤渠道信息列表
	private String wayname;
	public void setWayname(String name){
		this.wayname = name;
	}
	public String getWayname(){
		return this.wayname;
	}
	
	//渠道id-根据渠道id,展示渠道详细信息
	private String wayid;
	public String getWayid(){
		return this.wayid;
	}
	public void setWayid(String wayid){
		this.wayid = wayid;
	}
	
	//是否为网点编码选择弹出框
	private boolean popup;
	public boolean isPopup() {
		return popup;
	}
	public void setPopup(boolean popup) {
		this.popup = popup;
	}

	//渠道详细信息
	private NodeDetail nodeDetail;
	public void setNodeDetail(NodeDetail nd){
		this.nodeDetail = nd;
	}
	public NodeDetail getNodeDetail(){
		return this.nodeDetail;
	}
	
	//获取Service，实现业务逻辑
	private ManagerNodeService service;
	public void setService(ManagerNodeService service){
		this.service = service;
	}
	
	/**
	 * 延迟加载部分登录信息：合作商资料、上级渠道经理、菜单栏
	 */
	private IDelayLoadService delayLoadService;	
	public void setDelayLoadService(IDelayLoadService delayLoadService) {
		this.delayLoadService = delayLoadService;
	}
	/**
	 * 转入网点列表
	 */
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
		
		this.setTitle(PageLoction.MAG_NODE_LIST);
		return SUCCESS;
	}
	
	/**
	 * 省管理员转入网点列表
	 */
	public String doGdList(){
		LoginMember member = this.getMember();
		if( !member.isInfoloaded()){//待延迟加载的信息尚未加载，加载这些信息
			member = this.delayLoadService.fillMember(member);
			//获取菜单项
			Map<String,ArrayList> menuMap = member.getMenuMap();
	 		this.getSession().setAttribute("menuMap", menuMap);//将菜单信息放入session中
	 		member.setMenuMap(null);//避免在session中放置2次
	 		this.getSession().setAttribute(HttpDictionary.USER_NAME, member);
		}
		
		this.setTitle(PageLoction.GDINFO);
		return SUCCESS;
	}
	/**
	 * 市管理员转入网点列表
	 */
	public String doCityList(){
		LoginMember member = this.getMember();
		if( !member.isInfoloaded()){//待延迟加载的信息尚未加载，加载这些信息
			member = this.delayLoadService.fillMember(member);
			//获取菜单项
			Map<String,ArrayList> menuMap = member.getMenuMap();
	 		this.getSession().setAttribute("menuMap", menuMap);//将菜单信息放入session中
	 		member.setMenuMap(null);//避免在session中放置2次
	 		this.getSession().setAttribute(HttpDictionary.USER_NAME, member);
		}
		
		this.setTitle(PageLoction.CITYINFO);
		return SUCCESS;
	}
	/**
	 * 查询网点
	 */
	public String doAjaxList(){
		ServiceResult result = isLogin();
		if(result.isSuccess())
			result = service.transact(getMember(), getParameter(), ServiceType.QUERY);
		this.writeJSONServicePage(result, getsetCols());
		return null;
	}
	
	/**
	 * 查看某个网点详细信息
	 */
	public String doLoad(){
		this.setTitle(PageLoction.MAG_NODE_INFO);
		ServiceResult result = isLogin();
		if(result.isSuccess())
			result = service.transact(getMember(), getNodeParameter(), ServiceType.QUERY);
		if(result.isSuccess()){
			//setResult(result.getRetResult());
			List retList = result.getRetResult().getData();
			if(retList.size()>0){
				this.nodeDetail = (NodeDetail)retList.get(0);
			}
			return SUCCESS;
		}
		else{
			setMessage(result.getMessage());
			return ERROR;
		}
	}
	
	@Override
	public QueryParameter getParameter() {
		// TODO Auto-generated method stub
		ManagerNodeQueryParameter parameter = new ManagerNodeQueryParameter();
		// 设置页码
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// 设置大小  
		
		if(this.getWayname()!=null)
			parameter.setWayname(this.getWayname());
		parameter.setWaymagcode(this.getMember().getEmployeeid());
		parameter.setAction(QueryAction.SECTION);//需要分页
		//parameter.setOperation( int operation )
		
		return parameter;
	}
	
	public QueryParameter getNodeParameter(){
		ManagerNodeQueryParameter parameter = new ManagerNodeQueryParameter();
		parameter.setWayid(this.getWayid());
		parameter.setAction(QueryAction.ALL);//不需要分页
		return parameter;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 获得表头
	 * @return
	 */
	public List<ColumnSet> getsetCols() {

		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		//setCols.add(new ColumnSet("wayid"));
		setCols.add(new ColumnSet("wayid", "渠道编码"));
		setCols.add(new ColumnSet("wayname", "渠道名称"));
		setCols.add(new ColumnSet("officetel", "手机平台捆绑手机号码"));
		setCols.add(new ColumnSet("starlevel", "星级"));//需要从数字、字符编码翻译成中文
		setCols.add(new ColumnSet("catetype", "连线性质"));//需要从数字、字符编码翻译成中文
		setCols.add(new ColumnSet("cityid", "地市公司"));//需要从数字、字符编码翻译成中文
		setCols.add(new ColumnSet("countyid", "分公司"));//需要从数字、字符编码翻译成中文
		setCols.add(new ColumnSet("svccode", "服务销售中心"));
		setCols.add(new ColumnSet("formtype", "业态类型"));//需要从数字、字符编码翻译成中文
		setCols.add(new ColumnSet("address", "详细地址"));
		setCols.add(new ColumnSet("oper", "查看人员",true));
		
		return setCols;
	}
	
	 /**
	 * 返回页面显示的效果
	 * 
	 * @return the colSet
	 */
	public String getShowCols() {

		return JSONArray.fromObject(getsetCols()).toString();
	}
	
	/**
	 * 转入网点列表--弹出框选择
	 */
	public String doListPopup(){
		return SUCCESS;
	}
	/**
	 * 查询网点--弹出框选择
	 */
	public String doAjaxListPopup(){
		ServiceResult result = isLogin();
		if(result.isSuccess())
			result = service.transact(getMember(), getParameterPopup(), ServiceType.QUERY);		
		this.writeJSONServicePage(result, getsetColsPopup());
		return null;
	}
	public QueryParameter getParameterPopup(){
		ManagerNodeQueryParameter parameter = new ManagerNodeQueryParameter();
		// 设置页码
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// 设置大小  

		parameter.setWaymagcode(this.getMember().getEmployeeid());
		parameter.setAction(QueryAction.SECTION);//需要分页
		if(this.isPopup()){
			parameter.setPopup(this.isPopup());
			if(StringUtils.isNotEmpty(this.getWayid())){
				parameter.setWayid(this.getWayid());
			}
			if(StringUtils.isNotEmpty(this.getWayname())){
				parameter.setWayname(this.getWayname());
			}
		}
		return parameter;
	}	
	/**
	 * 获得表头--弹出框选择
	 */
	public List<ColumnSet> getsetColsPopup() {
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		//setCols.add(new ColumnSet("wayid"));
		setCols.add(new ColumnSet("wayid", "渠道编码"));
		setCols.add(new ColumnSet("wayname", "渠道名称"));
		return setCols;
	}
	/**
	 * 返回页面显示的效果--弹出框选择
	 * 
	 * @return the colSet
	 */
	public String getShowColsPopup() {
		return JSONArray.fromObject(getsetColsPopup()).toString();
	}
}
