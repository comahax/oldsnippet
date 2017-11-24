package com.sunrise.boss.web.fee.billing.checkprocess;

import java.util.ArrayList;
import java.util.List;

import com.sunrise.boss.business.common.dictitem.control.Dictitem;
import com.sunrise.boss.business.common.dictitem.control.DictitemBO;
import com.sunrise.boss.business.fee.billing.checkprocess.persistent.DictitemDTO;
import com.sunrise.boss.business.fee.billing.uapreq.persistent.UapReqDBParam;
import com.sunrise.boss.business.fee.billing.uapreq.persistent.UapReqVO;
import com.sunrise.jop.business.base.dictitem.DictitemDBParam;
import com.sunrise.jop.business.base.dictitem.DictitemVO;
import com.sunrise.jop.common.commoncontrol.CommonBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBConstant;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

public class CheckProcessAction extends BaseAction {

	public CheckProcessAction(){
		setClsVO(DictitemVO.class);
		this.pkNameArray = new String[] { "dictid","groupid" };
		setParam(new DictitemDBParam());
		
		setClsControl(Dictitem.class);
		setClsQueryParam(DictitemDBParam.class);
		setDbFlag(DBConstant.DB_FLAG_BILL);
	}
	
	public String doList() throws Exception {
		
		User user = (User)super.getDBAccessUser();
		
		DictitemDBParam param = (DictitemDBParam)super.getParam();
		
		Dictitem bo = (Dictitem)BOFactory.build(DictitemBO.class, user);
		
		param.set_se_groupid("IB_REQ_UAP");
		
		DataPackage dp = bo.doQuery(param, user);
		setDp(dp);
		
		List mp =  turnToMyPackage(dp,user);
		
		super.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, mp);
		
		return "list";
	}
	
	public void setUapInfo(UapReqDBParam param,User user, DictitemDTO dto) throws Exception
	{
		CommonBO bo = (CommonBO)BOFactory.build(CommonBO.class,user);
		bo.setVoClass(UapReqVO.class);
		param.set_desc("1");//降序
		param.set_ne_validbillcyc(String.valueOf(PublicUtils.getCurBillCyc()));
		DataPackage dp = bo.doQuery(param);
		if(dp == null || dp.getDatas() == null || dp.getDatas().size() == 0){
			dto.setState((short) 0);//无请求数据，默认未处理
			return;
		}
		UapReqVO uv = (UapReqVO)dp.getDatas().get(0);//获取最新的核查请求
		dto.setDeal_time(uv.getDeal_time());
		dto.setRemark(uv.getRemark());
		dto.setReq_time(uv.getReq_time());
		dto.setOperator(uv.getOperator());
		dto.setState(uv.getState());

	}
	
	public List turnToMyPackage(DataPackage dp,User user) throws Exception{

		List list = dp.getDatas();
		List array = new ArrayList();
		for(int i = 0; i < list.size();i++){
			DictitemVO dv = (DictitemVO)list.get(i);
			DictitemDTO dto = new DictitemDTO();
			BeanUtils.copyProperties(dto, dv);
			
			UapReqDBParam uapParam = new UapReqDBParam();
			uapParam.set_se_req_type(dv.getDictid());
			setUapInfo(uapParam,user,dto);
			
			array.add(dto);
		}
		list.clear();
		
		return array;
	}
}
