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
		throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
	}
	if(parameterMap.get("resextratype")==null || "".equals(parameterMap.get("resextratype")))
		throw new Exception("��ѡ����Դ��ȡ��ʽ!");
	if("FIXSECT".equals(parameterMap.get("resextratype"))){
		if(parameterMap.get("fixsectNum")==null || "".equals(parameterMap.get("fixsectNum")))
			throw new Exception("����дָ���Ŷ�ֵ!");
		if(!PublicUtils.isInteger((String)parameterMap.get("fixsectNum"))||((String)parameterMap.get("fixsectNum")).length()!=3)
			throw new Exception("ָ���Ŷ�ֵֻ������λ����!");
	}
	if("CYCSECT".equals(parameterMap.get("resextratype"))){
		if(parameterMap.get("cycsectNum")==null || "".equals(parameterMap.get("cycsectNum")))
			throw new Exception("����дѭ���Ŷ�ֵ!");
		if(((String)parameterMap.get("cycsectNum")).length()>20)
			throw new Exception("ѭ���Ŷ�ֵ�����Ϊ20λ!");
		String[] nums=((String)parameterMap.get("cycsectNum")).split(",");
		for(String num:nums){
			if(!PublicUtils.isInteger(num)||num.length()!=3)
				throw new Exception("ѭ���Ŷ�ֵÿ�κ���ֻ������λ����!");
		}
	}	
	Sysparam sysparamBO=(Sysparam)BOFactory.build(SysparamBO.class,(User)parameterMap.get("user"));
	Serializable pkVO=new SysparamVO();
	BeanUtils.setProperty(pkVO, "systemid", "27");//ϵͳ��ʶ
	BeanUtils.setProperty(pkVO, "paramtype", "pboss_fx");//��������
	SysparamVO vo=(SysparamVO) sysparamBO.doFindByPk(pkVO);
		
		if(vo==null){
			throw new Exception("��Դ������ȡ״̬����δ����");
		}
		if("1".equals(vo.getParamvalue())){
			throw new Exception("|��Դ������ȡ�������ڽ����У�������������ͬʱ����|");
		}
		//������Դ�Ƿ����������
		String sysparamvalue21=sysparamBO.doFindByID("21", "pboss_fx");
		if(StringUtils.isEmpty(sysparamvalue21)){
			throw new Exception("������Դ�Ƿ���������̲���δ����");
		}
		//�����׿�Ʒ�ư���С
		String sysparamvalue5=sysparamBO.doFindByID("5", "pboss_fx");
		if(StringUtils.isEmpty(sysparamvalue5)){
			throw new Exception("�׿�Ʒ�ư���С����δ����");
		}
		
}

public void checkLine(String line, int rowCount, User user)
	throws Exception {
	// TODO Auto-generated method stub
		//�������
	String[] content = StringUtils.splitPreserveAllTokens(line, "|");
	if (content.length>1 ){
		throw new Exception("�����涨������,��鿴����˵��!");
	}
	if (content.length<1 ){
		throw new Exception("������Ų�����Ϊ��,��鿴����˵��!");
	}
	if(content[0].length()>18)
		throw new Exception("�������Ҫ����󳤶�Ϊ18λ���ַ���,��鿴����˵��!");
 
}

private boolean isEmpty(String checkStr) throws Exception {
if (checkStr != null) {
	return StringUtils.isBlank(checkStr);
} else {
	throw new Exception("����ַ���Ϊ��!");
}
}
}
