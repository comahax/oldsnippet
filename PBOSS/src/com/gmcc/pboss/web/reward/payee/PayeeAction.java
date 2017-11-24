package com.gmcc.pboss.web.reward.payee;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.reward.payee.PayeeDBParam;
import com.gmcc.pboss.business.reward.payee.PayeeVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.reward.payee.Payee;
import com.gmcc.pboss.control.reward.payee.PayeeBO;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: PayeeAction </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public class PayeeAction extends BaseAction{
	
	public PayeeAction() {
		super();

		this.setForm(new PayeeForm());
		this.setParam(new PayeeDBParam());

        setClsVO(PayeeVO.class);
        this.pkNameArray=new String[]{"seq"};
		this.setClsControl(Payee.class);
		this.setClsQueryParam(PayeeDBParam.class) ;

	}
	
	public String doList() throws Exception {
		//HttpServletRequest request = getRequest();
		//User user = (User) request.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
		Payee payee = (Payee) BOFactory.build(PayeeBO.class, getDBAccessUser());
		PayeeDBParam params = (PayeeDBParam)getParam();
		// 清除输入收款单位的空格
		String skPayee = params.get_sk_payee();
		if(StringUtils.isNotEmpty(skPayee)){
			params.set_sk_payee(skPayee.trim());
		}		
		
		params.set_se_cityid(getDBAccessUser().getCityid());
		DataPackage dp = payee.doQuery(params);
		setDp(dp);
		return "list";
	}
	
	public String doDelete() throws Exception{
		String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
		Payee payee = (Payee) BOFactory.build(PayeeBO.class, getDBAccessUser());
		for (int i = 0; i < selectArray.length; i++) {
			//PayeeVO vo = payee.doFindByPk(getSelectedPK(selectArray[i]));
			payee.doRemoveByPK(getSelectedPK(selectArray[i]));
		}
		return doList();
	}
	
	public String doSave() throws Exception{
		PayeeForm payeeForm = (PayeeForm) getForm();
		Payee payee = (Payee) BOFactory.build(PayeeBO.class, getDBAccessUser());
		
		// 判断收款单位名称唯一性
		PayeeDBParam params =new PayeeDBParam();
		params.set_se_cityid(getDBAccessUser().getCityid());
		params.set_se_payee(payeeForm.getPayee()) ;
		DataPackage dp = payee.doQuery(params);
		if (dp.getDatas().size()>0 && !CMD.equals("EDIT")) {
			super.addActionError("【" + payeeForm.getPayee() + "】已存在该收款单位名称");
			return "content";
		}
		
		if (CMD.equals("NEW")) {
			PayeeVO payeeVO = new PayeeVO();
			BeanUtils.copyProperties(payeeVO, payeeForm);
			payeeVO.setCityid(getDBAccessUser().getCityid());
			payeeVO = payee.doCreate(payeeVO);
			BeanUtils.copyProperties(getForm(), payeeVO);
		} else if (CMD.equals("EDIT")) {
			PayeeVO vo = payee.doFindByPk(payeeForm.getSeq());
			BeanUtils.copyProperties(vo, payeeForm);
			vo.setCityid(getDBAccessUser().getCityid());
			vo = payee.doUpdate(vo);
			BeanUtils.copyProperties(getForm(), vo);
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
		export.setFileName("收款单位资料");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间", format.format(new Date())});
		export.addOutputProperty("payee", "收款单位");
		export.addOutputProperty("pubpri", "对公/对私");
		
		// 设置VO类
		export.voClassArray = new Class[] { PayeeVO.class };
		
		// 设置查询方法
		export.queryMethodName = "doList";
		PayeeDBParam params = (PayeeDBParam) getParam();
		params.setQueryAll(true);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
//	public String doEdit() throws Exception {
//		HttpServletRequest request = getRequest();
//		User user = (User) request.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
//		String payeeid = request.getParameter("param._pk");
//		payeeid = new String(payeeid.getBytes("iso8859-1"),"GBK");
//		 
//		PayeeForm payeeForm = (PayeeForm) getForm();
//		Payee payee = (Payee) BOFactory.build(PayeeBO.class, getDBAccessUser());
//		PayeeVO payeeVO = (PayeeVO) payee.doFindByPk(payeeid);
//
//		BeanUtils.copyProperties(payeeForm, payeeVO);
//	
//			this.CMD = WEB_CMD_EDIT;
//			return "content";
//	}
}