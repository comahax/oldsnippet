package com.sunrise.boss.ui.cms.bbc.bbcadjust;


import java.util.Date;

import com.sunrise.boss.business.cms.bbc.bbcadjust.persistent.BbcadjustVO;
import com.sunrise.boss.business.cms.waitaudit.persistent.WaitauditVO;
import com.sunrise.boss.delegate.cms.bbc.bbcadjust.BbcadjustDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.pub.tools.StringSplit;

public class BbcadjustTaskBean extends BaseBatchTaskBean {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BbcadjustDelegate delegate;
	
	private Date nowDate;
	
	public BbcadjustTaskBean() throws Exception{
		// TODO Auto-generated constructor stub
		delegate = new BbcadjustDelegate();
		nowDate = new Date();
		super.setBatchName("B2M网站调整管理导入日志查询");
		super.setWriteLog(true);
	}
	
	public String doStart() {
		return "调整类别|网点编码|作用结算月份(YYYYMM)|调整金额|调整原因类型|备注|酬金发生月(YYYYMM)|" + "\r\n";
	}
	
	public String doEnd() throws Exception {
        return "";
    }
	
	public ResultVO processLine(String line, int rowCount, User user, WaitauditVO vo) {
		ResultVO resultVO=new ResultVO();
		String[] content = StringSplit.split(line, "|");
		try{
			if(content.length == 7){
				BbcadjustVO createvo=new BbcadjustVO();
				createvo.setAdjustkind(content[0]);
				createvo.setWayid(content[1]);
				createvo.setEftmonth(content[2]);
				createvo.setAdjmoney(new Double(content[3]));
				createvo.setReasontype(content[4]);
				createvo.setRemark(content[5]);
				createvo.setIslock(new Short("1"));
				createvo.setCreateoprcode(vo.getOprcode());
				createvo.setCreatetime(vo.getCreatetime());
				createvo.setUpdateoprcode(user.getOpercode());
				createvo.setUpdatetime(nowDate);
				createvo.setRewardtype(new Short("-2"));
				createvo.setAdtoprcode(user.getOpercode());
				createvo.setAdttime(nowDate);
				createvo.setSrcmonth(content[6]);
				createvo = delegate.doCreate(createvo, user);

				line = rowCount + "   " + line + "    插入成功";
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
