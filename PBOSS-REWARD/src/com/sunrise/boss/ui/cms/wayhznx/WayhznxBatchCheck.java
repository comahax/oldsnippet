package com.sunrise.boss.ui.cms.wayhznx;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.pub.tools.PublicUtils;
import com.sunrise.pub.tools.StringSplit;

public class WayhznxBatchCheck extends BaseCheckFormat{

	public WayhznxBatchCheck() {
		// TODO Auto-generated constructor stub
	}
	
	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("","要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}
	
	public void checkLine(String line, int rowCount, User user) throws Exception {
		
		String[] content = StringSplit.split(line, "|");
		WayDelegate waydelegate=new WayDelegate();
		if (content.length < 3) {
			throw new BusinessException("","上传失败,文件格式不正确,第"+rowCount+"行应该为3列");
		}
		
		if(StringUtils.isEmpty(content[0])){
			throw new BusinessException("","第"+rowCount+"行网点编码不能为空");
		}
		if(StringUtils.isEmpty(content[1])){
			throw new BusinessException("","第"+rowCount+"行计算合作年限的开始时间不能为空");
		}
		if(StringUtils.isEmpty(content[2])){
			throw new BusinessException("","第"+rowCount+"行备注不能为空");
		}
		
		if(content[2].getBytes().length > 255){
			throw new BusinessException("","第"+rowCount+"行备注描述过长,不能超过255个字符!");
		}
		
		WayVO wayvo=waydelegate.doFindByPk(content[0], user);
		if(wayvo==null || !"AG".equals(wayvo.getWaytype())){
			throw new BusinessException("","上传失败，第"+rowCount+"行网点编码["+content[0]+"]不存在或不是社会渠道");
		}
		
		if(!PublicUtils.checkDateTime(2, content[1], null, null, null)){
			throw new BusinessException("","上传失败，第"+rowCount+"行计算合作年限的开始时间(YYYYMMDD)["+content[1]+"]不合法");
		}
		
	}
	
}
