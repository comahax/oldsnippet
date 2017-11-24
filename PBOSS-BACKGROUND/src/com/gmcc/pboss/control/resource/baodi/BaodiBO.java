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
//		查询系统参数配置表获取保底资源有效期（单位小时），SQL大致如下：
//		select paramvalue from  
//		where PARAMTYPE='pboss_fx' and SYSTEMID=31
//		如果无数据则默认有效期为48小时。
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
//		查询商品包表（IM_PR_COMPACK），匹配包状态为1可售、所属库区为BD保底资源，
//		如果无结果数据则退出，如果有结果数据，则逐条处理：

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
//		1)	根据批次和包号查询配送商资源表（IM_PR_DISCOMRES），如果无结果数据则返回处理下一条数据；否则，记录分配单号。
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
//					2)	根据分配单号查询资源分配单表（IM_PR_RESDISFORM），如果无结果数据则返回处理下一条数据；否则，记录发布时间(非修改发布时间)。
					ResdisformDBParam resdisformParam = new ResdisformDBParam();
					resdisformParam.setQueryAll(true);
					resdisformParam.setDataOnly(true);
					resdisformParam.set_se_disid(discomresVO.getDisid());
					DataPackage resdisformDP = resdisformBO.doQuery(resdisformParam);
					if( null != resdisformDP && null != resdisformDP.getDatas() && 0<resdisformDP.getDatas().size()){
						Collection<ResdisformVO> resdisformLis = resdisformDP.getDatas();
						for(ResdisformVO resdisformVO :resdisformLis ){
							try{
//								3)	判断 当前时间>=发布时间+有效期 是否成立，如果不成立则返回处理下一条数据；否则，修改商品包所属库区为ZG直供资源，返回。
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
