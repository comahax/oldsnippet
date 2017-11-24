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
		
//		查询资源分配单（IM_PR_RESDISFORM），分配单状态为“待发布”，发布时间为<=当前时间+60秒
//		如果无查询结果则进入休眠状态，休眠指定时间后重新启动；如果查询结果，则结果数据逐条处理：
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
			log.info("============= 打不到满足条件(分配单状态为“待发布”，发布时间为<=当前时间+60秒的数据)的分配单 ===============");
		}

	}

	//查询分配单
	public DataPackage doResourceDeployQuery(ResdisformDBParam param) throws Exception{
		ResdisformDAO resdisformDAO = (ResdisformDAO)DAOFactory.build(ResdisformDAO.class,user);
		return resdisformDAO.queryByNamedSqlQuery("com.gmcc.pboss.business.resource.resdisform.resourceDeployQuery", param);
	}
	
	
	public void doDeploy(ResdisformVO resdisformVO) throws Exception {
		
//		2根据分配单号和配送商编码查询配送商资源表（IM_PR_DISCOMRES），获取商品批次和包号信息。
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
//				3根据商品批次和包号批量修改商品包（IM_PR_COMPACK）包状态为“可售”。
				if(null != compackVO){
					compackVO.setPackstate("1");
					log.info("============= 根据商品批次["+discomresVO.getBatchno()+"] 和包号["+discomresVO.getBoxnum()+"]批量修改商品包（IM_PR_COMPACK）包状态为“可售”===============");
					}
//				4根据商品批次和包号批量修改套卡资源表（IM_FX_COMRESSMP）商品状态为“可售”。
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
				log.info("============= 根据商品批次["+discomresVO.getBatchno()+"] 和包号["+discomresVO.getBoxnum()+"]批量修改套卡资源表（IM_FX_COMRESSMP）商品状态为“可售”===============");
			}
//			5修改分配单状态为“已发布”。			
			resdisformVO.setDisformstate("ISSUED");
			Resdisform resdisformBO = (ResdisformBO)BOFactory.build(ResdisformBO.class, user);
			resdisformBO.doUpdate(resdisformVO);

		}else{
			log.info("============= 根据分配单号["+resdisformVO.getDisid()+"] 和配送商编码["+resdisformVO.getDiscomcode()+"]查询配送商资源表（IM_PR_DISCOMRES），获取商品批次和包号信息 打不到相关记录===============");
		}
	}
	
}
