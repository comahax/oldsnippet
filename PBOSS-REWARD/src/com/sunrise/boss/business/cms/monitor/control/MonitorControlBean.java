/**
* auto-generated code
* Tue Aug 21 08:42:57 CST 2012
*/
package com.sunrise.boss.business.cms.monitor.control;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.dcord.persistent.DcordDAO;
import com.sunrise.boss.business.cms.monitor.persistent.MonitorVO;
import com.sunrise.boss.business.cms.monitor.persistent.MonitorDAO;
import com.sunrise.boss.business.cms.monitor.persistent.MonitorListVO;

/**
 * <p>Title: MonitorControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/monitor/control/MonitorControlBean"
 name="MonitorControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class MonitorControlBean extends AbstractControlBean
    implements MonitorControl {

    public MonitorVO doCreate(MonitorVO vo, User user)
        throws Exception {
        try{
			MonitorDAO dao = (MonitorDAO) DAOFactory.build(MonitorDAO.class, user);
            // TODO  set the pk */
            return (MonitorVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(MonitorVO vo, User user)
        throws Exception {
        try{
			MonitorDAO dao = (MonitorDAO) DAOFactory.build(MonitorDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public MonitorVO doUpdate(MonitorVO vo, User user)
        throws Exception {
        try{
			MonitorDAO dao = (MonitorDAO) DAOFactory.build(MonitorDAO.class, user);
            return (MonitorVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public MonitorVO doFindByPk(Serializable pk, User user)
        throws Exception {
			MonitorDAO dao = (MonitorDAO) DAOFactory.build(MonitorDAO.class, user);
        return (MonitorVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(MonitorListVO params, User user)
        throws Exception {
			MonitorDAO dao = (MonitorDAO) DAOFactory.build(MonitorDAO.class, user);
        return dao.query(params);
    }
    
    public String doCreateaccount(MonitorListVO params, User user)throws Exception{
    	try{
    		String retinfo = "";
        	MonitorDAO dao = (MonitorDAO)DAOFactory.build(MonitorDAO.class, user);
        	DcordDAO ddao = (DcordDAO)DAOFactory.build(DcordDAO.class, user);
        	MonitorVO vo = new MonitorVO();
        	String abatchno = null;
        	
        	try{//�������κ�
        		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            	String month = sdf.format(new Date());
            	String city = SessionFactoryRouter.conversionCityid(user.getCityid());//���б�ʶ�ַ�
            	Long sequence = (Long)ddao.getSequence("CH_ADT_MONITOR_ABATCHNO_SEQ");
            	if((sequence%1000)==0){//����λΪ000,ȡ��һ��ֵ
            		sequence = (Long)ddao.getSequence("CH_ADT_MONITOR_ABATCHNO_SEQ");
            	}
            	String reportseq = sequence.toString();
            	reportseq = reportseq.substring(reportseq.length()-3);
            	abatchno = "CCZ" + city + month + reportseq;
            	System.out.println("���ɳ������κ�:"+abatchno);
        	}catch(Exception ex){
        		ex.printStackTrace();
        		throw new Exception("�������κ�ʧ�ܣ�ԭ��"+ex.getMessage());
        	}  
        	
        	String countyid = params.get_countyid();
        	String rewardmonth = params.get_rewardmonth();
        	String upperopnid = params.get_upperopnid();
        	String lastdate2 = params.get_lastdate2();
        	String paymonth = params.get_paymonth();
        	
        	int result = -1;
        	try{//������ϸ����
        		result = ddao.doUpdateaccount(params, abatchno);
        	}catch(Exception ex){
        		throw new Exception("ȷ�ϳ���ʧ�ܣ����³�����������ϸ������ʧ��");
        	}
        	 
        	if(result>0){//������ϸ���ݳɹ��������������μ�¼
        		vo.setAbatchno(abatchno);
            	vo.setRewardmonth(rewardmonth);
            	vo.setCountyid(countyid);
            	vo.setUpperopnid(upperopnid);
            	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            	vo.setLastdate(sdf.parse(lastdate2));
            	vo.setStatus((short)2);
            	vo.setCityid(Short.valueOf(user.getCityid()));
            	vo.setConoprcode(user.getOpercode());
            	vo.setConoptime(new Date());
            	vo.setPaymonth(paymonth);
            	dao.create(vo);
            	retinfo = "ȷ�ϳ��˳ɹ������κ�:"+abatchno;
        	}else if(result==0){//������0����ϸ����
        		retinfo="���ݳ����������޳�����ϸ���ݣ����ܳ���";
        	}        	
        	return retinfo;
    	}catch(Exception ex){
    		ex.printStackTrace();
    		sessionContext.setRollbackOnly();
    		throw new Exception("����ȷ���쳣,���Ժ�����!"+ex.getMessage());
    	}    	
    }
}
