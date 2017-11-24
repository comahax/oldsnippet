/**
 * auto-generated code
 * Tue Jun 05 08:33:24 CST 2012
 */
package com.gmcc.pboss.control.channel.checkedapplydetail;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.gmcc.pboss.business.channel.checkedapplydetail.CheckedapplydetailDAO;
import com.gmcc.pboss.business.channel.checkedapplydetail.CheckedapplydetailDBParam;
import com.gmcc.pboss.business.channel.checkedapplydetail.CheckedapplydetailVO;
import com.gmcc.pboss.business.channel.checkedapplydetail.ViewCADVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: CheckedapplydetailBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class CheckedapplydetailBO extends AbstractControlBean implements
		Checkedapplydetail {

	public CheckedapplydetailVO doCreate(CheckedapplydetailVO vo) throws Exception {
		try {
			CheckedapplydetailDAO dao = (CheckedapplydetailDAO) DAOFactory.build(CheckedapplydetailDAO.class, user);
			// TODO set the pk */
			return (CheckedapplydetailVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(CheckedapplydetailVO vo) throws Exception {
		try {
			CheckedapplydetailDAO dao = (CheckedapplydetailDAO) DAOFactory.build(CheckedapplydetailDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			CheckedapplydetailDAO dao = (CheckedapplydetailDAO) DAOFactory.build(CheckedapplydetailDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CheckedapplydetailVO doUpdate(CheckedapplydetailVO vo) throws Exception {
		try {
			CheckedapplydetailDAO dao = (CheckedapplydetailDAO) DAOFactory.build(CheckedapplydetailDAO.class,user);
			return (CheckedapplydetailVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CheckedapplydetailVO doFindByPk(Serializable pk) throws Exception {
		CheckedapplydetailDAO dao = (CheckedapplydetailDAO) DAOFactory.build(CheckedapplydetailDAO.class,user);
		return (CheckedapplydetailVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(CheckedapplydetailDBParam params)
			throws Exception {
		CheckedapplydetailDAO dao = (CheckedapplydetailDAO) DAOFactory.build(CheckedapplydetailDAO.class,user);
		return dao.query(params);
	}
	
	public DataPackage doQueryCheckedapplydetail(CheckedapplydetailDBParam params)
		throws Exception {
		CheckedapplydetailDAO dao = (CheckedapplydetailDAO) DAOFactory.build(CheckedapplydetailDAO.class,user);
		
		params.set_se_cityid(user.getCityid());
		params.getQueryConditions().put("cityid", user.getCityid());
		
		params.setSelectFieldsString("cityid,chainhead,wayname," +
				"address,buztypecode,starlevel,istop," +
				"wayid,chktype,wtype,status,applytype,applyno,aptime,oprtime,seq,waystatus");
		
		if (null!= params.get_se_oprtime() && !"".equals(params.get_se_oprtime())) {
			params.set_sql_oprtime(("to_char(oprtime,'yyyyMM')="+params.get_se_oprtime()));
			
			params.set_se_oprtime(null);
		}
		
		DataPackage dp=null;
		dp=dao.queryByNamedSqlQuery("queryCheckedapplydetail",params);
		
		DataPackage resultDp = new DataPackage();
		List collection = new ArrayList();
		
		//�������ͷ�Ϊ���ࣺtop�����ʾ��������istop�ֶ�Ϊ1�����㣬
		//ʡ���������������ʾ�����Ӧ��������������̴��ڲ�����������̶�Ӧ������ʡ���������ڣ�
		//������������Ϊ��Ǳ�����㡣
		if(dp != null && !"".equals(dp)){
			List datas = dp.getDatas();
			
			if(datas != null && !"".equals(datas) && datas.size()>0){
				for(int i=0 ; i<datas.size() ; i++){
					Map oneRecord = (Map)datas.get(i);
					
					ViewCADVO viewCADVO = new ViewCADVO();
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
	}
	//���²�ѯ��Ȩ����������ϸ�� 
	  public DataPackage doQueryInfoForUpdate(CheckedapplydetailDBParam params)
			throws Exception {
		CheckedapplydetailDAO dao = (CheckedapplydetailDAO) DAOFactory.build(
				CheckedapplydetailDAO.class, user);
		params.setSelectFieldsString("seq,cityid,wtype,wayid,chktype,oprcode,applyno,applytype,aptime,address,wayname,buztypecode,starlevel,chainhead");
		params.setSelectFieldsUseVOType(true);
		return dao.queryByNamedSqlQuery("com.gmcc.pboss.business.channel.checkedapplydetail.QueryInfoForUpdate",params);
	}
	  
	  // ������ѯ��Ȩ����������ϸ�� 
	    public DataPackage doQueryInfoForInsert(CheckedapplydetailDBParam params) throws Exception{
	    	CheckedapplydetailDAO dao = (CheckedapplydetailDAO) DAOFactory.build(
					CheckedapplydetailDAO.class, user);
			params.setSelectFieldsString("seq,cityid,wtype,wayid,chktype,oprcode,applyno,applytype,aptime,chgtype,address,wayname,buztypecode,starlevel,chainhead");
			params.getQueryConditions().put("oprcode", params.get_se_oprcode());
			params.set_pagesize("0");
			params.setSelectFieldsUseVOType(true);
			DataPackage dp = null;
			
			if (params.get_se_applyno()!=null && !"".equals(params.get_se_applyno())) {//�����뵥��
				params.getQueryConditions().put("applyno", params.get_se_applyno());
				dp = dao.queryByNamedSqlQuery("com.gmcc.pboss.business.channel.checkedapplydetail.QueryNoRightHasAppyno",params);
			} else {//û�����뵥��
				dp = dao.queryByNamedSqlQuery("com.gmcc.pboss.business.channel.checkedapplydetail.QueryNoRightNoAppyno",params);
			}
			return dp;
	    }

	// �ֹ�˾������ѯ��Ȩ����������ϸ��
	public DataPackage doQueryInfoForInsert_COUNTY(CheckedapplydetailDBParam params) throws Exception {
		CheckedapplydetailDAO dao = (CheckedapplydetailDAO) DAOFactory.build(
		CheckedapplydetailDAO.class, user);
		params.setSelectFieldsString("seq,cityid,wtype,wayid,chktype,oprcode,applyno,applytype,aptime,chgtype,address,wayname,buztypecode,starlevel,chainhead");
		params.getQueryConditions().put("oprcode", params.get_se_oprcode());
		params.set_pagesize("0");
		params.setSelectFieldsUseVOType(true);
		DataPackage dp = null;
		if (params.get_se_applyno()!=null && !"".equals(params.get_se_applyno())) {//�����뵥��
			params.getQueryConditions().put("applyno", params.get_se_applyno());
			dp = dao.queryByNamedSqlQuery("com.gmcc.pboss.business.channel.checkedapplydetail.QueryNoRightHasAppyno_COUNTY",params);
		} else {//û�����뵥��
			dp = dao.queryByNamedSqlQuery("com.gmcc.pboss.business.channel.checkedapplydetail.QueryNoRightNoAppyno_COUNTY",params);
		}
		return dp;
	}

	// �й�˾������������ѯ��Ȩ����������ϸ��
	public DataPackage doQueryInfoForInsert_MIDCITY(CheckedapplydetailDBParam params) throws Exception {
		CheckedapplydetailDAO dao = (CheckedapplydetailDAO) DAOFactory.build(
				CheckedapplydetailDAO.class, user);
		params.setSelectFieldsString("seq,cityid,wtype,wayid,chktype,oprcode,applyno,applytype,aptime,chgtype,address,wayname,buztypecode,starlevel,chainhead");
		params.getQueryConditions().put("oprcode", params.get_se_oprcode());
		params.set_pagesize("0");
		params.setSelectFieldsUseVOType(true);
		params.set_se_oprcode(null);
		DataPackage dp = null;
		if (params.get_se_applyno()!=null && !"".equals(params.get_se_applyno())) {//�����뵥��
			params.getQueryConditions().put("applyno", params.get_se_applyno());
			dp = dao.queryByNamedSqlQuery("com.gmcc.pboss.business.channel.checkedapplydetail.QueryNoRightHasAppyno_MIDCITY",params);
		} else {//û�����뵥��
			dp = dao.queryByNamedSqlQuery("com.gmcc.pboss.business.channel.checkedapplydetail.QueryNoRightNoAppyno_MIDCITY",params);
		}
		return dp;
	}

	//��Ȩ�����������ѡ���������㣬��������Ϊ�˳������ʱ�򣬲�ѯ���������������
	public DataPackage doQueryWayinfoForExitway(WayDBParam params)
			throws Exception {
		CheckedapplydetailDAO dao = (CheckedapplydetailDAO) DAOFactory.build(
				CheckedapplydetailDAO.class, user);
		params.setSelectFieldsString("wayid, wayname, waystate");
		params.setSelectFieldsUseVOType(true);
		params.getQueryConditions().put("cityid",params.get_se_cityid());
		return dao.queryByNamedSqlQuery("pboss.channel.way.queryWayinfoForExitway",params);
	}

	//��Ȩ�����������ѡ���������㣬��������Ϊ׼�������ʱ�򣬲�ѯ��������������
	public DataPackage doQueryWayinfoForapplyway(WayDBParam params)
			throws Exception {
		CheckedapplydetailDAO dao = (CheckedapplydetailDAO) DAOFactory.build(
				CheckedapplydetailDAO.class, user);
		params.setSelectFieldsString("wayid, wayname, waystate");
		params.setSelectFieldsUseVOType(true);
		params.getQueryConditions().put("cityid",params.get_se_cityid());
		return dao.queryByNamedSqlQuery("pboss.channel.way.queryWayinfoForapplyway",params);
	}
}
