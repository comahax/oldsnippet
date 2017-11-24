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
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
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
	 * 文件行的内容检查
	 */
	public void checkLine(String line, int rowCount, User user) throws Exception {

		if (rowCount > 10000) {
			throw new Exception("文件行数不能超过10000行");
		}
		if (null == line || "".equals(line.trim())) {
			return;
		}
		
		String[] items = CheckUtil.splitPreserveAllTokens(line);
		// 检查列数
		if (items.length != 2) {
			throw new Exception("上传数据列数不对,应为2列,请查看说明帮助!");
		}
		if (!CheckUtil.checkString(items[0], 18, false)) {
			throw new Exception("[业务编码]不能为空,并且长度不能超过18位.");
		}
		if (!CheckUtil.checkString(items[1], 18, false)) {
			throw new Exception("[需计酬渠道编码]不能为空,并且长度不能超过18位.");
		}
		// step1 (检查是否已设置)检测是否删除不存在的记录或者新增已经存在的记录
		if ("1".equals(getOprType())) {
			checkProcess(user, items);
		}
		// step3
		// 检测是否社会渠道
		checkWay(user, items);
		// step4 业务校验 3、 “业务编码”为上架业务
		checkBusi(user, items);

	}

	private void checkBusi(User user, String[] items) throws BusinessException, Exception {
		if (StringUtils.isEmpty(items[0])) {
			throw new BusinessException("", "业务编码不能为空");
		}
		//判断编码是否层次,如果是层次,则不需要检测是否上架.
		if (!getDelegate().checkIsLayer(items[0], user)) {
			BusicityloadDelegate citydelegate = new BusicityloadDelegate();
			DataPackage dp;
			BusicityloadListVO listVO = new BusicityloadListVO();
			listVO.set_se_opnid(items[0]);
			listVO.set_se_cityid(user.getCityid());
			dp = citydelegate.doQuery(listVO, user);
			if (dp.getDatas().size() < 1) {
				throw new BusinessException("", "上传失败，该业务[" + items[0] + "]未在本地市上架，请先进行业务上架操作。");
			}
		}
	}

	/**
	 * 检测新增和删除的时候
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
			throw new BusinessException("", "上传失败，记录在系统已存在。");
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
			throw new BusinessException("", "导入渠道代码不能为空");
		}
		String msg = "上传失败,不是本地市的社会渠道或渠道不存在";
		WayVO wayVO = new WayVO();
		wayVO = getWayDelegate().doFindByPk(items[1].trim(), user);
		if (wayVO == null) {
			throw new Exception(msg);
		} else if (!"AG".equals(wayVO.getWaytype())) {
			throw new Exception(msg);
		}
		// 还要检测地市编码
		else if (wayVO.getCityid() != null) {
			if (!wayVO.getCityid().equals(SessionFactoryRouter.conversionCityid(user.getCityid()))) {
				throw new Exception(msg);
			}
		}
		if (wayVO.getCityid() == null) {
			throw new Exception("地市标志字段异常:为空");
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
