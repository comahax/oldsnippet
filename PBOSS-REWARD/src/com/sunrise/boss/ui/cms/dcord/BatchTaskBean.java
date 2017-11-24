/**
 * 
 */
package com.sunrise.boss.ui.cms.dcord;

import java.util.Date;
import org.apache.commons.lang.StringUtils;
import com.sunrise.boss.business.cms.adjustment.persistent.AdjustmentListVO;
import com.sunrise.boss.business.cms.dcord.persistent.DcordListVO;
import com.sunrise.boss.business.cms.dcord.persistent.DcordVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamListVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.adjustment.AdjustmentDelegate;
import com.sunrise.boss.delegate.cms.cityrecord.CityrecordDelegate;
import com.sunrise.boss.delegate.cms.dcord.DcordDelegate;
import com.sunrise.boss.delegate.common.sysparam.SysparamDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

/**
 * @author cx-yz
 * 
 */
public class BatchTaskBean extends BaseBatchTaskBean {
	DcordDelegate delegate;
	AdjustmentDelegate adjustdegelete = null;
	CityrecordDelegate cityrecordDelegate = null;
	SysparamDelegate sysparamDelegate = null;
	boolean isUpper = false;

	public BatchTaskBean() {
		try {
			delegate = new DcordDelegate();
			adjustdegelete = new AdjustmentDelegate();
			cityrecordDelegate = new CityrecordDelegate();
			sysparamDelegate = new SysparamDelegate();
			batchName = "酬金出账明细批量调整";
			setWriteLog(true);
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
	}

	protected String doStart() {
		try {
	    	SysparamListVO sysparamListVO = new SysparamListVO();
	    	sysparamListVO.set_se_paramtype("channel");
	    	sysparamListVO.set_ne_systemid("93");
	    	DataPackage sysparamDP = sysparamDelegate.doQuery(sysparamListVO, user);
			if (sysparamDP != null && sysparamDP.getDatas() != null && sysparamDP.getDatas().size() > 0) {
	    		SysparamVO sysparamVO = (SysparamVO) sysparamDP.getDatas().iterator().next();
	    		if ("1".equals(sysparamVO.getParamvalue())) {
	    			isUpper = true;
	    		}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
		return "渠道编码|业务编码|酬金期数|业务发生月|结算月份|结算状态|处理结果|" + "\r\n";
	}

	/**
	 * 处理一条记录
	 */
	public ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		try {
			DcordVO dcordvo = null;
			String isflag = "";
			if (content.length == 7) {
				String wayid = content[0].trim();
				String rewardtype = content[2].trim();
				String oprmonth = content[3].trim();
				String rewardmonth = content[4].trim();
				isflag = content[5].trim();
				
				String opnid = "";
				if (content[1] != null && !"".equals(content[1].trim())) {
					opnid = content[1].trim();
				}
				
				DcordListVO listvo = new DcordListVO();
				listvo.set_se_wayid(wayid);
				listvo.set_se_rewardmonth(rewardmonth);
				listvo.set_se_opnid(opnid);
				listvo.set_sql_batchno(" batchno is null");
				listvo.set_se_oprmonth(oprmonth);
				listvo.set_ne_rewardtype(rewardtype);
				listvo.set_pagesize("0");
				DataPackage dp = delegate.doQuery(listvo, user);
				if (dp != null && dp.getDatas() != null && dp.getDatas().size() > 0) {
					if(dp.getDatas().size() > 1){
						line += "对应数据存在重复记录，无法确定调整哪条数据，请在查询界面对单条数据调整";
						resultVO.setInfo(line);
		    			resultVO.setOk(false);
		    			return resultVO;
					}else{
						dcordvo = (DcordVO) dp.getDatas().iterator().next();
					}
				} else {
					line += "没有满足给定条件的数据，无法调整";
					resultVO.setInfo(line);
	    			resultVO.setOk(false);
	    			return resultVO;
				}
			} else if (content.length == 3) {
				isflag = content[1].trim();
				dcordvo = delegate.doFindByPk(Long.valueOf(content[0].trim()), user);
				if (dcordvo == null) {
					line += "没有序列号为 " + content[0].trim() + " 的数据，无法调整";
					resultVO.setInfo(line);
	    			resultVO.setOk(false);
	    			return resultVO;
				}
			}
			
			if (dcordvo.getIsflag() != 0 && dcordvo.getIsflag() != 3 && dcordvo.getIsflag() != 4) {
				line += "对应数据不处于“待结算”、“冻结”、“暂挂”状态，不允许调整";
				resultVO.setInfo(line);
    			resultVO.setOk(false);
    			return resultVO;
			}
			
			//根据wayid、rewardmonth、upperopnid检查ch_adt_adjustment表是否存在相关记录且batchno为空的记录
        	AdjustmentListVO adjustmentListVO = new AdjustmentListVO();
        	adjustmentListVO.set_se_rewardmonth(dcordvo.getRewardmonth());
        	adjustmentListVO.set_se_wayid(dcordvo.getWayid());
        	if (isUpper) {
        		adjustmentListVO.set_se_upperopnid(dcordvo.getUpperopnid());
        	}
        	adjustmentListVO.set_sql_batchno(" batchno is null");
        	adjustmentListVO.set_pagesize("0");
        	DataPackage dp1 = adjustdegelete.doQuery(adjustmentListVO, user);
        	if(dp1!=null && dp1.getDatas().size()>0){
        		line += " 失败原因:该渠道当前结算月份已确认待出付款报表,若需调整请在【付款数据调整管理】中先删除该网点的已核对记录!";
        		resultVO.setInfo(line);
    			resultVO.setOk(false);
    			return resultVO;
        	}
			
        	dcordvo.setIsflag(Short.parseShort(isflag));
			dcordvo.setAdjustoprcode(user.getOpercode());
			dcordvo.setAdjustoptime(new Date());
			delegate.doUpdate(dcordvo, user);
			
			cityrecordDelegate.updateIsflagByDcordid(Short.parseShort(isflag), dcordvo.getId(), user);
			line += "操作成功|";
			resultVO.setOk(true);
			resultVO.setInfo(line);
		} catch (Exception ex) {
			ex.printStackTrace();
			line += "错误信息:" + ex.getMessage() + "|";
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
}
