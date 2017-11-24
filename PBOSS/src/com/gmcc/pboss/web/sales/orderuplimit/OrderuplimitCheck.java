package com.gmcc.pboss.web.sales.orderuplimit;

import java.io.File;
import java.util.HashMap;

import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

public class OrderuplimitCheck extends BaseCheckFormat {

	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		String[] content = StringUtils.split(line, "|");
		if (content.length != 6) {
			throw new Exception("�ϴ�������������,ӦΪ6��,��鿴˵������!");
		}
		if (StringUtils.isEmpty(content[0])) {
			throw new Exception("����˾����Ϊ��");
		}
		if (StringUtils.isEmpty(content[1])) {
			throw new Exception("�Ǽ�����Ϊ��");
		}
		if (StringUtils.isEmpty(content[2])) {
			throw new Exception("��Ʒ���಻��Ϊ��");
		} else if (!checkDictitem(content[2], "IM_FXCOMCATEGORY", user)) {
			throw new Exception("��Ʒ����[" + content[2] + "]������");
		}
		if (StringUtils.isEmpty(content[3]) || content[3].length()>10 || !PublicUtils.isInteger(content[3])) {
			throw new Exception("��߿�治��Ϊ���ұ����ǳ���С��10λ������");
		}
		if (StringUtils.isEmpty(content[4]) || content[4].length()>10 || !PublicUtils.isInteger(content[4])) {
			throw new Exception("��ɫԤ������Ϊ���ұ����ǳ���С��10λ������");
		}
		if (StringUtils.isEmpty(content[5]) || content[5].length()>10 || !PublicUtils.isInteger(content[5])) {
			throw new Exception("��ɫԤ������Ϊ���ұ����ǳ���С��10λ������");
		}
		if (new Integer(content[3])<new Integer(content[4]) || new Integer(content[3])<new Integer(content[5])){
			throw new Exception("��߿�治��С�ں�ɫԤ�����ɫԤ����ֵ");
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