package com.gmcc.pboss.control.resource.distributableres;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.channel.cntycompany.CntycompanyDAO;
import com.gmcc.pboss.business.channel.cntycompany.CntycompanyDBParam;
import com.gmcc.pboss.business.channel.cntycompany.CntycompanyVO;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDAO;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaVO;
import com.gmcc.pboss.business.resource.comressmp.ComressmpDAO;
import com.gmcc.pboss.business.resource.distributableres.DistributableResDBParam;
import com.gmcc.pboss.business.resource.distributableres.DistributableResVO;
import com.gmcc.pboss.business.sales.order.OrderDAO;
import com.gmcc.pboss.business.sales.order.OrderDBParam;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class DistributableResBO extends AbstractControlBean implements DistributableRes {

	public DistributableResVO 	doGetDistributableRes(CntycompanyVO cntVO,ComcategoryrelaVO comcatVO) throws Exception {
		
		ComcategoryrelaDBParam comcategoryrelaParam=new ComcategoryrelaDBParam();
	
		List<Long> cntList=null;
		OrderDAO orderDAO = (OrderDAO) DAOFactory.build(OrderDAO.class, user);
		ComressmpDAO comressmpDAO = (ComressmpDAO) DAOFactory.build(ComressmpDAO.class, user);
		OrderDBParam orderDBParam = new OrderDBParam();
		DistributableResVO distributableResVO=new DistributableResVO();
		distributableResVO.setCountyid(cntVO.getCountycompid());
		distributableResVO.setComcategory(comcatVO.getComcategory());
		distributableResVO.setBrand(comcatVO.getBrand());
		//可售资源数量
		comcategoryrelaParam=new ComcategoryrelaDBParam();
		Long cnt1 = comressmpDAO.queryBuyresource(cntVO.getCountycompid(), comcatVO.getComcategory());
		distributableResVO.setCnt1(cnt1);
		//已审核未抽取
		Long cnt4 = orderDAO.getOrderResource(cntVO.getCountycompid(), comcatVO.getComcategory(),"AUDITED,WAITCON,CONFIRMED");
		distributableResVO.setCnt4(cnt4);
		//待审核资源数量
		Long cnt3 = orderDAO.getOrderResource(cntVO.getCountycompid(), comcatVO.getComcategory(),"ESTABLISH");
		distributableResVO.setCnt3(cnt3);
		//可分配资源数量（可售资源数量－已审核未抽取数量）
		distributableResVO.setCnt2(cnt1-cnt4);
				
				
		return distributableResVO;
	}
	
	
}
