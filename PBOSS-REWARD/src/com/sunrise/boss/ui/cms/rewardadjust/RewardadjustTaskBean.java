package com.sunrise.boss.ui.cms.rewardadjust;


import java.util.Date;

import com.sunrise.boss.business.cms.rewardadjust.persistent.RewardadjustVO;
import com.sunrise.boss.business.cms.waitaudit.persistent.WaitauditVO;
import com.sunrise.boss.delegate.cms.rewardadjust.RewardadjustDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.pub.tools.StringSplit;

public class RewardadjustTaskBean extends BaseBatchTaskBean {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RewardadjustDelegate delegate;
	
	private Date nowDate;
	
	public RewardadjustTaskBean() throws Exception{
		// TODO Auto-generated constructor stub
		delegate = new RewardadjustDelegate();
		nowDate = new Date();
		super.setBatchName("����������������־��ѯ");
		super.setWriteLog(true);
	}
	
	public String doStart() {
		return "�������|�������|���ý����·�(YYYYMM)|�������|������ʽ|����ԭ������|��ע|�������(YYYYMM)|" + "\r\n";
	}
	
	public String doEnd() throws Exception {
        return "";
    }
	
	public ResultVO processLine(String line, int rowCount, User user, WaitauditVO vo) {
		ResultVO resultVO=new ResultVO();
		String[] content = StringSplit.split(line, "|");
		try{
			if(content.length == 8){
				RewardadjustVO createvo=new RewardadjustVO();
				createvo.setAdjustkind(content[0]);
				createvo.setWayid(content[1]);
				createvo.setEftmonth(content[2]);
				createvo.setAdjmoney(new Double(content[3]));
				createvo.setAdjusttype(content[4]);
				createvo.setReasontype(content[5]);
				createvo.setRemark(content[6]);
				createvo.setIslock(new Short("1"));
				createvo.setCreateoprcode(vo.getOprcode());
				createvo.setCreatetime(vo.getCreatetime());
				createvo.setUpdateoprcode(user.getOpercode());
				createvo.setUpdatetime(nowDate);
				createvo.setRewardtype(new Short("-1"));
				createvo.setAdtoprcode(user.getOpercode());
				createvo.setAdttime(nowDate);
				createvo.setSrcmonth(content[7]);
				createvo.setAdjsrc("CH_PW_WAITAUDIT");
				createvo.setAdjsrcseq(vo.getTaskid());
				createvo = delegate.doCreate(createvo, user);

				line = rowCount + "   " + line + "    ����ɹ�";
			}
			resultVO.setInfo(line);
			resultVO.setOk(true);
			
		}catch(Exception e){
			line = rowCount + "   " + line + "    ������Ϣ:" + e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
}
