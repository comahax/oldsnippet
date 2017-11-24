package com.gmcc.pboss.web.examine.disexamine;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;  

import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO; 
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.examine.disexamine.DisexamineBO; 
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;


public class DisexamineTaskBean extends BaseBatchTaskBean {

	 

	public DisexamineTaskBean() throws Exception {
		super.setBatchName("�����̿��˹�����");
		super.setOprtype("����");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub

	}

	protected String doStart() {
		return "���|������|��������|�۷����|˵��|������Ϣ  \r\n";
	}

	@Override
	protected ResultVO processLine(String line, int rowCount) {
		// TODO Auto-generated method stub
		// String loginwayid = user.getWayid();
		ResultVO resultVO = new ResultVO();
		try {
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");
			DisexamineBO disexamineBo = (DisexamineBO) BOFactory.build(DisexamineBO.class, user);
			//��������Ϣ���
			Way way = (WayBO) BOFactory.build(WayBO.class, user);
			WayVO wayVO = way.doFindByPk(items[0].trim());
			if (wayVO == null ){
				throw  new Exception(items[0].trim()+"�����̲�����");
			}
			//�������ڼ��
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy");
			String year = items[1].trim().substring(0,4);
			String month = items[1].trim().substring(4);
			if ( !format.format(date).equals(year) || date.getMonth()+1!=Integer.parseInt(month) ) {
				throw new Exception(items[1].trim()+"�������ڲ�Ϊ����");
			}
			
		    disexamineBo.doDisexamineImport(items);  
			line = rowCount
					+ "|"
					+ Code2NameUtils.code2Name("#WAYIDINFO",items[0].trim(), user.getCityid()) 
					+ "|"+items[1].trim()+ "|"+items[2]+"|"+items[3].trim()+ "|"+"�����ɹ�";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		} catch (Exception e) { 
			line = rowCount + "|" + line + "|" +"����ʧ��:"+ e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}

}
