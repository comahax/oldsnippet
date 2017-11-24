package com.gmcc.pboss.biz.info.salesDetail.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.apache.commons.lang.time.DateUtils;

import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.CodeReverseKey;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.ExcelColumn;
import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.biz.info.salesDetail.service.RegistersimService;
import com.gmcc.pboss.biz.info.salesDetail.support.RegistersimQueryParameter;

public class RegistersimAction extends AbstractAction {

	/*
	 * ��ȡ��ѯ����
	 */
	//��Ա����-��Ա���룬�׿�����oprcode�ֶζ�Ӧ��Ա��employeeid
	private String oprcode;
	public void setOprcode(String oprcode){
		this.oprcode = oprcode;
	}
	public String getOprcode(){
		return this.oprcode;
	}
	//�׿�����
	private String mobile;
	public void setMobile(String mobile){
		this.mobile = mobile;
	}
	public String getMobile(){
		return this.mobile;
	}
	//Ʒ��
	private String brand;
	public void setBrand(String b){
		this.brand = b;
	}
	public String getBrand(){
		return this.brand;
	}
	//�ǼǷ�ʽ
	private String flag;	
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	//��Ʒ����
	private String type;		
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	//�Ǽǿ�ʼʱ��
	private Date timeFrom;
	public void setTimeFrom(Date timeFrom){
		this.timeFrom = timeFrom;
	}
	public Date getTimeFrom(){
		return this.timeFrom;
	}
	//�Ǽǽ���ʱ��
	private Date timeTo;
	public void setTimeTo(Date timeTo){
		this.timeTo = timeTo;
	}
	public Date getTimeTo(){			
		return this.timeTo;
	}
	//������ʼʱ��
	private Date activeFrom;
	public void setActiveFrom(Date from){
		this.activeFrom = from;
	}
	public Date getActiveFrom(){
		return this.activeFrom;
	}
	//�������ʱ��
	private Date activeTo;
	public void setActiveTo(Date to){
		this.activeTo = to;
	}
	public Date getActiveTo(){
		return this.activeTo;
	}
	@Override
	public QueryParameter getParameter() {
		// TODO Auto-generated method stub
		RegistersimQueryParameter parameter = new RegistersimQueryParameter();
		// ����ҳ��
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// ����ҳ��
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// ���ô�С  
		
		LoginMember logMem = this.getMember();
		parameter.setCityid(logMem.getCityid());
		parameter.setWayid(logMem.getWayid());
		if(logMem.getIsnet()==0){//��Ա
			parameter.setOprcode(logMem.getEmployeeid());
		}
		else{//����
			if (this.getOprcode()!=null){
				parameter.setOprcode(this.getOprcode());
			}
		}
		parameter.setCountyid(logMem.getChannel().getCountyid());
		parameter.setSvccode(logMem.getChannel().getSvccode());
		if(this.getMobile()!=null)
			parameter.setMobile(this.getMobile());
		if(this.getBrand()!=null)
			parameter.setBrand(this.getBrand());
		if(this.getFlag()!=null && !"".equals(this.getFlag())){
			parameter.setFlag(this.getFlag());
		}
		if(this.getType()!=null && !"".equals(this.getType())){
			parameter.setType(this.getType());
		}
		if(this.getTimeFrom()!=null && this.getTimeTo()!=null){
			parameter.setStartDate(this.getTimeFrom());
			parameter.setEndDate(this.getTimeTo());
		}
		if(this.getActiveFrom()!=null && this.getActiveTo()!=null){
			parameter.setActiveFrom(this.getActiveFrom());
			parameter.setActiveTo(this.getActiveTo());
		}
		return parameter;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		//Date d = new Date();
		//this.setTimeFrom(d);
		//this.setTimeTo(DateUtils.addDays(d, 3));
		
	}
	
	/**
	 * ��Ա����-�׿�ҵ���ѯ��service
	 */
	private RegistersimService registersimService;
	public void setRegistersimService(RegistersimService registersimService){
		this.registersimService = registersimService;
	}
	public RegistersimService getRegistersimService(){
		return this.registersimService;
	}
	
	/*
	 *�����׿�������Ϣ��ѯ�б�
	 */
	public String doList(){
		this.setTitle(PageLoction.CARD_SALE_DETAIL_QUERY);
		RegistersimQueryParameter parameter = (RegistersimQueryParameter)this.getParameter();
		Date d = new Date();
		this.setTimeFrom(d);
		this.setTimeTo(d);
		return SUCCESS;
	}
	
	public String doAjax(){
		ServiceResult result = isLogin();
		if(result.isSuccess())
			result = registersimService.transact(getMember(), getParameter(), ServiceType.QUERY);
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
		ServiceResult result = registersimService.transact(member, param, ServiceType.QUERY);
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
		cols.add(new ExcelColumn("strstarlevel", "�Ǽ�",10));
		cols.add(new ExcelColumn("employeename", "��Ա",10));
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
		ServiceResult result = registersimService.transact(member, param, ServiceType.QUERY);
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
	
	//�ֹ�˾
	public String getStrCountyid(){
		String countyid = this.getMember().getChannel().getCountyid();
		String strCountyid = Constant.getCountyidchName(countyid);
		return strCountyid;
	}
}
