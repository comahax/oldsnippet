/**
 * auto-generated code
 * Fri Jun 25 09:24:18 CST 2010
 */
package com.gmcc.pboss.control.sales.comdisscale;

import java.io.Serializable;
import java.util.List;

import com.gmcc.pboss.business.resource.comcatebrand.ComcatebrandDBParam;
import com.gmcc.pboss.business.sales.comdisscale.ComdisscaleDAO;
import com.gmcc.pboss.business.sales.comdisscale.ComdisscaleDBParam;
import com.gmcc.pboss.business.sales.comdisscale.ComdisscaleVO;
import com.gmcc.pboss.control.resource.comcatebrand.Comcatebrand;
import com.gmcc.pboss.control.resource.comcatebrand.ComcatebrandBO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ComdisscaleBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author zhangsiwei
 * @version 1.0
 */
public class ComdisscaleBO extends AbstractControlBean implements
		Comdisscale {

	public ComdisscaleVO doCreate(ComdisscaleVO vo) throws Exception {
		try {
			ComdisscaleDAO dao = (ComdisscaleDAO) DAOFactory.build(ComdisscaleDAO.class, user);
			return (ComdisscaleVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ComdisscaleVO vo) throws Exception {
		try {
			ComdisscaleDAO dao = (ComdisscaleDAO) DAOFactory.build(ComdisscaleDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ComdisscaleDAO dao = (ComdisscaleDAO) DAOFactory.build(ComdisscaleDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ComdisscaleVO doUpdate(ComdisscaleVO vo) throws Exception {
		try {
			ComdisscaleDAO dao = (ComdisscaleDAO) DAOFactory.build(ComdisscaleDAO.class,user);
			return (ComdisscaleVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ComdisscaleVO doFindByPk(Serializable pk) throws Exception {
		ComdisscaleDAO dao = (ComdisscaleDAO) DAOFactory.build(ComdisscaleDAO.class,user);
		return (ComdisscaleVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ComdisscaleDBParam params)
			throws Exception {
		ComdisscaleDAO dao = (ComdisscaleDAO) DAOFactory.build(ComdisscaleDAO.class,user);
		return dao.query(params);
	}
	
	public boolean checkDisscale(ComdisscaleVO vo) throws Exception {
//		根据分公司、微区域、星级、品牌对商品分配比例设置表 (FX_RU_COMDISSCALE)进行查询
		Comdisscale cds = (Comdisscale)BOFactory.build(ComdisscaleBO.class, user);
		ComdisscaleDBParam param = new ComdisscaleDBParam();
		param.set_se_brand(vo.getBrand());
		param.set_se_countyid(vo.getCountyid());
		param.set_se_mareacode(vo.getMareacode());
		param.set_ne_starlevel(vo.getStarlevel().toString());
//		param.set_sne_comcategory(vo.getComcategory());
		DataPackage dp = cds.doQuery(param);
		List<ComdisscaleVO> list = dp.getDatas();
		Double sumofdisscale = vo.getDisscale();
		for(ComdisscaleVO cdvo:list){
			sumofdisscale += cdvo.getDisscale();
		}
		if(sumofdisscale>1){
			return false;
		}else{
			return true;
		}
	}

	public boolean isExist(ComdisscaleVO vo) throws Exception {
		//唯一约束检查，根据分公司、微区域、星级、套卡品牌、商品种类对商品分配比例设置表 (FX_RU_COMDISSCALE)进行查询，
		//如果已经存在数据，则提示“相同记录已经存在，请检查。”并返回。
		Comdisscale cds = (Comdisscale)BOFactory.build(ComdisscaleBO.class, user);
		ComdisscaleDBParam param = new ComdisscaleDBParam();
		param.set_se_brand(vo.getBrand());
		param.set_se_countyid(vo.getCountyid());
		param.set_se_mareacode(vo.getMareacode());
		param.set_ne_starlevel(vo.getStarlevel().toString());
		param.set_se_comcategory(vo.getComcategory());
		DataPackage dp = cds.doQuery(param);
		if(dp != null && dp.getDatas() != null && dp.getDatas().size()>0){
			return true;
		}
		return false;		
	}

	public boolean checkRale(ComdisscaleVO vo) throws Exception {
//		商品种类品牌对应关系检查：根据套卡品牌和商品种类查询商品种类品牌对应关系表(IM_PR_COMCATEBRAND)，
//		如果无数据则提示“商品种类和套卡品牌对应关系错误，请检查。”并返回；否则继续。
		Comcatebrand cmb = (Comcatebrand)BOFactory.build(ComcatebrandBO.class, user);
		ComcatebrandDBParam comcatebrandDBParam = new ComcatebrandDBParam();
		comcatebrandDBParam.set_se_brand(vo.getBrand());
		comcatebrandDBParam.set_se_comcategory(vo.getComcategory());
		DataPackage dp = cmb.doQuery(comcatebrandDBParam);
		if(dp != null && dp.getDatas() != null && dp.getDatas().size()>0){
			return true;
		}
		return false;		
	}

	public DataPackage isExistb(ComdisscaleVO vo) throws Exception {
		Comdisscale cds = (Comdisscale)BOFactory.build(ComdisscaleBO.class, user);
		ComdisscaleDBParam param = new ComdisscaleDBParam();
		param.set_se_brand(vo.getBrand());
		param.set_se_countyid(vo.getCountyid());
		param.set_se_mareacode(vo.getMareacode());
		param.set_ne_starlevel(vo.getStarlevel().toString());
//		param.set_sne_comcategory(vo.getComcategory());
		param.set_se_comcategory(vo.getComcategory());
		DataPackage dp = cds.doQuery(param);	
		return dp;
	}
	
}
