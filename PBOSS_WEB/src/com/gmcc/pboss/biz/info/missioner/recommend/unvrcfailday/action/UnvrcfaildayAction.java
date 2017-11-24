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
		// ����ҳ��
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// ����ҳ��
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// ���ô�С  
		
		short empattr2 = this.getLogMember().getEmpattr2();
		if(empattr2==1 || empattr2==2){//����רԱ ���� 1+3רԱ
			parameter.setRcno(this.getLogMember().getTelephone());
		}else{// 3 ������
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
		if(empattr2==1 || empattr2==2){//����רԱ ���� 1+3רԱ
			return "missioner";
		}else{// 3 ������
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
	 * ��ñ�ͷ
	 * @return
	 */
	public List<ColumnSet> getsetCols() {
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();	
//		u.failid,u.rcno,u.mobileno,u.opnid,o.name as opnname,u.rcmonth,u.rcdate
//		u.reason,u.ossrc,u.wayid,w.wayname,e.empattr2 
		//setCols.add(new ColumnSet("failid", "���"));
		setCols.add(new ColumnSet("rcno", "רԱ����"));
		setCols.add(new ColumnSet("mobileno", "�ͻ�����"));
		setCols.add(new ColumnSet("opnid", "ҵ�����"));
		setCols.add(new ColumnSet("opnname", "ҵ������"));
		setCols.add(new ColumnSet("rcmonth", "�Ƽ��·�"));
		setCols.add(new ColumnSet("rcdate", "�Ƽ�ʱ��"));
		setCols.add(new ColumnSet("reason", "ʧ��ԭ��"));
		setCols.add(new ColumnSet("ossrc", "ҵ��ƽ̨��Դ"));
		short empattr2 = this.getLogMember().getEmpattr2();
		if(empattr2==1 || empattr2==2){//����רԱ ���� 1+3רԱ
			setCols.add(new ColumnSet("wayid", "��������"));
			setCols.add(new ColumnSet("wayname", "��������"));
		}else{// 3 ������
			setCols.add(new ColumnSet("empattr2", "��Ա����"));	
		}
		return setCols;
	}
	 /**
	 * ����ҳ����ʾ��Ч��
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
