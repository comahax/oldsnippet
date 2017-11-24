/**
 * auto-generated code
 * Tue Jul 12 17:07:47 CST 2011
 */
 package com.gmcc.pboss.web.channel.wayrechargeno;

import java.util.Date;

import com.gmcc.pboss.business.channel.nosect.NosectDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.channel.wayrechargeno.WayrechargenoVO ;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.wayrechargeno.WayrechargenoDBParam;
import com.gmcc.pboss.business.sales.bankshop.BankshopDBParam;
import com.gmcc.pboss.control.channel.nosect.Nosect;
import com.gmcc.pboss.control.channel.nosect.NosectBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.channel.wayrechargeno.Wayrechargeno ;
import com.gmcc.pboss.control.channel.wayrechargeno.WayrechargenoBO;

/**
 * <p>Title: WayrechargenoAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class WayrechargenoAction extends BaseAction{
	
	public WayrechargenoAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new WayrechargenoForm());
		this.setParam(new WayrechargenoDBParam());

        //指定VO类
        setClsVO(WayrechargenoVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"seq"};
		this.setClsControl(Wayrechargeno.class);
		this.setClsQueryParam(WayrechargenoDBParam.class) ;

	}
	
	@Override
	public String doList() throws Exception {
		WayrechargenoDBParam param=(WayrechargenoDBParam) getParam();;
//		param.set_ne_cityid(getDBAccessUser().getCityid());
//		param.set_ne_cityid(CityMappingUtil.getCityNo(getDBAccessUser().getCityid()));
		param.set_se_cityid(CityMappingUtil.getCityNo(getDBAccessUser().getCityid()));
//		DBQueryParam dd=getParam().;
		return super.doList();
	}
	
	public String doSave() throws Exception {
		
		try {
			
			WayrechargenoBO bo=(WayrechargenoBO)BOFactory.build(WayrechargenoBO.class,getDBAccessUser());
			WayrechargenoForm form=(WayrechargenoForm)getForm();
			
			Way way = (Way)BOFactory.build(WayBO.class, getDBAccessUser());
			WayVO wayVO = way.doFindByPk(form.getWayid());
			if (wayVO == null) {
				throw new Exception("渠道不存在, 渠道编码:" + form.getWayid());
			}
			
			Nosect control = (Nosect) BOFactory.build(NosectBO.class, getDBAccessUser());
			NosectDBParam params=new NosectDBParam();
			params.set_snm_beginno(form.getMobile());
			params.set_snl_endno(form.getMobile());
			DataPackage dp1=control.doQuery(params);
			if(dp1.getRowCount()<=0){
				throw new Exception("手机号码不存在于号段表");
			}
			
			WayrechargenoDBParam param1=new WayrechargenoDBParam();
			param1.set_se_mobile(form.getMobile());
			param1.set_sne_wayid(form.getWayid());
			DataPackage dp2 = bo.doQuery(param1);
			if(dp2.getRowCount()>0){
				throw new Exception("该手机号码已经被用于其他的渠道了,请换一个其他的号码");
			}
			
			
			WayrechargenoDBParam param=new WayrechargenoDBParam();
			param.set_se_wayid(form.getWayid());
			param.set_se_mobile(form.getMobile());
//			param.set_ne_cityid(form.getCityid().toString());
			param.set_ne_cityid(CityMappingUtil.getCityNo(getDBAccessUser().getCityid()));
			form.setCityid(Short.parseShort(CityMappingUtil.getCityNo(getDBAccessUser().getCityid())));
			form.setOpercode(getDBAccessUser().getOprcode());
			form.setOpertime(new Date());
			if (WEB_CMD_NEW.equals(CMD)) {
				form.setOpertype("I");
				DataPackage dp = bo.doQuery(param);
				if (dp.getRowCount() > 0) {
					throw new Exception("相同记录已经存在，请检查。");
				}
				super.doSave();
			}else{
				form.setOpertype("U");
				param.set_nne_seq(form.getSeq().toString());
				DataPackage dp = bo.doQuery(param);
				if (dp.getRowCount() > 0) {
					throw new Exception("相同记录已经存在，请检查。");
				}
				super.doSave();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			addActionError(e.getMessage());
		}
		
		return "content";
		
	}
	
}