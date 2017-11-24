package com.sunrise.boss.ui.cms.reward.busiwayrel;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.busicityload.persistent.BusicityloadListVO;
import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.business.cms.reward.busiwayrel.persistent.BusiwayrelVO;
import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.busicityload.BusicityloadDelegate;
import com.sunrise.boss.delegate.cms.reward.busiwayrel.BusiwayrelDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;

import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.boss.ui.commons.User;

public class BusiwayrelBatchCheck extends BaseCheckFormat {
	private WayDelegate wayDelegate = null;

	private BusiwayrelDelegate delegate = null;

	private BusicityloadDelegate busicityloadDelegate = null;

	public BusiwayrelBatchCheck() {
		super();
	}

	private String oprType;

	private static final Log log = LogFactory.getLog(BusiwayrelBatchCheck.class);

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}

		try {
			if (parameterMap.get("oprType") != null
					&& !"".equals((String) parameterMap.get("oprType"))) {
				setOprType((String) parameterMap.get("oprType"));
			}
			if (log.isInfoEnabled()) {
				log.info(oprType);
			}
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw ex;
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
		
		String[] items = CheckUtil.splitPreserveAllTokens(line);
		// �������
		if (items.length != 2) {
			throw new Exception("�ϴ�������������,ӦΪ2��,��鿴˵������!");
		}
		if (!CheckUtil.checkString(items[0], 18, false)) {
			throw new Exception("[ҵ�����]����Ϊ��,���ҳ��Ȳ��ܳ���18λ.");
		}
		if (!CheckUtil.checkString(items[1], 18, false)) {
			throw new Exception("[��Ƴ���������]����Ϊ��,���ҳ��Ȳ��ܳ���18λ.");
		}
		// step1 (����Ƿ�������)����Ƿ�ɾ�������ڵļ�¼���������Ѿ����ڵļ�¼
		if ("1".equals(getOprType())) {
			checkProcess(user, items);
		}
		// step3
		// ����Ƿ��������
		checkWay(user, items);
		// step4 ҵ��У�� 3�� ��ҵ����롱Ϊ�ϼ�ҵ��
		checkBusi(user, items);

	}

	private void checkBusi(User user, String[] items) throws BusinessException, Exception {
		if (StringUtils.isEmpty(items[0])) {
			throw new BusinessException("", "ҵ����벻��Ϊ��");
		}
		//�жϱ����Ƿ���,����ǲ��,����Ҫ����Ƿ��ϼ�.
		if (!getDelegate().checkIsLayer(items[0], user)) {
			BusicityloadDelegate citydelegate = new BusicityloadDelegate();
			DataPackage dp;
			BusicityloadListVO listVO = new BusicityloadListVO();
			listVO.set_se_opnid(items[0]);
			listVO.set_se_cityid(user.getCityid());
			dp = citydelegate.doQuery(listVO, user);
			if (dp.getDatas().size() < 1) {
				throw new BusinessException("", "�ϴ�ʧ�ܣ���ҵ��[" + items[0] + "]δ�ڱ������ϼܣ����Ƚ���ҵ���ϼܲ�����");
			}
		}
	}

	/**
	 * ���������ɾ����ʱ��
	 * 
	 * @param user
	 * @param items
	 * @throws Exception
	 * @throws BusinessException
	 */
	private void checkProcess(User user, String[] items) throws Exception, BusinessException {
		BusiwayrelVO wayrelvo = new BusiwayrelVO();
		wayrelvo.setOpnid(items[0].trim());
		wayrelvo.setWayid(items[1].trim());
		if (getDelegate().doFindByPk(wayrelvo, user) != null) {
			throw new BusinessException("", "�ϴ�ʧ�ܣ���¼��ϵͳ�Ѵ��ڡ�");
		}
	}

	/**
	 * 
	 * @param user
	 * @param items
	 * @throws Exception
	 * @throws BusinessException
	 */
	private void checkWay(User user, String[] items) throws Exception, BusinessException {
		if (StringUtils.isBlank(items[1])) {
			throw new BusinessException("", "�����������벻��Ϊ��");
		}
		String msg = "�ϴ�ʧ��,���Ǳ����е��������������������";
		WayVO wayVO = new WayVO();
		wayVO = getWayDelegate().doFindByPk(items[1].trim(), user);
		if (wayVO == null) {
			throw new Exception(msg);
		} else if (!"AG".equals(wayVO.getWaytype())) {
			throw new Exception(msg);
		}
		// ��Ҫ�����б���
		else if (wayVO.getCityid() != null) {
			if (!wayVO.getCityid().equals(SessionFactoryRouter.conversionCityid(user.getCityid()))) {
				throw new Exception(msg);
			}
		}
		if (wayVO.getCityid() == null) {
			throw new Exception("���б�־�ֶ��쳣:Ϊ��");
		}
	}

	public BusicityloadDelegate getBusicityloadDelegate() throws Exception {
		if (busicityloadDelegate == null) {
			busicityloadDelegate = new BusicityloadDelegate();
		}
		return busicityloadDelegate;
	}

	public BusiwayrelDelegate getDelegate() throws Exception {
		if (delegate == null) {
			delegate = new BusiwayrelDelegate();
		}
		return delegate;
	}

	public WayDelegate getWayDelegate() throws Exception {
		if (wayDelegate == null) {
			wayDelegate = new WayDelegate();
		}
		return wayDelegate;
	}

	public String getOprType() {
		return oprType;
	}

	public void setOprType(String oprType) {
		this.oprType = oprType;
	}

}
