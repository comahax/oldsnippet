package com.gmcc.pboss.web.sales.wayassistant;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;


import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;

import com.gmcc.pboss.control.channel.way.WayBO;

import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

public class WayassistantCheck extends BaseCheckFormat {
	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}

	}

	// 找出每行数据后对数据进行校验
	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		// TODO Auto-generated method stub
		// 订单编号
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 7) {
			throw new Exception("商品订购辅助信息填写不完整,请查看补充说明!");
		}
		// 每个字段都要判断是否为空和有效性约束，合作商编号要判断是否存在
		// 对合作商编码进行校验
		if (content[0] == null || this.isEmpty(content[0])) {
			throw new Exception("合作商编码不可以为空!");
		} else {
			WayBO waybo = (WayBO) BOFactory.build(
					WayBO.class, user);
			WayVO wayvo = waybo
					.doFindByPk(content[0]);
			if(wayvo==null)
			{
				throw new Exception("合作商编码不存在!");
			}
		}
		
		// 对是否可发起订购字段校验
		if(content[1]==null||this.isEmpty(content[1])){
			throw new Exception("是否可发起订购不可以为空！");
		}
		else{
			int conorder=-1;
			try{
				conorder=Integer.parseInt(content[1]);
			}catch(Exception e){
				throw new Exception("是否可发起订购只能是数字！");
			}
			if(conorder!=0&&conorder!=1){
				throw new Exception("是否可发起订购只能为1或0！");
			}
			
		}
		

		// 对是否打印发票字段校验
		if(content[2]==null||this.isEmpty(content[2])){
			throw new Exception("是否打印发票不可以为空！");
		}
		else{
			int printinvoice=-1;
			try{
				printinvoice=Integer.parseInt(content[2]);
			}catch(Exception e){
				throw new Exception("是否打印发票只能是数字！");
			}
			if(printinvoice!=0 && printinvoice!=1){
				throw new Exception("是否打印发票只能为1或0！");
			}
			
		}
		
		
		// 对缴费方式字段校验
		if(content[3]==null||this.isEmpty(content[3])){
			throw new Exception("缴费方式不可以为空！");
		}
		else{
			String 	paytype=content[3];
			if(!paytype.equals("ADPAY") && !paytype.equals("BANK") && !paytype.equals("CASH") && !paytype.equals("POS")){
				throw new Exception("缴费方式数据输入不正确！");
			}
		}
		
		// 对送货方式字段校验
		if(content[4]==null||this.isEmpty(content[4])){
			throw new Exception("送货方式不可以为空！");
		}
		else{
			String 	delitype=content[4];
			if(!delitype.equals("ARRIVEPAY") && !delitype.equals("PAYFIRST")){
				throw new Exception("送货方式数据输入不正确！");
			}
		}
		
		
		// 对是否可订购靓号字段校验
		if(content[5]==null||this.isEmpty(content[5])){
			throw new Exception("是否可订购靓号不可以为空！");
		}
		else{
			int orderbetterno=-1;
			try{
				orderbetterno=Integer.parseInt(content[5]);
			}catch(Exception e){
				throw new Exception("是否可订购靓号输入错误！");
			}
			if(orderbetterno!=0&&orderbetterno!=1){
				throw new Exception("是否可订购靓号只能为1或0！");
			}
			
		}
		
		
	}

	private boolean isEmpty(String checkStr) throws Exception {
		if (checkStr != null) {
			return StringUtils.isBlank(checkStr);
		} else {
			throw new Exception("检查字符串为空!");
		}
	}

}
