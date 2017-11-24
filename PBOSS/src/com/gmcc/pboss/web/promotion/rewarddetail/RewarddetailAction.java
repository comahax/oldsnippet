/**
 * auto-generated code
 * Fri Apr 09 10:08:16 CST 2010
 */
 package com.gmcc.pboss.web.promotion.rewarddetail;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.promotion.rewarddetail.RewarddetailVO ;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.sunrise.jop.ui.struts2.WebConstant;
import com.gmcc.pboss.business.promotion.rewarddetail.RewarddetailDBParam;
import com.gmcc.pboss.business.sales.disform.DisformDBParam;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.promotion.rewarddetail.Rewarddetail ;

/**
 * <p>Title: RewarddetailAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RewarddetailAction extends BaseAction{
	
	public RewarddetailAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new RewarddetailForm());
		this.setParam(new RewarddetailWebParam());

        //指定VO类
        setClsVO(RewarddetailVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"seqid"};
		this.setClsControl(Rewarddetail.class);
		this.setClsQueryParam(RewarddetailDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	@Override
	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("促销酬金列表");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "导出时间",
						format.format(new Date()) });
		export.addOutputProperty("seqid", "序号");
		export.addOutputProperty("creatingtime", "创建时间");
		export.addOutputProperty("pid", "方案标识");
		export.addOutputProperty("ruleid", "规则标识");
		export.addOutputProperty("wayid", "渠道代码", export.CODE2NAME, "#WAYIDINFO");
		export.addOutputProperty("calcmonth", "结算月份", export.DATE, "yyyyMM");
		export.addOutputProperty("comcategory", "商品种类", export.CODE2NAME,
				"$IM_FXCOMCATEGORY");
		export.addOutputProperty("stdamount", "酬金标准");
		export.addOutputProperty("amount", "金额");
		RewarddetailDBParam params = (RewarddetailDBParam)super.getParam();
		params.set_pagesize("0");
		super.setParam(params);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
}