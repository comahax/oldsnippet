/**
 * auto-generated code
 * Tue Oct 13 09:30:24 CST 2009
 */
package com.gmcc.pboss.control.sales.comprice;

import java.io.Serializable; 
import java.util.List; 
import com.gmcc.pboss.business.channel.custwaytype.CustwaytypeDBParam;
import com.gmcc.pboss.business.channel.custwaytype.CustwaytypeVO; 
import com.gmcc.pboss.business.sales.comprice.CompriceConstant;
import com.gmcc.pboss.business.sales.comprice.CompriceDAO;
import com.gmcc.pboss.business.sales.comprice.CompriceDBParam;
import com.gmcc.pboss.business.sales.comprice.CompriceVO;
import com.gmcc.pboss.business.sales.comprice.CompriceVOHelper; 
import com.gmcc.pboss.control.channel.custwaytype.Custwaytype;
import com.gmcc.pboss.control.channel.custwaytype.CustwaytypeBO; 
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
  
 

/**
 * <p>Title: CompriceBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CompriceBO extends AbstractControlBean implements
		Comprice {

	public CompriceVO doCreate(CompriceVO vo) throws Exception {
		try {
			CompriceDAO dao = (CompriceDAO) DAOFactory.build(CompriceDAO.class, user);
			// TODO set the pk */
			return (CompriceVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(CompriceVO vo) throws Exception {
		try {
			CompriceDAO dao = (CompriceDAO) DAOFactory.build(CompriceDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			CompriceDAO dao = (CompriceDAO) DAOFactory.build(CompriceDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CompriceVO doUpdate(CompriceVO vo) throws Exception {
		try {
			CompriceDAO dao = (CompriceDAO) DAOFactory.build(CompriceDAO.class,user);
			return (CompriceVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CompriceVO doFindByPk(Serializable pk) throws Exception {
		CompriceDAO dao = (CompriceDAO) DAOFactory.build(CompriceDAO.class,user);
		return (CompriceVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(CompriceDBParam params)
			throws Exception {
		CompriceDAO dao = (CompriceDAO) DAOFactory.build(CompriceDAO.class,user);
		return dao.query(params);
	}
	
	public Long doCompriceSave(CompriceVOHelper helper) throws Exception{
		CompriceVO compriceVO = new CompriceVO();
		BeanUtils.copyProperties(compriceVO, helper);
		
		//根据售价区分方式获取相应的售价
		String type = helper.getPricediftype();
		if(type.equals(CompriceConstant.PRICEDIFTYPE_NODIF))
		{
			compriceVO.setPrice2(null);
		}
		else if(type.equals(CompriceConstant.PRICEDIFTYPE_ACCOUNT))
		{
			compriceVO.setPrice1(helper.getPrice2());
			compriceVO.setPrice2(helper.getPrice3());
		}
		else if(type.equals(CompriceConstant.PRICEDIFTYPE_INVOICE))
		{
			compriceVO.setPrice1(helper.getPrice4());
			compriceVO.setPrice2(helper.getPrice5());
		}
		
		Comprice comprice = (Comprice)BOFactory.build(CompriceBO.class,user);
		if(null==compriceVO.getRecid())
		{
			comprice.doCreate(compriceVO);
		}
		else
		{
			
			comprice.doUpdate(compriceVO);
		}
		return compriceVO.getRecid();
	}
	
	//获取合作类型列表
	public List<CustwaytypeVO> doGetCustwaytypeList() throws Exception{
		Custwaytype custwaytype = (Custwaytype) BOFactory.build(CustwaytypeBO.class,user);
		CustwaytypeDBParam param = new CustwaytypeDBParam();
		param.set_ne_citycompid(user.getCityid());
		DataPackage dp = custwaytype.doQuery(param);
		return dp.getDatas();
	} 
	
	
	//商品销售价格设置批量导入
	
	public void  doCompriceImport(String[] item) throws Exception{
	    
	    
	    CompriceVO compriceVO = new CompriceVO();
	    compriceVO.setCityid(user.getCityid()); 
 		compriceVO.setCountyid(item[0]);
		compriceVO.setStarlevel(Short.parseShort(item[1]));
		compriceVO.setCooptype(item[2]);
		compriceVO.setComcategory(item[3]);
		compriceVO.setPricediftype(item[4]);
		compriceVO.setPrice1(Double.parseDouble(item[5]));
		if (item[6] != null && !"".equals(item[6])){
			compriceVO.setPrice2(Double.parseDouble(item[6]));
		}
	     
	    CompriceDBParam compriceParam = new CompriceDBParam();
	    compriceParam.set_se_countyid(item[0]);
	    compriceParam.set_ne_starlevel(Short.parseShort(item[1]));
	    compriceParam.set_se_cooptype(item[2]);
	    compriceParam.set_se_comcategory(item[3]);
	    compriceParam.set_se_cityid(user.getCityid());
	    DataPackage dp = doQuery(compriceParam);
	    List<CompriceVO> list = dp.getDatas(); 
	    if (list.isEmpty())
	    {
	    	//数据不存在 执行新增   
	    		 doCreate(compriceVO);  
	    }else if (!list.isEmpty())
	    {
	    	//数据存在 执行更新   
	    	CompriceVO compriceVO2 = list.get(0);
	    	compriceVO2.setCityid(user.getCityid()); 
			compriceVO2.setCountyid(item[0]);
			compriceVO2.setStarlevel(Short.parseShort(item[1]));
			compriceVO2.setCooptype(item[2]);
			compriceVO2.setComcategory(item[3]);
			compriceVO2.setPricediftype(item[4]);
			compriceVO2.setPrice1(Double.parseDouble(item[5]));
			if (item[6] != null && !"".equals(item[6])){
				compriceVO2.setPrice2(Double.parseDouble(item[6]));
			}
			
			doUpdate(compriceVO2);  
			 
		 
	    } 
				 
			 
		}  
}
