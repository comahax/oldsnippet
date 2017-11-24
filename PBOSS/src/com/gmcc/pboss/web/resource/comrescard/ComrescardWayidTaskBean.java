package com.gmcc.pboss.web.resource.comrescard;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.resource.comrescard.Comrescard;
import com.gmcc.pboss.control.resource.comrescard.ComrescardBO;
import com.gmcc.pboss.business.resource.comrescard.ComrescardVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.common.utils.bean.BeanUtils;


public class ComrescardWayidTaskBean extends BaseBatchTaskBean{
	
	public ComrescardWayidTaskBean() throws Exception{
		super.setBatchName("��ֵ����������");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try{
			Comrescard  bo = (Comrescard)BOFactory.build(ComrescardBO.class, user);
			//��Ʒ��Դ���롢��Ʒ��ʶ������������
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");
			Serializable pkVO = new ComrescardVO();
			BeanUtils.setProperty(pkVO, "comresid", items[0]);
			BeanUtils.setProperty(pkVO, "comid", items[1]);
			ComrescardVO comrescardVO = bo.doFindByPk(pkVO);
			//����ֵ����¼�Ƿ����
			if(comrescardVO==null){
				throw new Exception("��ֵ�����ݲ�����|");
			}
			//����ֵ��״̬�Ƿ񡰿��ۡ��������䡱
			if(comrescardVO.getComstate()!=1 && comrescardVO.getComstate()!=30){//�������Ҳ��ɷ���
				throw new Exception("��ֵ��״̬����ȷ|");
			}
			Way wayBO = (Way)BOFactory.build(WayBO.class, user);
			
			/*ȡ��ͬһ�ֹ�˾������*/
			////���ݳ�ֵ����ѯ��¼����ȡ����������
			//WayVO oldWay = wayBO.doFindByPk(comrescardVO.getWayid());
			////��ȡ����Ա��������
			//WayVO operatorWayVO = wayBO.doFindByPk(user.getWayid());
		    ////�жϳ�ֵ�������ֹ�˾�����Ա���������ֹ�˾�Ƿ���ͬ
			//if(!oldWay.getCountyid().equals(operatorWayVO.getCountyid())){
			//	throw new Exception("��ֵ�������ڸ÷ֹ�˾��Ͻ|");
			//}
			
			//���������������ȡ������¼
			WayVO newWay = wayBO.doFindByPk(items[2]);
			//����������Ƿ���ڣ�״̬�Ƿ�Ϊ��1����Ч
			if(newWay==null){
				throw new Exception("���������ݲ�����|");
			}
			if(newWay.getWaystate()!=1){
				throw new Exception("������������Ч|");
			}
			
			/*ȡ��ͬһ�ֹ�˾������*/
			////��������������ֹ�˾�Ƿ������Ա�����ֹ�˾һ�£����򲻹����Ͻ
			//if(!operatorWayVO.getCountyid().equals(newWay.getCountyid())){
			//	throw new Exception("�����������ڸ÷ֹ�˾��Ͻ|");
			//}
			
			comrescardVO.setWayid(items[2]);
			bo.doUpdate(comrescardVO);
			line=rowCount+"|"+line+"|";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		}catch(Exception e){
			line = rowCount+"|"+line+e.getMessage();
			e.printStackTrace();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}

}
