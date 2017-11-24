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

		//���¼��������Ǳ����
		this.setForm(new NumtypedefForm());
		this.setParam(new NumtypedefWebParam());

        //ָ��VO��
        setClsVO(NumtypedefVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"typeid"};
		this.setClsControl(Numtypedef.class);
		this.setClsQueryParam(NumtypedefDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	@Override
	public String doDelete() throws Exception {
		try{
			String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
			
			if(selectArray == null) {
				addActionError("�޷���ȡѡ����Ŀ��");
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
	 * Ϊ�����༭ҳ��ĺ�������б�ֵ
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
	 * ����
	 */
	public String doSave() throws Exception{
		try {
			Object obj =new  NumtypedefVO();
			BeanUtils.copyProperties(obj, getForm());		
			if (WEB_CMD_NEW.equals(getCMD())) {
				Object vo = null;
				if (pkNameArray.length == 1) { // ��һ����
					Object pk = PropertyUtils.getNestedProperty(obj, pkNameArray[0]);
					// ���ﷵ�ص���String����
					if (pk != null) {
						vo = executeDlgMethod(METHOD_TYPE_FINDBYPK, (Serializable) pk);
					}
				} else {// ��������
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
	 * ɾ��������������Ϣ
	 * @return
	 * @throws Exception
	 */
	public String doDeleteRule() throws Exception{
		try{
			String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
			
			if(selectArray == null) {
				addActionError("�޷���ȡѡ����Ŀ��");
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
	 * ���������������Ϣ
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
				this.addActionError("�Ѵ�����ͬ�Ĺ�����ʽ��");
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
	 * �ж�����/�༭����������Ϣ��ΨһԼ��
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
			numtypedefWebParam.set_se_typecode(typecode);//���ͱ���
			numtypedefWebParam.set_ne_effective("1");//��Ч
			//���ݽ���¼������ͱ���,��Ч��(��Ч)��ѯ�������Ͷ�����Ƿ��Ѿ����ڼ�¼
			if(typecode!=null && !"".equals(typecode) && bo.doQuery(numtypedefWebParam).getDatas().size()>0){
				writer.write("NO1");
			}else{
				//���ݽ���¼������ȼ�,��Ч��(��Ч)��ѯ�������Ͷ����
				numtypedefWebParam.set_ne_prilevel(prilevel);//���ȼ�
				numtypedefWebParam.set_se_typecode(null);//���ͱ������
				if(prilevel!=null && !"".equals(prilevel) && bo.doQuery(numtypedefWebParam).getDatas().size()>0){
					writer.write("NO2");
				}
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
	}
}