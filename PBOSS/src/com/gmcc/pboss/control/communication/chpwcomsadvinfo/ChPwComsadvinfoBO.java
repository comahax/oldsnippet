/**
 * auto-generated code
 * Mon Mar 23 12:58:46 CST 2015
 */
package com.gmcc.pboss.control.communication.chpwcomsadvinfo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import com.gmcc.pboss.business.channel.waitreq.WaitreqVO;
import com.gmcc.pboss.business.communication.chpwcomsadvinfo.ChPwComsadvinfoDBParam;
import com.gmcc.pboss.business.communication.chpwcomsadvinfo.ChPwComsadvinfoDAO;
import com.gmcc.pboss.business.communication.chpwcomsadvinfo.ChPwComsadvinfoVO;
import com.gmcc.pboss.business.communication.chpwcomsadvinfolog.ChPwComsadvinfologVO;
import com.gmcc.pboss.business.communication.chpwcomsrcvobj.ChPwComsrcvobjVO;
import com.gmcc.pboss.control.channel.waitreq.Waitreq;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.communication.chpwcomsadvinfolog.ChPwComsadvinfolog;
import com.gmcc.pboss.control.communication.chpwcomsadvinfolog.ChPwComsadvinfologBO;
import com.gmcc.pboss.control.communication.chpwcomsrcvobj.ChPwComsrcvobj;
import com.gmcc.pboss.control.communication.chpwcomsrcvobj.ChPwComsrcvobjBO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: ChPwComsadvinfoBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChPwComsadvinfoBO extends AbstractControlBean implements
		ChPwComsadvinfo {

	public ChPwComsadvinfoVO doCreate(ChPwComsadvinfoVO vo) throws Exception {
		try {
			ChPwComsadvinfoDAO dao = (ChPwComsadvinfoDAO) DAOFactory.build(ChPwComsadvinfoDAO.class, user);
			// TODO set the pk */
			return (ChPwComsadvinfoVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ChPwComsadvinfoVO vo) throws Exception {
		try {
			ChPwComsadvinfoDAO dao = (ChPwComsadvinfoDAO) DAOFactory.build(ChPwComsadvinfoDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ChPwComsadvinfoDAO dao = (ChPwComsadvinfoDAO) DAOFactory.build(ChPwComsadvinfoDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ChPwComsadvinfoVO doUpdate(ChPwComsadvinfoVO vo) throws Exception {
		try {
			ChPwComsadvinfoDAO dao = (ChPwComsadvinfoDAO) DAOFactory.build(ChPwComsadvinfoDAO.class,user);
			return (ChPwComsadvinfoVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ChPwComsadvinfoVO doFindByPk(Serializable pk) throws Exception {
		ChPwComsadvinfoDAO dao = (ChPwComsadvinfoDAO) DAOFactory.build(ChPwComsadvinfoDAO.class,user);
		return (ChPwComsadvinfoVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ChPwComsadvinfoDBParam params)
			throws Exception {
		ChPwComsadvinfoDAO dao = (ChPwComsadvinfoDAO) DAOFactory.build(ChPwComsadvinfoDAO.class,user);
		return dao.query(params);
	}

	public void doUpdateAdvinfo(ChPwComsadvinfoVO vo) throws Exception {
		try {
			if (vo.getState() != 1 && vo.getState() != 3) {
				ChPwComsadvinfoVO advinfoVO = new ChPwComsadvinfoVO();
				BeanUtils.copyProperties(advinfoVO, vo);
				advinfoVO.setAdvinfoid(null);
				advinfoVO.setTitle(vo.getTitle() + " [公告已删除]");
				doRelease(advinfoVO);
			}
			vo.setState(Short.valueOf("3"));
			doUpdate(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ChPwComsadvinfoVO doRelease(ChPwComsadvinfoVO advinfoVO)
			throws Exception {
		advinfoVO.setState(Short.valueOf("2"));
		if (advinfoVO.getAdvinfoid() == null) {
			advinfoVO = doCreate(advinfoVO);
			doSavaComsadvinfoLog(advinfoVO, "create");
		} else {
			advinfoVO = doUpdate(advinfoVO);
			doSavaComsadvinfoLog(advinfoVO, "update");
		}
		ChPwComsadvinfoDAO dao = (ChPwComsadvinfoDAO) DAOFactory.build(ChPwComsadvinfoDAO.class,user);
		DataPackage operatorDP = dao.doQueryOperatorByRoleId(advinfoVO.getRcvobjtype());
		List<Map<String, String>> operatorList = operatorDP.getDatas();
		ChPwComsrcvobj chPwComsrcvobj = (ChPwComsrcvobj) BOFactory.build(ChPwComsrcvobjBO.class, user);
		
		ChPwComsrcvobjVO chPwComsrcvobjVO = null;
		for (Map<String, String> map : operatorList) {
			String cityid = CityMappingUtil.getCityid(map.get("region"));
			chPwComsrcvobjVO = new ChPwComsrcvobjVO();
			chPwComsrcvobjVO.setAdvinfoid(advinfoVO.getAdvinfoid());
			chPwComsrcvobjVO.setObjid(map.get("operid"));
			chPwComsrcvobjVO.setObjname(map.get("opername"));
			chPwComsrcvobjVO.setCityid(cityid);
			chPwComsrcvobjVO.setState(Short.valueOf("2"));
			chPwComsrcvobj.doCreate(chPwComsrcvobjVO);
			
			String contactphone = map.get("contactphone");
			if (advinfoVO.getSmsnotify() == 1
					&& contactphone != null
					&& contactphone.length() == 11) {
				DBAccessUser DBUser = new DBAccessUser();
				DBUser.setCityid(cityid);
				DBUser.setOprcode(user.getOprcode());
				Waitreq waitreqBO = (Waitreq) BOFactory.build(WaitreqBO.class, DBUser);
				
				WaitreqVO waitreqVO = new WaitreqVO();
				waitreqVO.setSmstype(Short.valueOf("6"));
				waitreqVO.setAreacode(cityid);
				waitreqVO.setCreattime(new Date());
				waitreqVO.setMessage("省公司发布公告：" + advinfoVO.getTitle() + "，请登录COMS系统查阅！");
				waitreqVO.setRecno(contactphone);
				waitreqVO.setDealcount(new Short("0"));
				waitreqVO.setSendno("10086");
				waitreqVO.setIssuccess(new Short("0"));
				waitreqVO.setResultcode("");
				waitreqVO.setResultdesc("");
				waitreqBO.doCreate(waitreqVO);
			}
		}
		return advinfoVO;
	}

	public void doSavaComsadvinfoLog(ChPwComsadvinfoVO vo, String oprtype) throws Exception {
		ChPwComsadvinfolog comsadvinfolog = (ChPwComsadvinfolog) BOFactory.build(ChPwComsadvinfologBO.class, user);
		ChPwComsadvinfologVO logVO = new ChPwComsadvinfologVO();
		BeanUtils.copyProperties(logVO, vo);
		logVO.setOptime(PublicUtils.formatUtilDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		logVO.setOprcode(user.getOprcode());
		logVO.setOprtype(oprtype);
		logVO.setSuccess("success");
		comsadvinfolog.doCreate(logVO);
	}

	public DataPackage doCityList(ChPwComsadvinfoDBParam params)
			throws Exception {
		ChPwComsadvinfoDAO dao = (ChPwComsadvinfoDAO) DAOFactory.build(ChPwComsadvinfoDAO.class,user);
		return dao.doCityList(params, user.getOprcode());
	}
}
