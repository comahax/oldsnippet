package com.sunrise.boss.ui.cms.mendregister;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import com.sunrise.boss.business.cms.mendregister.persistent.MendregisterVO;
import com.sunrise.boss.business.cms.registersim.persistent.RegistersimVO;
import com.sunrise.boss.business.resmanage.nosect.control.NosectControl;
import com.sunrise.boss.business.resmanage.nosect.control.NosectControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.employee.EmployeeDelegate;
import com.sunrise.boss.delegate.cms.mendregister.MendregisterDelegate;
import com.sunrise.boss.delegate.cms.registersim.RegistersimDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.pub.tools.PublicUtils;

public class BatchTaskBean extends BaseBatchTaskBean {
	MendregisterDelegate mdelegate;
	EmployeeDelegate edelegate;
	RegistersimDelegate rdelegate;

	public BatchTaskBean() {
		try {
			mdelegate = new MendregisterDelegate();
			edelegate = new EmployeeDelegate();
			rdelegate = new RegistersimDelegate();
			batchName = "�׿����۲��Ǽ�";
			setWriteLog(true);
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
	}

	protected String doStart() {
		return "��� | �׿����� | �׿�����ʱ��(yyyymmdd) | ��������� | �Ƿ�ɹ� | ʧ��ԭ��"
				+ "\r\n";
	}

	/**
	 * ����һ����¼
	 */
	public ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		MendregisterVO mvo = new MendregisterVO();
		RegistersimVO rvo = new RegistersimVO();
		try{
			//�ֻ������ڸ�ʽУ��
			if(!checkMobile(items[0]) || !checkMobile(items[2]) || !checkDate(items[1])){
				mvo.setMobile(items[0]);
				mvo.setOfficetel(items[2]);
				mvo.setOptime(new Date());
				mvo.setOprcode(user.getOpercode());
				mvo.setSuccess(new Short("1"));
				mvo.setAdtremark("��ʽ����");
				mdelegate.doCreate(mvo, user);
				throw new BusinessException("","��ʽ����");
			}
			//����Ƿ��ǵ���
			if(!checkMonth(items[1])){
				mvo.setMobile(items[0]);
				mvo.setOfficetel(items[2]);
				mvo.setSelltime(PublicUtils.strToSqlDate(items[1], "yyyyMMdd"));
				mvo.setOptime(new Date());
				mvo.setOprcode(user.getOpercode());
				mvo.setSuccess(new Short("1"));
				mvo.setAdtremark("���ܲ��Ǽ����µ����ۼ�¼");
				mdelegate.doCreate(mvo, user);
				throw new BusinessException("","���ܲ��Ǽ����µ����ۼ�¼");
			}
			//���31�������ظ��ǼǼ�¼
			if(mdelegate.checkIfExistIn31Days(items[0], PublicUtils.strToSqlDate(items[1], "yyyyMMdd"), user)){
				mvo.setMobile(items[0]);
				mvo.setOfficetel(items[2]);
				mvo.setSelltime(PublicUtils.strToSqlDate(items[1], "yyyyMMdd"));
				mvo.setOptime(new Date());
				mvo.setOprcode(user.getOpercode());
				mvo.setSuccess(new Short("1"));
				mvo.setAdtremark("�����ظ��ǼǼ�¼");
				mdelegate.doCreate(mvo, user);
				throw new BusinessException("","�����ظ��ǼǼ�¼");
			}
			//����Ա��������Ч��
			if(!edelegate.mobileEmployeeQuery(items[2], user)){
				mvo.setMobile(items[0]);
				mvo.setOfficetel(items[2]);
				mvo.setSelltime(PublicUtils.strToSqlDate(items[1], "yyyyMMdd"));
				mvo.setOptime(new Date());
				mvo.setOprcode(user.getOpercode());
				mvo.setSuccess(new Short("1"));
				mvo.setAdtremark("��Ա��������Ч");
				mdelegate.doCreate(mvo, user);
				throw new BusinessException("","��Ա��������Ч");
			}
			//�жϡ��׿����롯�����Ƿ�Ϊ������
			NosectControl ncontrol = (NosectControl)ControlFactory
				.build(NosectControlBean.class);
			String bossarea = ncontrol.doQueryCityID(items[0], user);
			if(!bossarea.equals(user.conversionCityid())){
			//if(!bossarea.equals(user.getCityid())){
				mvo.setMobile(items[0]);
				mvo.setOfficetel(items[2]);
				mvo.setSelltime(PublicUtils.strToSqlDate(items[1], "yyyyMMdd"));
				mvo.setOptime(new Date());
				mvo.setOprcode(user.getOpercode());
				mvo.setSuccess(new Short("1"));
				mvo.setAdtremark("�Ǳ������׿�");
				mdelegate.doCreate(mvo, user);
				throw new BusinessException("","�Ǳ������׿�");
			}
			mvo.setMobile(items[0]);
			mvo.setOfficetel(items[2]);
			mvo.setSelltime(PublicUtils.strToSqlDate(items[1], "yyyyMMdd"));
			mvo.setOptime(new Date());
			mvo.setOprcode(user.getOpercode());
			mvo.setSuccess(new Short("2"));
			mvo.setAdtremark("��ÿ��һ��ͳһ���ǼǴ���");
			mdelegate.doCreate(mvo, user);
			
//			EmployeeListVO elistvo = new EmployeeListVO();
//			elistvo.set_se_officetel(items[2]);
//			DataPackage edp = edelegate.mobileEmployeeQuery(elistvo, user);
//			List list = (List) edp.getDatas();
//			EmployeeVO employeevo = (EmployeeVO) list.get(0);
//			rvo.setCityid(user.getCityid());
//			rvo.setOprcode(employeevo.getOprcode2());
//			rvo.setWayid(employeevo.getWayid());
//			rvo.setMobile(items[0]);
//			rvo.setPosvalid("00");
//			rvo.setPosdiff(new Short("-1"));
//			rvo.setAddtime(new Date());
//			rvo.setOprtime(PublicUtils.strToSqlDate(items[1], "yyyyMMdd"));
//			rvo.setMendfalg(new Short("2"));
//			rvo.setMendtime(new Date());
//			rdelegate.doCreate(rvo, user);
			
			resultVO.setOk(true);
			resultVO.setInfo(showInfo(resultVO, items, rowCount));
			return resultVO;
		}catch (Exception ex) { // ����ʧ��
			msg = ex.getMessage();
			resultVO.setOk(false);
			resultVO.setInfo(showInfo(resultVO, items, rowCount) + msg);
			return resultVO;
		}
	}

	/**
	 * ����ļ���ʽ
	 */
	public String showInfo(ResultVO resultVO, String[] items, int rowCount) {
		final String COMPART = " | "; // �ָ�
		StringBuffer resultStr = new StringBuffer();
		// ���
		resultStr.append(rowCount).append(COMPART);
		resultStr.append(items[0]).append(COMPART);
		resultStr.append(items[1]).append(COMPART);
		resultStr.append(items[2]).append(COMPART);

		// ������
		if (resultVO.isOk()) {
			resultStr.append("�ɹ�");
		} else {
			resultStr.append("ʧ��");
		}
		resultStr.append(COMPART);
		return resultStr.toString();
	}
	
	//����Ƿ���11λ����
	public boolean checkMobile(String mobile){
		try {
			if(mobile.length()!=11){
				return false;
			}
			Double temp = Double.valueOf(mobile);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	//����Ƿ���yyyyMMdd��ʽ�����ַ���
	public boolean checkDate(String date){
		return PublicUtils.checkDateTime(2, date, "", ":", " ");
	}
	
	//����Ƿ��ǵ���
	public boolean checkMonth(String date){
		try {
			String thismonth = PublicUtils.formatUtilDate(new Date(), "yyyyMM");
			String datetemp = date.substring(0, 6);
			return (datetemp.equals(thismonth));
		} catch (Exception e) {
			return false;
		}
	}
}
