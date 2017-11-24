package com.gmcc.pboss.web.resource.comressmp;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.resource.compack.CompackBO;
import com.gmcc.pboss.control.resource.compack.Compack;
import com.gmcc.pboss.business.resource.compack.CompackVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;

public class ComressmpWayidTaskBean extends BaseBatchTaskBean {

	public ComressmpWayidTaskBean() throws Exception{
		super.setBatchName("�׿���������");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try{
			Compack packBO = (Compack)BOFactory.build(CompackBO.class, user);
			//��Ʒ���Ρ����š�����������
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");
			Serializable pkVO = new CompackVO();
			BeanUtils.setProperty(pkVO, "batchno", items[0]);
			BeanUtils.setProperty(pkVO, "boxnum", items[1]);
			CompackVO compackVO = packBO.doFindByPk(pkVO);
			//��Ʒ���Ƿ����
			if(compackVO==null){
				throw new Exception("��Ʒ�����ݲ�����|");
			}
			//״̬�Ƿ񡰿��ۡ��򡰴����䡱
			if( !"1".equals(compackVO.getPackstate()) && !"30".equals(compackVO.getPackstate()) ){
				throw new Exception("��Ʒ��״̬����ȷ|");
			}
			Way wayBO = (Way)BOFactory.build(WayBO.class, user);
			
			/*ȡ��ͬһ�ֹ�˾������*/
			////������Ʒ������ȡ����������
			//WayVO oldWay = wayBO.doFindByPk(compackVO.getWayid());
			////��ȡ����Ա��������
			//WayVO operatorWayVO = wayBO.doFindByPk(user.getWayid());
			////�ж���Ʒ�������ֹ�˾�����Ա���������ֹ�˾�Ƿ���ͬ
			//if(!oldWay.getCountyid().equals(operatorWayVO.getCountyid())){
			//	throw new Exception("��Ʒ�������ڸ÷ֹ�˾��Ͻ|");
			//}
			
			//�������������룬�ж����Ƿ������״̬Ϊ��1����Ч
			WayVO newWay = wayBO.doFindByPk(items[2]);
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
			
			//������Ʒ���е������׿�������Ϣwayid
			//������Ʒ��������Ϣwayid
			packBO.doUpdateComressmp(compackVO, items[2]);
			
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
