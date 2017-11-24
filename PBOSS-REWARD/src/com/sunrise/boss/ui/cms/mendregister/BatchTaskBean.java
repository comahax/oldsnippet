package com.sunrise.boss.ui.cms.mendregister;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import com.sunrise.boss.business.cms.mendregister.persistent.MendregisterVO;
import com.sunrise.boss.business.cms.registersim.persistent.RegistersimVO;
import com.sunrise.boss.business.resmanage.nosect.control.NosectControl;
import com.sunrise.boss.business.resmanage.nosect.control.NosectControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.employee.EmployeeDelegate;
import com.sunrise.boss.delegate.cms.mendregister.MendregisterDelegate;
import com.sunrise.boss.delegate.cms.registersim.RegistersimDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.pub.tools.PublicUtils;

public class BatchTaskBean extends BaseBatchTaskBean {
	MendregisterDelegate mdelegate;
	EmployeeDelegate edelegate;
	RegistersimDelegate rdelegate;

	public BatchTaskBean() {
		try {
			mdelegate = new MendregisterDelegate();
			edelegate = new EmployeeDelegate();
			rdelegate = new RegistersimDelegate();
			batchName = "套卡销售补登记";
			setWriteLog(true);
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
	}

	protected String doStart() {
		return "序号 | 套卡号码 | 套卡销售时间(yyyymmdd) | 公务机号码 | 是否成功 | 失败原因"
				+ "\r\n";
	}

	/**
	 * 处理一条记录
	 */
	public ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		MendregisterVO mvo = new MendregisterVO();
		RegistersimVO rvo = new RegistersimVO();
		try{
			//手机，日期格式校验
			if(!checkMobile(items[0]) || !checkMobile(items[2]) || !checkDate(items[1])){
				mvo.setMobile(items[0]);
				mvo.setOfficetel(items[2]);
				mvo.setOptime(new Date());
				mvo.setOprcode(user.getOpercode());
				mvo.setSuccess(new Short("1"));
				mvo.setAdtremark("格式错误");
				mdelegate.doCreate(mvo, user);
				throw new BusinessException("","格式错误");
			}
			//检查是否是当月
			if(!checkMonth(items[1])){
				mvo.setMobile(items[0]);
				mvo.setOfficetel(items[2]);
				mvo.setSelltime(PublicUtils.strToSqlDate(items[1], "yyyyMMdd"));
				mvo.setOptime(new Date());
				mvo.setOprcode(user.getOpercode());
				mvo.setSuccess(new Short("1"));
				mvo.setAdtremark("不能补登记往月的销售记录");
				mdelegate.doCreate(mvo, user);
				throw new BusinessException("","不能补登记往月的销售记录");
			}
			//检查31天内无重复登记记录
			if(mdelegate.checkIfExistIn31Days(items[0], PublicUtils.strToSqlDate(items[1], "yyyyMMdd"), user)){
				mvo.setMobile(items[0]);
				mvo.setOfficetel(items[2]);
				mvo.setSelltime(PublicUtils.strToSqlDate(items[1], "yyyyMMdd"));
				mvo.setOptime(new Date());
				mvo.setOprcode(user.getOpercode());
				mvo.setSuccess(new Short("1"));
				mvo.setAdtremark("存在重复登记记录");
				mdelegate.doCreate(mvo, user);
				throw new BusinessException("","存在重复登记记录");
			}
			//检查店员，网点有效性
			if(!edelegate.mobileEmployeeQuery(items[2], user)){
				mvo.setMobile(items[0]);
				mvo.setOfficetel(items[2]);
				mvo.setSelltime(PublicUtils.strToSqlDate(items[1], "yyyyMMdd"));
				mvo.setOptime(new Date());
				mvo.setOprcode(user.getOpercode());
				mvo.setSuccess(new Short("1"));
				mvo.setAdtremark("店员或网点无效");
				mdelegate.doCreate(mvo, user);
				throw new BusinessException("","店员或网点无效");
			}
			//判断‘套卡号码’归属是否为本地市
			NosectControl ncontrol = (NosectControl)ControlFactory
				.build(NosectControlBean.class);
			String bossarea = ncontrol.doQueryCityID(items[0], user);
			if(!bossarea.equals(user.conversionCityid())){
			//if(!bossarea.equals(user.getCityid())){
				mvo.setMobile(items[0]);
				mvo.setOfficetel(items[2]);
				mvo.setSelltime(PublicUtils.strToSqlDate(items[1], "yyyyMMdd"));
				mvo.setOptime(new Date());
				mvo.setOprcode(user.getOpercode());
				mvo.setSuccess(new Short("1"));
				mvo.setAdtremark("非本地市套卡");
				mdelegate.doCreate(mvo, user);
				throw new BusinessException("","非本地市套卡");
			}
			mvo.setMobile(items[0]);
			mvo.setOfficetel(items[2]);
			mvo.setSelltime(PublicUtils.strToSqlDate(items[1], "yyyyMMdd"));
			mvo.setOptime(new Date());
			mvo.setOprcode(user.getOpercode());
			mvo.setSuccess(new Short("2"));
			mvo.setAdtremark("待每日一次统一补登记处理");
			mdelegate.doCreate(mvo, user);
			
//			EmployeeListVO elistvo = new EmployeeListVO();
//			elistvo.set_se_officetel(items[2]);
//			DataPackage edp = edelegate.mobileEmployeeQuery(elistvo, user);
//			List list = (List) edp.getDatas();
//			EmployeeVO employeevo = (EmployeeVO) list.get(0);
//			rvo.setCityid(user.getCityid());
//			rvo.setOprcode(employeevo.getOprcode2());
//			rvo.setWayid(employeevo.getWayid());
//			rvo.setMobile(items[0]);
//			rvo.setPosvalid("00");
//			rvo.setPosdiff(new Short("-1"));
//			rvo.setAddtime(new Date());
//			rvo.setOprtime(PublicUtils.strToSqlDate(items[1], "yyyyMMdd"));
//			rvo.setMendfalg(new Short("2"));
//			rvo.setMendtime(new Date());
//			rdelegate.doCreate(rvo, user);
			
			resultVO.setOk(true);
			resultVO.setInfo(showInfo(resultVO, items, rowCount));
			return resultVO;
		}catch (Exception ex) { // 插入失败
			msg = ex.getMessage();
			resultVO.setOk(false);
			resultVO.setInfo(showInfo(resultVO, items, rowCount) + msg);
			return resultVO;
		}
	}

	/**
	 * 结果文件格式
	 */
	public String showInfo(ResultVO resultVO, String[] items, int rowCount) {
		final String COMPART = " | "; // 分隔
		StringBuffer resultStr = new StringBuffer();
		// 序号
		resultStr.append(rowCount).append(COMPART);
		resultStr.append(items[0]).append(COMPART);
		resultStr.append(items[1]).append(COMPART);
		resultStr.append(items[2]).append(COMPART);

		// 办理结果
		if (resultVO.isOk()) {
			resultStr.append("成功");
		} else {
			resultStr.append("失败");
		}
		resultStr.append(COMPART);
		return resultStr.toString();
	}
	
	//检查是否是11位数字
	public boolean checkMobile(String mobile){
		try {
			if(mobile.length()!=11){
				return false;
			}
			Double temp = Double.valueOf(mobile);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	//检查是否是yyyyMMdd格式日期字符串
	public boolean checkDate(String date){
		return PublicUtils.checkDateTime(2, date, "", ":", " ");
	}
	
	//检查是否是当月
	public boolean checkMonth(String date){
		try {
			String thismonth = PublicUtils.formatUtilDate(new Date(), "yyyyMM");
			String datetemp = date.substring(0, 6);
			return (datetemp.equals(thismonth));
		} catch (Exception e) {
			return false;
		}
	}
}
