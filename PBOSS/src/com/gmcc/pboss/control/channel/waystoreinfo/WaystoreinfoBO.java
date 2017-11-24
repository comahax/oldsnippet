package com.gmcc.pboss.control.channel.waystoreinfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map; 
import com.gmcc.pboss.business.channel.waystoreinfo.VwaystoreinfoVo;
import com.gmcc.pboss.business.channel.waystoreinfo.WaystoreinfoDBParam;
import com.gmcc.pboss.business.channel.waystoreinfo.WaystoreinfoDAO;
import com.gmcc.pboss.business.channel.waystoreinfo.WaystoreinfoVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: WaystoreinfoBO </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public class WaystoreinfoBO extends AbstractControlBean implements Waystoreinfo {

	public WaystoreinfoVO doCreate(WaystoreinfoVO vo) throws Exception {
		try {
			WaystoreinfoDAO dao = (WaystoreinfoDAO) DAOFactory.build(WaystoreinfoDAO.class, user);
			// TODO set the pk */
			return (WaystoreinfoVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(WaystoreinfoVO vo) throws Exception {
		try {
			WaystoreinfoDAO dao = (WaystoreinfoDAO) DAOFactory.build(WaystoreinfoDAO.class,user);
			vo = doFindByPk(vo);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			WaystoreinfoDAO dao = (WaystoreinfoDAO) DAOFactory.build(WaystoreinfoDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WaystoreinfoVO doUpdate(WaystoreinfoVO vo) throws Exception {
		try {
			WaystoreinfoDAO dao = (WaystoreinfoDAO) DAOFactory.build(WaystoreinfoDAO.class,user);
			return (WaystoreinfoVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WaystoreinfoVO doFindByPk(Serializable pk) throws Exception {
		try {
			WaystoreinfoDAO dao = (WaystoreinfoDAO) DAOFactory.build(WaystoreinfoDAO.class,user);
			return (WaystoreinfoVO) dao.findByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DataPackage doQuery(WaystoreinfoDBParam params) throws Exception {
		try {
			WaystoreinfoDAO dao = (WaystoreinfoDAO) DAOFactory.build(WaystoreinfoDAO.class,user);
			return dao.query(params);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}		
	}
	
	 public DataPackage doWaystoreinfoList(WaystoreinfoDBParam params) throws Exception{
		 try {
				WaystoreinfoDAO dao = (WaystoreinfoDAO) DAOFactory.build(WaystoreinfoDAO.class,user);  
				params.setSelectFieldsString("wayid,area,cityid,zqtype,zqpic,zqarea,zqpanel,zqcupboard,zqcards,zqpricetag,zqrack,zqinad,zqhead,zqpaste,zqtablecard,zqdecca,zqbill,doorpic,doortype,outwallad,outwallpic,tdmonopoly,busimonopoly,storeconduct,modulus,createtime, wayname,latitude,longtitude,zqpicpath,doorpicpath");
			   // params.setSelectFieldsUseVOType(true);
			    DataPackage resultDp = new DataPackage();
			    DataPackage dp=null;
				dp = dao.queryByNamedSqlQuery("com.gmcc.pboss.business.channel.waystoreinfoList",params); 
				List collection = new ArrayList(); 
				if (dp != null && !"".equals(dp)) {
				List datas = dp.getDatas();

				if (datas != null && !"".equals(datas) && datas.size() > 0) {
					for (int i = 0; i < datas.size(); i++) {
						Map oneRecord = (Map) datas.get(i);
						VwaystoreinfoVo viewCADVO = new VwaystoreinfoVo();
						BeanUtils.copyProperties(viewCADVO, oneRecord);
						collection.add(viewCADVO);
					}
				}
			} 
				resultDp.setDatas(collection);
				resultDp.setRowCount(dp.getRowCount());
				resultDp.setPageNo(dp.getPageNo());
				resultDp.setPageSize(dp.getPageSize()); 
			return resultDp;
			} catch (Exception ex) {
				throw new JOPException(ex);
			}	
	 }
}
