package com.sunrise.boss.ui.example.batchtest;

import org.apache.commons.lang.*;

import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class BatchTaskBean extends BaseBatchTaskBean {

	private Short oprtype;

	public BatchTaskBean() {
		try {
			// delegate = new OrdinaryTableDelegate(RobnumresVO.class,
			// RobnumreslogVO.class);
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
	}

	protected String doStart() {
		BatchtestForm batchtestForm=(BatchtestForm)form;
		oprtype=batchtestForm.getOprtype();
		//oprtype=new Short(parameterMap.get("oprtype").toString());
		return "序号 | 号码 | 操作类型 | 渠道编号 | 状态 | 办理结果 | 出错信息"+"\r\n";
	}

	/**
	 * 处理一条记录
	 */
	public ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String mobileno;
		String[] items = line.split("\\|");
		mobileno = items[0];
		String channel = items[1];
		Short status = new Short(items[2]);
		try {
			if (oprtype.shortValue() == 0) { // 增加
				doInsert(mobileno, channel, status);
			}
			if (oprtype.shortValue() == 3) { // 删除
				doDelete(mobileno, channel, status);
			}
			resultVO.setOk(true);
			resultVO.setInfo(showInfo(resultVO, items, rowCount));
			return resultVO;
		} catch (Exception ex) { // 插入失败
			msg = ex.getMessage();
			resultVO.setOk(false);
			resultVO.setInfo(showInfo(resultVO, items, rowCount)+msg);
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
		// 号码
		resultStr.append(items[0]).append(COMPART);
		// 操作类型
		if (oprtype.shortValue() == 0) {
			resultStr.append("增加");
		}
		if (oprtype.shortValue() == 3) {
			resultStr.append("删除");
		}
		resultStr.append(COMPART);
		// 渠道编号
		resultStr.append(items[1]).append(COMPART);
		// 状态
		resultStr.append(items[2]).append(COMPART);
		// 办理结果
		if (resultVO.isOk()) {
			resultStr.append("成功");
		} else {
			resultStr.append("失败");
		}
		resultStr.append(COMPART);
		return resultStr.toString();
	}

	private void doDelete(String mobileno, String channel, Short status)
			throws Exception {
		// RobnumresVO robnumresVO = (RobnumresVO)
		// delegate.doFindByPk(mobileno,"");
		// if (robnumresVO == null) {
		// throw new Exception("找不到相应的记录,不在抢购号码表中");
		// }
		// robnumresVO = new RobnumresVO();
		// robnumresVO.setMobileno(mobileno);
		// robnumresVO.setChannel(channel);
		// robnumresVO.setStatus(status);
		//
		// RobnumreslogVO logVO = new RobnumreslogVO();
		// logVO.setLogid(new Long(Sequence.getSequence()));
		// logVO.setMobileno(mobileno);
		// logVO.setChannel(channel);
		// logVO.setStatus(status);
		// logVO.setOprcode(user.getOpercode());
		// logVO.setOprtime(new Timestamp(System.currentTimeMillis()));
		// logVO.setWayid(user.getWayid());
		// logVO.setOprtype(oprtype);
		// delegate.doRemoveByVO(robnumresVO, logVO, user.getOpercode());
	}

	/**
	 * 插入记录
	 * 
	 */
	private void doInsert(String mobileno, String channel, Short status)
			throws Exception {
		if(mobileno.equals("13800138000")){//for test Exception
			throw new Exception("号码状态无效");
		}
		// RobnumresVO oldRobnumresVO = (RobnumresVO)
		// delegate.doFindByPk(mobileno,"");
		// RobnumresVO newRobnumresVO = new RobnumresVO();
		// newRobnumresVO.setMobileno(mobileno);
		// newRobnumresVO.setChannel(channel);
		// newRobnumresVO.setStatus(status);
		//		
		// RobnumreslogVO logVO = new RobnumreslogVO();
		// logVO.setLogid(new Long(Sequence.getSequence()));
		// logVO.setMobileno(mobileno);
		// logVO.setChannel(channel);
		// logVO.setStatus(status);
		// logVO.setOprcode(user.getOpercode());
		// logVO.setOprtime(new Timestamp(System.currentTimeMillis()));
		// logVO.setWayid(user.getWayid());
		//		
		// if (oldRobnumresVO == null) {//新增
		// logVO.setOprtype(new Short(ADD)); //0:增加
		// delegate.doCreate(newRobnumresVO, logVO, user.getOpercode()); // 插数据
		// }else{ //更新
		// RobnumreslogVO oldLogVO = new RobnumreslogVO();
		// oldLogVO.setLogid(new Long(Sequence.getSequence()));
		// oldLogVO.setMobileno(oldRobnumresVO.getMobileno());
		// oldLogVO.setChannel(oldRobnumresVO.getChannel());
		// oldLogVO.setStatus(oldRobnumresVO.getStatus());
		// oldLogVO.setOprcode(user.getOpercode());
		// oldLogVO.setOprtime(new Timestamp(System.currentTimeMillis()));
		// oldLogVO.setWayid(user.getWayid());
		// oldLogVO.setOprtype(new Short(BEFOREUPDATE));//1:修改前
		// logVO.setOprtype(new Short(AFTERUPDATE)); //2:修改后
		// delegate.doUpdate2(newRobnumresVO,oldLogVO,logVO,
		// user.getOpercode());
		// }
	}

	public void setOprtype(Short oprtype) {
		this.oprtype = oprtype;
	}

}
