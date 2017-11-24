package com.gmcc.pboss.control.resource.comressmp;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gmcc.pboss.business.resource.compack.CompackVO;
import com.gmcc.pboss.business.resource.comressmp.ComressmpDBParam;
import com.gmcc.pboss.business.resource.comressmp.ComressmpVO;
import com.gmcc.pboss.business.resource.discomres.DiscomresDBParam;
import com.gmcc.pboss.business.resource.discomres.DiscomresVO;
import com.gmcc.pboss.business.resource.resdisform.ResdisformDAO;
import com.gmcc.pboss.business.resource.resdisform.ResdisformDBParam;
import com.gmcc.pboss.business.resource.resdisform.ResdisformVO;
import com.gmcc.pboss.control.resource.compack.Compack;
import com.gmcc.pboss.control.resource.compack.CompackBO;
import com.gmcc.pboss.control.resource.discomres.Discomres;
import com.gmcc.pboss.control.resource.discomres.DiscomresBO;
import com.gmcc.pboss.control.resource.resdisform.Resdisform;
import com.gmcc.pboss.control.resource.resdisform.ResdisformBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;



public class ComressmpDeployBO extends AbstractControlBean implements ComressmpDeploy{

	private Log log = LogFactory.getLog(ComressmpDeployBO.class);
	
	public void process() throws Exception {
		// TODO Auto-generated method stub
		ComressmpDeployBO comressmpDeployBO = (ComressmpDeployBO)BOFactory.build(ComressmpDeployBO.class,user);
		
//		��ѯ��Դ���䵥��IM_PR_RESDISFORM�������䵥״̬Ϊ����������������ʱ��Ϊ<=��ǰʱ��+60��
//		����޲�ѯ������������״̬������ָ��ʱ������������������ѯ���������������������
//		Date date = new Date();
//		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
//		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		Resdisform resdisformBO = (ResdisformBO) BOFactory.build(ResdisformBO.class,user);
		ResdisformDBParam resdisformParams = new ResdisformDBParam ();
		resdisformParams.setQueryAll(true);
		resdisformParams.setDataOnly(true);
		resdisformParams.set_se_disformstate("WAITISSUE");	
		
		DataPackage resdisformDP = comressmpDeployBO.doResourceDeployQuery(resdisformParams);
		
		if( null != resdisformDP && null != resdisformDP.getDatas() && resdisformDP.getDatas().size()>0){
			List<ResdisformVO> list = (List<ResdisformVO>)resdisformDP.getDatas();
			for(ResdisformVO resdisformVO : list){
				try{
					comressmpDeployBO.doDeploy(resdisformVO);
				}catch(Exception e){
					LoggerUtils.error(e, log);
				}
			}
		}else{
			log.info("============= �򲻵���������(���䵥״̬Ϊ����������������ʱ��Ϊ<=��ǰʱ��+60�������)�ķ��䵥 ===============");
		}

	}

	//��ѯ���䵥
	public DataPackage doResourceDeployQuery(ResdisformDBParam param) throws Exception{
		ResdisformDAO resdisformDAO = (ResdisformDAO)DAOFactory.build(ResdisformDAO.class,user);
		return resdisformDAO.queryByNamedSqlQuery("com.gmcc.pboss.business.resource.resdisform.resourceDeployQuery", param);
	}
	
	
	public void doDeploy(ResdisformVO resdisformVO) throws Exception {
		
//		2���ݷ��䵥�ź������̱����ѯ��������Դ��IM_PR_DISCOMRES������ȡ��Ʒ���κͰ�����Ϣ��
		Discomres discomresBO =  (DiscomresBO)BOFactory.build(DiscomresBO.class,user);
		Compack compackBO = (CompackBO)BOFactory.build(CompackBO.class,user);
		Comressmp comressmpBO = (ComressmpBO)BOFactory.build(ComressmpBO.class,user);
		DiscomresDBParam discomresParam = new DiscomresDBParam();
		discomresParam.setQueryAll(true);
		discomresParam.setDataOnly(true);
		discomresParam.set_se_disid(resdisformVO.getDisid());
		discomresParam.set_se_discomcode(resdisformVO.getDiscomcode());
		DataPackage discomresDP = discomresBO.doQuery(discomresParam);

		if( null != discomresDP && null != discomresDP.getDatas() && discomresDP.getDatas().size()>0){
			List<DiscomresVO> discomresList = (List<DiscomresVO>)discomresDP.getDatas();
			
			for(DiscomresVO discomresVO : discomresList){
				CompackVO  compackVO = new CompackVO();
				compackVO.setBatchno(discomresVO.getBatchno());
				compackVO.setBoxnum(discomresVO.getBoxnum());
				compackVO = compackBO.doFindByPk(compackVO);
//				3������Ʒ���κͰ��������޸���Ʒ����IM_PR_COMPACK����״̬Ϊ�����ۡ���
				if(null != compackVO){
					compackVO.setPackstate("1");
					log.info("============= ������Ʒ����["+discomresVO.getBatchno()+"] �Ͱ���["+discomresVO.getBoxnum()+"]�����޸���Ʒ����IM_PR_COMPACK����״̬Ϊ�����ۡ�===============");
					}
//				4������Ʒ���κͰ��������޸��׿���Դ��IM_FX_COMRESSMP����Ʒ״̬Ϊ�����ۡ���
				ComressmpDBParam comressmparam = new ComressmpDBParam();
				comressmparam.setQueryAll(true);
				comressmparam.setDataOnly(true);
				comressmparam.set_se_boxnum(discomresVO.getBoxnum());
				comressmparam.set_se_batchno(discomresVO.getBatchno());
				DataPackage comressmpDP = comressmpBO.doQuery(comressmparam);
				if( null != comressmpDP && null != comressmpDP.getDatas() && !comressmpDP.getDatas().isEmpty()){
					for(ComressmpVO comressmpVO:(List<ComressmpVO>)comressmpDP.getDatas()){
						comressmpVO.setComstate(new Short("1"));
						comressmpBO.doUpdate(comressmpVO);
					}
				}
				log.info("============= ������Ʒ����["+discomresVO.getBatchno()+"] �Ͱ���["+discomresVO.getBoxnum()+"]�����޸��׿���Դ��IM_FX_COMRESSMP����Ʒ״̬Ϊ�����ۡ�===============");
			}
//			5�޸ķ��䵥״̬Ϊ���ѷ�������			
			resdisformVO.setDisformstate("ISSUED");
			Resdisform resdisformBO = (ResdisformBO)BOFactory.build(ResdisformBO.class, user);
			resdisformBO.doUpdate(resdisformVO);

		}else{
			log.info("============= ���ݷ��䵥��["+resdisformVO.getDisid()+"] �������̱���["+resdisformVO.getDiscomcode()+"]��ѯ��������Դ��IM_PR_DISCOMRES������ȡ��Ʒ���κͰ�����Ϣ �򲻵���ؼ�¼===============");
		}
	}
	
}
