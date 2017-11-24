package com.sunrise.boss.ui.cms.reward.busitocom;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightVO;
import com.sunrise.boss.business.cms.reward.busitocom.persistent.BusitocomListVO;
import com.sunrise.boss.business.cms.reward.busitocom.persistent.BusitocomVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.reward.busitocom.BusitocomDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;


public class DelBusitocomBatchCheck extends BaseCheckFormat {

	public DelBusitocomBatchCheck() {
		super();
	}
	
	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	/**
	 * �ļ��е����ݼ��
	 */
	public void checkLine(String line, int rowCount, User user) throws Exception {

		if (rowCount > 10000) {
			throw new Exception("�ļ��������ܳ���10000��");
		}
		if (null == line || "".equals(line.trim())) {
			return;
		}

		String[] items = line.split("\\|");

		// �������
		if (items.length != 1) {
			throw new Exception("�ϴ�������������,ӦΪ1��,��鿴˵������!");
		}
		
		if (StringUtils.isEmpty(items[0])) {
			throw new BusinessException("", "��1�С���Ʒ��ʶ������Ϊ��!");
		}
		
		if (items[0].length()>18){
			throw new BusinessException("", "��1�С���Ʒ��ʶ�����Ȳ��ܳ���18λ!");
		}
		
		if (!NumberUtils.isNumber(items[0])) {
			throw new BusinessException("", "��1�С���Ʒ��ʶ������Ϊ����");
		}
		
		BusitocomVO vo = new BusitocomVO();
		BusitocomDelegate busidelegate = new BusitocomDelegate();
		BusitocomListVO listvo = new BusitocomListVO();
		listvo.set_ne_comid(items[0]);
		DataPackage dp = busidelegate.doQuery(listvo, user);
		if(dp!=null&&dp.getDatas().size()>0){
			vo = (BusitocomVO) ((List) dp.getDatas()).get(0);
			if(vo.getOpnid().trim().toString().substring(0, 4).equals("0403")){
				ProvincialrightVO rightvo = new ProvincialrightVO();
				rightvo.setProopr(user.getOpercode());
				rightvo.setRightid("CH_PW_TERMINALSELL");
				CommonDelegate delegate = new CommonDelegate(ProvincialrightVO.class);
				rightvo = (ProvincialrightVO) delegate.doFindByPk(rightvo, user);
				if (rightvo == null) {
					throw new BusinessException("","��ǰ���Ų���ɾ��[0403]��ͷ��ҵ��!");
				}
			}
		}
	}

	public static boolean checkDate(String date) {
		boolean ret = true;
		if (date.length() != 8)
			return false;
		try {
			SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
			sd.parse(date);
		} catch (Exception e) {
			return false;
		}
		return ret;
	}

	public static void main(String[] args) {

		DelBusitocomBatchCheck check = new DelBusitocomBatchCheck();

	}
}
