/**
 * auto-generated code
 * Wed Jul 28 14:21:59 CST 2010
 */
package com.gmcc.pboss.control.reward.rewardlocal;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.gmcc.pboss.business.reward.rewardlocal.RewardlocalDBParam;
import com.gmcc.pboss.business.reward.rewardlocal.RewardlocalDAO;
import com.gmcc.pboss.business.reward.rewardlocal.RewardlocalVO;
import com.gmcc.pboss.business.reward.rewardlocaltitle.RewardlocaltitleDBParam;
import com.gmcc.pboss.business.reward.rewardlocaltitle.RewardlocaltitleVO;
import com.gmcc.pboss.business.reward.rewardlocalvalue.RewardlocalvalueDBParam;
import com.gmcc.pboss.business.reward.rewardlocalvalue.RewardlocalvalueVO;
import com.gmcc.pboss.control.reward.rewardlocaltitle.Rewardlocaltitle;
import com.gmcc.pboss.control.reward.rewardlocaltitle.RewardlocaltitleBO;
import com.gmcc.pboss.control.reward.rewardlocalvalue.Rewardlocalvalue;
import com.gmcc.pboss.control.reward.rewardlocalvalue.RewardlocalvalueBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: RewardlocalBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class RewardlocalBO extends AbstractControlBean implements
		Rewardlocal {
	private Logger log = Logger.getLogger(RewardlocalBO.class);
	private Pattern pattern = Pattern.compile("^(\\(\\S+\\)-\\S+)$");
	
	public RewardlocalVO doCreate(RewardlocalVO vo) throws Exception {
		try {
			RewardlocalDAO dao = (RewardlocalDAO) DAOFactory.build(RewardlocalDAO.class, user);
			// TODO set the pk */
			return (RewardlocalVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(RewardlocalVO vo) throws Exception {
		try {
			RewardlocalDAO dao = (RewardlocalDAO) DAOFactory.build(RewardlocalDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			RewardlocalDAO dao = (RewardlocalDAO) DAOFactory.build(RewardlocalDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RewardlocalVO doUpdate(RewardlocalVO vo) throws Exception {
		try {
			RewardlocalDAO dao = (RewardlocalDAO) DAOFactory.build(RewardlocalDAO.class,user);
			return (RewardlocalVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RewardlocalVO doFindByPk(Serializable pk) throws Exception {
		RewardlocalDAO dao = (RewardlocalDAO) DAOFactory.build(RewardlocalDAO.class,user);
		return (RewardlocalVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(RewardlocalDBParam params)
			throws Exception {
		RewardlocalDAO dao = (RewardlocalDAO) DAOFactory.build(RewardlocalDAO.class,user);
		return dao.query(params);
	}
	
	public Object doGetSequence(String sequenceName) throws Exception{
		RewardlocalDAO dao = (RewardlocalDAO) DAOFactory.build(RewardlocalDAO.class,user);
		return dao.getSequence(sequenceName);
	}
	/**
     * ���س������ж� �߼� 
     * @param rewardmonth	�����·�
     * @param prttype		��������
     * @return ���ڣ�TRUREE ����FALSE
     */
    public boolean doIsExistReward(String rewardmonth,String prttype) throws Exception{
    	//���ݽ����·֣��������Ͳ�ѯ�������
    	Rewardlocal rewardlocalBO = (Rewardlocal)BOFactory.build(RewardlocalBO.class,user);
    	RewardlocalDBParam param1 = new RewardlocalDBParam();
    	param1.setCountOnly(true);
    	param1.set_se_rpttype(prttype);
    	param1.set_se_rewardmonth(rewardmonth);
    	DataPackage dp =  rewardlocalBO.doQuery(param1);
    	if(dp == null | dp.getRowCount() <=0 )
    		return false;
    	//���ݽ����·֣��������Ͳ�ѯ���Ƴ���ϸ��
    	Rewardlocaltitle rewardlocaltitleBO = (Rewardlocaltitle) BOFactory.build(RewardlocaltitleBO.class,user);
    	RewardlocaltitleDBParam param2 = new RewardlocaltitleDBParam();
    	param2.setCountOnly(true);
    	param2.set_se_rpttype(prttype);
    	param2.set_se_rewardmonth(rewardmonth);
    	dp = rewardlocaltitleBO.doQuery(param2);
    	if(dp == null | dp.getRowCount() <=0 )
    		return false;
    	return true;
    }
    
    
    /**
     * ���س��ɾ�� �߼� 
     * @param rewardmonth	�����·�
     * @param prttype		��������
     */
    public void doRemoveReward(String rewardmonth,String prttype) throws Exception{
    	Session session  = SessionUtils.currentSession(user.getCityid());
    	Connection conn = session.connection();
    	PreparedStatement stmt = null;
    	try{
    		//ɾ�������ϸֵ���ֵ��
    		String sql1 = "";
    		if( !"RPWDLocalRPT".equals(prttype)){
    			sql1 = "delete from CH_PW_REWARDLOCALVALUE v where v.mstid in " +
				"(select rewardid from CH_PW_REWARDLOCAL l where l.rewardmonth = ? and l.rpttype = ? )";
    		}else{
    			sql1 = "delete from CH_PW_REWARDLOCALDTL l where l.REWARDMONTH = ?  ";
    		}
    		log.info(sql1);
    		
        	stmt = conn.prepareStatement(sql1);
        	stmt.setString(1, rewardmonth);
        	if( !"RPWDLocalRPT".equals(prttype)){
        		stmt.setString(2, prttype);
        	}
        	stmt.executeUpdate();
        	//2)	ɾ�������
        	String sql2 = "delete from CH_PW_REWARDLOCALTITLE t where t.REWARDMONTH = ? and t.RPTTYPE = ? ";
        	log.info(sql2);
        	stmt = conn.prepareStatement(sql2);
        	stmt.setString(1, rewardmonth);
        	stmt.setString(2, prttype);
        	stmt.executeUpdate();    	
        	
        	//ɾ�����س������
        	String sql3 = "delete from CH_PW_REWARDLOCAL  t where t.REWARDMONTH = ? and t.RPTTYPE = ?";
        	log.info(sql3);
        	stmt = conn.prepareStatement(sql3);
        	stmt.setString(1, rewardmonth);
        	stmt.setString(2, prttype);
        	stmt.executeUpdate();
    	}catch(Exception e){
    		e.printStackTrace();
    		throw new JOPException("ɾ�����ر���ʧ��",e.getCause());
    	}finally{
    		if( null != stmt ){
    			try{
    				stmt.close();
    			}catch(Exception ex){
    				ex.printStackTrace();
    				LoggerUtils.error(ex, log);
    			}
    			
    		}
    	}
    }
    
    
    /**
	 * ��ӱ��س���ֶζ���
	 * @param rewardmonth ��������
	 * @param rpttype ��������
	 * @param items ��Ҫ��ӵ��ֶ���
	 */
	public int[] doAddRewardlocaltitle(String rewardmonth,String rpttype,String[] items) throws Exception{
		int[] result = new int[items.length];
		int seq = 1;
		String lastTitleXXX = null;//ǰһ�������XXX
		int lastTitleNumber = 0;
		int lastSubTitleNumber = 0;
		Rewardlocaltitle rewardlocaltitleBO = (Rewardlocaltitle) BOFactory.build(RewardlocaltitleBO.class,user);
		for(int i = 0;i<items.length;i++){
			result[i] = seq;
			RewardlocaltitleVO rewardlocaltitleVO = new RewardlocaltitleVO();
			rewardlocaltitleVO.setRewardmonth(rewardmonth);
			rewardlocaltitleVO.setRpttype(rpttype);
			rewardlocaltitleVO.setSeq(seq++);
			Matcher matcher = pattern.matcher(items[i].trim());
//			d)	�жϴ˱����Ƿ��ԡ�(XXX)-YYY��ģʽ���壬���ǣ���������ʽ��XXX��YYY��ȡ������
//			��XXX����ǰһ�������XXX����������ǰһ��������ͬ������������Ϊǰһ������Ķ��������+1��
//			��������Ϊǰһ������ı����+1����������Ÿ�ֵΪ1����XXX��ֵ�����������У�������������ΪYYY
			if(matcher.find()){
				String[] tempItems = StringUtils.splitPreserveAllTokens(items[i].trim(), "-");
				tempItems[0] = tempItems[0].replace("(", "").replace(")", "");
				if( tempItems[0].equals(lastTitleXXX)){
					rewardlocaltitleVO.setTitleno(lastTitleNumber);
					rewardlocaltitleVO.setSubno(++lastSubTitleNumber);
				}else{
					rewardlocaltitleVO.setTitleno(++lastTitleNumber);
					lastSubTitleNumber = 1;
					rewardlocaltitleVO.setSubno(lastSubTitleNumber);
				}
				rewardlocaltitleVO.setTitlename(tempItems[0]);
				rewardlocaltitleVO.setSubtitlename(tempItems[1]);
				lastTitleXXX = tempItems[0];								
			}else{
//				e)	�����ǡ�(XXX)-YYY��ģʽ��������Ϊǰһ������+1���ѵ�Ȼ�������Ƹ�ֵ������������
				rewardlocaltitleVO.setTitleno(++lastTitleNumber);
				rewardlocaltitleVO.setTitlename(items[i].trim());
			}
			rewardlocaltitleBO.doCreate(rewardlocaltitleVO);
		}
		return result;
	}

	/**
	 * ��ӳ����������
	 * @param rewardmonth ��������
	 * @param rpttype ��������
	 * @param items ������������[0]-[5]�������ֹ�˾����������������ţ�˫���֣����������루BOSS�����������ơ������Ǽ�
	 * @return ����������ID
	 */
	private long addRewardlocal(String rewardmonth,String rpttype,String[] items) throws Exception {
		if( null == items || items.length != 6)
			throw new Exception("�������ȷ");
		Rewardlocal rewardlocalBO = (Rewardlocal) BOFactory.build(RewardlocalBO.class,user);
		Object seqObj = rewardlocalBO.doGetSequence("CH_PW_REWARDLOCAL_SEQ");
		long seq = Long.parseLong(seqObj.toString());
		RewardlocalVO rewardlocalVO = new RewardlocalVO();
		rewardlocalVO.setRewardid(seq);
		rewardlocalVO.setRewardmonth(rewardmonth);
		rewardlocalVO.setRpttype(rpttype);
		rewardlocalVO.setCityname(items[0].trim());
		rewardlocalVO.setLocalname(items[1].trim());
		rewardlocalVO.setWayidCus(items[2]);
		rewardlocalVO.setWayid(items[3].trim());
		rewardlocalVO.setWayname(items[4].trim());
		rewardlocalVO.setStarlevel(items[5].trim().length() == 0? null:new Short(items[5].trim()));		
		rewardlocalBO.doCreate(rewardlocalVO);
		return seq;
	}
	
	/**
	 * ��ӳ�����ֵ
	 * @param rewardId ��������ʶ
	 * @param req	����������
	 * @param items �������ֵ
	 */
	private void addRewardlocalvalue(long rewardId,int[] req,String[] items) throws Exception{

		Rewardlocalvalue rewardlocalvalueBO = (Rewardlocalvalue) BOFactory.build(RewardlocalvalueBO.class,user);
		for(int i = 0;i<req.length && i<items.length;i++){
			RewardlocalvalueVO rewardlocalvalueVO = new RewardlocalvalueVO();
			rewardlocalvalueVO.setMstid(rewardId);
			rewardlocalvalueVO.setSeq(req[i]);
			String[] det = StringUtils.splitPreserveAllTokens(items[i], "#");
			if(det.length<=1){
				rewardlocalvalueVO.setContent(items[i]);
			}else{
				rewardlocalvalueVO.setContent(det[0]);
				rewardlocalvalueVO.setType(det[1]);
			}
			
			rewardlocalvalueBO.doCreate(rewardlocalvalueVO);
		}
		if(req.length>items.length){//��֤����������һ��
			for(int i = items.length;i<req.length ;i++){
				RewardlocalvalueVO rewardlocalvalueVO = new RewardlocalvalueVO();
				rewardlocalvalueVO.setMstid(rewardId);
				rewardlocalvalueVO.setSeq(req[i]);
				rewardlocalvalueVO.setContent(null);
				rewardlocalvalueBO.doCreate(rewardlocalvalueVO);
			}
		}
	}
	
	/**
	 * ��ӳ��(����ֵ��)����
	 * @param rewardmonth ��������
	 * @param rpttype ��������
	 * @param items 
	 * @param req ��ʶ���
	 */
	public void doAddRewardlocal(String rewardmonth,String rpttype,String[] items,int[] req) throws Exception {		
		try{
			if( null == items || items.length<6)
				throw new Exception(" ������Ȳ���ȷ");
			
			long rewardId = this.addRewardlocal(rewardmonth, rpttype, (String[])ArrayUtils.subarray(items,0,6));
			this.addRewardlocalvalue(rewardId, req, (String[])ArrayUtils.subarray(items,6,items.length));	
				
		}catch(Exception e){
			LoggerUtils.error(e, log);
			if( null != e.getCause())
				throw new JOPException(e.getMessage(),e.getCause());
			else 
				throw new JOPException(e);
		}
	}
}
