package com.asisinfo.common.hibernate.transformer;

import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.transform.ResultTransformer;

import com.asisinfo.common.model.DynamicBean;
import com.asisinfo.common.model.DynamicProperty;

public class DynamicBeanTransformer  implements ResultTransformer{
	private static final long serialVersionUID = 1L;
	
	private Map beanConfig;
	
	private String[] declaredFieldName;
	
	private String[] resultFields;//Ŀ������ֶ�����
	
	public DynamicBeanTransformer(Map<String,String> config){
		this.beanConfig = config;
		declaredFieldName = new String[config.size()];
		beanConfig.keySet().toArray(declaredFieldName);
	}

	public Object transformTuple(Object[] tuple, String[] aliases) {
		DynamicBean result = new DynamicBean(beanConfig);
		for(int i=0;i<declaredFieldName.length;i++){
			result.put(declaredFieldName[i], null);
		}

		try {
			if (resultFields == null) {
				resultFields = new String[aliases.length];
				for (int i = 0; i < aliases.length; i++) {
					String alias = aliases[i];
					if (alias != null) {
						//�����������Ҫ���õ���������
						resultFields[i] = getFieldNameByAlias(alias);
					}
				}
			}
			
			for (int i = 0; i < aliases.length; i++) {
				if (resultFields[i] != null&&tuple[i]!=null) {
					Object val = tuple[i];
					String toType = (String)beanConfig.get(resultFields[i]);
					try {
						if(toType!=null){
							val = DynamicProperty.convert(val, toType);
						}
						result.put(resultFields[i], val);
					} catch (Exception e) {
						throw new Exception("�޷���"+tuple[i]+"ת����"+resultFields[i]+":"+toType);
					} 
				}
			}
		} catch (Exception e) {
			throw new HibernateException("����ת��ΪDynamicBean,config="
					+ beanConfig,e);
		}

		return result;
	}

	// �������ݿ��ֶ�����POJO����JAVA�������������������ݿ��ֶ������磺USER_ID
	private String getFieldNameByAlias(String alias) {
		// ���ֶ��������е��¸�ȥ��
		String proName = alias.toLowerCase();
		String fieldName = null;
		fieldName = getFieldName(proName);//�Ȳ��������ֱ�Ӳ�������
		if(fieldName==null){//���Ҳ�����ȥ���»��߲���
			fieldName = getFieldName(proName.replaceAll("_", ""));
		}
		if(fieldName==null){//������ȥǰ׺���»��߲���
			if (proName.indexOf("_") > 0) {
				proName = proName.substring(proName.indexOf("_") + 1);
			}
			fieldName = getFieldName(proName.replaceAll("_", ""));
		}
		return fieldName;
	}

	private String getFieldName(String proName){
		for (String fieldName : declaredFieldName) {
			if (fieldName.toLowerCase().equals(proName)) {
				return fieldName;
			}
		}
		return null;
	}
	
	public List transformList(List collection) {
		return collection;
	}
}
