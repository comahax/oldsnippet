package com.gmcc.pboss.web.resource.com;

import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.resource.numtyperule.NumtyperuleDBParam;
import com.gmcc.pboss.business.resource.numtyperule.NumtyperuleVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.resource.com.Com;
import com.gmcc.pboss.control.resource.com.ComBO;
import com.gmcc.pboss.control.resource.numtyperule.Numtyperule;
import com.gmcc.pboss.control.resource.numtyperule.NumtyperuleBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class PhoneTypeTask extends BaseBatchTaskBean{
	List<NumtyperuleVO> typeruleList = null;//���������ʽ�б�
	public PhoneTypeTask() throws Exception {
		super.setBatchName("��������ʶ��");
	}
	
	
	
	@Override
	public void doProcessFile(String fileInPath, String fileOutPath)
			throws Exception {
		// TODO Auto-generated method stub

		Numtyperule numtyperuleBO = (Numtyperule)BOFactory.build(NumtyperuleBO.class,user);
		NumtyperuleDBParam dbParam = new NumtyperuleDBParam();
		dbParam.setDataOnly(true);
		dbParam.setQueryAll(true);
		typeruleList = numtyperuleBO.doGetNumtyperuleList(dbParam );	
		super.doProcessFile(fileInPath, fileOutPath);
	}



	@Override
	protected ResultVO processLine(String line, int rowCount) {
		// TODO Auto-generated method stub
//		���ú�������߼���������Դ����߼�����ȡ�������ͣ������ȡ�ɹ���
//		����������������������У������ȡ��������ʧ�ܣ��������������д����ȡ�������ͳ�����

		ResultVO resultVO = new ResultVO();
		try{
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");
			Numtyperule numtyperuleBO = (Numtyperule)BOFactory.build(NumtyperuleBO.class,user);
			Long typeID = numtyperuleBO.doMatchNumber(items[0], typeruleList);
			if(null == typeID)
				line += "��ȡ�������ͳ���";
			else
				line += Code2NameUtils.code2Name("#Numtypedef",typeID.toString(),user.getCityid());
			resultVO.setInfo(line);
			resultVO.setOk(true);
		}catch(Exception e){
			line += "��ȡ�������ͳ���";
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
}
