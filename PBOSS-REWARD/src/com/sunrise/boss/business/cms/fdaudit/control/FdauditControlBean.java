/**
* auto-generated code
* Thu Jul 26 16:12:39 CST 2007
*/
package com.sunrise.boss.business.cms.fdaudit.control;

import java.io.InputStream;
import java.io.Serializable;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.type.AbstractComponentType;
import org.hibernate.type.Type;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.admin.acl.control.ACLControl;
import com.sunrise.boss.business.admin.acl.control.ACLControlBean;
import com.sunrise.boss.business.cms.fdaudit.persistent.FdauditVO;
import com.sunrise.boss.business.cms.fdaudit.persistent.FdauditDAO;
import com.sunrise.boss.business.cms.fdaudit.persistent.FdauditListVO;
import com.sunrise.boss.business.cms.fdauditdef.persistent.FdauditdefVO;

/**
 * <p>Title: FdauditControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yuanweihai
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/fdaudit/control/FdauditControlBean"
 name="FdauditControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class FdauditControlBean extends AbstractControlBean
    implements FdauditControl {
	private static Properties p;
	private static Logger log = Logger.getRootLogger();
	
    public FdauditVO doCreate(FdauditVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         FdauditDAO dao = (FdauditDAO) DAOFactory.build(FdauditDAO.class, user);
            return (FdauditVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(FdauditVO vo, User user)
        throws Exception {
        try{
         FdauditDAO dao = (FdauditDAO) DAOFactory.build(FdauditDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public FdauditVO doUpdate(FdauditVO vo, User user)
        throws Exception {
        try{
         FdauditDAO dao = (FdauditDAO) DAOFactory.build(FdauditDAO.class, user);
            return (FdauditVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public FdauditVO doFindByPk(Serializable pk, User user)
        throws Exception {
         FdauditDAO dao = (FdauditDAO) DAOFactory.build(FdauditDAO.class, user);
        return (FdauditVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(FdauditListVO params, User user)
        throws Exception {
         FdauditDAO dao = (FdauditDAO) DAOFactory.build(FdauditDAO.class, user);
        return dao.query(params);
    }
    /**
     * 自营渠道管理，零售渠道管理等，相应的要设置字段审批令牌控制
     */
    public boolean businessPurview(String purview,User user)throws Exception{
    	ACLControl control = (ACLControl) ControlFactory.build(ACLControlBean.class);
		boolean permission = false;
		permission = control.checkPermission(user.getOpercode(), purview);
		if(log.isInfoEnabled()){
			log.info("====================oprcode:"+user.getOpercode()+";permission:"+permission+"==========================");
		}
    	return permission;
    }
    public boolean fieldBackfill(FdauditVO vo,FdauditdefVO fdauditdefvo,User user)throws Exception{
    	 FdauditDAO dao = (FdauditDAO) DAOFactory.build(FdauditDAO.class, user);
    	 dao.update(vo);
    	 return dao.fieldBackfill(fieldBackfillSQL(vo,fdauditdefvo,user));
    }
    private String fieldBackfillSQL(FdauditVO vo,FdauditdefVO fdauditdefvo,User user )throws Exception{
    	StringBuffer sql=new StringBuffer();
    	String tablename=vo.getTablename().trim();
    	String field=vo.getField().trim();
    	String fieldvalue=vo.getFieldvalue();
    	//Short fieldtype=fdauditdefvo.getFieldtype();

    	sql.append("UPDATE ");
    	sql.append(tablename);
    	sql.append(" SET ");
    	if(getSeparator(fieldvalue)==2){
    		sql.append(field+"=to_date('"+fieldvalue+"','yyyy-MM-dd')");
    	}else if(getSeparator(fieldvalue)==0){
    		sql.append(field+"="+fieldvalue);
    	}else{
    		sql.append(field+"='"+fieldvalue+"'");
    	}
    	sql.append(" WHERE ");
    	String pks[]=getPKs(tablename,user);
    	if(pks[0]!=null && !pks[0].equals("")){
    		sql.append(pks[0]+"='"+vo.getPkvalue()+"'");
    	}
    	if(pks.length>2){
    		if(pks[1]!=null && !pks[1].equals("")){
    			sql.append(" AND ");
    			sql.append(pks[1]+"='"+vo.getPkvalue2()+"'");
    		}
    	}

    	//System.out.println(sql.toString());
    	return sql.toString();
    	

    }
    /**
     * <option value="0" >数值型</option>
     * <option value="1" >字符型</option>
     * <option value="2" >日期型</option>
     * @param type
     * @return
     */
    private int getSeparator(String value){
    	int type=0;
    	NumberFormat myformat = NumberFormat.getInstance();     //数字格式化
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");    //时间格式化
    	try{
    		myformat.parse(value);
    		return type;
    	}catch(ParseException pe){
    		type=2;
    	}
    	try{
    		df.parse(value);
    		return type;
    	}catch(ParseException pe){
    		type=1;
    	}
    	return type;
    }
    

	private String[] getPKs(String tablename,User user) throws Exception {
		if(p==null){
			p=new Properties();
			InputStream is = FdauditControlBean.class.getResourceAsStream("fdaudit.properties");
			p.load(is);
			is.close();
		}
		String voclass=p.getProperty(tablename);
		if(voclass==null || voclass.equals("")){
			throw new Exception("请配置表"+tablename+"的VO");
		}
		Session session = SessionUtil.currentSession(user.getCityid());
		ClassMetadata metadata = session.getSessionFactory().getClassMetadata(voclass);
		Type type =  metadata.getIdentifierType();    	
	
		String[] pkNames = null;
		if( !(type instanceof AbstractComponentType)) {
			String pkName = metadata.getIdentifierPropertyName();	
			pkNames = new String[1];
			pkNames[0] = pkName;
		
		}else {
			AbstractComponentType aType = (AbstractComponentType)type;        	
			pkNames = aType.getPropertyNames();
		}
		return pkNames;
	}
	public Object doGetorgVO(Object vo, User user) throws Exception {
		FdauditDAO dao = (FdauditDAO) DAOFactory.build(FdauditDAO.class, user);
		return dao.doGetorgVO(vo, user);
	}
}
