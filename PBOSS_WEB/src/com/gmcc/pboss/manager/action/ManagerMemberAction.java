package com.gmcc.pboss.manager.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.apache.struts2.interceptor.SessionAware;

import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.member.model.Employee;
import com.gmcc.pboss.common.bean.Channel;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.manager.service.ManagerMemberService;
import com.gmcc.pboss.manager.support.ManagerMemberQueryParameter;

public class ManagerMemberAction extends AbstractAction implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2440052551624646830L;
	
	//��ȡService��ʵ����Ҫҵ���߼�
	private ManagerMemberService service;
	public void setService(ManagerMemberService service){
		this.service = service;
	}
	//���ݹ���������ѯ��Ա
	private String officeTel;
	public void setOfficeTel(String tel){
		this.officeTel = tel;
	}
	public String getOfficeTel(){
		return this.officeTel;
	}
	//�鿴��Ա��Ϣ
	private String employeeid;
	public void setEmployeeid(String id){
		this.employeeid = id;
	}
	public String getEmployeeid(){
		return this.employeeid;
	}
	//����channel,��Ա��Ϣ����չʾ��ʹ��
	private Channel empChannel;
	public Channel getEmpChannel() {
		return empChannel;
	}
	public void setEmpChannel(Channel empChannel) {
		this.empChannel = empChannel;
	}
	/**
	 * ��ת����Ա�б�ҳ��
	 */
	public String doList(){
		this.setTitle(PageLoction.MAG_ASSISTANT_LIST );		
		return SUCCESS;
	}
	
	/**
	 * ��ѯ��Ա
	 * @return
	 */
	public String doAjaxList(){
		
		ServiceResult result = null;
		
		result = isLogin();
		
		if(result.isSuccess())
			result = service.transact(getMember(), getParameter(), ServiceType.QUERY);
		
		this.writeJSONServicePage(result, getsetCols());
		return null;
	}
	
	/**
	 * ��ѯĳ����Ա
	 */
	public String doLoad() {
		this.setTitle(PageLoction.MAG_ASSISTANT_INFO);
		ServiceResult result = isLogin();
		
		if(result.isSuccess())
			result = service.transact(getMember(), getAssistantParameter(), ServiceType.QUERY);
		if(result.isSuccess()){
			Employee emp = (Employee)result.getRetResult().getData().get(0);
			Channel channel = this.service.getEmployeeChannel(emp.getWayid(), emp.getIsnet());
			this.setEmpChannel(channel);
			setResult(result.getRetResult());
			return SUCCESS;
		}
		else{
			setMessage(result.getMessage());
			return ERROR;
		}	
	}
	
	/**
	 * ��ȡ����-��ѯ��Ա�����ص�Ա�б�
	 */
	@Override
	public QueryParameter getParameter() {
		ManagerMemberQueryParameter parameter = new ManagerMemberQueryParameter();
		// ����ҳ��
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// ����ҳ��
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// ���ô�С  
		
		if (this.getOfficeTel() != null)
			parameter.setOfficetel(this.getOfficeTel());//���ù��������
		
		parameter.setManagerid(this.getMember().getEmployeeid());
		parameter.setAction(QueryAction.SECTION);//��Ҫ��ҳ
		//parameter.setOperation( int operation )
		
		return parameter;
	}
	/**
	 * ��ȡ����-��ѯ��Ա��Ϣ�����ص�����Ա
	 * @return
	 */
	public QueryParameter getAssistantParameter(){
		ManagerMemberQueryParameter parameter = new ManagerMemberQueryParameter();
		//parameter.setManagerid(this.getMember().getEmployeeid());
		parameter.setEmployeeid(getEmployeeid());
		parameter.setAction(QueryAction.ALL);//����ѯ����
		//parameter.setOperation( int operation);
		return parameter;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}
	
	//����session
	Map session;
	public void setSession(Map session){
		this.session = session;
	}

	/**
	 * ��ñ�ͷ
	 * @return
	 */
	public List<ColumnSet> getsetCols() {

		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		//setCols.add(new ColumnSet("officetel"));
		//setCols.add(new ColumnSet("oprcode", "����"));
		//setCols.add(new ColumnSet("employeeid"));
		setCols.add(new ColumnSet("employeeid", "��Ա���"));
		setCols.add(new ColumnSet("employeename", "����"));
		setCols.add(new ColumnSet("intime", "��ְʱ��"));
		setCols.add(new ColumnSet("officetel", "���������"));
		setCols.add(new ColumnSet("empstatusName", "�ù�״̬"));
		setCols.add(new ColumnSet("oper", "����",true));
		
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

}
