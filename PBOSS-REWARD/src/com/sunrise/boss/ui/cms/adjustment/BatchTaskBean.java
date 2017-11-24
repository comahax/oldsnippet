/**
 * 
 */
package com.sunrise.boss.ui.cms.adjustment;

import java.util.Date;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.adjustment.persistent.AdjustmentListVO;
import com.sunrise.boss.business.cms.adjustment.persistent.AdjustmentVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamListVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.adjustment.AdjustmentDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.common.sysparam.SysparamDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

/**
 * @author cx-yz
 * 
 */
public class BatchTaskBean extends BaseBatchTaskBean {
	AdjustmentDelegate delegate;
	
	private static final String COMMON_TITLE = "渠道编码|结算月份|税金|扣罚金额|备注|处理结果|\r\n";
	private static final String FEES_SUPPORT_TITLE = "渠道编码|结算月份|税金|扣罚金额|手续费|备注|处理结果|\r\n";
	private static final String UPPER_SUPPORT_TITLE = "渠道编码|结算月份|业务大类编码|税金|扣罚金额|备注|处理结果|\r\n";
	
	private boolean fees_support = false;
	private boolean upper_support = false;

	public BatchTaskBean() {
		try {
			delegate = new AdjustmentDelegate();
			batchName = "税金信息批量导入";
			setWriteLog(true);
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
	}

	protected String doStart() {
		SysparamDelegate sysparamDelegate;
		try {
			//是否支持手续费
			sysparamDelegate = new SysparamDelegate();
			SysparamListVO sysparamListVO = new SysparamListVO();
			sysparamListVO.set_se_paramtype(BatchAdjustmentCheck.SYS_CHANNEL);
			sysparamListVO.set_ne_systemid(BatchAdjustmentCheck.FEES_SWITCH);
			DataPackage sysparamDP = sysparamDelegate.doQuery(sysparamListVO,user);
			if (sysparamDP != null && sysparamDP.getDatas() != null	&& sysparamDP.getDatas().size() > 0) {
				for (Iterator<SysparamVO> it = sysparamDP.getDatas().iterator(); it.hasNext();) {
					SysparamVO sysparamVO = it.next();
					if (sysparamVO.getParamvalue() != null && "1".equals(sysparamVO.getParamvalue())) {
						this.fees_support = true;
						return FEES_SUPPORT_TITLE;
					}
				}
			}
			//是否支持业务大类
			sysparamListVO.set_se_paramtype(BatchAdjustmentCheck.SYS_CHANNEL);
			sysparamListVO.set_ne_systemid(BatchAdjustmentCheck.UPPEROPNID_SWITCH);
			sysparamDP = sysparamDelegate.doQuery(sysparamListVO,user);
			if (sysparamDP != null && sysparamDP.getDatas() != null	&& sysparamDP.getDatas().size() > 0) {
				for (Iterator<SysparamVO> it = sysparamDP.getDatas().iterator(); it.hasNext();) {
					SysparamVO sysparamVO = it.next();
					if (sysparamVO.getParamvalue() != null && "1".equals(sysparamVO.getParamvalue())) {
						this.upper_support = true;
						return UPPER_SUPPORT_TITLE;
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return COMMON_TITLE;
	}
	
	private void processLineFees(String line, ResultVO resultVO) throws Exception{
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");		
		String wayid = content[0].trim();
		String rewardmonth = content[1].trim();
		String tax = "0.0";
		String rpmoney = "0.0";
		String fees = "0.0";
		String remark = "";
		if (content[2] != null && !"".equals(content[2].trim())) {
			tax = content[2].trim();
		}
		if (content[3] != null && !"".equals(content[3].trim())) {
			rpmoney = content[3].trim();
		}
		if (content[4] != null && !"".equals(content[4].trim())) {
			fees = content[4].trim();
		}								
		if (content[5] != null && !"".equals(content[5].trim())) {
			remark = content[5].trim();
		}
		
		AdjustmentListVO listvo = new AdjustmentListVO();
		listvo.set_se_wayid(wayid);
		listvo.set_se_rewardmonth(rewardmonth);
		listvo.set_sql_batchno(" batchno is null");
		listvo.set_pagesize("0");
		DataPackage dp = delegate.doQuery(listvo, user);
		if (dp != null && dp.getDatas() != null && dp.getDatas().size() > 0) {//对应网点结算月已存在记录
			Iterator it = dp.getDatas().iterator();
			if (it.hasNext()) {
				AdjustmentVO vo = (AdjustmentVO) it.next();
				if (vo.getTaxmoney() != null) {						// 如果税金不为空，累加
					vo.setTaxmoney(vo.getTaxmoney()+ Double.parseDouble(tax));
				} else {
					vo.setTaxmoney(Double.parseDouble(tax));
				}
				
				if (vo.getRpmoney() != null) {						// 奖罚金额不为空，累加
					vo.setRpmoney(vo.getRpmoney()+ Double.parseDouble(rpmoney));
				} else {
					vo.setRpmoney(Double.parseDouble(rpmoney));
				}
				
				if (vo.getFees() != null) {// 手续费不为空，累加
					vo.setFees(vo.getFees() + Double.parseDouble(fees));
				} else {
					vo.setFees(Double.parseDouble(fees));
				}
				
				if (vo.getRemark() != null) {// 备注不为空
					remark = vo.getRemark() + "|" + remark;// 拼接
					if (remark.getBytes().length > 128) {// 超过128位，取后128位
						// remark = remark.substring(remark.length()-128);
						byte[] rb = remark.getBytes();
						remark = new String(rb, rb.length - 128, 128);
					}
				}else{// 备注为空
					if (remark.getBytes().length > 128) {// 文件上传备注超过128位，取前128位
						//vo.setRemark(remark.substring(0, 128));
						byte[] rb = remark.getBytes();
						remark = new String(rb, rb.length - 128, 128);
					}
				}
				vo.setRemark(remark);
				vo.setTaxoprcode(user.getOpercode());
				vo.setTaxoptime(new Date());
				delegate.doUpdate(vo, user);
			}
			line += "操作成功|";
		} else {//对应网点结算月不存在记录
			AdjustmentVO vo = new AdjustmentVO();
			WayDelegate wdelegate = new WayDelegate();
			WayVO wvo = wdelegate.doFindByPk(wayid, user);
			if (wvo != null) {
				vo.setWayid(wayid);
				vo.setCountyid(wvo.getCountyid());
				vo.setPaysum(0.0);
				vo.setRewardmonth(rewardmonth);
				vo.setTaxmoney(Double.parseDouble(tax));
				vo.setRemark(remark);
				vo.setRpmoney(Double.parseDouble(rpmoney));
				vo.setTaxoprcode(user.getOpercode());
				vo.setTaxoptime(new Date());
				vo.setFees(Double.parseDouble(fees));
				delegate.doCreate(vo, user);
				line += "操作成功|";
			} else {
				line += "渠道编码对应网点不存在，无法获取分公司信息";
			}
		}
		resultVO.setOk(true);
		resultVO.setInfo(line);
	}
	
	private void processLineCommon(String line, ResultVO resultVO) throws Exception{
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");

		String wayid = content[0].trim();
		String rewardmonth = content[1].trim();
		String tax = "0.0";
		String remark = "";
		String rpmoney = "0.0";
		if (content[2] != null && !"".equals(content[2].trim())) {
			tax = content[2].trim();
		}
		if (content[3] != null && !"".equals(content[3].trim())) {
			rpmoney = content[3].trim();
		}
		if (content[4] != null && !"".equals(content[4].trim())) {
			remark = content[4].trim();
		}
		
		AdjustmentListVO listvo = new AdjustmentListVO();
		listvo.set_se_wayid(wayid);
		listvo.set_se_rewardmonth(rewardmonth);
		listvo.set_sql_batchno(" batchno is null");
		listvo.set_pagesize("0");
		DataPackage dp = delegate.doQuery(listvo, user);
		if (dp != null && dp.getDatas() != null && dp.getDatas().size() > 0) {//对应网点结算月已存在记录
			Iterator it = dp.getDatas().iterator();
			if (it.hasNext()) {
				AdjustmentVO vo = (AdjustmentVO) it.next();
				if (vo.getTaxmoney() != null) {						// 如果税金不为空，累加
					vo.setTaxmoney(vo.getTaxmoney()+ Double.parseDouble(tax));
				} else {
					vo.setTaxmoney(Double.parseDouble(tax));
				}
				
				if (vo.getRpmoney() != null) {						// 奖罚金额不为空，累加
					vo.setRpmoney(vo.getRpmoney()+ Double.parseDouble(rpmoney));
				} else {
					vo.setRpmoney(Double.parseDouble(rpmoney));
				}
										
				if (vo.getRemark() != null) {// 备注不为空
					remark = vo.getRemark() + "|" + remark;// 拼接
					if (remark.getBytes().length > 128) {// 超过128位，取后128位
						byte[] rb = remark.getBytes();
						remark = new String(rb, rb.length - 128, 128);
					}
				} else {// 备注为空
					if (remark.length() > 128) {// 文件上传备注超过128位，取前128位
						byte[] rb = remark.getBytes();
						remark = new String(rb, rb.length - 128, 128);
					} 
				}
				vo.setRemark(remark);
				
				vo.setTaxoprcode(user.getOpercode());
				vo.setTaxoptime(new Date());
				delegate.doUpdate(vo, user);
			}
			line += "操作成功|";
		} else {//对应网点结算月不存在记录
			AdjustmentVO vo = new AdjustmentVO();
			WayDelegate wdelegate = new WayDelegate();
			WayVO wvo = wdelegate.doFindByPk(wayid, user);
			if (wvo != null) {
				vo.setWayid(wayid);
				vo.setCountyid(wvo.getCountyid());
				vo.setPaysum(0.0);
				vo.setRewardmonth(rewardmonth);
				vo.setTaxmoney(Double.parseDouble(tax));
				vo.setRemark(remark);
				vo.setRpmoney(Double.parseDouble(rpmoney));
				vo.setTaxoprcode(user.getOpercode());
				vo.setTaxoptime(new Date());
				delegate.doCreate(vo, user);
				line += "操作成功|";
			} else {
				line += "渠道编码对应网点不存在，无法获取分公司信息";
			}
		}
		resultVO.setOk(true);
		resultVO.setInfo(line);
	
	}
	
	private void processLineUpper(String line, ResultVO resultVO) throws Exception{
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");

		String wayid = content[0].trim();
		String rewardmonth = content[1].trim();
		String upperopnid = content[2].trim();
		String tax = "0.0";
		String remark = "";
		String rpmoney = "0.0";
		if (content[3] != null && !"".equals(content[3].trim())) {
			tax = content[3].trim();
		}
		if (content[4] != null && !"".equals(content[4].trim())) {
			rpmoney = content[4].trim();
		}
		if (content[5] != null && !"".equals(content[5].trim())) {
			remark = content[5].trim();
		}
		
		AdjustmentListVO listvo = new AdjustmentListVO();
		listvo.set_se_wayid(wayid);
		listvo.set_se_rewardmonth(rewardmonth);
		listvo.set_se_upperopnid(upperopnid);
		listvo.set_sql_batchno(" batchno is null");
		listvo.set_pagesize("0");
		DataPackage dp = delegate.doQuery(listvo, user);
		if (dp != null && dp.getDatas() != null && dp.getDatas().size() > 0) {//对应网点结算月已存在记录
			Iterator it = dp.getDatas().iterator();
			if (it.hasNext()) {
				AdjustmentVO vo = (AdjustmentVO) it.next();
				if (vo.getTaxmoney() != null) {						// 如果税金不为空，累加
					vo.setTaxmoney(vo.getTaxmoney()+ Double.parseDouble(tax));
				} else {
					vo.setTaxmoney(Double.parseDouble(tax));
				}
				
				if (vo.getRpmoney() != null) {						// 奖罚金额不为空，累加
					vo.setRpmoney(vo.getRpmoney()+ Double.parseDouble(rpmoney));
				} else {
					vo.setRpmoney(Double.parseDouble(rpmoney));
				}
										
				if (vo.getRemark() != null) {// 备注不为空
					remark = vo.getRemark() + "|" + remark;// 拼接
					if (remark.getBytes().length > 128) {// 超过128位，取后128位
						byte[] rb = remark.getBytes();
						remark = new String(rb, rb.length - 128, 128);
					}
				} else {// 备注为空
					if (remark.length() > 128) {// 文件上传备注超过128位，取前128位
						byte[] rb = remark.getBytes();
						remark = new String(rb, rb.length - 128, 128);
					} 
				}
				vo.setRemark(remark);
				
				vo.setTaxoprcode(user.getOpercode());
				vo.setTaxoptime(new Date());
				delegate.doUpdate(vo, user);
			}
			line += "操作成功|";
		} else {//对应网点结算月不存在记录
			AdjustmentVO vo = new AdjustmentVO();
			WayDelegate wdelegate = new WayDelegate();
			WayVO wvo = wdelegate.doFindByPk(wayid, user);
			if (wvo != null) {
				vo.setWayid(wayid);
				vo.setCountyid(wvo.getCountyid());
				vo.setUpperopnid(upperopnid);
				vo.setPaysum(0.0);
				vo.setRewardmonth(rewardmonth);
				vo.setTaxmoney(Double.parseDouble(tax));
				vo.setRemark(remark);
				vo.setRpmoney(Double.parseDouble(rpmoney));
				vo.setTaxoprcode(user.getOpercode());
				vo.setTaxoptime(new Date());
				delegate.doCreate(vo, user);
				line += "操作成功|";
			} else {
				line += "渠道编码对应网点不存在，无法获取分公司信息";
			}
		}
		resultVO.setOk(true);
		resultVO.setInfo(line);
	}

	/**
	 * 处理一条记录
	 */
	public ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try {
			if(this.fees_support){
				this.processLineFees(line, resultVO);
			}else if(this.upper_support){
				this.processLineUpper(line, resultVO);
			}else{
				this.processLineCommon(line, resultVO);
			}
		} catch (Exception ex) {
			line += "错误信息:" + ex.getMessage() + "|";
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
}
