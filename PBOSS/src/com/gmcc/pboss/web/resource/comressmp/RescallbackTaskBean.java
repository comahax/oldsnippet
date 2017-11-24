package com.gmcc.pboss.web.resource.comressmp;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.resource.compack.CompackVO;
import com.gmcc.pboss.business.resource.comrescard.ComrescardVO;
import com.gmcc.pboss.business.resource.comressmp.ComressmpVO;
import com.gmcc.pboss.business.resource.emptysim.EmptysimDBParam;
import com.gmcc.pboss.business.resource.emptysim.EmptysimVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.resource.compack.Compack;
import com.gmcc.pboss.control.resource.compack.CompackBO;
import com.gmcc.pboss.control.resource.comrescard.Comrescard;
import com.gmcc.pboss.control.resource.comrescard.ComrescardBO;
import com.gmcc.pboss.control.resource.comressmp.Comressmp;
import com.gmcc.pboss.control.resource.comressmp.ComressmpBO;
import com.gmcc.pboss.control.resource.emptysim.Emptysim;
import com.gmcc.pboss.control.resource.emptysim.EmptysimBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class RescallbackTaskBean extends BaseBatchTaskBean{
	
	public RescallbackTaskBean() throws Exception {
		super.setBatchName("��Դ����");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ResultVO processLine(String line, int rowCount) {
		// TODO Auto-generated method stub
		ResultVO resultVO = new ResultVO();
		try{
			String rescallback=(String)this.parameterMap.get("callbacktype");
			//��Ʒ��Դ���|��Ʒ��ʶ
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");
			String codeName = "";
			if("COMRESSMP".equals(rescallback)){ //�׿�
				Comressmp csmp = (Comressmp)BOFactory.build(ComressmpBO.class, user);
				Serializable pkVO=new ComressmpVO();
				BeanUtils.setProperty(pkVO, "comid", items[1]);//��Ʒ��ʶ
				BeanUtils.setProperty(pkVO, "comresid", items[0]);//��Ʒ��Դ���
				ComressmpVO csvo = csmp.doFindByPk(pkVO);
				if(csvo == null)
					throw new Exception("�׿����ݲ�����");
				codeName = Code2NameUtils.code2Name("$FX_COMSTATE",  csvo.getComstate().toString() , user.getCityid());
				String batchno = csvo.getBatchno();
				String boxnum = csvo.getBoxnum();
				if(csvo.getComstate()!=1 && csvo.getComstate()!=30)
					throw new Exception("��Ʒ״̬����ֻ�п��ۻ�������������գ���ǰ��Ʒ״̬Ϊ"+codeName);
				csmp.doRemoveByVO(csvo);
				
				Compack bo = (Compack) BOFactory.build(CompackBO.class, user);
				Serializable pkVO2 =new CompackVO();
				BeanUtils.setProperty(pkVO2, "batchno", batchno);//��Ʒ����
				BeanUtils.setProperty(pkVO2, "boxnum", boxnum);//����
				CompackVO compackVO=bo.doFindByPk(pkVO2);
				if(compackVO!=null){
					if(compackVO.getAmount()-1>0){
						compackVO.setAmount((short)(compackVO.getAmount()-1));
						bo.doUpdate(compackVO);
					}else{
						bo.doRemoveByVO(compackVO);
					}
				}
			}else if("EMPTYSIM".equals(rescallback)){  //�հ�SIM��
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
					codeName = Code2NameUtils.code2Name("$FX_COMSTATE",  vo.getUsestate().toString(), user.getCityid());
					if(vo.getUsestate()!=1 && vo.getUsestate()!=30) 
						throw new Exception("��Ʒ״̬����ֻ�п��ۻ�������������գ���ǰ��Ʒ״̬Ϊ"+codeName);  
					emptySimBO.doRemoveByPK(vo.getEmptyno());
				}
			}else{   //��ֵ��
				Comrescard csd = (Comrescard)BOFactory.build(ComrescardBO.class, user);
				Serializable pkVO=new ComrescardVO();
				BeanUtils.setProperty(pkVO, "comid", items[1]);//��Ʒ��ʶ
				BeanUtils.setProperty(pkVO, "comresid", items[0]);//��Ʒ��Դ���
				ComrescardVO csdvo = csd.doFindByPk(pkVO);
				if(csdvo == null)
					throw new Exception("��ֵ�����ݲ�����");
				codeName = Code2NameUtils.code2Name("$FX_COMSTATE",  csdvo.getComstate().toString() , user.getCityid());
				if(csdvo.getComstate()!=1 && csdvo.getComstate()!=30)
					throw new Exception("��Ʒ״̬����ֻ�п��ۻ�������������գ���ǰ��Ʒ״̬Ϊ"+codeName);
				csd.doRemoveByVO(csdvo);
			}
			line = rowCount + "   " + line + "    �ɹ�";
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
