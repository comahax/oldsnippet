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

		//以下几个方法是必须的
		this.setForm(new CompriceForm());
		this.setParam(new CompriceWebParam());

        //指定VO类
        setClsVO(CompriceVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"recid"};
		this.setClsControl(Comprice.class);
		this.setClsQueryParam(CompriceDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
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
						
		//查询商品种类信息
		DictitemWebParam dictitemwebparam = new DictitemWebParam();
		DictitemBO dictitembo = (DictitemBO) BOFactory.build(
				DictitemBO.class, this.getDBAccessUser());
		dictitemwebparam.set_sne_dictid("%CZ");
		dictitemwebparam.set_se_groupid("IM_FXCOMCATEGORY");
		ArrayList dictitemformlist2 = (ArrayList) (dictitembo
				.doQuery(dictitemwebparam).getDatas());
		super.getRequest().getSession().setAttribute("dictitemformlist2",
				dictitemformlist2);
		//查询合作类型信息
		CustwaytypeBO  custwaytypeBO = (CustwaytypeBO)BOFactory.build(CustwaytypeBO.class, this.getDBAccessUser());
		CustwaytypeDBParam custwaytypeDBParam = new CustwaytypeDBParam();
		custwaytypeDBParam.set_ne_citycompid(cityid);
		ArrayList custwaytypeList1 = (ArrayList)(custwaytypeBO.doQuery(custwaytypeDBParam).getDatas());
		super.getRequest().getSession().setAttribute("custwaytypeList1", custwaytypeList1);
		
		//设置合作类型列表
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
		
		//得到合作类型
		Custwaytype custwaytype = (Custwaytype) BOFactory.build(CustwaytypeBO.class,getDBAccessUser());
		CustwaytypeVO custwaytypeVO = new CustwaytypeVO();
		
		for (CompriceVO compriceVO : list) {
			custwaytypeVO.setCitycompid(compriceVO.getCityid());
			custwaytypeVO.setCustwaytypecode(compriceVO.getCooptype());
			custwaytypeVO=custwaytype.doFindByPk(custwaytypeVO);
			
			//设置合作类型
			if(custwaytypeVO!=null)
			{
				compriceVO.setCoopname(custwaytypeVO.getCustwaytypename());
			}
			//区分售价方式
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
		
		//设置合作类型列表
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
		//根据售价区分方式获取相应的售价
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
		
		//设置合作类型列表
		setForm(form);
		
		//设置合作类型列表
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
		
		//设置合作类型列表
		List<CustwaytypeVO> custwaytypeList = comprice.doGetCustwaytypeList();
		getRequest().setAttribute("custwaytypeList", custwaytypeList);
		
		//查询记录是否已经存在
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
			addActionError("相同记录已经存在，请检查。");
			return WEB_RESULT_CONTENT;
		}
		
		CompriceVOHelper helper = new CompriceVOHelper();
		BeanUtils.copyProperties(helper, form);
		Long recid = comprice.doCompriceSave(helper);
		form.setRecid(recid);
		setActionMessage("保存成功!");
		setCMD(WEB_CMD_SAVE);
		
		return WEB_RESULT_CONTENT;
	}
	
	
	
	
	public String doTxt() throws Exception { 

		CompriceDBParam compricedParamaram = (CompriceDBParam)super.getParam();
		compricedParamaram.setQueryAll(true);
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("商品销售价格设置导出");
		export.addOutputProperty("recid", "编码");
		export.addOutputProperty("cityid", "地市公司",export.CODE2NAME,"#CITYCOMPANY");
		export.addOutputProperty("countyid", "分公司",export.CODE2NAME,"#CNTYCOMPANY"); 
		export.addOutputProperty("starlevel", "星级 ",export.CODE2NAME,"$CH_STARLEVEL2");
		export.addOutputProperty("coopname", "合作类型");
		export.addOutputProperty("comcategory", "商品种类 ",export.CODE2NAME,"$IM_FXCOMCATEGORY");
		export.addOutputProperty("pricediftype", "售价区分方式",export.CODE2NAME,"$FX_PRICEDIFTYPE");
		export.addOutputProperty("price1", "统一售价(元)");
		export.addOutputProperty("price2", "对公售价(元)");
		export.addOutputProperty("price3", "对私售价(元)");
		export.addOutputProperty("price4", "打发票售价(元)");
		export.addOutputProperty("price5", "不打发票售价(元)");
		
		export.queryMethodName = "doListExportTxt";
		export.voClassArray = new Class[] { CompriceVO.class };
	
		prepareResponse(export.getFileName());
		
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"编码", "地市公司","分公司", "星级 ","合作类型", "商品种类","售价区分方式","统一售价(元)","对公售价(元)","对私售价(元)","打发票售价(元)","不打发票售价(元)"});
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
}