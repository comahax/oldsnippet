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

public class RewardranlogCheck extends BaseCheckFormat {
	WayDelegate waydelegate;
	WayaccountDelegate wayaccountdelegate;
	public RewardranlogCheck() throws Exception{
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
		
		if (content.length != 7) {
			throw new BusinessException("","上传数据列数不对,应为7列");
		}		
		// 收款账户
		if(StringUtils.isEmpty(content[1])){
			throw new BusinessException("","收款账户不能为空");
		}
		// 渠道编码
		if(!StringUtils.isEmpty(content[0])){
			WayVO wayvo=waydelegate.doFindByPk(content[0], user);
			if(wayvo==null){
				throw new BusinessException("",content[0]+" :渠道编码不存在");
			}else{
				String cityid=SessionFactoryRouter.conversionCityid(user.getCityid());
				if(!cityid.equals(wayvo.getCityid()))
				{
					throw new Exception(wayvo.getWayid()+" :不是本地市的渠道编码!");
				}
				if (!"AG".equals(wayvo.getWaytype())) {
					throw new Exception(wayvo.getWayid()+" :不属于社会渠道!");
				}
				WayaccountVO acvo = new WayaccountVO();
				acvo.setAccid(0);
				acvo.setWayid(wayvo.getWayid());
				WayaccountVO chvo = wayaccountdelegate.doFindByPk(acvo, user);
				if (chvo == null || !content[1].equals(chvo.getAcctno())) {
					throw new Exception("【渠道编码】，【收款账户】不符合【渠道管理】->【社会渠道网点信息管理】【酬金支付银行账号】设置!");
				}
			}
		}
		// 付款账户
		if(StringUtils.isEmpty(content[2])){
			throw new BusinessException("","付款账户不能为空");
		}
		// 计酬月份
		if(StringUtils.isEmpty(content[3]) || content[3].length()>6){
			throw new BusinessException("","计酬月份不能为空且长度不能超过6位");
		}
		SimpleDateFormat format=new SimpleDateFormat("yyyyMM");
		try{
			format.parse(content[3]);
		}catch(Exception e){
			throw new BusinessException("","计酬月份格式不正确，正确的格式应该为YYYYMM");
		}
		// 支付金额
		if(StringUtils.isBlank(content[4]) || !NumberUtils.isNumber(content[4].trim())){
			throw new BusinessException("","支付金额不能为空并且必须为数字");
		}
		if (content[4].indexOf('.') >= 0) {
			if(content[4].substring(content[4].indexOf('.')+1).length()>2){
				throw new BusinessException("","支付金额超过范围,只支持到小数点后两位");
			}
			if (content[4].substring(0,content[4].indexOf('.')).length() > 8) {
				throw new BusinessException("","支付金额超过范围,只支持八位整数");
			}
		} else {
			if (content[4].length() > 8) {
				throw new BusinessException("","支付金额超过范围,只支持八位整数");
			}
		}
		// 支付时间
		if(!StringUtils.isEmpty(content[5])){
			SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try{
				format1.parse(content[5]);
			}catch(Exception e){
				throw new BusinessException("","支付时间格式不正确，正确的格式应该为yyyy-MM-dd HH:mm:ss");
			}
		}
	}
}
