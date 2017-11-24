/**
 * auto-generated code
 * Tue Jul 05 09:55:05 CST 2011
 */
 package com.gmcc.pboss.web.base.smsobject; 
import java.util.List;

import com.gmcc.pboss.business.base.smsobject.SmsobjectVO ; 
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.base.smsobject.SmsobjectDBParam; 
import com.gmcc.pboss.business.channel.custwaytype.CustwaytypeVO;
import com.gmcc.pboss.business.sales.comprice.CompriceConstant;
import com.gmcc.pboss.business.sales.comprice.CompriceDBParam;
import com.gmcc.pboss.business.sales.comprice.CompriceVO;
import com.gmcc.pboss.business.sales.comprice.CompriceVOHelper;
import com.gmcc.pboss.control.base.smsobject.Smsobject;
import com.gmcc.pboss.control.sales.comprice.Comprice;
import com.gmcc.pboss.control.sales.comprice.CompriceBO;
import com.gmcc.pboss.web.sales.comprice.CompriceForm;

/**
 * <p>Title: SmsobjectAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author lyl
 * @version 1.0
 */
public class SmsobjectAction extends BaseAction{
	
	public SmsobjectAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new SmsobjectForm());
		this.setParam(new SmsobjectDBParam());

        //ָ��VO��
        setClsVO(SmsobjectVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"seqid"};
		this.setClsControl(Smsobject.class);
		this.setClsQueryParam(SmsobjectDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	//�õ��û����ڵĵ��б��
	public String doList() throws Exception{
		
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid); 
		super.doList();
		return WEB_RESULT_LIST;
	}
	
	public String doEdit() throws Exception{
		
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid); 
		super.doEdit(); 
		return WEB_RESULT_CONTENT;
	}
	
	public String doNew() throws Exception{
		
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid); 
		super.doNew();
		return WEB_RESULT_CONTENT;
	}
	
	
	
}