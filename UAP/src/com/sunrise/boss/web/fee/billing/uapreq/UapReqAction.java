package com.sunrise.boss.web.fee.billing.uapreq;

import java.util.Date;

import com.sunrise.boss.business.fee.billing.uapreq.control.UapReq;
import com.sunrise.boss.business.fee.billing.uapreq.control.UapReqBO;
import com.sunrise.boss.business.fee.billing.uapreq.persistent.UapReqDBParam;
import com.sunrise.boss.business.fee.billing.uapreq.persistent.UapReqVO;
import com.sunrise.boss.web.common.batch.upload.BatchResultForm;
import com.sunrise.boss.web.common.batch.upload.UploadFileAction;
import com.sunrise.jop.common.commoncontrol.CommonBO;
import com.sunrise.jop.common.commoncontrol.CommonControl;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.db.DBConstant;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.ui.User;

public class UapReqAction extends UploadFileAction {

	public UapReqAction() {	
		setForm(new UapReqForm());
	    setParam(new UapReqDBParam());
	    setClsVO(UapReqVO.class);

	    this.pkNameArray = new String[] { "logid" };
	    setClsControl(UapReq.class);
	    setClsQueryParam(UapReqDBParam.class);
	    
	    String target = getRequest().getParameter("target");
	    if(target == null || target.equals("")){
	    	target = "GR";
	    }
	    if("JT".equals(target)) {
	    	setDbFlag(DBConstant.DB_FLAG_GDIB); //集团菜单
	    	getRequest().setAttribute("target",target);	
	    }else {
	    	setDbFlag(DBConstant.DB_FLAG_IB); //节点菜单
	    	getRequest().setAttribute("target",target);	
	    }
	    
	}
	
	public String doList() throws Exception{
		UapReqDBParam param = (UapReqDBParam)super.getParam();
		param.set_orderby("logid");
		param.set_desc("1");
		return super.doList();
	}
	

	public String doSave() throws Exception{
		User user = (User)getDBAccessUser();
		UapReqForm form = (UapReqForm)getForm();
		CommonControl bo = (CommonControl)BOFactory.build(CommonBO.class, user);
		form.setBatch(bo.getSequence("IB_REQ_UAP_BATCH_SEQ"));
		form.setRegion(new Integer(user.getCityid()));
		form.setReq_time(new Date());
		form.setState(new Short("0"));
		form.setOperator(user.getOprcode());
		form.setValidbillcyc(PublicUtils.getCurBillCyc());
		
		UapReqVO vo = new UapReqVO();
		BeanUtils.copyProperties(vo, form);
	    if(form.getParam().equals("FILE")) {
	    	String filename = getFilename();
	    	if(filename!=null || !filename.equals("")) {
	    		UapReq reqbo = (UapReq)BOFactory.build(UapReqBO.class, user);
	    		if(form.getReq_type().equals("1001") 
	    				|| form.getReq_type().equals("1002")
	    				|| form.getReq_type().equals("1004")){
	    			try {
	    				reqbo.doSaveFixfeeReq(vo, filename);
	    				CMD = WEB_CMD_SAVE;
	    				this.setActionMessage("发起请求成功！");
	    			} catch (Exception e){
	    				this.setActionMessage(e.getMessage());
	    			}
	    			
	    		}
	    		if(form.getReq_type().equals("1003")){
	    			try {
	    				reqbo.doSaveProdReq(vo, filename);
	    				CMD = WEB_CMD_SAVE;
	    				this.setActionMessage("发起请求成功！");
	    			} catch (Exception e){
	    				this.setActionMessage(e.getMessage());
	    			}
	    			
	    		}
	    	}
	    }else {
	    	super.doSave();
	    	this.setActionMessage("发起请求成功！");
	    }
	    
	    return doList();
	
	}
	
	public String doUploadNumber() throws Exception{
		UapReqForm form = (UapReqForm)this.getForm();
		return "uploadNumber";
	}
	
	public String doUploadProd() throws Exception{
		UapReqForm form = (UapReqForm)this.getForm();
		return "uploadProd";
	}
	/**
	 * TXT格式批量上传
	 * @return String
	 */
	public String doUpNumber() throws Exception {
		setCheckFormat(new NumberCheck()); //文件检查类
		BatchResultForm result = checkFile();//检查文件数据
		if(result!=null){
			getRequest().setAttribute("infile", result.getInFile());
			getRequest().setAttribute("filename", result.getFileName());
			getRequest().setAttribute("filedatas", result.getTotal());
		}
	
		return "uploadNumber";
		
	}
	
	public String doUpProd() throws Exception {
		setCheckFormat(new ProdCheck()); //文件检查类
		BatchResultForm result = checkFile();//检查文件数据
		if(result!=null){
			getRequest().setAttribute("infile", result.getInFile());
			getRequest().setAttribute("filename", result.getFileName());
			getRequest().setAttribute("filedatas", result.getTotal());
		}
		
		return "uploadProd";
	}
	
	public String doDeny() throws Exception {
		UapReqDBParam param = (UapReqDBParam)super.getParam();
		
		UapReqBO bo = (UapReqBO)BOFactory.build(UapReqBO.class, getDBAccessUser());
		
		String [] selectItem = param.get_selectitem();
		String succeedid = "";
		String failedid = "";
		for(String logid : selectItem){
			UapReqVO urVO = bo.doFindByPk(new Long(logid));
			if(urVO.getState() != 0) {  //为0-待处理 才可以作废
				failedid += "," + logid;
				continue;
			}
			urVO.setState(new Short("-1"));
			urVO.setDeal_time(new Date());
			bo.doUpdate(urVO);
			succeedid += "," + logid;
		}
		if(!"".equals(failedid)) addActionError("该记录状态不可作废："+failedid.substring(1));
		if(!"".equals(succeedid)) setActionMessage("作废成功："+succeedid.substring(1));
		return doList();
	}
}
