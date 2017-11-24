package com.sunrise.boss.ui.cms.personalbusi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sunrise.boss.business.cms.adimarea.persistent.AdimareaVO;
import com.sunrise.boss.business.cms.operation.persistent.OperationVO;
import com.sunrise.boss.business.cms.personalbusi.persistent.PersonalbusiVO;
import com.sunrise.boss.delegate.cms.adimarea.AdimareaDelegate;
import com.sunrise.boss.delegate.cms.operation.OperationDelegate;
import com.sunrise.boss.delegate.cms.personalbusi.PersonalbusiDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class BatchTaskBean extends BaseBatchTaskBean {
	PersonalbusiDelegate delegate;
	public BatchTaskBean() {
		try {
			delegate = new PersonalbusiDelegate();
			batchName = "数据业务批量导入";
			setWriteLog(true);
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
	}

	protected String doStart() {
		return "顺序号|号码|渠道编码|业务分类信息编码|品牌|办理时间|操作类型|是否成功" + "\r\n";
	}

	/**
	 * 处理一条记录
	 */
	public ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] items = line.split("\\|");
		PersonalbusiVO vo = new PersonalbusiVO();
		try {

			vo.setMobile(items[0].trim());
			vo.setWayid(items[1].trim());
			OperationDelegate operationDelegate = new OperationDelegate();
			OperationVO operationVO = operationDelegate.doFindByPk(items[2], user);
			if(operationVO == null){
				throw new Exception("业务分类信息编码：" + items[2] + "不存在");
			}else if(operationDelegate.getParentlevel(operationVO, user) != 4){
				throw new Exception("业务分类信息编码必须选择第五级");
			}
			vo.setOpntype(items[2].trim());
			vo.setBrand(new Long(items[3].trim()));
			DateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date dt=fm.parse(items[4].trim());
			vo.setOpntime(dt);
			vo.setOprtype(items[5].trim());
			delegate.doCreate(vo, user);
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
		resultStr.append(items[4]).append(COMPART);
		resultStr.append(items[5]);
		resultStr.append(COMPART);
		// 办理结果
		if (resultVO.isOk()) {
			resultStr.append("新增成功");
		} else {
			resultStr.append("新增失败");
		}
		resultStr.append(COMPART);
		return resultStr.toString();
	}
}

