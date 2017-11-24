package com.asisinfo.common.hibernate.transformer;

import java.lang.reflect.Field;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.HibernateException;
import org.hibernate.transform.ResultTransformer;

/**
 * ʵ�����ݿ�������pojo�����ת��
 * @author johnson_hong 2013-03-01
 * @see ResultTransformer
 */

public class PojoTransformer implements ResultTransformer {
	private static final long serialVersionUID = 1L;

	private Class resultClass;
	private Field[] fields;//Ŀ����������ֶ�
	
	private String[] resultFields;//Ŀ������ֶ�����

	public PojoTransformer(Class resultClass) {
		if (resultClass == null)
			throw new IllegalArgumentException("resultClass cannot be null");
		this.resultClass = resultClass;
		this.fields = resultClass.getDeclaredFields();
	}

	// ���ת��ʱ��HIBERNATE���ô˷���
	public Object transformTuple(Object[] tuple, String[] aliases) {
		Object result;

		try {
			if (resultFields == null) {// ���ȳ�ʼ����ȡ��Ŀ��POJO�������SETTER����
				resultFields = new String[aliases.length];
				for (int i = 0; i < aliases.length; i++) {
					String alias = aliases[i];
					if (alias != null) {
						//�����������Ҫ���õ���������
						resultFields[i] = getFieldNameByAlias(alias);
					}
				}
			}
			result = resultClass.newInstance();

			// ����ʹ��SETTER�������POJO����
			for (int i = 0; i < aliases.length; i++) {
				if (resultFields[i] != null&&tuple[i]!=null) {
						try {
							BeanUtils.copyProperty(result, resultFields[i], tuple[i]);
						} catch (Exception e) {
							throw new Exception("�޷���"+tuple[i]+"���õ�"+resultClass.getName()+"��"+resultFields[i]);
						} 
				}
			}
		} catch (Exception e) {
			throw new HibernateException("����ת��ΪĿ������: "
					+ resultClass.getName(),e);
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
		for (Field field : fields) {
			if (field.getName().toLowerCase().equals(proName)) {
				return field.getName();
			}
		}
		return null;
	}
	
	public List transformList(List collection) {
		return collection;
	}

}
