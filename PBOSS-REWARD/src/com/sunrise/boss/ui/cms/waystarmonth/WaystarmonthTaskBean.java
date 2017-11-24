package com.sunrise.boss.ui.cms.waystarmonth;


import java.util.Date;

import com.sunrise.boss.business.cms.waitaudit.persistent.WaitauditVO;
import com.sunrise.boss.business.cms.waystarmonth.persistent.WaystarmonthVO;
import com.sunrise.boss.delegate.cms.waystarmonth.WaystarmonthDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.pub.tools.StringSplit;

public class WaystarmonthTaskBean extends BaseBatchTaskBean {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WaystarmonthDelegate delegate;
	
	private Date nowDate;
	
	public WaystarmonthTaskBean() throws Exception{
		// TODO Auto-generated constructor stub
		delegate = new WaystarmonthDelegate();
		nowDate = new Date();
		super.setBatchName("��������Ǽ��·ݣ�����������������־��ѯ");
		super.setWriteLog(true);
	}
	
	public String doStart() {
		return "�����������|�·�(YYYYMM)|�Ǽ�|�׿�����|" + "\r\n";
	}
	
	public String doEnd() throws Exception {
        return "";
    }
	
	public ResultVO processLine(String line, int rowCount, User user, WaitauditVO vo) {
		ResultVO resultVO=new ResultVO();
		String[] content = StringSplit.split(line, "|");
		try{
			if(content.length == 3){
				WaystarmonthVO createvo=new WaystarmonthVO();
				createvo.setWayid(content[0]);
				createvo.setEftmonth(content[1]);
				boolean flag = delegate.doFindByPk(createvo, user) == null;
				createvo.setBusivalue(new Double(content[2]));
				createvo.setOpcode(vo.getOprcode());
				createvo.setOprtime(nowDate);
				if(flag){
					createvo = delegate.doCreate(createvo, user);
					line = rowCount + "   " + line + "    ����ɹ�";
				}else{
					createvo = delegate.doUpdate(createvo, user);
					line = rowCount + "   " + line + "    ���³ɹ�";
				}
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
