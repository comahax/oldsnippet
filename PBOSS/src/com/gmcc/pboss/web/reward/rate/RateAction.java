package com.gmcc.pboss.web.reward.rate;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.reward.rate.RateDBParam;
import com.gmcc.pboss.business.reward.rate.RateDBParam;
import com.gmcc.pboss.business.reward.rate.RateVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.reward.rate.Rate;
import com.gmcc.pboss.control.reward.rate.RateBO;
import com.gmcc.pboss.control.reward.rate.Rate;
import com.gmcc.pboss.control.reward.rate.RateBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: RateAction </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public class RateAction extends BaseAction{
	
	public RateAction() {
		super();

		this.setForm(new RateForm());
		this.setParam(new RateDBParam());

        setClsVO(RateVO.class);
        this.pkNameArray=new String[]{"cityid"};
		this.setClsControl(Rate.class);
		this.setClsQueryParam(RateDBParam.class) ;

	}
	
	public String doList() throws Exception {
		HttpServletRequest request = getRequest();
		User user = (User) request.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
		Rate rate = (Rate) BOFactory.build(RateBO.class, getDBAccessUser());
		RateDBParam params = (RateDBParam)getParam();
		DataPackage dp = rate.doQuery(params);
		setDp(dp);
		return "list";
	}
	public String doDelete() throws Exception{
		String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
		Rate rate = (Rate) BOFactory.build(RateBO.class, getDBAccessUser());
		for (int i = 0; i < selectArray.length; i++) {
			//RateVO vo = rate.doFindByPk(getSelectedPK(selectArray[i]));
			rate.doRemoveByPK(getSelectedPK(selectArray[i]));
		}
		return doList();
	}
	
	public String doSave() throws Exception{
		RateForm rateForm = (RateForm) getForm();
		Rate rate = (Rate) BOFactory.build(RateBO.class, getDBAccessUser());
		
		
		// 判断收款单位名称唯一性
		RateVO vo = rate.doFindByPk(getSelectedPK(rateForm.getCityid()));
		if (vo != null) {
			BeanUtils.copyProperties(vo, rateForm);
			vo = rate.doUpdate(vo);
			BeanUtils.copyProperties(getForm(), vo);
		}else{
			RateVO rateVO = new RateVO();
			BeanUtils.copyProperties(rateVO, rateForm);
			rateVO = rate.doCreate(rateVO);
			BeanUtils.copyProperties(getForm(), rateVO);
		} 
		this.CMD = WEB_CMD_SAVE;
		setActionMessage("操作成功!");
		return "content";
	}
	
	public String doExportExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("税率");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间", format.format(new Date())});
		export.addOutputProperty("cityid", "地市");
		export.addOutputProperty("rate", "对私酬金代扣代缴税率");
		
		// 设置VO类
		export.voClassArray = new Class[] { RateVO.class };
		
		// 设置查询方法
		export.queryMethodName = "doList";
		RateDBParam params = (RateDBParam) getParam();
		params.setQueryAll(true);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
}