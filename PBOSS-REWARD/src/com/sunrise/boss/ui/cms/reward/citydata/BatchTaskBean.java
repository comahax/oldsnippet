package com.sunrise.boss.ui.cms.reward.citydata;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.reward.citydata.persistent.CitydataListVO;
import com.sunrise.boss.business.cms.reward.citydata.persistent.CitydataVO;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.delegate.cms.reward.citydata.CitydataDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class BatchTaskBean extends BaseBatchTaskBean {
	private String remark;

	private String reasonkind;

	private String source;

	private String batchno;

	public BatchTaskBean() {
		try {
			SimpleDateFormat datetime = new SimpleDateFormat("yyyyMMddHHmmss");
			super.setWriteLog(true);
			super.setBatchName("�й�˾��Ч���ݵ���");
			batchno = datetime.format(new Date());
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
	}

	protected String doStart() {
		try {
			CitydataDelegate delegate = new CitydataDelegate();
//			CitydataListVO listVO = new CitydataListVO();
//			listVO.getQueryConditions().put("_se_calcmonth", getLastmonth());
//			listVO.getQueryConditions().put("_ne_state", "0");
//			Iterator iterator = delegate.doQuery(listVO, user).getDatas().iterator();
//			while(iterator.hasNext()){
//				CitydataVO vo = (CitydataVO)iterator.next();
//				vo.setState(new Short((short)-2));
//				delegate.doUpdate(vo, user);
//			}
			
			delegate.clearAll(user);
		} catch (Exception e) {
			log.error("�����ϴε��������ʱ����" + e.getMessage());
		}
		return "��� | ����ҵ����� | ҵ�������� | ҵ����ʱ�� | ҵ����BOSS���� | ҵ�������� | ���뷢��ҵ���� |Ʒ�� | ������� | ������Ϣ"
				+ "\r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		String op = "����";
		try {
			CitydataVO citydataVO = setVO(items);
			CitydataDelegate delegate = new CitydataDelegate();
			if(citydataVO.getValidflag().intValue() == 1){
				delegate.doCreate(citydataVO, user);
			}else{
				CitydataListVO listVO = new CitydataListVO();
				listVO.getQueryConditions().put("_se_opnid", citydataVO.getOpnid());
				listVO.getQueryConditions().put("_ne_rewardtype", citydataVO.getRewardtype());
				Iterator iterator = delegate.doQuery(listVO, user).getDatas().iterator();
				while(iterator.hasNext()){
					CitydataVO vo = (CitydataVO) iterator.next();
					vo.setState(new Short((short)-2));
					delegate.doUpdate(vo, user);
				}
				op = "�޸�";
			}
			resultVO.setOk(true);
			resultVO.setInfo(showInfo(resultVO, items, rowCount, op));
			return resultVO;
		} catch (Exception ex) { // ����ʧ��
			ex.printStackTrace();
			msg = ex.getMessage();
			resultVO.setOk(false);
			resultVO.setInfo(showInfo(resultVO, items, rowCount, op) + msg);
			return resultVO;
		}
	}

	/**
	 * ����ļ���ʽ
	 */
	public String showInfo(ResultVO resultVO, String[] items, int rowCount,
			String op) {
		final String COMPART = " | "; // �ָ�
		StringBuffer resultStr = new StringBuffer();
		// ���
		resultStr.append(rowCount).append(COMPART);
		for (int i = 0; i < items.length; i++) {
			resultStr.append(items[i]).append(COMPART);
		}
		resultStr.append(op);
		// ������
		if (resultVO.isOk()) {
			resultStr.append("�ɹ�");
		} else {
			resultStr.append("ʧ��");
		}
		resultStr.append(COMPART);
		return resultStr.toString();
	}

	/**
	 * ����ҵ�����|ҵ��������|ҵ����ʱ��|ҵ����BOSS����|ҵ��������|���뷢��ҵ����|Ʒ��|�������
	 * 
	 * @param items
	 * @return
	 * @throws Exception
	 */
	private CitydataVO setVO(String[] items) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		CitydataVO citydataVO = new CitydataVO();
		citydataVO.setOpnid(items[0].trim());
		citydataVO.setValidflag(new Short((short)1));
		citydataVO.setRewardtype(new Short(items[7].trim()));
		citydataVO.setCalcmonth(getLastmonth());
		citydataVO.setWayid(items[1].trim());
		citydataVO.setOprtime(sdf.parse(items[2].trim()));
		citydataVO.setOprcode(items[3].trim());
		citydataVO.setMobile(items[4].trim());
		citydataVO.setBusivalue(new Double(items[5].trim()));
		citydataVO.setBrand(new Short(items[6].trim()));
		
		String path = ((BatchCitydataForm) getForm()).getFilename();
		String fname = path.substring(path.lastIndexOf("/")  + 1, path.length());
		citydataVO.setDatasource(fname);
		
		citydataVO.setRemark(((BatchCitydataForm) getForm()).getRemark());
		citydataVO.setCityid(SessionFactoryRouter.conversionCityid(user
				.getCityid()));
		citydataVO.setCreatetime(new Date());
		citydataVO.setCreatecode(user.getOpercode());
		citydataVO.setBatchno(user.getCityid() + batchno);
		citydataVO.setState(new Short((short) 0));
		return citydataVO;
	}

	private String getLastmonth() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
		calendar.set(Calendar.DATE, 1);
		return sdf.format(calendar.getTime()).substring(0, 6);
	}
}
