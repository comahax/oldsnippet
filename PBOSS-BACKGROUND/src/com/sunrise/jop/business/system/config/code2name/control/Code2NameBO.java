package com.sunrise.jop.business.system.config.code2name.control;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gmcc.pboss.business.base.dictitem.DictitemDAO;
import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.sunrise.jop.business.system.config.code2name.persistent.Code2NameDAO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/admin/code2name/control/Code2NameControlBean"
*    name="Code2NameControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class Code2NameBO extends AbstractControlBean implements Code2NameControl {
	private static Log log = LogFactory.getLog(Code2NameBO.class);
	private Code2NameDAO getCode2NameDAO(String voName,String dbFlag) throws Exception {	
		Class voClass = Class.forName(voName);
		Code2NameDAO dao = (Code2NameDAO) DAOFactory.build(Code2NameDAO.class,voClass, dbFlag); 
		return dao;
	}
	/**
	 * 转换编码。用于单表翻译。
	 * @param voName
	 * @param codeName
	 * @param nameName
	 * @param codeValue
	 * @param dbFlag
	 * @return
	 * @throws Exception
	 */
	public Object doTranslateCode(String voName, String codeName,
			String nameName, Object codeValue, String dbFlag) throws Exception {
		Code2NameDAO dao = getCode2NameDAO(voName,dbFlag);
		return dao.translateCode(voName, codeName, nameName, codeValue);
	}
	
	/**
	 * 转换编码。需要按groupid判断分组，用于数据字典的翻译
	 * @param voName
	 * @param groupid
	 * @param codeName
	 * @param nameName
	 * @param codeValue
	 * @param dbFlag
	 * @return
	 * @throws Exception 
	 */
	public Object doTranslateCode(String voName, String groupid, String codeName, String nameName, Object codeValue, String dbFlag) throws Exception {
		
		if(groupid!=null) { //数据字典
			DictitemDAO dao = (DictitemDAO) DAOFactory.build(DictitemDAO.class,dbFlag);
			
			DictitemVO vo = new DictitemVO();
			vo.setDictid((String)codeValue);
			vo.setGroupid(groupid);
			DictitemVO vo2 = (DictitemVO) dao.findByPk(vo);
			
			if(vo2 == null)
			{
				if(log.isInfoEnabled())
				{
					log.info("code can't convet to name: codevalue:"+codeValue);
				}
				return codeValue;
			}
			if(vo2.getDictname()!=null)
				return vo2.getDictname();
			else
				return codeValue;
		
		}else {
			Code2NameDAO dao = getCode2NameDAO(voName,dbFlag);
			return dao.translateCode(voName, codeName, nameName, codeValue);
		}
	}
	
//	/**
//	 * 获取某个类型的所有编码。
//	 * @param voName
//	 * @param codeName
//	 * @param nameName
//	 * @param dbFlag
//	 * @return
//	 * @throws Exception
//	 */
//	public Map doValueList(String voName, String codeName, String nameName, String dbFlag) throws Exception {
//		
//		Code2NameDAO dao = getCode2NameDAO(voName,dbFlag);
//		return dao.valueList(voName, codeName, nameName );
//	}
//	
	/**
	 * 获取数据字典某个项目的所有编码。
	 * @param voName
	 * @param codeName
	 * @param nameName
	 * @param dbFlag
	 * @return
	 * @throws Exception
	 */
	public Map doValueList(String groupid, String codeName, String nameName, DBQueryParam param,String dbFlag) throws Exception {
		
		if(groupid!=null) { //数据字典
			
			DataPackage dp =  doValueListPackage(groupid, codeName, nameName, param, dbFlag);			
			Map maplist = new LinkedHashMap(dp.getDatas().size());

//			//将数据转换为 map
			for(int i = 0 ; i < dp.getDatas().size() ; i++ ) {
				DictitemVO vo = (DictitemVO) dp.getDatas().get(i);
				maplist.put(vo.getDictid(), vo.getDictname());
			}
			
			return maplist;	
		}
		throw new JOPException("SYS-103","数据字典查询时 groupCode 丢失！",null);
	}
	
	/**
	 * 根据VOClass 获取所有编码，名称列表
	 * @param voName
	 * @param codeName
	 * @param nameName
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public DataPackage doValueListPackage(String groupid, String codeName, String nameName, DBQueryParam param,String dbFlag) throws Exception {

		if(groupid!=null) { //数据字典
			
			DictitemDBParam dictParam = new DictitemDBParam();
			
			BeanUtils.copyProperties(dictParam , param ); //将外部设置的条件放进来
			
			dictParam.set_se_groupid(groupid); //设置字段组编码
			
			DataPackage dp =  doValueListPackage(DictitemVO.class, codeName, nameName, dictParam, dbFlag);
			
			return dp;
			
		}
		throw new JOPException("SYS-103","数据字典查询时 groupCode 丢失！",null);
	}
	
	/**
	 * 根据VOClass 获取所有编码，名称列表. 适用数据字典和单表参数。
	 */
	public DataPackage doValueListPackage(Class voClass, String codeName, String nameName, DBQueryParam param, String dbFlag) throws Exception {
		Code2NameDAO dao = getCode2NameDAO(voClass.getName(),dbFlag);
		return dao.valueListPackage(voClass, codeName, nameName,param );
	}
}
