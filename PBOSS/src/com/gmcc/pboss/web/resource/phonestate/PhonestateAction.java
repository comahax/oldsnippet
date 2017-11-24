/**
 * auto-generated code
 * Mon Jul 04 16:25:21 CST 2011
 */
 package com.gmcc.pboss.web.resource.phonestate;

import com.gmcc.pboss.business.resource.phonestate.PhonestateDBParam;
import com.gmcc.pboss.business.resource.phonestate.PhonestateVO;
import com.gmcc.pboss.control.resource.phonestate.Phonestate;
import com.gmcc.pboss.control.resource.phonestate.PhonestateBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: PhonestateAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author lyl
 * @version 1.0
 */
public class PhonestateAction extends BaseAction{
	
	public PhonestateAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new PhonestateForm());
		this.setParam(new PhonestateDBParam());

        //ָ��VO��
        setClsVO(PhonestateVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"comresid"};
		this.setClsControl(Phonestate.class);
		this.setClsQueryParam(PhonestateDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	public String doList() throws Exception{ 
		try{
			if (this.isQuery){
			Phonestate phonestateBO = (Phonestate) BOFactory.build(PhonestateBO.class, super.getDBAccessUser());
	        PhonestateDBParam params = (PhonestateDBParam)super.getParam(); 
			DataPackage dpTmp = (DataPackage)phonestateBO.doChooseData(params);		
			this.setDp(dpTmp);
			}
		}catch (Exception e) {e.printStackTrace();
			throw new Exception(e);
		}
		
		return WEB_RESULT_LIST;
	}
	private boolean isQuery;// �Ƿ�ͳ�Ʊ�ʶ��Ĭ�ϲ���ѯ

	public boolean getIsQuery() {
		return isQuery;
	}

	public void setIsQuery(boolean isQuery) {
		this.isQuery = isQuery;
	}
}