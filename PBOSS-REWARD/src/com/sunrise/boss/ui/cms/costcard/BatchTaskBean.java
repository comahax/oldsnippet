package com.sunrise.boss.ui.cms.costcard;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.adimarea.persistent.AdimareaVO;
import com.sunrise.boss.business.cms.costcard.persistent.CostcardListVO;
import com.sunrise.boss.business.cms.costcard.persistent.CostcardVO;
import com.sunrise.boss.business.cms.operation.persistent.OperationVO;
import com.sunrise.boss.business.cms.personalbusi.persistent.PersonalbusiVO;
import com.sunrise.boss.delegate.cms.adimarea.AdimareaDelegate;
import com.sunrise.boss.delegate.cms.costcard.CostcardDelegate;
import com.sunrise.boss.delegate.cms.operation.OperationDelegate;
import com.sunrise.boss.delegate.cms.personalbusi.PersonalbusiDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class BatchTaskBean extends BaseBatchTaskBean {
	CostcardDelegate delegate;

	private boolean isNew = true;

	public BatchTaskBean() {
		try {
			batchName = "社会渠道充值卡销售批量导入";
			setWriteLog(true);
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
	}

	private CostcardDelegate getDelegate() throws Exception {
		if (delegate == null) {
			return new CostcardDelegate();
		} else {
			return delegate;
		}
	}

	public String doStart() {
		return "顺序号|渠道编码|结算月份（YYYYMM）|业务长码|销售数量(张)|是否成功" + "\r\n";
	}
	   /**
     * 处理文件完毕进行的操作
     * @throws Exception
     */
    public String doEnd() throws Exception {
        return "";
    }
	/**
	 * 处理一条记录
	 */
	public ResultVO processLine(String line, int rowCount,User user) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		CostcardVO vo = new CostcardVO();
		try {
			vo.setWayid(items[0].trim());
			vo.setCalcmonth(items[1].trim());
			OperationDelegate operationDelegate = new OperationDelegate();
			OperationVO operationVO = operationDelegate.doFindByPk(items[2],
					user);
			if (operationVO == null) {
				throw new Exception("业务分类信息编码：" + items[2] + "不存在");
			} else if (operationDelegate.getParentlevel(operationVO, user) != 4) {
				throw new Exception("业务分类信息编码必须选择第五级");
			}
			vo.setOpnid(items[2].trim());

			vo.setSalenum(new Integer(items[3].trim()));
			isNew = findByUPK(items[0].trim(), items[1].trim(),
					items[2].trim(), user);
			if (isNew) {
				getDelegate().doCreate(vo, user);
			} else {
				getDelegate().doUpdate(vo, user);
			}
			resultVO.setOk(true);
			resultVO.setInfo(showInfo(resultVO, items, rowCount));
			return resultVO;
		} catch (Exception ex) { // 插入失败
			msg = ex.getMessage();
			resultVO.setOk(false);
			resultVO.setInfo(showInfo(resultVO, items, rowCount) + msg);
			return resultVO;
		}
	}

	/**
	 * 结果文件格式
	 */
	public String showInfo(ResultVO resultVO, String[] items, int rowCount) {
		final String COMPART = " | "; // 分隔
		StringBuffer resultStr = new StringBuffer();
		// 序号
		resultStr.append(rowCount).append(COMPART);
		resultStr.append(items[0]).append(COMPART);
		resultStr.append(items[1]).append(COMPART);
		resultStr.append(items[2]).append(COMPART);
		resultStr.append(items[3]).append(COMPART);
		resultStr.append(COMPART);
		// 办理结果
		if (resultVO.isOk()) {
			if(isNew){
				resultStr.append("新增成功");
			}else
			{
				resultStr.append("修改成功");
			}
		} else {
			resultStr.append("新增失败");
		}
		resultStr.append(COMPART);
		return resultStr.toString();
	}

	private boolean findByUPK(String wayid, String calcmonth, String opnid,
			User user) throws Exception {
		CostcardListVO listVO = new CostcardListVO();
		listVO.set_se_wayid(wayid);
		listVO.set_se_calcmonth(calcmonth);
		listVO.set_se_opnid(opnid);
		return (getDelegate().doQuery(listVO, user).getRowCount() <= 0);
	}
}
