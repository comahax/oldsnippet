package com.sunrise.boss.ui.cms.rewardranlog;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.rewardranlog.persistent.RewardranlogListVO;
import com.sunrise.boss.business.cms.rewardranlog.persistent.RewardranlogVO;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountListVO;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.rewardranlog.RewardranlogDelegate;
import com.sunrise.boss.delegate.cms.wayaccount.WayaccountDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.pub.tools.StringSplit;

public class DeleteTaskBean extends BaseBatchTaskBean {
	private RewardranlogDelegate delegate;
//	private WayDelegate waydelegate;
	private WayaccountDelegate wayaccountDelegate;
	boolean cando = false;
	public DeleteTaskBean() throws Exception{
		// TODO Auto-generated constructor stub
		delegate = new RewardranlogDelegate();
//		waydelegate=new WayDelegate();
		wayaccountDelegate=new WayaccountDelegate();
		super.setBatchName("酬金发放日志管理批量删除");
		super.setWriteLog(true);
	}
	protected String doStart() {
		return "酬金发放日志管理批量删除结果 \r\n";
	}
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO=new ResultVO();
		String[] content = StringSplit.split(line, "|");
		String wayid = "";
		try{
			// 通过收款账户，渠道编码，计酬月份
			RewardranlogListVO aclistvo = new RewardranlogListVO();
			aclistvo.set_se_wayid(content[0]);
			aclistvo.set_se_paccount(content[1]);
			aclistvo.set_se_calcmonth(content[2]);
			DataPackage accdp = delegate.doQuery(aclistvo, user);
			if(accdp == null || accdp.getRowCount()==0){
				throw new BusinessException("","对应数据在库表中不存在。");
			} else {
				//账户记录存在
				Iterator it = accdp.getDatas().iterator();
				while (it.hasNext()) {
					RewardranlogVO accvo = (RewardranlogVO)it.next();
					RewardranlogVO newvo = new RewardranlogVO();
					org.apache.commons.beanutils.BeanUtils.copyProperties(newvo,
							accvo);
					delegate.doRemove(newvo, user);
				}
			}
			
			line = rowCount + "   " + line + "    删除成功";			
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
