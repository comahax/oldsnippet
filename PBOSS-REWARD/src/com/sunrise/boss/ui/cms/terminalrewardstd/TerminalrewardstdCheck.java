package com.sunrise.boss.ui.cms.terminalrewardstd;

 
import java.util.HashMap; 
import org.apache.commons.lang.StringUtils; 
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
 

public class TerminalrewardstdCheck extends BaseCheckFormat {
	private String region;
	public TerminalrewardstdCheck() {
		// TODO Auto-generated constructor stub
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		region = parameterMap.get("region").toString();
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("",
					"Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");  
		if (content.length != 7) {
			throw new Exception("�ϴ�������������,ӦΪ6��,��鿴˵������!");
		}
		if (StringUtils.isEmpty(content[0])) {
			throw new BusinessException("", "[�ն���ƷID]����Ϊ��");
		}
		if ( CheckUtil.isEmpty(content[1])) {
			throw new BusinessException("","[��׼��]����Ϊ��");
		}    
		if (StringUtils.isEmpty(content[2])) {
			throw new BusinessException("", "[����׼]����Ϊ��"); 
		} 
		if (StringUtils.isEmpty(content[3])) {
			throw new BusinessException("", "[�������]����Ϊ��");
		}
		if (StringUtils.isEmpty(content[4])) {
			throw new BusinessException("", "[�Ƴ�����]����Ϊ��");
		}  
		for (int i = 0; i < content.length - 1; i++) {
			switch (i) {
			case 0:
				if (!CheckUtil.checkString(content[i], 18, true)) {
					throw new Exception("[�ն���ƷID]���ܴ���18λ");
				}
				break;
			case 1:
				if (content[i] != null && !"".equals(content[i])) {
					if (!CheckUtil.checkDoubleNum(content[i])) {
						throw new Exception("[��׼��]ֻ�ܴ��ڵ���0");
					}
				}
				break;
			case 2:
				if (content[i] != null && !"".equals(content[i])) {
					if (!CheckUtil.checkDouble(content[i], 12, 4)) {
						throw new Exception("[����׼]�������ֲ��ܳ���12λ,С�����ֲ��ܳ���4λ");
					}
				}
				break; 
			case 3:
				
				if(region.equals("999")){
				   if (!content[i].trim().matches("(1|2|3|4|11|12|13|14)")) {
					throw new Exception("[�������]��ʽ����,Ӧ��Ϊ1��2��3��4��11��12��13��14�е�һ����ֵ");
				    }
				}else if(!region.equals("999")){
				   if (!content[i].trim().matches("(1|2|3|4|5|6|11|12|13|14)")) {
					throw new Exception("[�������]��ʽ����,Ӧ��Ϊ1��2��3��4��5��6��11��12��13��14�е�һ����ֵ");
				    }
				}
				break;
			case 4:
				if (!content[i].trim().matches("[1-2]")) {
					throw new Exception("[�Ƴ�����]��ʽ����,ֻ��Ϊ����1��2");
				}
				break;
			case 5:
				if (!StringUtils.isEmpty(content[5])) {
					if (!CheckUtil.checkString(content[i], 128, true)) {
						throw new Exception("[��ע]���ܳ���128���ַ�");
					}
				}
				break;

			}
		}
	}

}
