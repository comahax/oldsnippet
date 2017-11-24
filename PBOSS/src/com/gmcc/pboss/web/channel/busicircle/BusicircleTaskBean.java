package com.gmcc.pboss.web.channel.busicircle;

import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.channel.busicircle.BusicircleVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.channel.busicircle.Busicircle;
import com.gmcc.pboss.control.channel.busicircle.BusicircleBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;

public class BusicircleTaskBean extends BaseBatchTaskBean{ 
	
	public BusicircleTaskBean() throws Exception {
		super.setBatchName("��Ȧ���������������");
		super.setOprtype("����");
		super.setWriteLog(true); 
	}

	protected String doStart() {
		return "�к�|��Ȧ����|��Ȧ����|��Ȧ����|�ֹ�˾|��Ȧ��ַ|������|  \r\n";
	}
	//��������  ���˷�ʽ  �������� ��������
	@Override
	protected ResultVO processLine(String line, int rowCount) {
		 
		ResultVO resultVO = new ResultVO();
		try {
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");  
			Busicircle busicircleBO = (Busicircle)BOFactory.build(BusicircleBO.class, DBAccessUser.getInnerUser()) ;
			BusicircleVO VO = busicircleBO.doFindByPk(items[0]);
			BusicircleVO busicircleVO = new BusicircleVO();
			
			busicircleVO.setBuscno(items[0]);
			busicircleVO.setBuscelevel(items[2]);
			busicircleVO.setCreatetime(new Date());
			 
			busicircleVO.setCountyid(items[3]);
			busicircleVO.setCityid(user.getCityid());
			if ( null != items[1]){
			     busicircleVO.setBuscname(items[1]);	
			} 
			if (null != items[4]) {
			     busicircleVO.setBuscaddr(items[4]);	
			}
			if (null!=VO){
				BeanUtils.copyProperties(VO, busicircleVO);
				busicircleBO.doUpdate(VO);
			}else{
				busicircleBO.doCreate(busicircleVO);
			} 
 			line = rowCount
			        + "|"
			        + items[0] + "|" + items[1]+ "|"+items[2]+ "|"+items[3]+ "|"+items[4]
					+ "|"+"�����ɹ�"+"|";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		} catch (Exception e) { 
			line = rowCount + "   " + line + "|������Ϣ:" + e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	} 
}
