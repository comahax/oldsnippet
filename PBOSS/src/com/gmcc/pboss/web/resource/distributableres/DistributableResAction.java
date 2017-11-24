package com.gmcc.pboss.web.resource.distributableres;

import java.util.ArrayList;
import java.util.List;


import com.gmcc.pboss.business.channel.cntycompany.CntycompanyDBParam;
import com.gmcc.pboss.business.channel.cntycompany.CntycompanyVO;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaVO;
import com.gmcc.pboss.business.resource.distributableres.DistributableResDBParam;
import com.gmcc.pboss.business.resource.distributableres.DistributableResVO;
import com.gmcc.pboss.control.channel.cntycompany.Cntycompany;
import com.gmcc.pboss.control.channel.cntycompany.CntycompanyBO;
import com.gmcc.pboss.control.resource.comcategoryrela.Comcategoryrela;
import com.gmcc.pboss.control.resource.comcategoryrela.ComcategoryrelaBO;
import com.gmcc.pboss.control.resource.distributableres.DistributableRes;
import com.gmcc.pboss.control.resource.distributableres.DistributableResBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

public class DistributableResAction extends BaseAction {

	public DistributableResAction() {
		super();

		//以下几个方法是必须的
		this.setParam(new DistributableResDBParam());
		//指定VO类
        setClsVO(DistributableResVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.setClsControl(DistributableRes.class);
		this.setClsQueryParam(DistributableResDBParam.class) ;

	}

	
	public String doList()throws Exception {
		try {
			DistributableResDBParam param = (DistributableResDBParam) getParam();
			DistributableRes bo = (DistributableRes) BOFactory.build(DistributableResBO.class,super.getDBAccessUser());
			
			ComcategoryrelaDBParam comcategoryrelaParam=new ComcategoryrelaDBParam();
			List<CntycompanyVO>  cntycompanyList=null;
			// 查询县公司信息表（CH_PW_CNTYCOMPANY），获取分公司集合
			CntycompanyDBParam cntycompanyParam=new CntycompanyDBParam();
			Cntycompany cntycompanyBO = (Cntycompany) BOFactory.build(CntycompanyBO.class, getDBAccessUser());
			cntycompanyParam.set_se_citycompid(getDBAccessUser().getCityid());
			
			if(!StringUtils.isEmpty(param.get_se_countyid())){
				cntycompanyParam.set_se_countycompid(param.get_se_countyid());
				BeanUtils.copyProperties(comcategoryrelaParam, param);
				comcategoryrelaParam.set_pagesize("20");
			}else{
				BeanUtils.copyProperties(cntycompanyParam, param);
				comcategoryrelaParam.set_pagesize("0");
			}
		
			DataPackage cntdata=cntycompanyBO.doQuery(cntycompanyParam);
			cntycompanyList=cntdata.getDatas();
			Comcategoryrela comcategoryrelaBO = (Comcategoryrela) BOFactory.build(ComcategoryrelaBO.class, getDBAccessUser());
			if(!StringUtils.isEmpty(param.get_se_comcategory())){
				comcategoryrelaParam.set_se_comcategory(param.get_se_comcategory());
			}
			if(!StringUtils.isEmpty(param.get_se_brand())){
				comcategoryrelaParam.set_se_brand(param.get_se_brand());
			}
			
			DataPackage comcategoryreladata=comcategoryrelaBO.doQueryDistinctComcategory(comcategoryrelaParam);//comcategoryrelaBO.doQuery(comcategoryrelaParam);
			//List<ComcategoryrelaVO>  comcategoryrelaList=comcategoryreladata.getDatas();
			List<Object[]>  comcategoryrelaList=comcategoryreladata.getDatas();
			DistributableResVO distributableResVO=null;
			List<DistributableResVO> list=new ArrayList<DistributableResVO>();
			ComcategoryrelaVO comcatVO=null;
			for(CntycompanyVO cntVO:cntycompanyList){
				for(Object[] objs:comcategoryrelaList){
					comcatVO=new ComcategoryrelaVO();
					comcatVO.setComcategory((String)objs[0]);
					comcatVO.setBrand((String)objs[1]);
					comcatVO.setRestype((String)objs[2]);
					distributableResVO=bo.doGetDistributableRes(cntVO, comcatVO);
					list.add(distributableResVO);
				}
			}
			/*for(CntycompanyVO cntVO:cntycompanyList){
				for(ComcategoryrelaVO comcatVO:comcategoryrelaList){
					
				}
			}*/
			
			DataPackage dp=new DataPackage();
			dp.setDatas(list);
			if(!StringUtils.isEmpty(param.get_se_countyid())){
				dp.setPageNo(comcategoryreladata.getPageNo());
				dp.setPageSize(comcategoryreladata.getPageSize());
				dp.setRowCount(comcategoryreladata.getRowCount());
				BeanUtils.copyProperties(param,comcategoryrelaParam);
			}else{
				dp.setPageNo(comcategoryreladata.getPageNo());
				dp.setPageSize(comcategoryreladata.getPageSize());
				dp.setRowCount(cntdata.getRowCount()*comcategoryreladata.getRowCount());
				BeanUtils.copyProperties(param,cntycompanyParam);
			}
			super.setDp(dp);
		} catch (Exception e) {
			super.addActionError(e.getMessage());
			e.printStackTrace();
		}
		return "list";
	}
}
