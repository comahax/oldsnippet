package com.sunrise.boss.ui.zifee.batchyxplancopy;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.business.cms.common.AuditUtils;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.delegate.zifee.yxplan.YxPlanDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

/**
 * @author zengjianxin
 */
public class BatchTaskBean extends BaseBatchTaskBean {
	YxPlanDelegate delegate;

	public BatchTaskBean() {
		try {
			delegate = new YxPlanDelegate();
			batchName = "营销方案批量复制";
			setWriteLog(true);
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
	}

	protected String doStart() {
		BatchYxplanCopyForm batchyxplancopyForm = (BatchYxplanCopyForm) form;
		return "序号 | 模版营销方案标识 | 新营销方案标识 | 新营销方案名称 | 启动时间 | 停用时间 | 营销方案说明 | 需要复制的明细串 | 操作类型 | 操作结果 | 操作结果描述"
				+ "\r\n";
	}

	/**
	 * 处理一条记录
	 */
	public ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		String op = "增加";

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		YxPlanVO vo = new YxPlanVO();
		try {
			vo = delegate.doFindByPk(new Long(items[0]), user);
			if (vo == null) {
				throw new Exception("模版营销方案标识不存在!");
			}
			if (user.getCityid() == null || "".equals(user.getCityid())) {
				throw new Exception("当前登陆工号的区域标识为空，要求不能为空!");
			}
			String yxplanid=null;
			if (isNull(items[1].trim())) {
//				String seq = delegate.getYxplanSeq(user).toString();
//				yxplanid = user.getCityid()+ StringUtils.repeat("0", 11 - seq.length()) + seq;
				yxplanid=delegate.doGetYxplanID(user).toString();
			}else{
				yxplanid = items[1];
			}
			vo.setYxplanid(new Long(yxplanid));
			vo.setYxplanname(items[2]);// 营销方案名称
			vo.setAreacode(user.getCityid());// 区域标识
			vo.setOperatorcode(user.getOpercode());// 操作工号
			vo.setCheckercode(user.getOpercode());// 审核工号
			vo.setStartdate(isNull(items[3].trim()) ? null : format
					.parse(items[3]));// 启动时间
			vo.setStopdate(isNull(items[4].trim()) ? null : format
					.parse(items[4]));// 停用时间
			vo.setRemark(items[5]);// 营销方案说明

			String list = "";
			AuditUtils auditutils = new AuditUtils();

			if ("*".equals(items[6].trim())) {
				CommonDelegate dictitemDelegate = new CommonDelegate(
						DictitemVO.class);
				DictitemListVO listvo = new DictitemListVO();
				listvo.set_se_groupid("PC_YXPLANCOPYITEM");
				listvo.set_pagesize("");
				DataPackage dataPack = dictitemDelegate.doQuery(listvo, user);
				dataPack.setPageSize(40);
				if (dataPack.getRowCount() >= 0) {
					Collection col = dataPack.getDatas();
					Iterator it = col.iterator();
					for (int i = 0; i < dataPack.getRowCount(); i++) {
						list = list + ((DictitemVO) it.next()).getDictid()
								+ ",";
					}
					list = list.substring(0, list.length() - 1);
				}
			} else {
				String[] lists = StringUtils.splitPreserveAllTokens(items[6],
						",");
				for (int i = 0; i < lists.length; i++) {
					if (!auditutils.doCheckSystemParam("PC_YXPLANCOPYITEM",
							lists[i], user)) {
						throw new Exception("复制明细数字串中含有无法匹配的复制明细" + lists[i]);
					}
				}
				list = items[6];
			}

			delegate.doSinglecopy(items[0], list, vo, false,filename, user);

			resultVO.setOk(true);
			resultVO.setInfo(showInfo(resultVO, items, rowCount, op,yxplanid));
			return resultVO;

		} catch (Exception ex) { // 插入失败
			msg = ex.getMessage();
			resultVO.setOk(false);
			resultVO.setInfo(showInfo(resultVO, items, rowCount, op , "") + msg);
			return resultVO;
		}
	}

	/**
	 * 结果文件格式
	 */
	public String showInfo(ResultVO resultVO, String[] items, int rowCount,
			String op,String newyxplanid) {
		final String COMPART = " | "; // 分隔
		StringBuffer resultStr = new StringBuffer();
		// 序号
		resultStr.append(rowCount).append(COMPART);
		resultStr.append(items[0]).append(COMPART);
		resultStr.append(newyxplanid).append(COMPART);
		resultStr.append(items[2]).append(COMPART);
		resultStr.append(items[3]).append(COMPART);
		resultStr.append(items[4]).append(COMPART);
		resultStr.append(items[5]).append(COMPART);
		resultStr.append(items[6]).append(COMPART);

		resultStr.append(op);
		resultStr.append(COMPART);
		// 办理结果
		if (resultVO.isOk()) {
			resultStr.append("成功");
		} else {
			resultStr.append("失败");
		}
		resultStr.append(COMPART);
		return resultStr.toString();
	}

	private boolean isNull(String item) {
		return "".equals(item) || "null".equals(item) || "空".equals(item);
	}
}
