package com.sunrise.boss.ui.cms.rewardranlog;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountVO;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.cms.wayaccount.WayaccountDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.pub.tools.StringSplit;

public class DeleteCheck extends BaseCheckFormat {
	WayDelegate waydelegate;
	WayaccountDelegate wayaccountdelegate;
	public DeleteCheck() throws Exception{
		// TODO Auto-generated constructor stub
		waydelegate=new WayDelegate();
		wayaccountdelegate=new WayaccountDelegate();
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("","要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount, User user) throws Exception {
		
		String[] content =StringSplit.split(line, "|");
		
		if (content.length != 3) {
			throw new BusinessException("","上传数据列数不对,应为3列");
		}
		// 渠道编码
		if(StringUtils.isEmpty(content[0])){
			throw new BusinessException("","渠道编码不能为空");
		}
		// 收款账户
		if(StringUtils.isEmpty(content[1])){
			throw new BusinessException("","收款账户不能为空");
		}
		// 计酬月份
		if(StringUtils.isEmpty(content[2]) || content[2].length()>6){
			throw new BusinessException("","计酬月份不能为空且长度不能超过6位");
		}
		SimpleDateFormat format=new SimpleDateFormat("yyyyMM");
		try{
			format.parse(content[2]);
		}catch(Exception e){
			throw new BusinessException("","计酬月份格式不正确，正确的格式应该为YYYYMM");
		}
	}
}
