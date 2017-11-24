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
	 * �ӳټ��ز��ֵ�¼��Ϣ�����������ϡ��ϼ����������˵���
	 */
	private IDelayLoadService delayLoadService;	
	public void setDelayLoadService(IDelayLoadService delayLoadService) {
		this.delayLoadService = delayLoadService;
	}

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
		
		this.setTitle(PageLoction.RecommendSuccessQuery);
		Short empattr2 = this.getLogMember().getEmpattr2();
		
		if(empattr2 == null){
			this.setMessage("רԱ����Ϊ��");
			return "error";
		}
		if(empattr2 == 1 || empattr2 == 2){
			return "missioner";//�ƹ�רԱ
		}else{
			if(empattr2 == 3){
				return "agency";//������
			}else{
				this.setMessage("��������רԱ���Ͳ�֧�ַ���");
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
	 * ��ñ�ͷ
	 * @return
	 */
	public List<ColumnSet> getsetCols1() {
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();		
		setCols.add(new ColumnSet("ruleid", "У�����"));
		setCols.add(new ColumnSet("opnid", "����ҵ�����"));
		setCols.add(new ColumnSet("name", "����ҵ������"));
		setCols.add(new ColumnSet("calcopnid", "����ҵ�����"));
		setCols.add(new ColumnSet("calname", "����ҵ������"));
		setCols.add(new ColumnSet("calcmonth", "�����·�"));
		setCols.add(new ColumnSet("wayid", "��������"));
		setCols.add(new ColumnSet("wayname", "��������"));		
		setCols.add(new ColumnSet("oprtime", "ҵ����ʱ��"));
		setCols.add(new ColumnSet("oprcode", "רԱ����"));
		setCols.add(new ColumnSet("mobile", "ҵ��������"));
		setCols.add(new ColumnSet("busivalue", "ҵ����"));
		setCols.add(new ColumnSet("rewardtype", "�������"));
		setCols.add(new ColumnSet("ossrc", "ҵ����Դ"));
		setCols.add(new ColumnSet("empattr2", "��Ա����"));		
		return setCols;
	}
	 /**
	 * ����ҳ����ʾ��Ч��
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
	 * ��ñ�ͷ
	 * @return
	 */
	public List<ColumnSet> getsetCols2() {
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();		
		setCols.add(new ColumnSet("ruleid", "У�����"));
		setCols.add(new ColumnSet("opnid", "����ҵ�����"));
		setCols.add(new ColumnSet("name", "����ҵ������"));
		setCols.add(new ColumnSet("calcopnid", "����ҵ�����"));
		setCols.add(new ColumnSet("calname", "����ҵ������"));
		setCols.add(new ColumnSet("calcmonth", "�����·�"));
		setCols.add(new ColumnSet("wayid", "��������"));
		setCols.add(new ColumnSet("wayname", "��������"));		
		setCols.add(new ColumnSet("oprtime", "ҵ����ʱ��"));
		setCols.add(new ColumnSet("oprcode", "רԱ����"));
		setCols.add(new ColumnSet("mobile", "ҵ��������"));
		setCols.add(new ColumnSet("busivalue", "ҵ����"));
		setCols.add(new ColumnSet("rewardtype", "�������"));
		setCols.add(new ColumnSet("ossrc", "ҵ����Դ"));
		setCols.add(new ColumnSet("empattr2", "��Ա����"));		
		return setCols;
	}
	 /**
	 * ����ҳ����ʾ��Ч��
	 * @return the colSet
	 */
	public String getShowCols2(){
		return JSONArray.fromObject(getsetCols2()).toString();
	}
	
	@Override
	public QueryParameter getParameter() {
		parameter = parameter==null?new MissionerQueryParameter():parameter;
		
		// ����ҳ��
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// ����ҳ��
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// ���ô�С
		
		if(getMember() != null && !"".equals(getMember())){
			//��ϵ�绰��רԱ��ѯʱ���޶���רԱ��Ӧ�����ݣ���ҳ��������
			parameter.setTelephone(getMember().getTelephone());
			
			//���������������̲�ѯʱ���޶������̶�Ӧ�����ݣ���ҳ��������
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
