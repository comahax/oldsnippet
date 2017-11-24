package com.gmcc.pboss.web.resource.emptysim;

import java.io.Serializable;
import org.apache.commons.lang.StringUtils;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.resource.compack.CompackBO;
import com.gmcc.pboss.control.resource.compack.Compack;
import com.gmcc.pboss.control.resource.emptysim.Emptysim;
import com.gmcc.pboss.control.resource.emptysim.EmptysimBO;
import com.gmcc.pboss.business.resource.compack.CompackVO;
import com.gmcc.pboss.business.resource.emptysim.EmptysimDBParam;
import com.gmcc.pboss.business.resource.emptysim.EmptysimVO;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class EmptysimWayidTaskBean extends BaseBatchTaskBean {

	public EmptysimWayidTaskBean() throws Exception{
		super.setBatchName("�հ�SIM����������");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try{ 
			//�տ����к�|��Ʒ��ʶ|����������|
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");
			Emptysim emptySimBO = (Emptysim)BOFactory.build(EmptysimBO.class, user);
			
			//���ݿհ׿����кź���Ʒ��ʶ��ѯ�հ׿���Դ��IM_FX_EMPTYSIM��
			EmptysimDBParam emptysimDBParam = new EmptysimDBParam();
			emptysimDBParam.set_ne_emptyno(Long.parseLong(items[0]));
			emptysimDBParam.set_ne_comid(Long.parseLong(items[1])); 
			DataPackage dp = emptySimBO.doQuery(emptysimDBParam);
			EmptysimVO  vo = null;
			if(dp.getDatas().size()==0){
				throw new Exception("�հ׿����ݲ�����");
			}else {
				//�Բ�ѯ�����״̬�����жϣ�������ǡ�����--1���򡰴�����--30��״̬����д����ԭ�򡰿հ׿�״̬����ȷ��
			    vo = (EmptysimVO) dp.getDatas().get(0);
				if(vo.getUsestate() != 1 && vo.getUsestate() != 30) 
					throw new Exception("�հ׿�״̬����ȷ");  
			} 
			//���������������ѯ������(CH_PW_WAY),����޽��������д����ԭ�����������ݲ����ڡ�
			Way wayBO = (WayBO)BOFactory.build(WayBO.class, user);
			WayVO wayVO = wayBO.doFindByPk(items[2]);
			if(null==wayVO){
				 throw new Exception("���������ݲ�����");  
			}else{
				//�Բ�ѯ����������Ϣ���������״̬[waystate]�����жϣ��������״̬��Ϊ1��Ч������д����ԭ��������������Ч����
				if( wayVO.getWaystate()!=1)
					 throw new Exception("������������Ч");  
			} 
            //	 ���¿հ׿������е�������ʶΪ���������룬ͬʱ�Ǽǿհ׿���־��IM_FX_EMPTYSIMLOG����
			
			vo.setWayid(items[2]);
			emptySimBO.doUpdate(vo);
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
