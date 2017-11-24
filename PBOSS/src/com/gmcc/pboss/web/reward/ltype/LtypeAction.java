package com.gmcc.pboss.web.reward.ltype;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.ClassUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.reward.ltype.LtypeDBParam;
import com.gmcc.pboss.business.reward.ltype.LtypeVO;
import com.gmcc.pboss.business.reward.rate.RateVO;
import com.gmcc.pboss.business.reward.stype.StypeDBParam;
import com.gmcc.pboss.business.reward.stype.StypeVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.reward.ltype.Ltype;
import com.gmcc.pboss.control.reward.ltype.LtypeBO;
import com.gmcc.pboss.control.reward.rate.Rate;
import com.gmcc.pboss.control.reward.rate.RateBO;
import com.gmcc.pboss.control.reward.stype.Stype;
import com.gmcc.pboss.control.reward.stype.StypeBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.exception.system.ActionException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: LtypeAction </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public class LtypeAction extends BaseAction{
	
	public LtypeAction() {
		super();

		this.setForm(new LtypeForm());
		this.setParam(new LtypeDBParam());

        setClsVO(LtypeVO.class);
        this.pkNameArray=new String[]{"seq"};
		this.setClsControl(Ltype.class);
		this.setClsQueryParam(LtypeDBParam.class) ;

	}
	public String doList() throws Exception {
		HttpServletRequest request = getRequest();
		User user = (User) request.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
		Ltype ltype = (Ltype) BOFactory.build(LtypeBO.class, getDBAccessUser());
		LtypeDBParam params = (LtypeDBParam)getParam();
		DataPackage dp = ltype.doQueryBySql(params);
		setDp(dp);
		return "list";
	}
}