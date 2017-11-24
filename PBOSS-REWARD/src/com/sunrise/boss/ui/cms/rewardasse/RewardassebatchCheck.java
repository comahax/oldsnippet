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
//	������Ͷ���,����99��ѭ��ǰ��ĳ������,99���ͱ��������������һλ
	protected static String[] rewardasstype = new String[]{"0","1","2","3","4","5","6","7","8","30","51","52","53","54","55","99"};
	WayDelegate waydelegate;
	public RewardassebatchCheck() throws Exception{
		// TODO Auto-generated constructor stub
		waydelegate=new WayDelegate();
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("","Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount, User user) throws Exception {
		
		String[] content =StringSplit.split(line, "|");
		
		if (content.length < 4) {
			throw new BusinessException("","����������.����Ӧ��4��");
		}
		if(StringUtils.isEmpty(content[0])){
			throw new BusinessException("","�������벻��Ϊ��");
		}
		WayVO wayvo=waydelegate.doFindByPk(content[0], user);
		if(wayvo==null){
			throw new BusinessException("",content[0]+" :�������벻����");
		}else{
			String cityid=SessionFactoryRouter.conversionCityid(user.getCityid());
			if(!cityid.equals(wayvo.getCityid()))
			{
				throw new Exception(wayvo.getWayid()+" :���Ǳ����е��������/�����̱���!");
			}
		}
		
		if(StringUtils.isEmpty(content[1]) || content[1].length()>6){
			throw new BusinessException("","�����·ݲ���Ϊ���ҳ��Ȳ��ܳ���6λ");
		}
		SimpleDateFormat format=new SimpleDateFormat("yyyyMM");
		try{
			format.parse(content[1]);
		}catch(Exception e){
			throw new BusinessException("","�����·ݸ�ʽ����ȷ����ȷ�ĸ�ʽӦ��ΪYYYYMM");
		}
		if(StringUtils.isEmpty(content[2]) || !Arrays.asList(rewardasstype).contains(content[2])){
			throw new BusinessException("","������Ͳ���Ϊ�ջ��߲���������");
		}else if (StringUtils.isNotBlank(content[2])){
			String rewardtype=content[2].trim();
			if("51".equals(rewardtype) || "52".equals(rewardtype) || "53".equals(rewardtype))
			{
				if(wayvo!=null && !StringUtils.equals(wayvo.getWaysubtype(), "DIS"))
				{
					throw new Exception("�������Ϊ[����רӪ���],[���۴����]����[���۳�����]ʱ,�����������Ǻ���������");
				}
			}
		}
		if(StringUtils.isBlank(content[3]) || !NumberUtils.isNumber(content[3].trim())){
			throw new BusinessException("","����ϵ������Ϊ�ղ��ұ���Ϊ����");
		}
		if(content[3].substring(content[3].indexOf('.')+1).length()>6){
			throw new BusinessException("","����ϵ��������Χ,ֻ֧�ֵ�С�������λ");
		}
		Double double1=new Double(content[3]);
		if(double1.doubleValue()<0.0000 || double1.doubleValue()>5){
			throw new BusinessException("","����ϵ����ʽ����Ϊ0.000000~5.000000");
		}
		// 54/55������ͣ�����ϵ��ֵ��Χ<=1
		if("54".equals(content[2].trim()) || "55".equals(content[2].trim())) {
			Double double2=new Double(content[3]);
			if(double2.doubleValue()<0.0000 || double2.doubleValue()>1){
				throw new BusinessException("","54/55������ͣ�����ϵ��ֵ��Χ<=1");
			}
		}
	}
}
