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
//		���ݷֹ�˾��΢�����Ǽ���Ʒ�ƶ���Ʒ����������ñ� (FX_RU_COMDISSCALE)���в�ѯ
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
		//ΨһԼ����飬���ݷֹ�˾��΢�����Ǽ����׿�Ʒ�ơ���Ʒ�������Ʒ����������ñ� (FX_RU_COMDISSCALE)���в�ѯ��
		//����Ѿ��������ݣ�����ʾ����ͬ��¼�Ѿ����ڣ����顣�������ء�
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
//		��Ʒ����Ʒ�ƶ�Ӧ��ϵ��飺�����׿�Ʒ�ƺ���Ʒ�����ѯ��Ʒ����Ʒ�ƶ�Ӧ��ϵ��(IM_PR_COMCATEBRAND)��
//		�������������ʾ����Ʒ������׿�Ʒ�ƶ�Ӧ��ϵ�������顣�������أ����������
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
