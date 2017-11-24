/**
 * auto-generated code
 * Tue Oct 13 09:30:24 CST 2009
 */
 package com.gmcc.pboss.web.sales.comprice;

 
import java.util.ArrayList;
import java.util.List;

import com.gmcc.pboss.business.channel.custwaytype.CustwaytypeDBParam;
import com.gmcc.pboss.business.channel.custwaytype.CustwaytypeVO;
import com.gmcc.pboss.business.sales.comprice.CompriceConstant;
import com.gmcc.pboss.business.sales.comprice.CompriceDBParam;
import com.gmcc.pboss.business.sales.comprice.CompriceVO;
import com.gmcc.pboss.business.sales.comprice.CompriceVOHelper;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.channel.custwaytype.Custwaytype;
import com.gmcc.pboss.control.channel.custwaytype.CustwaytypeBO;
import com.gmcc.pboss.control.sales.comprice.Comprice;
import com.gmcc.pboss.control.sales.comprice.CompriceBO;
import com.gmcc.pboss.web.base.dictitem.DictitemWebParam;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: CompriceAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CompriceAction extends BaseAction{
	public CompriceAction() throws Exception{
		super();

		//���¼��������Ǳ����
		this.setForm(new CompriceForm());
		this.setParam(new CompriceWebParam());

        //ָ��VO��
        setClsVO(CompriceVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"recid"};
		this.setClsControl(Comprice.class);
		this.setClsQueryParam(CompriceDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
		
	}
	
	public String doList() throws Exception{
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		CompriceDBParam param = (CompriceDBParam)getParam();
		param.set_se_cityid(cityid);
		
		super.doList();
						
		//��ѯ��Ʒ������Ϣ
		DictitemWebParam dictitemwebparam = new DictitemWebParam();
		DictitemBO dictitembo = (DictitemBO) BOFactory.build(
				DictitemBO.class, this.getDBAccessUser());
		dictitemwebparam.set_sne_dictid("%CZ");
		dictitemwebparam.set_se_groupid("IM_FXCOMCATEGORY");
		ArrayList dictitemformlist2 = (ArrayList) (dictitembo
				.doQuery(dictitemwebparam).getDatas());
		super.getRequest().getSession().setAttribute("dictitemformlist2",
				dictitemformlist2);
		//��ѯ����������Ϣ
		CustwaytypeBO  custwaytypeBO = (CustwaytypeBO)BOFactory.build(CustwaytypeBO.class, this.getDBAccessUser());
		CustwaytypeDBParam custwaytypeDBParam = new CustwaytypeDBParam();
		custwaytypeDBParam.set_ne_citycompid(cityid);
		ArrayList custwaytypeList1 = (ArrayList)(custwaytypeBO.doQuery(custwaytypeDBParam).getDatas());
		super.getRequest().getSession().setAttribute("custwaytypeList1", custwaytypeList1);
		
		//���ú��������б�
		Comprice comprice = (Comprice)BOFactory.build(CompriceBO.class,getDBAccessUser());
		List<CustwaytypeVO> custwaytypeList = comprice.doGetCustwaytypeList();
		getRequest().setAttribute("custwaytypeList", custwaytypeList);
		return WEB_RESULT_LIST;
	}
	
	
	public String doListExportTxt() throws Exception{
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		
		CompriceDBParam param = (CompriceDBParam)getParam();
		param.set_se_cityid(cityid);
		Comprice comprice = (Comprice)BOFactory.build(CompriceBO.class,getDBAccessUser());
		DataPackage dp = comprice.doQuery(param);
		List<CompriceVO> list = dp.getDatas(); 
		
		//�õ���������
		Custwaytype custwaytype = (Custwaytype) BOFactory.build(CustwaytypeBO.class,getDBAccessUser());
		CustwaytypeVO custwaytypeVO = new CustwaytypeVO();
		
		for (CompriceVO compriceVO : list) {
			custwaytypeVO.setCitycompid(compriceVO.getCityid());
			custwaytypeVO.setCustwaytypecode(compriceVO.getCooptype());
			custwaytypeVO=custwaytype.doFindByPk(custwaytypeVO);
			
			//���ú�������
			if(custwaytypeVO!=null)
			{
				compriceVO.setCoopname(custwaytypeVO.getCustwaytypename());
			}
			//�����ۼ۷�ʽ
			if("NODIF".equals(compriceVO.getPricediftype()))
			{
				compriceVO.setPrice2(null);
            	compriceVO.setPrice3(null);
            	compriceVO.setPrice4(null);
				compriceVO.setPrice5(null);
            }
			else if("ACCOUNT".equals(compriceVO.getPricediftype()))
			{
				compriceVO.setPrice3(compriceVO.getPrice2());
            	compriceVO.setPrice2(compriceVO.getPrice1());
            	compriceVO.setPrice4(null);
				compriceVO.setPrice5(null);
				compriceVO.setPrice1(null);
			}
			else if("INVOICE".equals(compriceVO.getPricediftype()))
			{
				compriceVO.setPrice4(compriceVO.getPrice1());
				compriceVO.setPrice5(compriceVO.getPrice2());
				compriceVO.setPrice1(null);
            	compriceVO.setPrice2(null);
            	compriceVO.setPrice3(null);
				
			} 
			 
		}
		dp.setDatas(list);
		this.setDp(dp); 
		return WEB_RESULT_LIST;
	}
	
	
	
	
	
	
	public String doNew() throws Exception{
		super.doNew();
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		
		//���ú��������б�
		Comprice comprice = (Comprice)BOFactory.build(CompriceBO.class,getDBAccessUser());
		List<CustwaytypeVO> custwaytypeList = comprice.doGetCustwaytypeList();
		getRequest().setAttribute("custwaytypeList", custwaytypeList);
		
		return WEB_RESULT_CONTENT;
	};
	
	public String doEdit() throws Exception{
		super.doEdit();
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		
		CompriceVO compriceVO= (CompriceVO) getForm();
		CompriceForm form = new CompriceForm();
		BeanUtils.copyProperties(form, compriceVO);
		//�����ۼ����ַ�ʽ��ȡ��Ӧ���ۼ�
		String type = compriceVO.getPricediftype();
		if(type.equals(CompriceConstant.PRICEDIFTYPE_NODIF))
		{
			form.setPrice2(null);
		}
		else if(type.equals(CompriceConstant.PRICEDIFTYPE_ACCOUNT))
		{
			form.setPrice2(compriceVO.getPrice1());
			form.setPrice3(compriceVO.getPrice2());
			form.setPrice1(null);
		}
		else if(type.equals(CompriceConstant.PRICEDIFTYPE_INVOICE))
		{
			form.setPrice4(compriceVO.getPrice1());
			form.setPrice5(compriceVO.getPrice2());
			form.setPrice1(null);
			form.setPrice2(null);
		}
		
		//���ú��������б�
		setForm(form);
		
		//���ú��������б�
		Comprice comprice = (Comprice)BOFactory.build(CompriceBO.class,getDBAccessUser());
		List<CustwaytypeVO> custwaytypeList = comprice.doGetCustwaytypeList();
		getRequest().setAttribute("custwaytypeList", custwaytypeList);
		
		return WEB_RESULT_CONTENT;
	};
	
	public String doSave() throws Exception{
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		CompriceForm form= (CompriceForm) getForm();
		Comprice comprice = (Comprice)BOFactory.build(CompriceBO.class,getDBAccessUser());
		
		//���ú��������б�
		List<CustwaytypeVO> custwaytypeList = comprice.doGetCustwaytypeList();
		getRequest().setAttribute("custwaytypeList", custwaytypeList);
		
		//��ѯ��¼�Ƿ��Ѿ�����
		CompriceDBParam param = new CompriceDBParam();
		param.set_se_cityid(form.getCityid());
		param.set_se_countyid(form.getCountyid());
		param.set_se_cooptype(form.getCooptype());
		param.set_se_comcategory(form.getComcategory());
		param.set_ne_starlevel(form.getStarlevel());
		
		if (WEB_CMD_EDIT.equals(CMD)) {
			param.set_nne_recid(form.getRecid().toString());
		}
		DataPackage dp = comprice.doQuery(param);
		if (dp.getRowCount() > 0) {
			addActionError("��ͬ��¼�Ѿ����ڣ����顣");
			return WEB_RESULT_CONTENT;
		}
		
		CompriceVOHelper helper = new CompriceVOHelper();
		BeanUtils.copyProperties(helper, form);
		Long recid = comprice.doCompriceSave(helper);
		form.setRecid(recid);
		setActionMessage("����ɹ�!");
		setCMD(WEB_CMD_SAVE);
		
		return WEB_RESULT_CONTENT;
	}
	
	
	
	
	public String doTxt() throws Exception { 

		CompriceDBParam compricedParamaram = (CompriceDBParam)super.getParam();
		compricedParamaram.setQueryAll(true);
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("��Ʒ���ۼ۸����õ���");
		export.addOutputProperty("recid", "����");
		export.addOutputProperty("cityid", "���й�˾",export.CODE2NAME,"#CITYCOMPANY");
		export.addOutputProperty("countyid", "�ֹ�˾",export.CODE2NAME,"#CNTYCOMPANY"); 
		export.addOutputProperty("starlevel", "�Ǽ� ",export.CODE2NAME,"$CH_STARLEVEL2");
		export.addOutputProperty("coopname", "��������");
		export.addOutputProperty("comcategory", "��Ʒ���� ",export.CODE2NAME,"$IM_FXCOMCATEGORY");
		export.addOutputProperty("pricediftype", "�ۼ����ַ�ʽ",export.CODE2NAME,"$FX_PRICEDIFTYPE");
		export.addOutputProperty("price1", "ͳһ�ۼ�(Ԫ)");
		export.addOutputProperty("price2", "�Թ��ۼ�(Ԫ)");
		export.addOutputProperty("price3", "��˽�ۼ�(Ԫ)");
		export.addOutputProperty("price4", "��Ʊ�ۼ�(Ԫ)");
		export.addOutputProperty("price5", "����Ʊ�ۼ�(Ԫ)");
		
		export.queryMethodName = "doListExportTxt";
		export.voClassArray = new Class[] { CompriceVO.class };
	
		prepareResponse(export.getFileName());
		
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"����", "���й�˾","�ֹ�˾", "�Ǽ� ","��������", "��Ʒ����","�ۼ����ַ�ʽ","ͳһ�ۼ�(Ԫ)","�Թ��ۼ�(Ԫ)","��˽�ۼ�(Ԫ)","��Ʊ�ۼ�(Ԫ)","����Ʊ�ۼ�(Ԫ)"});
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
}