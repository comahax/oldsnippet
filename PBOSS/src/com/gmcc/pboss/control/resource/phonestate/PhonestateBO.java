/**
 * auto-generated code
 * Mon Jul 04 16:25:21 CST 2011
 */
package com.gmcc.pboss.control.resource.phonestate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gmcc.pboss.business.resource.comressmp.ComressmpDBParam;
import com.gmcc.pboss.business.resource.comressmp.ComressmpVO;
import com.gmcc.pboss.business.resource.phonestate.PhonestateDAO;
import com.gmcc.pboss.business.resource.phonestate.PhonestateDBParam;
import com.gmcc.pboss.business.resource.phonestate.PhonestateVO;
import com.gmcc.pboss.business.sales.partnerres.PartnerresDBParam;
import com.gmcc.pboss.business.sales.partnerres.PartnerresVO;
import com.gmcc.pboss.control.resource.comressmp.Comressmp;
import com.gmcc.pboss.control.resource.comressmp.ComressmpBO;
import com.gmcc.pboss.control.sales.partnerres.Partnerres;
import com.gmcc.pboss.control.sales.partnerres.PartnerresBO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: PhonestateBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author lyl
 * @version 1.0
 */
public class PhonestateBO extends AbstractControlBean implements Phonestate {

	public PhonestateVO doCreate(PhonestateVO vo) throws Exception {
		try {
			PhonestateDAO dao = (PhonestateDAO) DAOFactory.build(
					PhonestateDAO.class, user);
			// TODO set the pk */
			return (PhonestateVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(PhonestateVO vo) throws Exception {
		try {
			PhonestateDAO dao = (PhonestateDAO) DAOFactory.build(
					PhonestateDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			PhonestateDAO dao = (PhonestateDAO) DAOFactory.build(
					PhonestateDAO.class, user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PhonestateVO doUpdate(PhonestateVO vo) throws Exception {
		try {
			PhonestateDAO dao = (PhonestateDAO) DAOFactory.build(
					PhonestateDAO.class, user);
			return (PhonestateVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PhonestateVO doFindByPk(Serializable pk) throws Exception {
		PhonestateDAO dao = (PhonestateDAO) DAOFactory.build(
				PhonestateDAO.class, user);
		return (PhonestateVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(PhonestateDBParam params) throws Exception {
		PhonestateDAO dao = (PhonestateDAO) DAOFactory.build(
				PhonestateDAO.class, user);
		return dao.query(params);
	}

	//号码状态查询方法
	public DataPackage doChooseData(PhonestateDBParam params) throws Exception {
		Comressmp comressmp = (Comressmp) BOFactory.build(ComressmpBO.class,
				user);
		ComressmpDBParam comressmpDBParam = new ComressmpDBParam();
		//设置入库时间倒序
		comressmpDBParam.set_orderby("entertime");
		comressmpDBParam.set_desc("1");
		comressmpDBParam.set_se_comresid(params.get_se_comresid());
		//设置页面查询条件，然后查询套卡资源表数据，
		if (null != params.get_se_reswayid()) {
			comressmpDBParam.set_se_wayid(params.get_se_reswayid());
		}
		if (null != params.get_dnl_saletime()) {
			comressmpDBParam.set_dnl_saletime(params.get_dnl_saletime());
		}
		if (null != params.get_dnm_saletime()) {
			comressmpDBParam.set_dnm_saletime(params.get_dnm_saletime());
		}
		DataPackage dp = new DataPackage();
		DataPackage comressmpdp = comressmp.doQuery(comressmpDBParam);
		ComressmpVO comressmpVO = null;
		if (comressmpdp.getDatas().size() > 0) {
			comressmpVO = (ComressmpVO) comressmpdp.getDatas().get(0); //跟进入库时间对数据进行倒叙，然后取第一条套卡资源的数据
		}
		Partnerres partnerres = (Partnerres) BOFactory.build(
				PartnerresBO.class, user);
		PartnerresDBParam partnerresDBParam = new PartnerresDBParam(); 
		PartnerresVO partnerresVO = null;
		//判断套卡资源表数据是否存在，然后继续下一步处理
		if (null != comressmpVO && !"".equals(comressmpVO)) {
			PhonestateVO phonestateVO = new PhonestateVO();
			List<PhonestateVO> list = new ArrayList<PhonestateVO>();

			if (comressmpVO.getComstate() == 10) { //状态为10时表示套卡已抽取 
				DataPackage orderdp = QueryOrderidByComresid(params
						.get_se_comresid());
				if (orderdp.getDatas().size()>0) {
					PhonestateVO vo = (PhonestateVO)orderdp.getDatas().get(0);
					phonestateVO.setOrderid(vo.getOrderid());
					phonestateVO.setWayid(vo.getWayid());
				}
				phonestateVO.setComstate(comressmpVO.getComstate());
				phonestateVO.setSaletime(comressmpVO.getSaletime());
				phonestateVO.setReswayid(comressmpVO.getWayid());
				phonestateVO.setComresid(comressmpVO.getComresid()); 
				list.add(phonestateVO);

				dp.setDatas(list);

			} else if (comressmpVO.getComstate() == 2) { //状态为2时表示套卡已销售
				partnerresDBParam.set_se_comresid(params.get_se_comresid());
				partnerresDBParam.set_orderby("createtime");
				partnerresDBParam.set_desc("1");
				DataPackage partnerresdp = partnerres
						.doQuery(partnerresDBParam);
				if (partnerresdp.getDatas().size() != 0) {
					partnerresVO = (PartnerresVO) partnerresdp.getDatas()
							.get(0);
				}
				DataPackage orderdp = QueryOrderidByComresid(params
						.get_se_comresid());
				if (orderdp.getDatas().size()>0) {
					phonestateVO.setOrderid(((PhonestateVO)orderdp.getDatas().get(0)).getOrderid()); 
				} 
				//设置页面显示值 
				phonestateVO.setComstate(comressmpVO.getComstate());
				phonestateVO.setSaletime(comressmpVO.getSaletime());
				phonestateVO.setReswayid(comressmpVO.getWayid());
				phonestateVO.setComresid(partnerresVO.getComresid());
				phonestateVO.setActtime(partnerresVO.getActtime());
				phonestateVO.setIsactive(partnerresVO.getIsactive());
				phonestateVO.setWayid(partnerresVO.getWayid());
				list.add(phonestateVO);
				dp.setDatas(list);
			} else {
				//状态为其他时，取套卡资源表的数据
				phonestateVO.setComstate(comressmpVO.getComstate());
				phonestateVO.setSaletime(comressmpVO.getSaletime());
				phonestateVO.setReswayid(comressmpVO.getWayid());
				phonestateVO.setComresid(comressmpVO.getComresid());
				list.add(phonestateVO);
				dp.setDatas(list);
			}
		}

		return dp;
	}

	//跟进手机号码联合查询订单号
	public DataPackage QueryOrderidByComresid(String comresid) throws Exception {
		PhonestateDAO dao = (PhonestateDAO) DAOFactory.build(
				PhonestateDAO.class, user);
		PhonestateDBParam param = new PhonestateDBParam();
		param.getQueryConditions().put("comresid", comresid);
		param.setSelectFieldsString("orderid,wayid"); 
		param.setSelectFieldsUseVOType(true); 
		return dao.QueryOrderidByComresid(param);
	}
}
