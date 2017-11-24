/**
* auto-generated code
* Wed Aug 16 16:27:53 CST 2006
*/
package com.sunrise.boss.business.fee.check.disputersn.persistent;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.SessionUtil;
import org.hibernate.Query;

/**
 * <p>Title: DisputeReasonDAO</p>
 * <p>Description: Data Access Object for DisputeReasonVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author liwenjing
 * @version 1.0
 */
public class DisputeReasonDAO extends BaseDAO {

    /**
     * default constructor
     */
    public DisputeReasonDAO(){
        super(DisputeReasonVO.class);
    }
    public List getAllUpperGrade(){
    	Session session = SessionUtil.currentSession(getDbFlag());
    	String hql="from DisputeReasonVO vo where vo.grade=0";
    	return session.createQuery(hql).list();
    }
    public List getGrade(int grade){
    	Session session = SessionUtil.currentSession(getDbFlag());
    	String hql="from DisputeReasonVO vo where vo.grade=:grade";
    	Query query = session.createQuery(hql);
    	query.setInteger("grade", grade);
    	return query.list();
    	
    }
    public List getLowByRsncode(String rsncode) {
    	Session session = SessionUtil.currentSession(getDbFlag());
    	String hql="from DisputeReasonVO vo where vo.rsnattach=:grade";
    	Query query = session.createQuery(hql);
    	query.setString("grade",rsncode);
    	return query.list();
    }
    public Object create(Object vo) throws Exception{
    	DisputeReasonVO voo=(DisputeReasonVO)vo;
    	if (voo.getGrade().intValue()==0){
    	super.create(vo);
    	voo.setRsnattach(voo.getRsncode().toString());
    	super.update(voo);
    	}
    	else{
    		super.create(vo);   		
        }
    	return vo;
    }
//    public DisputeReasonVO findByPk(Serializable pk){
//    	String rsncode=(String)pk;
//    	
//    	return null;
//    }
}
