package com.gmcc.pboss.web.sales.canorderinfo;

import org.apache.commons.lang.StringUtils;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.sales.canorderinfo.CanorderinfoVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.sales.canorderinfo.Canorderinfo;
import com.gmcc.pboss.control.sales.canorderinfo.CanorderinfoBO;
import com.sunrise.jop.infrastructure.control.BOFactory;

public class CanorderinfoNoticeTaskBean extends BaseBatchTaskBean{

	public CanorderinfoNoticeTaskBean() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected String doStart() {
		return "合作商编码|短信内容|出错原因|  \r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		// TODO Auto-generated method stub 
		ResultVO resultVO = new ResultVO();
		//CanorderinfoVO coiVO = new CanorderinfoVO();
		String wayid = "";
		String smsContent = "";	//短信内容
		String sendNum = "";		
		String officetel =  "";
		try{
			String[] content = StringUtils.splitPreserveAllTokens(line, "|");			
			if(content[0]!=null && !content[0].equals("")){
				wayid = content[0];	
			}
			
			
			Canorderinfo canorderinfo = (Canorderinfo) BOFactory.build(CanorderinfoBO.class,user);
			
			WayVO wayvo = new WayVO();//合作商信息
			
			canorderinfo.doCheckWayAndModel(user, wayvo, wayid);
			
			CanorderinfoVO coiVO = canorderinfo.doNotceOne(user, wayvo);
			smsContent = coiVO.getSmsContent();	//短信内容
			sendNum = coiVO.getSendNum();		
			officetel =  coiVO.getOfficetel();
			/*
			 * 此处发送短信
			 */
			WaitreqBO waitreqBO = (WaitreqBO)BOFactory.build(WaitreqBO.class,user);    				    				
			waitreqBO.doInsert2(new Short("3"), smsContent, sendNum,officetel);
			//waitreqBO.doInsert3(new Short("3"), smsContent, sendNum, officetel,new Date());
						
			line=wayid+"|"+smsContent+"|成功";
			resultVO.setInfo(line);
			resultVO.setOk(true);			
		}catch(Exception e){
			line = line + "|"+ smsContent + "|" + e.getMessage() + "|";
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		
		return resultVO;
	}

}
