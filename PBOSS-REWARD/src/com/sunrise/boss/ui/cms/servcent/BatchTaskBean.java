package com.sunrise.boss.ui.cms.servcent;

import com.sunrise.boss.business.cms.servcent.persistent.ServcentVO;
import com.sunrise.boss.delegate.cms.servcent.ServcentDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.pub.tools.StringSplit;

public class BatchTaskBean extends BaseBatchTaskBean {
	ServcentDelegate delegate;
	public BatchTaskBean() {
		try {
			delegate = new ServcentDelegate();
			batchName = "服务销售中心管理";
			setWriteLog(true);
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
	}
	protected String doStart() {
		return "服务销售中心编码|分公司编码|服务销售中心名称|服务销售中心类型|法人代表|计费用行政区域代码|行政区划编码|办公地点经度|办公地点纬度" + "\r\n";
	}
	/**
	 * 处理一条记录
	 */
	public ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] items = StringSplit.split(line, "|");
		ServcentVO vo = new ServcentVO();
		try {
			ServcentVO oldvo = delegate.doFindByPk(items[0], user);
			if(oldvo == null){//新增
				
			
			vo.setSvccode(items[0]);
			vo.setCountyid(items[1]);
			vo.setSvcname(items[2]);
			vo.setSvctype(new Short(items[3]));
			vo.setAgent(items[4]);
			vo.setBillingcode(items[5]);
			vo.setAdacode(items[6]);
			vo.setLongitude(items[7]);
			vo.setLatitude(items[8]);
			

			delegate.doCreate(vo, user);
			}else {//修改
				if (items[1] != null && !items[1].equals("")) {
					oldvo.setCountyid(items[1]);
				}
				if (items[2] != null && !items[2].equals("")) {
					oldvo.setSvcname(items[2]);
				}
				if (items[3] != null && !items[3].equals("")) {
					oldvo.setSvctype(new Short(items[3]));
				}
				if (items[4] != null && !items[4].equals("")) {
					oldvo.setAgent(items[4]);
				}
				if (items[5] != null && !items[5].equals("")) {
					oldvo.setBillingcode(items[5]);
				}
				if (items[6] != null && !items[6].equals("")) {
					oldvo.setAdacode(items[6]);
				}
				if (items[7] != null && !items[7].equals("")) {
					oldvo.setLongitude(items[7]);
				}
				if (items[8] != null && !items[8].equals("")) {
					oldvo.setLatitude(items[8]);
				}
				delegate.doUpdate(oldvo, user);
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
		resultStr.append(items[4]).append(COMPART);
		resultStr.append(items[5]).append(COMPART);
		resultStr.append(items[6]).append(COMPART);
		resultStr.append(items[7]).append(COMPART);
		resultStr.append(items[8]).append(COMPART);
		
		resultStr.append("增加");
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

}
