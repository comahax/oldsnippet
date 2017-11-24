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
			throw new BusinessException("","Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount, User user) throws Exception {
		
		String[] content =StringSplit.split(line, "|");
		
		if (content.length != 5) {
			throw new BusinessException("","�ϴ�������������,ӦΪ5��");
		}
		// �տ��˻�
		if(StringUtils.isEmpty(content[0])){
			throw new BusinessException("","�տ��˻�����Ϊ��");
		}
		// �����˻�
		if(StringUtils.isEmpty(content[1])){
			throw new BusinessException("","�����˻�����Ϊ��");
		}
//		WayVO wayvo=waydelegate.doFindByPk(content[0], user);
//		if(wayvo==null){
//			throw new BusinessException("",content[0]+" :�������벻����");
//		}else{
//			String cityid=SessionFactoryRouter.conversionCityid(user.getCityid());
//			if(!cityid.equals(wayvo.getCityid()))
//			{
//				throw new Exception(wayvo.getWayid()+" :���Ǳ����е���������!");
//			}
//		}
		
		if(StringUtils.isEmpty(content[2]) || content[2].length()>6){
			throw new BusinessException("","�Ƴ��·ݲ���Ϊ���ҳ��Ȳ��ܳ���6λ");
		}
		SimpleDateFormat format=new SimpleDateFormat("yyyyMM");
		try{
			format.parse(content[2]);
		}catch(Exception e){
			throw new BusinessException("","�Ƴ��·ݸ�ʽ����ȷ����ȷ�ĸ�ʽӦ��ΪYYYYMM");
		}
		if(StringUtils.isBlank(content[3]) || !NumberUtils.isNumber(content[3].trim())){
			throw new BusinessException("","֧������Ϊ�ղ��ұ���Ϊ����");
		}
		if (content[3].indexOf('.') >= 0) {
			if(content[3].substring(content[3].indexOf('.')+1).length()>2){
				throw new BusinessException("","֧��������Χ,ֻ֧�ֵ�С�������λ");
			}
			if (content[3].substring(0,content[3].indexOf('.')).length() > 8) {
				throw new BusinessException("","֧��������Χ,ֻ֧�ְ�λ����");
			}
		} else {
			if (content[3].length() > 8) {
				throw new BusinessException("","֧��������Χ,ֻ֧�ְ�λ����");
			}
		}
	}
}
