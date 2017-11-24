package com.sunrise.boss.ui.cms.rewardasse;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.pub.tools.StringSplit;

public class RewardassebatchCheck extends BaseCheckFormat {
//	酬金类型定义,遇到99则循环前面的酬金类型,99类型必须放在数组的最后一位
	protected static String[] rewardasstype = new String[]{"0","1","2","3","4","5","6","7","8","30","51","52","53","54","55","99"};
	WayDelegate waydelegate;
	public RewardassebatchCheck() throws Exception{
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
		
		if (content.length < 4) {
			throw new BusinessException("","参数不完整.最少应有4项");
		}
		if(StringUtils.isEmpty(content[0])){
			throw new BusinessException("","渠道编码不能为空");
		}
		WayVO wayvo=waydelegate.doFindByPk(content[0], user);
		if(wayvo==null){
			throw new BusinessException("",content[0]+" :渠道编码不存在");
		}else{
			String cityid=SessionFactoryRouter.conversionCityid(user.getCityid());
			if(!cityid.equals(wayvo.getCityid()))
			{
				throw new Exception(wayvo.getWayid()+" :不是本地市的网点编码/合作商编码!");
			}
		}
		
		if(StringUtils.isEmpty(content[1]) || content[1].length()>6){
			throw new BusinessException("","考核月份不能为空且长度不能超过6位");
		}
		SimpleDateFormat format=new SimpleDateFormat("yyyyMM");
		try{
			format.parse(content[1]);
		}catch(Exception e){
			throw new BusinessException("","考核月份格式不正确，正确的格式应该为YYYYMM");
		}
		if(StringUtils.isEmpty(content[2]) || !Arrays.asList(rewardasstype).contains(content[2])){
			throw new BusinessException("","酬金类型不能为空或者参数不存在");
		}else if (StringUtils.isNotBlank(content[2])){
			String rewardtype=content[2].trim();
			if("51".equals(rewardtype) || "52".equals(rewardtype) || "53".equals(rewardtype))
			{
				if(wayvo!=null && !StringUtils.equals(wayvo.getWaysubtype(), "DIS"))
				{
					throw new Exception("酬金类型为[合作专营酬金],[销售达标酬金]或者[销售超额酬金]时,网点编码必须是合作商类型");
				}
			}
		}
		if(StringUtils.isBlank(content[3]) || !NumberUtils.isNumber(content[3].trim())){
			throw new BusinessException("","考核系数不能为空并且必须为数字");
		}
		if(content[3].substring(content[3].indexOf('.')+1).length()>6){
			throw new BusinessException("","考核系数超过范围,只支持到小数点后六位");
		}
		Double double1=new Double(content[3]);
		if(double1.doubleValue()<0.0000 || double1.doubleValue()>5){
			throw new BusinessException("","考核系数格式必须为0.000000~5.000000");
		}
		// 54/55酬金类型，考核系数值范围<=1
		if("54".equals(content[2].trim()) || "55".equals(content[2].trim())) {
			Double double2=new Double(content[3]);
			if(double2.doubleValue()<0.0000 || double2.doubleValue()>1){
				throw new BusinessException("","54/55酬金类型，考核系数值范围<=1");
			}
		}
	}
}
