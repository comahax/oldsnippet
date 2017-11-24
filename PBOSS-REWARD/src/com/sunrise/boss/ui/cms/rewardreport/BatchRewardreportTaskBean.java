package com.sunrise.boss.ui.cms.rewardreport;

import java.util.Iterator;

import org.apache.commons.beanutils.BeanUtils;

import com.sunrise.boss.business.cms.rewardreport.persistent.RewardreportListVO;
import com.sunrise.boss.business.cms.rewardreport.persistent.RewardreportVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountListVO;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.rewardreport.RewardreportDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.cms.wayaccount.WayaccountDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.pub.tools.StringSplit;

public class BatchRewardreportTaskBean extends BaseBatchTaskBean {
	private RewardreportDelegate delegate;
	private WayDelegate waydelegate;
	private WayaccountDelegate wayaccountDelegate;
	boolean cando = false;
	public BatchRewardreportTaskBean() throws Exception{
		// TODO Auto-generated constructor stub
		delegate = new RewardreportDelegate();
		waydelegate=new WayDelegate();
		wayaccountDelegate=new WayaccountDelegate();
		super.setBatchName("酬金结果支付管理导入");
		super.setWriteLog(true);
	}
	protected String doStart() {
		return "酬金结果支付管理导入结果 \r\n";
	}
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO=new ResultVO();
		String[] content = StringSplit.split(line, "|");
		String wayid = "";
		try{
			// 通过收款账户取得渠道id
			WayaccountListVO aclistvo = new WayaccountListVO();
			aclistvo.set_se_acctno(content[0]);
			DataPackage accdp = wayaccountDelegate.doQuery(aclistvo, user);
			if(accdp == null || accdp.getRowCount()==0){
				throw new BusinessException("","账户在渠道资料不存在，请在【社会网点信息管理】维护相关信息。");
			} else {
				//账户记录存在
				Iterator it = accdp.getDatas().iterator();
				while (it.hasNext()) {
					WayaccountVO accvo = (WayaccountVO)it.next();
					wayid = accvo.getWayid();
				}
			}
			RewardreportVO rewardreportVO=new RewardreportVO();
			if ("".equals(wayid)) {
				throw new BusinessException("","账户在渠道资料不存在，请在【社会网点信息管理】维护相关信息。");
			}
			rewardreportVO.setWayid(wayid);
			rewardreportVO.setTaccount(content[0]);
			rewardreportVO.setPaccount(content[1]);
			rewardreportVO.setCalcmonth(content[2]);
			rewardreportVO.setPaymoney(Double.valueOf(content[3]));
			if (!"".equals(content[4].trim())) {
				rewardreportVO.setMemo(content[4].trim());
			}

			// 取得对应【渠道编码】【计酬月份】存在的相关记录
			RewardreportListVO listvo = new RewardreportListVO();
			listvo.set_se_wayid(rewardreportVO.getWayid());
			listvo.set_se_calcmonth(rewardreportVO.getCalcmonth());
			DataPackage dp = delegate.doQuery(listvo, user);
			if(dp == null || dp.getRowCount()==0){
				// 取得渠道名称
				WayVO wayvo = waydelegate.doFindByPk(rewardreportVO.getWayid(), user);
				if(wayvo==null){
					throw new BusinessException("","["+rewardreportVO.getWayid()+"] :渠道编码不存在");
				}
				rewardreportVO.setName(wayvo.getWayname());
				delegate.doCreate(rewardreportVO, user);
				
				line = rowCount + "   " + line + "    新增成功";

			}else{
				//相关记录存在
				Iterator it = dp.getDatas().iterator();
				while (it.hasNext()) {
					RewardreportVO oldvo = (RewardreportVO)it.next();
					RewardreportVO newvo = new RewardreportVO();
					BeanUtils.copyProperties(newvo, oldvo);
					newvo.setPaymoney(rewardreportVO.getPaymoney());
					newvo.setTaccount(rewardreportVO.getTaccount());
					newvo.setPaccount(rewardreportVO.getPaccount());
					if (!"".equals(rewardreportVO.getMemo())) {
						newvo.setMemo(rewardreportVO.getMemo());
					}
					
					delegate.doUpdate(newvo, user);
					line = rowCount + "   " + line + "    更新成功";
				}

			}
			
			resultVO.setInfo(line);
			resultVO.setOk(true);
			
		}catch(Exception e){
			line = rowCount + "   " + line + "    错误信息:" + e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
}
