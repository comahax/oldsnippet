/**
 * auto-generated code
 * Sat Sep 05 16:02:03 CST 2009
 */
 package com.gmcc.pboss.web.resource.numtypedef;

import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.resource.numsortrule.NumsortruleDBParam;
import com.gmcc.pboss.business.resource.numsortrule.NumsortruleVO;
import com.gmcc.pboss.business.resource.numtypedef.NumtypedefDBParam;
import com.gmcc.pboss.business.resource.numtypedef.NumtypedefVO;
import com.gmcc.pboss.control.resource.numsortrule.Numsortrule;
import com.gmcc.pboss.control.resource.numsortrule.NumsortruleBO;
import com.gmcc.pboss.control.resource.numtypedef.Numtypedef;
import com.gmcc.pboss.control.resource.numtypedef.NumtypedefBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.i18n.I18nMessage;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: NumtypedefAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class NumtypedefAction extends BaseAction{
	private String ruleexp;
	
	public String getRuleexp() {
		return ruleexp;
	}
	public void setRuleexp(String ruleexp) {
		this.ruleexp = ruleexp;
	}
	public NumtypedefAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new NumtypedefForm());
		this.setParam(new NumtypedefWebParam());

        //指定VO类
        setClsVO(NumtypedefVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"typeid"};
		this.setClsControl(Numtypedef.class);
		this.setClsQueryParam(NumtypedefDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	@Override
	public String doDelete() throws Exception {
		try{
			String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
			
			if(selectArray == null) {
				addActionError("无法获取选中项目！");
				return doList();
			}
			Numtypedef numtypedef=(Numtypedef)BOFactory.build(NumtypedefBO.class,super.getDBAccessUser());
			numtypedef.doRemoveJoinNumsortrule(selectArray);
		}catch(Exception e){
			this.addActionMessage(e.getMessage());
		}
		
		return super.doList();
	}
	public String doEdit() throws Exception{
		String pk = getParam().get_pk();
		if (pk == null){
			setForm(new BaseVO());
			setCMD(WEB_CMD_NEW);
		}else{
			setForm(findVOFromDB());
			setCMD(WEB_CMD_EDIT);
			setDataPackage(((NumtypedefVO)getForm()).getTypeid());
		}
		
		return WEB_RESULT_CONTENT;
	}
	/**
	 * 为新增编辑页面的号码分类列表赋值
	 * @param typeid
	 * @throws Exception
	 */
	private void setDataPackage(Long typeid)throws Exception{
	/*	Numsortrule numsortrule=(Numsortrule)BOFactory.build(NumsortruleBO.class,super.getDBAccessUser());
		NumtypedefWebParam numtypedefWebParam=(NumtypedefWebParam)this.getParam();
		NumsortruleDBParam param=new NumsortruleDBParam();
		param.set_pageno(numtypedefWebParam.get_pageno());
		param.set_pagesize("10");
		param.set_ne_typeid(typeid);
		DataPackage dp = numsortrule.doQuery(param);
		setDp(dp);
		this.setClsQueryParam(NumsortruleDBParam.class);
		this.setParam(param);*/
		Numsortrule numsortrule=(Numsortrule)BOFactory.build(NumsortruleBO.class,super.getDBAccessUser());
		NumtypedefWebParam numtypedefWebParam=(NumtypedefWebParam)this.getParam();
		NumsortruleDBParam param=new NumsortruleDBParam();
		param.set_desc(numtypedefWebParam.get_desc());
		param.set_orderby(numtypedefWebParam.get_orderby());
		param.set_pageno(numtypedefWebParam.get_pageno());
		param.set_ne_typeid(typeid);
		DataPackage dp = numsortrule.doQuery(param);
		setDp(dp);
		numtypedefWebParam.set_desc(param.get_desc());
		numtypedefWebParam.set_orderby(param.get_orderby());
		numtypedefWebParam.set_pageno(param.get_pageno());
		numtypedefWebParam.set_pagesize(param.get_pagesize());
		this.setParam(numtypedefWebParam);
	}
	/**
	 * 保存
	 */
	public String doSave() throws Exception{
		try {
			Object obj =new  NumtypedefVO();
			BeanUtils.copyProperties(obj, getForm());		
			if (WEB_CMD_NEW.equals(getCMD())) {
				Object vo = null;
				if (pkNameArray.length == 1) { // 单一主键
					Object pk = PropertyUtils.getNestedProperty(obj, pkNameArray[0]);
					// 这里返回的是String类型
					if (pk != null) {
						vo = executeDlgMethod(METHOD_TYPE_FINDBYPK, (Serializable) pk);
					}
				} else {// 复合主建
					vo = executeDlgMethod(METHOD_TYPE_FINDBYPK, (Serializable) obj);
				}
				if (vo == null) {
					executeDlgMethod(METHOD_TYPE_CREATE, obj);
					
					  setActionMessage(I18nMessage.getPublicString("msgSaveSuccess"));
				} else {
					
					onDuplicatePk();
				}
			} else {
					executeDlgMethod(METHOD_TYPE_UPDATE, obj);
				
				    setActionMessage(I18nMessage.getPublicString("msgSaveSuccess"));
			}		
			setCMD(WEB_CMD_SAVE);
			this.setForm((NumtypedefVO)obj);
			setDataPackage(((NumtypedefVO)obj).getTypeid());
		} catch (Exception e) {
			super.addActionError(e.getMessage()==null?e.getCause().getMessage():e.getMessage());
			return WEB_RESULT_CONTENT;
		}
		return WEB_RESULT_CONTENT;
	}
	/**
	 * 删除号码分类规则信息
	 * @return
	 * @throws Exception
	 */
	public String doDeleteRule() throws Exception{
		try{
			String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
			
			if(selectArray == null) {
				addActionError("无法获取选中项目！");
				return doEdit();
			}
			Numsortrule numsortrule=(Numsortrule)BOFactory.build(NumsortruleBO.class,super.getDBAccessUser());	
			for (int i = 0; i < selectArray.length; i++) {
				numsortrule.doRemoveByPK(Long.valueOf(selectArray[i]));
			}
		}catch(Exception e){
			this.addActionMessage(e.getMessage());
		}
		
		return doEdit();
	}
	/**
	 * 保存号码分类规则信息
	 * @return
	 * @throws Exception
	 */
	public String doSaveRule() throws Exception{
		try{
			Numsortrule numsortrule=(Numsortrule)BOFactory.build(NumsortruleBO.class,super.getDBAccessUser());
			String typedefPk = getParam().get_pk();
			NumsortruleDBParam params = new NumsortruleDBParam();
			params.set_ne_typeid(Long.valueOf(typedefPk));
			params.set_se_ruleexp(ruleexp);
			if(numsortrule.doQuery(params).getDatas().size()>0){
				this.addActionError("已存在相同的规则表达式。");
				return doEdit();
			}
			NumsortruleVO vo =new NumsortruleVO();
			vo.setRuleexp(ruleexp);
			vo.setTypeid(Long.valueOf(typedefPk));
			numsortrule.doCreate(vo);
		}catch(Exception e){
			this.addActionMessage(e.getMessage());
		}		
		return doEdit();
	}
	/**
	 * 判断新增/编辑号码类型信息的唯一约束
	 * @throws Exception
	 */
	public void checkUnique() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		PrintWriter writer  = null;
		
		try{
			String typecode=request.getParameter("typecode");
			String prilevel=request.getParameter("prilevel");
			writer = response.getWriter();
			Numtypedef bo=(Numtypedef)BOFactory.build(NumtypedefBO.class,super.getDBAccessUser());	
			NumtypedefWebParam numtypedefWebParam=new NumtypedefWebParam();
			numtypedefWebParam.set_se_typecode(typecode);//类型编码
			numtypedefWebParam.set_ne_effective("1");//生效
			//根据界面录入的类型编码,有效性(有效)查询号码类型定义表是否已经存在记录
			if(typecode!=null && !"".equals(typecode) && bo.doQuery(numtypedefWebParam).getDatas().size()>0){
				writer.write("NO1");
			}else{
				//根据界面录入的优先级,有效性(有效)查询号码类型定义表
				numtypedefWebParam.set_ne_prilevel(prilevel);//优先级
				numtypedefWebParam.set_se_typecode(null);//类型编码清空
				if(prilevel!=null && !"".equals(prilevel) && bo.doQuery(numtypedefWebParam).getDatas().size()>0){
					writer.write("NO2");
				}
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
	}
}