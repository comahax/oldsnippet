/**
* auto-generated code
* Wed Aug 15 12:25:59 CST 2012
*/
package com.sunrise.boss.business.cms.dcord.persistent;

import java.sql.PreparedStatement;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.impl.SessionImpl;

import com.sunrise.boss.business.cms.monitor.persistent.MonitorListVO;
import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.SessionUtil;

/**
 * <p>Title: DcordDAO</p>
 * <p>Description: Data Access Object for DcordVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class DcordDAO extends BaseLogDAO {

    /**
     * default constructor
     */
    public DcordDAO(){
        super(DcordVO.class);
    }
    
    public int doUpdateaccount(MonitorListVO params, String abatchno) throws Exception{
    	String countyid = params.get_countyid();
    	String rewardmonth = params.get_rewardmonth();
    	String upperopnid = params.get_upperopnid();
    	String lastdate2 = params.get_lastdate2();
    	String paymonth = params.get_paymonth();
    	StringBuilder sb = new StringBuilder();
    	sb.append("update ch_adt_dcord set abatchno=? ");
    	sb.append(" where condate<=to_date(?,'yyyy-mm-dd') and abatchno is null ");
    	if(countyid!=null && countyid.trim().length()!=0){
    		sb.append(" and countyid='"+countyid+"'");
    	}
    	if(rewardmonth!=null && rewardmonth.trim().length()!=0){
    		sb.append(" and rewardmonth='"+rewardmonth+"'");
    	}
    	if(upperopnid!=null && upperopnid.trim().length()!=0){
    		sb.append(" and upperopnid='"+upperopnid+"'");
    	}
    	if(paymonth!=null && paymonth.trim().length()!=0){
    		sb.append(" and paymonth='"+paymonth+"'");
    	}
    	PreparedStatement pstat = null;
    	try{
    		Session session = SessionUtil.currentSession(this.getDbFlag());        	
        	//pstat = session.connection().prepareStatement(sb.toString());
        	pstat =((SessionImpl)session).getBatcher().prepareStatement(sb.toString());
            pstat.setString(1, abatchno);
            pstat.setString(2, lastdate2);
            System.out.println("������䣺"+sb.toString());
            System.out.println("���κ�:"+abatchno);
            System.out.println("���ݽ�ֹȷ�����ڣ�"+lastdate2);
//            if(true){
//            	throw new Exception("�������");
//            }
            int result = pstat.executeUpdate();
            if(result>=0){
            	System.out.println("ȷ�ϳ��ʣ�����ch_adt_dcord��ɹ�����������"+result+"��");
            	session.flush();
            }               
            return result;
    	}finally{
    		if(pstat!=null){
    			pstat.close();
    		}
    	}
    	
    }
    

    /**
     * ���ݸ������κţ���ѯCH_ADT_DCORD���¼���޸Ķ�Ӧ���ݵ�isflag״ֵ̬
     * @param batchno
     * @return
     * @throws Exception
     */
	public int updateDcordIsflag(Short isflag, String batchno) throws Exception {
		PreparedStatement statement = null;
		try {
			Session session = SessionUtil.currentSession(getDbFlag());
			String SQL = "UPDATE CH_ADT_DCORD SET ISFLAG = ? WHERE BATCHNO = ?";
			statement = ((SessionImpl)session).getBatcher().prepareStatement(SQL);
			statement.setShort(1, isflag);
			statement.setString(2, batchno);
			int rows = statement.executeUpdate();
			session.flush();
			return rows;
		} catch (Exception e) {
			throw e;
		} finally {
			if (statement != null) {
				statement.close();
			}
		}
	}
}
