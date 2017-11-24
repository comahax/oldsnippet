package com.sunrise.boss.web.fee.monternet.ibdatabusiinfo;

import javax.servlet.http.HttpServletRequest;

import com.sunrise.boss.business.fee.monternet.ibdatabusiinfo.control.IbDataBusiinfo;
import com.sunrise.boss.business.fee.monternet.ibdatabusiinfo.control.IbDataBusiinfoBO;
import com.sunrise.boss.business.fee.monternet.ibdatabusiinfo.persistent.IbDataBusiinfoDBParam;
import com.sunrise.boss.business.fee.monternet.ibdatabusiinfo.persistent.IbDataBusiinfoVO;
import com.sunrise.jop.common.utils.i18n.Message;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBConstant;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: IbDataBusiinfoAction </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 赵武
 * @version 1.0
 */
public class IbDataBusiinfoAction extends BaseAction{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4782459073684239464L;
	
	private final static String RESPATH ="/com/sunrise/boss/web/fee/monternet/ibdatabusiinfo/IbDataBusiinfoAction_zh_CN.properties";

	public IbDataBusiinfoAction() {
		super();

		this.setForm(new IbDataBusiinfoForm());
		this.setParam(new IbDataBusiinfoDBParam());

        setClsVO(IbDataBusiinfoVO.class);
        this.pkNameArray=new String[]{"billcycle","chargingtype","filetype","opCode","port","spCode"};
		this.setClsControl(IbDataBusiinfo.class);
		this.setClsQueryParam(IbDataBusiinfoDBParam.class) ;
		setDbFlag(DBConstant.DB_FLAG_BILL);
	}
	
	public String doList() throws Exception {
		User user = (User)super.getDBAccessUser();
		
		IbDataBusiinfoDBParam param = (IbDataBusiinfoDBParam)super.getParam();
		param.set_pagesize("20");
		IbDataBusiinfoBO urb = (IbDataBusiinfoBO)BOFactory.build(IbDataBusiinfoBO.class, user);
		DataPackage dp = urb.doQuery(param);
		setDp(dp);
		this.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		
		return "list";
	}
	
	public String doExcel() throws Exception{
		User user = (User)getDBAccessUser();
		
		HttpServletRequest request = super.getRequest();
		IbDataBusiinfoDBParam param = (IbDataBusiinfoDBParam)super.getParam();
		ExcelOutIbDataBusiinfo export = new ExcelOutIbDataBusiinfo(user,param.getPropertys().split(","));
		
		export.setFileName(Message.getString(RESPATH, "titleList"));
		
		request.setAttribute("creator", export);
		request.setAttribute("LISTVO", param);
		request.setAttribute("queryVO", request);
		
		return "excelout";
	}
}