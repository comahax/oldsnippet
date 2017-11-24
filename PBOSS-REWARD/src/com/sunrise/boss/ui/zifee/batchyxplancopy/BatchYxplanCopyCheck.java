package com.sunrise.boss.ui.zifee.batchyxplancopy;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.zifee.yxplan.control.YxPlanControl;
import com.sunrise.boss.business.zifee.yxplan.control.YxPlanControlBean;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanListVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

/**
 * �̳�BaseCheckFormat����ʵ��ICheckFormat�ӿ�
 * 
 * @author zengjianxin
 */
public class BatchYxplanCopyCheck extends BaseCheckFormat {
	public BatchYxplanCopyCheck() {
		super();
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		if (null == line || "".equals(line)) {
			return;
		}
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		// �������
		if (items.length != 7) {
			throw new Exception("�ϴ�������������,ӦΪ7��,��鿴˵������!");
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		if (items[0] == null || "".equals(items[0].trim())
				|| "��".equals(items[0].trim())) {
			throw new Exception("[ģ��Ӫ��������ʶ]����Ϊ��!");
		}
		//������[��Ӫ��������ʶ]
		if (items[1] == null || "".equals(items[1].trim())
				|| "��".equals(items[1].trim())) {
			//throw new Exception("[��Ӫ��������ʶ]����Ϊ��!");
		}else{
//			��Ӫ��������ʶ��֤
			if (items[1].matches("\\d{14}")) {
				if(user.isProvinceUser()  && !items[1].substring(0, 3).equals("100") ){
					throw new Exception("[��Ӫ��������ʶ]ǰ3λ���Ϸ���ȫʡ����ǰ��λӦ��Ϊ100��");
				}
				if((items[1].substring(0, 3).equals(user.getCityid())) || (user.isProvinceUser() && "100".equals(items[1].substring(0, 3)))){
					YxPlanListVO params=new YxPlanListVO();
					params.set_ne_yxplanid(items[1].toString());
					YxPlanControl control=(YxPlanControl) ControlFactory.build(YxPlanControlBean.class);
					DataPackage dp=control.doQuery(params, user);
					if(dp.getDatas().size()>0){
						throw new Exception("��Ӫ��������ʶ�Ѵ���!");
					}
				}else{
					throw new Exception("[��Ӫ��������ʶ]ǰ3λ���Ϸ���ӦΪ����Ա���ڵ��б�ʶ��");
				}
			}else{
				throw new Exception("[��Ӫ��������ʶ]������Ϊ14λ�����ִ���");
			}
		}
		if (items[2] == null || "".equals(items[2].trim())
				|| "��".equals(items[2].trim())) {
			throw new Exception("[��Ӫ����������]����Ϊ��!");
		}
		if (items[3] == null || "".equals(items[3].trim())
				|| "��".equals(items[3].trim())) {
			throw new Exception("[����ʱ��]����Ϊ��!");
		}
		if (items[4] == null || "".equals(items[4].trim())
				|| "��".equals(items[4].trim())) {
			throw new Exception("[ͣ��ʱ��]����Ϊ��!");
		}
		if (items[5] == null || "".equals(items[5].trim())
				|| "��".equals(items[5].trim())) {
			throw new Exception("[Ӫ������˵��]����Ϊ��!");
		}
		if (items[6] == null || "".equals(items[6].trim())
				|| "��".equals(items[6].trim())) {
			throw new Exception("[��Ҫ���Ƶ���ϸ��]����Ϊ��!");
		}

		if (!items[0].matches("\\d{1,14}")) {
			throw new Exception("[ģ��Ӫ��������ʶ]������ȷΪ1-14λ���֣�");
		}
		
		
		if (items[2].trim().length() > 128) {
			throw new Exception("[��Ӫ����������]���Ȳ��ܴ���128��");
		}
		// ����ʱ��
		Date d2 = null;
		try {
			d2 = sdf.parse(items[3]);
		} catch (Exception e) {
			throw new Exception("[����ʱ��]��ʽ���ԣ���ȷ��ʽΪ[yyyy-MM-dd HH:mm:ss]");
		}

		// ����ʱ��
		Date d3 = null;
		try {
			d3 = sdf.parse(items[4]);
		} catch (Exception e) {
			throw new Exception("[ͣ��ʱ��]��ʽ���ԣ���ȷ��ʽΪ[yyyy-MM-dd HH:mm:ss]");
		}

		if (sdf.parse(items[4]).before(sdf.parse(items[3]))) {
			throw new Exception("[ͣ��ʱ��]������[����ʱ��]֮ǰ��");
		}

		if (items[5].trim().length() > 2000) {
			throw new Exception("[Ӫ������˵��]���Ȳ��ܴ���2000��");
		}
	}
}