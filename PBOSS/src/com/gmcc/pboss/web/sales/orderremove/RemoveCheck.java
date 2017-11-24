package com.gmcc.pboss.web.sales.orderremove;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

public class RemoveCheck extends BaseCheckFormat{

	@Override
	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		// TODO Auto-generated method stub
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	@Override
	public void checkLine(String line, int rowCount ,User user) throws Exception {
		// TODO Auto-generated method stub
//		�������Ҫ���ַ����ͣ���󳤶�18λ�����ͨ���������һ������ͨ������ʾ�����ļ��кʹ�����������ֹ�ļ��ϴ���
		String item[] = StringUtils.splitPreserveAllTokens(line,"|");
		if(item.length != 4)
			throw new Exception("�ϴ�������������,ӦΪ3��,��鿴˵������!");
		
		for (int i = 0; i < item.length; i++) {
			
			switch (i) {
			// ��������
			case 0:
				if ("".equals(item[i].trim())
						|| item[i].getBytes("GBK").length > 18) {
					throw new Exception("[�������]����Ϊ�ջ����18λ");
				}
				break;
			
			case 1:
				if ("".equals(item[i].trim())) {
					throw new Exception("[����ԭ��]����Ϊ��");
				}
				if (!checkDictitem(item[i],"FX_DISUSE",user)) {
					throw new Exception("�̶�����[����ԭ��]��ֵ����ȷ");
				}
				break;
			}
		}
		
	}

	// ���̶���������
	public boolean checkDictitem(String item, String groupid, User user) throws Exception {
		Dictitem delegate = (DictitemBO) BOFactory.build(DictitemBO.class,user);
		DictitemDBParam listVO = new DictitemDBParam();
		listVO.set_se_groupid(groupid);
		listVO.set_se_dictid(item);
		if (delegate.doQuery(listVO).getRowCount() <= 0) {
			return false;
		}
		return true;
	}
	
}
