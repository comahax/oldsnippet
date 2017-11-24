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
			throw new BusinessException("","Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}
	
	public void checkLine(String line, int rowCount, User user) throws Exception {
		
		String[] content = StringSplit.split(line, "|");
		WayDelegate waydelegate=new WayDelegate();
		if (content.length < 3) {
			throw new BusinessException("","�ϴ�ʧ��,�ļ���ʽ����ȷ,��"+rowCount+"��Ӧ��Ϊ3��");
		}
		
		if(StringUtils.isEmpty(content[0])){
			throw new BusinessException("","��"+rowCount+"��������벻��Ϊ��");
		}
		if(StringUtils.isEmpty(content[1])){
			throw new BusinessException("","��"+rowCount+"�м���������޵Ŀ�ʼʱ�䲻��Ϊ��");
		}
		if(StringUtils.isEmpty(content[2])){
			throw new BusinessException("","��"+rowCount+"�б�ע����Ϊ��");
		}
		
		if(content[2].getBytes().length > 255){
			throw new BusinessException("","��"+rowCount+"�б�ע��������,���ܳ���255���ַ�!");
		}
		
		WayVO wayvo=waydelegate.doFindByPk(content[0], user);
		if(wayvo==null || !"AG".equals(wayvo.getWaytype())){
			throw new BusinessException("","�ϴ�ʧ�ܣ���"+rowCount+"���������["+content[0]+"]�����ڻ����������");
		}
		
		if(!PublicUtils.checkDateTime(2, content[1], null, null, null)){
			throw new BusinessException("","�ϴ�ʧ�ܣ���"+rowCount+"�м���������޵Ŀ�ʼʱ��(YYYYMMDD)["+content[1]+"]���Ϸ�");
		}
		
	}
	
}
