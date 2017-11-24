package com.sunrise.boss.ui.cms.reward.busyxplan;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.delegate.zifee.yxplan.YxPlanDelegate;
import com.sunrise.boss.delegate.cms.operation.OperationDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class BatchBusyxplanCheck extends BaseCheckFormat {
	OperationDelegate opDel;
	YxPlanDelegate yxDel;
	WayDelegate wayDel;
	public BatchBusyxplanCheck() throws Exception {
		// TODO Auto-generated constructor stub
		opDel = new OperationDelegate();
		yxDel = new YxPlanDelegate();
		wayDel=new WayDelegate();
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		// TODO Auto-generated method stub
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length !=8) {
			throw new Exception("上传数据列数不对,应为7列,请查看说明帮助!");
		}
		if (!CheckUtil.checkString(content[0], 18, false)) {
			throw new Exception("[业务编码]不能为空且长度不能大于18");
		}
		if(opDel.doFindByPk(content[0].trim(), user)==null)
		{
			throw new Exception("[业务编码]必须在系统中存在");
		}
		if (!CheckUtil.checkNum(content[1], 14, true)) {
			throw new Exception("[营销方案编码]必须为数字不能为空且长度不能大于14");
		}
		if(!CheckUtil.isEmpty(content[1])){
		   if(yxDel.doFindByPk(new Long(content[1].trim()), user)==null)
		  {
			throw new Exception("[营销方案编码]必须在系统中存在");
	     	}
		}

		if (!CheckUtil.checkDouble(content[2], 10, 2)
				|| CheckUtil.isEmpty(content[2])) {
			throw new Exception("[营销方案月租(元)]必须为数字不能为空且:整数长度不能大于10,小数部分长度不能大于2");
		}
		if (!CheckUtil.checkString(content[3], 20, true)) {
			throw new Exception("[渠道编码]长度不能大于20");
		}
		if (!CheckUtil.checkString(content[4], 32, false)) {
			throw new Exception("[营销方案业务类型]长度不能大于32");
		}
		if (!CheckUtil.getInstance().checkDictitem("CH_CBPLANBUSITYPE",
				CheckUtil.dealString(content[4]), user)) {
			throw new Exception("[营销方案业务类型]的固定参数值不正确");
		}
		if ("WLAN".equals(content[4].trim())) {
			if (!CheckUtil.checkString(content[3], 20, false)) {
				throw new Exception("[营销方案业务类型]为[广州高校营销方案]时[渠道编码]不能为空!");
			}
		}else{
			if (!CheckUtil.checkString(content[3], 20, true)) {
				throw new Exception("[营销方案业务类型]不为[广州高校营销方案]时[渠道编码]必须为空!");
			}
		} 
		 if (!CheckUtil.isEmpty(content[5])) {
		   if (!CheckUtil.checkNum(content[5]) || Integer.parseInt(content[5])<=0 || Integer.parseInt(content[5])>12) {
			 throw new Exception("[客户维系酬金发放期数]只允许填数字1-12");
		 }
		 }
		
		if(!StringUtils.isBlank(content[3]) && wayDel.doFindByPk(content[3].trim(), user)==null)
		{
			throw new Exception("[渠道编码]必须在系统中存在");
		} 
//		if (!CheckUtil.checkNum(content[6], 14, true)) {
//			throw new Exception("[产品标识]必须为数字不能为空且长度不能大于14");
//		}
		if(CheckUtil.isEmpty(content[1]) && CheckUtil.isEmpty(content[6])){
			 throw new Exception("营销方案标识和产品标识不能同时为空");
		}

	}
}
