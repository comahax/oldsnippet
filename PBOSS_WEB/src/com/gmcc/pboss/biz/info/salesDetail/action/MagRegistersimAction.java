package com.gmcc.pboss.biz.info.salesDetail.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONArray;

import com.gmcc.pboss.biz.info.salesDetail.service.MagRegistersimService;
import com.gmcc.pboss.biz.info.salesDetail.support.MagRegistersimQueryParameter;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.constant.service.ConstantService;
import com.gmcc.pboss.common.dictionary.CodeReverseKey;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.ExcelColumn;
import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.model.constant.ChPwCntycompany;
import com.gmcc.pboss.biz.info.salesDetail.support.MagRegistersimQueryParameter;

public class MagRegistersimAction extends AbstractAction {

	MagRegistersimQueryParameter parameter;
	@Override
	public QueryParameter getParameter() {
		// TODO Auto-generated method stub
		//MagRegistersimQueryParameter parameter = new MagRegistersimQueryParameter();
		parameter = parameter==null?new MagRegistersimQueryParameter():parameter;
		// ����ҳ��
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// ����ҳ��
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// ���ô�С  
		parameter.setCityid(this.getMember().getCityid());
		if(!StringUtils.isNotEmpty(parameter.getWayid())){
			//��ѯ����δ�޶�������룬���Ծ���������������Ϊ��Χ��������ﲻ���ƣ���ѯ�����Ŵ�
			parameter.setWaymagcode(this.getMember().getEmployeeid());
		}
		return parameter;
	}
	public void setParameter(MagRegistersimQueryParameter p){
		this.parameter = p;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		//Date d = new Date();
		//this.setTimeFrom(d);
		//this.setTimeTo(DateUtils.addDays(d, 3));
	}

	/**
	 * ������Ա-�׿�ҵ���ѯ��service
	 */
	private MagRegistersimService magRegistersimService;
	public void setMagRegistersimService(MagRegistersimService magRegistersimService){
		this.magRegistersimService = magRegistersimService;
	}
	public MagRegistersimService getMagRegistersimService(){
		return this.magRegistersimService;
	}
	
	/**
	 * �̶�����Service
	 */
	private ConstantService constantService;
	public ConstantService getConstantService() {
		return constantService;
	}
	public void setConstantService(ConstantService constantService) {
		this.constantService = constantService;
	}
	/*
	 *�����׿�������Ϣ��ѯ�б�
	 */
	public String doList(){
		this.setTitle(PageLoction.MAG_CARD_SALE_DETAIL_QUERY);
		MagRegistersimQueryParameter p = (MagRegistersimQueryParameter)this.getParameter();
		Date d = new Date();
		p.setTimeFrom(d);
		p.setTimeTo(d);
		return SUCCESS;
	}
	
	public String doAjax(){
		ServiceResult result = isLogin();
		if(result.isSuccess())
			result = magRegistersimService.transact(getMember(), getParameter(), ServiceType.QUERY);
		this.writeJSONServicePage(result, getsetCols());
		return null;
	}
	
	/**
	 * ����Excel
	 */
	public String doExportExcel(){
		LoginMember member = getMember();
		QueryParameter param = getParameter();
		param.setAction(QueryAction.ALL);
		ServiceResult result = magRegistersimService.transact(member, param, ServiceType.QUERY);
		if (result.isSuccess() && result.getRetResult() != null && result.getRetResult().getData() != null && result.getRetResult().getData().size() > 0) {
			int size = result.getRetResult().getData().size();
			if( size>0 && size<=65536 )//�����������ݲ��ܳ���65536�У�����Excel2003��֧��
				this.exportExcel(result.getRetResult().getData());
		}
		return null;
	}
	/**
	 * ���ص���Excel�ļ�������
	 */
	protected String getExcelTitle(){
		return "�׿�������ϸ�嵥";
	}
	/**
	 * ���ص���excel���е���Ϣ
	 * @return
	 */
	protected List<ExcelColumn> getExcelColumn(){
		List<ExcelColumn> cols = new ArrayList<ExcelColumn>();
		cols.add(new ExcelColumn("wayid","�������",10));
		cols.add(new ExcelColumn("wayname", "��������",15));
		cols.add(new ExcelColumn("strcountyid", "�ֹ�˾",15));
		cols.add(new ExcelColumn("strstarlevel", "�Ǽ�",15));
		cols.add(new ExcelColumn("employeename", "��Ա",15));
		cols.add(new ExcelColumn("officetel", "�����ֻ�����",15));
		cols.add(new ExcelColumn("mobile", "�׿�����",15));//�׿�����
		cols.add(new ExcelColumn("brandName", "Ʒ��",10));
		cols.add(new ExcelColumn("comname", "��Ʒ��",10));
		cols.add(new ExcelColumn("comtype", "��Ʒ����",10));
		cols.add(new ExcelColumn("comclassid", "��Ʒ���",10));
		cols.add(new ExcelColumn("comprice", "��Ʒ�۸�(Ԫ)",15));
		cols.add(new ExcelColumn("flag", "���Ǳ�ʶ",10));
		cols.add(new ExcelColumn("oprtime", "�Ǽ�ʱ��",20,"yyyy-MM-dd HH:mm:ss"));
		cols.add(new ExcelColumn("activedate", "����ʱ��",20,"yyyy-MM-dd HH:mm:ss"));
		return cols;
	}
	/**
	 * ����txt
	 */
	public String doExportTxt(){
		LoginMember member = getMember();
		QueryParameter param = getParameter();
		param.setAction(QueryAction.ALL );
		ServiceResult result = magRegistersimService.transact(member, param, ServiceType.QUERY);
		if (result.isSuccess() && result.getRetResult() != null && result.getRetResult().getData() != null && result.getRetResult().getData().size() > 0) {
			this.exportTxt(result.getRetResult().getData());
		}
		return null;
	}
	
	/**
	 * ��ñ�ͷ
	 * @return
	 */
	public List<ColumnSet> getsetCols() {
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		setCols.add(new ColumnSet("wayid", "�������"));
		setCols.add(new ColumnSet("wayname", "��������"));
		setCols.add(new ColumnSet("strcountyid", "�ֹ�˾"));
		setCols.add(new ColumnSet("strstarlevel", "�Ǽ�"));
		setCols.add(new ColumnSet("employeename", "��Ա"));
		setCols.add(new ColumnSet("officetel", "�����ֻ�����"));
		setCols.add(new ColumnSet("mobile", "�׿�����"));//�׿�����
		setCols.add(new ColumnSet("brandName", "Ʒ��"));
		setCols.add(new ColumnSet("comname", "��Ʒ��"));
		setCols.add(new ColumnSet("comtype", "��Ʒ����"));
		setCols.add(new ColumnSet("comclassid", "��Ʒ���"));
		setCols.add(new ColumnSet("comprice", "��Ʒ�۸�(Ԫ)"));
		setCols.add(new ColumnSet("flag", "���Ǳ�ʶ"));
		setCols.add(new ColumnSet("oprtime", "�Ǽ�ʱ��"));
		setCols.add(new ColumnSet("activedate", "����ʱ��"));
		//setCols.add(new ColumnSet("oper", "����",true));
		return setCols;
	}
	 /**
	 * ����ҳ����ʾ��Ч��
	 * @return the colSet
	 */
	public String getShowCols(){
		return JSONArray.fromObject(getsetCols()).toString();
	}	
	
	/**
	 * ��ȡƷ������
	 */
	public Map getBrandType(){
		Map t = new LinkedHashMap();
		t.put("", "��ѡ��");
		Map brandType = Constant.getConstantsMap(CodeReverseKey.SIMBRAND);
		t.putAll(brandType);
		return t;
	}
	
	/**
	 * ��ȡ�׿��ǼǷ�ʽ
	 */
	public Map getMendFlag(){
		Map t = new LinkedHashMap();
		t.put("", "");
		Map mendFlag = Constant.getConstantsMap(CodeReverseKey.CH_MFLAG);
		t.putAll(mendFlag);
		return t;
	}
	
	/**
	 * ��ȡ��Ʒ����
	 */
	public Map getComType(){
		Map t = new LinkedHashMap();
		t.put("", "");
		Map comType = Constant.getConstantsMap(CodeReverseKey.IM_COMTYPE);
		t.putAll(comType);
		return t;
	}
	
	/**
	 * �ֹ�˾��Ϣ����
	 * @return
	 */
	public Map<String,String> getCntyComd() {
		//��ȡ��Ȼ��¼�û���Ϣ
		LoginMember member = this.getMember();
		LinkedHashMap<String, String> rtn = new LinkedHashMap<String, String>();

		rtn.put("", "��ѡ��");
		
		Map<String, ChPwCntycompany> map = this.constantService.getBranchCntyComps(member.getCityid());
		
		//�ֹ�˾��Ϣ������ʱ��ֱ�ӷ���ԭ����MAP
		if (map == null) return rtn;
		//����Map
		Iterator<String> allKey = map.keySet().iterator();
		while (allKey.hasNext()){
			String key = allKey.next();
			ChPwCntycompany value = map.get(key);
			rtn.put(key, value.getCountycompname());
		}
		return rtn;
	}
}
