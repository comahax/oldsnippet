package com.sunrise.boss.ui.cms.provagent.vchpdrprewardrecord;

import java.util.HashMap;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;
import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.business.cms.provagent.chpdagent.persistent.ChPdAgentVO;
import com.sunrise.boss.business.cms.provagent.chpdsubscription.persistent.ChPdSubscriptionVO;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.provagent.chpdagent.ChPdAgentDelegate;
import com.sunrise.boss.delegate.cms.provagent.chpdsubscription.ChPdSubscriptionDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class VChPdRprewardrecordCheck extends BaseCheckFormat {
	 

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		 
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("", "Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount, User user) throws Exception {
		if (null == line || "".equals(line)) {
			return;
		}
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 7) {
			throw new Exception("�ϴ�������������,ӦΪ6��,��鿴˵������!");
		}  
		if (StringUtils.isEmpty(content[2]) ) {
			throw new Exception("[�Ƴ��·�]����Ϊ���ҼƳ��·�Ϊ6λ����(�磺201309)");
		}else if (content[2].length()!=6){
			throw new Exception("[�Ƴ��·�]����Ϊ���ҼƳ��·�Ϊ6λ����(�磺201309)");
		}
		if (StringUtils.isEmpty(content[3])) {
			throw new Exception("[����]����Ϊ��������Ϊ����0С�ڵ���60����");
		}else if(!CheckUtil.checkNum(content[3]) || Integer.parseInt(content[3]) <= 0 || Integer.parseInt(content[3]) >= 60){
			throw new Exception("[����]����Ϊ��������Ϊ����0С�ڵ���60����");
		}
		if (StringUtils.isEmpty(content[4])) {
			throw new Exception("[���б�ʶ]����Ϊ����");
		} 
		
		if (StringUtils.isEmpty(content[5])) {
			throw new Exception("[�������]����Ϊ�������4λС����8λ����������λ");
		}else {
			this.chechRpmoney(content[5]);
		}
		//�������̱��롢���Ų�Ʒ���
		ChPdAgentDelegate   agent = new ChPdAgentDelegate();
		User realuser = new User();
		BeanUtils.copyProperties(realuser, user);
		realuser.setCityid(SessionFactoryRouter.conversionCityid2Num(content[4]));
		ChPdAgentVO agentVO = agent.doFindByPk(content[0], realuser);
		ChPdSubscriptionDelegate sub = new ChPdSubscriptionDelegate();
		ChPdSubscriptionVO subVo = sub.doFindByPk(content[1], realuser);
		
		if (StringUtils.isEmpty(content[0])) {
			throw new Exception("[�����̱���]����Ϊ��");
		}else if (null==agentVO){
			throw new Exception("[�����̱���]�����ڴ��������ϱ��У����ʵ");
		}
		if (StringUtils.isEmpty(content[1])) {
			throw new Exception("[���Ų�Ʒ���]����Ϊ��");
		}else if(null==subVo){
			throw new Exception("[���Ų�Ʒ���]�����ڶ�����ϵ�����ʵ");
		} 
		
	}
	
	private void chechRpmoney(String rpmoney)throws Exception{
		//��齱��
		if(rpmoney!=null && !"".equals(rpmoney.trim())){
			String s = rpmoney.trim();
			double jf = 0;
			try{
				jf = Double.parseDouble(s);
			}catch(NumberFormatException ex){
				throw new Exception("��������ֶα��������֣����ܳ��ַ������ַ�");
			}			
			int index = s.indexOf(".");
			if(index!=-1){
				if(s.substring(index).length()>5){
					throw new Exception("��������ֶ�С������������4λ");
				}
				if ((jf > 0 && s.substring(0, index).length() > 8)
						|| (jf < 0 && s.substring(0, index).length() > 8)) {
					throw new Exception("��������ֶ������������8λ");
				}
			}else{
				if((jf > 0 && s.length()>8) || (jf < 0 && s.length()>8)){
					throw new Exception("��������ֶ������������8λ");
				}
			}
			
		}
	}
	


}
