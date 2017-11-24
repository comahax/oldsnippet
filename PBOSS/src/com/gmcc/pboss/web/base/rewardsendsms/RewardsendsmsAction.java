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

		//以下几个方法是必须的
		this.setForm(new RewardsendsmsForm());
		this.setParam(new RewardsendsmsDBParam());

        //指定VO类
        setClsVO(RewardsendsmsVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"seqid"};
		this.setClsControl(Rewardsendsms.class);
		this.setClsQueryParam(RewardsendsmsDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
private String has_right;//省公司、市公司令牌权限
	
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
	
	//查询
	public String doList() throws Exception{
		
		RewardsendsmsDBParam rewardsendsmsDBParam = (RewardsendsmsDBParam)getParam();  
		DBAccessUser user = this.getDBAccessUser(); 
		rewardsendsmsDBParam.set_se_cityid(user.getCityid());
		Rewardsendsms rewardsendsms = (Rewardsendsms) BOFactory.build(RewardsendsmsBO.class, user);
		DataPackage dP = rewardsendsms.doQuery(rewardsendsmsDBParam);
		this.setDp(dP); 
		return WEB_RESULT_LIST;
	}

	//保存
	public String doSave() throws Exception {  
		RewardsendsmsForm form = (RewardsendsmsForm) getForm();
		DBAccessUser user = this.getDBAccessUser();
		form.setCityid(user.getCityid());
		form.setCreatetime(new Date()); 
		super.doSave();
		return WEB_RESULT_CONTENT;
	}
	
	//新增
	public String doNew() throws Exception{ 
		this.CMD = WEB_CMD_NEW;
		return WEB_RESULT_CONTENT;
	};
	
	 //删除
	public String doDelete() throws Exception{
		String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
		Rewardsendsms rewardsendsms = (Rewardsendsms) BOFactory.build(RewardsendsmsBO.class, getDBAccessUser());
		for (int i = 0; i < selectArray.length; i++) { 
			rewardsendsms.doRemoveByPK(selectArray[i]);
		}
		return doList();
	}
	
 
	//导出
	public String doExportExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("出酬短信通知信息资料录入");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间", format.format(new Date())});
		export.addOutputProperty("cityid", "地市公司", CommonExportBean.CODE2NAME, "#CITYCOMPANY");  
		export.addOutputProperty("sendtel", "酬金负责人号码");
		export.addOutputProperty("type", "出酬酬金类型", CommonExportBean.CODE2NAME, "$CH_REWARDSMSTYPE");
		export.addOutputProperty("createtime", "创建时间",export.DATE,"yyyy-MM-dd" );
		
		// 设置VO类
		export.voClassArray = new Class[] { RewardsendsmsVO.class };
		
		// 设置查询方法
		export.queryMethodName = "doList";
		RewardsendsmsDBParam params = (RewardsendsmsDBParam) getParam();
		params.setQueryAll(true);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}