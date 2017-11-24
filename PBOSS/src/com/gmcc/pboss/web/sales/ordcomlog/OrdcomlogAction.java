/**
 * auto-generated code
 * Wed Aug 04 10:45:31 CST 2010
 */
 package com.gmcc.pboss.web.sales.ordcomlog;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.sales.ordcomlog.OrdcomlogDBParam;
import com.gmcc.pboss.business.sales.ordcomlog.OrdcomlogVO;
import com.gmcc.pboss.control.sales.ordcomlog.Ordcomlog;
import com.gmcc.pboss.control.sales.ordcomlog.OrdcomlogBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: OrdcomlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class OrdcomlogAction extends BaseAction{
	
	public OrdcomlogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new OrdcomlogForm());
		this.setParam(new OrdcomlogDBParam());

        //ָ��VO��
        setClsVO(OrdcomlogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"seqid"};
		this.setClsControl(Ordcomlog.class);
		this.setClsQueryParam(OrdcomlogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	public String doList() throws Exception {
		OrdcomlogForm form = (OrdcomlogForm)getForm();
		Long ordcomid = form.getOrdcomid();
		
		Ordcomlog ordcomlog = (Ordcomlog)BOFactory.build(OrdcomlogBO.class, getDBAccessUser());
		OrdcomlogDBParam param = (OrdcomlogDBParam)getParam();
		if(null!=ordcomid)
		{
			param.set_ne_ordcomid(String.valueOf(ordcomid));
		}
		param.set_pagesize("0");
		//��һ�ν����ʶ������Ĭ������
		String flag = (String)getRequest().getParameter("flag");
		if(null!=flag)
		{
			param.set_orderby("optime");
			param.set_desc("1");
		}
		DataPackage dp = null;
		try{
			dp = ordcomlog.doQuery(param);
			List<OrdcomlogVO> ordcomlogList = dp.getDatas();
			for(int i=0; i<ordcomlogList.size(); i++)
			{
				OrdcomlogVO ordcomlogVO = ordcomlogList.get(i);
				ordcomlogVO.setId(i+1);
			}
		}catch (Exception e) {
			addActionError(e.getMessage());
		}
		setDp(dp);
		return WEB_RESULT_LIST;
	}
}