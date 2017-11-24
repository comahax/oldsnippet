/**
 * auto-generated code
 * Thu Apr 10 14:34:42 CST 2014
 */
 package com.gmcc.pboss.web.base.rewardsendsms;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.gmcc.pboss.business.base.rewardsendsms.RewardsendsmsVO ;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.sunrise.jop.ui.struts2.WebConstant;
import com.gmcc.pboss.business.base.rewardsendsms.RewardsendsmsDBParam;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.base.operright.Operright;
import com.gmcc.pboss.control.base.operright.OperrightBO;
import com.gmcc.pboss.control.base.rewardsendsms.Rewardsendsms ;
import com.gmcc.pboss.control.base.rewardsendsms.RewardsendsmsBO;

/**
 * <p>Title: RewardsendsmsAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RewardsendsmsAction extends BaseAction{
	
	public RewardsendsmsAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new RewardsendsmsForm());
		this.setParam(new RewardsendsmsDBParam());

        //ָ��VO��
        setClsVO(RewardsendsmsVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"seqid"};
		this.setClsControl(Rewardsendsms.class);
		this.setClsQueryParam(RewardsendsmsDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
private String has_right;//ʡ��˾���й�˾����Ȩ��
	
	public String getHas_right() throws Exception{
		Operright operright = (Operright) BOFactory.build(OperrightBO.class, DBAccessUser.getInnerUser());
		boolean right_pro = operright.doCheckPermission(getDBAccessUser().getOprcode(), "CH_BUSICIRCLE_PRO");
		
		boolean right_city = operright.doCheckPermission(getDBAccessUser().getOprcode(), "CH_BUSICIRCLE_CITY");
		
		if(right_pro || right_city){
			has_right = "true";
		}else{
			has_right = "false";
		}
		
		return has_right;
	}

	public void setHas_right(String has_right) {
		this.has_right = has_right;
	}
	
	//��ѯ
	public String doList() throws Exception{
		
		RewardsendsmsDBParam rewardsendsmsDBParam = (RewardsendsmsDBParam)getParam();  
		DBAccessUser user = this.getDBAccessUser(); 
		rewardsendsmsDBParam.set_se_cityid(user.getCityid());
		Rewardsendsms rewardsendsms = (Rewardsendsms) BOFactory.build(RewardsendsmsBO.class, user);
		DataPackage dP = rewardsendsms.doQuery(rewardsendsmsDBParam);
		this.setDp(dP); 
		return WEB_RESULT_LIST;
	}

	//����
	public String doSave() throws Exception {  
		RewardsendsmsForm form = (RewardsendsmsForm) getForm();
		DBAccessUser user = this.getDBAccessUser();
		form.setCityid(user.getCityid());
		form.setCreatetime(new Date()); 
		super.doSave();
		return WEB_RESULT_CONTENT;
	}
	
	//����
	public String doNew() throws Exception{ 
		this.CMD = WEB_CMD_NEW;
		return WEB_RESULT_CONTENT;
	};
	
	 //ɾ��
	public String doDelete() throws Exception{
		String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
		Rewardsendsms rewardsendsms = (Rewardsendsms) BOFactory.build(RewardsendsmsBO.class, getDBAccessUser());
		for (int i = 0; i < selectArray.length; i++) { 
			rewardsendsms.doRemoveByPK(selectArray[i]);
		}
		return doList();
	}
	
 
	//����
	public String doExportExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�������֪ͨ��Ϣ����¼��");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export.appendHeadLine(new String[] { "����ʱ��", format.format(new Date())});
		export.addOutputProperty("cityid", "���й�˾", CommonExportBean.CODE2NAME, "#CITYCOMPANY");  
		export.addOutputProperty("sendtel", "������˺���");
		export.addOutputProperty("type", "����������", CommonExportBean.CODE2NAME, "$CH_REWARDSMSTYPE");
		export.addOutputProperty("createtime", "����ʱ��",export.DATE,"yyyy-MM-dd" );
		
		// ����VO��
		export.voClassArray = new Class[] { RewardsendsmsVO.class };
		
		// ���ò�ѯ����
		export.queryMethodName = "doList";
		RewardsendsmsDBParam params = (RewardsendsmsDBParam) getParam();
		params.setQueryAll(true);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}