package com.sunrise.boss.ui.cms.rewardreport;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.pub.tools.StringSplit;

public class BatchRewardreportCheck extends BaseCheckFormat {
	WayDelegate waydelegate;
	public BatchRewardreportCheck() throws Exception{
		// TODO Auto-generated constructor stub
		waydelegate=new WayDelegate();
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("","要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount, User user) throws Exception {
		
		String[] content =StringSplit.split(line, "|");
		
		if (content.length != 5) {
			throw new BusinessException("","上传数据列数不对,应为5列");
		}
		// 收款账户
		if(StringUtils.isEmpty(content[0])){
			throw new BusinessException("","收款账户不能为空");
		}
		// 付款账户
		if(StringUtils.isEmpty(content[1])){
			throw new BusinessException("","付款账户不能为空");
		}
//		WayVO wayvo=waydelegate.doFindByPk(content[0], user);
//		if(wayvo==null){
//			throw new BusinessException("",content[0]+" :渠道编码不存在");
//		}else{
//			String cityid=SessionFactoryRouter.conversionCityid(user.getCityid());
//			if(!cityid.equals(wayvo.getCityid()))
//			{
//				throw new Exception(wayvo.getWayid()+" :不是本地市的渠道编码!");
//			}
//		}
		
		if(StringUtils.isEmpty(content[2]) || content[2].length()>6){
			throw new BusinessException("","计酬月份不能为空且长度不能超过6位");
		}
		SimpleDateFormat format=new SimpleDateFormat("yyyyMM");
		try{
			format.parse(content[2]);
		}catch(Exception e){
			throw new BusinessException("","计酬月份格式不正确，正确的格式应该为YYYYMM");
		}
		if(StringUtils.isBlank(content[3]) || !NumberUtils.isNumber(content[3].trim())){
			throw new BusinessException("","支付金额不能为空并且必须为数字");
		}
		if (content[3].indexOf('.') >= 0) {
			if(content[3].substring(content[3].indexOf('.')+1).length()>2){
				throw new BusinessException("","支付金额超过范围,只支持到小数点后两位");
			}
			if (content[3].substring(0,content[3].indexOf('.')).length() > 8) {
				throw new BusinessException("","支付金额超过范围,只支持八位整数");
			}
		} else {
			if (content[3].length() > 8) {
				throw new BusinessException("","支付金额超过范围,只支持八位整数");
			}
		}
	}
}
