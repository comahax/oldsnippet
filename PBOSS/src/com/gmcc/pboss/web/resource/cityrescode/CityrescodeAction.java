/**
 * auto-generated code
 * Tue Aug 09 20:23:41 CST 2011
 */
 package com.gmcc.pboss.web.resource.cityrescode;

import java.util.List;

import com.gmcc.pboss.business.base.functionitem.FunctionitemDBParam;
import com.gmcc.pboss.business.channel.custwaytype.CustwaytypeVO;
import com.gmcc.pboss.business.resource.cityrescode.CityrescodeVO ;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.resource.cityrescode.CityrescodeDBParam;
import com.gmcc.pboss.business.sales.comprice.CompriceDBParam;
import com.gmcc.pboss.control.resource.cityrescode.Cityrescode ;
import com.gmcc.pboss.control.sales.comprice.Comprice;
import com.gmcc.pboss.control.sales.comprice.CompriceBO;
import com.gmcc.pboss.web.base.functionitem.FunctionitemForm;

/**
 * <p>Title: CityrescodeAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class CityrescodeAction extends BaseAction{
	
	public CityrescodeAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new CityrescodeForm());
		this.setParam(new CityrescodeDBParam());

        //ָ��VO��
        setClsVO(CityrescodeVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"id"};
		this.setClsControl(Cityrescode.class);
		this.setClsQueryParam(CityrescodeDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}  
	
	public String doList() throws Exception{
		String cityid = getDBAccessUser().getCityid(); 
		CityrescodeDBParam param = (CityrescodeDBParam)getParam(); 
		param.set_se_cityid(cityid);
		
		super.doList();  
		return WEB_RESULT_LIST;
	}
	
	public String doSave() {
		try{
			CityrescodeForm form = (CityrescodeForm) super.getForm();
			CityrescodeDBParam param = (CityrescodeDBParam) super.getParam();
			String cityid = getDBAccessUser().getCityid(); 
			param.set_se_cityid(cityid);
			param.set_se_cityrescode(form.getCityrescode());
			param.set_se_comcategory(form.getComcategory());
			DataPackage dp = null;
			dp = (DataPackage)executeDlgMethod(METHOD_TYPE_QUERY, param);
			if (dp.getDatas().isEmpty()) {
				super.doSave();
			}else if(!dp.getDatas().isEmpty()){
				this.addActionError("��ͬ��¼�Ѿ����ڣ�����");
				return WEB_RESULT_CONTENT;
			}
		}catch(Exception e){
			this.addActionError(e.getMessage());
			return WEB_RESULT_CONTENT;
		}
		return WEB_RESULT_CONTENT;
	};	
}