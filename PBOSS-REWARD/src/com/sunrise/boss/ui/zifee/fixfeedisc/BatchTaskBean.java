package com.sunrise.boss.ui.zifee.fixfeedisc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sunrise.boss.business.zifee.fixfeedisc.persistent.PcPsFixfeediscListVO;
import com.sunrise.boss.business.zifee.fixfeedisc.persistent.PcPsFixfeediscVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.fee.woff.acct.AcctDelegate;
import com.sunrise.boss.delegate.zifee.fixfeedisc.FixfeediscDelegate;
import com.sunrise.boss.delegate.zifee.yxplan.YxPlanDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class BatchTaskBean extends BaseBatchTaskBean {
	private static Log log = LogFactory.getLog(BatchTaskBean.class);

	private FixfeediscDelegate delegate;

	private final String SEPARATOR = "|";

	/*
	 * 操作类型（0新增、1修改、2删除）
	 */
	private int operType = 0;

	public BatchTaskBean() {
		try {
			delegate = new FixfeediscDelegate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected String doStart() {
		this.operType = Integer.parseInt(parameterMap.get("operType")
				.toString());
		if (log.isDebugEnabled())
			log.debug("=====================操作类型：" + this.operType
					+ "（0新增、1修改、2删除）================");
		if (this.operType == 0)
			return "营销方案标识|帐单科目标识|优惠方式|折扣|应优惠金额|状态|" + "\r\n";
		else
			return "固定费优惠标识|营销方案标识|帐单科目标识|优惠方式|折扣|应优惠金额|状态|" + "\r\n";
	}

	/**
	 * 处理一条记录
	 */
	public ResultVO processLine(String line, int rowCount) {
		if (log.isDebugEnabled())
			log.debug("=====================" + rowCount + "：" + line
					+ "================");
		String[] items = line.split("\\|");
		ResultVO resultVO = new ResultVO();
		String state = "失败";
		resultVO.setOk(false);
		try {
			if (this.operType == 0) {
				if (!isYxPlanIdExist(items, user))
					throw new BusinessException("", "不存在该营销方案标识！");
				if (!isAcctIdExist(items, user))
					throw new BusinessException("", "不存在该账单科目标识！");
				if (isExist(items, user))
					throw new BusinessException("", "已存在相同的营销方案和账单科目的记录！");
				PcPsFixfeediscVO vo = new PcPsFixfeediscVO();
				vo.setYxplanid(new Long(items[0].trim()));
				vo.setAcctid(new Long(items[1].trim()));
				vo.setDisctype(new Long(items[2].trim()));
				vo.setRecdisamt(new Float(items[4].trim()));
				vo.setDisccount(new Float(items[3].trim()));
				delegate.doCreate(vo, user);
				resultVO.setOk(true);
				state = "成功";
			} else if (this.operType == 1) {
				if (!isYxPlanIdExist(items, user))
					throw new BusinessException("", "不存在该营销方案标识！");
				PcPsFixfeediscVO vo = delegate.doFindByPk(new Long(items[0].trim()),
						user);
				if (vo == null)
					throw new BusinessException("", "不存在该固定费优惠记录！");
				if (!vo.getYxplanid().toString().equals(items[1].trim()))
					throw new BusinessException("", "修改记录的营销方案标识["
							+ vo.getYxplanid().toString() + "]与文本文件内的营销方案标识["
							+ items[1] + "]不一致！");
				vo.setAcctid(new Long(items[2].trim()));
				vo.setDisctype(new Long(items[3].trim()));
				vo.setDisccount(new Float(items[4].trim()));
				vo.setRecdisamt(new Float(items[5].trim()));
				delegate.doUpdate(vo, user);
				resultVO.setOk(true);
				state = "成功";
			}
		} catch (BusinessException be) {
			state = "失败：" + be.getMessage();
		} catch (Exception e) {
			state = "失败"+e.getMessage();
		}
		StringBuffer sb = genOptInfo(rowCount, items, state);
		resultVO.setInfo(sb.toString());
		return resultVO;
	}

	private StringBuffer genOptInfo(int rowCount, String[] items, String state) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < items.length; i++) {
			sb.append(items[i]);
			sb.append(SEPARATOR);
		}
		sb.append(state);
		sb.append(SEPARATOR);
		return sb;
	}

	/*
	 * 检查营销方案标识是否合法（包括字段类型检查和存在性检查）
	 */
	private boolean isYxPlanIdExist(String[] items, User user) throws Exception {
		YxPlanDelegate yxPlanDelegate = new YxPlanDelegate();
		Object obj = yxPlanDelegate.doFindByPk(new Long(items[this.operType].trim()),
				user);
		if (obj != null)
			return true;
		else
			return false;
	}

	/*
	 * 检查账单科目标识是否合法（包括字段类型检查和存在性检查）
	 */
	private boolean isAcctIdExist(String[] items, User user) throws Exception {
		AcctDelegate acctDelegate = new AcctDelegate();
		Object obj = acctDelegate.doFindByPk(
				new Long(items[this.operType + 1].trim()), user);
		if (obj != null)
			return true;
		else
			return false;
	}

	/*
	 * 检查是否存在相同的营销方案和账单科目的记录
	 */
	private boolean isExist(String[] items, User user) throws Exception {
		PcPsFixfeediscListVO listVO = new PcPsFixfeediscListVO();
		listVO.set_pagesize(null);
		listVO.set_pageno(null);
		listVO.set_ne_yxplanid(items[0].trim());
		listVO.set_ne_acctid(items[1].trim());
		DataPackage datas = delegate.doQuery(listVO, user);
		if (datas.getRowCount() > 0)
			return true;
		else
			return false;
	}

}
