package com.sunrise.boss.web.fee.billing.uapreq;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sunrise.boss.business.fee.billing.billstatus.persistent.BillStatusDBParam;
import com.sunrise.boss.business.fee.billing.billstatus.persistent.BillStatusVO;
import com.sunrise.boss.business.fee.billing.uapreq.control.UapReq;
import com.sunrise.boss.business.fee.billing.uapreq.control.UapReqBO;
import com.sunrise.boss.business.fee.billing.uapreq.persistent.UapReqDBParam;
import com.sunrise.boss.business.fee.billing.uapreq.persistent.UapReqVO;
import com.sunrise.boss.business.fee.billing.uapreq.persistent.UapRuDownloadDBParam;
import com.sunrise.boss.business.fee.billing.uapreq.persistent.UapRuDownloadVO;
import com.sunrise.jop.business.base.dictitem.DictitemDBParam;
import com.sunrise.jop.business.base.dictitem.DictitemVO;
import com.sunrise.jop.common.commoncontrol.CommonBO;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBConstant;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

public class UapReqFileAction extends BaseAction 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2343786997579077459L;

	public UapReqFileAction(){
		setForm(new UapReqForm());
	    setParam(new UapReqDBParam());

	    setClsVO(UapReqVO.class);

	    this.pkNameArray = new String[] { "logid" };
	    setClsControl(UapReq.class);
	    setClsQueryParam(UapReqDBParam.class);
	    setDbFlag(DBConstant.DB_FLAG_BILL);
	}
	
	public String doList() throws Exception 
	{
		User user = (User)super.getDBAccessUser();
		
		UapReqDBParam param = (UapReqDBParam)super.getParam();
		DataPackage dpFile = getFileTypeExUp(user, "_1");//文件下载
		param.set_sin_req_type(analyseFileType(dpFile.getDatas()));
		param.set_orderby("logid");
		param.set_desc("1");
		
		UapReqBO urb = (UapReqBO)BOFactory.build(UapReqBO.class, user);
		DataPackage dp = urb.doQuery(param);
		setDp(dp);
		this.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		
		return "list";
	}
	
	public String doSave() throws Exception 
	{
		User user = (User)super.getDBAccessUser();
		
		UapReqForm uf = (UapReqForm)super.getForm();
		
		DBQueryParam param = (DBQueryParam)super.getParam();
		UapReqBO urb = (UapReqBO)BOFactory.build(UapReqBO.class, user);
		
		CommonBO bo = (CommonBO)BOFactory.build(CommonBO.class,user);
		long batch = bo.getSequence("IB_REQ_UAP_BATCH_SEQ");
		String []  selectItem = param.get_selectitem();
		for(String type : selectItem){
			UapReqVO arv = new UapReqVO();
			arv.setReq_type(type);
			arv.setValidbillcyc(new Long(uf.getValidbillcyc()));
			arv.setState(new Short("0"));
			arv.setBatch(batch);
			arv.setReq_time(new Date(System.currentTimeMillis()));
			arv.setOperator(user.getOprcode());
			arv.setRegion(Integer.parseInt(user.getCityid()));
			urb.doCreate(arv);
		}
		this.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_SUCCEED, "SUCCEED");
		setActionMessage("发起请求成功!");
		
		//因为文件类型是读请求表,所以返回content页面时需再次查询
		//DataPackage dp = getFileType(user,"_1");
		//super.getRequest().setAttribute("LIST", dp);
		
		return doList();
	}
	
	public String doUpdate() throws Exception 
	{
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
	
	public String doUpdate1() throws Exception 
	{
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
		
		return doList1();

	}
	
	public String doNew() throws Exception 
	{
		User user = (User)super.getDBAccessUser();
		UapReqForm form = (UapReqForm)super.getForm();
		String validbillcyc = (String)super.getRequest().getParameter("validbillcyc");
		if (validbillcyc == null) {
			validbillcyc = PublicUtils.formatUtilDate(new Date(),"yyyyMM00");	
		}
		form.setValidbillcyc(new Long(validbillcyc));
		
		String A101 = queryStatus(validbillcyc, "A101", user);
		String A102 = queryStatus(validbillcyc, "A102", user);
		String A103 = queryStatus(validbillcyc, "A103", user);
		String A104 = queryStatus(validbillcyc, "A104", user);
		String A105 = queryStatus(validbillcyc, "A105", user);
		
		DataPackage fixfee = getFileType(user,"11__","FIXFEE"); //固定费
		DataPackage acculate = getFileType(user,"31__","ACCULATE"); //通信费
		DataPackage accounting = getFileType(user,"41__","ACCOUNTING"); //合账
		DataPackage frefee = getFileType(user,"8101","PREFEE"); //预付费低销
		
		super.getRequest().setAttribute("FIXFEE", fixfee);
		super.getRequest().setAttribute("ACCULATE", acculate);
		super.getRequest().setAttribute("ACCOUNTING", accounting);
		super.getRequest().setAttribute("PREFEE", frefee);
		
		super.getRequest().setAttribute("status_A101", A101); //月初预出
		super.getRequest().setAttribute("status_A102", A102); //月中预出
		super.getRequest().setAttribute("status_A103", A103); //24号预跑
		super.getRequest().setAttribute("status_A104", A104); //月底全量
		super.getRequest().setAttribute("status_A105", A105); //月底增量
		
		return "content";
	}
	public String doView() throws Exception{
		return "content1";
	}
	
	public String doList1() throws Exception 
	{
		User user = (User)super.getDBAccessUser();
		
		UapReqDBParam param = (UapReqDBParam)super.getParam();
		DataPackage dpFile = getFileType(user, "_2");//统计分析
		param.set_sin_req_type(analyseFileType(dpFile.getDatas()));
		param.set_orderby("logid");
		param.set_desc("1");
		
		UapReqBO urb = (UapReqBO)BOFactory.build(UapReqBO.class, user);
		DataPackage dp = urb.doQuery(param);
		setDp(dp);
		this.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		
		return "list1";
	}
	
	public String listUpload() throws Exception {
		User user = (User)super.getDBAccessUser();
		
		UapReqDBParam param = (UapReqDBParam)super.getParam();
		DataPackage dpFile = getFileType(user, "8102");//文件上传
		param.set_sin_req_type(analyseFileType(dpFile.getDatas()));
		param.set_orderby("logid");
		param.set_desc("1");
		
		UapReqBO urb = (UapReqBO)BOFactory.build(UapReqBO.class, user);
		DataPackage dp = urb.doQuery(param);
		setDp(dp);
		this.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		
		return "listUpload";
	}
	
	public String newUpload() throws Exception {
		User user = (User)super.getDBAccessUser();
		UapReqForm form = (UapReqForm)super.getForm();
		String validbillcyc = (String)super.getRequest().getParameter("validbillcyc");
		if (validbillcyc == null) {
			validbillcyc = PublicUtils.formatUtilDate(new Date(),"yyyyMM00");	
		}
		form.setValidbillcyc(new Long(validbillcyc));
		
		String A101 = queryStatus(validbillcyc, "A101", user);
		String A102 = queryStatus(validbillcyc, "A102", user);
		String A103 = queryStatus(validbillcyc, "A103", user);
		String A104 = queryStatus(validbillcyc, "A104", user);
		String A105 = queryStatus(validbillcyc, "A105", user);
		
		//DataPackage fixfee = getFileType(user,"11__","FIXFEE"); //固定费
		//DataPackage acculate = getFileType(user,"31__","ACCULATE"); //通信费
		//DataPackage accounting = getFileType(user,"41__","ACCOUNTING"); //合账
		DataPackage frefee = getFileType(user,"8102","PREFEE"); //预付费低销
		
		//super.getRequest().setAttribute("FIXFEE", fixfee);
		//super.getRequest().setAttribute("ACCULATE", acculate);
		//super.getRequest().setAttribute("ACCOUNTING", accounting);
		super.getRequest().setAttribute("PREFEE", frefee);
		
		super.getRequest().setAttribute("status_A101", A101); //月初预出
		super.getRequest().setAttribute("status_A102", A102); //月中预出
		super.getRequest().setAttribute("status_A103", A103); //24号预跑
		super.getRequest().setAttribute("status_A104", A104); //月底全量
		super.getRequest().setAttribute("status_A105", A105); //月底增量
		
		return "contentUpload";
	}
	
	public String saveReqAndRu() throws Exception {
		User user = (User)super.getDBAccessUser();
		
		UapReqForm uf = (UapReqForm)super.getForm();
		
		DBQueryParam param = (DBQueryParam)super.getParam();
		UapReqBO urb = (UapReqBO)BOFactory.build(UapReqBO.class, user);
		
		CommonBO bo = (CommonBO)BOFactory.build(CommonBO.class,user);
		long batch = bo.getSequence("IB_REQ_UAP_BATCH_SEQ");
		String []  selectItem = param.get_selectitem();
		
		UapReqVO arv = new UapReqVO();
		arv.setReq_type(selectItem[0]);
		arv.setValidbillcyc(new Long(uf.getValidbillcyc()));
		arv.setState(new Short("0"));
		arv.setBatch(batch);
		arv.setReq_time(new Date(System.currentTimeMillis()));
		arv.setOperator(user.getOprcode());
		arv.setRegion(Integer.parseInt(user.getCityid()));
		
		this.getRequest().getParameter("ruleId");
		UapRuDownloadVO uapRuDownloadVO = new UapRuDownloadVO();
		uapRuDownloadVO.setRuleId(this.getRequest().getParameter("ruleId"));
		uapRuDownloadVO.setSrcPath(this.getRequest().getParameter("uploadfile"));
		
		urb.doSaveReqAndRu(arv, uapRuDownloadVO);
		
		this.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_SUCCEED, "SUCCEED");
		setActionMessage("发起请求成功!");
		
		//因为文件类型是读请求表,所以返回content页面时需再次查询
		//DataPackage dp = getFileType(user,"_1");
		//super.getRequest().setAttribute("LIST", dp);
		
		return listUpload();
	}
	
	public String loadUploadPath() throws Exception {
		User user = (User)super.getDBAccessUser();
		
		UapRuDownloadDBParam param = new UapRuDownloadDBParam();
		param.set_se_req_ruleId("8102");
		
		UapReqBO urb = (UapReqBO)BOFactory.build(UapReqBO.class, user);
		UapRuDownloadVO uapRuDownloadVO = urb.getUploadPath(param);
		this.renderText(uapRuDownloadVO.getRuleId()+";;"+uapRuDownloadVO.getSrcPath());
		
		return null;
	}
	
	public String updateReq() throws Exception 
	{
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
		
		return listUpload();

	}
	
	public String doSave1() throws Exception
	{
		User user = (User)super.getDBAccessUser();
		
		UapReqForm uf = (UapReqForm)super.getForm();
		UapReqDBParam param = (UapReqDBParam)super.getParam();
		String [] paramArray = param.get_selectitem();
		String [] paramArray2 = param.get_selectitem2();
		uf.set_selectitem(paramArray);
		uf.set_selectitem2(paramArray2);
		setValue(uf);
		
		UapReqVO arv = new UapReqVO();
		arv.setReq_type(uf.getReq_type());
		arv.setValidbillcyc(new Long(uf.getValidbillcyc()));
		arv.setState(new Short("0"));
		
		CommonBO bo = (CommonBO)BOFactory.build(CommonBO.class,user);
		arv.setBatch(bo.getSequence("IB_REQ_UAP_BATCH_SEQ"));
		arv.setReq_time(new Date(System.currentTimeMillis()));
		arv.setOperator(user.getOprcode());
		arv.setParam(genParam(uf));
		arv.setRemark(uf.getRemark());
		arv.setRegion(Integer.parseInt(user.getCityid()));
		
		UapReqBO urb = (UapReqBO)BOFactory.build(UapReqBO.class, user);
		urb.doCreate(arv);
		
		this.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_SUCCEED, "SUCCEED");
		setActionMessage("发送请求成功!");
		
		return doList1();
	}
	
	public String genParam(UapReqForm uf)
	{
		StringBuffer param = new StringBuffer("TJ:");
		param.append(uf.getStatisticmark() == null ? 0 : 1);
		param.append("|");
		param.append("FX:");
		param.append(uf.getAnalysemark() == null ? 0 : 1);
		param.append("|");
		param.append("COMPVALIDBILLCYC:");
		param.append(uf.getCompvalidbillcyc());
		System.out.println("param:" + param);
		return param.toString();
	}

	public void setValue(UapReqForm uf){
		String [] array = uf.get_selectitem();
		String [] array2 = uf.get_selectitem2();
		if(array != null){
			if("true".equals(array[0])){
				uf.setStatisticmark("1");
			}else{
				uf.setStatisticmark("0");
			}
		}
		if(array2 != null){
			if("true".equals(array2[0])){
				uf.setAnalysemark("1");
			}else{
				uf.setAnalysemark("0");
			}
		}

	}
	
	public DataPackage getFileType(User user,String dictid) throws Exception {
		DictitemDBParam param = new DictitemDBParam();
		param.set_se_groupid("IB_REQ_UAP");
		param.set_ssw_dictid(dictid);
		param.set_pagesize("0");
		param.set_orderby("sortorder");
		
		CommonBO bo = (CommonBO)BOFactory.build(CommonBO.class, user);
		bo.setVoClass(DictitemVO.class);
		DataPackage dp = bo.doQuery(param);
		
		return dp;
	}
	
	public DataPackage getFileTypeExUp(User user,String dictid) throws Exception {
		DictitemDBParam param = new DictitemDBParam();
		param.set_se_groupid("IB_REQ_UAP");
		param.set_ssw_dictid(dictid);
		param.set_sne_dictid("8102");
		param.set_pagesize("0");
		param.set_orderby("sortorder");
		
		CommonBO bo = (CommonBO)BOFactory.build(CommonBO.class, user);
		bo.setVoClass(DictitemVO.class);
		DataPackage dp = bo.doQuery(param);
		
		return dp;
	}
	
	// 分模块
	public DataPackage getFileType(User user,String dictid,String description) throws Exception {
		DictitemDBParam param = new DictitemDBParam();
		param.set_se_groupid("IB_REQ_UAP");
		param.set_ssw_dictid(dictid);
		param.set_se_description(description);
		param.set_pagesize("0");
		param.set_orderby("sortorder");
		
		CommonBO bo = (CommonBO)BOFactory.build(CommonBO.class, user);
		bo.setVoClass(DictitemVO.class);
		DataPackage dp = bo.doQuery(param);
		
		return dp;
	}
	
	public List<String> analyseFileType(List<DictitemVO> list){
		List<String> ls = new ArrayList<String>();
		for(DictitemVO vo : list){
			System.out.println("===="+vo.getDictid()+"======");
			ls.add(vo.getDictid());
		}
		return ls;
	}
	
	public String queryStatus(String validbillcyc, String phase, User user) {
		String status = "";
		try {
			BillStatusDBParam param = new BillStatusDBParam();
			param.set_ne_validbillcyc(validbillcyc);
			param.set_ne_subphase("0");
			param.set_se_phase(phase);
			param.set_ne_region(user.getCityid());
			
			CommonBO bo = (CommonBO)BOFactory.build(CommonBO.class, user);
			bo.setVoClass(BillStatusVO.class);
			DataPackage dp = bo.doQuery(param);
			if(dp != null && dp.getDatas() != null && dp.getDatas().size() > 0) {
				BillStatusVO vo = (BillStatusVO)dp.toList(BillStatusVO.class).get(0);
				status = vo.getState() == null ? "" : vo.getState().toString();
			}
			
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return  status;
	}
}
