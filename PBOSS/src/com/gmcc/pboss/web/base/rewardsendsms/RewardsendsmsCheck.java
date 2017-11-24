package com.gmcc.pboss.web.base.rewardsendsms;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

public class RewardsendsmsCheck extends BaseCheckFormat {
	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}

	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {

		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		Dictitem dictitem = (Dictitem) BOFactory.build(DictitemBO.class, user);
		DictitemVO vo = new DictitemVO();
		
		vo.setGroupid("CH_REWARDSMSTYPE");
		vo.setDictid(content[1]);
		
		if (content.length != 3) {
			throw new Exception("�ϴ�������������,ӦΪ2��,��鿴˵������!");
		}
		if (content[0] == null || "".equals(content[0])) {
			throw new Exception("���������˺��벻��Ϊ��");
		}else if (content[0].length()<11 || content[0].length()>11){
			throw new Exception("���������˺������Ϊ��Ч��11λ�ֻ�����");
		}
		if (content[1] == null || "".equals(content[1])) {
			throw new Exception("���������Ͳ���Ϊ��");
		} else if (dictitem.doFindByPk(vo) == null) { 
			throw new Exception("���������͡�" + content[1] + "���̶�����ֵ���������ݣ����ʵ");
		}  
		 
		
	}

}
