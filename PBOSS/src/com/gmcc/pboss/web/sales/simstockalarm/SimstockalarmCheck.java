package com.gmcc.pboss.web.sales.simstockalarm;

import java.io.File;
import java.util.HashMap;
import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class SimstockalarmCheck extends BaseCheckFormat {

	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 6) {
			throw new Exception("�ϴ�������������,ӦΪ5��,��鿴˵������!");
		}
		if (StringUtils.isEmpty(content[0])) {
			throw new Exception("�����̱��벻��Ϊ��");
		} else {
			Way way = (Way) BOFactory.build(WayBO.class, user);
			WayDBParam param = new WayDBParam();
			param.set_se_wayid(content[0]);
			param.set_se_waytype("AG");
			DataPackage dp = way.doQuery(param);
			if (dp.getRowCount() == 0) {
				throw new Exception("�����̱��벻����");
			}
		}
		if (StringUtils.isEmpty(content[1])) {
			throw new Exception("��Ʒ���಻��Ϊ��");
		} else if (!checkDictitem(content[1], "IM_FXCOMCATEGORY", user)) {
			throw new Exception("��Ʒ����[" + content[1] + "]������");
		}
		if (StringUtils.isEmpty(content[2])) {
			throw new Exception("��߿�治��Ϊ��");
		}
		if (StringUtils.isEmpty(content[3])) {
			throw new Exception("��ɫԤ������Ϊ��");
		}
		if (StringUtils.isEmpty(content[4])) {
			throw new Exception("��ɫԤ������Ϊ��");
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