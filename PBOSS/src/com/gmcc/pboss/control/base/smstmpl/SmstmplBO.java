/**
 * auto-generated code
 * Mon Dec 21 09:15:59 CST 2009
 */
package com.gmcc.pboss.control.base.smstmpl;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.gmcc.pboss.business.base.smstmpl.SmstmplDAO;
import com.gmcc.pboss.business.base.smstmpl.SmstmplDBParam;
import com.gmcc.pboss.business.base.smstmpl.SmstmplVO;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: SmstmplBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class SmstmplBO extends AbstractControlBean implements
		Smstmpl {

	public SmstmplVO doCreate(SmstmplVO vo) throws Exception {
		try {
			SmstmplDAO dao = (SmstmplDAO) DAOFactory.build(SmstmplDAO.class, user);
			// TODO set the pk */
			return (SmstmplVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(SmstmplVO vo) throws Exception {
		try {
			SmstmplDAO dao = (SmstmplDAO) DAOFactory.build(SmstmplDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			SmstmplDAO dao = (SmstmplDAO) DAOFactory.build(SmstmplDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SmstmplVO doUpdate(SmstmplVO vo) throws Exception {
		try {
			SmstmplDAO dao = (SmstmplDAO) DAOFactory.build(SmstmplDAO.class,user);
			return (SmstmplVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SmstmplVO doFindByPk(Serializable pk) throws Exception {
		SmstmplDAO dao = (SmstmplDAO) DAOFactory.build(SmstmplDAO.class,user);
		return (SmstmplVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(SmstmplDBParam params)
			throws Exception {
		SmstmplDAO dao = (SmstmplDAO) DAOFactory.build(SmstmplDAO.class,user);
		return dao.query(params);
	}
	
	//短信模板接口
	public String doGenSMS(String sId, Map<String,String> keyAndValue) throws Exception{
		SmstmplDBParam param = new SmstmplDBParam();
		param.set_se_sid(sId);
		param.set_se_sstate("1");
		DataPackage dp = doQuery(param);
		//找到对应短信模板
		if(dp.getRowCount()>0)
		{
			List<SmstmplVO> smstmplList = dp.getDatas();
			String content = smstmplList.get(0).getScontent();
			if(content == null){
				content = "";
			}
			
			//替换参数
			String key = new String();
			String value = new String();

			for(Iterator<String> iter = keyAndValue.keySet().iterator(); iter.hasNext();)
			{
				key = iter.next();
				value = keyAndValue.get(key);
				content = content.replaceAll("\\{" + key + "\\}", value);
			}
			return content;
		}
		else
		{
			return "";
		}
	}
	
	/**
	 * 短信模板接口
	 * @param sId
	 * @param sContent	模板内容
	 * @param keyAndValue
	 * @return
	 * @throws Exception
	 */
	public String doGenSMS(String sId,String sContent, Map<String,String> keyAndValue) throws Exception{
		if (StringUtils.isEmpty(sContent)) {
			
			SmstmplDBParam param = new SmstmplDBParam();
			param.set_se_sid(sId);
			param.set_se_sstate("1");
			DataPackage dp = doQuery(param);
			if(dp.getRowCount()>0){
				//找到对应短信模板
				List<SmstmplVO> smstmplList = dp.getDatas();
				sContent = smstmplList.get(0).getScontent();
			}
			
		}
		
		if(!StringUtils.isEmpty(sContent))
		{
			//替换参数
			String key = new String();
			String value = new String();

			for(Iterator<String> iter = keyAndValue.keySet().iterator(); iter.hasNext();)
			{
				key = iter.next();
				value = keyAndValue.get(key);
				sContent = sContent.replaceAll("\\{" + key + "\\}", value);
			}
			return sContent;
		}
		else
		{
			return "";
		}
	}
}
