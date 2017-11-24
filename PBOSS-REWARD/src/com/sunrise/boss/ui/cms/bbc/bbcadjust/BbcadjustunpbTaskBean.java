package com.sunrise.boss.ui.cms.bbc.bbcadjust;


import java.util.Date;

import com.sunrise.boss.business.cms.bbc.bbcadjust.persistent.BbcadjustVO;
import com.sunrise.boss.business.cms.waitaudit.persistent.WaitauditVO;
import com.sunrise.boss.delegate.cms.bbc.bbcadjust.BbcadjustDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.pub.tools.StringSplit;

public class BbcadjustunpbTaskBean extends BaseBatchTaskBean {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BbcadjustDelegate delegate;
	
	private Date nowDate;
	
	public BbcadjustunpbTaskBean() throws Exception{
		// TODO Auto-generated constructor stub
		delegate = new BbcadjustDelegate();
		nowDate = new Date();
		super.setBatchName("ȫԱ�����������������־��ѯ");
		super.setWriteLog(true);
	}
	
	public String doStart() {
		return "�������|�������|���ý����·�(YYYYMM)|�������|����ԭ������|��ע|�������(YYYYMM)|" + "\r\n";
	}
	
	public String doEnd() throws Exception {
        return "";
    }
	
	public ResultVO processLine(String line, int rowCount, User user, WaitauditVO vo) {
		ResultVO resultVO=new ResultVO();
		String[] content = StringSplit.split(line, "|");
		BbcadjustVO createvo=new BbcadjustVO();
		try{
			if(vo.getSubsystem() == 7){
				createvo.setAdjustkind(content[0]);
				createvo.setWayid(content[1]);
				createvo.setEftmonth(content[2]);
				createvo.setAdjmoney(new Double(content[3]));
				createvo.setReasontype(content[4]);
				createvo.setRemark(content[5]);
				createvo.setSrcmonth(content[6]);
			}else if(vo.getSubsystem() == 8){
				createvo.setAdjustkind(content[0]);
				createvo.setWayid(content[1]);
				createvo.setMobile(content[2]);
				createvo.setEftmonth(content[3]);
				createvo.setAdjmoney(new Double(content[4]));
				createvo.setReasontype(content[5]);
				createvo.setRemark(content[6]);
				createvo.setSrcmonth(content[7]);
			}
			createvo.setCreateoprcode(vo.getOprcode());
			createvo.setCreatetime(vo.getCreatetime());
			createvo.setUpdateoprcode(user.getOpercode());
			createvo.setAdtoprcode(user.getOpercode());
			createvo.setUpdatetime(nowDate);
			createvo.setAdttime(nowDate);
			createvo.setIslock(new Short("1"));
			createvo.setRewardtype(new Short("-2"));
			createvo.setOssrc(new Short("3"));
			delegate.doCreate(createvo, user);
			line = rowCount + "   " + line + "    ����ɹ�";
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
