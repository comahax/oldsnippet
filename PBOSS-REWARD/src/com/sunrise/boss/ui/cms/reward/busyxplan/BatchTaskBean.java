package com.sunrise.boss.ui.cms.reward.busyxplan;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanVO;
import com.sunrise.boss.business.cms.reward.busyxplan.persistent.BusyxplanListVO;
import com.sunrise.boss.business.cms.reward.busyxplan.persistent.BusyxplanVO;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.delegate.zifee.yxplan.YxPlanDelegate;
import com.sunrise.boss.delegate.cms.reward.busyxplan.BusyxplanDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class BatchTaskBean extends BaseBatchTaskBean {
	private BusyxplanDelegate delegate;
	private YxPlanDelegate yxDel;

	public BatchTaskBean() throws Exception {
		super.setBatchName("Ӫ��������ȫʡͳһҵ���������");
		super.setWriteLog(true);
		delegate = new BusyxplanDelegate();
		yxDel = new YxPlanDelegate();
		// TODO Auto-generated constructor stub
	}

	protected String doStart() {
		return "Ӫ��������ȫʡͳһҵ��������ý�� \r\n";
	}

	/**
	 * ����һ����¼
	 */
	protected ResultVO processLine(String line, int rowCount) {
		String[] propertyname = new String[] { "opnid", "yxplanid", "wrapfee",
				"wayid", "planbusitype", "noncyc", "prodid" };
		ResultVO resultVO = new ResultVO();
		// resultVO.setInfo(line);
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		try {
			BusyxplanVO busyVO = new BusyxplanVO();
			busyVO.setOpnid(content[0]);
			if (StringUtils.isBlank(content[1])
					&& StringUtils.isBlank(content[6])) {
				throw new Exception("Ӫ��������ʶ�Ͳ�Ʒ��ʶ����ͬʱΪ��");
			} else {
				if (!StringUtils.isBlank(content[1])) {
					busyVO.setYxplanid(new Long(content[1]));
				} else if (!StringUtils.isBlank(content[6])) {
					busyVO.setProdid(content[6]);
				}
			}
			if (!StringUtils.isBlank(content[2])) {
				busyVO.setWrapfee(new Double(content[2]));
			}
			busyVO.setWayid(content[3]);
			busyVO.setPlanbusitype(content[4]);
			if (null != content[5] && !("").equals(content[5])) {
				busyVO.setNoncyc(Long.parseLong(content[5]));
			}
			if (!StringUtils.isBlank(content[6])) {
				busyVO.setCityid(user.getCityid());
			} else if (!StringUtils.isBlank(content[1])) {
				if (!("").equals(busyVO.getYxplanid())
						&& null != busyVO.getYxplanid()) {
					YxPlanVO yxVO = yxDel
							.doFindByPk(busyVO.getYxplanid(), user);
					if (yxVO == null) {
						throw new Exception("[Ӫ����������]������ϵͳ�д���");
					} else {
						busyVO.setCityid(yxVO.getAreacode());
					}
				}
			}
			BusyxplanListVO busyvo = new BusyxplanListVO();
			busyvo.set_se_opnid(content[0]);
			List yxPlantemp = new ArrayList();
			List prodidtemp = new ArrayList();
			BusyxplanDelegate busyDelegate = new BusyxplanDelegate();
			if (!"".equals(content[1]) && null != content[1]) {
				busyvo.set_ne_yxplanid(content[1]);
				busyVO.setYxplanid(Long.parseLong(content[1]));
				yxPlantemp = (List) busyDelegate.doQuery(busyvo, user)
						.getDatas();

			}
			if (!"".equals(content[6]) && null != content[6]) {
				busyvo.set_se_prodid(content[6]);
				busyVO.setProdid(content[6]);
				prodidtemp = (List) busyDelegate.doQuery(busyvo, user)
						.getDatas();
			}

			if (!yxPlantemp.isEmpty() || !prodidtemp.isEmpty()) {
				throw new Exception("��ҵ���Ӧ��Ӫ��������ʶ/��Ʒ��ʶ�Ѵ��ڣ���������±���!");
			} else {
				delegate.doCreate(busyVO, user);
			}

			line = rowCount + "   " + line + "    �ɹ�";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		} catch (Exception e) {
			if (e instanceof NumberFormatException) {
				line = rowCount + "   " + line + "    ������Ϣ:" + e.getMessage()
						+ "Ӧ��������";
			} else {
				line = rowCount + "   " + line + "    ������Ϣ:" + e.getMessage();
			}
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
}
