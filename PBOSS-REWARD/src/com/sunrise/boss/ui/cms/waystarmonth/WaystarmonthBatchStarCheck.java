package com.sunrise.boss.ui.cms.waystarmonth;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.pub.tools.PublicUtils;
import com.sunrise.pub.tools.StringSplit;

public class WaystarmonthBatchStarCheck extends BaseCheckFormat{
	
	private static final String SLVS = "0123456";
	
	public WaystarmonthBatchStarCheck() {
		// TODO Auto-generated constructor stub
	}
	
	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("","要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}
	
	public void checkLine(String line, int rowCount, User user) throws Exception {
		
		String[] content = StringSplit.split(line, "|");
		WayDelegate waydelegate = new WayDelegate();
		if (content.length != 3) {
			throw new BusinessException("","上传失败,文件格式不正确,导入格式必需为3列");
		}
		
		if(StringUtils.isEmpty(content[0])){
			throw new BusinessException("","渠道编码不能为空");
		}else{
			WayVO wayvo = waydelegate.doFindByPk(content[0], user);
			if(wayvo == null || !SessionFactoryRouter.conversionCityid(user.getCityid()).equals(wayvo.getCityid())){
				throw new BusinessException("","渠道编码不合法或不存在");
			}
		}
		
		if(StringUtils.isEmpty(content[1])){
			throw new BusinessException("","月份(YYYYMM)不能为空");
		}else{
			if(!PublicUtils.checkDateTime(1, content[1], null, null, null)){
				throw new BusinessException("","月份(YYYYMM)应为6位年月数字");
			}
		}
		
		if(StringUtils.isEmpty(content[2])){
			throw new BusinessException("","星级不能为空");
		}else{
			if(content[2].length() != 1 || SLVS.indexOf(content[2]) == -1 ){
				throw new BusinessException("","星级只能是{0,1,2,3,4,5,6}其中一个");
			}
		}
	}
	
}
