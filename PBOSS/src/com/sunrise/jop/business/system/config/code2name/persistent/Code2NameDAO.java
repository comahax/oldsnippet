package com.sunrise.jop.business.system.config.code2name.persistent;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;

import com.sunrise.jop.common.persistent.CommonDAO;
import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.BaseDAO;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class Code2NameDAO extends AbstractDAO {
	
	public Code2NameDAO() {		
	}
	
	public Code2NameDAO(String dbFlag){
		setDbFlag(dbFlag);
	}

    public Object translateCode(String voName, String codeName,
			String nameName, Object codeValue) throws Exception {
    	String daoClassName = StringUtils.replace(voName, "VO", "DAO");
		Class daoClass = Class.forName(daoClassName);
		BaseDAO dao = DAOFactory.build(daoClass, getDbFlag());
		
		DBQueryParam param = new DBQueryParam();
		List fields = new ArrayList(2);
		fields.add(codeName);
		fields.add(nameName);
		param.setSelectFields(fields);
		
//		param.getQueryConditions().put(arg0, arg1); // codeValue��Ϊ����	
		Object returnValue = codeValue;
		
		Class voClass = Class.forName(voName);
		//��֤���������������ȷ��
		Object typerightCodeValue = convertValueAsPropertyType(voClass,codeName,codeValue);
		
		Object object =  dao.findByPk((Serializable)typerightCodeValue);
		if(object !=null){
			Object nameValue = PropertyUtils.getProperty(object, nameName);
			if(nameValue!=null)
				returnValue = nameValue;
		}
		return returnValue;
    }
//    
    /**
     * �÷�����BO�
     */
//	public Object translateCode(String voName,  String groupid,  String codeName,
//			String nameName, Object codeValue) throws Exception {		
////		
////		if(groupid!=null) { //�����ֵ�
////			DictItemDAO dao = (DictItemDAO) DAOFactory.build(DictItemDAO.class, getDbFlag());
////			
////			DictItemVO vo = new DictItemVO();
////			vo.setDictCode((Long)codeValue);
////			vo.setGroupCode(groupid);
////			DictItemVO vo2 = (DictItemVO) dao.findByPk(vo);
////			
////			if(vo2.getDictName()!=null)
////				return vo2.getDictName();
////		
////		}
//		return codeValue;
//		
//////		Session session = (Session)getSessionManager().currentSession();		
////		try {
////			// ��ѯ��䣺 select VO.name from voName as VO where VO.code=:code
////			StringBuffer hql = new StringBuffer("select VO.").append(nameName)
////					.append(" from ").append(voName).append(" as VO where VO.")
////					.append(codeName).append(" = :code");
////			
////			if(groupid!=null)
////				hql.append(" and VO.groupid ").append(" = :groupid");
////			
////			Query query = session.createQuery(hql.toString());
////			query.setParameter("code", codeValue);
////			if(groupid!=null)
////				query.setParameter("groupid", groupid);
////						
////			Iterator iter = query.iterate();
////			if (iter != null && iter.hasNext()) {
////				return iter.next();
////			} else {
////				return codeValue;
////			}
////
////		} catch (HibernateException ex) {
////			if (ex.getCause() != null) {
////				throw new Exception(ex.getCause());
////			} else {
////				throw ex;
////			}
////		}
//	}
	
	private Object convertValueAsPropertyType(Class voClass,String field, Object codeValue) throws Exception {
		Object obj = voClass.newInstance();
		PropertyDescriptor descriptor = PropertyUtils.getPropertyDescriptor(obj, field);
		Class pType = descriptor.getPropertyType();
		
		if(pType == String.class)
			return codeValue;
		else if( Long.class.isAssignableFrom(pType)) {
			return Long.valueOf(codeValue.toString());
			
		}else if( Integer.class.isAssignableFrom(pType)) {
			return Integer.valueOf(codeValue.toString());
			
		}else if( Short.class.isAssignableFrom(pType)) {
			return Short.valueOf(codeValue.toString());
			
		}else if( Byte.class.isAssignableFrom(pType)) {
			return Byte.valueOf(codeValue.toString());
		}
		
		throw new IllegalArgumentException("Unsupported type of condition field " + field + ".Require String, Long, Integer,Short,Byte type."  );
		
		//��ʱ������primitive���� pType.getName().equals("long") || pType.getName().equals("integer") || pType.getName().equals("byte") || pType.getName().equals("short"))
	}

//	public DataPackage valueListPackage(String voName, String codeName,
//			String nameName, DBQueryParam param ) throws Exception {
//		
//	}
	
	/**
	 * ��ȡ�����ֵ�б�ֻ��ȡ���룬���������ֶ�
	 */
//	public Map valueList(String voName, String codeName,String nameName ) throws Exception {		
//		return valueList(voName, codeName, null, nameName);
//	}
	


//	public Map valueList(String voName, String codeName, DBQueryParam param, String nameName) throws Exception {
////		Session session = (Session)getSessionManager().currentSession();
//		try {
////			String daoClassName = StringUtils.replace(voName, "VO", "DAO");
////			Class daoClass = Class.forName(daoClassName);
////			BaseDAO dao = DAOFactory.build(daoClass, getDbFlag());
////			
////			List fields = new ArrayList(2);
////			fields.add(codeName);
////			fields.add(nameName);
////			param.setSelectFields(fields);
////			param.setQueryAll(true); //��ѯ����
////			
////			//Class voClass = Class.forName(voName);
////			//��֤���������������ȷ��
////			//Object typerightCodeValue = convertValueAsPropertyType(voClass,codeName,codeValue);
//			
//			DataPackage dp = valueListPackage(voName, codeName, nameName, param);
//			
//			Map maplist = new LinkedHashMap(dp.getDatas().size());
//			
//			//������ת��Ϊ map
//			for(int i = 0 ; i < dp.getDatas().size() ; i++ ) {
//				Object vo = dp.getDatas().get(i);
//				
//			}
////			Object object =  dao.findByPk((Serializable)typerightCodeValue);
////			if(object !=null){
////				Object nameValue = PropertyUtils.getProperty(object, nameName);
////				if(nameValue!=null)
////					returnValue = nameValue;
////			}
////			return returnValue;
//			
//			// ��ѯ��䣺 select VO.name,VO.code from voName as VO 
////			StringBuffer hql = new StringBuffer("select VO.").append(nameName)
////					.append(",VO.").append(codeName).append(" from ").append(voName).append(" as VO ");
////			Query query = session.createQuery(hql.toString());			
//			
////			Iterator iter = query.iterate();
////			while (iter != null && iter.hasNext()) {
////				Object[] value = (Object[])iter.next();
////				if( value[1] != null && value[0] != null ){
////					maplist.put(value[1].toString(),value[0].toString());
////				}
////			}
//			return maplist;//maplist;
//		} catch (HibernateException ex) {
//			ex.printStackTrace();
//			if (ex.getCause() != null) {
//				throw new Exception(ex.getCause());
//			} else {
//				throw ex;
//			}
//		}
//	}
//	
	/**
	 * ����VOClass ��ȡ���б��룬�����б�
	 * @param voName
	 * @param codeName
	 * @param nameName
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public DataPackage valueListPackage(Class voClass, String codeName, String nameName, DBQueryParam param) throws Exception {		
		try {			
			BaseDAO dao = DAOFactory.buildCommonDAO(voClass, getDbFlag());		

			//���е�code2name����Ӧ�ò���field������ʽ
			//������Ϊ����fieldѡ����hibernate�ķ�����ƻ���Ϊȱ�ٹ�����,����ÿ��VO������Ӧ��code2nameר�Ź�����,Ӱ������
			//1.����VO������ר�ŵĹ�����
			//2.����˫��������������code2name������Ϊ��Ϊͬ����ʱ,���췽�������ν���Ҹ���
			//  ����: ˫���� dictid:String groupid:String   code2name dictid:String dictname:String 
			//	���޷�д������������,ֻ�ܸ�ԭ�еĹ�������Ӷ�һ����ν������,��Ҫд��һ��code2name�Ĺ�����
			//�������ε����´���,�����������Ǹ��ڴ�ʩ�Ӷ�һ��ѹ������,�����dictitem�����Ӵ�,�ֶβ��Ǻܶ�,Ӳ���㹻֧�ֵ������,ӦΪ�ȽϺõķ���,
			
//			List fields = new ArrayList(2);
//			fields.add(codeName);
//			fields.add(nameName);
//			param.setSelectFields(fields);
//			param.setQueryAll(false); //��ѯ����
			DataPackage dp = null;
			if(param.isQueryByNameSql()){
				dp = dao.queryByNamedSqlQuery(param.getNameSql(), param);
			}else {
				dp = dao.query(param);
			}
			
			return dp;
		} catch (HibernateException ex) {
			ex.printStackTrace();
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}
	}
}