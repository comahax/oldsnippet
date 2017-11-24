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

	//��������-�����������ƣ�����������Ϣ�б�
	private String wayname;
	public void setWayname(String name){
		this.wayname = name;
	}
	public String getWayname(){
		return this.wayname;
	}
	
	//����id-��������id,չʾ������ϸ��Ϣ
	private String wayid;
	public String getWayid(){
		return this.wayid;
	}
	public void setWayid(String wayid){
		this.wayid = wayid;
	}
	
	//�Ƿ�Ϊ�������ѡ�񵯳���
	private boolean popup;
	public boolean isPopup() {
		return popup;
	}
	public void setPopup(boolean popup) {
		this.popup = popup;
	}

	//������ϸ��Ϣ
	private NodeDetail nodeDetail;
	public void setNodeDetail(NodeDetail nd){
		this.nodeDetail = nd;
	}
	public NodeDetail getNodeDetail(){
		return this.nodeDetail;
	}
	
	//��ȡService��ʵ��ҵ���߼�
	private ManagerNodeService service;
	public void setService(ManagerNodeService service){
		this.service = service;
	}
	
	/**
	 * �ӳټ��ز��ֵ�¼��Ϣ�����������ϡ��ϼ����������˵���
	 */
	private IDelayLoadService delayLoadService;	
	public void setDelayLoadService(IDelayLoadService delayLoadService) {
		this.delayLoadService = delayLoadService;
	}
	/**
	 * ת�������б�
	 */
	public String doList(){
		LoginMember member = this.getMember();
		if( !member.isInfoloaded()){//���ӳټ��ص���Ϣ��δ���أ�������Щ��Ϣ
			member = this.delayLoadService.fillMember(member);
			//��ȡ�˵���
			Map<String,ArrayList> menuMap = member.getMenuMap();
	 		this.getSession().setAttribute("menuMap", menuMap);//���˵���Ϣ����session��
	 		member.setMenuMap(null);//������session�з���2��
	 		this.getSession().setAttribute(HttpDictionary.USER_NAME, member);
		}
		
		this.setTitle(PageLoction.MAG_NODE_LIST);
		return SUCCESS;
	}
	
	/**
	 * ʡ����Աת�������б�
	 */
	public String doGdList(){
		LoginMember member = this.getMember();
		if( !member.isInfoloaded()){//���ӳټ��ص���Ϣ��δ���أ�������Щ��Ϣ
			member = this.delayLoadService.fillMember(member);
			//��ȡ�˵���
			Map<String,ArrayList> menuMap = member.getMenuMap();
	 		this.getSession().setAttribute("menuMap", menuMap);//���˵���Ϣ����session��
	 		member.setMenuMap(null);//������session�з���2��
	 		this.getSession().setAttribute(HttpDictionary.USER_NAME, member);
		}
		
		this.setTitle(PageLoction.GDINFO);
		return SUCCESS;
	}
	/**
	 * �й���Աת�������б�
	 */
	public String doCityList(){
		LoginMember member = this.getMember();
		if( !member.isInfoloaded()){//���ӳټ��ص���Ϣ��δ���أ�������Щ��Ϣ
			member = this.delayLoadService.fillMember(member);
			//��ȡ�˵���
			Map<String,ArrayList> menuMap = member.getMenuMap();
	 		this.getSession().setAttribute("menuMap", menuMap);//���˵���Ϣ����session��
	 		member.setMenuMap(null);//������session�з���2��
	 		this.getSession().setAttribute(HttpDictionary.USER_NAME, member);
		}
		
		this.setTitle(PageLoction.CITYINFO);
		return SUCCESS;
	}
	/**
	 * ��ѯ����
	 */
	public String doAjaxList(){
		ServiceResult result = isLogin();
		if(result.isSuccess())
			result = service.transact(getMember(), getParameter(), ServiceType.QUERY);
		this.writeJSONServicePage(result, getsetCols());
		return null;
	}
	
	/**
	 * �鿴ĳ��������ϸ��Ϣ
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
		// ����ҳ��
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// ����ҳ��
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// ���ô�С  
		
		if(this.getWayname()!=null)
			parameter.setWayname(this.getWayname());
		parameter.setWaymagcode(this.getMember().getEmployeeid());
		parameter.setAction(QueryAction.SECTION);//��Ҫ��ҳ
		//parameter.setOperation( int operation )
		
		return parameter;
	}
	
	public QueryParameter getNodeParameter(){
		ManagerNodeQueryParameter parameter = new ManagerNodeQueryParameter();
		parameter.setWayid(this.getWayid());
		parameter.setAction(QueryAction.ALL);//����Ҫ��ҳ
		return parameter;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ��ñ�ͷ
	 * @return
	 */
	public List<ColumnSet> getsetCols() {

		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		//setCols.add(new ColumnSet("wayid"));
		setCols.add(new ColumnSet("wayid", "��������"));
		setCols.add(new ColumnSet("wayname", "��������"));
		setCols.add(new ColumnSet("officetel", "�ֻ�ƽ̨�����ֻ�����"));
		setCols.add(new ColumnSet("starlevel", "�Ǽ�"));//��Ҫ�����֡��ַ����뷭�������
		setCols.add(new ColumnSet("catetype", "��������"));//��Ҫ�����֡��ַ����뷭�������
		setCols.add(new ColumnSet("cityid", "���й�˾"));//��Ҫ�����֡��ַ����뷭�������
		setCols.add(new ColumnSet("countyid", "�ֹ�˾"));//��Ҫ�����֡��ַ����뷭�������
		setCols.add(new ColumnSet("svccode", "������������"));
		setCols.add(new ColumnSet("formtype", "ҵ̬����"));//��Ҫ�����֡��ַ����뷭�������
		setCols.add(new ColumnSet("address", "��ϸ��ַ"));
		setCols.add(new ColumnSet("oper", "�鿴��Ա",true));
		
		return setCols;
	}
	
	 /**
	 * ����ҳ����ʾ��Ч��
	 * 
	 * @return the colSet
	 */
	public String getShowCols() {

		return JSONArray.fromObject(getsetCols()).toString();
	}
	
	/**
	 * ת�������б�--������ѡ��
	 */
	public String doListPopup(){
		return SUCCESS;
	}
	/**
	 * ��ѯ����--������ѡ��
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
		// ����ҳ��
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// ����ҳ��
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// ���ô�С  

		parameter.setWaymagcode(this.getMember().getEmployeeid());
		parameter.setAction(QueryAction.SECTION);//��Ҫ��ҳ
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
	 * ��ñ�ͷ--������ѡ��
	 */
	public List<ColumnSet> getsetColsPopup() {
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		//setCols.add(new ColumnSet("wayid"));
		setCols.add(new ColumnSet("wayid", "��������"));
		setCols.add(new ColumnSet("wayname", "��������"));
		return setCols;
	}
	/**
	 * ����ҳ����ʾ��Ч��--������ѡ��
	 * 
	 * @return the colSet
	 */
	public String getShowColsPopup() {
		return JSONArray.fromObject(getsetColsPopup()).toString();
	}
}
