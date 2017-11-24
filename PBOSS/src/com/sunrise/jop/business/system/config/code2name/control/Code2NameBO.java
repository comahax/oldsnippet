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
	 * ת�����롣���ڵ����롣
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
	 * ת�����롣��Ҫ��groupid�жϷ��飬���������ֵ�ķ���
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
		
		if(groupid!=null) { //�����ֵ�
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
//	 * ��ȡĳ�����͵����б��롣
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
	 * ��ȡ�����ֵ�ĳ����Ŀ�����б��롣
	 * @param voName
	 * @param codeName
	 * @param nameName
	 * @param dbFlag
	 * @return
	 * @throws Exception
	 */
	public Map doValueList(String groupid, String codeName, String nameName, DBQueryParam param,String dbFlag) throws Exception {
		
		if(groupid!=null) { //�����ֵ�
			
			DataPackage dp =  doValueListPackage(groupid, codeName, nameName, param, dbFlag);			
			Map maplist = new LinkedHashMap(dp.getDatas().size());

//			//������ת��Ϊ map
			for(int i = 0 ; i < dp.getDatas().size() ; i++ ) {
				DictitemVO vo = (DictitemVO) dp.getDatas().get(i);
				maplist.put(vo.getDictid(), vo.getDictname());
			}
			
			return maplist;	
		}
		throw new JOPException("SYS-103","�����ֵ��ѯʱ groupCode ��ʧ��",null);
	}
	
	/**
	 * ����VOClass ��ȡ���б��룬�����б�
	 * @param voName
	 * @param codeName
	 * @param nameName
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public DataPackage doValueListPackage(String groupid, String codeName, String nameName, DBQueryParam param,String dbFlag) throws Exception {

		if(groupid!=null) { //�����ֵ�
			
			DictitemDBParam dictParam = new DictitemDBParam();
			
			BeanUtils.copyProperties(dictParam , param ); //���ⲿ���õ������Ž���
			
			dictParam.set_se_groupid(groupid); //�����ֶ������
			
			DataPackage dp =  doValueListPackage(DictitemVO.class, codeName, nameName, dictParam, dbFlag);
			
			return dp;
			
		}
		throw new JOPException("SYS-103","�����ֵ��ѯʱ groupCode ��ʧ��",null);
	}
	
	/**
	 * ����VOClass ��ȡ���б��룬�����б�. ���������ֵ�͵��������
	 */
	public DataPackage doValueListPackage(Class voClass, String codeName, String nameName, DBQueryParam param, String dbFlag) throws Exception {
		Code2NameDAO dao = getCode2NameDAO(voClass.getName(),dbFlag);
		return dao.valueListPackage(voClass, codeName, nameName,param );
	}
}
