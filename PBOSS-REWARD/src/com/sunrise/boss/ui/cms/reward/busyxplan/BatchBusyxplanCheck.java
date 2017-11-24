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
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		// TODO Auto-generated method stub
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length !=8) {
			throw new Exception("�ϴ�������������,ӦΪ7��,��鿴˵������!");
		}
		if (!CheckUtil.checkString(content[0], 18, false)) {
			throw new Exception("[ҵ�����]����Ϊ���ҳ��Ȳ��ܴ���18");
		}
		if(opDel.doFindByPk(content[0].trim(), user)==null)
		{
			throw new Exception("[ҵ�����]������ϵͳ�д���");
		}
		if (!CheckUtil.checkNum(content[1], 14, true)) {
			throw new Exception("[Ӫ����������]����Ϊ���ֲ���Ϊ���ҳ��Ȳ��ܴ���14");
		}
		if(!CheckUtil.isEmpty(content[1])){
		   if(yxDel.doFindByPk(new Long(content[1].trim()), user)==null)
		  {
			throw new Exception("[Ӫ����������]������ϵͳ�д���");
	     	}
		}

		if (!CheckUtil.checkDouble(content[2], 10, 2)
				|| CheckUtil.isEmpty(content[2])) {
			throw new Exception("[Ӫ����������(Ԫ)]����Ϊ���ֲ���Ϊ����:�������Ȳ��ܴ���10,С�����ֳ��Ȳ��ܴ���2");
		}
		if (!CheckUtil.checkString(content[3], 20, true)) {
			throw new Exception("[��������]���Ȳ��ܴ���20");
		}
		if (!CheckUtil.checkString(content[4], 32, false)) {
			throw new Exception("[Ӫ������ҵ������]���Ȳ��ܴ���32");
		}
		if (!CheckUtil.getInstance().checkDictitem("CH_CBPLANBUSITYPE",
				CheckUtil.dealString(content[4]), user)) {
			throw new Exception("[Ӫ������ҵ������]�Ĺ̶�����ֵ����ȷ");
		}
		if ("WLAN".equals(content[4].trim())) {
			if (!CheckUtil.checkString(content[3], 20, false)) {
				throw new Exception("[Ӫ������ҵ������]Ϊ[���ݸ�УӪ������]ʱ[��������]����Ϊ��!");
			}
		}else{
			if (!CheckUtil.checkString(content[3], 20, true)) {
				throw new Exception("[Ӫ������ҵ������]��Ϊ[���ݸ�УӪ������]ʱ[��������]����Ϊ��!");
			}
		} 
		 if (!CheckUtil.isEmpty(content[5])) {
		   if (!CheckUtil.checkNum(content[5]) || Integer.parseInt(content[5])<=0 || Integer.parseInt(content[5])>12) {
			 throw new Exception("[�ͻ�άϵ��𷢷�����]ֻ����������1-12");
		 }
		 }
		
		if(!StringUtils.isBlank(content[3]) && wayDel.doFindByPk(content[3].trim(), user)==null)
		{
			throw new Exception("[��������]������ϵͳ�д���");
		} 
//		if (!CheckUtil.checkNum(content[6], 14, true)) {
//			throw new Exception("[��Ʒ��ʶ]����Ϊ���ֲ���Ϊ���ҳ��Ȳ��ܴ���14");
//		}
		if(CheckUtil.isEmpty(content[1]) && CheckUtil.isEmpty(content[6])){
			 throw new Exception("Ӫ��������ʶ�Ͳ�Ʒ��ʶ����ͬʱΪ��");
		}

	}
}
