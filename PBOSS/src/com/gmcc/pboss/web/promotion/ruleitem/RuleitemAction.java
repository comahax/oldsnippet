/**
 * auto-generated code
 * Fri Sep 18 18:06:45 CST 2009
 */
 package com.gmcc.pboss.web.promotion.ruleitem;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.promotion.elmtinst.ElmtinstDBParam;
import com.gmcc.pboss.business.promotion.elmtinst.ElmtinstVO;
import com.gmcc.pboss.business.promotion.elmttmpl.ElmttmplDBParam;
import com.gmcc.pboss.business.promotion.elmttmpl.ElmttmplVO;
import com.gmcc.pboss.business.promotion.ruleitem.RuleitemDBParam;
import com.gmcc.pboss.business.promotion.ruleitem.RuleitemVO;
import com.gmcc.pboss.control.promotion.elmtinst.Elmtinst;
import com.gmcc.pboss.control.promotion.elmtinst.ElmtinstBO;
import com.gmcc.pboss.control.promotion.elmttmpl.Elmttmpl;
import com.gmcc.pboss.control.promotion.elmttmpl.ElmttmplBO;
import com.gmcc.pboss.control.promotion.ruleitem.Ruleitem;
import com.gmcc.pboss.control.promotion.ruleitem.RuleitemBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.AAUtilsForStruts2;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: RuleitemAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RuleitemAction extends BaseAction{
	public static final String EXP_TYPE1 = "1";
	public static final String EXP_TYPE2 = "2";
	public static final String EXP_TYPE3 = "3";
	public static final String EXP_TYPE4 = "4";
	public static final String EXP_TYPE5 = "5";
	
	public static final String SOURCE = "0";
	public static final String NORM = "1";
	public static final String HASSOURCE = "1";
	public static final String NOSOURCE = "0";
	
	public RuleitemAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new RuleitemForm());
		this.setParam(new RuleitemWebParam());

        //指定VO类
        setClsVO(RuleitemVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"itemid"};
		this.setClsControl(Ruleitem.class);
		this.setClsQueryParam(RuleitemDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	@Override
	public String doList() throws Exception {
		RuleitemForm itemform = (RuleitemForm) getForm();
		if(ServletActionContext.getRequest()
				.getParameter("pk")!=null){
			itemform.setRuleid(Long.valueOf(ServletActionContext.getRequest()
					.getParameter("pk")));
			itemform.setPid(Long.valueOf(ServletActionContext.getRequest()
					.getParameter("pk1")));
			itemform.setIsEnabled(ServletActionContext.getRequest()
				.getParameter("isActive"));
		}
		RuleitemDBParam params = (RuleitemDBParam) this.getParam();
		RuleitemBO itembo = (RuleitemBO) BOFactory.build(RuleitemBO.class, getDBAccessUser());
		params.set_ne_ruleid(itemform.getRuleid().toString());
		
		DataPackage itemdp = itembo.doQuery(params);
		if(itemdp!=null && itemdp.getDatas().size()>0){
			this.setDp(itemdp);
			return "list";
		}
		return "list";
	}
	
	public String doNew() throws Exception{
		setCMD(WEB_CMD_NEW);
		
		Ruleitem ruleitem = (Ruleitem)BOFactory.build(RuleitemBO.class,getDBAccessUser());
		RuleitemForm form= (RuleitemForm) getForm();
		Boolean hasSource = getHasSourceFlag(ruleitem,String.valueOf(form.getRuleid()));
		if(hasSource)
		{
			form.setHasSource(HASSOURCE);
			String columnsinfo = "";
			RuleitemVO ruleitemVO = getSource(ruleitem,String.valueOf(form.getRuleid()));
			String instid = getSourceInstid(ruleitem, ruleitemVO.getOptexpression());
			columnsinfo = getColumnsinfo(instid);
			
			//将字段信息封装成map，回传到页面
			Map<String,String> sourceMap = getColumnsMap(columnsinfo);
			form.setSourceMap(sourceMap);
		}
		else
		{
			form.setHasSource(NOSOURCE);
		}
		return WEB_RESULT_CONTENT;
	}
	
	public String doSave() throws Exception{
		RuleitemForm form= (RuleitemForm) getForm();
		Ruleitem ruleitem = (Ruleitem)BOFactory.build(RuleitemBO.class, getDBAccessUser());
		String columnsinfo = "";
		String instid = new String();
		
		//获取实例标识
		if(null!=form.getExpType() && form.getExpType().equals(EXP_TYPE1))instid=form.getElmtinst_1_1();
		else if(null!=form.getExpType() && form.getExpType().equals(EXP_TYPE2))instid=form.getElmtinst_2_1();
		else if(null!=form.getExpType() && form.getExpType().equals(EXP_TYPE3))instid=form.getElmtinst_3_1();
		else if(null!=form.getExpType() && form.getExpType().equals(EXP_TYPE4))instid=form.getElmtinst_4_1();
		else if(null!=form.getExpType() && form.getExpType().equals(EXP_TYPE5))instid=ruleitem.doGetInstid(form.getParam_5());
		
		//根据实例标识获取字段信息
		columnsinfo = getColumnsinfo(instid);
		//设置字段信息
		form.setColumnsinfo(columnsinfo);
		
		//设置规则标识
		//form.setRuleid(new Long(1));
		
		//设置表达式信息
		String expression = new String();
		if(null!=form.getExpType() && form.getExpType().equals(EXP_TYPE1))
		{
			expression = form.getElmtinst_1_1();
		}
		else if(null!=form.getExpType() && form.getExpType().equals(EXP_TYPE2))
		{
			expression = form.getElmtinst_2_1() + "/" + form.getElmtinst_2_2();
		}
		else if(null!=form.getExpType() && form.getExpType().equals(EXP_TYPE3))
		{
			expression = "(" + form.getElmtinst_3_1() + "-" + form.getElmtinst_3_2() + ")"
					   + "/" + form.getElmtinst_3_2() + ">" + form.getParam_3();
		}
		else if(null!=form.getExpType() && form.getExpType().equals(EXP_TYPE4))
		{
			expression = form.getElmtinst_4_1() + "/" + form.getElmtinst_4_2() + ">" + form.getParam_4();
		}
		else if(null!=form.getExpType() && form.getExpType().equals(EXP_TYPE5))
		{
			expression = form.getParam_5();
		}
		form.setOptexpression(expression);
		
		if(null!=form.getHasSource()&&form.getHasSource().equals(NOSOURCE))
		{
			//设置数据类型
			form.setDatatype(SOURCE);
			//设置过滤方式
			form.setFiltermode(null);
			//设置匹配条件
			form.setMatching(null);

		}
		else if(null!=form.getHasSource()&&form.getHasSource().equals(HASSOURCE))
		{
			//设置数据类型
			form.setDatatype(NORM);
			//设置匹配条件,过滤方式由页面带入
			String sourceStr = form.getSource();
			String[] resArray = sourceStr.split(", ");
			String normStr = form.getNorm();
			String[] normArray = normStr.split(", ");
			
			StringBuffer sb = new StringBuffer();
			for(int i=0; i<resArray.length; i++)
			{
				sb.append(resArray[i] + "=" + normArray[i] + ";");
			}
			form.setMatching(sb.toString());

		}
		
		//复制到vo
		RuleitemVO vo = new RuleitemVO();
		BeanUtils.copyProperties(vo, form);
		
		//保存规则明细
		ruleitem.doCreate(vo);
		setActionMessage("保存成功!");
		setCMD(WEB_CMD_SAVE);
		form.setItemid(vo.getItemid());
		
		return WEB_RESULT_CONTENT;
	}
	
	public String doDelete() throws Exception{
		RuleitemForm form= (RuleitemForm) getForm();
		//如果数据里有源数据，则删除所有数据
		if(null!=form.getHasSource()&&form.getHasSource().equals(HASSOURCE))
		{
			Ruleitem ruleitem = (Ruleitem)BOFactory.build(RuleitemBO.class,getDBAccessUser());
			RuleitemDBParam param = new RuleitemDBParam();
			param.set_ne_ruleid(getRequest().getParameter("pk"));
			param.set_pagesize("0");
			DataPackage dp = ruleitem.doQuery(param);
			List<RuleitemVO> ruleitemList = dp.getDatas();
			if(null!=ruleitemList && ruleitemList.size()>0)
			{
				for(int i=0; i<ruleitemList.size(); i++)
				{
					ruleitem.doRemoveByPK(ruleitemList.get(i).getItemid());
				}
			}
			return doList();
		}
		else
		{
			return super.doDelete();
		}
	}
	
	public String doRefresh() throws Exception {
		if(AAUtilsForStruts2.isAjaxRequest()){
			Ruleitem ruleitem = (Ruleitem)BOFactory.build(RuleitemBO.class,getDBAccessUser());
			String columnsinfo = "";
			RuleitemForm form= (RuleitemForm) getForm();
			
			//获取实例标识
			String instid = new String();
			
			if(null!=form.getExpType() && form.getExpType().equals(EXP_TYPE1))instid=form.getElmtinst_1_1();
			else if(null!=form.getExpType() && form.getExpType().equals(EXP_TYPE2))instid=form.getElmtinst_2_1();
			else if(null!=form.getExpType() && form.getExpType().equals(EXP_TYPE3))instid=form.getElmtinst_3_1();
			else if(null!=form.getExpType() && form.getExpType().equals(EXP_TYPE4))instid=form.getElmtinst_4_1();
			else if(null!=form.getExpType() && form.getExpType().equals(EXP_TYPE5))instid=ruleitem.doGetInstid(form.getParam_5());
			
			if(null!=instid&&!instid.equals(""))
			{
				columnsinfo = getColumnsinfo(instid);
			}
			super.getRequest().setAttribute("columnsinfo",columnsinfo);
			AAUtilsForStruts2.addZonesToRefresh("refreshTable");
		}
		return "content";
	}
	
	public String getColumnsinfo(String instid) throws Exception{
		String columnsinfo = "";
		
		ElmtinstDBParam param = new ElmtinstDBParam();
		param.set_se_instid(instid);
		
		//根据实例标识得到模板信息，根据模板信息获取字段信息
		Elmtinst elmtinst = (Elmtinst) BOFactory.build(ElmtinstBO.class, getDBAccessUser()) ;
		DataPackage dp = elmtinst.doQuery(param);
		if(dp != null && dp.getDatas().size() == 1){
			ElmtinstVO elmtinstVO = (ElmtinstVO) dp.getDatas().get(0);
			Elmttmpl elmttmpl = (Elmttmpl)BOFactory.build(ElmttmplBO.class, getDBAccessUser());
			ElmttmplDBParam param2= new ElmttmplDBParam();
			param2.set_se_tmplid(elmtinstVO.getTmplid().toString());
			dp = elmttmpl.doQuery(param2);
			if(dp != null && dp.getDatas().size() == 1){
				ElmttmplVO elmttmplVO = (ElmttmplVO) dp.getDatas().get(0);
				columnsinfo = elmttmplVO.getColumnsinfo();
			}
		}
		return columnsinfo;
	}
	
	public Map<String,String> getColumnsMap(String columnsinfo) throws Exception {
		String[] columnsArray = columnsinfo.split("\\|");
		Map<String,String> columnsMap = new LinkedHashMap<String,String>();
		for(int i=0; i<columnsArray.length; i++)
		{
			columnsMap.put(columnsArray[i], columnsArray[i]);
		}
		return columnsMap;
	}
	
	public String getSourceInstid(Ruleitem ruleitem, String expression) throws Exception {
		String instid = ruleitem.doGetInstid(expression);
		return instid;
	}
	
	public RuleitemVO getSource(Ruleitem ruleitem, String ruleid) throws Exception {
		RuleitemDBParam param = new RuleitemDBParam();
		param.set_se_datatype(SOURCE);
		param.set_ne_ruleid(ruleid);
		DataPackage dp = ruleitem.doQuery(param);
		
		if(null!=dp && dp.getDatas().size()==1)return (RuleitemVO)dp.getDatas().get(0);
		else return null;
	}
	
	public Boolean getHasSourceFlag(Ruleitem ruleitem, String ruleid) throws Exception {
		RuleitemVO ruleitemVO = getSource(ruleitem, ruleid);
		if(ruleitemVO!=null)return true;
		else return false;
	}
}