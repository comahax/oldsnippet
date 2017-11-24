package com.gmcc.pboss.web.sales.orderresdet;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.base.sysparam.SysparamVO;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

public class OrderresdetCheck extends BaseCheckFormat {
public void checkFile(File file, HashMap parameterMap, String contentType)
	throws Exception {
	if (!"text/plain".equalsIgnoreCase(contentType)) {
		throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
	}
	if(parameterMap.get("resextratype")==null || "".equals(parameterMap.get("resextratype")))
		throw new Exception("请选择资源抽取方式!");
	if("FIXSECT".equals(parameterMap.get("resextratype"))){
		if(parameterMap.get("fixsectNum")==null || "".equals(parameterMap.get("fixsectNum")))
			throw new Exception("请填写指定号段值!");
		if(!PublicUtils.isInteger((String)parameterMap.get("fixsectNum"))||((String)parameterMap.get("fixsectNum")).length()!=3)
			throw new Exception("指定号段值只能是三位数字!");
	}
	if("CYCSECT".equals(parameterMap.get("resextratype"))){
		if(parameterMap.get("cycsectNum")==null || "".equals(parameterMap.get("cycsectNum")))
			throw new Exception("请填写循环号段值!");
		if(((String)parameterMap.get("cycsectNum")).length()>20)
			throw new Exception("循环号段值长度最长为20位!");
		String[] nums=((String)parameterMap.get("cycsectNum")).split(",");
		for(String num:nums){
			if(!PublicUtils.isInteger(num)||num.length()!=3)
				throw new Exception("循环号段值每段号码只能是三位数字!");
		}
	}	
	Sysparam sysparamBO=(Sysparam)BOFactory.build(SysparamBO.class,(User)parameterMap.get("user"));
	Serializable pkVO=new SysparamVO();
	BeanUtils.setProperty(pkVO, "systemid", "27");//系统标识
	BeanUtils.setProperty(pkVO, "paramtype", "pboss_fx");//参数类型
	SysparamVO vo=(SysparamVO) sysparamBO.doFindByPk(pkVO);
		
		if(vo==null){
			throw new Exception("资源批量抽取状态参数未设置");
		}
		if("1".equals(vo.getParamvalue())){
			throw new Exception("|资源批量抽取操作正在进行中，不允许多个操作同时进行|");
		}
		//订购资源是否管理配送商
		String sysparamvalue21=sysparamBO.doFindByID("21", "pboss_fx");
		if(StringUtils.isEmpty(sysparamvalue21)){
			throw new Exception("订购资源是否关联配送商参数未设置");
		}
		//载入套卡品牌包大小
		String sysparamvalue5=sysparamBO.doFindByID("5", "pboss_fx");
		if(StringUtils.isEmpty(sysparamvalue5)){
			throw new Exception("套卡品牌包大小参数未设置");
		}
		
}

public void checkLine(String line, int rowCount, User user)
	throws Exception {
	// TODO Auto-generated method stub
		//订单编号
	String[] content = StringUtils.splitPreserveAllTokens(line, "|");
	if (content.length>1 ){
		throw new Exception("超出规定的列数,请查看补充说明!");
	}
	if (content.length<1 ){
		throw new Exception("订单编号不允许为空,请查看补充说明!");
	}
	if(content[0].length()>18)
		throw new Exception("订单编号要求最大长度为18位的字符串,请查看补充说明!");
 
}

private boolean isEmpty(String checkStr) throws Exception {
if (checkStr != null) {
	return StringUtils.isBlank(checkStr);
} else {
	throw new Exception("检查字符串为空!");
}
}
}
