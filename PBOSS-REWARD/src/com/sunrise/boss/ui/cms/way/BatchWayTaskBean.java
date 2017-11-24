package com.sunrise.boss.ui.cms.way;

import org.apache.commons.lang.StringUtils;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class BatchWayTaskBean extends BaseBatchTaskBean {
	private static WayDelegate delegate = null;

	private String flag = "";

	private static WayDelegate getDelegate() throws Exception {
		if (delegate == null) {
			return new WayDelegate();
		} else {
			return delegate;
		}
	}

	public BatchWayTaskBean() {
		try {
			delegate = new WayDelegate();
			batchName = "渠道信息管理";
			setWriteLog(true);
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
	}

	protected String doStart() {
		return "序号|渠道编码|渠道名称|上级渠道|营业点标识|是否共享|渠道类别|渠道子类别|分公司自定义渠道类别管理|城市级别|渠道等级|渠道MIS编码|物业来源分类|是否联网|联网方式|经营模式|是否中心渠道|星级|排他性|连锁总店编码|签约状态|营业人员数量|管理人员数量|终端数量|纬度|经度|渠道状态|渠道中间代码|自营标志"
				+ "\r\n";
	}

	/**
	 * 处理一条记录
	 */
	public ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] items = line.split("\\|");
		// 去空格

		WayVO wayVO = new WayVO();
		try {
			// 社会渠道基本信息
			wayVO = getDelegate().doFindByPk(items[0].trim(), user);
			if (wayVO == null) {
				// 新增
				wayVO = new WayVO();
				flag = "新增";
				buildVO(wayVO, items);
				getDelegate().doCreate(wayVO, user);
			} else {
				// 修改
				flag = "修改";
				buildVO(wayVO, items);
				delegate.doUpdate(wayVO, user);
			}
			resultVO.setOk(true);
			resultVO.setInfo(showInfo(resultVO, items, rowCount));
			return resultVO;
		} catch (Exception ex) { // 插入失败
			msg = ex.getMessage();
			resultVO.setOk(false);
			ex.printStackTrace();
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
		resultStr.append(items[9]).append(COMPART);
		resultStr.append(items[10]).append(COMPART);
		resultStr.append(items[11]).append(COMPART);
		resultStr.append(items[12]).append(COMPART);
		resultStr.append(items[13]).append(COMPART);
		resultStr.append(items[14]).append(COMPART);
		resultStr.append(items[15]).append(COMPART);
		resultStr.append(items[16]).append(COMPART);
		resultStr.append(items[17]).append(COMPART);
		resultStr.append(items[18]).append(COMPART);
		resultStr.append(items[19]).append(COMPART);
		resultStr.append(items[20]).append(COMPART);
		resultStr.append(items[21]).append(COMPART);
		resultStr.append(items[22]).append(COMPART);
		resultStr.append(items[23]).append(COMPART);
		resultStr.append(items[24]).append(COMPART);
		resultStr.append(items[25]).append(COMPART);
		resultStr.append(items[26]).append(COMPART);
		resultStr.append(items[27]).append(COMPART).append(flag);
		// 办理结果
		if (resultVO.isOk()) {
			resultStr.append(" 成功");
		} else {
			resultStr.append(" 失败");
		}
		resultStr.append(COMPART);
		return resultStr.toString();
	}

	private void buildVO(WayVO wayVO, String[] items) throws Exception {
		// \渠道编码0
		if (!isEmpty(items[0]))
			wayVO.setWayid(items[0].trim());
		// \渠道名称1
		if (!isEmpty(items[1]))
			wayVO.setWayname(items[1].trim());
		// 上级渠道编码2 上级渠道不允许修改
		if (!isEmpty(items[2]) && "新增".equals(flag)) {
			wayVO.setUpperwayid(items[2].trim());
			WayVO tempVO = getDelegate().doFindByPk(items[2].trim(), user);
			if (tempVO != null) {
				if (tempVO.getCenterid() != null) {
					wayVO.setCenterid(tempVO.getCenterid());
				}
				if (tempVO.getCityid() != null) {
					wayVO.setCityid(tempVO.getCityid());
				}
				if (tempVO.getCountyid() != null) {
					wayVO.setCountyid(tempVO.getCountyid());
				}
			}
		} else if (!isEmpty(items[2]) && "修改".equals(flag)
				&& !items[2].trim().equals(wayVO.getUpperwayid())) {
			throw new Exception("渠道上级编码暂不提供修改");
		}
		// 营业点标识3
		if (!isEmpty(items[3]))
			wayVO.setBusicode(items[3].trim());
		// \是否共享4??
		if (!isEmpty(items[4]))
			wayVO.setIsshare(items[4].trim());
		// \ 渠道类别5
		if (!isEmpty(items[5]))
			wayVO.setWaytype(items[5].trim());
		// \ 渠道子类别6
		if (!isEmpty(items[6]))
			wayVO.setWaysubtype(items[6].trim());
		// 分公司自定义渠道类别管理7
		if (!isEmpty(items[7]))
			wayVO.setCusttype(items[7].trim());
		// // \ 区域中心8
		// if (!isEmpty(items[8]))
		// wayVO.setCenterid(items[8].trim());
		// // \ 市公司9
		// if (!isEmpty(items[9]))
		// wayVO.setCityid(items[9].trim());
		// // 县公司10
		// if (!isEmpty(items[10]))
		// wayVO.setCountyid(items[10].trim());
		// 城市级别11
		if (!isEmpty(items[8]))
			wayVO.setCitylevel(new Short(items[8].trim()));
		// 渠道级别12
		// if (!isEmpty(items[12]))
		// wayVO.setWaylevel(new Short(items[12].trim()));
		// 渠道等级9
		if (!isEmpty(items[9]))
			wayVO.setBchlevel(items[9].trim());
		// 渠道MIS编码10
		if (!isEmpty(items[10]))
			wayVO.setMiscode(items[10].trim());
		// 物业来源分类11
		if (!isEmpty(items[11]))
			wayVO.setPrtsource(new Long(items[11].trim()));
		// 是否联网12---------------------------------------------------------------------
		if (!isEmpty(items[12]))
			wayVO.setIsconnected(new Long(items[12].trim()));
		// 联网方式13
		if (!isEmpty(items[13]))
			wayVO.setConnecttype(new Long(items[13].trim()));
		// 经营模式14
		if (!isEmpty(items[14]))
			wayVO.setRunmode(new Long(items[14].trim()));
		// 是否中心渠道15
		if (!isEmpty(items[15]))
			wayVO.setIscoreway(new Long(items[15].trim()));
		// 星级16
		if (!isEmpty(items[16]))
			wayVO.setStarlevel(new Long(items[16].trim()));
		// 排他性17
		if (!isEmpty(items[17]))
			wayVO.setPt(new Long(items[17].trim()));
		// 连锁总店编码18
		if (!isEmpty(items[18]))
			wayVO.setChainhead(items[18].trim());
		// 签约状态19
		if (!isEmpty(items[19]))
			wayVO.setSignstatus(new Long(items[19].trim()));
		// 营业人员数量20------------------------------------------------------
		if (!isEmpty(items[20]))
			wayVO.setEmpnumber(new Long(items[20].trim()));
		// 管理人员数量21
		if (!isEmpty(items[21]))
			wayVO.setMagnumber(new Long(items[21].trim()));
		// 终端数量22
		if (!isEmpty(items[22]))
			wayVO.setTerminumber(new Long(items[22].trim()));
		// \ 纬度23
		if (!isEmpty(items[23]))
			wayVO.setLatitude(items[23].trim());
		// \ 经度24
		if (!isEmpty(items[24]))
			wayVO.setLongtitude(items[24].trim());
		// \ 渠道状态25
		if (!isEmpty(items[25]))
			wayVO.setWaystate(new Short(items[25].trim()));
		if (isEmpty(items[25]) && "新增".equals(flag)) {
			wayVO.setWaystate(new Short("1"));
		}
		// 渠道中间代码26
		if (!isEmpty(items[26]))
			wayVO.setDepotdet(items[26].trim());
		// \ 自营标志31
		if (!isEmpty(items[27])) {
			wayVO.setRunbyself(items[27].trim());
		}
	}

	private boolean isEmpty(String item) throws Exception {
		return StringUtils.isEmpty(item.trim());
	}
}
