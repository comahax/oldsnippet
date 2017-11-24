package com.sunrise.boss.business.cms.common;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.business.cms.fdaudit.persistent.FdauditListVO;
import com.sunrise.boss.business.cms.fdaudit.persistent.FdauditVO;
import com.sunrise.boss.business.cms.fdauditdef.persistent.FdauditdefListVO;
import com.sunrise.boss.business.cms.fdauditdef.persistent.FdauditdefVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.delegate.admin.acl.ACLDelegate;
import com.sunrise.boss.delegate.cms.fdaudit.FdauditDelegate;
import com.sunrise.boss.delegate.cms.fdauditdef.FdauditdefDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.commons.User;

public class AuditUtils {

	public AuditUtils() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * ������Ҫ��˵�VO���б���
	 * 
	 * @param vo
	 *            ������ֶ�VO
	 * @param types
	 *            ��Ҫ��˵��ֶ���
	 * @param pk
	 *            ����
	 * @param user
	 *            �û�
	 * @param tablename
	 * @param controlid �������
	 * @return
	 * @throws Exception
	 */
	public Object doSaveAudit(Object vo, String tablename, String typename,
			String[] types, String[] pk, String controlid,User user) throws Exception {
		FdauditDelegate delegate = new FdauditDelegate();
		String[] newtype=doGetAudittype(tablename,typename,user);
		if(!this.doCheckPre(controlid, user)){
		for (int i = 0; i < newtype.length; i++) {
			if(StringUtils.isNotEmpty(newtype[i]) && !this.doCheckisNull(PropertyUtils.getProperty(vo, newtype[i]))){
			FdauditVO auditvo = new FdauditVO();
			auditvo.setTablename(tablename);
			auditvo.setTypename(typename);
			auditvo.setField(newtype[i]);
			auditvo
					.setFieldvalue(PropertyUtils.getProperty(vo, newtype[i]) == null ? ""
							: PropertyUtils.getProperty(vo, newtype[i])
									.toString());
			auditvo.setPkvalue(PropertyUtils.getProperty(vo, pk[0]).toString());
			if (pk.length > 1) {
				auditvo.setPkvalue2(PropertyUtils.getProperty(vo, pk[1])
						.toString());
			}
			auditvo.setOperid(user.getOpercode());
			auditvo.setOptime(new java.util.Date());
			auditvo.setAuditstatus(new Short("0"));
			delegate.doCreate(auditvo, user);
			PropertyUtils.setProperty(vo, newtype[i], null);
			}
		}
		}
		return vo;
	}
	
	private String[] doGetAudittype(String tablename,String typename,User user) throws Exception{
		FdauditdefDelegate def=new FdauditdefDelegate();
		FdauditdefListVO listvo=new FdauditdefListVO();
		listvo.set_se_tablename(tablename);
		listvo.set_se_typename(typename);
		listvo.set_ne_state(new Short("1"));
		listvo.set_pagesize("0");
		List list=(List)def.doQuery(listvo, user).getDatas();
		String[] result=new String[list.size()];
		int index=0;
		for(Iterator it=list.iterator();it.hasNext();){
			FdauditdefVO vo=(FdauditdefVO)it.next();
			result[index]=vo.getField();
			index++;
		}
		return result;
	}

	public Object doUpdateValue(Object vo, String tablename, String typename,
			String[] types, String[] pk, String controlid,User user) throws Exception {
		String[] newtype=doGetAudittype(tablename,typename,user);
		if(!this.doCheckPre(controlid, user)){
		Object orgvo=this.doGetorgVO(vo, user);//��ѯ���ݿ�ԭ��������
		if(orgvo==null){
			return vo;
		}
		Object tempvo=BeanUtils.cloneBean(orgvo);//����һ�����ݿ�ԭʼ����.
		BeanUtils.copyProperties(orgvo,vo);//�Գ־û��Ķ�����и���
		String[] types1=new String[20];
		for(int i=0;i<newtype.length;i++){
			BeanUtils.setProperty(vo, newtype[i],null);
		}
		vo=this.doGetAuditvalue(vo, tablename, typename, pk,true, user);//��δ��˵��ֶθ�ֵ��vo
		if(vo==null){//�ж��Ƿ�Ϊ��,�ж���˿����Ƿ���ֵ
			vo=tempvo;
		}
		int index=0;
		for (int i = 0; i < newtype.length; i++) {
			if (!ObjectUtils.equals(PropertyUtils.getProperty(vo, newtype[i]),PropertyUtils.getProperty(orgvo, newtype[i]))) {
				types1[index]=newtype[i];
				index++;
			}else if(!ObjectUtils.equals(PropertyUtils.getProperty(vo, newtype[i]),PropertyUtils.getProperty(tempvo, newtype[i]))){
				types1[index]=newtype[i];
				index++;
			}
		}
		this.doSaveAuditForupdate(orgvo, tablename, typename, types1, pk, controlid,user);
		for(int i=0;i<newtype.length;i++){//����Ҫ��˵�ֵ��Ϊԭ�����ݿ��е�ֵ
			PropertyUtils.setProperty(orgvo, newtype[i], PropertyUtils.getProperty(tempvo, newtype[i]));
		}
		return orgvo;
		}else{
			return vo;
		}
	}
	
	public Object doSaveAuditForupdate(Object vo, String tablename, String typename,
			String[] types, String[] pk, String controlid,User user) throws Exception {
		FdauditDelegate delegate = new FdauditDelegate();
		if(!this.doCheckPre(controlid, user)){
		for (int i = 0; i < types.length; i++) {
			if(StringUtils.isNotEmpty(types[i])){
			FdauditVO auditvo = new FdauditVO();
			auditvo.setTablename(tablename);
			auditvo.setTypename(typename);
			auditvo.setField(types[i]);
			auditvo
					.setFieldvalue(PropertyUtils.getProperty(vo, types[i]) == null ? ""
							: PropertyUtils.getProperty(vo, types[i])
									.toString());
			auditvo.setPkvalue(PropertyUtils.getProperty(vo, pk[0]).toString());
			if (pk.length > 1) {
				auditvo.setPkvalue2(PropertyUtils.getProperty(vo, pk[1])
						.toString());
			}
			auditvo.setOperid(user.getOpercode());
			auditvo.setOptime(new java.util.Date());
			auditvo.setAuditstatus(new Short("0"));
			delegate.doCreate(auditvo, user);
			}
		}
		}
		return vo;
	}

	public Object doGetAuditvalue(Object vo, String tablename, String typename,
			String[] pk, User user) throws Exception {
		if(vo==null){
			return null;
		}
		FdauditListVO listvo = new FdauditListVO();
		FdauditDelegate delegate = new FdauditDelegate();
		if(PropertyUtils.getProperty(vo, pk[0])!=null){
		listvo.set_se_tablename(tablename);
		listvo.set_se_typename(typename);
		listvo.set_se_pkvalue(PropertyUtils.getProperty(vo, pk[0]).toString());
		if (pk.length > 1) {
			listvo.set_se_pkvalue2(PropertyUtils.getProperty(vo, pk[1])
					.toString());
		}
		listvo.set_ne_auditstatus("0");//��ѯδ��˵ļ�¼
		listvo.set_orderby("optime");
		listvo.set_desc("1");
		listvo.set_pagesize("1000");
		DataPackage package1 = delegate.doQuery(listvo, user);
		if (package1.getDatas().size() > 0) {
			Set fild=new HashSet();
			//�����δ��˵ļ�¼������ʾʱ����������VO��ȥ
			for (int i = 0; i < (package1.getDatas().size()); i++) {
				FdauditVO tempvo = (FdauditVO) package1.getDatas().toArray()[i];
				if (fild.add(tempvo.getField())) {
					BeanUtils.copyProperty(vo, tempvo.getField(), tempvo.getFieldvalue());
				}
			}
		}
		}
		return vo;
	}
	
	private Object doGetAuditvalue(Object vo, String tablename, String typename,
			String[] pk, boolean ischeck,User user) throws Exception {
		if(vo==null){
			return null;
		}
		FdauditListVO listvo = new FdauditListVO();
		FdauditDelegate delegate = new FdauditDelegate();
		if(PropertyUtils.getProperty(vo, pk[0])!=null){
		listvo.set_se_tablename(tablename);
		listvo.set_se_typename(typename);
		listvo.set_se_pkvalue(PropertyUtils.getProperty(vo, pk[0]).toString());
		if (pk.length > 1) {
			listvo.set_se_pkvalue2(PropertyUtils.getProperty(vo, pk[1])
					.toString());
		}
		listvo.set_ne_auditstatus("0");//��ѯδ��˵ļ�¼
		listvo.set_orderby("optime");
		listvo.set_desc("1");
		listvo.set_pagesize("1000");
		DataPackage package1 = delegate.doQuery(listvo, user);
		if (package1.getDatas().size() > 0) {
			Set fild=new HashSet();
			for (int i = 0; i < (package1.getDatas().size()); i++) {
				FdauditVO tempvo = (FdauditVO) package1.getDatas().toArray()[i];
				if (fild.add(tempvo.getField())) {
					BeanUtils.copyProperty(vo, tempvo.getField(), tempvo.getFieldvalue());
				}
			}
		}else if(ischeck && !BaseActionForm.class.isAssignableFrom(vo.getClass())){//�����˿�����ֵ,�򷵻ؿ�
			return null;
		}
		}
		return vo;
	}
	
	//�ж��Ƿ���Ȩ��
	public boolean doCheckPre(String controlid,User user) throws Exception{
		ACLDelegate delegate=new ACLDelegate();
		return delegate.checkPermission(user.getOpercode(),controlid);
	}
	
	//�ж��Ƿ���Ȩ�� Ȩ��ID������ ||  ���� && ���Ӷ��
	public boolean havePurview(String controlid,User user) throws Exception{
		String[] ids; // controlIDs
		String flag; // ����־
		ACLDelegate delegate=new ACLDelegate();
		if (controlid != null) {
			if (controlid.indexOf("||") >= 0) {
				ids = controlid.split("\\|\\|");
				flag = "||";
			} else if (controlid.indexOf("&&") >= 0) {
				ids = controlid.split("\\&\\&");
				flag = "&&";
			} else {
				ids = new String[1];
				ids[0] = controlid;
				flag = null;
			}
			boolean[] bools = new boolean[ids.length]; // Ȩ��ֵ
			for (int i = 0; i < ids.length; ++i) {
				try {
					bools[i] = delegate.checkPermission(user.getOpercode(),
							ids[i].trim());
				} catch (Exception e) {
					e.printStackTrace();
					bools[i] = false;
				}
			}

			// �ϲ�����Ȩ��ֵ
			if ("||".equals(flag)) {
				boolean result = false;
				for (int i = 0; i < bools.length; ++i) {
					result = result || bools[i];
				}
				return result;
			} else if ("&&".equals(flag)) {
				boolean result = true;
				for (int i = 0; i < bools.length; ++i) {
					result = result && bools[i];
				}
				return result;
			} else {
				return bools[0];
			}

		} else {
			return false;
		}
	}
	
	public static String[] doCheckisNULL(String[] propertyname,String[] importvalue) throws Exception{
		String[] result=new String[importvalue.length];
		for(int i=0;i<propertyname.length;i++){
			if("null".equals(importvalue[i]) || "��".equals(importvalue[i])){
				result[i]=propertyname[i];
			}
		}
		return result;
	}
	public static void copyPropertiesSetNull(Object desc,Object orig,String[] propertyname,String[] importvalue) throws Exception{
		Map propertyMap=PropertyUtils.describe(orig);
		String[] setNull=doCheckisNULL(propertyname,importvalue);
		List list=Arrays.asList(setNull);
		Iterator iterator=propertyMap.keySet().iterator();
		while(iterator.hasNext()){
			String name=(String)iterator.next();
			Object value=propertyMap.get(name);
			if ("class".equals(name)) {
                continue; // No point in trying to set an object's class
            }
			if(contains(list,name)){
				org.apache.commons.beanutils.BeanUtils.copyProperty(desc, name, null);
				continue;
			}
			if(value==null || value.toString().length()==0){//��������ļ���ֵΪ��,�򲻴���
				continue;
			}
			org.apache.commons.beanutils.BeanUtils.copyProperty(desc, name, value);
			
		}
	}
	
	private static boolean contains(List list,String name) throws Exception{
		boolean result=false;
		for(Iterator it=list.iterator();it.hasNext();){
			if(name.equalsIgnoreCase((String)it.next())){
				result=true;
				break;
			}
		}
		return result;
	}
	
	//�ж��Ƿ�С��
	public static boolean doCheckDouble(String doublevalaue) {
		try{
			Double.parseDouble(doublevalaue);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	/*
	 * �жϵ���γ��
	 * @param decimal ���жϵ�ֵ
	 * @param length  С�����λ��
	 */
	public static boolean doCheckLatitude(String dicimal) throws Exception{
		try{
		if(dicimal.indexOf(".")==-1){
			return false;
		}else{
			if(dicimal.substring(dicimal.indexOf(".")+1, dicimal.length()).length()!=6)
			return false;
		}
		BigDecimal temp=new BigDecimal(dicimal);
		if(temp.doubleValue()<100 || temp.doubleValue()>130){
			return false;
		}
		}catch(NumberFormatException e){
			return false;
		}
		return true;
	}
	
	/*
	 * �жϵ�����
	 * @param decimal ���жϵ�ֵ
	 * @param length  С�����λ��
	 */
	public static boolean doCheckLongtitude(String dicimal) throws Exception{
		try{
		if(dicimal.indexOf(".")==-1){
			return false;
		}else{
			if(dicimal.substring(dicimal.indexOf(".")+1, dicimal.length()).length()!=6)
			return false;
		}
		BigDecimal temp=new BigDecimal(dicimal);
		if(temp.doubleValue()<18 || temp.doubleValue()>26){
			return false;
		}
		}catch(NumberFormatException e){
			return false;
		}
		return true;
	}
	
	public static boolean doCheckWayidStyle(String wayid) throws Exception{
		String path="^[a-zA-Z][a-zA-z0-9-]{0,18}$";
		Pattern pattern=Pattern.compile(path);
		Matcher matcher=pattern.matcher(wayid);
		if(matcher.find()){
			return true;
		}
			return false;
	}
	public boolean doCheckSystemParam(String groupid,String dictid,User user) throws Exception{
		DictitemVO vo=new DictitemVO();
		CommonDelegate dictitemDelegate = new CommonDelegate(DictitemVO.class);
		vo.setGroupid(groupid);
		vo.setDictid(dictid);
		vo = (DictitemVO) dictitemDelegate.doFindByPk(vo,user);
		if(vo==null){
			return false;
		}
			return true;
	}
	
	public Object doGetorgVO(Object vo,User user) throws Exception{
		FdauditDelegate delegate=new FdauditDelegate();
		return delegate.doGetorgVO(vo, user);
		
	}
	
	private boolean doCheckisNull(Object value) throws Exception{
		if(value instanceof String){
			return StringUtils.isEmpty((String)value);
		}else{
			return value==null;
		}
		
	}
	/**
	 * ��ȡ��ǰ��Ҫ��˵��ֶ�,����ǰ̨��ʾ.
	 * @param tablename
	 * @param typename
	 * @param user
	 * @return ��Ҫ��˵��ֶ���������
	 * @throws Exception
	 */
	public String doQueryFdauditStr(String tablename,String typename,User user) throws Exception{
		StringBuffer result=new StringBuffer("");
		FdauditdefListVO listvo=new FdauditdefListVO();
		listvo.set_se_tablename(tablename);
		listvo.set_se_typename(typename);
		listvo.set_ne_state(new Short("1"));
		listvo.set_pagesize("1000");
		FdauditdefDelegate delegate=new FdauditdefDelegate();
		List list=(List)delegate.doQuery(listvo, user).getDatas();
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				FdauditdefVO vo=(FdauditdefVO)list.get(i);
				if(i==0){
					result.append(vo.getFieldchname());
				}else{
					result.append(",").append(vo.getFieldchname());
				}
			}
		}
		return result.toString();
	}
}
