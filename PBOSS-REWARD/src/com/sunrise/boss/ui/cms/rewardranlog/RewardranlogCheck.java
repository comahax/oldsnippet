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
			throw new BusinessException("","Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount, User user) throws Exception {
		
		String[] content =StringSplit.split(line, "|");
		
		if (content.length != 7) {
			throw new BusinessException("","�ϴ�������������,ӦΪ7��");
		}		
		// �տ��˻�
		if(StringUtils.isEmpty(content[1])){
			throw new BusinessException("","�տ��˻�����Ϊ��");
		}
		// ��������
		if(!StringUtils.isEmpty(content[0])){
			WayVO wayvo=waydelegate.doFindByPk(content[0], user);
			if(wayvo==null){
				throw new BusinessException("",content[0]+" :�������벻����");
			}else{
				String cityid=SessionFactoryRouter.conversionCityid(user.getCityid());
				if(!cityid.equals(wayvo.getCityid()))
				{
					throw new Exception(wayvo.getWayid()+" :���Ǳ����е���������!");
				}
				if (!"AG".equals(wayvo.getWaytype())) {
					throw new Exception(wayvo.getWayid()+" :�������������!");
				}
				WayaccountVO acvo = new WayaccountVO();
				acvo.setAccid(0);
				acvo.setWayid(wayvo.getWayid());
				WayaccountVO chvo = wayaccountdelegate.doFindByPk(acvo, user);
				if (chvo == null || !content[1].equals(chvo.getAcctno())) {
					throw new Exception("���������롿�����տ��˻��������ϡ���������->���������������Ϣ���������֧�������˺š�����!");
				}
			}
		}
		// �����˻�
		if(StringUtils.isEmpty(content[2])){
			throw new BusinessException("","�����˻�����Ϊ��");
		}
		// �Ƴ��·�
		if(StringUtils.isEmpty(content[3]) || content[3].length()>6){
			throw new BusinessException("","�Ƴ��·ݲ���Ϊ���ҳ��Ȳ��ܳ���6λ");
		}
		SimpleDateFormat format=new SimpleDateFormat("yyyyMM");
		try{
			format.parse(content[3]);
		}catch(Exception e){
			throw new BusinessException("","�Ƴ��·ݸ�ʽ����ȷ����ȷ�ĸ�ʽӦ��ΪYYYYMM");
		}
		// ֧�����
		if(StringUtils.isBlank(content[4]) || !NumberUtils.isNumber(content[4].trim())){
			throw new BusinessException("","֧������Ϊ�ղ��ұ���Ϊ����");
		}
		if (content[4].indexOf('.') >= 0) {
			if(content[4].substring(content[4].indexOf('.')+1).length()>2){
				throw new BusinessException("","֧��������Χ,ֻ֧�ֵ�С�������λ");
			}
			if (content[4].substring(0,content[4].indexOf('.')).length() > 8) {
				throw new BusinessException("","֧��������Χ,ֻ֧�ְ�λ����");
			}
		} else {
			if (content[4].length() > 8) {
				throw new BusinessException("","֧��������Χ,ֻ֧�ְ�λ����");
			}
		}
		// ֧��ʱ��
		if(!StringUtils.isEmpty(content[5])){
			SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try{
				format1.parse(content[5]);
			}catch(Exception e){
				throw new BusinessException("","֧��ʱ���ʽ����ȷ����ȷ�ĸ�ʽӦ��Ϊyyyy-MM-dd HH:mm:ss");
			}
		}
	}
}
