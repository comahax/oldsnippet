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
			throw new BusinessException("", "要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount, User user) throws Exception {
		if (null == line || "".equals(line)) {
			return;
		}
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 7) {
			throw new Exception("上传数据列数不对,应为6列,请查看说明帮助!");
		}  
		if (StringUtils.isEmpty(content[2]) ) {
			throw new Exception("[计酬月份]不能为空且计酬月份为6位年月(如：201309)");
		}else if (content[2].length()!=6){
			throw new Exception("[计酬月份]不能为空且计酬月份为6位年月(如：201309)");
		}
		if (StringUtils.isEmpty(content[3])) {
			throw new Exception("[期数]不能为空且期数为大于0小于等于60整数");
		}else if(!CheckUtil.checkNum(content[3]) || Integer.parseInt(content[3]) <= 0 || Integer.parseInt(content[3]) >= 60){
			throw new Exception("[期数]不能为空且期数为大于0小于等于60整数");
		}
		if (StringUtils.isEmpty(content[4])) {
			throw new Exception("[地市标识]不能为空且");
		} 
		
		if (StringUtils.isEmpty(content[5])) {
			throw new Exception("[奖罚金额]不能为空且最多4位小数、8位整数含符号位");
		}else {
			this.chechRpmoney(content[5]);
		}
		//检查代理商编码、集团产品编号
		ChPdAgentDelegate   agent = new ChPdAgentDelegate();
		User realuser = new User();
		BeanUtils.copyProperties(realuser, user);
		realuser.setCityid(SessionFactoryRouter.conversionCityid2Num(content[4]));
		ChPdAgentVO agentVO = agent.doFindByPk(content[0], realuser);
		ChPdSubscriptionDelegate sub = new ChPdSubscriptionDelegate();
		ChPdSubscriptionVO subVo = sub.doFindByPk(content[1], realuser);
		
		if (StringUtils.isEmpty(content[0])) {
			throw new Exception("[代理商编码]不能为空");
		}else if (null==agentVO){
			throw new Exception("[代理商编码]不存在代理商资料表中，请核实");
		}
		if (StringUtils.isEmpty(content[1])) {
			throw new Exception("[集团产品编号]不能为空");
		}else if(null==subVo){
			throw new Exception("[集团产品编号]不存在订购关系表，请核实");
		} 
		
	}
	
	private void chechRpmoney(String rpmoney)throws Exception{
		//检查奖罚
		if(rpmoney!=null && !"".equals(rpmoney.trim())){
			String s = rpmoney.trim();
			double jf = 0;
			try{
				jf = Double.parseDouble(s);
			}catch(NumberFormatException ex){
				throw new Exception("奖罚金额字段必须是数字，不能出现非数字字符");
			}			
			int index = s.indexOf(".");
			if(index!=-1){
				if(s.substring(index).length()>5){
					throw new Exception("奖罚金额字段小数点后最多允许4位");
				}
				if ((jf > 0 && s.substring(0, index).length() > 8)
						|| (jf < 0 && s.substring(0, index).length() > 8)) {
					throw new Exception("奖罚金额字段整数最多允许8位");
				}
			}else{
				if((jf > 0 && s.length()>8) || (jf < 0 && s.length()>8)){
					throw new Exception("奖罚金额字段整数最多允许8位");
				}
			}
			
		}
	}
	


}
