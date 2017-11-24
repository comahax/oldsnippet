package com.gmcc.pboss.control.resource.baodi;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gmcc.pboss.business.base.sysparam.SysparamDBParam;
import com.gmcc.pboss.business.base.sysparam.SysparamVO;
import com.gmcc.pboss.business.resource.compack.CompackDBParam;
import com.gmcc.pboss.business.resource.compack.CompackVO;
import com.gmcc.pboss.business.resource.discomres.DiscomresVO;
import com.gmcc.pboss.business.resource.resdisform.ResdisformDBParam;
import com.gmcc.pboss.business.resource.resdisform.ResdisformVO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.resource.compack.Compack;
import com.gmcc.pboss.control.resource.compack.CompackBO;
import com.gmcc.pboss.control.resource.discomres.Discomres;
import com.gmcc.pboss.control.resource.discomres.DiscomresBO;
import com.gmcc.pboss.control.resource.resdisform.Resdisform;
import com.gmcc.pboss.control.resource.resdisform.ResdisformBO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class BaodiBO extends AbstractControlBean implements Baodi{

	private Log log = LogFactory.getLog(BaodiBO.class);
	
	public void process() throws Exception {
		// TODO Auto-generated method stub
//		��ѯϵͳ�������ñ��ȡ������Դ��Ч�ڣ���λСʱ����SQL�������£�
//		select paramvalue from  
//		where PARAMTYPE='pboss_fx' and SYSTEMID=31
//		�����������Ĭ����Ч��Ϊ48Сʱ��
		int  efectiveTime = 48;
		Compack compackBO = (CompackBO)BOFactory.build(CompackBO.class,user);
		BaodiBO baidiBO = (BaodiBO) BOFactory.build(BaodiBO.class,user);
		Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,user);
		SysparamDBParam sysparamParam = new SysparamDBParam();
		sysparamParam.set_se_paramtype("pboss_fx");
		sysparamParam.set_ne_systemid("31");
		DataPackage sysparamDP = sysparamBO.doQuery(sysparamParam);
		if( null != sysparamDP && null != sysparamDP.getDatas() && 0<sysparamDP.getDatas().size()){
			SysparamVO sysparamvo = (SysparamVO) ((List)sysparamDP.getDatas()).get(0);
			efectiveTime = sysparamvo.getParamvalue() == null ? 48 :Integer.parseInt(sysparamvo.getParamvalue());
		}			
//		��ѯ��Ʒ����IM_PR_COMPACK����ƥ���״̬Ϊ1���ۡ���������ΪBD������Դ��
//		����޽���������˳�������н�����ݣ�����������

		CompackDBParam compackParam = new CompackDBParam();
		compackParam.setQueryAll(true);
		compackParam.setDataOnly(true);
		compackParam.set_se_packstate("1");
		compackParam.set_se_storarea("BD");
		DataPackage compackDP = compackBO.doQuery(compackParam);
		if( null != compackDP && null != compackDP.getDatas() && 0<compackDP.getDatas().size()){
			Collection<CompackVO> list = compackDP.getDatas();
			for(CompackVO compackVO : list){
				try{
					baidiBO.doRelease(compackVO,efectiveTime);
				}catch(Exception e){
					e.printStackTrace();
					log.error(e);
				}
			}
		}
	}

	public void doRelease(CompackVO compackVO,long  efectiveTime) throws Exception{
		Discomres discomresBO = (DiscomresBO)BOFactory.build(DiscomresBO.class,user);
		Resdisform resdisformBO = (ResdisformBO) BOFactory.build(ResdisformBO.class,user);
		Compack compackBO = (CompackBO)BOFactory.build(CompackBO.class,user);
//		1)	�������κͰ��Ų�ѯ��������Դ��IM_PR_DISCOMRES��������޽�������򷵻ش�����һ�����ݣ����򣬼�¼���䵥�š�
		DiscomresQueryParam discomresParam = new DiscomresQueryParam();
		discomresParam.setQueryAll(true);
		discomresParam.setDataOnly(true);
		discomresParam.set_se_batchno(compackVO.getBatchno());
		discomresParam.set_se_boxnum(compackVO.getBoxnum());
		DataPackage discomresDP = discomresBO.doQuery(discomresParam);
		if( null != discomresDP && null != discomresDP.getDatas() && 0<discomresDP.getDatas().size()){
			Collection<DiscomresVO> discomresList = discomresDP.getDatas();
			for(DiscomresVO discomresVO : discomresList){
				try{
//					2)	���ݷ��䵥�Ų�ѯ��Դ���䵥��IM_PR_RESDISFORM��������޽�������򷵻ش�����һ�����ݣ����򣬼�¼����ʱ��(���޸ķ���ʱ��)��
					ResdisformDBParam resdisformParam = new ResdisformDBParam();
					resdisformParam.setQueryAll(true);
					resdisformParam.setDataOnly(true);
					resdisformParam.set_se_disid(discomresVO.getDisid());
					DataPackage resdisformDP = resdisformBO.doQuery(resdisformParam);
					if( null != resdisformDP && null != resdisformDP.getDatas() && 0<resdisformDP.getDatas().size()){
						Collection<ResdisformVO> resdisformLis = resdisformDP.getDatas();
						for(ResdisformVO resdisformVO :resdisformLis ){
							try{
//								3)	�ж� ��ǰʱ��>=����ʱ��+��Ч�� �Ƿ����������������򷵻ش�����һ�����ݣ������޸���Ʒ����������ΪZGֱ����Դ�����ء�
								if(new Date().getTime()-resdisformVO.getIssutime().getTime()>=(efectiveTime*60*60*1000)){
									compackVO.setStorarea("ZG");
									compackBO.doUpdate(compackVO);
								}
							}catch(Exception e){
								e.printStackTrace();
								log.error(e);
							}
						}
					}										
				}catch(Exception e){
					e.printStackTrace();
					log.error(e);
				}
			}
		}
	}
}
