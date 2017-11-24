package com.sunrise.boss.ui.cms.rewardranlog;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;

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

public class RewardranlogTaskBean extends BaseBatchTaskBean {
	private RewardranlogDelegate delegate;
//	private WayDelegate waydelegate;
	private WayaccountDelegate wayaccountDelegate;
	boolean cando = false;
	public RewardranlogTaskBean() throws Exception{
		// TODO Auto-generated constructor stub
		delegate = new RewardranlogDelegate();
//		waydelegate=new WayDelegate();
		wayaccountDelegate=new WayaccountDelegate();
		super.setBatchName("酬金发放日志管理导入");
		super.setWriteLog(true);
	}
	protected String doStart() {
		return "酬金发放日志管理导入结果 \r\n";
	}
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO=new ResultVO();
		String[] content = StringSplit.split(line, "|");
		String wayid = "";
		try{
			// 通过收款账户取得渠道id
			WayaccountListVO aclistvo = new WayaccountListVO();
			aclistvo.set_se_acctno(content[1]);
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
			RewardranlogVO vo = new RewardranlogVO();
			// 渠道编码
			if (!StringUtils.isEmpty(content[0])) {
				vo.setWayid(content[0]);
			} else {
				if ("".equals(wayid)) {
					throw new BusinessException("","账户在渠道资料不存在，请在【社会网点信息管理】维护相关信息。");
				}
				vo.setWayid(wayid);
			}
			// 收款账户
			vo.setPaccount(content[1]);
			// 付款账户
			vo.setRaccount(content[2]);
			// 计酬月份
			vo.setCalcmonth(content[3]);
			// 支付金额
			vo.setRemark((Double.valueOf(content[4])));
			// 支付时间
			if(!StringUtils.isEmpty(content[5])){
				SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try{
					vo.setPtime(format1.parse(content[5]));
				}catch(Exception e){
					throw new BusinessException("","支付时间格式不正确，正确的格式应该为yyyy-MM-dd HH:mm:ss");
				}
			}
			// 备注说明
			if (!"".equals(content[6].trim())) {
				vo.setMemo(content[6].trim());
			}
			// 操作工号
			vo.setOpercode(user.getOpercode());
			// 操作时间
			vo.setOpertime(new Date());
			// 操作类型
			vo.setOpertype("I");
			delegate.doCreate(vo, user);
			
			line = rowCount + "   " + line + "    新增成功";			
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
