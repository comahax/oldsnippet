/**
 * auto-generated code
 * Wed Dec 28 15:16:03 CST 2011
 */
 package com.gmcc.pboss.web.examine.disexamine;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date; 
import java.util.List;

import javassist.expr.NewArray;

import org.apache.log4j.helpers.DateTimeDateFormat;

import com.gmcc.pboss.business.examine.disexamine.DisexamineVO ;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.sunrise.jop.ui.struts2.WebConstant;
import com.gmcc.pboss.business.examine.disexamine.DisexamineDBParam; 
import com.gmcc.pboss.control.communication.advinfo.Advinfo;
import com.gmcc.pboss.control.communication.advinfo.AdvinfoBO;
import com.gmcc.pboss.control.examine.disexamine.Disexamine ;
import com.gmcc.pboss.control.examine.disexamine.DisexamineBO;

/**
 * <p>Title: DisexamineAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class DisexamineAction extends BaseAction{
	
	public DisexamineAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new DisexamineForm());
		this.setParam(new DisexamineDBParam());

        //ָ��VO��
        setClsVO(DisexamineVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"seqid"};
		this.setClsControl(Disexamine.class);
		this.setClsQueryParam(DisexamineDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	public String doSave() throws Exception{
		
		//��ȡ��ǰ������Ա����
		 User user = (User)super.getRequest().getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);  
	     Date date = new Date();
		 DisexamineVO disexamineForm = (DisexamineVO) getForm();
		 disexamineForm.setCreatetime(date);
		 disexamineForm.setCreatecode(user.getOprcode());  
		 if ( !disexamineForm.getExmnperiod().substring(0, 4).equals(new SimpleDateFormat("yyyy").format(date)) || Integer.parseInt(disexamineForm.getExmnperiod().substring(4))!=date.getMonth()+1){
			 if (CMD.equals("EDIT")) {
				 setActionMessage("ֻ���޸Ŀ�������Ϊ���µ�����");
			 }else{
				 setActionMessage("ֻ��������������Ϊ���µ�����");
			 }
			 return WEB_RESULT_CONTENT;
		 }
		 setForm(disexamineForm); 
		 super.doSave();
		return WEB_RESULT_CONTENT;
	}
	 
	public String doDelete() throws Exception{
		String string = this.getRequest().getParameter("seqids");
		String[] seqid =string.split("\\|");
		DisexamineDBParam disexamineDBParam = new DisexamineDBParam();
		ArrayList list = new ArrayList();
	    for (int i=0;i<seqid.length;i++) {
	    	 if(null!=seqid[i]){
	    		  list.add(seqid[i]);
	    	 }
	    }
	    disexamineDBParam.set_nin_seqid(list);
	    Disexamine disexamineBo = (DisexamineBO) BOFactory.build(DisexamineBO.class,
				getDBAccessUser()); 
	    DataPackage dp = disexamineBo.doQuery(disexamineDBParam); 
	    List disexamineList = new ArrayList();
	    disexamineList = dp.getDatas();
	    Date date = new Date();
	    String flag="";
	    for (int i=0;i<disexamineList.size();i++) {
	    	 DisexamineVO disexamineVO = new DisexamineVO();
	    	 disexamineVO = (DisexamineVO)disexamineList.get(i);
	    	 if (!disexamineVO.getExmnperiod().substring(0, 4).equals(new SimpleDateFormat("yyyy").format(date)) || Integer.parseInt(disexamineVO.getExmnperiod().substring(4))!= date.getMonth()+1  ) {
	    		  flag +=disexamineVO.getSeqid()+"��";
	    	 }else {
	    		 super.doDelete();
	    	 }
	    }
	    if (!("").equals(flag)) {
	    	  setActionMessage("ֻ��ɾ�����µĿ�����������");
	    }
	  
	    super.doList();
		return WEB_RESULT_LIST;
	}
	
	
}