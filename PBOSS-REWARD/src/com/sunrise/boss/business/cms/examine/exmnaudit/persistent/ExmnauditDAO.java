/**
* auto-generated code
* Sat Nov 28 17:57:55 CST 2009
*/
package com.sunrise.boss.business.cms.examine.exmnaudit.persistent;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: ExmnauditDAO</p>
 * <p>Description: Data Access Object for ExmnauditVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExmnauditDAO extends BaseLogDAO {

    /**
     * default constructor
     */
    public ExmnauditDAO(){
        super(ExmnauditVO.class);
    }
    /**
     * ���ݿ��˵Ǽ�ID����͵�ǰ���Ų�ѯ��֤�ܷ��ջ�
     * @param itemgradeds
     * @param oprcode
     * @return ���ܱ����յĿ��˵ǼǱ�ʶ����
     * @throws Exception
     */
    public List doValidateCallbackInfo(String[] itemgradeds,String oprcode,User user) throws Exception{
    	String values=formatIds(itemgradeds);
    	String sql = "select t.itemgradedid from CH_PW_EXMNAUDIT t  where t.presenter<>'"+oprcode+"' and t.state='0' and t.itemgradedid in('"+values+"') " +
    			" and t.submissiontime=(select max(e.submissiontime) from  CH_PW_EXMNAUDIT e where e.itemgradedid=t.itemgradedid and e.state='0')";
    	Session session = SessionUtil.currentSession(user.getCityid());
		Query query=session.createSQLQuery(sql).addScalar("itemgradedid", Hibernate.STRING);
		return query.list();
    }
    /**
     * ɾ�����յĿ�����Ϣ�����Ϣ
     * @param itemgradeds
     * @param oprcode
     * @throws Exception
     */
    public void removeCallbackInfo(String[] itemgradeds,String oprcode,User user) throws Exception{
    	String values=formatIds(itemgradeds);
    	String sql = "delete from CH_PW_EXMNAUDIT t where t.presenter='"+oprcode+"' and t.state='0' and t.itemgradedid in('"+values+"') " +
    	" and t.submissiontime=(select max(e.submissiontime) from  CH_PW_EXMNAUDIT e where e.itemgradedid=t.itemgradedid and t.state='0')";
    	Session session = SessionUtil.currentSession(user.getCityid());
			try{
				
				session.connection().createStatement().executeUpdate(sql);
			}catch(Exception e){
				e.printStackTrace();
				throw e;
			}
			
		
    }
   
    /**
	  * �������п��ύ�Ŀ��������ֱ�ʶ��Ϣ
	  */
	 public List doFindAllCallbackItemgradeds(User user)throws Exception{
	    	String sql = "select t.itemgradedid from CH_PW_EXMNAUDIT t  where t.presenter='"+user.getOpercode()+"' and t.state='0' " +
	    			" and t.submissiontime=(select max(e.submissiontime) from  CH_PW_EXMNAUDIT e where e.itemgradedid=t.itemgradedid and e.state='0' )";
	    	Session session = SessionUtil.currentSession(user.getCityid());
			Query query=session.createSQLQuery(sql).addScalar("itemgradedid", Hibernate.STRING);
			return query.list();
	 }
    private String formatIds(String[] strs){
    	String values="";
    	for(int i=0;i<strs.length;i++){
    		if("".equals(values))
    			values=strs[i];
    		else
    			values+="','"+strs[i];
    	}
    	return values;
    }
    /**
     * �������п��ύ������Ϣ��˵�ID����
     * @param registercode
     * @return
     * @throws Exception
     */
    public List doFindAllSubmitSeqid(String exmnperiod,String registercode,User user)throws Exception{
    	String sql = "select t.itemgradedid from CH_PW_EXMNAUDIT t inner join CH_PW_ITEMGRADED i on t.itemgradedid=i.seqid where t.state='1' and i.state='1' and i.exmnperiod='"+exmnperiod+"'"+
    	" and t.submissiontime=(select max(e.submissiontime) from  CH_PW_EXMNAUDIT e where e.itemgradedid=t.itemgradedid and t.state='1')";
    	if(registercode!=null)
    		sql+=" and t.auditor='"+registercode+"'";
    	Session session = SessionUtil.currentSession(user.getCityid());
		Query query=session.createSQLQuery(sql).addScalar("itemgradedid", Hibernate.STRING);
		return query.list();
    }
    /**
     * ��֤���������
     * @param itemgradeds
     * @param oprcode
     * @return 
     * @throws Exception
     */
    public List doValidateNewAuditor(String[] reqids,String[] itemgradeds ,User user) throws Exception{
    	String itemgradedValues=formatIds(itemgradeds);
    	String reqidValues=formatIds(reqids);
    	String sql = "select t.itemgradedid from CH_PW_EXMNAUDIT t  where t.state='1' and t.itemgradedid in('"+itemgradedValues+"')  and t.seqid in('"+reqidValues+"')" +
    			" and t.submissiontime=(select max(e.submissiontime) from  CH_PW_EXMNAUDIT e where e.itemgradedid=t.itemgradedid and e.state='1')";
    	Session session = SessionUtil.currentSession(user.getCityid());
		Query query=session.createSQLQuery(sql).addScalar("itemgradedid", Hibernate.STRING);
		return query.list();
    }
    /**
	  * �������пɻ��յĿ��������ֱ�ʶ��Ϣ
	  */
	 public List doFindAllCallbackItemgradeds(String oprcode,User user)throws Exception{
	    	String sql = "select t.itemgradedid from CH_PW_EXMNAUDIT t  where t.presenter='"+oprcode+"' and t.state='0' " +
	    			" and t.submissiontime=(select max(e.submissiontime) from  CH_PW_EXMNAUDIT e where e.itemgradedid=t.itemgradedid and e.state='0' )";
	    	Session session = SessionUtil.currentSession(user.getCityid());
			Query query=session.createSQLQuery(sql).addScalar("itemgradedid", Hibernate.STRING);
			return query.list();
	 }
	 /**
	     * �������п��ύ������Ϣ��˵�ID����
	     * @param registercode
	     * @return
	     * @throws Exception
	     */
	    public List doFindAllAuditSeqid(String exmnperiod,String registercode,User user)throws Exception{
	    	String sql = "select t.seqid from CH_PW_EXMNAUDIT t inner join CH_PW_ITEMGRADED i on t.itemgradedid=i.seqid where t.state='0' and i.exmnperiod='"+exmnperiod+"'";
	    	if(registercode!=null)
	    		sql+=" and t.auditor='"+registercode+"'";
	    	Session session = SessionUtil.currentSession(user.getCityid());
			Query query=session.createSQLQuery(sql).addScalar("seqid", Hibernate.STRING);
			return query.list();
	    }
}
