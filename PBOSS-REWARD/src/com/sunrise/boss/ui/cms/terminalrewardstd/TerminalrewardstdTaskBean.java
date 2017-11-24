package com.sunrise.boss.ui.cms.terminalrewardstd;

 
import org.apache.commons.lang.StringUtils; 
import com.sunrise.boss.business.cms.terminalrewardstd.persistent.TerminalrewardstdListVO;
import com.sunrise.boss.business.cms.terminalrewardstd.persistent.TerminalrewardstdVO;
import com.sunrise.boss.common.base.db.DataPackage; 
import com.sunrise.boss.delegate.cms.terminalrewardstd.TerminalrewardstdDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class TerminalrewardstdTaskBean extends BaseBatchTaskBean {
	
	private String region;
	
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public TerminalrewardstdTaskBean() throws Exception {
		super.setBatchName("�ն˳���׼����������");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub
	}

	protected String doStart() {
		return "�ն˳���׼���������� \r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		
		String region =getRegion();
		ResultVO resultVO = new ResultVO(); 
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		try {
			
			TerminalrewardstdDelegate td=new TerminalrewardstdDelegate();
			TerminalrewardstdListVO listvo=new TerminalrewardstdListVO();
			listvo.set_se_comid(content[0]);
			if("999".equals(region)){
				
				listvo.set_ne_citycode("999");
			}
			else{
				
				listvo.set_ne_citycode(user.getCityid());
				region=user.getCityid();
			} 
			listvo.set_ne_rewardtype(content[3]);
			DataPackage dp=td.doQuery(listvo, user);
			if(dp!=null&&dp.getDatas().size()>0){ 
				TerminalrewardstdVO vo=new TerminalrewardstdVO();
				vo.setAcctype(Short.parseShort(content[4]));
				vo.setAdtremark(content[5]);
				java.util.Date date = new java.util.Date();
				vo.setCreatetime(date); 
				vo.setComid(content[0]);
				vo.setStandardprice(Double.parseDouble(content[1]));
				if(content[2] != null && !"".equals(content[2])){
					vo.setRewardstd(Double.parseDouble(content[2]));	
				} 
				vo.setRewardtype(Short.parseShort(content[3]));
				vo.setCitycode(Short.parseShort(region)); 
				td.doUpdate(vo, user);
			}	 
			else{  
				TerminalrewardstdVO vo=new TerminalrewardstdVO();
				vo.setComid(content[0]);
				vo.setRewardtype(Short.parseShort(content[3]));
				vo.setCitycode(Short.parseShort(region));
				vo.setAcctype(Short.parseShort(content[4]));
				vo.setAdtremark(content[5]);
				java.util.Date date = new java.util.Date();
				vo.setCreatetime(date);
				if(content[1] != null && !"".equals(content[1])){
					vo.setStandardprice((Double.parseDouble(content[1])));	
				}
				if(content[2] != null && !"".equals(content[2])){
					vo.setRewardstd(Double.parseDouble(content[2]));	
				} 
			  
				
				td.doCreate(vo, user);
			}
			
			line = rowCount + "   " + line + "    �����ɹ�";
			resultVO.setOk(true);
			resultVO.setInfo(line);
			return resultVO;
			}catch (Exception ex) { // ����ʧ��
				line = rowCount + "   " + line + "    ������Ϣ:" + ex.getMessage();
				resultVO.setInfo(line);
				resultVO.setOk(false);
			}
			
		return resultVO;
	}


}